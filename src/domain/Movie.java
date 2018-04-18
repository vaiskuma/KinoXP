package domain;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by ADMIN on 18/09/2017.
 */
public class Movie {

    private StringProperty title = new SimpleStringProperty(this,"title","unknown");
    private StringProperty director= new SimpleStringProperty(this,"director","unknown");
    private StringProperty des = new SimpleStringProperty(this,"description","unknown");
    private IntegerProperty duration = new SimpleIntegerProperty(this, "duration",0);
    int id;

    public Movie(StringProperty title, StringProperty director, StringProperty des, IntegerProperty duration) {
        this.title = title;
        this.director = director;
        this.des = des;
        this.duration = duration;
    }

    public Movie(String title, String director, String des, int duration) {
        this.title.setValue(title);
        this.director.setValue(director);
        this.des.setValue(des);
        this.duration.setValue(duration);
        setListeners();
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

    public String getDirector() {
        return director.get();
    }

    public StringProperty directorProperty() {
        return director;
    }

    public void setDirector(String director) {
        this.director.set(director);
    }

    public String getDes() {
        return des.get();
    }

    public StringProperty desProperty() {
        return des;
    }

    public void setDes(String des) {
        this.des.set(des);
    }

    public int getDuration() {
        return duration.get();
    }

    public IntegerProperty durationProperty() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration.set(duration);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private void setListeners(){
        title.addListener(

                (v, oldValue, newValue)->{
                    MovieList.getInstance().updateMovie(this, "title", newValue);
                });
        director.addListener(
                //this is a lambda expression,
                (v, oldValue, newValue)->{
                    MovieList.getInstance().updateMovie(this, "director", newValue);
                });
        des.addListener(
                //this is a lambda expression,
                (v, oldValue, newValue)->{
                    MovieList.getInstance().updateMovie(this, "description", newValue);
                });
        duration.addListener(
                //this is a lambda expression,
                (v, oldValue, newValue)->{
                    String duration = Integer.toString(newValue.intValue());
                    MovieList.getInstance().updateMovie(this, "duration", duration);
                });

    }


}
