package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	protected List<Card> cards;

	public Hand() {
		cards = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void clear() {
		//TODO Clarify what this method is supposed to do
	}

	public abstract int getHandValue();

	@Override
	public String toString() {
		return "Hand [" + cards + "]";
	}
	
	
}
