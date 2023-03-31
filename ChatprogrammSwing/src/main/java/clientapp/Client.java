package clientapp;

import javafx.scene.control.Alert;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable {

    public String getUsername() {
        return username;
    }

    private ChatController controller;
    private String username;
    private Socket client;

    private OutputStream out;
    private PrintWriter writer;

    private InputStream in;
    private BufferedReader reader;

    private String message;

    public void createClient(Serverobj server, String username,ChatController controller) {
        try
        {
            if (controller.txtUsername.getText()!="")
            {
                this.controller=controller;
                client = new Socket(server.getIpAdresse(), server.getPort());
                System.out.println("Client gestartet");

                //Daten an Server senden setup
                out = client.getOutputStream();
                writer = new PrintWriter(out);

                //Daten, welche vom Server gesendet werden setup
                in = client.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in));

                this.username = username;
                controller.txtUsername.setDisable(true);
                new Thread(this).start();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Bitte Username eingeben");
                alert.setTitle("UsernameError");
                alert.showAndWait();
            }



        }
        catch (IOException e)
        {
            System.out.println(e);
        }

    }
    public void dataSend(String message)
    {
        if (controller.message.getText() != "")
        {
            writer.write(message + "\n");
            writer.flush();
        }

    }

    public void datenEmpfang()
    {
        try {
            String s = null;

            while ((s = reader.readLine())!= null)
            {
                controller.chatBox.appendText(s+"\n");
                System.out.println(s);

                //System.out.println("Empfangen vom Server:" + s);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Messagereceiver
    @Override
    public void run() {
        datenEmpfang();
    }
}
