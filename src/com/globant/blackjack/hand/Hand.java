package com.globant.blackjack.hand;

import com.globant.blackjack.card.Card;

public interface Hand {

	int size();
	void addCard(Card card);
	int getValue();
	void flipCards();

}