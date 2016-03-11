package com.github.dwiechert.cm;

import com.github.dwiechert.cm.models.Route;
import com.github.dwiechert.cm.utils.ForestParser;
import com.github.dwiechert.cm.utils.ForestSolver;

public class CMMain {
	public static void main(final String... args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Must provide a file to parse.");
		}
		
		final ForestParser parser = new ForestParser();
		final int[][] forest = parser.parseForest(args[0]);
		
		final ForestSolver solver = new ForestSolver();
		final Route route = solver.solve(forest);
		// TODO: Add a good toString to route
		System.out.println("The best route is:\n" + route);
	}
}
