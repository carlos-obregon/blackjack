package com.globant.blackjack;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.globant.blackjack.BlackjackGame.BlackjackWinner;
import com.globant.blackjack.card.BlackjackCard;
import com.globant.blackjack.card.Rank;
import com.globant.blackjack.card.Suit;
import com.globant.blackjack.deck.Deck;

public class BlackjackGameTests {

	private Deck deck;
	private BlackjackGame game;

	public void commonSetup() {
		game = new BlackjackGame(1, deck);
		game.setup();
		game.uncoverCrupierHand();
	}

	public void setup20OnCrupierHand19OnPlayerHand() {
		deck = mock(Deck.class);
		when(deck.giveCard())
			.thenReturn(new BlackjackCard(Rank.TEN, Suit.HEART))
			.thenReturn(new BlackjackCard(Rank.TEN, Suit.DIAMOND))
			.thenReturn(new BlackjackCard(Rank.NINE, Suit.HEART));
		when(deck.giveCard(false)).thenReturn(new BlackjackCard(Rank.TEN, Suit.SPADE));
		commonSetup();
	}

	@Test
	public void testHouseWinsWithHigherTotalButLessThan22() {
		setup20OnCrupierHand19OnPlayerHand();
		assertEquals(20, game.getCrupierHandTotal());
		assertEquals(19, game.getPlayerHandTotal(0));
		assertEquals(BlackjackWinner.HOUSE, game.determineOutcome(0));
	}

}
