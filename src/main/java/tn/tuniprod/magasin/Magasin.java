package tn.tuniprod.magasin;

import tn.tuniprod.employe.Caissier;
import tn.tuniprod.employe.Employe;
import tn.tuniprod.employe.Responsable;
import tn.tuniprod.employe.Vendeur;
import tn.tuniprod.exceptions.MagasinPleinException;
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

    private boolean magasinPlein() {
        return nbProduits == CAPACITE_MAX;
    }

    public boolean addProduit(Produit produit) throws MagasinPleinException {
        if (magasinPlein()) {
            throw new MagasinPleinException("Le magasin est plein");
        }
        if (!this.produitExists(produit)) {
            produits[nbProduits] = produit;
            setNbProduits(this.nbProduits + 1);
            Magasin.nbTotalProduits++;
            return true;
        }
        return false;
    }

    private int getProduitIndex(Produit produit) {
        for (int i = 0; i < nbProduits; i++) {
            if (produit.comparer(produits[i])) return i;
        }
        return -1;
    }

    public boolean removeProduit(Produit produit) {
        int index = getProduitIndex(produit);
        if (index == -1 || nbProduits == 0) return false;
        for (int i = index; i < nbProduits - 1; i++) {
            produits[i] = produits[i + 1];
        }
        this.produits[nbProduits] = null;
        setNbProduits(this.nbProduits - 1);
        return true;
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

    private int getEmployeIndex(Employe employe) {
        for (int i = 0; i < nbEmployes; i++) {
            if (employe.comparer(employes[i])) return i;
        }
        return -1;
    }

    public boolean removeEmploye(Employe employe) {
        int index = getEmployeIndex(employe);
        if (index == -1 || nbEmployes == 0) return false;
        for (int i = index; i < nbEmployes - 1; i++) {
            employes[i] = employes[i + 1];
        }
        this.produits[nbEmployes] = null;
        setNbEmployes(this.nbEmployes - 1);
        return true;
    }

    public static long getNbTotalProduits() {
        return nbTotalProduits;
    }

    public void afficheSalaire() {
        double salaire = 0;
        System.out.print("Le salaire de des employe est : ");
        for (var employe : employes) {
            if (employe != null) salaire += employe.getSalaire();
        }
        System.out.println(salaire);
    }

    public void affichePrimeResponsable() {
        double prime = 0;
        System.out.print("La prime des responsables est : ");
        for (var employe : employes) {
            if (employe instanceof Responsable) prime += ((Responsable) employe).getPrime();
        }
        System.out.println(prime);
    }

    public void afficheTypeEmploye() {
        int nbCaissier = 0;
        int nbVendeur = 0;
        int nbResponsable = 0;

        for (var employe : employes) {
            if (employe instanceof Responsable) nbResponsable++;
            else if (employe instanceof Vendeur) nbVendeur++;
            else if (employe instanceof Caissier) nbCaissier++;
        }
        System.out.println("Le nombre de caissier est : " + nbCaissier);
        System.out.println("Le nombre de vendeur est : " + nbVendeur);
        System.out.println("Le nombre de responsable est : " + nbResponsable);
    }

    public static Magasin supMagasin(Magasin m1, Magasin m2) {
        return m1.getNbProduits() == m2.getNbProduits() ? null : m1.getNbProduits() > m2.getNbProduits() ? m1 : m2;
    }

    @Override
    public String toString() {
        return "Magasin{" + "id=" + id + ", libelle=" + getLibelle() + ", adresse=" + getAdresse() + ", produits=" + Arrays.toString(getProduits()) + ", nbProduits=" + getNbProduits() + ", employes=" + Arrays.toString(getEmployes()) + '}';
    }

}
