package Clientside;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ClientController {

    private Client client;
    @FXML
    private TextField portInput,adresseInput,message;
    @FXML
    protected TextArea chatbox;
    @FXML
    private Button btnConnect,send;


    public void connect() throws IOException {
        int port = Integer.parseInt(portInput.getText());
        String adresse = adresseInput.getText();
        client = new Client(adresse,port,this);
    }
    public void send()
    {
        client.sendMessage(message.getText());
    }
}