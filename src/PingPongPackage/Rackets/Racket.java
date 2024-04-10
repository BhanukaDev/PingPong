package PingPongPackage.Rackets;

import java.awt.Color;
import java.awt.Graphics;

import PingPongPackage.BoxCollider;
import PingPongPackage.TableSetting;

public class Racket {
	private BoxCollider box;
	public Graphics g;
	int screenHeight = TableSetting.getTableSize()[1];
	int unitSize = TableSetting.getUnitSize();

	int borderSize = TableSetting.getBorder();

	public Racket(int x, int y, int w, int h) {
		box = new BoxCollider(x, y, w, h);
	}

	public Racket(int x, int y, int w, int h, Graphics g) {
		box = new BoxCollider(x, y, w, h);
		this.g = g;

	}

	public void showGraphic(Graphics g) {
		box.showGraphic(g);
	}

	public void showGraphic(Graphics g, Color color) {
		box.showGraphic(g, color);
	}

	public void showGraphic() {
		box.showGraphic(this.g);
	}

	public BoxCollider getCollider() {
		return box;
	}

	public void move(int dir, int speed) {
		float ypos = box.getPosition()[1] + dir * speed * unitSize;

		if (dir == -1 && ypos < box.getSize()[1] / 2 + borderSize) {
			ypos = box.getSize()[1] / 2 + borderSize;
		} else if (dir == 1 && ypos > screenHeight - box.getSize()[1] + box.getSize()[1] / 2 - borderSize) {
			ypos = screenHeight - box.getSize()[1] + box.getSize()[1] / 2 - borderSize;
		}

		float xpos = box.getPosition()[0];
		box.setPosition(xpos, ypos);
	}

	public float[] getPosition() {
		return box.getPosition();
	}

	public void setGraphics(Graphics g) {
		this.g = g;
	}

	public Graphics getGraphics() {
		return g;
	}
}
