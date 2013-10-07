import java.awt.Color;


public class TransparentBubble extends Bubble {

	public TransparentBubble(Game g, Color color, int x, int y) {
		super(g, color, x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void press() {
		//do nothing
	}
	
	public Color getColor(Color c) {
		setColor(c);
		return c;
	}

	@Override
	public void destroy() {
		g.getBoard()[getX()][getY()] = null;
		g.setScore(g.getScore()+1);
	}
	
	
}
