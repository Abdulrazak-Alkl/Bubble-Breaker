
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;



public class Game {
	
	private Setting settings;
	private Bubble[][] board;
	private int Score;
	private Timer t;
	private HideExpireBubbles task;
	
	public Game(String settingsFile)
	{
		this.settings = new Setting(settingsFile);
		board = new Bubble[settings.getxBoardDimension()][settings.getyBoardDimension()];
	}
	
	public void generateBoard()
	{
		Random r1 = new Random();
		Random r2 = new Random();
		int n;
		int c;
		for (int i=0; i < settings.getxBoardDimension() ; i++)
		{
			for (int j=0; j < settings.getyBoardDimension() ; j++)
			{
				c = r2.nextInt(settings.getColorNum());
				n = r1.nextInt(300);
				if (n<200)
					board[i][j] = new NormalBubble(this, settings.getColors()[c], i, j);
				else if (n<250 && n>200)
					board[i][j] = new BombBubble(this, settings.getColors()[c], i, j);
				else
					board[i][j] = new TransparentBubble(this, settings.getColors()[c], i, j);
			}
			
		}
	}
	
	public void shift()
	{
		shiftDown();
		shiftRight();
	}
	
	private void shiftDown() 
	{
		for (int j = 0 ; j < getSettings().getyBoardDimension() ; j++)
		{
			int a = 0;
			int b = 0;
			while (a < getSettings().getxBoardDimension() && b < getSettings().getxBoardDimension())
			{
				if(board[a][j] == null)
					a++;
				else
				{
					if(board[a][j] != board[b][j])
					{
						board[b][j] = board[a][j];
						board[b][j].setX(b);
						board[a][j] = null;
					}
					b++;
					a++;
				}
			}
		}
	}
	
	private void shiftRight() 
	{
		for (int a = 0 ; a < getSettings().getyBoardDimension() ; a++)
			if(board[0][a] == null)
			{
				for (int j = a ; j > 0 ; j--)
				{
					for (int i = 0 ; i < getSettings().getxBoardDimension() && board[i][j-1] != null ; i++)
					{
						board[i][j] = board[i][j-1];
						board[i][j].setY(j);
						board[i][j-1] = null;
					}
				}
				generateColumeLeft();
			}
	}
	
	private void generateColumeLeft() 
	{
		Random r1 = new Random();
		Random r2 = new Random();
		int n;
		int c;
		for (int i = 0 ; i < getSettings().getxBoardDimension() ; i++)
		{
			c = r2.nextInt(settings.getColorNum());
			n = r1.nextInt(30);
			if (n<20)
				board[i][0] = new NormalBubble(this, settings.getColors()[c], i, 0);
			else if (n<25 && n>20)
				board[i][0] = new BombBubble(this, settings.getColors()[c], i, 0);
			else
				board[i][0] = new TransparentBubble(this, settings.getColors()[c], i, 0);
		}
	}
	
	public void startGame()
	{
		Score = 0;
		t = new Timer();
		task = new HideExpireBubbles(this);
		generateBoard();
		t.schedule(task, getSettings().getBubbleLifeTime()*1000);
		
	}
	
	public boolean gameIsOver()
	{
		for (int i=0; i < settings.getxBoardDimension() ; i++)
		{
			for (int j=0; j < settings.getyBoardDimension() ; j++)
			{
				if(getBoard()[i][j] != null && (getBoard()[i][j].getClass() == BombBubble.class || detect(getBoard()[i][j]) > 1))
					return false;
			}	
		}
		return true;
	}

	private int detect(Bubble b)
	{
		int x = b.getX();
		int y = b.getY();
		int count = 0;
		Bubble temp = b;
		b = null;
		count++;
		if(y != getSettings().getyBoardDimension()-1 && getBoard()[x][y+1] != null && temp.getColor() == getBoard()[x][y+1].getColor(temp.getColor()))
			count ++;
		if(y != 0 && getBoard()[x][y-1] != null && temp.getColor() == getBoard()[x][y-1].getColor(temp.getColor()))
			count ++;
		if(x != getSettings().getxBoardDimension()-1 && getBoard()[x+1][y] != null && temp.getColor() == getBoard()[x+1][y].getColor(temp.getColor()))
			count ++;
		if(x != 0 && getBoard()[x-1][y] != null &&  temp.getColor() == getBoard()[x-1][y].getColor(temp.getColor()))
			count ++;
		b = temp;
		return count;
	}
	
	public Setting getSettings() {
		return settings;
	}

	public void setSettings(Setting settings) {
		this.settings = settings;
	}

	public Bubble[][] getBoard() {
		return board;
	}

	public void setBoard(Bubble[][] board) {
		this.board = board;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public int getPoints() {
		return getScore()*(getScore()-1);
	}
}
