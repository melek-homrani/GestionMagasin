package tn.tuniprod.employe;

public class Vendeur extends Employe {
    private double tauxDeVente;
    private int numeroDeCaisse;

    public Vendeur() {
    }

    public Vendeur(int id, String nom, String adresse) {
        super(id, nom, adresse);
    }

    public Vendeur(int id, String nom, String adresse, double nbrHeures) {
        super(id, nom, adresse, nbrHeures);
    }

    public Vendeur(int id, String nom, String adresse, double nbrHeures, int numeroDeCaisse) {
        super(id, nom, adresse, nbrHeures);
        this.numeroDeCaisse = numeroDeCaisse;
    }

    public Vendeur(int id, String nom, String adresse, double nbrHeures, double tauxDeVente, int numeroDeCaisse) {
        super(id, nom, adresse, nbrHeures);
        this.tauxDeVente = tauxDeVente;
        this.numeroDeCaisse = numeroDeCaisse;
    }

    public double getTauxDeVente() {
        return tauxDeVente;
    }

    public int getNumeroDeCaisse() {
        return numeroDeCaisse;
    }

    public void setTauxDeVente(double tauxDeVente) {
        this.tauxDeVente = tauxDeVente;
    }

    public void setNumeroDeCaisse(int numeroDeCaisse) {
        this.numeroDeCaisse = numeroDeCaisse;
    }

    @Override
    public String toString() {
        return "Vendeur{" + "id" + getId() + ", nom='" + getNom() + ", adresse='" + getAdresse() + ", nbrHeures=" + getNbrHeures() + ", tauxDeVente=" + getTauxDeVente() + ", numeroDeCaisse=" + getNumeroDeCaisse() + '}';
    }
}
