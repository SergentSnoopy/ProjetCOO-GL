package UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TechController extends Controller implements Initializable {

    @FXML
    public ImageView logo;
    @FXML
    public Label solde;

    public TechController() throws IOException {
        super();
    }

    @FXML
    public void Eject() {
        System.exit(0);
    }

    @FXML
    public void GoRendre() {
        System.out.println("Test");
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
    public void Vip() throws IOException {
        if (!cl.getIsSubscribed()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VIP");
            alert.setHeaderText("VIP");
            if (cl.becomeVIP()) {

                alert.setContentText("Vous etez VIP");
            } else alert.setContentText("Solde insufisant");
            alert.showAndWait();
            bdd.commit();
        }
    }

    @FXML
    public void GoRecharge() {

        Stage stage = (Stage) logo.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Recharger.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(new Scene(root, 640, 400));
        stage.show();
    }

    @FXML
    public void GoHist() {

        Stage stage = (Stage) logo.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Historique.fxml"));
        } catch (IOException ex) {
            //ex.printStackTrace();
            System.out.println(ex);
        }
        stage.setScene(new Scene(root, 640, 400));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        solde.setText(""+cl.getCurrentBalance()+"€");
    }
}
