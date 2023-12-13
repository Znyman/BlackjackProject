package com.skilldistillery.blackjack.entities;

public class Player implements BlackjackActions {

	private Hand hand;

	public Player() {
		hand = new BlackjackHand();
	}

	@Override
	public void receiveCard(Card card) {
		hand.addCard(card);
	}

	public boolean takeTurn(String hitOrStand) {
		switch (hitOrStand.toLowerCase()) {
		case "hit":
			return true;
		case "stand":
			System.out.println("You have ended your turn. It is now the dealer's turn.");
			return false;
		default:
			return false;
		}
	}

	@Override
	public void displayHand() {
		System.out.println(
				this.getClass().getSimpleName() + "'s " + hand + " is currently at " + getHandValue() + " points.");
	}

	@Override
	public int getHandValue() {
		return hand.getHandValue();
	}

	@Override
	public boolean didBust() {
		return ((BlackjackHand) hand).isBust();

	}

	@Override
	public boolean gotBlackjack() {
		return ((BlackjackHand) hand).isBlackjack();
	}

	@Override
	public void resetHand() {
		hand = new BlackjackHand();
	}
}
