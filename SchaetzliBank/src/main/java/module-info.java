module com.example.schaetzlibank {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.schaetzlibank to javafx.fxml;
    exports com.example.schaetzlibank;
}