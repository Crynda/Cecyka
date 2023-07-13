module com.scenes {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.scenes to javafx.fxml;
    exports com.scenes;
}
