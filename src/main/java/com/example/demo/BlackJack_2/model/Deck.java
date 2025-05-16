package com.example.demo.BlackJack_2.model;

import java.util.ArrayList;
import java.util.Random;


public class Deck {
	private Cards cards;
	private ArrayList<Cards> deck;
	private Cheater cheater;
	
	public Deck() {
		this.deck = new ArrayList<Cards>();
		this.cheater = new Cheater();
		//featureLists
		String[]  suits = {"♠", "♦" ,"♥","♣"};
		String[] faces = {"2","3","4","5","6","7","8","9","10","J","Q","K","Ace"};
		Integer[] values = {2,3,4,5,6,7,8,9,10,10,10,10,11};
		
		for(String suit: suits) {
			for (int i = 0; i < faces.length; i++) {
			cards = new Cards(suit, faces[i], values[i]);
			deck.add(cards);
			}
		}
	}

	public Cards getCard() {
		Random random = new Random();
		int i = random.nextInt(deck.size());
		Cards draw = deck.get(i);
		deck.remove(i);
		//remove value from cheaterDeck
		if (draw.getFace().equals("Ace")) {
			cheater.getCheaterDeck().remove(11);
		}else {
			cheater.getCheaterDeck().remove(draw.getValue());
		}
		
		if (draw.getFace().equals("Ace")) {
			draw = new Cards(draw.getSuit(), draw.getFace(), 11);
		}
		return draw;
	}
	
	public Cards dealerGetsCard() {
		Random random = new Random();
		int i = random.nextInt(deck.size());
		Cards draw = deck.remove(i);
		
		//remove value from cheaterDeck
				if (draw.getFace().equals("Ace")) {
					cheater.getCheaterDeck().remove(11);
				}else {
					cheater.getCheaterDeck().remove(draw.getValue());
				}
		
		if (draw.getFace().equals("Ace")) {
			int decisionKey = random.nextInt(2);
			if (decisionKey == 0) {
				draw = new Cards(draw.getSuit(), draw.getFace(), 1);
			}else {
				draw = new Cards(draw.getSuit(), draw.getFace(), 11);
			}

		}
		//debug
//		System.out.println(deck);
		return draw;
	}
	public ArrayList<Cards> getDeck() {
		return deck;
	}
}
