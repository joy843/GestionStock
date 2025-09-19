//Création de la classe ProduitPerissable qui hérite de Produit
public class Produitperissable extends Produit{
	
	//Déclaration d'une variable d'instance
	private String dateExp;
	
	//Déclaration d'un constructeur prenant en compte la date d'expiration
	public Produitperissable(String id, String name, int qt, double prix, String d) {
		super(id,name,qt,prix);
		this.dateExp = d;
	}
	
	//Accesseur
	public String getDateExp() {
		return this.dateExp;
	}
	
	//Mutateur
	public void setDateExp(String d) {
		this.dateExp = d;
	}
	
	//Méthode toString tenant compte de la date d'expiration
	public String toString() {
		return super.toString() + " date exp= " + this.dateExp;
	}

}
