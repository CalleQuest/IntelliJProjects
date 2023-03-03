module com.example.javafxeinfuehrung2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxeinfuehrung2 to javafx.fxml;
    exports com.example.javafxeinfuehrung2;
}