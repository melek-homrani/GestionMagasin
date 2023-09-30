package tn.tuniprod.employe;

public class Employe {
    protected int id;
    protected String nom;
    protected String adresse;
    protected double nbrHeures;

    public Employe() {
    }

    public Employe(int id, String nom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
    }

    public Employe(int id, String nom, String adresse, double nbrHeures) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.nbrHeures = nbrHeures;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public double getNbrHeures() {
        return nbrHeures;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNbrHeures(double nbrHeures) {
        this.nbrHeures = nbrHeures;
    }

    @Override
    public String toString() {
        return "Employe{" + "id=" + getId() + ", nom='" + getNom() + ", adresse= " + getAdresse() + ", nbrHeures=" + getNbrHeures() + '}';
    }
}
