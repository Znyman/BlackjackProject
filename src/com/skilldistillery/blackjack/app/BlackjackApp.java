package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	private Player player = new Player();
	private Dealer dealer = new Dealer();
	private Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {

		BlackjackApp app = new BlackjackApp();
		app.run();
	}

	public void run() {
		String keepPlaying = "";
		do {
			dealInitialHands();
			if (!player.gotBlackjack()) {
				playersTurn();
				dealer.takeTurn();
			} else {
				System.out.println("You got blackjack! Now the dealer will reveal their cards and determine a winner.");
				dealer.displayHand();
			}
			determineWinner();
			
			System.out.print("Would you like to play again? 'yes' or 'no' ");
			keepPlaying = keyboard.nextLine();
			
			if (keepPlaying.equalsIgnoreCase("yes")) {
				player.resetHand();
				dealer.resetHand();
			}
			
		} while (keepPlaying.equalsIgnoreCase("yes"));
		
		System.out.println("Thanks for playing! Goodbye.");
		
	}

	private void dealInitialHands() {
		dealer.dealCardToPlayer(player);
		dealer.dealCardToSelf();
		System.out.println("Dealer's Hand [Face Down Card]");
		dealer.dealCardToPlayer(player);
		System.out.println("Dealer's Hand [Face Down Card, " + dealer.dealCardToSelf() + "]");
	}

	private void playersTurn() {
		boolean keepHitting = true;
		while (keepHitting) {
			if (player.didBust()) {
				System.out.println("You busted. Now it is the dealer's turn.");
				keepHitting = false;
			} else if (player.gotBlackjack()) {
				System.out.println("You got Blackjack! It's now the dealer's turn.");
				keepHitting = false;
			} else {
				System.out.print("Would you like to 'hit' or 'stand'? ");
				String hitOrStand = keyboard.nextLine();
				if (!hitOrStand.equals("hit") && !hitOrStand.equals("stand")) {
					System.out.println("Input not recognized.");
					continue;
				}
				keepHitting = player.takeTurn(hitOrStand);
				if (keepHitting) {
					dealer.dealCardToPlayer(player);
				}
			}
		}
	}

	public void determineWinner() {
		if (player.gotBlackjack() && dealer.gotBlackjack()) {
			System.out.println("The game is considered a standoff because both you and the dealer got Blackjack.");
		} else if (player.gotBlackjack() && !dealer.gotBlackjack()) {
			System.out.println("You won because you got Blackjack and the dealer didn't!");
		} else if (!player.gotBlackjack() && dealer.gotBlackjack()) {
			System.out.println("The dealer won because they got Blackjack and you didn't.");
		} else if (player.didBust() && dealer.didBust()) {
			System.out.println("There was no winner because both you and the dealer busted.");
		} else if (!player.didBust() && dealer.didBust()) {
			System.out.println("You won because the dealer busted and you didn't!");
		} else if (player.didBust() && !dealer.didBust()) {
			System.out.println("The dealer won because you busted and they didn't.");
		} else if (player.getHandValue() == dealer.getHandValue()) {
			System.out.println("The game is considered a standoff because both you and the dealer got the same points.");
		} else if (player.getHandValue() > dealer.getHandValue()) {
			System.out.println("You won because you were closer to Blackjack than the dealer was.");
		} else if (player.getHandValue() < dealer.getHandValue()) {
			System.out.println("The dealer won because they were closer to Blackjack than you were.");
		}
	}

}
