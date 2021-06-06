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

			// Dealer shuffles deck if not already shuffled
			if (playDeck.isShuffled() == false) {
				dealer.shuffleDeck(playDeck);
			}
			// Dealer deals 1 card to each player
			for (Player player : table) {
				dealer.dealCard(playDeck, player);
			}
			// and second card
			for (Player player : table) {
				dealer.dealCard(playDeck, player);
			}
			// Each player hand is displayed with all cards up
			for (Player player : table) {
				player.showCards();
				player.showScore();
				// checks for blackjack
				if (player.getScore() == 21) {
					System.out.println("BLACKJACK, " + player.toString() + " WINS!");
					break;
				}
				if (player.getScore() > 21) {
					System.out.println(player.toString() +" busted!");
					break;
				}
			}
			// Checks for bust
			// Dealer asks each player if they want to hit or stay
			// TODO - put in loop, break when player stays or busts
			boolean hit = true;
			boolean playerBust = false;
			
			while (hit) {
				hit = dealer.askPlayerHitOrStay(playDeck, human);
				human.showCards();
				human.showScore();
				// check for bust
				if (human.getScore() > 21) {
					System.out.println("Busted, you lose!");
					playerBust = true;
					break;
				}
			}
			// Dealers turn to hit or stay
			// TODO put inside loop, break when dealer stays or busts
			if (!playerBust) {
				
			dealer.checkHandToHit(playDeck, dealer);
			dealer.showCards();
			dealer.showScore();
		
			if (dealer.getScore() > 21) {
				System.out.println("Dealer busted, you win!");
				break;
				}
			
			// If no win condition yet, compare each player hand to dealer, winner = high score
			// TODO include all players
			else if (dealer.getScore() > human.getScore()) {
				System.out.println("You lose, dealer wins with " + dealer.getScore());
			} else {
				System.out.println("You win! Your " + human.getScore() + 
						" beats the dealers " + dealer.getScore());
			}
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
