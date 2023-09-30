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
    public double getSalaire() {
        int PRIX_HEURE = 5;
        double PRIX_HEURE_SUPPLEMENTAIRE = PRIX_HEURE * 1.15;
        if (getNbrHeures() <= 180) return getNbrHeures() * PRIX_HEURE;
        return (getNbrHeures() - 180) * PRIX_HEURE + (180 - getNbrHeures()) * PRIX_HEURE_SUPPLEMENTAIRE;
    }

    @Override
    public String toString() {
        return "Caissier{" + "id" + getId() + ", nom='" + getNom() + ", adresse='" + getAdresse() + ", nbrHeures=" + getNbrHeures() + ", salaire" + getSalaire() + '}';
    }

}
