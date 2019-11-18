package Fonct;

import Fonct.Historique.Film;
import Fonct.Input_Output.BD_locale;

import java.io.IOException;
import java.util.ArrayList;

public class Machine {
    ArrayList<Film> listefilm;

    public ArrayList<Film> getListefilm() {
        return listefilm;
    }

    public void chargeBD() throws IOException {
        BD_locale bd=new BD_locale(System.getProperty("user.dir")+"/src/BDD/BDlocale");
        listefilm=bd.getFilms();
    }
}

