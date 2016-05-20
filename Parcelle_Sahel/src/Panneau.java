import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel implements MouseListener, KeyListener {
	
	private ArrayList<Parcelle> parcelles = new ArrayList<Parcelle>();
	private Parcelle currentParcelle;
	private StartPoint currentStartPoint;
	private BasicStroke circleStroke = new BasicStroke();
	private DisplayManager dm; 
	private Random rand = new Random();
	
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
					parcelles.add(currentParcelle);
					currentParcelle.setColor(new Color(
							(int) (Math.abs(this.rand.nextInt() / (float)Integer.MAX_VALUE) * 255), 
							(int) (Math.abs(this.rand.nextInt() / (float)Integer.MAX_VALUE) * 255), 
							(int) (Math.abs(this.rand.nextInt() / (float)Integer.MAX_VALUE) * 255), 
							180));
					currentParcelle.setStartPoint(event.getX(), event.getY());
					currentStartPoint = currentParcelle.getStartPoint();
					this.currentStartPoint.setAttachedParcelle(currentParcelle);
					this.addMouseMotionListener(currentStartPoint);
					this.repaint();
				
				} else {	
					currentParcelle.checkEnd(event.getX(), event.getY());
					if(currentParcelle.isEnded()) {
						this.currentParcelle.drawFinalLine();
						this.removeMouseMotionListener(currentStartPoint);
						this.addMouseListener(currentParcelle);
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
				System.out.println(parcelles.get(0));
				
				break;
			}	
		} 
	}

	public void mouseEntered(MouseEvent event) {}


	public void mouseExited(MouseEvent arg0) {}


	public void mouseReleased(MouseEvent arg0) {}

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
