package com.globant.blackjack.card;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class BlackjackCardTests {

	private Rank ace;
	private Suit heart;
	private BlackjackCard card;

	@Before
	public void setup() {
		ace = Rank.ACE;
		heart = Suit.HEART;
		card = new BlackjackCard(ace, heart);
	}

	@Test
	public void testCardCreation() {
		assertEquals(ace, card.getRank());
		assertEquals(heart, card.getSuit());
	}

	@Test
	public void testImmutability() {
		ace = Rank.EIGHT;
		heart = Suit.DIAMOND;
		assertTrue(!ace.equals(card.getRank()));
		assertTrue(!heart.equals(card.getRank()));
	}

	@Test
	public void testExpectedValues() {
		Rank[] ranks = Rank.values();
		BlackjackCard[] cards = new BlackjackCard[ranks.length];
		for (int i = 0; i < ranks.length; ++i) {
			cards[i] = new BlackjackCard(ranks[i], heart);
		}
		int[] EXPECTED_VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
		int[] actualValues = new int[cards.length];
		for (int i = 0; i < cards.length; ++i) {
			actualValues[i] = cards[i].getValue();
		}
		assertArrayEquals(String.format("Actual values were: %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d", actualValues[0], actualValues[1], actualValues[2], actualValues[3], actualValues[4], actualValues[5], actualValues[6], actualValues[7], actualValues[8], actualValues[9], actualValues[10], actualValues[11], actualValues[12]), EXPECTED_VALUES, actualValues);
	}

	@Test
	public void testExpectedRepresentations() {
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();
		final int TOTAL_CARDS = ranks.length * suits.length;
		BlackjackCard[] cards = new BlackjackCard[TOTAL_CARDS];
		for (int j = 0; j < suits.length; ++j) {
			for (int i = 0; i < ranks.length; ++i) {
				int k = j * ranks.length + i;
				cards[k] = new BlackjackCard(ranks[i], suits[j]);
			}
		}
		String[] EXPECTED_VALUES = {"AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC",
				"AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "TS", "JS", "QS", "KS",
				"AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "TH", "JH", "QH", "KH",
				"AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "TD", "JD", "QD", "KD"};
		String[] actualValues = new String[TOTAL_CARDS];
		for (int i = 0; i < cards.length; ++i) {
			actualValues[i] = cards[i].toString();
		}
		assertArrayEquals(EXPECTED_VALUES, actualValues);
	}

	@Test
	public void aNewlyCreatedCardIsVisible() {
		assertTrue(card.isVisible());
	}

	@Test
	public void anInvisibleCardIsNotShown() {
		card.setVisible(false);
		String INVISIBLE_CARD_REPRESENTATION = "**";
		assertEquals(INVISIBLE_CARD_REPRESENTATION, card.toString());		
	}

	@Test
	public void testCanFlipACard() {
		card.setVisible(false);
		assertTrue(!card.isVisible());
	}

}
