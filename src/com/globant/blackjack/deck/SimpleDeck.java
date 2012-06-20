package com.globant.blackjack.deck;

import java.util.ArrayList;
import java.util.Collections;

import com.globant.blackjack.card.BlackjackCard;
import com.globant.blackjack.card.Rank;
import com.globant.blackjack.card.Suit;

public class SimpleDeck extends BaseDeck implements Deck {

	public SimpleDeck() {
		final int TOTAL_CARDS_ON_A_DECK = 52;
		deck = new ArrayList<>(TOTAL_CARDS_ON_A_DECK);
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				deck.add(new BlackjackCard(rank, suit));
			}
		}
		Collections.shuffle(deck);
	}

}
