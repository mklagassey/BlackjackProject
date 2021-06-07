package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Player;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp casino = new BlackjackApp();
		casino.play();
	}

	private void play() {
		Scanner scan = new Scanner(System.in);
		// TODO - make table its own class
		List<Player> table = new ArrayList<Player>();
		BlackjackHumanPlayer human = new BlackjackHumanPlayer();
		BlackjackDealer dealer = new BlackjackDealer();
		boolean keepPlaying = true;
		{
			table.add(human);
			table.add(dealer);
		}

		System.out.println("Welcome to Wild West Blackjack!\n"
				+ "What's your name slim?");
		human.setName(scan.nextLine());
		System.out.println("Alright " + human.getName() + ", let's play!");
		

		do {
			boolean hit = true;
			boolean playerBust = false;
			boolean blackjack = false;
			Deck playDeck = new Deck();
			for (Player player : table) {
				player.resetHand();
			}
			dealer.setHideFirstCard(true);


			// Dealer shuffles deck if not already shuffled
			if (playDeck.isShuffled() == false) {
				dealer.shuffleDeck(playDeck);
				try {
					System.out.println("Dealer is shuffling deck: ");
					for (int i = 0; i < 5; i++) {
						System.err.print("♥");
						Thread.sleep(50);
						System.err.println("♦");
						Thread.sleep(50);
						System.out.print("♣");
						Thread.sleep(50);
						System.out.println("♠");
						Thread.sleep(50);						
					}
				} catch (InterruptedException e) {

				}
			}
			// Dealer deals 2 cards to each player
			for (int i = 0; i < 2; i++) {
				for (Player player : table) {
					dealer.dealCard(playDeck, player);				
				}
			}
		
			// Each player hand is displayed with all cards up
			for (Player player : table) {
				player.showCards();
				player.showScore();
				// checks for blackjack
				if (player.getScore() == 21) {
					System.out.println("BLACKJACK, " + player.getName() + " WINS!");
					blackjack = true;
					break;
				}
				// Required for double hard aces,
				// TODO remove when soft ace is available
				if (player.getScore() > 21) {
					System.out.println(player.getName() +" busted!");
					playerBust = true;
					break;
				}
			}
			
			if (!playerBust && !blackjack) {
					
				while (hit) {
					hit = dealer.askPlayerHitOrStay(playDeck, human);
					human.showCards();
					human.showScore();
					// check for bust
					if (human.getScore() > 21) {
						System.out.println("Busted, you lose!\n"
								+ "Sorry " + human.getName() + ", better luck next time.");
						playerBust = true;
						break;
					}
				}
				
				if (!playerBust && !blackjack) {
						
					dealer.checkHandToHit(playDeck, dealer);
					dealer.showCards();
					dealer.showScore();
				
					if (dealer.getScore() > 21) {
						System.out.println("Dealer busted, you win!");
						break;
						}
		
					else if (dealer.getScore() > human.getScore()) {
						System.out.println("You lose, dealer wins with " + dealer.getScore());
					} else if (dealer.getScore() == human.getScore()) {
						System.out.println("Draw game, no winner.");
					} else {
						System.out.println("You win! Your " + human.getScore() + 
								" beats the dealers " + dealer.getScore());
					}
				
				}
			}
			
			keepPlaying = human.quitOrPlay();
			
		} while (keepPlaying);
		System.out.println("Thanks for playing pardner, come back real soon!");
		scan.close();
	}

}

