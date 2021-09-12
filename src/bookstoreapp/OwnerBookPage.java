package bookstoreapp;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class OwnerBookPage extends OwnerBack {

    @FXML
    private TableView<Book> BooksTable;
    @FXML
    private Button addbtn;
    @FXML
    private Label error;
    @FXML
    private Label error1;
    @FXML
    private TextField bookprice;
    @FXML
    private TextField bookname;
    @FXML
    private Button btndelete;

    @FXML
    public void deleteRow(ActionEvent e) {

        Book rm = BooksTable.getSelectionModel().getSelectedItem();
        Main.removeBook(rm);

    }

    @FXML
    public void initialize() {

        ObservableList<Book> BObsList = Main.getBooksList();
        BooksTable.setItems(BObsList);

        TableColumn<Book, String> bname = new TableColumn<Book, String>("Book Name");
        bname.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn<Book, Double> bprice = new TableColumn<Book, Double>("Price");
        bprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        BooksTable.getColumns().addAll(bname, bprice);
    }

    public void Addbook() throws IOException {

        String bname = bookname.getText();
        String pr = bookprice.getText();
        double pri = 0.0;
        error1.setText("");

        boolean isDouble = true;

        try {
            pri = Double.parseDouble(pr);
        } catch (NumberFormatException e) {
            isDouble = false;
        }

        if (bname.isEmpty() || pr.isEmpty()) {

            error.setText("Empty Field(s)!");
        } else if (!isDouble) {

            error.setText("Please Enter a numeric value for price");
        } else {
            boolean exists = false;

            ObservableList<Book> BObsList = Main.getBooksList();

            for (int i = 0; i < BObsList.size(); i++) {

                String s = BObsList.get(i).getName();
                if (s.equals(bname)) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                error.setText("A book with this name already exists! If you like to update the price of it ");
                error1.setText("please remove it and then add it again with the updated price");
            } else {
                error.setText("");
                Main.addBook(bname, pri);
            }

        }
    }

}
