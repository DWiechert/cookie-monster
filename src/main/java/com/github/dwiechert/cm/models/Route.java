package com.github.dwiechert.cm.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to hold information about a route.
 * 
 * @author Dan Wiechert
 */
public class Route {
	/**
	 * String format for this route.
	 * <p/>
	 * Should be formatted with the following variables:
	 * <ol>
	 * <li>isValid</li>
	 * <li>number of cookies</li>
	 * </ol>
	 */
	private static final String TO_STRING_FORMAT = "Is valid?: %s\n" + "Number of cookies: %d\n" + "Coordinates:\n";
	private boolean valid;
	private List<Coordinate> coordinates;

	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * @param valid
	 *            the valid to set
	 */
	public void setValid(final boolean valid) {
		this.valid = valid;
	}

	/**
	 * @return the coordinates
	 */
	public List<Coordinate> getCoordinates() {
		if (coordinates == null) {
			coordinates = new ArrayList<>();
		}
		return coordinates;
	}

	/**
	 * @param coordinates
	 *            the coordinates to set
	 */
	public void setCoordinates(final List<Coordinate> coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * Adds a coordinate to this route.
	 * 
	 * @param coordinate
	 *            The coordinate to add.
	 */
	public void addCoordinate(final Coordinate coordinate) {
		if (coordinates == null) {
			coordinates = new ArrayList<>();
		}
		coordinates.add(coordinate);
	}

	/**
	 * Gets the total number of cookies in this route.
	 *
	 * @return The total number of cookies or {@code -1} if this route is invalid.
	 */
	public Integer getTotalCookies() {
		if (!isValid()) {
			return -1;
		}
		return coordinates.stream().mapToInt(Coordinate::getNumCookies).sum();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (coordinates == null ? 0 : coordinates.hashCode());
		result = prime * result + (valid ? 1231 : 1237);
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Route)) {
			return false;
		}
		final Route other = (Route) obj;
		if (coordinates == null) {
			if (other.coordinates != null) {
				return false;
			}
		} else if (!coordinates.equals(other.coordinates)) {
			return false;
		}
		if (valid != other.valid) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Route [valid=" + valid + ", coordinates=" + coordinates + "]";
	}

	/**
	 * Provides a nicely formatted route.
	 * 
	 * @return The formatted route.
	 */
	public String format() {
		final StringBuilder builder = new StringBuilder();
		builder.append(String.format(TO_STRING_FORMAT, isValid(), getTotalCookies()));
		getCoordinates().forEach(c -> builder.append(c.format()));
		return builder.toString();
	}
}
