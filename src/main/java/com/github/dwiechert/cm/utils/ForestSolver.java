package com.github.dwiechert.cm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

		// Forest is a square so all rows/cols are the same size
		final int maxRow = forest.length;
		final int maxColumn = forest[0].length;

		return null;
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
}
