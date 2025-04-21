package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		this.y = Math.random();
		this.x = Math.random();
		
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(255, 0, 0);
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}
