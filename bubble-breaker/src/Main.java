
public class Main {
	
	
	
	
	public static void main(String[] args) {
		Game g = new Game("properties");
		GUI gui = new GUI(g);
		
		/*g.startGame();
		
		for (int i=g.getSettings().getxBoardDimension()-1; i >= 0 ; i--)
		{
			for (int j=0; j < g.getSettings().getyBoardDimension(); j++)
			{
				System.out.print(g.getBoard()[i][j].getX() + "," + g.getBoard()[i][j].getY() + "," + g.getBoard()[i][j] + "   ");
			}
			System.out.println();
		}
		
		g.getBoard()[1][0].press();
		System.out.println();
		
		for (int i=g.getSettings().getxBoardDimension()-1; i >= 0 ; i--)
		{
			for (int j=0; j < g.getSettings().getyBoardDimension(); j++)
			{
				if (g.getBoard()[i][j] != null)
					System.out.print(g.getBoard()[i][j].getX() + "," + g.getBoard()[i][j].getY() + "," + g.getBoard()[i][j] + "   ");
				else
					System.out.print("null    ");
			}
			System.out.println();
		}
		g.getBoard()[1][1].press();
		System.out.println();
		
		for (int i=g.getSettings().getxBoardDimension()-1; i >= 0 ; i--)
		{
			for (int j=0; j < g.getSettings().getyBoardDimension(); j++)
			{
				if (g.getBoard()[i][j] != null)
					System.out.print(g.getBoard()[i][j].getX() + "," + g.getBoard()[i][j].getY() + "," + g.getBoard()[i][j] + "   ");
				else
					System.out.print("null    ");
			}
			System.out.println();
		}*/
	}
}
