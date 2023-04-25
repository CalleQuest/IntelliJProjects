package Serverside;

import java.io.IOException;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

    private ServerSocket socket;
    private Socket p;
    private ServerController controller;
    private int port;
    private Thread t;

    public Server(int port, ServerController controller) throws IOException {
        this.port = port;
        this.controller = controller;
        socket = new ServerSocket(port);
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket p = socket.accept();
                controller.clientList.add(new ClientProxy(controller, p));
                controller.benutzer++;
                System.out.println(controller.benutzer);
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

    }
}
