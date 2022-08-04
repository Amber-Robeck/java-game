package userInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MyButton {
	
	public int x, y, width, height, id;
	private String text;
	private Rectangle bounds;
	private boolean mouseOver;
	private boolean mousePressed;
	
	public MyButton(String text, int x, int y, int width, int height) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = -1;
		
		initBounds();
		
	}
	
	public MyButton(String text, int x, int y, int width, int height, int id) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
		 
		initBounds();
		
	}
	
	private void initBounds() {
		this.bounds = new Rectangle(x, y, width, height);
		
	}

	public void draw(Graphics g) {
		
		//button body
		drawBody(g);
		
		//button border
		drawBorder(g);
		
		//button text
		drawtext(g);
		
	}
	
	private void drawBorder(Graphics g) {
		if (mousePressed) {
			g.setColor(Color.BLACK);
			g.drawRect(x, y, width, height);
			g.drawRect(x + 1, y + 1, width - 2, height - 2);
			g.drawRect(x + 2, y + 2, width - 4, height - 4);
		} else {
			g.setColor(Color.BLACK);
			g.drawRect(x, y, width, height);
		}
		
	}

	private void drawBody(Graphics g) {
		if(mouseOver) 
			g.setColor(Color.GRAY);
		else
			g.setColor(Color.white);
		g.fillRect(x, y, width, height);
		
		
	}

	private void drawtext(Graphics g) {
		//width and height of input string
		int w = g.getFontMetrics().stringWidth(text);
		int h = g.getFontMetrics().getHeight();
		g.drawString(text, x - w / 2 + width / 2, y + h / 2 + height / 2);
		
	}
	
	public void resetBooleans() {
		this.mouseOver = false;
		this.mousePressed = false;
	}
	
	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}

	
	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}
	
	public boolean isMouseOver() {
		return mouseOver;
	}
	
	public boolean isMousePressed() {
		return mousePressed;
	}

	public Rectangle getBounds() {
	return bounds;	
	}
	
	public int getId() {
		return id;
	}

}
