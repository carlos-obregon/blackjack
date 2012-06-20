package com.globant.blackjack.deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.globant.blackjack.card.Card;

public class DeckTests {

	private Deck deck;

	@Before
	public void setup() {
		deck = new SimpleDeck();
	}

	@Test
	public void deckCreation() {
		final int SIZE_OF_NEWLY_CREATED_DECK = 52;
		assertEquals(SIZE_OF_NEWLY_CREATED_DECK, deck.size());
	}

	@Test
	public void givenACardADeckHasOneCardLess() {
		final int SIZE_OF_A_DECK_AFTER_GIVEN_A_CARD = 51;
		deck.giveCard();
		assertEquals(SIZE_OF_A_DECK_AFTER_GIVEN_A_CARD, deck.size());
	}

	@Test
	public void deckCanProvideAnInvisibleCard() {
		Card card = deck.giveCard(false);
		assertTrue(!card.isVisible());
	}

}
