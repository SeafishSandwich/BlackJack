package com.example.demo.BlackJack_2.model;

import java.util.ArrayList;

public class Cheater {
	private ArrayList<Integer> cheaterDeck;

	public  Cheater() {
		this.cheaterDeck = new ArrayList<Integer>();
		for (int i = 2; i <= 10; i++) {
			for (int m = 0; m < 4; m++) {
				cheaterDeck.add(i);
			}
		}
		for (int j = 0; j < 12; j++) {
			cheaterDeck.add(10);
		}
		for (int k = 0; k < 4; k++) {
			cheaterDeck.add(11);
		}
	}

	public ArrayList<Integer> getCheaterDeck() {
		return cheaterDeck;
	}
	
	
}
