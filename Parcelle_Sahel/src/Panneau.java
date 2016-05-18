import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel implements MouseListener{
	
	private ArrayList<Parcelle> parcelles = new ArrayList<Parcelle>();
	private Parcelle currentParcelle;
	private static float[] dashParam = {20.0f, 20.0f};
	private static BasicStroke pathStroke = new BasicStroke(10.0f, BasicStroke.CAP_ROUND, 
				BasicStroke.JOIN_MITER, 10.0f,dashParam, 0.0f);
	private BasicStroke circleStroke = new BasicStroke();
	
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
		
		
		
		ListIterator<Parcelle> cur = parcelles.listIterator();
			
		while(cur.hasNext()){
			Parcelle elem = cur.next();
			elem.setColor(Color.cyan);
			g2d.setPaint(elem.getColor());
			g2d.setStroke(pathStroke);
			g2d.draw(elem.getPath());
			
			if (currentParcelle != null ) {
				g2d.setPaint(currentParcelle.getStartPoint().getPointColor());
				g2d.setStroke(circleStroke);
				g2d.draw(currentParcelle.getStartPoint().drawStartPoint(20));
			}
		}
	}

	public void mouseClicked(MouseEvent event) {}

	public void mousePressed(MouseEvent event) {
		if (currentParcelle == null) {
			currentParcelle = new Parcelle();
			parcelles.add(currentParcelle);
			
			currentParcelle.setStartPoint(event.getX(), event.getY());
			this.repaint();
		} else {
			this.repaint();
			
			currentParcelle.checkEnd(event.getX(), event.getY());
			if(currentParcelle.isEnded()) {
				this.currentParcelle.drawFinalLine();
				this.currentParcelle = null;	 
			} else { 
				this.currentParcelle.drawLineTo(event.getX(), event.getY());
			}
		}
	}


	public void mouseEntered(MouseEvent event) {}


	public void mouseExited(MouseEvent arg0) {}




	public void mouseReleased(MouseEvent arg0) {}
}
