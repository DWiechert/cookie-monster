package com.github.dwiechert.cm;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Test;

import com.github.dwiechert.cm.models.Route;
import com.github.dwiechert.cm.utils.ForestParser;
import com.github.dwiechert.cm.utils.ForestSolver;

/**
 * Tests for {@link CMMain}.
 *
 * @author Dan Wiechert
 */
public class CMMainTest {
	/**
	 * Verifies an exception is thrown if no forest file is provided.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void run_NoForestFile() {
		final CMMain main = new CMMain(null, null);
		main.run(new String[0]);
	}

	/**
	 * Verifies the main run can be processed successfully.
	 */
	@Test
	public void run() {
		final String forestFile = "file.txt";

		final int[][] forest = new int[0][];
		final ForestParser parser = mock(ForestParser.class);
		doReturn(forest).when(parser).parseForest(forestFile);

		final Route route = new Route();
		final ForestSolver solver = mock(ForestSolver.class);
		doReturn(route).when(solver).solve(forest);

		final CMMain main = new CMMain(parser, solver);
		main.run(new String[] { forestFile });

		verify(parser).parseForest(forestFile);
		verifyNoMoreInteractions(parser);
		verify(solver).solve(forest);
		verifyNoMoreInteractions(solver);
	}
}
