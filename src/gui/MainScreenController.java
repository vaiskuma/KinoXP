package gui;

import database.BookingCRUD;
import database.DBconnection;
import domain.Booking;
import domain.BookingList;
import domain.Movie;
import domain.MovieList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ADMIN on 02/10/2017.
 */
public class MainScreenController implements Initializable {
    @FXML
    public Button mainAdd;
    @FXML
    public Button mainDelete;
    @FXML
    public TableView<Movie> movies;
    @FXML
    public TableColumn<Movie , String> movieName;
    @FXML
    public TableColumn<Movie , String> movieDes;
    @FXML
    private MovieList moviess = MovieList.getInstance();
    private BookingList bookings = BookingList.getInstance();
    private ObservableList<Movie> movieList = moviess.getTheMovieList();
    private ObservableList<Booking> bookingList = bookings.getTheBookingList();
    DBconnection db = new DBconnection();
    private BookingCRUD bookingCRUD = new BookingCRUD();

    public void initializeMovieTable() {

        movies.setEditable(true);
        movieName.setCellValueFactory(new PropertyValueFactory<>("title"));
        movieName.setCellFactory(TextFieldTableCell.forTableColumn());
        movieDes.setCellValueFactory(new PropertyValueFactory<>("des"));
        movieDes.setCellFactory(TextFieldTableCell.forTableColumn());
        movies.setItems(movieList);

    }

    @FXML
    private void btnMainAdd() {
        try {
            SceneManager.getInstance().loadAddMovieScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnDelete(){
        Movie byeMovie = movies.getSelectionModel().getSelectedItem();
        if(!db.deleteMovie(moviess,byeMovie));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeMovieTable();
    }

    public void btnLogOut() throws IOException {
        SceneManager.getInstance().loadUserScene();
    }
}
