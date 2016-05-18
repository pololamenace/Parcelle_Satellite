import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.GeneralPath;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel implements MouseListener{
	
	Parcelle[] parcelles;
	GeneralPath path;
	float[] dashParam = {20.0f, 20.0f};
	
	public Panneau() {
		super();
		this.addMouseListener(this);
	}
	
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		try {
			Image img = ImageIO.read(new File("./img/cool-wallpaper-1.jpg"));
			g.drawImage(img, 0,0,this.getWidth(), this.getHeight(), this);
		} catch (IOException errImgIO) {
			errImgIO.printStackTrace();
		}
		
		
		g2d.setPaint(Color.green);
		
		g2d.setStroke(new BasicStroke(10.0f, BasicStroke.CAP_ROUND, 
						BasicStroke.JOIN_MITER, 10.0f,dashParam, 0.0f));
		if (path != null) 
			g2d.draw(path);
	}

	public void mouseClicked(MouseEvent event) {
		if (path == null) {
			path = new GeneralPath();
			path.moveTo(event.getX(), event.getY());
		} else {
			this.path.lineTo(event.getX(), event.getY());
			this.repaint();
		}
	}

	public void mousePressed(MouseEvent event) {
		if (path == null) {
			path = new GeneralPath();
			path.moveTo(event.getX(), event.getY());
		} else {
			this.path.lineTo(event.getX(), event.getY());
			this.repaint();
		}
	}


	public void mouseEntered(MouseEvent event) {
		
	}


	public void mouseExited(MouseEvent arg0) {
		
	}




	public void mouseReleased(MouseEvent arg0) {
		
	}
}
