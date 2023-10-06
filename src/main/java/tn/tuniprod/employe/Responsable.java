package tn.tuniprod.employe;

public class Responsable extends Employe {
    private double prime;

    public Responsable() {
    }

    public Responsable(int id, String nom, String adresse) {
        super(id, nom, adresse);
    }

    public Responsable(int id, String nom, String adresse, double nbrHeures) {
        super(id, nom, adresse, nbrHeures);
    }

    public Responsable(int id, String nom, String adresse, double nbrHeures, double prime) {
        super(id, nom, adresse, nbrHeures);
        this.prime = prime;
    }

    public double getPrime() {
        return prime;
    }

    @Override
    public double getSalaire() {
        int PRIX_HEURE = 10;
        double PRIX_HEURE_SUPPLEMENTAIRE = PRIX_HEURE * 1.2;
        if (getNbrHeures() <= 160) return getNbrHeures() * PRIX_HEURE;
        return (getNbrHeures() - 160) * PRIX_HEURE_SUPPLEMENTAIRE + 160 * PRIX_HEURE_SUPPLEMENTAIRE;
    }

    public void setPrime(double prime) {
        this.prime = prime;
    }

    @Override
    public String toString() {
        return "Responsable{" + "id" + getId() + ", nom='" + getNom() + ", adresse='" + getAdresse() + ", nbrHeures=" + getNbrHeures() + ", prime=" + getPrime() + ", salaire=" + getSalaire() + '}';
    }
}
