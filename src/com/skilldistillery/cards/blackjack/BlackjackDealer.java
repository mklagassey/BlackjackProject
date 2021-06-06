package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Player;

public class BlackjackDealer extends Player {

	Scanner input = new Scanner(System.in);
	private BlackjackHand hand = new BlackjackHand();
	private boolean hideFirstCard = true;

	public BlackjackDealer() {

	}

	public void shuffleDeck(Deck deck) {
		deck.shuffle();
	}

	public void dealCard(Deck deck, Player player) {
		Card dealt = deck.dealCard();
		player.addCardToHand(dealt);
	}

	@Override
	public void addCardToHand(Card card) {
		this.hand.addCard(card);
	}

	@Override
	public void showCards() {
		System.out.println("Dealers cards: ");
		if (hideFirstCard) {
			System.out.println("Hidden card");
			hand.showHand(1, hand.getHandSize());
		} else {
			hand.showHand(0, hand.getHandSize());
			;
		}
	}

	@Override
	public void showScore() {
		if (hideFirstCard) {
			System.out.println("Dealers score: ???");
		} else {
			System.out.println("Dealers score: " + hand.getHandValue());
		}
	}

	public int getScore() {
		return hand.getHandValue();
	}

	public boolean askPlayerHitOrStay(Deck deck, Player player) {
		String playerInput;
		boolean hit = true;

		System.out.println("Would you like to hit or stay?");
		do {
			playerInput = input.nextLine();
			char first = playerInput.charAt(0);
			if (first == 'h' || first == 'H') {
				this.dealCard(deck, player);
				System.out.println("Here is your card...");
				break;
			} else if (first == 's' || first == 'S') {
				hit = false;
			} else {
				System.out.println("Sorry, I didn't understand that." 
			+ "Please choose hit (h) or stay (s)");
				continue;
			}
		} while (hit);
		return hit;
	}

	public void checkHandToHit(Deck deck, Player dealer) {
		while (hand.getHandValue() < 17) {
			dealCard(deck, dealer);
			;
			System.out.println("Dealer hits.");

		}
		hideFirstCard = false;
	}

	public void setHideFirstCard(Boolean show) {
		hideFirstCard = show;
	}

	public void returnCardsToDeck() {
		// TODO Auto-generated method stub

	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub

	}

}
