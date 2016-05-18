import java.awt.Color;
import java.awt.geom.GeneralPath;

public class Parcelle {
	private GeneralPath path;
	private StartPoint startPoint;
	private Color colorParam;
	private static float distMax = 50f;
	private boolean ended = false;
	
	public Parcelle() {}
	
	public Color getColor() {
		return this.colorParam;
	}
	
	public void drawLineTo(int posX, int posY){
		try {
			this.path.lineTo(posX, posY);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public void drawFinalLine() {
		this.path.lineTo(this.startPoint.getX(), this.startPoint.getY());
	}
	
	public void setStartPoint(int posX, int posY){
		this.path = new GeneralPath();
		this.path.moveTo(posX, posY); 
		this.startPoint = new StartPoint(posX, posY);
	}
	
	public StartPoint getStartPoint(){
		return this.startPoint;
	}
	
	public GeneralPath getPath() {
		return this.path;
	}
	
	public void setColor(Color pColor) {
		this.colorParam = pColor; 
	}
	
	public boolean checkEnd(int posX, int posY) {
		if (this.ended == false)
			this.ended = (this.startPoint.distance(posX, posY) < distMax);
		return this.ended; 
	}
	
	public boolean isEnded() {
		return this.ended;
	}
	/*
	public Graphics2D drawStartPoint(Graphics2D g, int diametre){
		int x =(int) this.startPoint.getX(), y = (int) this.startPoint.getY();
		g.drawOval(x - diametre/2, y - diametre/2, diametre,diametre);
		return g;
	}*/
}
