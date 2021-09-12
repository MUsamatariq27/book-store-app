package bookstoreapp;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LogOut {

    @FXML
    private Button logout;

    public void userLogout(ActionEvent e) throws IOException {

        Main m = new Main();
        m.changeScene("LoginPage.fxml");
    }

}
