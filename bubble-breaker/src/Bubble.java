import java.awt.Color;
import java.util.LinkedList;



public abstract class Bubble {
	
	private Color color;
	private int x;
	private int y;
	protected Game g;
	
	
	public Game getG() {
		return g;
	}

	public void setG(Game g) {
		this.g = g;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Bubble(Game g, Color color, int x, int y) {
		super();
		this.g = g;
		this.color = color;
		this.x = x;
		this.y = y;
	}
	
	public abstract void destroy();
	public abstract void press();
	public abstract Color getColor(Color c);
	
	@Override
	public String toString() {
		String s="";
		Color c = getColor();
		if(c == Color.RED)
			s = "R";
		else if (c == Color.GREEN)
			s = "G";
		else if (c == Color.BLUE)
			s = "B";
		else if (c == Color.YELLOW)
			s = "Y";
		return s;
	}
	
	public int isGrouped()
	{
		int x = getX();
		int y = getY();
		int count = 0;
		destroy();
		count++;
		if(y != g.getSettings().getyBoardDimension()-1 && g.getBoard()[x][y+1] != null && getColor() == g.getBoard()[x][y+1].getColor(getColor()))
		{
			System.out.println("destroy: " + g.getBoard()[x][y+1].getX() + "," + g.getBoard()[x][y+1].getY());
			count += g.getBoard()[x][y+1].isGrouped();
		}
		if(y != 0 && g.getBoard()[x][y-1] != null && getColor() == g.getBoard()[x][y-1].getColor(getColor()))
		{
			System.out.println("addB: " + g.getBoard()[x][y-1].getX() + "," + g.getBoard()[x][y-1].getY());
			count += g.getBoard()[x][y-1].isGrouped();
		}
		if(x != g.getSettings().getxBoardDimension()-1 && g.getBoard()[x+1][y] != null && getColor() == g.getBoard()[x+1][y].getColor(getColor()))
		{
			System.out.println("addB: " + g.getBoard()[x+1][y].getX() + "," + g.getBoard()[x+1][y].getY());
			count += g.getBoard()[x+1][y].isGrouped();
		}
		if(x != 0 && g.getBoard()[x-1][y] != null &&  getColor() == g.getBoard()[x-1][y].getColor(getColor()))
		{
			System.out.println("addB: " + g.getBoard()[x-1][y].getX() + "," + g.getBoard()[x-1][y].getY());
			count += g.getBoard()[x-1][y].isGrouped();
		}
		return count;
	}

}