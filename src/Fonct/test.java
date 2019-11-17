package Fonct;

import Fonct.Historique.Film;
import Fonct.Historique.*;
import Fonct.Input_Output.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class test {
    public static void main(String[] args) throws IOException {
        Historique test_hist = new Historique();
        test_hist.addBancaire("01234",200);
//        ArrayList<Film> listFilm=new ArrayList<Film>();
//        Film F=new Film();
//        listFilm.add()
//        test_hist.addLocation();
        System.out.println("Working Directory = " +
                System.getProperty("user.dir")+"/src/BDD/BDlocale");

        BD_locale bd=new BD_locale(System.getProperty("user.dir")+"/src/BDD/BDlocale");
        System.out.println(bd.getFilms().get(1).getNbDispo());
        test_hist.addLocation("Terminator","James Cameron",true,bd.getFilms());
        test_hist.voirHistBancaire();
        test_hist.voirHistLocation();
        System.out.println(bd.getFilms().get(1).getNbDispo());
    }
}
