package main;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends JPanel {
	
	private Random random;
	private BufferedImage img;
	private long lastTime;
	private int frames;
	
//	private double timePerFrame;
//	private long lastFrame;
	
	private ArrayList<BufferedImage> sprites = new ArrayList<>();

	public GameScreen(BufferedImage img) {
		this.img = img;
		
		loadSprites();
		
		random = new Random();
		
//		timePerFrame = 1000000000.0/60.0;
	}
	
	
	private void loadSprites() {
		
		for (int y = 0; y<3; y++) {
			for(int x = 0; x<9; x++) {
				sprites.add(img.getSubimage(x*32, y*32, 32, 32));
			}
		}
		
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		for(int y=0; y<20; y++) {
			for(int x=0; x<20; x++) {
				
				g.drawImage(sprites.get(getRandomInt()), x*32, y*32, null);
			}
		}
		
//		if(System.nanoTime() - lastFrame >= timePerFrame) {
//
//			lastFrame = System.nanoTime();
//			repaint();
//		}else {
//			//we do nothing
//		}
		
		callFPS();
		
	}
		
		private void callFPS() {
			frames++;
			if(System.currentTimeMillis() - lastTime >= 1000) {
				System.out.println("FPS: " + frames);
				frames = 0;
				lastTime = System.currentTimeMillis();
			}
			
		}
		
	
	private int getRandomInt() {
		return random.nextInt(27);
	}
	
	private Color getRandomColor() {
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		
		return new Color(r, g, b);
	}
}
