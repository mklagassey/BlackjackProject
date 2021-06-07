package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> hand = new ArrayList<>();

	// Hand values would be calculated differently depending on the rules of the game
	// and should be determined by the sub-class
	public abstract int getHandValue();

	public void addCard(Card card) {
		hand.add(card);
	}

	public List<Card> fold() {
		return hand;
	}
	
	public int getHandSize() {
		return hand.size();
	}
		
	public void showHand(int begin, int end) {
		String line = "*";
		ArrayList<String> vizcard = new ArrayList<>();
		for (int i = begin; i < end; i++) {
			vizcard = hand.get(i).toArray();
			for (String string : vizcard) {
				line += string;
			}
		}
		System.out.println(line);
	}
	
}
