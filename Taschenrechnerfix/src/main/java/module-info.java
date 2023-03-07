module com.example.taschenrechnerfix {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.taschenrechnerfix to javafx.fxml;
    exports com.example.taschenrechnerfix;
}