package com.example.demo.BlackJack_2.model;

import java.util.ArrayList;
import java.util.List;

public class AutoPlayer {
    private int autoPlayersum;
    private Deck deck;
    private ArrayList<Cards> hands = new ArrayList<Cards>();

    public AutoPlayer(Deck shareDeck) {
        this.deck = shareDeck;

    }

    public List<Cards> getHands() {
        return hands;
    }

    public ArrayList<Cards> firstTwoCards(){

        hands.clear();
        autoPlayersum = 0;
        hands.add(deck.dealerGetsCard());
        hands.add(deck.dealerGetsCard());

        for (Cards values : hands) {
            autoPlayersum += values.getValue();
        }

        return hands;

    }

    public List<Cards> drawCard() throws InterruptedException {
        if (autoPlayersum < 12) {
            Cards newcCards = deck.dealerGetsCard();
            hands.add(newcCards);
            autoPlayersum += newcCards.getValue();

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
