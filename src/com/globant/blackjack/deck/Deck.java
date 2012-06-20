package com.globant.blackjack.deck;

import com.globant.blackjack.card.Card;

public interface Deck {

	Card giveCard();
	Card giveCard(boolean visible);
	int size();

}
