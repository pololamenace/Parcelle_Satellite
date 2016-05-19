import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.InputEvent;
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
	private StartPoint currentStartPoint;
	private BasicStroke circleStroke = new BasicStroke();
	private DisplayManager dm; 
	
	public Panneau(DisplayManager pdm) {
		super();
		this.addMouseListener(this);
		dm = pdm;
	}
	
	public void paintComponent(Graphics g){

		Graphics2D g2d = (Graphics2D) g;

		try {
			Image img = ImageIO.read(new File("./img/sahel.jpg"));
			g.drawImage(img, 0,0,this.getWidth(), this.getHeight(), this);
		} catch (IOException errImgIO) {
			errImgIO.printStackTrace();
		}
		
		ListIterator<Parcelle> cur = parcelles.listIterator();
		
		while(cur.hasNext()){
			Parcelle elem = cur.next();
			elem.setColor(new Color(0,255,0,180));
			g2d.setPaint(elem.getColor());
			g2d.setStroke(elem.getStroke());
			if (elem.isSelected()) 
				g2d.fill(elem.getPath());
			else
				g2d.draw(elem.getPath());
			
			g2d.draw(elem.getPath());
		}
		
		if (currentStartPoint != null ) {
			g2d.setPaint(currentStartPoint.getPointColor());
			g2d.setStroke(circleStroke);
			if (currentStartPoint.getOver() == true) {
				g2d.fill(currentStartPoint.getPointShape());
			} else {
				g2d.draw(currentStartPoint.getPointShape());
			}
		}
	}

	public void mouseClicked(MouseEvent event) {}

	public void mousePressed(MouseEvent event) {
		switch(event.getModifiers()) {
			case InputEvent.BUTTON1_MASK: {
				if (currentParcelle == null) {
					currentParcelle = new Parcelle();
					currentParcelle.setAttachedPan(this);
					this.addMouseListener(currentParcelle);
					parcelles.add(currentParcelle);
					currentParcelle.setStartPoint(event.getX(), event.getY());
					currentStartPoint = currentParcelle.getStartPoint();
					this.addMouseMotionListener(currentStartPoint);
					this.repaint();
				
				} else {	
					currentParcelle.checkEnd(event.getX(), event.getY());
					if(currentParcelle.isEnded()) {
						this.currentParcelle.drawFinalLine();
						this.removeMouseMotionListener(currentStartPoint);
						this.currentStartPoint = null; 
						this.repaint();
						dm.createDialogue(currentParcelle, "Please enter name for new parcel");
						this.currentParcelle = null;	
					} else { 
						this.currentParcelle.drawLineTo(event.getX(), event.getY());
						this.repaint();
					}
				}
				break; 
			}
			case (InputEvent.BUTTON2_MASK): {
				break; 
			}
			case (InputEvent.BUTTON3_MASK): {
				break;
			}	
		} 
	}

	public void mouseEntered(MouseEvent event) {}


	public void mouseExited(MouseEvent arg0) {}


	public void mouseReleased(MouseEvent arg0) {}
}
