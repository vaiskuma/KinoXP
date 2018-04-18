package gui;

import database.DBconnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

public class DeleteMoviesSceneController implements Initializable {


    public ComboBox combo;
    DBconnection db = new DBconnection();

    @FXML
    void btnDeleteMovie() throws SQLException {
        String titleDel = "a Film";

        String message = "Do you wish to delete the selected film?";

        Object[] options = {"Yes",
                "No"};

        final JOptionPane optionPane = new JOptionPane(                 //40-45 & 53-56  = dialogue popup
                "Do you wish to delete the selected film",
                JOptionPane.QUESTION_MESSAGE,
                YES_NO_OPTION);
        int dialogue = JOptionPane.showOptionDialog(optionPane, message, "Warning!", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        Connection con = DBconnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT      " +
                "id " +

                "FROM movies WHERE `movies`.`titles`= Inceptionx");
        int id = rs.getInt(5);

        if (dialogue == YES_OPTION) {

            Statement prepstmt = con.createStatement();
            String sql = ("DELETE FROM `kinoxp`.`movies`" +
                    "WHERE  `movies`.`id`=" + id );
            prepstmt.execute(sql);
            con.close();

        } else if (dialogue == NO_OPTION) {
            System.out.println("Cancelled");

        }
    }
    @FXML
    void btnMenu(){
        try{
            SceneManager.getInstance().loadMainScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void populate() {
        Delete del = new Delete();
        combo.setItems(del.customerOrder());

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populate();
    }
}
