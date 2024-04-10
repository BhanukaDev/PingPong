package PingPongPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import PingPongPackage.Rackets.Direction;
import PingPongPackage.Rackets.Racket;

public class GamePanel extends JPanel implements ActionListener {

	int screenWidth = TableSetting.getTableSize()[0];
	int screenHeight = TableSetting.getTableSize()[1];
	int unitSize = TableSetting.getUnitSize();
	int borderSize = TableSetting.getBorder();

	BoxCollider borderup = new BoxCollider(screenWidth / 2, borderSize / 2, screenWidth, borderSize);
	BoxCollider borderdown = new BoxCollider(screenWidth / 2, screenHeight - borderSize / 2, screenWidth, borderSize);
	BoxCollider borderleft = new BoxCollider(-screenWidth / 2, screenHeight / 2, screenWidth, screenHeight);
	BoxCollider borderright = new BoxCollider(screenWidth * 1.5f, screenHeight / 2, screenWidth, screenHeight);

	Racket mracket = new Racket(unitSize * 4, screenHeight / 2, unitSize * 4, unitSize * 15);
	Racket aracket = new Racket(screenWidth - unitSize * 4, screenHeight / 2, unitSize * 4, unitSize * 15);

	Ball ball = new Ball(screenWidth / 2, screenHeight / 2, unitSize * 4);

	Timer timer;

	Direction MRacketDir = Direction.Stop;

	GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setFocusable(true);
		this.setBackground(Color.black);
		this.addKeyListener(new MKeyAdapter());
		timer = new Timer(20, this);
		timer.start();

	}

	public void paintComponent(Graphics g) {
		drawBorder(g);

		mracket.showGraphic(g, Color.white);
		aracket.showGraphic(g, Color.white);
		ball.showGraphic(g, Color.white);

	}

	public void drawBorder(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, screenWidth, screenHeight);
		borderup.showGraphic(g, Color.white);
		borderdown.showGraphic(g, Color.white);
		borderleft.showGraphic(g, Color.black);
		borderright.showGraphic(g, Color.black);

	}

	public void drawGrid(Graphics g) {
		int[] grid = TableSetting.getGrid();
		int unitsize = TableSetting.getUnitSize();
		int height = TableSetting.getTableSize()[1];
		int width = TableSetting.getTableSize()[0];

		g.setColor(Color.green);
		for (int i = 1; i < grid[0]; i++) {
			g.drawLine(unitsize * i, 0, unitsize * i, height);
		}

		for (int i = 1; i < grid[1]; i++) {
			g.drawLine(0, unitsize * i, width, unitsize * i);
		}
	}

	public void actionPerformed(ActionEvent e) {
		int dir = MRacketDir == Direction.Up ? -1 : MRacketDir == Direction.Down ? 1 : 0;
		mracket.move(dir, 1);
		aracket.move(dir, 1);
		ball.move();

		if (ball.getCollider().isHit(mracket.getCollider()) || ball.getCollider().isHit(aracket.getCollider())) {

			if (ball.getCollider().hitTop()) {
				System.out.println("Top");
			}
			if (ball.getCollider().hitBottom()) {
				System.out.println("Bottom");
			}
			if (ball.getCollider().hitLeft()) {
				ball.reverseXDir();
			}
			if (ball.getCollider().hitRight()) {
				ball.reverseXDir();
			}
		}

		if (borderup.isHit(ball.getCollider()) || borderdown.isHit(ball.getCollider())) {
			ball.reverseYDir();
		}
		
		if (borderleft.isHit(ball.getCollider()) || borderright.isHit(ball.getCollider())) {
			ball.reverseXDir();
		}

		repaint();
	}

	public class MKeyAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				MRacketDir = Direction.Up;
				break;
			case KeyEvent.VK_DOWN:
				MRacketDir = Direction.Down;
				break;
			default:
				MRacketDir = Direction.Stop;
				break;

			}
		}

//		public void keyReleased(KeyEvent e) {
//			MRacketDir = Direction.Stop;
//		}
	}
}
