package com.example.serverapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    Server server = new Server();
    @FXML
    private TextField portInput;
    @FXML
    private Label serverStatus;
    @FXML
    private Button serverBtn;

    public void serverMaker()
    {
        if (portInput.getText() != "" && isNumeric(portInput.getText()) == true) {
            server.createServer(Integer.parseInt(portInput.getText()));
            serverStatus.setText("Server läuft");
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Bitte Portnummer eingeben");
            alert.setHeaderText("Fehler");
            alert.showAndWait();
        }
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}