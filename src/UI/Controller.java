package UI;

import Fonct.Historique.Historique;
import Fonct.Input_Output.BD_Distante;
import Fonct.Input_Output.BD_Locale;
import Fonct.Personne.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller  {
    BD_Locale bdl;
    BD_Distante bdd;
    Client cl;
    static String numcl;

    public Controller() throws IOException {
        bdl=new BD_Locale(System.getProperty("user.dir")+"\\src\\BDD\\BDlocale".replace("\\",System.getProperty("file.separator")));
        bdd=new BD_Distante(System.getProperty("user.dir")+"\\src\\BDD\\BDdistante".replace("\\",System.getProperty("file.separator")));
        cl=bdd.identification(numcl);
        if (cl==null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setHeaderText("Probleme avec la carte");
            alert.setContentText("Client inexistant, contacter un administrateur");
            alert.showAndWait();
            System.exit(1);
        }
    }
}
