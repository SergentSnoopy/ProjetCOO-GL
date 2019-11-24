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

    public Client(String numCarte, String name, String firstName, String address, Boolean isSubscribed, int currentBalance, Historique historic) throws IOException {
        super(numCarte);

        this.name = name;
        this.firstName = firstName;
        this.address = address;
        this.isSubscribed = isSubscribed;
        this.currentBalance = currentBalance;
        this.historic = historic;
    }

//    public Client(String nom, String prenom, String adresse) throws IOException {
//        setNumCarte("" + ((int) (Math.random() * 1000000 + 1000000)));
//
//        this.nom = nom;
//        this.prenom = prenom;
//        this.adresse = adresse;
//        this.estAbonne = false;
//        this.soldeActuel = 0;
//        this.historique = new Historique(getNumCarte());
//    }

    public void rentMovie(Film movie) {
        historic.addLocation(movie.getTitle(), movie.getDirector(), isSubscribed);
        this.setCurrentBalance(this.getCurrentBalance() - (isSubscribed ? 4 : 5));
        //retirer un film
    }

    public void returnMovie(Film movie) {
        historic.retournerLocation(movie.getTitle(), movie.getDirector(), isSubscribed);
        //ajouter un film dispo
    }

//    public void voirHistorique() {
//        historic.voirHistLocation();
//        historic.voirHistBancaire();
//    }


    public void rechargeAccount(String numCarte, int montant) {
        currentBalance = currentBalance + montant;
        historic.addBancaire(numCarte, montant);
    }

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