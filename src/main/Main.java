package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/design/_gui.fxml"));
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("/resources/Icon.PNG"));
        primaryStage.sizeToScene();
        primaryStage.show();
        primaryStage.toFront();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
