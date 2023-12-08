package com.skilldistillery.blackjack.entities;

public interface BlackjackActions {
	
	void receiveCard(Card card);
	void displayHand();
	public int getHandValue();
	public boolean didBust();
	public boolean gotBlackjack();
}
