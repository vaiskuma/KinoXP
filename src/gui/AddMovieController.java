package gui;

import database.MovieCRUD;
import domain.Movie;
import domain.MovieList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;


/**
 * Created by ADMIN on 18/09/2017.
 */
public class AddMovieController {

    private final MovieCRUD movies = new MovieCRUD();
    private MovieList moviess = MovieList.getInstance();
    private ObservableList<Movie> movieList = moviess.getTheMovieList();

    @FXML
    private TextField titleInput;

    @FXML
    private TextArea descInput;

    @FXML
    private TextField dirInput;

    @FXML
    private TextField durInput;


    @FXML
    private void btnAddMovie() {

        String title = titleInput.getText();
        String director = dirInput.getText();
        String desc = descInput.getText();
        int duration = Integer.parseInt(durInput.getText());
        String dur = durInput.getText();


        if (title.isEmpty() || desc.isEmpty() || director.isEmpty() || dur.isEmpty()) {
            SceneManager.getInstance().displayError("Missing Info", null, "Please fill all fields");
        } else {
            movies.addMovieDB(moviess, new Movie(title, director, desc, duration));
            titleInput.clear();
            dirInput.clear();
            durInput.clear();
            descInput.clear();
            SceneManager.getInstance().displayInformation("Movie saved!", null, "Movie has been saved!");
        }
    }

    @FXML
    private void btnMenu() {
        try {
            SceneManager.getInstance().loadMainScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



