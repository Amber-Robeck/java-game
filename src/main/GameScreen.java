package main;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class GameScreen extends JPanel {

	public GameScreen() {
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.GREEN);
		g.drawRect(50, 50, 100, 100);
		
	}
}
