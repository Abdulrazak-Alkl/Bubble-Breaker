import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BubblePanel extends JPanel implements MouseListener {
	
	Bubble b;
	GamePanel gp;
	JLabel label;
	
	public BubblePanel(Bubble b, GamePanel gp) {
		super();
		this.b = b;
		this.gp = gp;
		
		if (b.getClass() == NormalBubble.class)
			label = new JLabel("");
		else if (b.getClass() == BombBubble.class)
			label = new JLabel("B");
		else
			label = new JLabel("T");
		
		add(label);
		setBackground(b.getColor());
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		b.press();
		gp.updateNet();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
