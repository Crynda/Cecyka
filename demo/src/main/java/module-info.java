module com.cecyka.scenes {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.cecyka.scenes to javafx.fxml;
    exports com.cecyka.scenes;
}
