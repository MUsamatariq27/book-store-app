package bookstoreapp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {

    private final StringProperty username;
    private final StringProperty password;
    private IntegerProperty points;

    public Customer(String username, String pass) {

        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(pass);
        this.points = new SimpleIntegerProperty(0);

    }

    public String getUsername() {

        return username.get();
    }

    public String getPassword() {

        return password.get();
    }

    public int getPoints() {

        return points.get();
    }

    public void setPoints(int updatedPts) {

        this.points = new SimpleIntegerProperty(updatedPts);
    }

}
