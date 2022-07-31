package main;

import javax.swing.JPanel;

import inputs.KeyboardListener;
import inputs.ThisMouseListener;

import java.awt.Dimension;
import java.awt.Graphics;

public class GameScreen extends JPanel {
	
	private Game game;
	private Dimension size;
	
	private ThisMouseListener thisMouseListener;
	private KeyboardListener keyboardListener;

	public GameScreen(Game game) {
		this.game = game;
		
		setPanelSize();
	}
	
	public void initInputs() {
		thisMouseListener = new ThisMouseListener();
		keyboardListener = new KeyboardListener();
		
		addMouseListener(thisMouseListener);
		addMouseMotionListener(thisMouseListener);
		addKeyListener(keyboardListener);
		
		requestFocus();
	}
	
	
	
	private void setPanelSize() {
		size = new Dimension(640,640);
		
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
	}



	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		game.getRender().render(g);
	}
}
