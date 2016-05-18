import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
	Panneau contentPan = new Panneau();
	
	public Fenetre() {
		this.setTitle("Default name");
		this.setLocationRelativeTo(null);
		this.setSize(720,405); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(contentPan);
		this.setVisible(true);
	}
	
	
}
