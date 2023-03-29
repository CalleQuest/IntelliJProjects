package com.example.serverapp;

import java.io.*;
import java.net.Socket;

public class ClientProxy implements Runnable {

    private String username;
    private Socket clientSocket;
    private HelloController serverCon;
    //Brauchen wir fürs empfangen von daten
    private OutputStream out;
    private PrintWriter writer;

    //Braucht man für daten welche der Client schicken will
    private InputStream in;
    private BufferedReader reader;
    private String inputString;

    private Thread t1;

    public ClientProxy(HelloController serverControll, Socket newSocket) throws IOException {
        this.serverCon = serverControll;
        this.clientSocket = newSocket;

        //Date an Client senden
        out = clientSocket.getOutputStream();
        writer = new PrintWriter(out);

        //Daten, welche vom Client gesendet werden
        in = clientSocket.getInputStream();
        reader = new BufferedReader(new InputStreamReader(in));

        this.username = username;

        t1 = new Thread(this);
        t1.start();

    }
    //Hier schickt der Client den Thread
    @Override
    public void run() {
        try {
            inputString = null;

            while ((inputString = reader.readLine()) != null) {
            serverCon.nachrichtenBox.appendText(inputString+"\n");
            }
            writer.close();
            reader.close();
        }catch (IOException e)
        {
            System.out.println(e);
        }
    }
    }

