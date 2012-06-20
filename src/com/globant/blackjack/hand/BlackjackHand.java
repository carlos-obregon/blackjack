package com.globant.blackjack.hand;

import java.util.ArrayList;
import java.util.List;

import com.globant.blackjack.card.BlackjackCard;
import com.globant.blackjack.card.Card;
import com.globant.blackjack.card.Rank;

public class BlackjackHand implements Hand {

	private List<Card> hand;
	private int value;
	private int numberOfAces;

	public BlackjackHand() {
		hand = new ArrayList<>();
	}

	@Override
	public int size() {
		return hand.size();
	}

	private void addCardVisible(Card card) {
		value += card.getValue();
		if (card.getRank() == Rank.ACE) {
			++numberOfAces;
		}
	}

	@Override
	public void addCard(Card card) {
		Card cardToAdd = new BlackjackCard(card);
		hand.add(cardToAdd);
		if (cardToAdd.isVisible()) {
			addCardVisible(cardToAdd);
		}
	}

	@Override
	public int getValue() {
		int total = value;
		for (int aces = 1; aces <= numberOfAces && total + 10 <= 21; ++aces) {
			total += 10;
		}
		return total;
	}

	@Override
	public void flipCards() {
		for (Card card : hand) {
			if (!card.isVisible()) {
				card.setVisible(true);
				addCardVisible(card);
			}
		}
	}

	public String toString() {
		final int TOTAL_CARDS = hand.size();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < TOTAL_CARDS - 1; ++i) {
			sb.append(hand.get(i).toString()).append(' ');
		}
		sb.append(hand.get(TOTAL_CARDS - 1).toString());
		return sb.toString();
	}

}
