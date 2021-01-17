module ch.tpolgrabia.javashowcase.javafx1demo {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires com.google.common;

    opens ch.tpolgrabia.javashowcase.javafxdemo to javafx.fxml;
    opens ch.tpolgrabia.javashowcase.javafxdemo.controllers to javafx.fxml;
    exports ch.tpolgrabia.javashowcase.javafxdemo;
}
