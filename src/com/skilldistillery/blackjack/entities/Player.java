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

	@Override
	public void displayHand() {
		System.out.println(this.getClass().getSimpleName() + "'s " + hand + " is currently at " + getHandValue() + " points.");
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

}
