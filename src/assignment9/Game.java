package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake playing;
	private Food eating;
	private Powerup powerup;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(600, 600);
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);
		playing = new Snake();
		eating = new Food();
		powerup = new Powerup();
	}
	
	public void play() {
		while (playing.isInbounds()) { //TODO: Update this condition to check if snake is in bounds
			int dir = getKeypress();
			//Testing only: you will eventually need to do more work here
			System.out.println("Keypress: " + dir);
			
			if (dir != -1) {
				playing.changeDirection(dir);
			}
			if (playing.eatFood(eating)) {
				eating = new Food(); // Spawn new food if eaten
			} else {
				playing.move(); // Move normally (no growth)
			}
			if (playing.eatPowerup(powerup)) {
                playing.activateSpeedBoost(2.0, 5000); // 2x speed for 5 seconds
                powerup = new Powerup(); 
            }

			updateDrawing();
		}

		System.out.println("Game Over!");
		}
	
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		playing.draw();
		eating.draw();
		powerup.draw();
		StdDraw.show();
		StdDraw.pause(100); 
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
