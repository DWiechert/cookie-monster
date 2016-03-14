package com.github.dwiechert.cm.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.dwiechert.cm.models.Route;

/**
 * Tests for {@link ForestSolver}.
 *
 * @author Dan Wiechert
 */
public class ForestSolverTest {
	private static final String SINGLE = "src/test/resources/forestSolver/single.txt";
	private static final String NO_ROUTES = "src/test/resources/forestSolver/noRoutes.txt";
	private static final String ONE_ROUTE = "src/test/resources/forestSolver/oneRoute.txt";
	private static final String MULTIPLE_ROUTES = "src/test/resources/forestSolver/multipleRoutes.txt";

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

	/**
	 * Verifies a forest with no possible routes cannot be solved.
	 */
	@Test
	public void solve_NoRoutes() {
		final ForestParser parser = new ForestParser();
		final int[][] forest = parser.parseForest(NO_ROUTES);

		final ForestSolver solver = new ForestSolver();
		final Route route = solver.solve(forest);

		assertNotNull(route);
		assertFalse(route.isValid());
		assertEquals(-1, route.getTotalCookies().intValue());
	}

	/**
	 * Verifies a single forest can be properly solved.
	 */
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

	/**
	 * Verifies a forest with one route can be properly solved.
	 */
	@Test
	public void solve_OneRoute() {
		final ForestParser parser = new ForestParser();
		final int[][] forest = parser.parseForest(ONE_ROUTE);

		final ForestSolver solver = new ForestSolver();
		final Route route = solver.solve(forest);

		assertNotNull(route);
		assertTrue(route.isValid());
		assertEquals(110, route.getTotalCookies().intValue());
	}

	/**
	 * Verifies a forest with multiple route can be properly solved and the one with the most cookies is returned.
	 */
	@Test
	public void solve_MultipleRoutes() {
		final ForestParser parser = new ForestParser();
		final int[][] forest = parser.parseForest(MULTIPLE_ROUTES);

		final ForestSolver solver = new ForestSolver();
		final Route route = solver.solve(forest);

		assertNotNull(route);
		assertTrue(route.isValid());
		assertEquals(128, route.getTotalCookies().intValue());
	}
}
