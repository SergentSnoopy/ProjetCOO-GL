package UI;

import Fonct.Input_Output.BD_Distante;
import Fonct.Input_Output.BD_Locale;
import Fonct.Personne.Client;
import javafx.scene.control.Alert;

import java.io.IOException;

public class Controller {
    static String numcl;
    BD_Locale bdl;
    BD_Distante bdd;
    Client cl;

    public Controller() throws IOException {
        bdl = new BD_Locale(System.getProperty("user.dir") + "\\src\\BDD\\BDlocale".replace("\\", System.getProperty("file.separator")));
        bdd = new BD_Distante(System.getProperty("user.dir") + "\\src\\BDD\\BDdistante".replace("\\", System.getProperty("file.separator")));
        cl = bdd.identification(numcl);
        if (cl == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setHeaderText("Probleme avec la carte");
            alert.setContentText("Client inexistant, contacter un administrateur");
            alert.showAndWait();
            System.exit(1);
        }
    }
}
