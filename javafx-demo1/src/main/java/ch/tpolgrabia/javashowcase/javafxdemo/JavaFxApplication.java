package ch.tpolgrabia.javashowcase.javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFxApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        var javaVersion = System.getProperty("java.version");
        var javaFxVersion = System.getProperty("javafx.version");
        var l = new Label(
                String.format("Hello JavaFX %s, running on java %s.",
                        javaFxVersion, javaVersion));
        var scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}
