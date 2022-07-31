package scenes;

import java.awt.Graphics;

import helperMethods.LevelBuilder;
import main.Game;
import managers.TileManager;

public class Playing extends GameScene implements SceneMethods {
	
	private int[][] level;
	private TileManager tileManager;
	
	
	public Playing(Game game) {
		super(game);
		
		//The Level
		level = LevelBuilder.getLevelData();
		//Tile manager
		tileManager = new TileManager();
		
	}

	@Override
	public void render(Graphics g) {
		
		for(int y=0; y < level.length; y++) {
			for(int x=0; x< level[y].length; x++) {
				int id = level[y][x];
				g.drawImage(tileManager.getSprite(id), x*32, y*32, null );
			}
		}
		
	}

	@Override
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
