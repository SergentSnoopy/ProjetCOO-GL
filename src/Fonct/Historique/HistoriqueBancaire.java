package Fonct.Historique;

public class HistoriqueBancaire {
    private String date;
    private int amount;

    //Constructeur de HistoriqueBancaire
    public HistoriqueBancaire(String Date, int amount) {
        this.date = Date;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Date:" + date + ' ' +
                ", Montant:" + amount + "E";
    }
}
