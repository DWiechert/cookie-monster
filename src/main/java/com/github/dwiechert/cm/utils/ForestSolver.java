package com.github.dwiechert.cm.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dwiechert.cm.models.Coordinate;
import com.github.dwiechert.cm.models.Route;

/**
 * Class to solve a route through the forest.
 *
 * @author Dan Wiechert
 */
public class ForestSolver {
	private static final Logger LOGGER = LoggerFactory.getLogger(ForestSolver.class);

	/**
	 * Solves the forest of integers for the route with the highest total number.
	 *
	 * @param forest
	 *            The forest of integers.
	 * @return The route with the highest total.
	 * @throw IllegalArgumentException If the forest is null, empty, or not a square.
	 * @throw IllegalStateException If no possible route was found.
	 */
	public Route solve(final int[][] forest) {
		LOGGER.info("Attempting to solve forest:\n{}", forest);

		if (forest == null || forest.length == 0) {
			LOGGER.error("Forest cannot be null or empty.");
			throw new IllegalArgumentException("Forest cannot be null or empty.");
		}

		if (!verfiySquare(forest)) {
			LOGGER.error("Forest must be a square.");
			throw new IllegalArgumentException("Forest must be a square.");
		}

		final List<Route> routes = getRoutes(forest, forest.length - 1, forest[0].length - 1, new Route());

		final Optional<Route> optionalRoute = routes.stream().max((r1, r2) -> r1.getTotalCookies().compareTo(r2.getTotalCookies()));
		if (!optionalRoute.isPresent()) {
			LOGGER.error("No possible route.");
			throw new IllegalStateException("No possible route.");
		}

		final Route route = optionalRoute.get();
		LOGGER.info("Found best route:\n{}", route);
		return route;
	}

	/**
	 * Verifies the forest is a square.
	 *
	 * @param forest
	 *            The forest.
	 * @return {@code True} if the forest is a square, {@code false} otherwise.
	 */
	private boolean verfiySquare(final int[][] forest) {
		int rowSize = -1;
		for (int i = 0; i < forest.length; i++) {
			if (rowSize == -1) {
				rowSize = forest[i].length;
			}
			if (rowSize != forest[i].length) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Gets all of the possible routes through the forest.
	 *
	 * @param forest
	 *            The forest to parse.
	 * @param row
	 *            The row.
	 * @param col
	 *            The column.
	 * @param route
	 *            The current route.
	 * @return All of the possible routes.
	 */
	private List<Route> getRoutes(final int[][] forest, final int row, final int col, final Route route) {
		if (row == 0 && col == 0) {
			route.addCoordinate(new Coordinate(row, col, forest[row][col]));
			route.setValid(true);
			return Collections.singletonList(route);
		} else if (row < 0 || col < 0 || forest[row][col] < 0) {
			route.setValid(false);
			return Collections.singletonList(route);
		} else {
			route.addCoordinate(new Coordinate(row, col, forest[row][col]));
			final List<Route> routes = new ArrayList<>();

			final Route r1 = new Route();
			r1.setCoordinates(new ArrayList<>(route.getCoordinates()));
			r1.setValid(route.isValid());
			routes.addAll(getRoutes(forest, row - 1, col, r1));

			final Route r2 = new Route();
			r2.setCoordinates(new ArrayList<>(route.getCoordinates()));
			r2.setValid(route.isValid());
			routes.addAll(getRoutes(forest, row, col - 1, r2));

			return routes;
		}
	}
}
