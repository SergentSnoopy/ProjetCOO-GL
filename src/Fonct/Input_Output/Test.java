package Fonct.Input_Output;

import Fonct.Historique.Film;
import Fonct.Personne.Client;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String args[]) {
        try {
            BD_Locale bdl = new BD_Locale("BDlocale");
            BD_Distante bdd = new BD_Distante("BDdistante");

            ArrayList<Film> films = bdl.getFilms();
            Client client = bdd.identification("7325");

            for (Film f : films)
                System.out.println(f.getTitle());
            if (client != null) {
                System.out.println(client.getName());
                System.out.println(client.getHistoric().getBankHistList().size());
                client.setCurrentBalance(5);
            } else
                System.out.println("client not found");
            bdl.commit(films);
            bdd.commit();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
