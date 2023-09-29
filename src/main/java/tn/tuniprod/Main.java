package tn.tuniprod;

import tn.tuniprod.magasin.Magasin;
import tn.tuniprod.produit.Produit;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Produit tuniProd = new Produit();
        Produit lait = new Produit(1021, "Lait", "Delice");
        Produit yaourt = new Produit(2510, "Yaourt", "Vitalait");
        Produit tomate = new Produit(3250, "Tomate", "Sicam", 1.200);

        System.out.println("****All products go here****");
        tuniProd.afficher();
        lait.afficher();
        yaourt.afficher();
        tomate.afficher();

        lait.setPrix(0.700);

        tuniProd.setId(1);
        tuniProd.setLibelle("produit");
        tuniProd.setMarque("produit");
        tuniProd.setPrix(78.900);
        yaourt.setPrix(0.800);

        System.out.println("****All modified products go here****");
        tuniProd.afficher();
        yaourt.afficher();
        lait.afficher();

        tuniProd.setDateExpiration(LocalDate.of(2024, 12, 31));
        lait.setDateExpiration(LocalDate.of(2024, 12, 31));
        yaourt.setDateExpiration(LocalDate.of(2024, 12, 31));
        tomate.setDateExpiration(LocalDate.of(2024, 12, 31));

        System.out.println("****All products with toString() go here****");
//        System.out.println(tuniProd.toString());
//        System.out.println(lait.toString());
//        System.out.println(yaourt.toString());
//        System.out.println(tomate.toString());

        System.out.println("****All products with expiration date go here****");
        tuniProd.afficher();
        lait.afficher();
        yaourt.afficher();
        tomate.afficher();

        System.out.println("****Number Of All Products goes here****");
        System.out.println("le nombre total de tous les produits dans tous les magasins " + Produit.getNbProduits());

        Magasin magasin = new Magasin(12, "Tunis");
        var added = magasin.addProduit(tuniProd);
        System.out.println(added);
        magasin.addProduit(lait);
        magasin.addProduit(yaourt);
        magasin.addProduit(tomate);

        System.out.println("****All Products in Shopx² go here");
        System.out.println(magasin.afficher());

        Produit eau = new Produit(6864, "Eau", "Sabrine", 0.900);
        Magasin magasin1 = new Magasin(456, "Nabeul");
        magasin1.addProduit(eau);

        System.out.println("****All Products in Shop go here");
        System.out.println(magasin1.afficher());

        System.out.println("le nombre total de tous les produits dans tous les magasins " + Produit.getNbProduits());
    }
}