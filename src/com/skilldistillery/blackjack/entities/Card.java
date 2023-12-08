package com.skilldistillery.blackjack.entities;

import java.util.Objects;

public class Card {
	
	Suit suit;
	Rank rank;
	
	public Card(Suit suit, Rank rank) {
		setSuit(suit);
		setRank(rank);
	}

	public int getValue() {
		return rank.getValue();
	}
	
	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Card))
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}

	@Override
	public String toString() {
		return getRank() + " of " + getSuit();
	}
	
	
}
