package com.skilldistillery.cards.common;

import java.util.Collection;

public abstract class Player {
	
	protected Collection<Card> hand;
	
	
	
	public Player() {
	}

	public Player(Collection<Card> hand) {
		super();
		this.hand = hand;
	}
	
	public abstract void addCardToHand(Card card);
	
	public abstract void showCards();
	
	public abstract void showScore();

	public abstract void play();
	
	public abstract void quit();
	
	
}
