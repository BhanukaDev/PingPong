package PingPongPackage;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	GameFrame() {
		this.add(new GamePanel());
		this.setTitle("Ping Pong");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
}
