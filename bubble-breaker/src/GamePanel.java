import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements ActionListener {

	JPanel info;
	JLabel score;
	JPanel net;
	JMenuBar mb;
	JMenu m;
	JMenuItem i1;
	JMenuItem i2;
	JMenuItem i3;
	JMenuItem i4;	
	JMenuItem i5;
	JMenuItem i6;
	Game g;
	
	public GamePanel(Game g) {
		this.g = g;
		info = new JPanel();
		score = new JLabel();
		mb = new JMenuBar();
		m = new JMenu("Options");
		i1 = new JMenuItem("New");
		i2 = new JMenuItem("Exit");
		i3 = new JMenuItem("Top 10");
		i4 = new JMenuItem("Save");
		i5 = new JMenuItem("Undo");
		i6 = new JMenuItem("Open");
		//////////////////////////////////////////
		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		i5.addActionListener(this);
		i6.addActionListener(this);
		//////////////////////////////////////////
		mb.add(m);
		m.add(i1);
		m.add(i6);
		m.add(i4);
		m.add(i3);
		m.add(i5);
		m.add(i2);
		info.add(score);
		setLayout(new BorderLayout());
		add(info,BorderLayout.SOUTH);
		add(mb,BorderLayout.NORTH);
		updateNet();
	}
	
	public void updateNet(){
		if (net != null)
			remove(net);
		net = new JPanel();
		net.setLayout(new GridLayout(g.getSettings().getxBoardDimension(),g.getSettings().getyBoardDimension()));
		
		for (int i=g.getSettings().getxBoardDimension()-1; i >= 0 ; i--)
		{
			for (int j=0; j < g.getSettings().getyBoardDimension(); j++)
			{
				Bubble b = g.getBoard()[i][j];
				if(b != null )
					net.add(new BubblePanel(b, this));
				else
					net.add(new JPanel());
			}
		}
		score.setText("Points: " + g.getPoints());
		add(net,BorderLayout.CENTER);
		repaint();
		doLayout();
		revalidate();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == i1)
		{
			//new
			remove(net);
			g.startGame();
			updateNet();
			repaint();
			doLayout();
			revalidate();
		}
		else if (arg0.getSource() == i2)
		{
			//exit
			System.exit(0);
		}
		else if (arg0.getSource() == i3)
		{
			//top 10
		}
		else if (arg0.getSource() == i4)
		{
			//save
		}
		else if (arg0.getSource() == i5)
		{
			//undo
		}
		else if (arg0.getSource() == i6)
		{
			//open
		}
	}

}
