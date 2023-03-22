package com.example.serverapp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Server implements Runnable {
    private ServerSocket serverSock;
    private Socket clientSock;

    private OutputStream out;
    private PrintWriter writer;
    private String inputString;
    private InputStream in;
    private BufferedReader reader;

    public void createServer(int port)
    {
        try
        {
            serverSock = new ServerSocket(port);
            System.out.println("Server gestartet");

            clientSock = serverSock.accept();

            //Date an Client senden
             out = clientSock.getOutputStream();
             writer = new PrintWriter(out);

            //Daten, welche vom Client gesendet werden
            in = clientSock.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));

            inputString = null;

            while ((inputString = reader.readLine())!=null)
            {
                writer.write(inputString + "\n");
                writer.flush();
                System.out.println("Empfangen vom Client: " + inputString);
            }
            writer.close();
            reader.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void run() {

    }
}
