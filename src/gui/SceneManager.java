package gui;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
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

    public void loadMainScene() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/gui/MainScreen.fxml"));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("movies.png")));
    }

    public void loadUserScene() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/gui/UserMainScreen.fxml"));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("movies.png")));
    }

    void loadAddMovieScene() throws IOException {
        Parent movieRoot = FXMLLoader.load(getClass().getResource("/gui/AddMoviesScene.fxml"));
        Scene addMovieScene = new Scene(movieRoot, 600, 400);
        primaryStage.setScene(addMovieScene);
    }

    void loadLoginScene() throws IOException{
        Parent loginRoot = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));
        Scene loginScene = new Scene(loginRoot, 600, 400);
        primaryStage.setScene(loginScene);
    }
    void loadDeleteMovieScene() throws IOException {
        Parent deleteRoot = FXMLLoader.load(getClass().getResource("/gui/DeleteMoviesScene.fxml"));
        Scene deleteMovieScene = new Scene(deleteRoot, 600, 400);
        primaryStage.setScene(deleteMovieScene);
    }

    void loadBookingScene() throws IOException{
        Parent loginRoot = FXMLLoader.load(getClass().getResource("/gui/BookingMovieScene.fxml"));
        Scene loginScene = new Scene(loginRoot, 600, 400);
        primaryStage.setScene(loginScene);
    }

    void displayError(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }

    void displayInformation(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }
}
