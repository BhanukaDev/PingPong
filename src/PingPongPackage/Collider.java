package PingPongPackage;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Collider {

	private float xpos;
	private float ypos;
	
	public boolean debugging = false;

	Collider(float xpos, float ypos) {
		this.xpos = xpos;
		this.ypos = ypos;
	}
	
	public void isDebugging(boolean debugging) {
		this.debugging = debugging;
	}

	public abstract void showDebug(Graphics g);
	
	public abstract void showGraphic(Graphics g);
	
	public abstract void showGraphic(Graphics g, Color color);

	public abstract boolean isHit(BoxCollider box);

	public void setPosition(float xpos, float ypos) {
		this.xpos = xpos;
		this.ypos = ypos;
	}

	public float[] getPosition() {
		return new float[] { xpos, ypos };
	}

}
