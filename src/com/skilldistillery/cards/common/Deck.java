package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private boolean shuffled = false;
	private List<Card> deck;

	// Where the magic happens
	public Deck() {
		this.deck = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {	
				deck.add(new Card(suit, rank));
			}
		}
	}
	
	public boolean isShuffled() {
		return shuffled;
	}

	public void setShuffled(boolean status) {
		this.shuffled = status;
	}

	public int checkDeckSize() {
		if (deck == null) {
			return -1;
		}
		return deck.size();
	}
	
	public Card dealCard() {
		if (deck == null) {
		System.out.println("No deck!");
		return null;
		}
		return deck.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
		setShuffled(true);
	}
}
