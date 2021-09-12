package bookstoreapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CustomerBuy extends LogOut {

    @FXML
    private Label tc;

    @FXML
    public void initialize() {

        Main.removeIfselect();

        String status = "";

        if (CustomerStartScreen.getCustomer().getPoints() > 1000) {
            status += "Gold";
        } else {
            status += "Silver";
        }

        String s = "Your TC: $" + CustomerStartScreen.getTc() + "\n\n\n\n\n\nPoints: "
                + CustomerStartScreen.getCustomer().getPoints() + "\n\n\n\n\n\nStatus: "
                + status;
        tc.setText(s);

    }

}
