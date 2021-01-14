module ch.tpolgrabia.javashowcase.javafx1demo {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    opens ch.tpolgrabia.javashowcase.javafxdemo to javafx.fxml;
    exports ch.tpolgrabia.javashowcase.javafxdemo;
}
