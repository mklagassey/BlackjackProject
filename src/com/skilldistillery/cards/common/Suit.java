package com.skilldistillery.cards.common;

public enum Suit {
	
	HEARTS("♥"), SPADES("♠"), CLUBS("♣"), DIAMONDS("♦");
	
	private String name;
	
	Suit(String suit) {
		name = suit;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
