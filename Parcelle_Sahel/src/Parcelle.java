import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.GeneralPath;
import java.util.Random;

public class Parcelle implements MouseListener {
	private GeneralPath path;
	private Random rand = new Random(); 
	private Color colorParam;

	private StartPoint startPoint;
	private static float[] defaultDashParam = {10f,10f};
	private static float defaultSize = 5.0f;
	private static float[] selectedDashParam = {14f, 14f};
	private static float selectedSize = 7.0f;
	private BasicStroke pathStroke = new BasicStroke(defaultSize, BasicStroke.CAP_ROUND, 
			BasicStroke.JOIN_MITER, 10.0f,defaultDashParam, 0.0f);

	private static float distMax = 25f;
	
	private boolean ended = false;
	private boolean selected = false; 
	
	private Panneau attachedPan;
	
	private Info infos; 
	
	// Constructeur
	public Parcelle() {
		infos = new Info(this) ;		
		System.out.println((int) (Math.abs(this.rand.nextInt() / (float)Integer.MAX_VALUE) * 255));

	}
	/* ** ** ** ** */
	
	
	public void drawLineTo(int posX, int posY){
		try {
			this.path.lineTo(posX, posY);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public void drawFinalLine() {
		this.path.lineTo(this.startPoint.getX(), this.startPoint.getY());
		this.startPoint = null;
	}
	
	public boolean checkEnd(int posX, int posY) {
		if (this.ended == false)
			this.ended = (this.startPoint.distance(posX, posY) < distMax);
		return this.ended; 
	}
	
	/* *** MouseListener *** */ 
	public void mouseClicked(MouseEvent event) {
		if (event.getModifiers() == InputEvent.BUTTON3_MASK) {
			if (this.path.contains(event.getX(), event.getY())) {
				if (this.selected == false) { 
					this.selected = true;
					this.pathStroke = new BasicStroke(selectedSize, BasicStroke.CAP_ROUND, 
							BasicStroke.JOIN_MITER, 10.0f,selectedDashParam, 0.0f);
				} else {
					this.selected = false;
					this.pathStroke = new BasicStroke(defaultSize, BasicStroke.CAP_ROUND, 
							BasicStroke.JOIN_MITER, 10.0f,defaultDashParam, 0.0f);
				} 
				this.attachedPan.repaint();
			}
		}
	}


	public void mouseEntered(MouseEvent arg0) {}


	public void mouseExited(MouseEvent arg0) {}


	public void mousePressed(MouseEvent arg0) {}


	public void mouseReleased(MouseEvent arg0) {}
	/* *** *** *** */
	
	/* *** SET *** */ 
	public void setStartPoint(int posX, int posY){
		this.path = new GeneralPath();
		this.path.moveTo(posX, posY); 
		this.startPoint = new StartPoint(posX, posY);
		this.startPoint.setAttachedParcelle(this);
		this.startPoint.setDefaultPointColor(this.colorParam);
	}
	
	public void setColor(Color pColor) {
		this.colorParam = pColor; 
	}
	
	public void setAttachedPan(Panneau pan) {
		this.attachedPan = pan;
	}
	
	/* *** *** *** */
	/* *** GET *** */
	public StartPoint getStartPoint(){
		return this.startPoint;
	}
	
	public GeneralPath getPath() {
		return this.path;
	}
	
	public Color getColor() {
		return this.colorParam;
	}
	
	public BasicStroke getStroke() {
		return this.pathStroke;
	}
	
	public Panneau getAttachedPan() {
		return this.attachedPan;
	}
	
	public boolean isEnded() {
		return this.ended;
	}
	
	public boolean isSelected() {
		return this.selected;
	}
	
	public Info getInfos() {
		return this.infos;
	}
	/* *** *** *** */
/*	public String toString() {
		return this.infos.toString();
	}*/


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attachedPan == null) ? 0 : attachedPan.hashCode());
		result = prime * result
				+ ((colorParam == null) ? 0 : colorParam.hashCode());
		result = prime * result + (ended ? 1231 : 1237);
		result = prime * result + ((infos == null) ? 0 : infos.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result
				+ ((pathStroke == null) ? 0 : pathStroke.hashCode());
		result = prime * result
				+ ((startPoint == null) ? 0 : startPoint.hashCode());
		return result;
	}

	

}
