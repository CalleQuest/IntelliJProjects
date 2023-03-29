package clientapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    private Client client = new Client();
    private ArrayList<Serverobj> serverListe = new ArrayList<Serverobj>();
    private Serverobj localHost = new Serverobj("Lokaler PC","localhost",5555);
    private Thread t1 = new Thread(client);
    @FXML
    private ComboBox cmbServer;
    @FXML
    private TextField message,txtUsername;


    public void sendMessage()
    {
        client.dataSend(client.getUsername()+": "+ message.getText());
    }

    public void serverConnect()
    {
        client.createClient((Serverobj) cmbServer.getSelectionModel().getSelectedItem(),txtUsername.getText());
        t1.start();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        serverListe.add(localHost);
        cmbServer.getItems().addAll(serverListe);

    }
}