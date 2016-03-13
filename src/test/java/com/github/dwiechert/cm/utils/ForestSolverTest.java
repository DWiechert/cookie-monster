package com.github.dwiechert.cm.utils;

import org.junit.Test;

/**
 * Tests for {@link ForestSolver}.
 * 
 * @author Dan Wiechert
 */
public class ForestSolverTest {
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
}
