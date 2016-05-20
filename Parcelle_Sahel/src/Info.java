
public class Info {
	
	private String title = new String();
	private String description = new String();
	private Parcelle attachedParcelle; 
	
	public Info(Parcelle parc) {
		this.attachedParcelle = parc; 
	}
	
	public Info(Parcelle parc, String pTitre, String pDescription) {
		this.attachedParcelle = parc; 
		this.title = pTitre;
		this.description = pDescription;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String titre) {
		this.title = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Parcelle getAttachedParcelle() {
		return attachedParcelle;
	}

	public void setAttachedParcelle(Parcelle attachedParcelle) {
		this.attachedParcelle = attachedParcelle;
	}
	
	public String toString(){
		return this.title + " : "  + this.description;
	}
	
}
