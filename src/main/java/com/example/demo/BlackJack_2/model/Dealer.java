package com.example.demo.BlackJack_2.model;

import java.util.ArrayList;
import java.util.List;

public class Dealer{
	private int dealerSum;
	private Deck deck;
	private ArrayList<Cards> hands = new ArrayList<Cards>();

	public int getDealerSum() {
		return dealerSum;
	}
	
	public Dealer(Deck shareDeck) {
		this.deck = shareDeck;
		
	}

	public List<Cards> getHands() {
		return hands;
	}
	
	public ArrayList<Cards> firstTwoCards(){
		
		hands.clear();
		dealerSum = 0;
		hands.add(deck.dealerGetsCard());
		hands.add(deck.dealerGetsCard());

		for (Cards values : hands) {
			dealerSum += values.getValue();
		}

		return hands;

	}
	
	public List<Cards> drawCard() throws InterruptedException {
		while (dealerSum < 17) {
			Cards newcCards = deck.dealerGetsCard();
			hands.add(newcCards);
			dealerSum += newcCards.getValue();
			
	}
		return hands;
	}

	public List<String> getHandStrings() {
		List<String> handList = new ArrayList<String>();
		for (Cards card : hands) {
			handList.add(card.toString());
		}
		return handList;
	}
	

}
