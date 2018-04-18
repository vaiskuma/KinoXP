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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public TextField nameInput;
    public TextField emailInput;
    public TextField telInput;
    private MovieList moviess = MovieList.getInstance();
    private BookingList bookings = BookingList.getInstance();
    private ObservableList<Movie> movieList = moviess.getTheMovieList();
    private ObservableList<Booking> bookingList = bookings.getTheBookingList();
    DBconnection db = new DBconnection();
    private BookingCRUD bookingCRUD = new BookingCRUD();

    @FXML
    public TableColumn<Movie , String> movieName;
    @FXML
    public TableColumn<Movie , String> movieDes;
    @FXML
    private Button mainAdd;
    @FXML
    private Button mainDelete;
    @FXML
    public TableView<Movie> movies;

    Movie selectedMovie = null;




    public void initializeMovieTable() {
        movieName.setCellValueFactory(new PropertyValueFactory<>("title"));
        movieName.setCellFactory(TextFieldTableCell.forTableColumn());
        movieDes.setCellValueFactory(new PropertyValueFactory<>("des"));
        movieDes.setCellFactory(TextFieldTableCell.forTableColumn());
        movies.setItems(movieList);
        ObservableList<String> times = FXCollections.observableArrayList();
        times.addAll("1600", "1800", "2000", "2200" );
        selectTime.setItems(times);

    }



    @FXML
    private void btnLogin(){
        try {
            SceneManager.getInstance().loadLoginScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    public ChoiceBox selectTime;
    @FXML
    public Label movieTitle;

    @FXML
    private void showTime(MouseEvent event){
        ObservableList<String> times = FXCollections.observableArrayList();
        times.addAll("1600", "1800", "2000", "2200" );
        selectTime.setItems(times);
    }

    @FXML
    private void selectedMovie(MouseEvent click) throws IOException {
        if (click.getClickCount() == 2 && click.getButton().equals(MouseButton.PRIMARY)) {
            Movie m = movies.getSelectionModel()
                    .getSelectedItem();
            try {
                SceneManager.getInstance().loadBookingScene();
                movieTitle.setText(m.getTitle());
            } catch (IOException e) {
                System.out.println("e");
            }
            System.out.println(m);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initializeMovieTable();

        }

    public void btnBooking() throws IOException {
        selectedMovie = movies.getSelectionModel().getSelectedItem();


        String name = nameInput.getText();
        String email = emailInput.getText();
        int tel = Integer.parseInt(telInput.getText());
        String tim = selectTime.getValue().toString();
        int time = Integer.parseInt(tim);

        if (name.isEmpty() || email.isEmpty() || tel == 0 || time == 0 || selectedMovie == null) {
            SceneManager.getInstance().displayError("Missing Info", null, "Please fill all fields");
            } else {
            bookingCRUD.addBookingDB(bookings, new Booking(name, email, tel, time, selectedMovie.getTitle()));
            nameInput.clear();
            emailInput.clear();
            telInput.clear();
            SceneManager.getInstance().displayInformation("Reservation completed!", null, "Reservation has been completed!");
            }
        }


}

