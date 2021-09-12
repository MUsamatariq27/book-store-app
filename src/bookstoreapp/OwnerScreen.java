package bookstoreapp;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class OwnerScreen extends LogOut {

    @FXML
    private Button bookbtn;
    @FXML
    private Button cusbtn;

    @FXML
    public void GoBooksPage(ActionEvent e) throws IOException {

        Main m = new Main();
        m.changeScene("OwnerBooksPage.fxml");

    }

    @FXML
    public void GoOCustPage(ActionEvent e) throws IOException {

        Main m = new Main();
        m.changeScene("Owner-Customer-Page.fxml");

    }

}
