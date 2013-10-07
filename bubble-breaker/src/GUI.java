import java.awt.Dimension;

import javax.swing.JFrame;




public class GUI extends JFrame {
	public GUI(Game g) {
		
		g.startGame();
		GamePanel gp = new GamePanel(g);
		add(gp);
		
		setVisible(true);
		setMinimumSize(new Dimension(500, 600));
		setSize(500, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


}
