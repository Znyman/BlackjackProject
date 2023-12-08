package com.skilldistillery.blackjack.entities;

public enum Suit {
	
	HEARTS("Hearts"),
	SPADES("Spades"),
	CLUBS("Clubs"),
	DIAMONS("Diamonds");

	final private String name;
	
	Suit(String suit) {
		name = suit;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
