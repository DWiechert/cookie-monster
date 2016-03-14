package com.github.dwiechert.cm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dwiechert.cm.models.Route;
import com.github.dwiechert.cm.utils.ForestParser;
import com.github.dwiechert.cm.utils.ForestSolver;

/**
 * Main entry point for cookie-monster solver.
 *
 * @author Dan Wiechert
 */
public class CMMain {
	private static final Logger LOGGER = LoggerFactory.getLogger(CMMain.class);

	private final ForestParser parser;
	private final ForestSolver solver;

	/**
	 * Full constructor.
	 *
	 * @param parser
	 *            The parser.
	 * @param solver
	 *            The solver.
	 */
	public CMMain(final ForestParser parser, final ForestSolver solver) {
		this.parser = parser;
		this.solver = solver;
	}

	public void run(final String... args) {
		if (args.length != 1) {
			LOGGER.error("Must provide a forest file to parse.");
			throw new IllegalArgumentException("Must provide a forest file to parse.");
		}

		final int[][] forest = parser.parseForest(args[0]);
		final Route route = solver.solve(forest);
		LOGGER.info("\nThe best route is:\n{}", route.format());
	}

	/**
	 * Main method for the solver.
	 *
	 * @param args
	 *            The command line arguments. Must provide a forest file to parse.
	 * @throws IllegalArgumentException
	 *             If no forest file is provided.
	 */
	public static void main(final String... args) {
		final CMMain main = new CMMain(new ForestParser(), new ForestSolver());
		main.run(args);
	}
}
