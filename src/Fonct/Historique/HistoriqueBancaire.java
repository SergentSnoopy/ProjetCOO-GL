package Fonct.Historique;

import java.util.Date;

public class HistoriqueBancaire {
    private String NumCarte;
    private String Date;
    private int Montant;

    public String getNumCarte() {
        return NumCarte;
    }

    public void setNumCarte(String numCarte) {
        NumCarte = numCarte;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getMontant() {
        return Montant;
    }

    public void setMontant(int montant) {
        Montant = montant;
    }

    public HistoriqueBancaire(String NumCarte, String Date, int Montant){
        this.Date=Date;
        this.NumCarte=NumCarte;
        this.Montant=Montant;
    }
}
