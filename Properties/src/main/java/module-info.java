module com.example.properties {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.properties to javafx.fxml;
    exports com.example.properties;
}