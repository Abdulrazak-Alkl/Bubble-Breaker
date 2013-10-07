import java.util.TimerTask;


public class HideExpireBubbles extends TimerTask {

	Game g;
	
	
	public HideExpireBubbles(Game g) {
		super();
		this.g = g;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0; i < g.getSettings().getxBoardDimension() ; i++)
		{
			for (int j=0; j < g.getSettings().getyBoardDimension() ; j++)
			{
				if(g.getBoard()[i][j].getClass() == TransparentBubble.class || g.getBoard()[i][j].getClass() == BombBubble.class)
					g.getBoard()[i][j] = new NormalBubble(g, g.getBoard()[i][j].getColor(),g.getBoard()[i][j].getX(),g.getBoard()[i][j].getY());
			}
		}
	}

	
}
