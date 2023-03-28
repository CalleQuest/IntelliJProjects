package com.example.serverapp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable {

    private ArrayList<ClientProxy> clientListe = new ArrayList<ClientProxy>();
    private static int benutzer = 0;
    private ServerSocket serverSock;
    private Thread t1;

    private HelloController controller;

    public Server(HelloController controller)
    {
        this.controller = controller;
    }


    public Thread messageReceive = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                inputString = null;

                while ((inputString = reader.readLine()) != null) {
                    writer.write(inputString + "\n");
                    writer.flush();
                    System.out.println("Empfangen vom Client: " + inputString);
                }
                writer.close();
                reader.close();
            }catch (IOException e)
            {
                System.out.println(e);
            }
        }
    });
    private OutputStream out;
    private PrintWriter writer;
    private String inputString;
    private InputStream in;
    private BufferedReader reader;

    public void createServer(int port)
    {
        //beim servercreate wird der kreirte server zu einem thread durch die line unter diesen kommentar
        t1 = new Thread(this);
        try
        {
            serverSock = new ServerSocket(port);
            System.out.println("Server gestartet");
            messageReceive.start();


        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        try
        {
            while(true)
            {
                clientListe.add(new ClientProxy(controller,serverSock.accept()));
            }
            //Neuen client anlegen

        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
