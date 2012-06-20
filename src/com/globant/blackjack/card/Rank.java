package com.globant.blackjack.card;

public enum Rank {
	ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, J, Q, K;

	@Override
	public String toString() {
		switch(this) {
		case TWO:
		case THREE:
		case FOUR:
		case FIVE:
		case SIX:
		case SEVEN:
		case EIGHT:
		case NINE:
			return String.valueOf(getValue());
		case ACE:
		case TEN:
			return String.valueOf(super.toString().charAt(0));
		case J:
		case Q:
		case K:
			return super.toString();
			default:
				throw new AssertionError();
		}
	}

	public int getValue() {
		return ordinal() + 1;
	}

}
