package ch.tpolgrabia.javashowcase.javafxdemo.services;

import ch.tpolgrabia.javashowcase.javafxdemo.controllers.LoginController;
import com.google.common.eventbus.EventBus;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.io.InputStream;

public class SceneFactoryImpl implements SceneFactory {

    private Scene homeScene;
    private EventBus eventBus;

    public SceneFactoryImpl(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public Scene loadHomeScene() {
        if (homeScene != null) {
            return homeScene;
        }

        try (InputStream is = getClass().getClassLoader().getResourceAsStream("home.fxml")) {
            Parent root = new FXMLLoader().load(is);

            if (root == null) {
                System.out.println("Couldn't find parent...");
                return null;
            }

            homeScene = new Scene(root, 640, 480);
            return homeScene;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Scene loadLoginScene() {
        FXMLLoader loader = new FXMLLoader();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("login.fxml")) {
            Parent parent = loader.load(is);

            if (parent == null) {
                System.out.println("Couldn't load login component...");
                return null;
            }
            LoginController loginController = loader.getController();
            loginController.setEventBus(eventBus);
            Scene scene = new Scene(parent, 640, 480);
            return scene;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
