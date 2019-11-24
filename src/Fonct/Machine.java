package Fonct;

import Fonct.Historique.Film;
import Fonct.Input_Output.BD_Locale;
import Fonct.Personne.Client;

import java.io.IOException;
import java.util.ArrayList;

public class Machine {
    ArrayList<Film> listeFilm;
    ArrayList<Client> listeClient;
    BD_Locale bd;

    public ArrayList<Client> getListeClient() {
        return listeClient;
    }

    public ArrayList<Film> getListefilm() {
        return listeFilm;
    }

    public BD_Locale getBd() {
        return bd;
    }

    public void chargeBD() throws IOException {
        bd=new BD_Locale(System.getProperty("user.dir")+"/src/BDD/BDlocale");
        listeFilm=bd.getFilms();
    }
}

