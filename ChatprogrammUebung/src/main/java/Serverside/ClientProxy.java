package Serverside;

import Clientside.ClientController;

import java.io.*;
import java.net.Socket;

public class ClientProxy implements Runnable {
    private ServerController controller;

    private OutputStream out;
    private PrintWriter writer;

    private InputStream in;
    private BufferedReader reader;

    private Thread t;



    public ClientProxy(ServerController controller,Socket socket) throws IOException {
        this.controller = controller;
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
        writer.write(message+"\n");
        writer.flush();
    }

    @Override
    public void run() {
        try{
            String s;

            while ((s= reader.readLine()) != null)
            {
                controller.broadcast(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
