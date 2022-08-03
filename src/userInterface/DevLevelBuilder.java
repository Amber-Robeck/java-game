package userInterface;

import java.awt.Color;
import java.awt.Graphics;

public class DevLevelBuilder {

	private int x, y, width, height;
	
	private MyButton buttonMenu;
	
	public DevLevelBuilder(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		//Menu
		initMenu();
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, width, height);
		
		// render buttons
		drawButtons(g);
	}
	
	private void initMenu() {
		buttonMenu = new MyButton("Menu", 2, 642, 100, 30);
		
	}
	
	private void drawButtons(Graphics g) {
		buttonMenu.draw(g);
		
	}
	
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseReleased(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
