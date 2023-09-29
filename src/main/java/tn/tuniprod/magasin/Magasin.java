package tn.tuniprod.magasin;

import tn.tuniprod.produit.Produit;

public class Magasin {
    private long id;
    private String adresse;
    private final int CAPACITE_MAX = 50;
    private Produit[] produits;
    private int nbProduits = 0;

    public Magasin() {
    }

    public Magasin(long id, String adresse) {
        this.id = id;
        this.adresse = adresse;
        produits = new Produit[CAPACITE_MAX];

    }

    public Magasin(long id, String adresse, Produit[] produits) {
        this.id = id;
        this.adresse = adresse;
        setProduits(produits);
    }

    public long getId() {
        return this.id;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public long getNbProduits() {
        return this.nbProduits;
    }

    public Produit[] getProduits() {
        return this.produits;
    }

    public String getStringfiedProuit() {
        String s = "";
        for (int i = 0; i < nbProduits; i++) {
            s += "\n\tL'id est " + produits[i].getId() + ",de libelle " + produits[i].getLibelle() + ",de marque " + produits[i].getMarque() + " ,de prix " + produits[i].getPrix() + "et la date d expiration = " + produits[i].getDateExpiration();
        }
        return s;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNbProduits(int nbProduits) {
        this.nbProduits = nbProduits;
    }

    public void setProduits(Produit[] produits) {
        if (produits.length < CAPACITE_MAX) {
            for (int i = 0; i < produits.length; i++) {
                this.produits[i] = produits[i];
            }
        }
    }

    public boolean produitExists(Produit produit) {
        for (int i = 0; i < nbProduits; i++) {
            if (produit.comparer(produits[i]))
                return true;
        }
        return false;
    }

    public boolean addProduit(Produit produit) {
        if (nbProduits < CAPACITE_MAX && !this.produitExists(produit)) {
            produits[nbProduits] = produit;
            setNbProduits(this.nbProduits + 1);
            return true;
        }
        return false;
    }

    public boolean removeProduit(Produit produit) {
        if (nbProduits > 0 && this.produitExists(produit)) {
            for (int i = 0; i < nbProduits; i++) {
                if (produit.comparer(produits[i])) {
                    produits[i] = produits[nbProduits - 1];
                    setNbProduits(this.nbProduits - 1);
                    return true;
                }
            }
        }
        return false;
    }
    
    public static Magasin supMagasin(Magasin m1, Magasin m2) {
        return m1.getNbProduits() > m2.getNbProduits() ? m1 : m2;
    }

    public String afficher() {
        return "magasin.Magasin{" + "id=" + id +
                ", adresse=" + adresse +
                ", nbProduits=" + nbProduits +
                ", produits=" + this.getStringfiedProuit() +
                '}';
    }
}
