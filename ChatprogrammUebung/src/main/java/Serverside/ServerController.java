package Serverside;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ServerController {

    protected static int benutzer = 0;
    protected ArrayList<ClientProxy> clientList = new ArrayList<ClientProxy>();
    protected Server server;
    @FXML
    private TextArea chatlog;
    @FXML
    private Label status;
    @FXML
    private TextField txtPort;


    public void broadcast(String message)
    {
        for (ClientProxy proxy : clientList)
        {
            proxy.sendMessage(message);
            chatlog.appendText(message+"\n");
        }
    }

    public void createServer() {
        try
        {
            server = new Server(Integer.parseInt(txtPort.getText()),this);
            status.setText("Server läuft...");
            txtPort.setDisable(true);
        }
        catch (IOException e)
        {
            System.out.println("Server konnte nicht gestartet werden");
        }

    }




}