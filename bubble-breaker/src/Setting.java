import java.awt.Color;
import java.io.FileInputStream;
import java.util.Properties;



public class Setting {
	
	private int xBoardDimension;
	private int yBoardDimension;
	private Color[] colors;
	private int colorNum;
	private int bubbleLifeTime;
	private int bubbleRecurrence;
	
	
	public int getColorNum() {
		return colorNum;
	}

	public void setColorNum(int colorNum) {
		this.colorNum = colorNum;
	}

	public int getxBoardDimension() {
		return xBoardDimension;
	}

	public void setxBoardDimension(int xBoardDimension) {
		this.xBoardDimension = xBoardDimension;
	}

	public int getyBoardDimension() {
		return yBoardDimension;
	}

	public void setyBoardDimension(int yBoardDimension) {
		this.yBoardDimension = yBoardDimension;
	}

	public Color[] getColors() {
		return colors;
	}

	public void setColors(Color[] colors) {
		this.colors = colors;
	}

	public int getBubbleLifeTime() {
		return bubbleLifeTime;
	}

	public void setBubbleLifeTime(int bubbleLifeTime) {
		this.bubbleLifeTime = bubbleLifeTime;
	}

	public int getBubbleRecurrence() {
		return bubbleRecurrence;
	}

	public void setBubbleRecurrence(int bubbleRecurrence) {
		this.bubbleRecurrence = bubbleRecurrence;
	}
	
	public Setting(String path) {
		Properties p = loadUserProperties(path);
		this.xBoardDimension = Integer.parseInt(p.getProperty("x"));
		this.yBoardDimension = Integer.parseInt(p.getProperty("y"));
		this.colorNum = Integer.parseInt(p.getProperty("ColorNum"));
		this.colors = new Color[colorNum];
		this.bubbleLifeTime = Integer.parseInt(p.getProperty("bubbleLifeTime"));
		this.bubbleRecurrence = Integer.parseInt(p.getProperty("bubbleRecurrenceTime"));
		for (int i=0; i < colorNum; i++)
		{
			switch (p.getProperty("Color"+(i+1))) {
			case "red":
				colors[i] = Color.RED;
				break;
			case "green":
				colors[i] = Color.GREEN;
				break;
			case "blue":
				colors[i] = Color.blue;
				break;
			case "yellow":
				colors[i] = Color.YELLOW;
				break;
			case "orange":
				colors[i] = Color.ORANGE;
				break;
			case "pink":
				colors[i] = Color.PINK;
				break;
			default:
				break;
			}
			System.out.println(colors[i]);
		}
		
	}
	
	public Setting(int xBoardDimension, int yBoardDimension, Color[] colors,
			int colorNum, int bubbleLifeTime, int bubbleRecurrence) {
		super();
		this.xBoardDimension = xBoardDimension;
		this.yBoardDimension = yBoardDimension;
		this.colors = colors;
		this.colorNum = colorNum;
		this.bubbleLifeTime = bubbleLifeTime;
		this.bubbleRecurrence = bubbleRecurrence;
	}

	private Properties loadUserProperties(String path) {
			
		Properties userProperties = new Properties();
		
		try {
			userProperties.loadFromXML(new FileInputStream(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userProperties;
	}
	
	}