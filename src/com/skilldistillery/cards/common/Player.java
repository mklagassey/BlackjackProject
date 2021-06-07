package com.skilldistillery.cards.common;

import java.util.Collection;

public abstract class Player {
	
	protected Collection<Card> hand;
	protected String name;
	
	
	
	public Player() {
	}

	public Player(Collection<Card> hand) {
		super();
		this.hand = hand;
	}
	
	public abstract void addCardToHand(Card card);
	
	public abstract void showCards();
	
	public abstract void showScore();

	public abstract int getScore();
	
	public abstract boolean quitOrPlay();

	public abstract String getName();

	public abstract void setName(String name);

	public abstract void resetHand();
	
	
}
