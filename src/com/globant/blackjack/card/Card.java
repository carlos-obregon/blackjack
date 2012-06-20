package com.globant.blackjack.card;

public interface Card {

	Rank getRank();
	Suit getSuit();
	boolean isVisible();
	void setVisible(boolean visible);
	int getValue();

}
