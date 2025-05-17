package com.example.demo.BlackJack_2.model;

import java.util.List;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope

public class GameSession {
	private Deck sharedDeck;
	private Cheater cheater;
	private Dealer dealer;
	private Player player;
	private AutoPlayer autoPlayer;
	private boolean gameOver;
	private int accumulationPlayer;
	private int accumulationDealer;
	private String cheatMessage;
	private double cheatMessageD;

	public int getAccumulationPlayer(){
		return accumulationPlayer;
	}

	public int getAccumulationDealer(){
		return accumulationDealer;
	}
	
	public void startGame() throws InterruptedException {
		sharedDeck = new Deck();
		cheater = new Cheater();
		dealer = new Dealer(sharedDeck);
		player = new Player(sharedDeck);
		autoPlayer = new AutoPlayer(sharedDeck);
		gameOver = false;
		
		try {
			player.firstTwoCards();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dealer.firstTwoCards();
		autoPlayer.firstTwoCards();

		
	}

	public GameState hit() {
		
		if (gameOver) {
			return getState();
		}
		
		try {
			player.drawCard();
			autoPlayer.drawCard();
			String result = player.judgeResults();
			if (result.contains("BUST") || result.contains("BLACKJACK")){
				gameOver = true;
			}else{
				gameOver = false;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return getState();
		
	}
	
	public GameState stand() throws InterruptedException {
		gameOver = true;
		dealer.drawCard();

		int playerSum = player.getSumPoints();
		int dealerSum = dealer.getDealerSum();

		if (playerSum == dealerSum && dealerSum < 21 || playerSum == 21 && dealerSum ==21) {
			// no change
		} else if (dealerSum == 21){
			accumulationDealer += 1;
		} else if (playerSum> dealerSum && playerSum <21 )  {
			accumulationPlayer += 1;
		} else if (playerSum == 21) {
			accumulationPlayer += 2;
		} else if (dealerSum > 21 && playerSum < 21) {
			accumulationPlayer += 1;
			accumulationDealer -= 1;
		} else if (playerSum > 21) {
			accumulationPlayer -= 1;
			accumulationDealer += 1;
		}

		return getState();
	}
	
	public GameState Cheat() {
		List<Integer> cheaterDeck = cheater.getCheaterDeck();
		int playerValue = player.getSumPoints();
		int dealerValue = dealer.getDealerSum();
		int valueNotBust = 21 - playerValue;
		int valueDealerBust = 21 - dealerValue;
		
		double bustRate = 0.0;

		if(valueNotBust > 11) {
			cheatMessage = "Just Draw";
		}else {
			int count = 0;
			for (int values: cheaterDeck) {
				if(values > valueNotBust) {
					count+=1;
				}
			}
			bustRate = (double) count / cheaterDeck.size();
		}
		int countD = 0;
		for (int values: cheaterDeck) {
			if (values > valueDealerBust) {
				countD += 1;
			}
		}
		cheatMessageD = (double) countD / cheaterDeck.size();
		cheatMessage = Double.toString(bustRate);


		return getState();	
		
	}
	
	public GameState getState() {
		int playerSum = player.getSumPoints();
		int dealerSum = dealer.getDealerSum();
		String result = null;
		
		if (playerSum == dealerSum && dealerSum < 21 || playerSum == 21 && dealerSum ==21) {
			result = "平手";
		} else if (playerSum < dealerSum&& dealerSum<= 21 ) {
			result =  "你输了";
		} else if (playerSum> dealerSum && playerSum <21 ) {
			result = "你赢了！";
		} else if(playerSum == 21 && dealerSum != 21){
			result = "BlackJack! 你赢了！";
		} else if (dealerSum > 21 && playerSum < 21) {
			result = "庄家爆牌！你赢了！" ;
		} else if(playerSum >21) {
			result = "你爆牌了！你输了";
		}else {
			result = "写代码的忘了考虑这种情况orz";
		}
		
		return new GameState(player.getSumPoints(),dealer.getDealerSum(), gameOver, result,
				player.getHandStrings(), dealer.getHandStrings(), accumulationPlayer, accumulationDealer, autoPlayer.getHandStrings(), cheatMessage, cheatMessageD);
	}
	
	
}
