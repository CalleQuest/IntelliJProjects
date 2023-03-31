package com.example.serverapp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable {


    private static int benutzer = 0;
    private ServerSocket serverSock;
    private Thread t1;

    private HelloController controller;

    public Server(HelloController controller)
    {
        this.controller = controller;
    }


    private OutputStream out;
    private PrintWriter writer;
    private String inputString;
    private InputStream in;
    private BufferedReader reader;

    public void createServer(int port)
    {
        //beim servercreate wird der kreirte server zu einem thread durch die line unter diesen kommentar

        try
        {
            serverSock = new ServerSocket(port);
            System.out.println("Server gestartet");
            //messageReceive.start();


        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        t1 = new Thread(this);
        t1.start();
    }

    @Override
    public void run() {
        try
        {
            while(true)
            {
                System.out.println("ab hier Parallel vor Anmeldung");
                controller.getClientListe().add(new ClientProxy(controller,serverSock.accept()));
                System.out.println("ab hier Parallel NEUE ANMELDUNG!");
            }
            //Neuen client anlegen

        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
