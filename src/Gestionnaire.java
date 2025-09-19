import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
public class Gestionnaire {

	//algorithme récursif pour trier les produits les plus vendus
	public static void triBulle(Commande[] listeVente, int n) {
		  if (n == 1) return;
		  Commande temp;

		  for (int i = 0; i < n - 1; i++) {
		    if (listeVente[i].getQuantite() < listeVente[i + 1].getQuantite()) {
		    	temp = listeVente[i];
		    	listeVente[i] = listeVente[i+1];
		    	listeVente[i+1] = temp;
		    }
		  }

		  triBulle(listeVente, n - 1);
	}
	
	
	
	public static void main(String[] args) {
		int choix = 0;
		String id;
		Scanner sc = new Scanner(System.in);
		Stock stock = new Stock(1000);    			//Création d'un stock de maximum 1000 produits
		Stack<Commande> ventes = new Stack<>();    // Pile contenant l'historique des ventes
		
		do {
			
			System.out.println("\n\nMenu Principal\n ||||||||||||||||||||||||||||");
			System.out.println(" 1-  Ajouter produits       |");
			System.out.println(" 2-  Afficher produits      |");
			System.out.println(" 3-  Rechercher produit     |");
			System.out.println(" 4-  Modifier produits      |");
			System.out.println(" 5-  Supprimer produits     |");
			System.out.println(" 6-  Nouvelles commandes    |");
			System.out.println(" 7-  Historique de ventes   |");
			System.out.println(" 8-  Gestion des rapports   |");
			System.out.println("\n 0- Quitter\n");
			System.out.print("Que voulez faire? ");
			choix = sc.nextInt();
			
			try {
				
				switch(choix) {
				
					
				case 1:
					String ligne = "";
					System.out.println("\n.... Entrer les informations des produits comme suit: ");
					System.out.println("Identifiant,nom,quantite,prix,date expiration(si perissable) ou Identifiant,nom,quantite,prix(si non perissable)      puis valider");
					sc.nextLine();
					ligne = sc.nextLine();
					
					
					Stack<Produit> pile = new Stack<>();		//pile permettant de stocker les produits non périssables
					Queue<Produitperissable> file = new LinkedList<>();		//file permettant de stocker les produits périssables
					
					do {
						

							String [] chaine ;
							chaine = ligne.split(",");				//découpage de la ligne en utilisant la virgule comme séparateur
							
							if(stock.rechercherProduit(chaine[0]) == null) {		//vérification de la non existance de l'identifiant dans le stock
								
								if(chaine.length == 4) {	//Vérification de si il s'agit d'un produit non périssable	(4 entrées)
									Produit p  = new Produit(chaine[0], chaine[1], Integer.valueOf(chaine[2]), Double.valueOf(chaine[3]));
									pile.add(p);			//ajout du produit non périssable dans la pile de Produit
								}
								
								else if(chaine.length == 5) {	//vérification de si il s'agit d'un produit périssable		(5 entrées)
									Produitperissable p  = new Produitperissable(chaine[0], chaine[1], Integer.valueOf(chaine[2]), Double.valueOf(chaine[3]), chaine[4]);
									file.add(p);			//ajout du produit périssable dans la file de Produitperissable	
								}
								
								else 	break;	//arreter l'ajout si la ligne saisie par l'utilisateur n'est pa correcte
								
							}
							else System.out.println(" ...  Identifiant "+ chaine[0] + " deja existant");
							
							
							ligne = sc.nextLine();					//Lecture de la ligne
							
		
						
					}while(ligne != "");
					
					//Enregistrement des produits périssables et non périssables dans le stock
					while(!file.isEmpty()) {
						stock.ajouterProduit(file.remove());
					}
					while(!pile.isEmpty()) {
						stock.ajouterProduit(pile.pop());
					}
					
					break;
					
				
				case 2: 
					System.out.println("\n.... Liste des produits enregistrés: ");
					stock.afficherProduit();		//Affichage des produits
					
					break;
					
					
				case 3:
					sc.nextLine();
					System.out.print("\n.... Entrer l'identifiant du produit que vous recherchez:  ");
					id = sc.nextLine();
					
					if(stock.rechercherProduit(id) != null) {     //vérification de l'existance du produit
						if(stock.rechercherProduit(id).getClass().getName() == "Produitperissable") {
							System.out.println(((Produitperissable)stock.rechercherProduit(id)).toString());  //affichage avec date d'expiration
						}
						else System.out.print(stock.rechercherProduit(id).toString());		//affichage produit non périssable
					}
					else System.out.println("... Le produit n existe pas dans le stock ");
					
					break;
					
				case 4:
					
					
					ligne = "";
					System.out.println("\n.... Entrer l identifiant et les nouvelles informations des produits comme suit: ");
					System.out.println("Identifiant,nom,quantite,prix,date expiration(si existe)       puis valider sur ENTER");
					sc.nextLine();
					ligne = sc.nextLine();
					
					
					do {
						

							String [] chaine ;
							chaine = ligne.split(",");				//découpage de la ligne en utilisant la virgule comme séparateur
							
							
							if(stock.rechercherProduit(chaine[0]) != null) {	//vérification de l'existance du produit
								if(chaine.length == 4) {
									Produit p  = new Produit(chaine[0], chaine[1], Integer.valueOf(chaine[2]), Double.valueOf(chaine[3]));
									stock.modifierProduit(p);				// Modification
								}
								else if(chaine.length == 5) {
									Produitperissable p  = new Produitperissable(chaine[0], chaine[1], Integer.valueOf(chaine[2]), Double.valueOf(chaine[3]), chaine[4]);
									stock.modifierProduit(p);
								}
								else break;
								
							}
							else {
								System.out.println(" ...  L\' dentifiant "+ chaine[0] + " n \'existe pas");
								break;
							}
							
							
							ligne = sc.nextLine();	//Lecture de la ligne suivante
							
		
						
					}while(ligne != "");
					
					break;
					
					
					
				case 5: 
					sc.nextLine();
					System.out.print("\n.... Entrer l'identifiant du produit que vous voulez supprimer:  ");
					id = sc.nextLine();
					stock.supprimerProduit(id);
					break;
					
				
				case 6:	
					ligne = "";
					System.out.println("\n.... Nouvelles commandes: ");
					System.out.println("Saisissez comme suit:   Identifiant,quantite      puis ajouter la commande sur ENTER");
					sc.nextLine();
					ligne = sc.nextLine();
					
					
					Queue<Commande> fileCommande = new LinkedList<>();		//file des commandes en attentes
					
					do {
						

							String [] chaine ;
							chaine = ligne.split(",");				//découpage de la ligne en utilisant la virgule comme séparateur
							
							
							if(stock.rechercherProduit(chaine[0]) != null) {
								if(chaine.length == 2) {
									Commande c = new Commande(chaine[0], Integer.valueOf(chaine[1]));
									fileCommande.add(c);			//ajout dans la file d'attente
								}
								
								
							}
							else {
								System.out.println(" ...  Identifiant "+ chaine[0] + " n existe pas");
								break;
							}
							
							
							ligne = sc.nextLine();//Lecture de la ligne
							
		
						
					}while(ligne != "");
					
					System.out.println(" Voulez vous valider les commandes?  0 (pour non) et 1 (pour oui)");
					int ch = sc.nextInt();
					
					if(ch==1) {
						
						//Validation des commandes
						while(!fileCommande.isEmpty()) {
							Commande cv = fileCommande.remove();
							if(stock.rechercherProduit(cv.getIdentifiant()) != null) {
								
								// Vérifier si la quantite du produit dans le stock est supérieur ou egale a celle de la commande
								if(stock.rechercherProduit(cv.getIdentifiant()).getQuantite() >= cv.getQuantite()) {
									int quantiteRestante = stock.rechercherProduit(cv.getIdentifiant()).getQuantite() - cv.getQuantite();   
									
									stock.rechercherProduit(cv.getIdentifiant()).setQuantite(quantiteRestante);	//mise à jour de l'état de produit
									System.out.println(cv.getIdentifiant() + " vendu!");
									
									
									ventes.add(cv);			//Ajout de la commande dans la pile des ventes
								}
								else System.out.println("Quantite de produit insufisante pour le produit d identifiant " + cv.getIdentifiant());
								
							}
							
							
							
							
						}
						
					}
					else System.out.println("  Commandes annulees!!!");
					
					
					break;
					
					
				case 7:
					System.out.println("\n.... Liste des ventes enregistrés: ");
					
					//Affichage de toutes le commandes vendues.
					for(int i=ventes.size()-1; i>=0; i--) {
						System.out.println(ventes.get(i).toString());
					}
				
					break;
					
					
				case 8:
					System.out.println("\n\n     Sous Menu\n     |||||||||||||||||||||||||||||||||||||||||");
					System.out.println("     81-  les produits les plus vendus       |");
					System.out.println("     82-  les produits en rupture de stock   |");
					System.out.print("\nQue voulez verifier? ");
					int choix2 = sc.nextInt();
					
					switch(choix2) {
					
					
					case 81:
						
						System.out.println("\n.... Liste des produits les plus vendus ");
						int n = ventes.size();
						Commande[] tabVente = new Commande[n] ;  //Création d'un tableau contenant toutes les ventes
						for(int i=0; i<n; i++) {
							tabVente[i] = ventes.get(i);
						}
						triBulle(tabVente, n);			//Appel de la fonction récursive de tri
						for(int i=0; i<n; i++) {
							System.out.println(tabVente[i].toString());
						}
						break;
						
						
					case 82:
						System.out.println("\n.... Liste des produits en rupture de stock ");
						stock.produitEnRupture();
						break;
					}
					
					
					
					break;
				
				
				}
				
			}catch(Exception e) {
				
			}
			
		}while(choix !=0);
		
		System.out.println("\nMerci d'avoir utilisé notre service client de gestion des stocks de produits de notre entreprise. Au revoir !");
		
		
		
	}

}
