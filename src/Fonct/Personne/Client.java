package Fonct.Personne;

import Fonct.Historique.Film;
import Fonct.Historique.Historique;

import java.io.IOException;

public class Client extends Personne {
    private String nom;
    private String prenom;
    private String adresse;
    private Boolean estAbonne;
    private int soldeActuel;
    private Historique historique;

    public Client(String numCarte, String nom, String prenom, String adresse, Boolean estAbonne, int soldeActuel, Historique historique) throws IOException {
        super(numCarte);

        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.estAbonne = estAbonne;
        this.soldeActuel = soldeActuel;
        this.historique = historique;
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

    public void louerFilm(Film movie) {
        historique.addLocation(movie.getTitre(), movie.getRealisateur(), estAbonne);
        this.setSoldeActuel(this.getSoldeActuel() - (estAbonne ? 4 : 5));
        //retirer un film
    }

    public void rendreFilm(Film movie) {
        historique.retournerLocation(movie.getTitre(), movie.getRealisateur(), estAbonne);
        //ajouter un film dispo
    }

    public void voirHistorique() {
        historique.voirHistLocation();
        historique.voirHistBancaire();
    }


    public void rechargerCompte(String numCarte, int montant) {
        soldeActuel = soldeActuel + montant;
        historique.addBancaire(numCarte, montant);
    }

    public boolean devenirVip() {
        if (this.getSoldeActuel() >= 25) {
            this.setEstAbonne(true);
            this.setSoldeActuel(this.getSoldeActuel() - 25);
            return true;
        } else return false;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Boolean getEstAbonne() {
        return estAbonne;
    }

    public void setEstAbonne(Boolean estAbonne) {
        this.estAbonne = estAbonne;
    }

    public int getSoldeActuel() {
        return soldeActuel;
    }

    public void setSoldeActuel(int soldeActuel) {
        this.soldeActuel = soldeActuel;
    }

    public Historique getHistorique() {
        return historique;
    }

    public void setHistorique(Historique historique) {
        this.historique = historique;
    }
}