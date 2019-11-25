package UI;

import Fonct.Historique.Film;
import Fonct.Historique.Historique;
import Fonct.Historique.HistoriqueBancaire;
import Fonct.Historique.HistoriqueLocation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class RendreController extends Controller implements Initializable {
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
    public void Return() throws IOException {
        if(listfilm.getSelectionModel().getSelectedItem()==null)
        {

        }
        else {
            Date d = new Date();
            HistoriqueLocation h=new HistoriqueLocation(d.toString(),((HistoriqueLocation)listfilm.getSelectionModel().getSelectedItem()).getMovieTitle(),((HistoriqueLocation)listfilm.getSelectionModel().getSelectedItem()).getDirector(),-1,"Rendue");
            cl.getHistoric().getRentHistList().add(h);
            ArrayList<Film> listFilm=bdl.getFilms();
            Film f = new Film(((HistoriqueLocation) listfilm.getSelectionModel().getSelectedItem()).getMovieTitle(),((HistoriqueLocation) listfilm.getSelectionModel().getSelectedItem()).getDirector());

            for (int i = 0; i < listFilm.size(); i++) {
                if(listFilm.get(i).getTitle().equals(f.getTitle()) && listFilm.get(i).getDirector().equals(f.getDirector())){
                    listFilm.get(i).returnMovie();
                }
            }

            listfilm.getItems().remove(listfilm.getSelectionModel().getSelectedItem());
            bdd.commit();
            bdl.commit(listFilm);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rent.setVisible(false);

        ArrayList<HistoriqueLocation> temp= new ArrayList<>();
        for (HistoriqueLocation h: cl.getHistoric().getRentHistList())
        {

            if (h.getActionType().equals("Location"))
            {
                listfilm.getItems().add(h);
                temp.add(h);
            }
            if (h.getActionType().equals("Rendue"))
            {

                for (HistoriqueLocation p : temp)
                {
                    System.out.println(p.getMovieTitle());
                    if (p.equals(h))
                    {
                        listfilm.getItems().remove(h);
                    }
                }
            }
        }
        listfilm.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<HistoriqueLocation>() {
            @Override
            public void changed(ObservableValue<? extends HistoriqueLocation> observable, HistoriqueLocation oldValue, HistoriqueLocation newValue) {
                if (newValue != null) {
                    rent.setVisible(true);

                } else {
                    rent.setVisible(false);
                }
            }
        });

    }
}
