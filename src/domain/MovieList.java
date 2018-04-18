package domain;
import database.DBconnection;
import database.MovieCRUD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADMIN on 18/09/2017.
 */
public class MovieList {


    private static MovieList ourInstance = new MovieList();
    private ObservableList<Movie> theMovieList = FXCollections.observableArrayList();


    public ObservableList<Movie> getTheMovieList() {
        return theMovieList;
    }

    public static MovieList getInstance() {
        return ourInstance;
    }

    private MovieList(){
        DBconnection db = new DBconnection();
        db.loadMovies(this);
    }


    public void updateMovie(Movie toUpdate, String column, String newValue){
        DBconnection db = new DBconnection();
        System.out.println(toUpdate.getId());
        try {

            db.makeUpdate("UPDATE movies SET "+column+"='"+newValue+"' WHERE id="+toUpdate.getId());
                    } catch (SQLException e) {
                    e.printStackTrace();
                    }
                    }

                    }