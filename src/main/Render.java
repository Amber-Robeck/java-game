package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Render {

	private GameScreen gameScreen;
	private BufferedImage img;
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	private Random random;
	
	public Render(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		random = new Random();
		importImg();
		loadSprites();
	}
	
	public void render(Graphics g) {
		
		switch(GameStates.gameState) {
		
		case MENU:
			for(int y=0; y<20; y++) {
				for(int x=0; x<20; x++) {
					
					g.drawImage(sprites.get(getRandomInt()), x*32, y*32, null);
				}
			}
			
			break;
		case PLAYING:
			
			break;
		case SETTINGS:
			
			break;
		}
		
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
}
