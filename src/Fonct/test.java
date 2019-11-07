package Fonct;

import Fonct.Historique.Historique;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        Historique test_hist = new Historique();
        test_hist.addBancaire("01234",200);
        test_hist.addLocation();
        test_hist.voirHistBancaire();

    }
}
