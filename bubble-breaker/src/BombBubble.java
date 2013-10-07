import java.awt.Color;

import javax.swing.JOptionPane;


public class BombBubble extends Bubble {

	public BombBubble(Game g, Color color, int x, int y) {
		super(g, color, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		
		int x = getX();
		int y = getY();
		int bx = g.getSettings().getxBoardDimension()-1;
		int by = g.getSettings().getyBoardDimension()-1;
		g.getBoard()[x][y] = null;
		g.setScore(g.getScore()+1);
		
		if (y != 0 && g.getBoard()[x][y-1] != null)
			g.getBoard()[x][y-1].destroy();
		
		if (y != by && g.getBoard()[x][y+1] != null)
			g.getBoard()[x][y+1].destroy();
		
		if (x != 0 && g.getBoard()[x-1][y] != null)
			g.getBoard()[x-1][y].destroy();
		
		if (x != bx && g.getBoard()[x+1][y] != null)
			g.getBoard()[x+1][y].destroy();
		
		if (x != bx && y != by && g.getBoard()[x+1][y+1] != null)
			g.getBoard()[x+1][y+1].destroy();
		
		if (x != 0 && y != 0 && g.getBoard()[x-1][y-1] != null)
			g.getBoard()[x-1][y-1].destroy();
		
		if (x != bx && y != 0 && g.getBoard()[x+1][y-1] != null)
			g.getBoard()[x+1][y-1].destroy();
		
		if (x != 0 && y != by && g.getBoard()[x-1][y+1] != null)
			g.getBoard()[x-1][y+1].destroy();
	}

	@Override
	public void press() {
		destroy();	
		g.shift();
		if(g.gameIsOver())
			JOptionPane.showMessageDialog(null, "Game Over");
	}

	@Override
	public Color getColor(Color c) {
		return getColor();
	}
	
}
