package bookstoreapp;

//import bookstoreapp.Customer;
//import bookstoreapp.Main;
import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Login {

    @FXML
    private Button loginbtn;
    @FXML
    private Label loginerror;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void userLogIn(ActionEvent e) throws IOException {

        checkLogin();

    }

    public void checkLogin() throws IOException {

        Main m = new Main();

        String usrname = username.getText();
        String pass = password.getText();

        if (usrname.equals("admin") && pass.equals("admin")) {
            m.changeScene("Owner-Screeen.fxml");

        } else if (usrname.isEmpty() || pass.isEmpty()) {

            loginerror.setText("Empty Field(s)!");
        } else {
            ObservableList<Customer> c = Main.getCustomerList();
            boolean userfound = false;

            for (int i = 0; i < c.size(); i++) {
                Customer person = c.get(i);
                if (person.getUsername().equals(usrname) && person.getPassword().equals(pass)) {
                    userfound = true;
                    CustomerStartScreen.setCustomer(person);
                    m.changeScene("Customer-Start-Screen.fxml");
                    break;
                }

            }

            if (!userfound) {
                loginerror.setText("User not found! Incorrect Username or/and Password.");
            }
        }

    }

}
