package UI;

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

public class CompteController extends  Controller implements Initializable {

    @FXML
    public ImageView logo;

    public CompteController() throws IOException {
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
    public void GoHist(){

        Stage stage = (Stage)logo.getScene().getWindow();
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

    }
}
