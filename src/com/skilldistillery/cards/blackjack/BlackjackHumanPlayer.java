package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Player;

public class BlackjackHumanPlayer extends Player{
	Scanner kb = new Scanner(System.in);
	private String name = "Player";
	private BlackjackHand hand = new BlackjackHand();
	private boolean busted = false;

	public void addCardToHand(Card card) {
		this.hand.addCard(card);
	}
	
	public void resetHand() {
		this.hand = new BlackjackHand();
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
		System.out.println("<----------------------------------->");
	}
	
	public int getScore() {
		return hand.getHandValue();
	}

	@Override
	public boolean quitOrPlay() {
		boolean answer = false;
		String input;
		System.out.println("Do you want to play again? (Y/N)");
		input = kb.nextLine().toLowerCase();
		if (input.startsWith("y")) {
			answer = true;
		}
		return answer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		return builder.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isBusted() {
		return busted;
	}

	public void setBusted(boolean busted) {
		this.busted = busted;
	}

	


}
