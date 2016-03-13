package com.github.dwiechert.cm.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dwiechert.cm.models.Coordinate;
import com.github.dwiechert.cm.models.Route;

public class ForestSolver {
	private static final Logger LOGGER = LoggerFactory.getLogger(ForestSolver.class);

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

		// final List<Route> routes = getRoutes(forest);
		// final Optional<Route> route = routes.stream().filter(r -> r.isValid()).sorted((r1, r2) ->
		// r1.getTotalCookies().compareTo(r2.getTotalCookies())).findFirst();
		// if (!route.isPresent()) {
		// throw new IllegalStateException("No possible route.");
		// }
		// return route.get();

		Route route = new Route();
		traceBack(forest, forest.length - 1, forest[0].length - 1, route);
		if (!route.isValid()) {
			throw new IllegalStateException("No possible route.");
		}
		return route;
	}

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

	private List<Route> getRoutes(final int[][] forest) {
		// Forest is a square so all rows/cols are the same size
		final int maxRow = forest.length;
		final int maxCol = forest[0].length;
		final List<Route> routes = new ArrayList<>();
		for (int row = 0; row < maxRow; row++) {

			for (int col = 0; col < maxCol; col++) {

			}
		}
		return routes;
	}

	private void buildRoute(final int[][] forest, final int row, final int col, final int maxRow, final int maxCol, Route route) {

	}

	private void traceBack(final int[][] forest, final int row, final int col, Route route) {
		if (row == 0 && col == 0) {
			route.addCoordinate(new Coordinate(row, col, forest[row][col]));
			route.setValid(true);
		} else if (row < 0 || col < 0 || forest[row][col] < 0) {
			route.setValid(false);
		} else {
			route.addCoordinate(new Coordinate(row, col, forest[row][col]));
			
			final Route r1 = new Route();
			r1.setCoordinates(new ArrayList<>(route.getCoordinates()));
			r1.setValid(route.isValid());
			traceBack(forest, row - 1, col, r1);

			final Route r2 = new Route();
			r2.setCoordinates(new ArrayList<>(route.getCoordinates()));
			r2.setValid(route.isValid());
			traceBack(forest, row, col - 1, r2);

			LOGGER.info("Comparing routes:");
			LOGGER.info("r1: {}", r1);
			LOGGER.info("r2: {}", r2);
			route = r1.getTotalCookies() >= r2.getTotalCookies() ? r1 : r2;
			LOGGER.info("route: {}", route);
		}
	}
}
