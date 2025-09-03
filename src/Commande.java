public class Commande {

    //Déclaration des variables d'instances
	private String identifiant;
	private int quantite;
	
	//Constructeur
	public Commande (String id, int qt) {
		this.identifiant = id;
		this.quantite = qt;
	}
	
	//Accesseurs
	public String getIdentifiant() {
		return this.identifiant;
	}
	public int getQuantite() {
		return this.quantite;
	}
	
	//Mutateurs
	public void setIdentifiant(String id) {
		this.identifiant = id;
	}
	public void setQuantite(int qt) {
		this.quantite = qt;
	}
	
	
	//toString
	public String toString() {
		return " identifiant= " + this.identifiant + " quantite vendue= " + Integer.toString(quantite);
	}

}
