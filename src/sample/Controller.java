package sample;

import database.DBconnection;
import domain.MovieList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    private MovieList movies;
    private DBconnection db;



    @FXML
    public TextField title;
    @FXML
    public TextArea des;
    @FXML
    public Button addMovie;


}
