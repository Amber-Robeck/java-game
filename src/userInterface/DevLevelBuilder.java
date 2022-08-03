package userInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import objects.Tile;
import scenes.Playing;

import static main.GameStates.SetGameState;
import static main.GameStates.MENU;

public class DevLevelBuilder {

	private int x, y, width, height;
	private Playing playing;
	private MyButton buttonMenu;
	
	private ArrayList<MyButton> tileButtons = new ArrayList<>();
	
	public DevLevelBuilder(int x, int y, int width, int height, Playing playing) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.playing = playing;
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
		
		//loop over tiles
		int w = 50;
		int h = 50;
		int xStart=110;
		int yStart=650;
		int xOffset=(int) (w*1.1f);
		int i=0;
		
		for(Tile tile: playing.getTileManager().tiles) {
			tileButtons.add(new MyButton(tile.getName(), xStart + xOffset *i, yStart, w, h, i));
			i++;
		}
		
	}
	
	private void drawButtons(Graphics g) {
		buttonMenu.draw(g);
		
		
	//draw tiles in development bar
		drawTileButtons(g);
		
	}
	
	private void drawTileButtons(Graphics g) {
		for(MyButton b : tileButtons)
			g.drawImage(getButtonImg(b.getId()), b.x, b.y, b.width, b.height, null);
		
		
	}

	private BufferedImage getButtonImg(int id) {
		return playing.getTileManager().getSprite(id);
	}

	public void mouseClicked(int x, int y) {
		System.out.println("clicked");
		if (buttonMenu.getBounds().contains(x, y))
			SetGameState(MENU);
		
	}

	public void mouseMoved(int x, int y) {
		buttonMenu.setMouseOver(false);
		if (buttonMenu.getBounds().contains(x, y))
			buttonMenu.setMouseOver(true);
		
		
	}

	public void mousePressed(int x, int y) {
		if (buttonMenu.getBounds().contains(x, y))
			buttonMenu.setMousePressed(true);
		
	}
	
	public void mouseReleased(int x, int y) {
		buttonMenu.resetBooleans();
		
	}

}
