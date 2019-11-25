package Fonct.Personne;

import Fonct.Historique.Film;
import Fonct.Historique.Historique;

import java.io.IOException;

public class Client extends Personne {
    private String name;
    private String firstName;
    private String address;
    private Boolean isSubscribed;
    private int currentBalance;
    private Historique historic;

    //Constructeur de client
    public Client(String numCarte, String name, String firstName, String address, Boolean isSubscribed, int currentBalance, Historique historic) throws IOException {
        super(numCarte);

        this.name = name;
        this.firstName = firstName;
        this.address = address;
        this.isSubscribed = isSubscribed;
        this.currentBalance = currentBalance;
        this.historic = historic;
    }

    //permet de louer un film, elle prend en parametre le film souhaité
    public void rentMovie(Film movie) {
        historic.addLocation(movie.getTitle(), movie.getDirector(), isSubscribed);
    }

    //permet de retourner un film, elle prend un film en parametre
    public void returnMovie(Film movie) {
        historic.retournerLocation(movie.getTitle(), movie.getDirector(), isSubscribed);
    }


    //permet de recharger le solde client
    public void rechargeAccount(String numCarte, int montant) {
        currentBalance = currentBalance + montant;
        historic.addBancaire(numCarte, montant);
    }

    //prend de devenir vip si l'on possede un solde suffisant
    public boolean becomeVIP() {
        if (this.getCurrentBalance() >= 25) {
            this.setIsSubscribed(true);
            this.setCurrentBalance(this.getCurrentBalance() - 25);
            return true;
        } else return false;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getIsSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(Boolean isSubscribed) {
        this.isSubscribed = isSubscribed;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Historique getHistoric() {
        return historic;
    }

    public void setHistoric(Historique historic) {
        this.historic = historic;
    }
}