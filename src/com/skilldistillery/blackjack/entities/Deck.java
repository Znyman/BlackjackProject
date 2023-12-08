package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	List<Card> deck;
	
	public Deck() {
		deck = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(suit, rank));
			}
		}
	}
	
	public int cardsLeftInDeck() {
		return deck.size();
	}
	
	public Card dealCard() {
		return deck.remove(deck.size() - 1);
	}
	
	public void dealCard(Hand hand) {
		hand.addCard(dealCard());
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
}
