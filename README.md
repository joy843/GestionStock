# GestionStock

Projet réalisé dans le cadre du cours **Structures de données et algorithmes (INF1004)**.  
Ce projet implémente un **simulateur de gestion de stock** en Java permettant de gérer des produits, des commandes et des ventes en utilisant différentes structures de données (**piles, files, tableaux**).

# Contexte

La gestion de stock est un problème fondamental en informatique de gestion.  
Ce projet applique les concepts de structures de données en les traduisant dans une application console :

- Gestion des produits avec leurs informations (nom, quantité, prix, date d’expiration, etc.).  
- Organisation du stock en **pile** ou en **file** selon le type de produit.  
- Gestion d’une **file de commandes** à traiter dans l’ordre d’arrivée.  

# Fonctionnalités

- Ajout, suppression, modification et recherche de produits.  
- Gestion du stock :  
  - Produits **non périssables** stockés en **pile**.  
  - Produits **périssables** stockés en **file**.  
- Gestion des commandes en attente avec une **file FIFO**.  
- Enregistrement des ventes et mise à jour du stock.  
- Génération de rapports sur :  
  - Les ventes réalisées.  
  - Les produits en rupture.  
  - Les produits les plus vendus.  

# Pour l’exécution

Assurez-vous d’avoir **Java (JDK)** installé. Puis exécutez :

git clone https://github.com/joy843/GestionStock.git
cd GestionStock/src
javac *.java
java Gestionnaire