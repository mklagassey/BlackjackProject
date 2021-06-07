package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Player;

public class BlackjackDealer extends Player {

	Scanner input = new Scanner(System.in);
	private BlackjackHand hand = new BlackjackHand();
	private boolean hideFirstCard = true;
	private String name = "Dealer";
	private boolean busted = false;

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
			System.out.println("<----------------------------------->");

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
				System.out.println("Here's your card...");
				break;
			} else if (first == 's' || first == 'S') {
				hit = false;
			} else {
				System.out.println("Sorry, I didn't understand that.\n" + "Please choose hit (h) or stay (s)");
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

	public void resetHand() {
		this.hand = new BlackjackHand();
	}

	@Override
	public boolean quitOrPlay() {
		// TODO Auto-generated method stub
		return false;
	}

}
