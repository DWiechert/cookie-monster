package com.github.dwiechert.cm.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests for {@link ForestParser}.
 * 
 * @author Dan Wiechert
 */
public class ForestParserTest {
	private static final String NOT_FOUND = "not.a.file";
	private static final String INVALID = "src/test/resources/forestParser/invalid.txt";
	private static final String EMPTY = "src/test/resources/forestParser/empty.txt";
	private static final String SINGLE = "src/test/resources/forestParser/single.txt";
	private static final String SMALL = "src/test/resources/forestParser/small.txt";
	private static final String BIG = "src/test/resources/forestParser/big.txt";
	private static final String WEIRD_SHAPE = "src/test/resources/forestParser/weirdShape.txt";

	/**
	 * Verifies an exception is thrown if the forest file is not found.
	 */
	@Test(expected = IllegalStateException.class)
	public void parseForest_FileNotFound() {
		final ForestParser parser = new ForestParser();
		parser.parseForest(NOT_FOUND);
	}

	/**
	 * Verifies an exception is thrown if the forest file has an invalid number.
	 */
	@Test(expected = IllegalStateException.class)
	public void parseForest_Invalid() {
		final ForestParser parser = new ForestParser();
		parser.parseForest(INVALID);
	}

	/**
	 * Verifies an exception is thrown if the forest is empty.
	 */
	@Test(expected = IllegalStateException.class)
	public void parseForest_Empty() {
		final ForestParser parser = new ForestParser();
		final int[][] forest = parser.parseForest(EMPTY);
		assertEquals(0, forest.length);
	}

	/**
	 * Verifies a single forest can be properly parsed.
	 */
	@Test
	public void parseForest_Single() {
		final ForestParser parser = new ForestParser();
		final int[][] forest = parser.parseForest(SINGLE);
		assertEquals(1, forest.length);
		assertArrayEquals(new int[] { 1 }, forest[0]);
	}

	/**
	 * Verifies a small forest can be properly parsed.
	 */
	@Test
	public void parseForest_Small() {
		final ForestParser parser = new ForestParser();
		final int[][] forest = parser.parseForest(SMALL);
		assertEquals(2, forest.length);
		assertArrayEquals(new int[] { 11, 12 }, forest[0]);
		assertArrayEquals(new int[] { 21, 22 }, forest[1]);
	}

	/**
	 * Verifies a big forest can be properly parsed.
	 */
	@Test
	public void parseForest_Big() {
		final ForestParser parser = new ForestParser();
		final int[][] forest = parser.parseForest(BIG);
		assertEquals(10, forest.length);
		assertArrayEquals(new int[] { 11, 12, 13, 14, 15, 16, 17, 18, 19, 10 }, forest[0]);
		assertArrayEquals(new int[] { 21, 22, 23, 24, 25, 26, 27, 28, 29, 20 }, forest[1]);
		assertArrayEquals(new int[] { 31, 32, 33, 34, 35, 36, 37, 38, 39, 30 }, forest[2]);
		assertArrayEquals(new int[] { 41, 42, 43, 44, 45, 46, 47, 48, 49, 40 }, forest[3]);
		assertArrayEquals(new int[] { 51, 52, 53, 54, 55, 56, 57, 58, 59, 50 }, forest[4]);
		assertArrayEquals(new int[] { 61, 62, 63, 64, 65, 66, 67, 68, 69, 60 }, forest[5]);
		assertArrayEquals(new int[] { 71, 72, 73, 74, 75, 76, 77, 78, 79, 70 }, forest[6]);
		assertArrayEquals(new int[] { 81, 82, 83, 84, 85, 86, 87, 88, 89, 80 }, forest[7]);
		assertArrayEquals(new int[] { 91, 92, 93, 94, 95, 96, 97, 98, 99, 90 }, forest[8]);
		assertArrayEquals(new int[] { 101, 102, 103, 104, 105, 106, 107, 108, 109, 100 }, forest[9]);
	}

	/**
	 * Verifies a weird shaped forest can be properly parsed.
	 */
	@Test
	public void parseForest_WeirdShape() {
		final ForestParser parser = new ForestParser();
		final int[][] forest = parser.parseForest(WEIRD_SHAPE);
		assertEquals(7, forest.length);
		assertArrayEquals(new int[] { 11 }, forest[0]);
		assertArrayEquals(new int[] { 21, 22 }, forest[1]);
		assertArrayEquals(new int[] { 31, 32, 33 }, forest[2]);
		assertArrayEquals(new int[] { 41, 42, 43, 44 }, forest[3]);
		assertArrayEquals(new int[] { 51, 52, 53 }, forest[4]);
		assertArrayEquals(new int[] { 61, 62 }, forest[5]);
		assertArrayEquals(new int[] { 71 }, forest[6]);
	}
}
