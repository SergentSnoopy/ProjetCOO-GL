package UI;

import Fonct.Historique.Film;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SearchController extends Controller {
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
    @FXML
    public TextField ts;
    @FXML
    public Button rent;
    @FXML
    public Button ask;


    public SearchController() throws IOException {
        super();
    }

    public void setsearch(String s) {
        this.ts.setText(s);
        this.afficheFilm(s);
        if (s.isEmpty())
            rent.setVisible(false);
        ts.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                afficheFilm(newValue);
            }

        });

        listfilm.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Film>() {
            public void changed(ObservableValue<? extends Film> observable,
                                Film oldValue, Film newValue) {
                if (newValue != null) {
                    titre.setText(newValue.getTitre());
                    desc.setText(newValue.getResume());
                    aff.setImage(new Image(new File("src/Img/".replace("/", System.getProperty("file.separator")) + newValue.getAffiche()).toURI().toString()));
                    if (bdl.getLoc(newValue) != -1) {
                        ask.setVisible(false);
                        rent.setVisible(true);
                    } else {
                        rent.setVisible(false);
                        ask.setVisible(true);
                    }

                } else {
                    titre.setText("");
                    desc.setText("");
                    aff.setImage(null);
                    rent.setVisible(false);
                    ask.setVisible(false);
                }
            }
        });
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
    public void Rent() throws IOException {

        cl.louerFilm(((Film) listfilm.getSelectionModel().getSelectedItem()).getTitre(), ((Film) listfilm.getSelectionModel().getSelectedItem()).getRealisateur());
        bdd.commit();
    }

    @FXML
    public void Ask() throws IOException {

        cl.demanderFilm(((Film) listfilm.getSelectionModel().getSelectedItem()).getTitre(), ((Film) listfilm.getSelectionModel().getSelectedItem()).getRealisateur());
        bdd.commit();
    }

    public void afficheFilm(String s) {

        listfilm.getItems().clear();
        ArrayList<Film> films = this.bdl.getFilms();
        for (Film f : films) {
            if (f.getTitre().toLowerCase().contains(ts.getText().toLowerCase()))
                listfilm.getItems().add(f);
        }
        films = this.bdd.getFilms();
        for (Film f : films) {
            if (!listfilm.getItems().contains(f))
                if (f.getTitre().toLowerCase().contains(ts.getText().toLowerCase()))
                    listfilm.getItems().add(f);
        }
        listfilm.getItems().sort((o1, o2) -> {
            if (o1.equals(o2)) return 0;
            return ((Film) o1).getTitre().compareTo(((Film) o2).getTitre());
        });

    }
}
