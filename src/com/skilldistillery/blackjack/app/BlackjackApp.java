package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	Player player = new Player();
	Dealer dealer = new Dealer();
	Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {

		BlackjackApp app = new BlackjackApp();
		app.run();
	}

	// No instances of any other objects other than player and dealer (good
	// encapsulation)
	public void run() {
		
		dealInitialHands();
		if (!player.gotBlackjack()) {
			playersTurn();
			dealersTurn();
			determineWinner();
		} else {
			System.out.println("You got blackjack! Now the dealer will reveal their cards and determine a winner.");
			determineWinner();
		}
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
			System.out.print("Would you like to hit or stand? ");
			String hitOrStand = keyboard.nextLine();
			switch (hitOrStand.toLowerCase()) {
			case "hit":
				dealer.dealCardToPlayer(player);
				if (player.didBust()) {
					System.out.println("You busted. Now it is the dealer's turn.");
					return;
				}
				break;
			case "stand":
				System.out.println("You have ended your turn. It is now the dealer's turn.");
				keepHitting = false;
				break;
			default:
				System.out.println("Input not recognized. Please enter 'hit' or 'stand'");
				break;
			}
		}
	}
	
	private void dealersTurn() {
		dealer.displayHand();
		boolean keepHitting = dealer.getHandValue() < 17;
		while (keepHitting) {
			System.out.println("Dealer hits.");
			dealer.dealCardToSelf();
			dealer.displayHand();
			keepHitting = dealer.getHandValue() < 17;
		}
	}
	
	public void determineWinner() {
		if (player.didBust() && dealer.didBust()) {
			System.out.println("There was no winner because both you and the dealer busted.");
		} else if (!player.didBust() && dealer.didBust()) {
			System.out.println("You won because the dealer busted and you didn't!");
		} else if (player.didBust() && !dealer.didBust()) {
			System.out.println("The dealer won because you busted and they didn't.");
		} else if (player.gotBlackjack() && dealer.gotBlackjack()) {
			System.out.println("The game is considered a standoff because both you and the dealer got Blackjack.");
		} else if (player.gotBlackjack() && !dealer.gotBlackjack()) {
			System.out.println("You won because you got Blackjack and the dealer didn't!");
		} else if (!player.gotBlackjack() && dealer.gotBlackjack()) {
			System.out.println("The dealer won because they got Blackjack and you didn't.");
		} else if (player.getHandValue() == dealer.getHandValue()) {
			System.out.println("The game is considered a standoff because both you and the dealer got the same points.");
		} else if (player.getHandValue() > dealer.getHandValue()) {
			System.out.println("You won because you were closer to Blackjack than the dealer was.");
		} else if (player.getHandValue() < dealer.getHandValue()) {
			System.out.println("The dealer won because they were closer to Blackjack than you were.");
		}
	}

}
