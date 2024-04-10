package PingPongPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
	private BoxCollider collider;
	private int r;
	private float xdir = -1;
	private float ydir = 1;

	private Random random;

	int unitSize = TableSetting.getUnitSize();

	public Ball(int x, int y, int r) {
		collider = new BoxCollider(x, y, r, r);
		this.r = r;
		random = new Random();
	}

	public void showGraphic(Graphics g) {
		int xpos = (int) collider.getPosition()[0];
		int ypos = (int) collider.getPosition()[1];

		g.drawOval(xpos, ypos, r, r);
	}

	public void showGraphic(Graphics g, Color color) {
		int xpos = (int) collider.getPosition()[0];
		int ypos = (int) collider.getPosition()[1];
		g.setColor(color);
		g.fillOval(xpos - r / 2, ypos - r / 2, r, r);
	}

	public void move() {

		float xpos = collider.getPosition()[0] + xdir * 1 * unitSize;
		float ypos = collider.getPosition()[1] + ydir * 1 * unitSize;

		collider.setPosition(xpos, ypos);
	}

	public void reverseXDir() {
		
		if (xdir >= 1) {
			xdir = -1;
		} else {
			xdir = 1;
		}
		
		float ranfactor = random.nextFloat() * xdir;
		
		

	}

	public void reverseYDir() {

		if (ydir >= 1) {
			ydir = -1;
		} else {
			ydir = 1;
		}
		
		float ranfactor = random.nextFloat() * ydir;
//		System.out.printf("ydir: %f || ",ydir);
//		System.out.printf("ranFac: %f",ranfactor);
//		System.out.println("");
		
		
		
		ydir = -ranfactor;

	}

	public void setXDir(int dir) {
		this.xdir = dir;
	}

	public BoxCollider getCollider() {
		return collider;
	}
}
