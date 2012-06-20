package com.globant.blackjack.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class IO {

	private BufferedReader in;
	private PrintStream out;

	public IO(InputStream  in, PrintStream out) {
		this.in = new BufferedReader(new InputStreamReader(in));
		this.out = out;
	}

	public IO() {
		this(System.in, System.out);
	}

	public void printMessage(String message) {
		out.println(message);
	}

	public String readAction() throws IOException {
		return in.readLine();
	}

}
