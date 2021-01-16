package ch.tpolgrabia.javashowcase.javafxdemo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;

    private Runnable switchToHome;

    public void setSwitchToHome(Runnable switchToHome) {
        this.switchToHome = switchToHome;
    }

    @FXML
    public void handleLogin() {
        System.out.printf("Got data login: %s, password: %s\n",
                login.getText(), password.getText());
        switchToHome.run();
    }
}
