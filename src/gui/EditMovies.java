package gui;

import database.DBconnection;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.PreparedStatement;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Mantas_MSI on 22-Sep-17.
 */
public class EditMovies {

    public void editMovieButton(String whichMovie, String editTitle, String editDirector, String editDescription, int editDuration){

        try {
            Connection con = DBconnection.getConnection();
            Statement stmt = con.createStatement();

            String sql = "UPDATE movies " +
                    "SET "         +
                    "Title          = " +"'" + editTitle        +"'" + ", " +
                    "Director       = " +"'" + editDirector     +"'" + ", " +
                    "Description    = " +"'" + editDescription  +"'" + ", " +
                    "Duration       = " +"'" + editDuration     +"'" + "  " +
                    "WHERE Title    = " +"'" +   whichMovie     +"'" + ";"    ;

            System.out.println(sql);
            stmt.executeUpdate(sql);
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
