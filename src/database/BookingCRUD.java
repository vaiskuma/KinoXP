package database;

import domain.Booking;
import domain.BookingList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ADMIN on 29/09/2017.
 */
public class BookingCRUD {


        public boolean addBookingDB(BookingList bookingList, Booking booking){
            DBconnection db = new DBconnection();

            try {

                ResultSet getId= db.makeQuery("select max(id) from bookings");
                getId.next();
                int id =getId.getInt(1)+1;
                String sql = "INSERT INTO bookings VALUES('" + booking.getName() +"', '" + booking.getEmail() +"',  '" + booking.getTel() +"', '" + booking.getTime() +"', '" + id +"', '" + booking.getTitle() +"');";


                Connection con = DBconnection.getConnection();
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
                con.close();
                booking.setId(id);
                bookingList.getTheBookingList().add(booking);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        }
    }


