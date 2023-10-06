package tn.tuniprod.exceptions;

public class PrixNegatifException extends Exception {

    public PrixNegatifException() {
        super();
    }

    public PrixNegatifException(String message) {
        super(message);
    }

    public PrixNegatifException(double prix) {
        super("Le prix " + prix + " est négatif");
        System.out.println("Le prix " + prix + " est négatif");
    }
}
