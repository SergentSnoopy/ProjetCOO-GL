package UI;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class RechargeController extends Controller {

    @FXML
    public ImageView logo;
    @FXML
    public TextField num;
    @FXML
    public Label mont;
    @FXML
    public Button bt1;
    @FXML
    public Button bt2;
    @FXML
    public Button bt3;
    @FXML
    public Button bt4;
    @FXML
    public Button bt5;
    @FXML
    public Button bt6;

    public RechargeController() throws IOException {
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

    @FXML
    public void SetMontant(Event e) {

        mont.setText(((Button) e.getSource()).getText());
    }

    @FXML
    public void Valider() throws IOException {

        if (!num.getText().isEmpty() && !mont.getText().isEmpty()) {
            cl.rechargerCompte(num.getText(), Integer.parseInt(mont.getText()));
            bdd.commit();


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Recharger");
            alert.setHeaderText("Recharger");
            alert.setContentText("Vous avez recharger votre carte de " + mont.getText());
            alert.showAndWait();

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
    }
}
