package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> hand = new ArrayList<>();

	public void addCard(Card card) {
		
	}
	
	public int getHandValue() {
		int value = 0;
		
		for (Card card : hand) {
			value += card.getValue();
		}
		return value;
	}
	
	public void fold() {
		
	}
	
	public void showHand() {
		
	}
}
