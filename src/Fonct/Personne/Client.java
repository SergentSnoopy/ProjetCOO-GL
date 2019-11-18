package Fonct.Personne;

import Fonct.Historique.Film;
import Fonct.Historique.Historique;

import java.util.ArrayList;

public class Client extends Personne {
    private String nom;
    private String nrenom;
    private String adresse;
    private Boolean estAbonne;
    private int soldeActuel;
    private Historique historique;

    public Client(String nom, String nrenom, String adresse, Boolean estAbonne, int soldeActuel, Historique historique) {
        this.nom = nom;
        this.nrenom = nrenom;
        this.adresse = adresse;
        this.estAbonne = estAbonne;
        this.soldeActuel = soldeActuel;
        this.historique = historique;
    }

    public void louerFilm(String titre, String realisateur, ArrayList<Film> listeFilm){
        for (int i=0;i<listeFilm.size();i++) {
            if (titre == listeFilm.get(i).getTitre()) {
                if(realisateur == listeFilm.get(i).getRealisateur()) {
                    if(listeFilm.get(i).getNbDispo()>0){
                        historique.addLocation(titre,realisateur,estAbonne,listeFilm);
                    }
                }
            }
        }
    }

    public void rendreFilm(String titre, String realisateur, ArrayList<Film> listeFilm){
        historique.retournerLocation(titre,realisateur,estAbonne,listeFilm);
    }

    public void voirHistorique(){
        historique.voirHistLocation();
        historique.voirHistBancaire();
    }

    public Boolean devenirPremium(){
        if(soldeActuel<25){
            return false;
        }
        else{
            soldeActuel=soldeActuel-25;
            estAbonne=true;
            return true;
        }
    }

    public void rechargerCompte(String numCarte,int montant){
        soldeActuel=soldeActuel+montant;
        historique.addBancaire(numCarte,montant);
    }

    public void demanderFilm(String titre, String realisateur){
        //TODO
        //remplir
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNrenom() {
        return nrenom;
    }

    public void setNrenom(String nrenom) {
        this.nrenom = nrenom;
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