package com.example.demo.BlackJack_2.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private int sumPoints;
	private Deck deck;
	private ArrayList<Cards> hands = new ArrayList<Cards>();

	public Player(Deck shareDeck) {
		this.deck = shareDeck;
	}

	public int getSumPoints() {
		int total = 0;
		int aceCount = 0;

		for (Cards card : hands) {
			total += card.getValue();
			if (card.getFace().equals("Ace")) aceCount++;
		}

		while (total > 21 && aceCount > 0) {
			total -= 10;
			aceCount--;

		}
		sumPoints = total;
		return sumPoints;
	}

	public List<Cards> getHands() {
		return hands;
	}


	public ArrayList<Cards> firstTwoCards() throws InterruptedException {
		hands.clear();
		sumPoints = 0;
		hands.add(deck.getCard());
		hands.add(deck.getCard());

		for (Cards values : hands) {
			sumPoints += values.getValue();
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

	public Cards drawCard() throws InterruptedException {
		Cards newcCards = deck.getCard();
		hands.add(newcCards);
		sumPoints += newcCards.getValue();
		return newcCards;
	}

	public String judgeResults() {
		getSumPoints();
		if (sumPoints < 21) {
			return "NORMAL";
		} else if (sumPoints == 21) {
			return "BLACKJACK";
		} else{
			return "BUST";
		}
	}


}