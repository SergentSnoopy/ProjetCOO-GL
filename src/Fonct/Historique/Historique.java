package Fonct.Historique;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Historique {

    private ArrayList<HistoriqueLocation> listeHistLocation;
    private ArrayList<HistoriqueBancaire> listeHistBancaire;



    public void addLocation(Film film, Boolean estAbonne,ArrayList<Film> listeFilm){
        Date date = new Date();
        int placeDansListe=0;

        for (int i=0;i<listeFilm.size();i++) {
            if (film.getTitre() == listeFilm.get(i).getTitre()) {
                placeDansListe = i;
                break;
            }
        }

        if(estAbonne)
            listeHistLocation.add(new HistoriqueLocation(date,film,4,"Location"));
        else
            listeHistLocation.add(new HistoriqueLocation(date,film,5,"Location"));
        listeFilm.get(placeDansListe).RetirerUnFilm();
    }

    public void addBancaire(String NumCarte, int Montant){
        Date date = new Date();

        listeHistBancaire.add(new HistoriqueBancaire(NumCarte,date,Montant));
    }

    public void retournerLocation(Film film, Boolean estAbonne,ArrayList<Film> listeFilm){
        Date date = new Date();
        int placeDansListe=0;

        for (int i=0;i<listeFilm.size();i++) {
            if (film.getTitre() == listeFilm.get(i).getTitre()) {
                placeDansListe = i;
                break;
            }
        }

        if(estAbonne)
            listeHistLocation.add(new HistoriqueLocation(date,film,4,"Rendu"));
        else
            listeHistLocation.add(new HistoriqueLocation(date,film,5,"Rendu"));

        listeFilm.get(placeDansListe).RendreUnFilm();
    }
}
