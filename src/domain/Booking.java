package domain;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by ADMIN on 29/09/2017.
 */
public class Booking {

    private StringProperty name = new SimpleStringProperty(this,"name","unknown");
    private StringProperty email = new SimpleStringProperty(this,"email","unknown");
    private StringProperty title = new SimpleStringProperty(this,"title","unknown");
    private IntegerProperty time = new SimpleIntegerProperty(this, "time",0);
    private IntegerProperty tel = new SimpleIntegerProperty(this, "tel",0);
    int id;

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public int getTime() {
        return time.get();
    }

    public IntegerProperty timeProperty() {
        return time;
    }

    public void setTime(int time) {
        this.time.set(time);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTel() {
        return tel.get();
    }

    public IntegerProperty telProperty() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel.set(tel);
    }

    public Booking(String name, String email, int tel, int time, String title) {
        this.name.setValue(name);
        this.email.setValue(email);
        this.title.setValue(title);
        this.time.setValue(time);
        this.tel.setValue(tel);
    }


}
