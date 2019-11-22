package Fonct.Historique;

public class HistoriqueBancaire {
    private String Date;
    private int Montant;

    public HistoriqueBancaire(String Date, int Montant) {
        this.Date = Date;
        this.Montant = Montant;
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

    @Override
    public String toString() {
        return "Date:" + Date + ' ' +
                ", Montant:" + Montant + "E";
    }
}
