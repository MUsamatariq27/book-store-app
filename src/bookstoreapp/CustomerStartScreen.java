package bookstoreapp;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;

public class CustomerStartScreen extends LogOut {

    private static Customer customer;
    private static double Tc;

    @FXML
    private Button buybtn;

    @FXML
    private Button redeembtn;

    @FXML
    private Label cInfo;

    @FXML
    private TableView booksTable;

    @FXML
    public void initialize() {
        String status = "";

        if (customer.getPoints() > 1000) {
            status += "Gold";
        } else {
            status += "Silver";
        }

        String s = "Welcome " + customer.getUsername() + ". You have "
                + customer.getPoints() + " points. Your Status is "
                + status + ". ";

        cInfo.setText(s);

        ObservableList<Book> BObsList = Main.getBooksList();
        booksTable.setItems(BObsList);

        TableColumn<Book, String> bname = new TableColumn<Book, String>("Book Name");
        bname.setCellValueFactory(new PropertyValueFactory<>("Name"));
        booksTable.getColumns().add(bname);

        TableColumn<Book, Double> bprice = new TableColumn<Book, Double>("Price");
        bprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        booksTable.getColumns().add(bprice);

        TableColumn<Book, Boolean> sel = new TableColumn<>("Select Box");
        sel.setCellValueFactory(new PropertyValueFactory<>("select"));

        booksTable.getColumns().add(sel);

    }

    public static void setCustomer(Customer c) {

        customer = c;
    }

    @FXML
    public void buybooks(ActionEvent e) throws IOException {

        double tc = 0.0;

        ObservableList<Book> l = Main.getBooksList();

        for (Book b : l) {
            if (b.getSelect().isSelected()) {
                tc += b.getPrice();
            }
        }

        int p = (int) tc;

        Tc = tc;
        if (tc > 0.0) {

            int cur = customer.getPoints();

            cur += (p * 10);
            customer.setPoints(cur);

            Main m = new Main();
            m.changeScene("Customer-Tc-buy.fxml");

        }

    }

    @FXML
    public void RdBuy(ActionEvent e) throws IOException {

        double tc = 0.0;

        ObservableList<Book> l = Main.getBooksList();

        for (Book b : l) {
            if (b.getSelect().isSelected()) {
                tc += b.getPrice();
            }
        }

        int p = (int) tc;

        Tc = tc;
        System.out.println(Tc);
        if (tc > 0.0) {

            int cur = customer.getPoints();
            int a = cur / 100;

            if (a >= p) {
                int n = (a - p) * 100;
                cur = n;
                Tc = 0.0;
            } else {
                int ptR = cur / 100;
                Tc = tc - (double) ptR;
                cur = ((int) Tc) * 10;
            }

            customer.setPoints(cur);
            Main m = new Main();
            m.changeScene("Customer-Tc-buy.fxml");

        }

    }

    public static Customer getCustomer() {
        return customer;
    }

    public static double getTc() {
        return Tc;
    }

}
