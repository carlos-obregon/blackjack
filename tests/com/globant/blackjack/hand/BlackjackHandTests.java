package com.globant.blackjack.hand;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.globant.blackjack.card.BlackjackCard;
import com.globant.blackjack.card.Rank;
import com.globant.blackjack.card.Suit;

public class BlackjackHandTests {

	private Hand hand;
	private BlackjackCard aceOfHearts;

	@Before
	public void setup() {
		hand = new BlackjackHand();
		aceOfHearts = new BlackjackCard(Rank.ACE, Suit.HEART);
	}

	@Test
	public void testHandCreation() {		
		final int INITIAL_NUMBER_OF_CARDS_ON_EMPTY_HAND = 0;
		assertEquals(INITIAL_NUMBER_OF_CARDS_ON_EMPTY_HAND, hand.size());
	}

	@Test
	public void testCanAddACard() {
		BlackjackCard aceOfHearts = new BlackjackCard(Rank.ACE, Suit.HEART);
		hand.addCard(aceOfHearts);
		final int NUMBER_OF_CARDS_AFTER_ADDING_ONE_CARD_ON_EMPTY_HAND = 1;
		assertEquals(NUMBER_OF_CARDS_AFTER_ADDING_ONE_CARD_ON_EMPTY_HAND, hand.size());
	}

	@Test
	public void theCardOnHandHasTheSameValueThatBefore() {
		BlackjackCard twoOfHearts = new BlackjackCard(Rank.TWO, Suit.HEART);
		hand.addCard(twoOfHearts);
		final int VALUE_OF_TWO_OF_HEARTS = twoOfHearts.getValue();
		assertEquals(VALUE_OF_TWO_OF_HEARTS, hand.getValue());
	}

	@Test
	public void testValueOfOneAce() {
		hand.addCard(aceOfHearts);
		final int VALUE_OF_ONE_ACE_IN_HAND = 11;
		assertEquals(VALUE_OF_ONE_ACE_IN_HAND, hand.getValue());
	}

	@Test
	public void testValueOfTwoAces() {
		for (int veces = 1; veces <= 2; ++veces) {
			hand.addCard(aceOfHearts);
		}
		final int VALUE_OF_TWO_ACES_IN_HAND = 12;
		assertEquals(VALUE_OF_TWO_ACES_IN_HAND, hand.getValue());
	}

	@Test
	public void testBlackjackWithThreeAces() {
		for (int veces = 1; veces <= 3; ++veces) {
			hand.addCard(aceOfHearts);
		}
		hand.addCard(new BlackjackCard(Rank.EIGHT, Suit.HEART));
		final int BLACKJACK = 21;
		assertEquals(BLACKJACK, hand.getValue());
	}

	@Test
	public void testFlippedCardDoesNotCountOnValue() {
		aceOfHearts.setVisible(false);
		hand.addCard(aceOfHearts);
		final int VALUE_OF_HAND_WITH_FLIPPED_CARDS = 0;
		assertEquals(VALUE_OF_HAND_WITH_FLIPPED_CARDS, hand.getValue());
	}

	@Test
	public void invisibleCardsAreNotShown() {
		aceOfHearts.setVisible(false);
		hand.addCard(aceOfHearts);
		String UNKNOW_CARD = "**";
		assertEquals(UNKNOW_CARD, hand.toString());
	}

	@Test
	public void testFlipCardsLeaveCardsAsVisible() {
		aceOfHearts.setVisible(false);
		hand.addCard(aceOfHearts);
		hand.flipCards();
		String ACE_OF_HEARTS_REPRESENTATION = "AH";
		assertEquals(ACE_OF_HEARTS_REPRESENTATION, hand.toString());
	}

}
