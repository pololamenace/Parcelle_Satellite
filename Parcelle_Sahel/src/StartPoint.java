import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class StartPoint extends Point2D.Float implements MouseListener {
	
	private Color pointColor; 
	
	public StartPoint() {}
	
	public StartPoint(int x, int y) {
		super(x,y);
	}
	
	public Ellipse2D drawStartPoint(int diam) {
		int x = (int) this.getX(), y = (int) this.getY();
		return new Ellipse2D.Float(x - diam/2, y - diam/2,diam,diam);
	}

	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}
}
