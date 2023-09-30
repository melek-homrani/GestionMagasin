package tn.tuniprod.produit;


import java.time.LocalDate;


public class Produit {
    private int id;
    private String libelle;
    private String marque;
    private double prix;
    private LocalDate dateExpiration;


    public Produit() {
    }

    public Produit(int id, String libelle, String marque) {
        this.id = id;
        this.libelle = libelle;
        this.marque = marque;
    }


    public Produit(int id, String libelle, String marque, double prix) {
        this.id = id;
        this.libelle = libelle;
        this.marque = marque;
        setPrix(prix);
    }

    public Produit(int id, String libelle, String marque, double prix, LocalDate dateExpiration) {
        this.id = id;
        this.libelle = libelle;
        this.marque = marque;
        setPrix(prix);
        this.dateExpiration = dateExpiration;
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

    public boolean comparer(Produit p) {
        return (this.id == p.getId() && this.libelle.equals(p.getLibelle()) && this.prix == p.getPrix());
    }

    public static boolean comparer(Produit p1, Produit p2) {
        return (p1.getId() == p2.getId() && p1.getLibelle().equals(p2.getLibelle()) && p1.getPrix() == p2.getPrix());
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + getId() + ", libelle=" + getLibelle() + ", marque=" + getMarque() + ", prix=" + getPrix() + ", dateExpiration=" + getDateExpiration() + '}';
    }

}