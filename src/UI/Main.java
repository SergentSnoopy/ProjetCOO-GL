package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller.num = getParameters().getRaw().get(0);
        Controller controller=new Controller();
        Parent root;
        if(controller.getTypePerso().equals("Client"))
            root=FXMLLoader.load(getClass().getResource("Home.fxml"));
        else
            root=FXMLLoader.load(getClass().getResource("Tech.fxml"));
        primaryStage.setTitle("DVD Manager");
        primaryStage.setScene(new Scene(root, 640, 400));
        primaryStage.show();
    }
}
