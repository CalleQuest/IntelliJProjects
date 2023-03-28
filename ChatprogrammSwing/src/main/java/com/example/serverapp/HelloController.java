package com.example.serverapp;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    private Server server = new Server(this);
    @FXML
    private TextField portInput;
    @FXML
    private Label serverStatus;
    @FXML
    private Button serverBtn;
    @FXML
    protected TextArea nachrichtenBox;


    public void serverMaker() {
        if (portInput.getText() != "" && isNumeric(portInput.getText())) {
            server.createServer(Integer.parseInt(portInput.getText()));
            serverStatus.setText("Server läuft");

            //server.messageReceive.start();
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