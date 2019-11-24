package Fonct.Personne;

public abstract class Personne {
    private String numCarte;

    public Personne() {

    }

    public Personne(String numCarte) {
        this.numCarte = numCarte;
    }

    public String getNumCarte() {
        return numCarte;
    }

    public void setNumCarte(String numCarte) {
        this.numCarte = numCarte;
    }
}
