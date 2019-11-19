package UI;

import Fonct.Historique.Film;
import Fonct.Historique.HistoriqueBancaire;
import Fonct.Historique.HistoriqueLocation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HistoriqueController extends  Controller implements Initializable {

    @FXML
    public ImageView logo;

    @FXML
    public ListView listhist;

    @FXML
    public ListView lhist;

    public HistoriqueController() throws IOException {
        super();
    }


    @FXML
    public void GoHome(){

        Stage stage = (Stage)logo.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(new Scene(root, 640, 400));
        stage.show();
    }

    @FXML
    public void GoCompte(){

        Stage stage = (Stage)logo.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("compte.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(new Scene(root, 640, 400));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listhist.getItems().add("Bancaire");
        listhist.getItems().add("Location");
        listhist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {

                if (newValue.equals("Location"))
                {

                    for(HistoriqueLocation h : hist.voirHistLocation()) {
                        System.out.println("plop");
                        System.out.println(h);
                        lhist.getItems().add(h.toString());
                    }
                }
            }
        });
    }
}
