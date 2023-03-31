package clientapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    private Client client = new Client();
    private ArrayList<Serverobj> serverListe = new ArrayList<Serverobj>();
    private Serverobj localHost = new Serverobj("Lokaler PC","localhost",5555);
    @FXML
    private ComboBox cmbServer;
    @FXML
    protected TextField message,txtUsername;
    @FXML
    protected TextArea chatBox;


    public void sendMessage()
    {
        client.dataSend(client.getUsername()+": "+ message.getText());
    }

    public void serverConnect()
    {
        client.createClient((Serverobj) cmbServer.getSelectionModel().getSelectedItem(),txtUsername.getText(),this);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        serverListe.add(localHost);
        cmbServer.getItems().addAll(serverListe);

    }
}