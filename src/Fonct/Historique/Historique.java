package Fonct.Historique;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Historique {

    String userCardNumber;
    private ArrayList<HistoriqueLocation> rentHistList;
    private ArrayList<HistoriqueBancaire> bankHistList;

    public Historique(String userCardNumber) {
        this.userCardNumber = userCardNumber;
        bankHistList = new ArrayList<>();
        rentHistList = new ArrayList<>();
    }

    public ArrayList<HistoriqueLocation> getRentHistList() {
        return rentHistList;
    }

    public void setRentHistList(ArrayList<HistoriqueLocation> rentHistList) {
        this.rentHistList = rentHistList;
    }

    public ArrayList<HistoriqueBancaire> getBankHistList() {
        return bankHistList;
    }

    public void setBankHistList(ArrayList<HistoriqueBancaire> bankHistList) {
        this.bankHistList = bankHistList;
    }

    public String getUserCardNumber() {
        return userCardNumber;
    }

    public void setUserCardNumber(String userCardNumber) {
        this.userCardNumber = userCardNumber;
    }

    public void addLocation(String title, String director, Boolean isSubscribed) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        if (isSubscribed)
            rentHistList.add(new HistoriqueLocation(dateFormat.format(date), title, director, 4, "Location"));
        else
            rentHistList.add(new HistoriqueLocation(dateFormat.format(date), title, director, 5, "Location"));
    }

    public void addBancaire(String cardNumber, int amount) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        bankHistList.add(new HistoriqueBancaire(dateFormat.format(date), amount));
    }

    public void retournerLocation(String title, String director, Boolean isSubscribed) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        if (isSubscribed)
            rentHistList.add(new HistoriqueLocation(dateFormat.format(date), title, director, 4, "Rendu"));
        else
            rentHistList.add(new HistoriqueLocation(dateFormat.format(date), title, director, 5, "Rendu"));
    }

    public void voirHistBancaire() {
        String res = "";
        for (int i = 0; i < bankHistList.size(); i++) {
            res = res + bankHistList.get(i).getDate() + ";" + bankHistList.get(i).getAmount() + "\n";
        }
        System.out.print(res);
    }

    public ArrayList<HistoriqueLocation> voirHistLocation() {
        String res = "";
        for (int i = 0; i < rentHistList.size(); i++) {
            res = res + rentHistList.get(i).getDate() + ";" + rentHistList.get(i).getActionType() + ";" + rentHistList.get(i).getMovieTitle() + ";" + rentHistList.get(i).getDirector() + ";\n";
        }
        System.out.print(res);

        return this.rentHistList;
    }
}
