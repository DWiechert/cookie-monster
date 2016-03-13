package com.github.dwiechert.cm.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to parse a forest from a file.
 * 
 * @author Dan Wiechert
 */
public class ForestParser {
	private static final Logger LOGGER = LoggerFactory.getLogger(ForestParser.class);

	/**
	 * Parses a forest of integers from the provided file.
	 * 
	 * @param file
	 *            The file to parse.
	 * @return The parsed forest of integers.
	 * @throws IllegalStateException
	 *             If there was an error reading the file.
	 */
	public int[][] parseForest(final String file) {
		final List<List<Integer>> forest = new ArrayList<>();

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));

			String line;
			while ((line = reader.readLine()) != null) {
				final List<Integer> row = new ArrayList<>();

				final String[] columns = line.trim().split("\\s+");
				for (final String column : columns) {
					row.add(Integer.parseInt(column));
				}

				forest.add(row);
			}
		} catch (final IOException e) {
			LOGGER.error("Error parsing forest.", e);
			throw new IllegalStateException("Error parsing forest.", e);
		} catch (final NumberFormatException e) {
			LOGGER.error("Error parsing forest.", e);
			throw new IllegalStateException("Error parsing forest.", e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new RuntimeException("Error closing reader.", e);
				}
			}
		}

		int counter = 0;
		final int[][] array = new int[forest.size()][];
		for (final List<Integer> row : forest) {
			array[counter] = toIntArray(row);
			counter++;
		}
		LOGGER.info("Parsed forest:\n{}", array);
		return array;
	}

	/**
	 * Translates a list into an array.
	 * 
	 * @param list
	 *            The list.
	 * @return The array.
	 */
	private int[] toIntArray(final List<Integer> list) {
		final int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
}
