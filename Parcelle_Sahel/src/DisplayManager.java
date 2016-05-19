

public class DisplayManager {

	private Fenetre drawWin;
	private DialogueNom dial;
	
	public DisplayManager() {}
	
	public void createFenetre() {
		drawWin = new Fenetre(this); 
	}
	
	public void createDialogue(Parcelle forParcelle, String windowTitle) {
		if(dial == null) {
			dial = new DialogueNom(drawWin, windowTitle ,forParcelle);
		} else {
			dial.setVisible(true);
		}
	}
}
