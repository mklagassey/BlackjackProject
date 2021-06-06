package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Player;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp casino = new BlackjackApp();
		// Create a deck to play with
		Deck deck = new Deck();
		casino.play(deck);
	}

	private void play(Deck playDeck) {
		Scanner scan = new Scanner(System.in);
		List<Player> table = new ArrayList<Player>();
		BlackjackHumanPlayer human = new BlackjackHumanPlayer();
		BlackjackDealer dealer = new BlackjackDealer();
		int amtOfCards;
		boolean keepPlaying = true;
		String answer;

		{
			table.add(human);
			table.add(dealer);
		}

		System.out.println("Welcome to Blackjack!");

		while (keepPlaying) {
//			List<Card> hand = new ArrayList<>();
//			System.out.println("How many cards do you want?");

			// Dealer shuffles deck if not already shuffled
			if (playDeck.isShuffled() == false) {
				dealer.shuffleDeck(playDeck);
			}
			// Dealer deals 1 card to each player
			for (Player player : table) {
				dealer.dealCard(playDeck, player);
			}
			
			// Dealer deals 1 card to itself, displayed (down)
			// Dealer deals 1 card to each player, hands showing are updated
			// Dealer deals 1 card to itself, displayed up
			// Dealer deals 1 card to each player
			for (Player player : table) {
				dealer.dealCard(playDeck, player);
			}
			// Each player hand is displayed with all cards up
			for (Player player : table) {
				player.showCards();
				player.showScore();
			}
			if (human.getScore() == 21) {
				System.out.println("BLACKJACK, YOU WIN!");
				break;
			} else if (human.getScore() > 21) {
				System.out.println("Busted, you lose!");
			}
			// Dealer asks each player if they want to hit or stay
			dealer.askPlayerHitOrStay(playDeck, human);
			human.showCards();
			human.showScore();
			if (human.getScore() == 21) {
				System.out.println("BLACKJACK, YOU WIN!");
				break;
			} else if (human.getScore() > 21) {
				System.out.println("Busted, you lose!");
			}
			// Dealers turn to hit or stay
			dealer.checkHandToHit(playDeck, dealer);
			if (dealer.getScore() == 21) {
				System.out.println("BLACKJACK, dealer wins!");
				break;
			} else if (dealer.getScore() > 21) {
				System.out.println("Dealer busted, you win!");
			}
			dealer.showCards();
			dealer.showScore();
			
			// If no win condition yet, compare each player hand to dealer, winner = high score
			if (dealer.getScore() > human.getScore()) {
				System.out.println("You lose, dealer wins with " + dealer.getScore());
			} else {
				System.out.println("You win! Your " + human.getScore() + 
						" beats the dealers " + dealer.getScore());
			}
			try {
				System.out.println();
//				amtOfCards = scan.nextInt();
//				if (amtOfCards > playDeck.checkDeckSize()) {
//					System.out.println("Sorry, please choose a number less than " + playDeck.checkDeckSize());
//					continue;
//				} else {
//					playDeck.shuffle();
//					for (int i = 0; i < amtOfCards; i++) {
//						hand.add(playDeck.dealCard());
//
//					}
//					for (Card card : hand) {
//						System.out.println(card);
//					}
//				}

			} catch (Exception e) {
				System.out.println("Error: Please enter choose either hit (h) or stay (s)");
			} finally {
				if (playDeck.checkDeckSize() < 1) {
					System.out.println("All out of cards!");
					break;
				}
				System.out.println("Try again?");
				scan.nextLine();
				answer = scan.nextLine();

				if (answer.contains("n") || answer.contains("N")) {
					keepPlaying = false;
				}

			}
		}
		scan.close();
	}

}
