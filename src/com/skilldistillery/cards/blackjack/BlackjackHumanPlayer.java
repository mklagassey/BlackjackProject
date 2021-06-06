package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Player;

public class BlackjackHumanPlayer extends Player{
	
	BlackjackHand hand = new BlackjackHand();

	public void addCardToHand(Card card) {
		this.hand.addCard(card);
	}
	
	@Override
	public void showCards() {
		// TODO Auto-generated method stub
		System.out.println("Your cards: ");
		hand.showHand(0, hand.getHandSize());
	}
	
	@Override
	public void showScore() {
		System.out.println("Your score: " + hand.getHandValue());
	}
	
	public int getScore() {
		return hand.getHandValue();
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		
	}



}
