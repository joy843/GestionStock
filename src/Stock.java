import java.util.Stack;

public class Stock {
	
	//Déclaration des variables d'instances
	private int nbrMaxProduit;				//Nombre maximum de produit dans le stock
	private Produit listeProduit[];			//Tableau de tous les produits
	private int nbrProduit;					//Nombre de produits dans le stock
	
	//Constructeur
	public Stock(int nb) {
		this.nbrMaxProduit = nb;
		this.listeProduit = new Produit[nb];
		this.nbrProduit = 0;
	}
	
	//Accesseur
	public Produit[] getListeProduit() {
		return this.listeProduit;
	}
	
	//Méthode d'ajout de produit
	public void ajouterProduit(Produit p) {
		this.listeProduit[this.nbrProduit++] = p;		//ajout dans le tableau de produits
		System.out.println("... Ajout effectué ");
	}
	
	//Méthode de recherche de produit
	public Produit rechercherProduit(String id) {
		for (int i=0; i< this.nbrProduit; i++) {
			if(this.listeProduit[i].getIdentifiant().compareTo(id) == 0) {
				return this.listeProduit[i];
			}
		}
		return null;
	}
	
	//Méthode d'affichage de produit
	public void afficherProduit() {
		for (int i=0; i< this.nbrProduit; i++) {
			if(this.listeProduit[i].getClass().getName() == "Produitperissable") {         //Verifier si le produit est périssable pour afficher la date d'expiration
				System.out.println(((Produitperissable)this.listeProduit[i]).toString());
			}
			else System.out.println(this.listeProduit[i].toString());
			
		}
			
			
	}
	
	//Modification d'un produit
	public void modifierProduit(Produit p) {
		int cmp = 0;
		for (int i=0; i< this.nbrProduit; i++) {
			if(this.listeProduit[i].getIdentifiant().compareTo(p.getIdentifiant()) == 0) {
				this.listeProduit[i] = p;
				System.out.println("... Modification effectuée ");
				cmp++;
			}
		}
		if(cmp == 0) {
			System.out.println("... Aucun produit ne possède cet identifiant ");
		}
	}
	
	//Supprimer un produit
	public void supprimerProduit(String id) {
		int index = -1;
		for (int i=0; i< this.nbrProduit; i++) {
			if(this.listeProduit[i].getIdentifiant().compareTo(id) == 0) {
				index = i;
			}
		}
		if(index < 0 ) {
			System.out.println("... Le produit n existe pas dans le stock ");
		}
		else {
			this.nbrProduit--;
			//Décaler les éléments du tableau vers la gauche à partir de l'indice du produit à supprimer
			for (int i=index; i< this.nbrProduit; i++) {
				this.listeProduit[i] = this.listeProduit[i+1];
			}
			System.out.println("... Suppression effectuée ");
			
		}
		
	}
	
	
	//Méthode d'affichage des produits en rupture de stock
		public void produitEnRupture() {
			for (int i=0; i< this.nbrProduit; i++) {
				if(this.listeProduit[i].getQuantite() < 3) {
					if(this.listeProduit[i].getClass().getName() == "Produitperissable") {         //Verifier si le produit est périssable pour afficher la date d'expiration
						System.out.println(((Produitperissable)this.listeProduit[i]).toString());
					}
					else System.out.println(this.listeProduit[i].toString());
				}
				
				
			}
				
				
		}
	

	
	
}
