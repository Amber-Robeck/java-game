package scenes;

import java.awt.Graphics;

import helperMethods.LevelBuilder;
import main.Game;
import managers.TileManager;
import userInterface.DevLevelBuilder;
import userInterface.MyButton;

public class Playing extends GameScene implements SceneMethods {
	
	private int[][] level;
	private TileManager tileManager;
	
	private MyButton buttonMenu;
	
	private DevLevelBuilder devLevelBuilder;
	
	public Playing(Game game) {
		super(game);
		
		
		//The Level
		level = LevelBuilder.getLevelData();
		//Tile manager
		tileManager = new TileManager();
		//Level builder
		devLevelBuilder = new DevLevelBuilder(0, 640, 640, 100, this);
		
	}


	@Override
	public void render(Graphics g) {
		
		for(int y=0; y < level.length; y++) {
			for(int x=0; x< level[y].length; x++) {
				int id = level[y][x];
				g.drawImage(tileManager.getSprite(id), x*32, y*32, null );
			}
		}
		
		devLevelBuilder.draw(g);
	}

	public TileManager getTileManager() {
		return tileManager;
	}

	@Override
	public void mouseClicked(int x, int y) {
		System.out.println("clicked");
		devLevelBuilder.mouseClicked(x,y);
//		if(y >= 640) {
//			devLevelBuilder.mouseClicked(x,y);
//		}
		
	}

	@Override
	public void mouseMoved(int x, int y) {
		if(y >= 640) {
			devLevelBuilder.mouseMoved(x,y);
		}
		
	}

	@Override
	public void mousePressed(int x, int y) {
		if(y >= 640) {
			devLevelBuilder.mousePressed(x,y);
		}
		
	}

	@Override
	public void mouseReleased(int x, int y) {
		
		devLevelBuilder.mouseReleased(x,y);
		
	}

}
