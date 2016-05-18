import java.awt.Color;
import java.awt.geom.GeneralPath;

public class Parcelle {
	private GeneralPath path;
	private Color colorParam;
	private float[] dashParam;
	private static float distMax = 5f;
	
	public Parcelle() {}
	
	public float[] getDashParam() {
		return this.dashParam;
	}
	
	public Color getColor() {
		return this.getColor();
	}
	
	public void drawLineTo(int posX, int posY){
		try {
			this.path.lineTo(posX, posY);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public void setStartPoint(int posX, int posY){
		this.path = new GeneralPath();
		this.path.moveTo(posX, posY); 
	}
	
	public void getDistMax()
	
	public boolean isEnded(int posX, int posY) {
		return (this.path.getCurrentPoint().distance(posX, posY) <= this.distMax);
	}
}
