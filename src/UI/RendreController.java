package UI;

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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RendreController extends Controller implements Initializable {

    @FXML
    public ImageView logo;

    @FXML
    public ListView listhist;

    @FXML
    public ListView lhist;

    public RendreController() throws IOException {
        super();
    }


    @FXML
    public void GoHome() {

        Stage stage = (Stage) logo.getScene().getWindow();
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
    public void GoCompte() {

        Stage stage = (Stage) logo.getScene().getWindow();
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

                if (newValue.equals("Location")) {
                    lhist.getItems().clear();
                    for (HistoriqueLocation h : cl.getHistoric().getRentHistList()) {
                        lhist.getItems().add(h.toString());
                    }
                } else if (newValue.equals("Bancaire")) {
                    lhist.getItems().clear();
                    for (HistoriqueBancaire h : cl.getHistoric().getBankHistList()) {
                        lhist.getItems().add(h.toString());
                    }
                }
            }
        });
    }
}
