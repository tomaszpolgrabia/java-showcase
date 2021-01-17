package ch.tpolgrabia.javashowcase.javafxdemo.services;

import javafx.scene.Scene;

public interface SceneFactory {
    Scene loadHomeScene();

    Scene loadLoginScene();
}
