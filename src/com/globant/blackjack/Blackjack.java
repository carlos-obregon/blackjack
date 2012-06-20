package com.globant.blackjack;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import com.globant.blackjack.deck.SimpleDeck;
import com.globant.blackjack.hand.Hand;
import com.globant.blackjack.util.IO;

public class Blackjack {

	private IO io;
	private BlackjackGame game;
	private static final ResourceBundle messages;
	private static final String ACCEPT;
	private static final String DENY;

	static {
		messages = ResourceBundle.getBundle("messages");
		ACCEPT = messages.getString("accept.string");
		DENY = messages.getString("deny.string");
	}

	public Blackjack() {
		io = new IO();
		game = new BlackjackGame(1, new SimpleDeck());
		game.setup();
	}

	protected String doReadAction() throws IOException {
		io.printMessage(messages.getString("player.action"));
		String action = io.readAction();
		return action.equals(ACCEPT) ? "Y" : action.equals(DENY) ? "N" : "?";
	}

	protected String readAction() {
		while (true) {
			try {
				return doReadAction();
			} catch (IOException e) {
				io.printMessage(messages.getString("io.error"));
			}
		}
	}

	protected void printInputErrorMessage() {
		MessageFormat formatter = new MessageFormat("");
	    formatter.applyPattern(messages.getString("input.error"));
	    String output = formatter.format(new Object[]{ACCEPT, DENY});
	    io.printMessage(output);
	}

	protected void playerTurn() {
		boolean done = false;
		while (!done) {
			String action = readAction();
			switch (action) {
			case "N": {
				break;
			}
			case "Y":
				done = true;
				break;
				default:
					printInputErrorMessage();
			}
		}
	}

	protected void printHand(Hand hand) {
		io.printMessage(String.format(messages.getString("print.hand.format"),
				hand, hand.getValue()));
	}

	protected void printHands() {

	}

	public void play() {
		
	}

}
