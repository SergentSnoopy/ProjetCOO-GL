package Fonct.Personne;

import Fonct.Historique.Film;
import Fonct.Historique.Historique;
import java.lang.Double;

import java.io.IOException;
import java.util.ArrayList;

public class Client extends Personne {
    private String nom;
    private String prenom;
    private String adresse;
    private Boolean estAbonne;
    private int soldeActuel;
    private Historique historique;

    public Client(String numCarte,String nom, String prenom, String adresse, Boolean estAbonne, int soldeActuel, Historique historique) throws IOException {
        super(numCarte);

        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.estAbonne = estAbonne;
        this.soldeActuel = soldeActuel;
        this.historique = historique;
        chargeBD();
    }

    public Client(String nom, String prenom, String adresse) throws IOException {
        setNumCarte(""+((int)(Math.random()*1000000+1000000)));

        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.estAbonne = false;
        this.soldeActuel = 0;
        this.historique = new Historique(getNumCarte());
        chargeBD();
    }

    public void louerFilm(String titre, String realisateur){
        for (int i=0;i<getListefilm().size();i++) {
            if (titre.equals(getListefilm().get(i).getTitre())) {
                if(realisateur.equals(getListefilm().get(i).getRealisateur())) {
                    System.out.println(getListefilm().get(i).getNbDispo());
                    if(getListefilm().get(i).getNbDispo()>0 && this.getSoldeActuel()> (estAbonne ? 4:5)){
                        historique.addLocation(titre,realisateur,estAbonne);
                        getListefilm().get(i).louerUnFilm();
                        this.setSoldeActuel(this.getSoldeActuel()-(estAbonne ? 4:5));
                        break;
                    }
                }
            }
        }
    }

    public void rendreFilm(String titre, String realisateur){

        for (int i=0;i<getListefilm().size();i++) {
            if (titre.equals(getListefilm().get(i).getTitre())) {
                if(realisateur.equals(getListefilm().get(i).getRealisateur())) {
                    historique.retournerLocation(titre,realisateur,estAbonne,getListefilm());
                    getListefilm().get(i).rendreUnFilm();
                    break;
                }
            }
        }
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

    public boolean devenirVip(){
        if (this.getSoldeActuel()>=25)
        {
            this.setEstAbonne(true);
            this.setSoldeActuel(this.getSoldeActuel()-25);
            return true;
        }
        else return false;
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