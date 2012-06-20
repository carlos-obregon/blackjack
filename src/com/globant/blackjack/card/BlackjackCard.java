package com.globant.blackjack.card;

public class BlackjackCard extends BaseCard {

	public BlackjackCard(Rank rank, Suit suit) {
		super(rank, suit);
	}

	public BlackjackCard(Card card) {
		super(card);
	}

	public int getValue() {
		switch(rank) {
		case ACE:
		case TWO:
		case THREE:
		case FOUR:
		case FIVE:
		case SIX:
		case SEVEN:
		case EIGHT:
		case NINE:
		case TEN:
			return rank.getValue();
		case J:
		case Q:
		case K:
			return Rank.TEN.getValue();
			default:
				throw new AssertionError();
		}
	}

}
