package UI;

import Fonct.Historique.Film;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchController extends Controller implements Initializable {
    @FXML
    public ImageView logo;
    @FXML
    public ListView listfilm;
    @FXML
    public ListView listfilmdist;
    @FXML
    public Label titre;
    @FXML
    public Text desc;
    @FXML
    public ImageView aff;


    public SearchController() throws IOException {
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
    public void Rent(){

        hist.addLocation(titre.getText(),"",Boolean.FALSE);
        System.out.println(hist.voirHistLocation());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Film> films = this.bdl.getFilms();
        for (Film f :  films)
        {
            listfilm.getItems().add(f);
        }
        listfilm.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Film>() {
            public void changed(ObservableValue<? extends Film> observable,
                                Film oldValue, Film newValue) {
                titre.setText(newValue.getTitre());
                desc.setText(newValue.getResume());
                aff.setImage(new Image(new File("src/Img/".replace("/",System.getProperty("file.separator"))+newValue.getAffiche()).toURI().toString()));;
            }
        });
    }
}
