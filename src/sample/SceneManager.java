package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by ADMIN on 18/09/2017.
 */
public class SceneManager {
    private static SceneManager instance;

    private SceneManager(){}

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    private Stage primaryStage;
    public void setStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    void loadAddMovieScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/AddMoviesScene.fxml"));
        primaryStage.setScene(new Scene(root, 300, 275));
    }

    void loadMainMenu() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/MainScreen.fxml"));
        primaryStage.setScene(new Scene(root, 300, 275));
    }

    void loadDeleteMovieScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/DeleteMoviesScene.fxml"));
        primaryStage.setScene(new Scene(root, 300, 275));
    }




}
