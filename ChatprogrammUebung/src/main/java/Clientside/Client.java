package Clientside;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable {
    private Socket socket;
    private ClientController controller;

    private OutputStream out;
    private PrintWriter writer;

    private InputStream in;
    private BufferedReader reader;

    private Thread t;



    public Client (String ipadress, int port, ClientController controller) throws IOException {
        this.controller = controller;

        socket = new Socket(ipadress,port);
        System.out.println("Client gestartet");

        out = socket.getOutputStream();
        writer = new PrintWriter(out);

        in = socket.getInputStream();
        reader = new BufferedReader(new InputStreamReader(in));

        t= new Thread(this);
        t.start();
    }

    public void sendMessage(String message)
    {
     writer.write(message+ "\n");
     writer.flush();
    }

    @Override
    public void run() {
        try{
            String s;

            while ((s= reader.readLine()) != null)
            {
                controller.chatbox.appendText(s+"\n");
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
