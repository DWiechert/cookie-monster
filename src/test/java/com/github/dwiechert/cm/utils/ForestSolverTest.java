package com.github.dwiechert.cm.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.dwiechert.cm.models.Route;

/**
 * Tests for {@link ForestSolver}.
 * 
 * @author Dan Wiechert
 */
public class ForestSolverTest {
	private static final String SINGLE = "src/test/resources/forestSolver/single.txt";
	private static final String ONE_PATH = "src/test/resources/forestSolver/onePath.txt";
	
	/**
	 * Verifies an exception is thrown if the forest is null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void solve_NullForest() {
		final ForestSolver solver = new ForestSolver();
		solver.solve(null);
	}

	/**
	 * Verifies an exception is thrown if the forest is empty.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void solve_EmptyForest() {
		final ForestSolver solver = new ForestSolver();
		solver.solve(new int[0][]);
	}

	/**
	 * Verifies an exception is thrown if the forest is not a square.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void solve_NonSquareForest() {
		final int[][] forest = new int[2][];
		forest[0] = new int[] { 11 };
		forest[1] = new int[] { 21, 22 };

		final ForestSolver solver = new ForestSolver();
		solver.solve(forest);
	}
	
	@Test
	public void solve_Single() {
		final ForestParser parser = new ForestParser();
		final int[][] forest = parser.parseForest(SINGLE);
		
		final ForestSolver solver = new ForestSolver();
		final Route route = solver.solve(forest);
		
		assertNotNull(route);
		assertTrue(route.isValid());
		assertEquals(1, route.getTotalCookies().intValue());
	}
	
	@Test
	public void solve_OnePath() {
		final ForestParser parser = new ForestParser();
		final int[][] forest = parser.parseForest(ONE_PATH);
		
		final ForestSolver solver = new ForestSolver();
		final Route route = solver.solve(forest);
		
		assertNotNull(route);
		assertTrue(route.isValid());
		assertEquals(128, route.getTotalCookies().intValue());
	}
}
