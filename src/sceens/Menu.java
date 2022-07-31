package sceens;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import main.Game;
import userInterface.MyButton;
import static main.GameStates.*;

public class Menu extends GameScene implements SceneMethods{

	private BufferedImage img;
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	private Random random;
	
	private MyButton buttonPlaying, buttonSettings, buttonQuit;
	
	public Menu(Game game) {
			super(game);
			random = new Random();
			importImg();
			loadSprites();
			initButtons();
	}

	private void initButtons() {
		
		int w = 150;
		int h = w / 3;
		int x = 640 / 2 - w / 2;
		int y = 150;
		int yOffset = 100;
		
		
		buttonPlaying = new MyButton("Play", x, y, w, h);
		buttonSettings = new MyButton("Settings", x, y + yOffset, w, h);
		buttonQuit = new MyButton("Quit", x, y + yOffset * 2, w, h);
	}

	@Override
	public void render(Graphics g) {
			
		drawButtons(g);
			
			
//			loop for all sprites
//			for(int y=0; y<20; y++) {
//				for(int x=0; x<20; x++) {
//					
//					g.drawImage(sprites.get(getRandomInt()), x*32, y*32, null);
//				}
//			}
//			
	}
		
		
	private void drawButtons(Graphics g) {
			buttonPlaying.draw(g);
			buttonSettings.draw(g);
			buttonQuit.draw(g);
			
	}

	private void importImg() {
			
		InputStream is = getClass().getResourceAsStream("/spriteatlas.png");
			
			try {
				img = ImageIO.read(is);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
		
	private void loadSprites() {
			
		for (int y = 0; y<3; y++) {
			for(int x = 0; x<9; x++) {
				sprites.add(img.getSubimage(x*32, y*32, 32, 32));
				}
			}
			
	}
		
	private int getRandomInt() {
		return random.nextInt(27);
	}

	@Override
	public void mouseClicked(int x, int y) {
		if(buttonPlaying.getBounds().contains(x, y)) {
			SetGameState(PLAYING);
		} else if (buttonSettings.getBounds().contains(x, y)) {
			SetGameState(SETTINGS);
		} else if (buttonQuit.getBounds().contains(x, y)) {
			System.exit(0);
		}
		
	}

	@Override
	public void mouseMoved(int x, int y) {
		//reset hover
		buttonPlaying.setMouseOver(false);
		buttonSettings.setMouseOver(false);
		buttonQuit.setMouseOver(false);
		
		if(buttonPlaying.getBounds().contains(x, y)) {
			buttonPlaying.setMouseOver(true);
		} else if (buttonSettings.getBounds().contains(x, y)) {
			buttonSettings.setMouseOver(true);
		} else if (buttonQuit.getBounds().contains(x, y)) {
			buttonQuit.setMouseOver(true);
		}
		
	}

	@Override
	public void mousePressed(int x, int y) {
		//reset in mouse released
		if(buttonPlaying.getBounds().contains(x, y)) {
			buttonPlaying.setMousePressed(true);
		} else if (buttonSettings.getBounds().contains(x, y)) {
			buttonSettings.setMousePressed(true);
		} else if (buttonQuit.getBounds().contains(x, y)) {
			buttonQuit.setMousePressed(true);
		}
		
	}

	@Override
	public void mouseReleased(int x, int y) {
		resetButtons();
		
	}

	private void resetButtons() {
		buttonPlaying.resetBooleans();
		buttonSettings.resetBooleans();
		buttonQuit.resetBooleans();
	}

}
