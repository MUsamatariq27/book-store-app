package bookstoreapp;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class OwnerBack {

    @FXML
    public Button back;

    @FXML
    public void goBack(ActionEvent e) throws IOException {

        Main m = new Main();
        m.changeScene("Owner-Screeen.fxml");
    }

}
