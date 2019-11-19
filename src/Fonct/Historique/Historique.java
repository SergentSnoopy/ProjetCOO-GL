package Fonct.Historique;

import Fonct.Personne.Client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Historique {

    private ArrayList<HistoriqueLocation> listeHistLocation;
    private ArrayList<HistoriqueBancaire> listeHistBancaire;
    String numCarteUtilisateur;

    public ArrayList<HistoriqueLocation> getListeHistLocation() {
        return listeHistLocation;
    }

    public void setListeHistLocation(ArrayList<HistoriqueLocation> listeHistLocation) {
        this.listeHistLocation = listeHistLocation;
    }

    public ArrayList<HistoriqueBancaire> getListeHistBancaire() {
        return listeHistBancaire;
    }

    public void setListeHistBancaire(ArrayList<HistoriqueBancaire> listeHistBancaire) {
        this.listeHistBancaire = listeHistBancaire;
    }

    public String getNumCarteUtilisateur() {
        return numCarteUtilisateur;
    }

    public void setNumCarteUtilisateur(String numCarteUtilisateur) {
        this.numCarteUtilisateur = numCarteUtilisateur;
    }

    public Historique(String numCarteUtilisateur){
        this.numCarteUtilisateur=numCarteUtilisateur;
        listeHistBancaire=new ArrayList<>();
        listeHistLocation=new ArrayList<>();
    }

    public void addLocation(String titre, String realisateur, Boolean estAbonne){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        if(estAbonne)
            listeHistLocation.add(new HistoriqueLocation(dateFormat.format(date),titre,realisateur,4,"Location"));
        else
            listeHistLocation.add(new HistoriqueLocation(dateFormat.format(date),titre,realisateur,5,"Location"));
    }

    public void addBancaire(String NumCarte, int Montant){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        listeHistBancaire.add(new HistoriqueBancaire(NumCarte,dateFormat.format(date),Montant));
    }

    public void retournerLocation(String titre, String realisateur, Boolean estAbonne,ArrayList<Film> listeFilm){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        if(estAbonne)
            listeHistLocation.add(new HistoriqueLocation(dateFormat.format(date),titre,realisateur,4,"Rendu"));
        else
            listeHistLocation.add(new HistoriqueLocation(dateFormat.format(date),titre,realisateur,5,"Rendu"));
    }

    public void voirHistBancaire(){
        String res="";
        for(int i=0; i<listeHistBancaire.size();i++){
            res=res+listeHistBancaire.get(i).getNumCarte()+";"+listeHistBancaire.get(i).getDate()+";"+listeHistBancaire.get(i).getMontant()+"\n";
        }
        System.out.print(res);
    }

    public ArrayList<HistoriqueLocation> voirHistLocation(){
        String res="";
        for(int i=0; i<listeHistLocation.size();i++){
            res=res+listeHistLocation.get(i).getDate()+";"+listeHistLocation.get(i).getTypeDaction()+";"+listeHistLocation.get(i).getTitreFilm()+";"+listeHistLocation.get(i).getRealisateur()+";\n";
        }
        System.out.print(res);

        return this.listeHistLocation;
    }
}
