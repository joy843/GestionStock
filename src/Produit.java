public class Produit {
	
	//Déclaration des variables d'instances
	private String identifiant;
	private String nom;
	private int quantite;
	private double prixUnitaire;
	
	//Conctructeur
	public Produit(String id, String name, int qt, double prix) {
		this.identifiant = id;
		this.nom = name;
		this.quantite = qt;
		this.prixUnitaire = prix;
	}
	
	//Accesseurs
	public String getIdentifiant() {
		return this.identifiant;
	}
	public String getNom() {
		return this.nom;
	}
	public int getQuantite() {
		return this.quantite;
	}
	public double getPrix() {
		return this.prixUnitaire;
	}
	
	// Mutateurs
	public void setIdentifiant(String id) {
		this.identifiant = id;
	}
	public void setNom(String name) {
		this.nom = name;
	}
	public void setQuantite(int qt) {
		this.quantite = qt;
	}
	public void setPrix(double p) {
		this.prixUnitaire = p;
	}
	
	//toString
	public String toString() {
		return " - " + this.identifiant + " nom= " + this.nom + " quantite= " + Integer.toString(this.quantite) + " prix= " + Double.toString(this.prixUnitaire);
	}
	

}
