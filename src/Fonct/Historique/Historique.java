package Fonct.Historique;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Historique {

    private String userCardNumber;
    private ArrayList<HistoriqueLocation> rentHistList;
    private ArrayList<HistoriqueBancaire> bankHistList;

    //Constructeur d'Historique
    public Historique(String userCardNumber) {
        this.userCardNumber = userCardNumber;
        bankHistList = new ArrayList<>();
        rentHistList = new ArrayList<>();
    }

    public ArrayList<HistoriqueLocation> getRentHistList() {
        return rentHistList;
    }

    public ArrayList<HistoriqueBancaire> getBankHistList() {
        return bankHistList;
    }

    public String getUserCardNumber() {
        return userCardNumber;
    }

    //Ajout de la location dans l'historique de location en fonction du status du client (VIP?)
    public void addLocation(String title, String director, Boolean isSubscribed) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        if (isSubscribed)
            rentHistList.add(new HistoriqueLocation(dateFormat.format(date), title, director, 4, "Location"));
        else
            rentHistList.add(new HistoriqueLocation(dateFormat.format(date), title, director, 5, "Location"));
    }

    //Ajout d'un rechargement bancaire dans l'historique bancaire
    public void addBancaire(int amount) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        bankHistList.add(new HistoriqueBancaire(dateFormat.format(date), amount));
    }

    //ajout d'un retour de location dans l'historique de location
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
