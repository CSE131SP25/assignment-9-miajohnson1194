package assignment9;

import edu.princeton.cs.introcs.StdDraw;

public class Powerup {
	
	public static final double POWERUP_SIZE = 0.02;
	private double x, y;
	
	
	public Powerup() {
		this.y = Math.random();
		this.x = Math.random();
		
	}
	
	
	public void draw() {
		StdDraw.setPenColor(245, 245, 66);
		StdDraw.filledCircle(x, y, POWERUP_SIZE);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}

	
	


