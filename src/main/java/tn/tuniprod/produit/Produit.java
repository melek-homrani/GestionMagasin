package tn.tuniprod.produit;


import java.time.LocalDate;


public class Produit {
    private int id;
    private String libelle;
    private String marque;
    private double prix;
    private LocalDate dateExpiration;
    private static long nbTotalProduits = 0;

    public Produit() {
    }

    public Produit(int id, String libelle, String marque) {
        this.id = id;
        this.libelle = libelle;
        this.marque = marque;
        nbTotalProduits++;
    }


    public Produit(int id, String libelle, String marque, double prix) {
        this.id = id;
        this.libelle = libelle;
        this.marque = marque;
        setPrix(prix);
        nbTotalProduits++;
    }

    public Produit(int id, String libelle, String marque, double prix, LocalDate dateExpiration) {
        this.id = id;
        this.libelle = libelle;
        this.marque = marque;
        setPrix(prix);
        this.dateExpiration = dateExpiration;
        nbTotalProduits++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.libelle = libelle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        if (prix > 0) this.prix = prix;
        else System.out.println("Le prix ne peut pas être négatif.");
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public static long getNbTotalProduits() {
        return Produit.nbTotalProduits;
    }

    public boolean comparer(Produit p) {
        return (this.id == p.getId() && this.libelle.equals(p.getLibelle()) && this.prix == p.getPrix());
    }

    public static boolean comparer(Produit p1, Produit p2) {
        return (p1.getId() == p2.getId() && p1.libelle.equals(p2.getLibelle()) && p1.prix == p2.getPrix());
    }


    public void afficher() {

        System.out.println("L'id est " + id + ",de libelle " + libelle + ",de marque " + marque + " et de prix " + prix);
    }

    @Override
    public String toString() {
        return "L'id est " + id + ",de libelle " + libelle + ",de marque " + marque + " ,de prix " + prix + "et la date d expiration = " + dateExpiration;
    }

}