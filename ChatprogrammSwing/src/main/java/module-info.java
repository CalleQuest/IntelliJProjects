module com.example.chatprogrammswing {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.serverapp to javafx.fxml;
    exports com.example.serverapp;

    opens clientapp to javafx.fxml;
    exports clientapp;
}