package ch.tpolgrabia.javashowcase.javafxdemo.controllers;

import ch.tpolgrabia.javashowcase.javafxdemo.models.SwitchToHomeEvent;
import com.google.common.eventbus.EventBus;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;

    private EventBus eventBus;

    @FXML
    public void handleLogin() {
        System.out.printf("Got data login: %s, password: %s\n",
                login.getText(), password.getText());
        eventBus.post(new SwitchToHomeEvent());
    }

    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }
}
