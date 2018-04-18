package domain;

import database.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by ADMIN on 29/09/2017.
 */
public class BookingList {

    private static BookingList ourInstance = new BookingList();
    private ObservableList<Booking> theBookingList = FXCollections.observableArrayList();


    public ObservableList<Booking> getTheBookingList() {
        return theBookingList;
    }

    public static BookingList getInstance() {
        return ourInstance;
    }

    private BookingList(){
        DBconnection db = new DBconnection();
        db.loadBookings(this);
    }
}
