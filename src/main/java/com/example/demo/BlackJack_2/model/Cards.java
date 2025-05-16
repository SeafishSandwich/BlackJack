package com.example.demo.BlackJack_2.model;

public class Cards {
	private String suit;
	private String face;
	private int value;
	
	
	public String getSuit() {
		return suit;
	}


	public String getFace() {
		return face;
	}


	public int getValue() {
		return value;
	}


	public Cards(String suit, String face, int value) {
		this.suit = suit;
		this.face = face;
		this.value =value;
	}
	@Override
	public String toString() {
		return suit+face;
	}


}
