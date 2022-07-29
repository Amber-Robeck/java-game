package main;

import javax.swing.JFrame;

import inputs.KeyboardListener;
import inputs.ThisMouseListener;
import sceens.Menu;
import sceens.Playing;
import sceens.Settings;

public class Game extends JFrame implements Runnable {
	
	private GameScreen gameScreen;
	private Thread gameThread;
	
	private final double FPS_SET = 120.0;
	private final double UPS_SET = 60.0;
	
	private ThisMouseListener thisMouseListener;
	private KeyboardListener keyboardListener;
	
	private Render render;
	private Menu menu;
	private Playing playing;
	private Settings settings;
	
	public Game() {
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		initClasses();
		
		add(gameScreen);
		pack();
		setVisible(true);
		
	}
	
	private void initClasses() {
		render = new Render(this);
		gameScreen = new GameScreen(this);
		menu = new Menu(this);
		playing = new Playing(this);
		settings = new Settings(this);
		
	}

	private void initInputs() {
		thisMouseListener = new ThisMouseListener();
		keyboardListener = new KeyboardListener();
		
		addMouseListener(thisMouseListener);
		addMouseMotionListener(thisMouseListener);
		addKeyListener(keyboardListener);
		
		requestFocus();
	}
	
	private void start() {
		gameThread = new Thread(this) {};
		
		gameThread.start();
		
	}

	private void updateGame() {
	
//		System.out.println("game updated");
		
	}

	public static void main(String[] args) {
		System.out.println("Start of the game");
		
		Game game = new Game();
		game.initInputs();
		game.start();
	}

	@Override
	public void run() {
		
		double timePerFrame = 1000000000.0/FPS_SET;
		double timePerUpdate = 1000000000.0/UPS_SET;
		long lastFrame = System.nanoTime();
		long lastTimeCheck = System.currentTimeMillis();
		long lastUpdate = System.nanoTime();
		
		int frames = 0;
		int updates = 0;
		
		long now;
		
		while(true) {
			
			now = System.nanoTime();
			
			//Render
			if(now - lastFrame >= timePerFrame) {

				repaint();
				lastFrame = now;
				frames++;
			}
			
			//Update
			if(now - lastUpdate >= timePerUpdate) {
				updateGame();
				lastUpdate = now;
				updates++;
			}
			
			//Status
			if(System.currentTimeMillis()- lastTimeCheck >= 1000) {
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;
				lastTimeCheck = System.currentTimeMillis();
			}
			
			
		}
		
	}
	
	//Getters and Setters
	
	public Render getRender() {
		return render;
	}

	public Menu getMenu() {
		return menu;
	}

	public Playing getPlaying() {
		return playing;
	}

	public Settings getSettings() {
		return settings;
	}


	
	
}
