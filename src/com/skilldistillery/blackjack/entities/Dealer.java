package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	
	private Deck deck;
	
	public Dealer() {
		deck = new Deck();
		deck.shuffle();
	}
	
	public void dealCardToPlayer(Player player) {
		player.receiveCard(deck.dealCard());
		player.displayHand();
	}
	
	public Card dealCardToSelf() {
		Card newCard = deck.dealCard();
		receiveCard(newCard);
		return newCard;
	}
}
