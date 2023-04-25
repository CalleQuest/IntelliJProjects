module com.example.chatprogrammuebung {
    requires javafx.controls;
    requires javafx.fxml;

    opens Clientside to javafx.fxml;
    opens Serverside to javafx.fxml;
    exports Serverside;
    exports Clientside;
}