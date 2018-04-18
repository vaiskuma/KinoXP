package gui;

import database.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Delete {


    public ObservableList<String> customerOrder() {

        java.util.List<String> members = new ArrayList<String>();

        try {
            Connection con = DBconnection.getConnection();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT      " +
                    "titles   " +

                    "FROM movies ");
            // "WHERE rvID  =  " + ID);

            while (rs.next()) {

                members.add(rs.getString(1));

            }

            con.close();

            ObservableList<String> list = FXCollections.observableArrayList();


            String listString = "";

            for (String s : members) {
                listString += list.add(s);
            }
            System.out.print(list);
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            ObservableList<String> list2 = FXCollections.observableArrayList();
            list2.add("Failed to load");
            return list2;
        }

    }

}
