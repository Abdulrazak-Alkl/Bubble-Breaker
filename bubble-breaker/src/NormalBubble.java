import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JOptionPane;


public class NormalBubble extends Bubble {

	
	public NormalBubble(Game g, Color color, int x, int y) {
		super(g, color, x, y);
	}

	@Override
	public void press() {

		System.out.println("bubble pressed: " + getX() + "," + getY());
		int test = isGrouped();
		if (test != 1)
		{
			g.shift();
			if(g.gameIsOver())
				JOptionPane.showMessageDialog(null, "Game Over");	
		}
		else
		{
			g.getBoard()[getX()][getY()] = this;
			g.setScore(g.getScore()-1);
		}
	}

	@Override
	public Color getColor(Color c) {
		// TODO Auto-generated method stub
		return getColor();
	}

	@Override
	public void destroy() {
		g.getBoard()[getX()][getY()] = null;
		g.setScore(g.getScore()+1);
	}
	
}

