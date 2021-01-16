package ch.tpolgrabia.javashowcase.javafxdemo;

import ch.tpolgrabia.javashowcase.javafxdemo.controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

// TODO add event bus like system to switch between views and add messaging
public class JavaFxApplication extends Application {
    private Stage stage;
    private FXMLLoader loader;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        this.loader = new FXMLLoader();

        switchToLogin();
    }

    @Override
    public void stop() {
        this.stage = null;
        this.loader = null;
    }

    private void switchToLogin() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("login.fxml")) {
            var loader = new FXMLLoader();
            Parent root = loader.load(is);
            LoginController loginController = loader.getController();
            loginController.setSwitchToHome(this::switchToHome);
            var scene = new Scene(root, 640, 480);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void switchToHome() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("home.fxml")) {
            Parent root = loader.load(is);
            var scene = new Scene(root, 640, 480);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
