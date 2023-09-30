package tn.tuniprod.employe;

public class Caissier extends Employe {

    public Caissier() {
    }

    public Caissier(int id, String nom, String adresse) {
        super(id, nom, adresse);
    }

    public Caissier(int id, String nom, String adresse, double nbrHeures) {
        super(id, nom, adresse, nbrHeures);
    }

    @Override
    public String toString() {
        return "Caissier{" + "id" + getId() + ", nom='" + getNom() + ", adresse='" + getAdresse() + ", nbrHeures=" + getNbrHeures() + '}';
    }

}
