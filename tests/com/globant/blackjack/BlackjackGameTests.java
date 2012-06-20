package com.globant.blackjack;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.globant.blackjack.card.BlackjackCard;
import com.globant.blackjack.card.Rank;
import com.globant.blackjack.card.Suit;
import com.globant.blackjack.deck.Deck;

public class BlackjackGameTests {

	private Deck deck;
	private BlackjackGame game;

	@Before
	public void setup() {
		deck = mock(Deck.class);
		when(deck.giveCard())
			.thenReturn(new BlackjackCard(Rank.TWO, Suit.HEART))
			.thenReturn(new BlackjackCard(Rank.FOUR, Suit.HEART))
			.thenReturn(new BlackjackCard(Rank.FIVE, Suit.HEART));
		when(deck.giveCard(false)).thenReturn(new BlackjackCard(Rank.THREE, Suit.HEART));
		game = new BlackjackGame(1, deck);
		game.setup();
	}

	@Test
	public void testBlackjackGame() {
		assertEquals(21, game.getCrupierHandTotal());
	}

}
