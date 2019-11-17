package Fonct;

import Fonct.Historique.Film;
import Fonct.Historique.Historique;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        Historique test_hist = new Historique();
        test_hist.addBancaire("01234",200);
//        ArrayList<Film> listFilm=new ArrayList<Film>();
//        Film F=new Film();
//        listFilm.add()
//        test_hist.addLocation();
        test_hist.voirHistBancaire();

    }
}
