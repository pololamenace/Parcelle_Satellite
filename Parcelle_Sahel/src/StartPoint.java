import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;


public class StartPoint extends Point2D.Float implements MouseMotionListener{
	
	private Ellipse2D pointShape;
	private Ellipse2D overPointShape;
	
	private static int defaultPointDiam = 20;
	private static int overPointDiam = 25;
	private Color defaultPointColor = Color.green; 
	private Color overPointColor = Color.cyan;
	
	private boolean over = false;
	
	private Parcelle attachedParcelle;
	
	public StartPoint() {}
	
	public StartPoint(int x, int y) {
		super(x,y);
		this.pointShape = new Ellipse2D.Float(x - defaultPointDiam/2, y - defaultPointDiam/2,defaultPointDiam,defaultPointDiam);
		this.overPointShape = new Ellipse2D.Float(x - overPointDiam/2, y - overPointDiam/2,overPointDiam,overPointDiam);
	}
	
	public Color getPointColor() {
		if(!this.over)
			return this.defaultPointColor;
		else
			return this.overPointColor;
	}

	public Ellipse2D getPointShape() { 
		if(!this.over)
			return this.pointShape;
		else
			return this.overPointShape;
	}
	
	public boolean getOver() {
		return this.over;
	}
	
	public void setAttachedParcelle(Parcelle parc) {
		this.attachedParcelle = parc;
	}
	
	public void setPointShape(Ellipse2D pointShape) {
		this.pointShape = pointShape;
	}

	public void setDefaultPointColor(Color defaultPointColor) {
		this.defaultPointColor = defaultPointColor;
	}

	public void setOverPointColor(Color overPointColor) {
		this.overPointColor = overPointColor;
	}

	public void setOver(boolean over) {
		this.over = over;
	}

	public void mouseDragged(MouseEvent arg0) {}

	public void mouseMoved(MouseEvent event) {
		if (this.pointShape.contains(event.getX(), event.getY()) && !this.over) {
				this.over = true;
				this.attachedParcelle.getAttachedPan().repaint();
		}
		else if (!this.overPointShape.contains(event.getX(), event.getY()) && this.over){
				this.over = false;
				this.attachedParcelle.getAttachedPan().repaint();
		}
	}
}
