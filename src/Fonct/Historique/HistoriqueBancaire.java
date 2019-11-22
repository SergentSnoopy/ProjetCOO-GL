package Fonct.Historique;

import java.util.Date;

public class HistoriqueBancaire {
    private String Date;
    private int Montant;

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

    public HistoriqueBancaire(String Date, int Montant){
        this.Date=Date;
        this.Montant=Montant;
    }

    @Override
    public String toString() {
        return "Date:" + Date + ' ' +
                ", Montant:" + Montant+"E";
    }
}
