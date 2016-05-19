import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class Dialogue extends JDialog implements MouseListener,KeyListener{
	protected JPanel container = new JPanel();
	protected JTextField textbox = new JTextField(); 
	protected static JLabel desc = new JLabel("Name"); 
	protected static JButton btn = new JButton("OK");
	protected static Font defFont = new Font("Arial", Font.PLAIN, 12);
	protected static Parcelle parc = new Parcelle();
	
	public Dialogue(JFrame parent, String title, Parcelle parc){
		super(parent, title, true);
		
		this.setSize(400,50);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.setFont(defFont);
		
		desc.setForeground(Color.DARK_GRAY);
		desc.setPreferredSize(new Dimension(50,30));
		
		textbox.setPreferredSize(new Dimension(300,30));
		textbox.addKeyListener(this);
		
		btn.setPreferredSize(new Dimension(50,50));
		btn.setFont(defFont);
		
		container.add(desc, BorderLayout.WEST);
		container.add(textbox, BorderLayout.CENTER);
		container.add(btn, BorderLayout.EAST);
		
		this.setContentPane(container);
		this.setVisible(true);
	}

	public abstract void keyPressed(KeyEvent e);/* */

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}
}
