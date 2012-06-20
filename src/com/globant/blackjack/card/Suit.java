package com.globant.blackjack.card;

public enum Suit {
	CLUB("C"), SPADE("S"), HEART("H"), DIAMOND("D");

	private String representation;

	private Suit(String representation) {
		this.representation = representation;
	}

	@Override
	public String toString() {
		return representation;
	}

}
