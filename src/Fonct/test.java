package Fonct;

import Fonct.Historique.Film;
import Fonct.Historique.*;
import Fonct.Input_Output.*;
import Fonct.Personne.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class test {
    public static void main(String[] args) throws IOException, InterruptedException {

        Client c=new Client("Sollier","Mathieu","gare");
        System.out.println(c.getNumCarte());
        c.rechargerCompte("01234",200);

        System.out.println("Working Directory = " +
                System.getProperty("user.dir")+"/src/BDD/BDlocale");

        System.out.println(c.getListefilm().get(0).getNbDispo());
        c.louerFilm("Terminator","James Cameron");
        c.voirHistorique();
        System.out.println(c.getListefilm().get(0).getNbDispo());
        Thread.sleep(3000);
        c.rendreFilm("Terminator","James Cameron");
        c.voirHistorique();
        System.out.println(c.getListefilm().get(0).getNbDispo());



    }
}
