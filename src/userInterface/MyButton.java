package userInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MyButton {
	
	private int x, y, width, height;
	private String text;
	private Rectangle bounds;
	
	public MyButton(String text, int x, int y, int width, int height) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		initBounds();
		
	}
	
	private void initBounds() {
		this.bounds = new Rectangle(x, y, width, height);
		
	}

	public void draw(Graphics g) {
		
		//button body
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
		
		//button border
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
		
		//button text
		drawtext(g);
		
	}
	
	private void drawtext(Graphics g) {
		//width and height of input string
		int w = g.getFontMetrics().stringWidth(text);
		int h = g.getFontMetrics().getHeight();
		g.drawString(text, x - w / 2 + width / 2, y + h / 2 + height / 2);
		
	}

	public Rectangle getBounds() {
	return bounds;	
	}

}
