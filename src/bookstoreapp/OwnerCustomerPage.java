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

public class OwnerCustomerPage extends OwnerBack {

    @FXML
    private TableView<Customer> CustomerTable;
    @FXML
    private Button addcus;
    @FXML
    private Label error;
    @FXML
    private Label error1;
    @FXML
    private TextField username;
    @FXML
    private TextField pass;
    @FXML
    private Button btndeletecust;

    @FXML
    public void initialize() {

        ObservableList<Customer> CustList = Main.getCustomerList();
        CustomerTable.setItems(CustList);

        TableColumn<Customer, String> usrname = new TableColumn<Customer, String>("Username");
        usrname.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<Customer, String> pas = new TableColumn<Customer, String>("Password");
        pas.setCellValueFactory(new PropertyValueFactory<>("password"));

        TableColumn<Customer, Integer> pts = new TableColumn<Customer, Integer>("Points");
        pts.setCellValueFactory(new PropertyValueFactory<>("points"));

        CustomerTable.getColumns().addAll(usrname, pas, pts);
    }

    @FXML
    public void deleteCustomer(ActionEvent e) {

        Customer rm = CustomerTable.getSelectionModel().getSelectedItem();
        Main.removeCustomer(rm);

    }

    public void AddCustomer() throws IOException {

        String usrname = username.getText();
        String pas = pass.getText();
        error1.setText("");

        if (usrname.isEmpty() || pas.isEmpty()) {

            error.setText("Empty Field(s)!");
        } else {

            boolean exists = false;

            ObservableList<Customer> CustList = Main.getCustomerList();

            for (int i = 0; i < CustList.size(); i++) {

                String s = CustList.get(i).getUsername();
                if (s.equals(usrname)) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                error.setText("A Customer with this username already exists! If the user forgot password");
                error1.setText("please remove him and then re-add it again with the new password");
            } else {
                error.setText("");
                Main.addCustomer(usrname, pas);
            }
        }

    }

}
