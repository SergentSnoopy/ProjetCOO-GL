package UI;

import Fonct.Historique.Historique;
import Fonct.Input_Output.BD_Distante;
import Fonct.Input_Output.BD_locale;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller  {
    BD_locale bdl;
    BD_Distante bdd;
    Historique hist;

    public Controller() throws IOException {
        bdl=new BD_locale(System.getProperty("user.dir")+"\\src\\BDD\\BDlocale".replace("\\",System.getProperty("file.separator")));
        bdd=new BD_Distante(System.getProperty("user.dir")+"\\src\\BDD\\BDlocale".replace("\\",System.getProperty("file.separator")));
        hist=new Historique();
    }
}
