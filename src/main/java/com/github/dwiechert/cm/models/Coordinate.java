package com.github.dwiechert.cm.models;

public class Coordinate {
	private int x;
	private int y;
	private int numCookies;
	
	public Coordinate() {
	}
	
	public Coordinate(final int x, final int y, final int numCookies) {
		this.x = x;
		this.y = y;
		this.numCookies = numCookies;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(final int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(final int y) {
		this.y = y;
	}

	/**
	 * @return the numCookies
	 */
	public int getNumCookies() {
		return numCookies;
	}

	/**
	 * @param numCookies
	 *            the numCookies to set
	 */
	public void setNumCookies(final int numCookies) {
		this.numCookies = numCookies;
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
		result = prime * result + numCookies;
		result = prime * result + x;
		result = prime * result + y;
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
		if (!(obj instanceof Coordinate)) {
			return false;
		}
		final Coordinate other = (Coordinate) obj;
		if (numCookies != other.numCookies) {
			return false;
		}
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
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
		return "Coordinate [x=" + x + ", y=" + y + ", numCookies=" + numCookies + "]";
	}
}
