package UI;

import Fonct.Input_Output.BD_Distante;
import Fonct.Input_Output.BD_Locale;
import Fonct.Personne.Client;
import Fonct.Personne.Technicien;
import javafx.scene.control.Alert;

import java.io.IOException;

public class Controller {
    static String num;
    BD_Locale bdl;
    BD_Distante bdd;
    Client cl;
    Technicien tech;
    String typePerso;

    public String getTypePerso() {
        return typePerso;
    }

    public Controller() throws IOException {
        bdl = new BD_Locale(System.getProperty("user.dir") + "\\src\\BDD\\BDlocale".replace("\\", System.getProperty("file.separator")));
        bdd = new BD_Distante(System.getProperty("user.dir") + "\\src\\BDD\\BDdistante".replace("\\", System.getProperty("file.separator")));
        cl = bdd.identification(num);
        if (cl == null) {
            tech=bdd.identificationTechnicien(num);
            if(tech==null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alert");
                alert.setHeaderText("Probleme avec la carte");
                alert.setContentText("Personne inexistante, contacter un administrateur");
                alert.showAndWait();
                System.exit(1);
            }
        }
        if(cl!=null)
            typePerso="Client";
        else if(tech!=null)
            typePerso="Technicien";
    }
}
