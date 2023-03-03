module com.example.intellijeinfuehrung {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.intellijeinfuehrung to javafx.fxml;
    exports com.example.intellijeinfuehrung;
}