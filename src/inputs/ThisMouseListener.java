package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.Game;
import main.GameStates;

public class ThisMouseListener implements MouseListener, MouseMotionListener {

	private Game game;
	
	public ThisMouseListener(Game game) {
		this.game = game;
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
			switch(GameStates.gameState) {
			case MENU:
					game.getMenu().mouseMoved(e.getX(), e.getY());
				break;
			case PLAYING:
				break;
			case SETTINGS:
				break;
			default:
				break;
			
			}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()== MouseEvent.BUTTON1) {
			System.out.println("Mouse Position: " + e.getX() + " : " + e.getY());
			
			switch(GameStates.gameState) {
			case MENU:
					game.getMenu().mouseClicked(e.getX(), e.getY());
				break;
			case PLAYING:
				break;
			case SETTINGS:
				break;
			default:
				break;
			
			}
		}
		
//		if (e.getButton() == MouseEvent.BUTTON1) {
//			System.out.println("Left mouse clicked");
//		}
//		else if (e.getButton() == MouseEvent.BUTTON3) {
//			System.out.println("Right mouse clicked");
//		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch(GameStates.gameState) {
		case MENU:
				game.getMenu().mousePressed(e.getX(), e.getY());
			break;
		case PLAYING:
			break;
		case SETTINGS:
			break;
		default:
			break;
		
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch(GameStates.gameState) {
		case MENU:
				game.getMenu().mouseReleased(e.getX(), e.getY());
			break;
		case PLAYING:
			break;
		case SETTINGS:
			break;
		default:
			break;
		
		}	

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
