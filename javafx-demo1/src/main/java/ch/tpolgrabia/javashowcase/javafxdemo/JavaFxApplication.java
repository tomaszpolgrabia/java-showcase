package ch.tpolgrabia.javashowcase.javafxdemo;

import ch.tpolgrabia.javashowcase.javafxdemo.models.SwitchToHomeEvent;
import ch.tpolgrabia.javashowcase.javafxdemo.models.SwitchToLoginEvent;
import ch.tpolgrabia.javashowcase.javafxdemo.services.SceneFactory;
import ch.tpolgrabia.javashowcase.javafxdemo.services.SceneFactoryImpl;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import javafx.application.Application;
import javafx.stage.Stage;

// TODO add event bus like system to switch between views and add messaging
// TODO add guice to provide better factory style di-injection.
public class JavaFxApplication extends Application {
    private Stage stage;
    private EventBus eventBus;
    private SceneFactory factory;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        this.eventBus = new EventBus();
        this.eventBus.register(this);
        this.factory = new SceneFactoryImpl(eventBus);
        eventBus.post(new SwitchToLoginEvent());
    }

    @Override
    public void stop() {
        this.stage = null;
    }

    @Subscribe
    public void switchToLogin(SwitchToLoginEvent event) {
        stage.setScene(factory.loadLoginScene());
        stage.show();

    }

    @Subscribe
    public void switchToHome(SwitchToHomeEvent event) {
        stage.setScene(factory.loadHomeScene());
        stage.show();

    }
}
