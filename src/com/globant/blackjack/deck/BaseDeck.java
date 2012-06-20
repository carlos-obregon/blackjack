package com.globant.blackjack.deck;

import java.util.List;

import com.globant.blackjack.card.Card;

public abstract class BaseDeck implements Deck {

	protected List<Card> deck;

	@Override
	public Card giveCard() {
		 return giveCard(true);
	}

	@Override
	public Card giveCard(boolean visible) {
		Card card = deck.remove(deck.size() - 1);
		card.setVisible(visible);
		return card;
	}

	@Override
	public int size() {
		return deck.size();
	}

}
