package com.example.demo.BlackJack_2.model;

import java.util.List;

public class GameState {
	public int playerPoints;
	public int dealerPoints;
	public boolean gameOver;
	public String result;
	public List<String> playerHandList;
	public List<String> dealerHandList;
	public List<String> autoPlayerHandList;
	public int accumulationPlayer;
	public int accumulationDealer;
	public String  cheatMessage;

	public GameState(int playerPoints, int dealerPoints, boolean gameOver, String result,
			List<String>playerHandList, List<String> dealerHandList, int accumulationPlayer,
					 int accumulationDealer, List<String> autoPlayerHandList, String  cheatMessage) {
		this.playerPoints = playerPoints;
		this.dealerPoints = dealerPoints;
		this.gameOver = gameOver;
		this.result = result;
		this.playerHandList = playerHandList;
		this.dealerHandList = dealerHandList;
		this.autoPlayerHandList = autoPlayerHandList;
		this.accumulationPlayer = accumulationPlayer;
		this.accumulationDealer = accumulationDealer;
		this.cheatMessage = cheatMessage;
	}
	
	public GameState() {// for JSON Serialization
		
	}

}
