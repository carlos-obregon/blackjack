package com.globant.blackjack;

import com.globant.blackjack.card.Card;
import com.globant.blackjack.deck.Deck;
import com.globant.blackjack.hand.BlackjackHand;
import com.globant.blackjack.hand.Hand;

public class BlackjackGame {

	private Hand crupierHand;
	private Hand[] playerHands;
	private Deck deck;
	private static final int BLACKJACK = 21;

	public BlackjackGame(int numberOfPlayers, Deck deck) {
		this.deck = deck;
		crupierHand = new BlackjackHand();
		playerHands = new Hand[numberOfPlayers];
		for (int i = 0; i < numberOfPlayers; ++i) {
			playerHands[i] = new BlackjackHand();
		}
	}

	public void setup() {
		crupierHand.addCard(deck.giveCard());
		crupierHand.addCard(deck.giveCard(false));
		for (Hand hand : playerHands) {
			for (int times = 1; times <= 2; ++times) {
				hand.addCard(deck.giveCard());
			}
		}
	}

	public void giveCard(int player) {
		Card card = deck.giveCard();
		playerHands[player].addCard(card);
	}

	public int getPlayerHandTotal(int player) {
		return playerHands[player].getValue();
	}

	public int getCrupierHandTotal() {
		return crupierHand.getValue();
	}

	public void giveCardCrupier() {
		Card card = deck.giveCard();
		crupierHand.addCard(card);
	}

	enum BlackjackWinner {
		HOUSE, PLAYER, TIE, BLAKJACK;
	}

	public BlackjackWinner determineOutcome(int player) {
		int crupierTotal = crupierHand.getValue();
		int playerTotal = playerHands[player].getValue();
		if (crupierTotal == playerTotal) {
			if (crupierTotal > BLACKJACK) {
				return BlackjackWinner.TIE;
			} else {
				return BlackjackWinner.HOUSE;
			}
		} else if (playerTotal > crupierTotal) {
			if (playerTotal == BLACKJACK) {
				return BlackjackWinner.BLAKJACK;
			} else if (playerTotal < BLACKJACK) {
				return BlackjackWinner.PLAYER;
			} else {
				return BlackjackWinner.TIE;
			}
		} else {
			if (crupierTotal <= BLACKJACK) {
				return BlackjackWinner.HOUSE;
			} else if (playerTotal == BLACKJACK) {
				return BlackjackWinner.BLAKJACK;
			} else {
				return BlackjackWinner.PLAYER;
			}
		}
	}

}
