package Fonct.Historique;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Historique {

    private ArrayList<HistoriqueLocation> listeHistLocation;
    private ArrayList<HistoriqueBancaire> listeHistBancaire;

    public Historique(){
        listeHistBancaire=new ArrayList<>();
        listeHistLocation=new ArrayList<>();
    }

    public void addLocation(String titre, String realisateur, Boolean estAbonne,ArrayList<Film> listeFilm){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        int placeDansListe=0;

        for (int i=0;i<listeFilm.size();i++) {
            if (titre == listeFilm.get(i).getTitre()) {
                if(realisateur == listeFilm.get(i).getRealisateur()) {
                    placeDansListe = i;
                    break;
                }
            }
        }

        if(estAbonne)
            listeHistLocation.add(new HistoriqueLocation(dateFormat.format(date),titre,realisateur,4,"Location"));
        else
            listeHistLocation.add(new HistoriqueLocation(dateFormat.format(date),titre,realisateur,5,"Location"));
        listeFilm.get(placeDansListe).RetirerUnFilm();
    }

    public void addBancaire(String NumCarte, int Montant){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        listeHistBancaire.add(new HistoriqueBancaire(NumCarte,dateFormat.format(date),Montant));
    }

    public void retournerLocation(String titre, String realisateur, Boolean estAbonne,ArrayList<Film> listeFilm){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        int placeDansListe=0;

        for (int i=0;i<listeFilm.size();i++) {
            if (titre == listeFilm.get(i).getTitre()) {
                if(realisateur == listeFilm.get(i).getRealisateur()) {
                    placeDansListe = i;
                    break;
                }
            }
        }

        if(estAbonne)
            listeHistLocation.add(new HistoriqueLocation(dateFormat.format(date),titre,realisateur,4,"Rendu"));
        else
            listeHistLocation.add(new HistoriqueLocation(dateFormat.format(date),titre,realisateur,5,"Rendu"));

        listeFilm.get(placeDansListe).RendreUnFilm();
    }

    public void voirHistBancaire(){
        String res="";
        for(int i=0; i<listeHistBancaire.size();i++){
            res=res+listeHistBancaire.get(i).getNumCarte()+";"+listeHistBancaire.get(i).getDate()+";"+listeHistBancaire.get(i).getMontant()+"\n";
        }
        System.out.println(res);
    }

    public void voirHistLocation(){
        String res="";
        for(int i=0; i<listeHistLocation.size();i++){
            res=res+listeHistLocation.get(i).getDate()+";"+listeHistLocation.get(i).getTypeDaction()+";"+listeHistLocation.get(i).getTitreFilm()+";"+listeHistLocation.get(i).getRealisateur()+";\n";
        }
        System.out.println(res);
    }
}
