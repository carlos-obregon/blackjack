package com.globant.blackjack;

import com.globant.blackjack.card.Card;
import com.globant.blackjack.deck.Deck;
import com.globant.blackjack.hand.BlackjackHand;
import com.globant.blackjack.hand.Hand;

public class BlackjackGame {

	private Hand crupierHand;
	private Hand[] playersHand;
	private Deck deck;
	private static final int BLACKJACK = 21;

	public BlackjackGame(int numberOfPlayers, Deck deck) {
		this.deck = deck;
		crupierHand = new BlackjackHand();
		playersHand = new Hand[numberOfPlayers];
		for (int i = 0; i < numberOfPlayers; ++i) {
			playersHand[i] = new BlackjackHand();
		}
	}

	public void setup() {
		crupierHand.addCard(deck.giveCard());
		crupierHand.addCard(deck.giveCard(false));
		for (Hand hand : playersHand) {
			for (int times = 1; times <= 2; ++times) {
				hand.addCard(deck.giveCard());
			}
		}
	}

	public void uncoverCrupierHand() {
		crupierHand.flipCards();
	}

	public void giveCard(int player) {
		Card card = deck.giveCard();
		playersHand[player].addCard(card);
	}

	public int getPlayerHandTotal(int player) {
		return playersHand[player].getValue();
	}

	public int getCrupierHandTotal() {
		return crupierHand.getValue();
	}

	public void giveCardCrupier() {
		Card card = deck.giveCard();
		crupierHand.addCard(card);
	}

	public Hand getCrupierHand() {
		return crupierHand;
	}

	public Hand getPlayerHand(int player) {
		return playersHand[player];
	}

	enum BlackjackWinner {
		HOUSE, PLAYER, TIE, BLACKJACK;
	}

	public BlackjackWinner determineOutcome(int player) {
		int crupierTotal = crupierHand.getValue();
		int playerTotal = playersHand[player].getValue();
		if (crupierTotal == playerTotal) {
			if (crupierTotal > BLACKJACK) {
				return BlackjackWinner.TIE;
			} else {
				return BlackjackWinner.HOUSE;
			}
		} else if (playerTotal > crupierTotal) {
			if (playerTotal == BLACKJACK) {
				return BlackjackWinner.BLACKJACK;
			} else if (playerTotal < BLACKJACK) {
				return BlackjackWinner.PLAYER;
			} else {
				return BlackjackWinner.TIE;
			}
		} else {
			if (crupierTotal <= BLACKJACK) {
				return BlackjackWinner.HOUSE;
			} else if (playerTotal == BLACKJACK) {
				return BlackjackWinner.BLACKJACK;
			} else {
				return BlackjackWinner.PLAYER;
			}
		}
	}

}
