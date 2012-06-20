package com.globant.blackjack.card;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class RankTests {

	private Rank[] ranks;

	@Before
	public void basicSetup() {
		ranks = Rank.values();
	}

	@Test
	public void testRankCreation() {
		final int NUMBER_OF_RANKS = 13;
		assertEquals(NUMBER_OF_RANKS, ranks.length);
	}

	@Test
	public void testRankStringRepresentation() {
		HashSet<String> representation = 
				new HashSet<String>(Arrays.asList("A","2", "3", "4", "5", "6", 
						"7", "8", "9", "T", "J", "Q", "K"));
		ArrayList<String> actualRepresentation = 
				new ArrayList<String>(ranks.length);
		for (Rank rank : ranks) {
			actualRepresentation.add(rank.toString());
		}
		assertTrue(
				String.format(
						"Representations were %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s",
						ranks[0], ranks[1], ranks[2], ranks[3], ranks[4],
						ranks[5], ranks[6], ranks[7], ranks[8], ranks[9],
						ranks[10], ranks[11], ranks[12]),
				representation.containsAll(actualRepresentation));
	}

	@Test
	public void testRankValues() {
		int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		int[] actualValues = new int[ranks.length];
		for (int i = ranks.length - 1; i >= 0; --i) {
			actualValues[i] = ranks[i].getValue();
		}
		assertArrayEquals(values, actualValues);
	}

}
