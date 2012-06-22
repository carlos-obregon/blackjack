package com.globant.blackjack;

import com.globant.blackjack.deck.Deck;
import com.globant.blackjack.deck.SimpleDeck;
import com.globant.blackjack.util.IO;

public class Main {

	public static void main(String[] args) {
		IO io = new IO(System.in, System.out);
		Deck deck = new SimpleDeck();
		BlackjackGame game = new BlackjackGame(1, deck);
		Blackjack blackjack = new Blackjack(io, game);
		blackjack.play();
	}

}
