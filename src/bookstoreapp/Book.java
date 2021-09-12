package bookstoreapp;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;

public class Book {

    private final StringProperty Name;
    private final DoubleProperty price;
    private CheckBox select;

    public Book(String name, double pr) {

        this.Name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(pr);
        this.select = new CheckBox();
    }

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox s) {
        this.select = s;
    }

    public String getName() {

        return Name.get();
    }

    public Double getPrice() {

        return price.get();
    }

}
