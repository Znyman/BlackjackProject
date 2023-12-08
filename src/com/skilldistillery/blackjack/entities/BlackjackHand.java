package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	public BlackjackHand() {}

	@Override
	public int getHandValue() {
		int sum = 0;
		for (Card card : cards) {
			sum += card.getValue();
		}
		return sum;
	}
	
	public boolean isBlackjack() {
		return getHandValue() == 21;
	}
	
	public boolean isBust() {
		return getHandValue() > 21;
	}
}
