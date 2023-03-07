module com.example.taschenrechnerfixfix {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.taschenrechnerfixfix to javafx.fxml;
    exports com.example.taschenrechnerfixfix;
}