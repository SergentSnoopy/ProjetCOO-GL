package Fonct.Historique;

import java.util.Date;

public class HistoriqueBancaire {
    private String NumCarte;
    private Date Date;
    private int Montant;

    public HistoriqueBancaire(String NumCarte, Date Date, int Montant){
        this.Date=Date;
        this.NumCarte=NumCarte;
        this.Montant=Montant;
    }
}
