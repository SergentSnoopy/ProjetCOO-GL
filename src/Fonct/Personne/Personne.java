package Fonct.Personne;

import Fonct.Machine;

import java.io.IOException;

public abstract class Personne extends Machine {
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
