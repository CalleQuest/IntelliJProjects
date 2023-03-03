module com.example.buildereinfuehrung {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.buildereinfuehrung to javafx.fxml;
    exports com.example.buildereinfuehrung;
}