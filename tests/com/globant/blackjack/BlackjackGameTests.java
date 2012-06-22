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

	public void setup19OnCrupierHand20OnPlayerHand() {
		deck = mock(Deck.class);
		when(deck.giveCard())
			.thenReturn(new BlackjackCard(Rank.TEN, Suit.HEART))
			.thenReturn(new BlackjackCard(Rank.TEN, Suit.DIAMOND))
			.thenReturn(new BlackjackCard(Rank.TEN, Suit.SPADE));
		when(deck.giveCard(false)).thenReturn(new BlackjackCard(Rank.NINE, Suit.CLUB));
		commonSetup();
	}

	@Test
	public void testPlayerWinsWithHigherTotalButLessThan22() {
		setup19OnCrupierHand20OnPlayerHand();
		assertEquals(19, game.getCrupierHandTotal());
		assertEquals(20, game.getPlayerHandTotal(0));
		assertEquals(BlackjackWinner.PLAYER, game.determineOutcome(0));
	}

	public void setup22OnCrupierHand22OnPlayerHand() {
		deck = mock(Deck.class);
		when(deck.giveCard())
			.thenReturn(new BlackjackCard(Rank.J, Suit.HEART))
			.thenReturn(new BlackjackCard(Rank.J, Suit.DIAMOND))
			.thenReturn(new BlackjackCard(Rank.NINE, Suit.SPADE))
			.thenReturn(new BlackjackCard(Rank.THREE, Suit.SPADE))
			.thenReturn(new BlackjackCard(Rank.THREE, Suit.HEART));
		when(deck.giveCard(false)).thenReturn(new BlackjackCard(Rank.NINE, Suit.CLUB));
		commonSetup();
		game.giveCard(0);
		game.giveCardCrupier();
	}

	@Test
	public void testTieIfPlayerAndHouseTotalsAreOver21() {
		setup22OnCrupierHand22OnPlayerHand();
		assertEquals(22, game.getCrupierHandTotal());
		assertEquals(22, game.getPlayerHandTotal(0));
		assertEquals(BlackjackWinner.TIE, game.determineOutcome(0));
	}

	public void setup22OnCrupierHand19OnPlayerHand() {
		deck = mock(Deck.class);
		when(deck.giveCard())
			.thenReturn(new BlackjackCard(Rank.J, Suit.HEART))
			.thenReturn(new BlackjackCard(Rank.J, Suit.DIAMOND))
			.thenReturn(new BlackjackCard(Rank.NINE, Suit.SPADE))
			.thenReturn(new BlackjackCard(Rank.THREE, Suit.HEART));
		when(deck.giveCard(false)).thenReturn(new BlackjackCard(Rank.NINE, Suit.CLUB));
		commonSetup();
		game.giveCardCrupier();
	}

	@Test
	public void testPlayerWinsWithLowerTotalButHouseTotalIsOver21() {
		setup22OnCrupierHand19OnPlayerHand();
		assertEquals(22, game.getCrupierHandTotal());
		assertEquals(19, game.getPlayerHandTotal(0));
		assertEquals(BlackjackWinner.PLAYER, game.determineOutcome(0));
	}

	public void setup20OnCrupierHand20OnPlayerHand() {
		deck = mock(Deck.class);
		when(deck.giveCard())
			.thenReturn(new BlackjackCard(Rank.J, Suit.HEART))
			.thenReturn(new BlackjackCard(Rank.J, Suit.DIAMOND))
			.thenReturn(new BlackjackCard(Rank.TEN, Suit.SPADE));
		when(deck.giveCard(false)).thenReturn(new BlackjackCard(Rank.TEN, Suit.CLUB));
		commonSetup();
	}

	@Test
	public void testHouseWinsWithTieTotals() {
		setup20OnCrupierHand20OnPlayerHand();
		assertEquals(20, game.getCrupierHandTotal());
		assertEquals(20, game.getPlayerHandTotal(0));
		assertEquals(BlackjackWinner.HOUSE, game.determineOutcome(0));
	}

}
