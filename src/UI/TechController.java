package UI;

import Fonct.Historique.Film;
import Fonct.Input_Output.BD_Distante;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    public void GoStat() throws IOException{
        System.out.println("Stat");
        ArrayList<Film> AlFilm = bdl.getFilms();

        for (int i = 0; i < AlFilm.size() ; i++) {
            System.out.println(" " + AlFilm.get(i).getTitle() + " - " + AlFilm.get(i).getDirector() + " - " + bdl.getLoc(AlFilm.get(i)));
        }

//        bdl.commit(bdl.getFilms());
    }

    @FXML
    public void GoTop() {
        System.out.println("Top");
    }

    @FXML
    public void GoAdd() throws IOException{
        System.out.println("Add");
        ArrayList<BD_Distante.DemandeAjoutFilm> da = bdd.getDemandesAjoutsFilms();
        ArrayList<Film> bdlListFilm = bdl.getFilms();
        ArrayList<Film> bddListeFilm = bdd.getFilms();

        for (int i = 0; i < bdlListFilm.size(); i++) {
            bdlListFilm.get(i).setNovelty(false);
        }

        for (int i = 0; i < da.size() ; i++) {
            for (int j = 0; j < bddListeFilm.size(); j++) {
                if(da.get(i).getTitre().equals(bddListeFilm.get(j).getTitle()) && da.get(i).getRealisateur().equals(bddListeFilm.get(j).getDirector())) {
                    bddListeFilm.get(j).setNovelty(true);
                    bdlListFilm.add(bddListeFilm.get(j));
                }

            }
        }

        bdl.commit(bdlListFilm);
    }

    public void GoNew() {
        System.out.println("New");
    }

    @FXML
    public void GoHome() {

        Stage stage = (Stage) logo.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Tech.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(new Scene(root, 640, 400));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
