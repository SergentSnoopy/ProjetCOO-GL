package UI;

import Fonct.Historique.Film;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerHome extends Controller implements Initializable {

    @FXML
    public Button compte;
    @FXML
    public ImageView search;
    @FXML
    public ImageView top1;
    @FXML
    public ImageView top2;
    @FXML
    public ImageView top3;
    @FXML
    public TextField textsearch;


    public ControllerHome() throws IOException {
        super();
    }

    @FXML
    public void Comptebutton(ActionEvent event){

        Stage stage = (Stage)compte.getScene().getWindow();
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
    public void GoSearch(){

        Stage stage = (Stage)search.getScene().getWindow();
        Parent root = null;
        try {
            FXMLLoader fx= new FXMLLoader(getClass().getResource("search.fxml"));
            root =fx.load();
            SearchController sc = fx.getController();
            sc.setsearch(textsearch.getText());
            fx.setController(sc);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(new Scene(root, 640, 400));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<ImageView> lt = new ArrayList<ImageView>();
        lt.add(top1);
        lt.add(top2);
        lt.add(top3);
        ArrayList<Film> films = this.bdl.getFilms();
        int i=0;
        for (Film f :  films)
        {
            if (f.getTopVente()&& i<lt.size())
            {
                lt.get(i).setImage(new Image(new File("src/Img/".replace("/",System.getProperty("file.separator"))+f.getAffiche()).toURI().toString()));
                i++;

            }

        }



    }
}
