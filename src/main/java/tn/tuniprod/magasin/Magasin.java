package tn.tuniprod.magasin;

import tn.tuniprod.employe.Employe;
import tn.tuniprod.produit.Produit;

import java.util.Arrays;

public class Magasin {
    private final int CAPACITE_MAX = 50;
    private final int CAPACITE_MAX_EMPLOYE = 20;

    private long id;
    private String libelle;
    private String adresse;
    private Produit[] produits;
    private int nbProduits;
    private static long nbTotalProduits;
    private Employe[] employes;
    private int nbEmployes;


    public Magasin() {
        produits = new Produit[CAPACITE_MAX];
        employes = new Employe[CAPACITE_MAX_EMPLOYE];
    }

    public Magasin(long id, String libelle, String adresse) {
        this.id = id;
        this.libelle = libelle;
        this.adresse = adresse;
        produits = new Produit[CAPACITE_MAX];
        employes = new Employe[CAPACITE_MAX_EMPLOYE];
    }

    public long getId() {
        return this.id;
    }

    public String getLibelle() {
        return this.libelle;
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

    public long getNbEmployes() {
        return this.nbEmployes;
    }

    public Employe[] getEmployes() {
        return this.employes;
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

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNbProduits(int nbProduits) {
        this.nbProduits = nbProduits;
    }

    public void setNbEmployes(int nbEmployes) {
        this.nbEmployes = nbEmployes;
    }

    public boolean produitExists(Produit produit) {
        for (int i = 0; i < nbProduits; i++) {
            if (produit.comparer(produits[i])) return true;
        }
        return false;
    }

    public boolean addProduit(Produit produit) {
        if (nbProduits < CAPACITE_MAX && !this.produitExists(produit)) {
            produits[nbProduits] = produit;
            setNbProduits(this.nbProduits + 1);
            Magasin.nbTotalProduits++;
            return true;
        }
        return false;
    }

    public boolean removeProduit(Produit produit) {
        if (nbProduits > 0 && this.produitExists(produit)) {
            for (int i = 0; i < nbProduits; i++) {
                if (produit.comparer(produits[i])) {
                    for (int j = i; j < nbProduits - 1; j++) {
                        produits[j] = produits[j + 1];
                    }
                    setNbProduits(this.nbProduits - 1);
                    Magasin.nbTotalProduits--;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean employeExists(Employe employe) {
        for (int i = 0; i < nbEmployes; i++) {
            if (employe.comparer(employes[i])) return true;
        }
        return false;
    }

    public boolean addEmploye(Employe employe) {
        if (nbEmployes < CAPACITE_MAX_EMPLOYE && !this.employeExists(employe)) {
            employes[nbEmployes] = employe;
            setNbEmployes(this.nbEmployes + 1);
            return true;
        }
        return false;
    }

    public boolean removeEmploye(Employe employe) {
        if (nbEmployes > 0 && this.employeExists(employe)) {
            for (int i = 0; i < nbEmployes; i++) {
                if (employe.comparer(employes[i])) {
                    for (int j = i; j < nbEmployes - 1; j++) {
                        employes[j] = employes[j + 1];
                    }
                    setNbEmployes(this.nbEmployes - 1);
                    return true;
                }
            }
        }
        return false;
    }

    public static long getNbTotalProduits() {
        return nbTotalProduits;
    }

    public static Magasin supMagasin(Magasin m1, Magasin m2) {
        return m1.getNbProduits() > m2.getNbProduits() ? m1 : m2;
    }

    @Override
    public String toString() {
        return "Magasin{" +
                "id=" + id +
                ", libelle=" + getLibelle() +
                ", adresse=" + getAdresse() +
                ", produits=" + Arrays.toString(getProduits()) +
                ", nbProduits=" + getNbProduits() +
                ", employes=" + Arrays.toString(getEmployes()) +
                '}';
    }
}
