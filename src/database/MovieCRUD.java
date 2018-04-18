package database;

import domain.Movie;
import domain.MovieList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MovieCRUD {

public boolean addMovieDB(MovieList movieList, Movie movie){
    DBconnection db = new DBconnection();

    try {

        ResultSet getId= db.makeQuery("select max(id) from movies");
        getId.next();
        int id =getId.getInt(1)+1;
        String sql = "INSERT INTO movies VALUES('" + movie.getTitle() +"', " +
                "'" + movie.getDirector() +"',  '" + movie.getDes() +"', '" + movie.getDuration() +"', '" + id +"');";



        Connection con = DBconnection.getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate(sql);
        con.close();
        movie.setId(id);
        movieList.getTheMovieList().add(movie);
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }

}
}
