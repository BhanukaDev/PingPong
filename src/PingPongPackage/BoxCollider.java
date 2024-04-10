package PingPongPackage;

import java.awt.Color;
import java.awt.Graphics;

import PingPongPackage.Rackets.Direction;

public class BoxCollider extends Collider {

	private float width;
	private float height;

	private boolean hitLeft = false;
	private boolean hitRight = false;
	private boolean hitTop = false;
	private boolean hitBottom = false;

	public BoxCollider(float xpos, float ypos, float width, float height) {
		super(xpos, ypos);
		this.width = width;
		this.height = height;
	}

	public void setHitDirections(boolean t, boolean r, boolean b, boolean l) {
		this.hitLeft = l;
		this.hitRight = r;
		this.hitTop = t;
		this.hitBottom = b;

	}

	@Override
	public boolean isHit(BoxCollider box) {
		float xpos = getPosition()[0];
		float ypos = getPosition()[1];

		float _xpos = box.getPosition()[0];
		float _ypos = box.getPosition()[1];
		float _width = box.getSize()[0];
		float _height = box.getSize()[1];

		boolean overlapx = false;
		boolean overlapy = false;

		hitLeft = false;
		hitRight = false;
		hitTop = false;
		hitBottom = false;

		float dx = Math.abs(xpos - _xpos);
		float dy = Math.abs(ypos - _ypos);

		if (dx < (width + _width) / 2) {
			overlapx = true;
			if (xpos < _xpos) {
				hitRight = true;
			} else {
				hitLeft = true;
			}
		}

		if (dy < (height + _height) / 2) {
			overlapy = true;
			if (ypos < _ypos) {
				hitTop = overlapx && overlapy;
			} else {
				hitBottom = overlapx && overlapy;

			}
		}

		box.setHitDirections(hitTop, hitRight, hitBottom, hitLeft);

		return overlapx && overlapy;
	}

	public boolean hitLeft() {
		return hitLeft;
	}

	public boolean hitRight() {
		return hitRight;
	}

	public boolean hitTop() {
		return hitTop;
	}

	public boolean hitBottom() {
		return hitBottom;
	}

	public float[] getSize() {
		return new float[] { width, height };
	}

	@Override
	public void showDebug(Graphics g) {

		if (!debugging)
			return;
		float xpos = getPosition()[0];
		float ypos = getPosition()[1];

		g.setColor(Color.green);
		g.drawLine((int) (xpos - width / 2), (int) (ypos - height / 2), (int) (xpos + width / 2),
				(int) (ypos - height / 2));

		g.drawLine((int) (xpos - width / 2), (int) (ypos + height / 2), (int) (xpos + width / 2),
				(int) (ypos + height / 2));

		g.drawLine((int) (xpos - width / 2), (int) (ypos - height / 2), (int) (xpos - width / 2),
				(int) (ypos + height / 2));

		g.drawLine((int) (xpos + width / 2), (int) (ypos - height / 2), (int) (xpos + width / 2),
				(int) (ypos + height / 2));

	}

	@Override
	public void showGraphic(Graphics g) {
		if (debugging)
			return;
		float xpos = getPosition()[0];
		float ypos = getPosition()[1];

		g.setColor(Color.green);
		g.fillRect((int) (xpos - width / 2), (int) (ypos - height / 2), (int) width, (int) height);

	}

	@Override
	public void showGraphic(Graphics g, Color color) {
		if (debugging)
			return;
		float xpos = getPosition()[0];
		float ypos = getPosition()[1];
		g.setColor(color);
		g.fillRect((int) (xpos - width / 2), (int) (ypos - height / 2), (int) width, (int) height);

	}

}
