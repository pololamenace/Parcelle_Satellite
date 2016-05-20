import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
	private Panneau contentPan;
	
	public Fenetre(DisplayManager dm) {
		
		this.setTitle("Default name");
		this.setLocationRelativeTo(null);
		this.setExtendedState(this.getExtendedState() | MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPan = new Panneau(dm);
		this.setContentPane(contentPan);
		this.setVisible(true);
		this.setResizable(false);

	}

	public Panneau getContentPan() {
		return contentPan;
	}
	
	
	
	
}
