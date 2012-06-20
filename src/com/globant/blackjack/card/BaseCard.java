package com.globant.blackjack.card;

public abstract class BaseCard implements Card {

	protected Rank rank;
	protected Suit suit;
	protected boolean visible;

	public BaseCard(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
		visible = true;
	}

	public BaseCard(Card card) {
		this.rank = card.getRank();
		this.suit = card.getSuit();
		this.visible = card.isVisible();
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String toString() {
		return visible ? rank.toString() + suit.toString() : "**";
	}

	public int getValue() {
		return rank.getValue();
	}

}
