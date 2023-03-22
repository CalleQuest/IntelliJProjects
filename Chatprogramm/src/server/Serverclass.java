package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverclass {
    public static void main(String[] args) {
        try
        {
            ServerSocket server = new ServerSocket(5555);
            System.out.println("Server gestartet");

            Socket client = server.accept();

            //Date an Client senden
            OutputStream out = client.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            //Daten, welche vom Client gesendet werden
            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String s = null;

            while ((s= reader.readLine())!=null)
            {
                writer.write(s + "\n");
                writer.flush();
                System.out.println("Empfangen vom Client: " + s);
            }
            writer.close();
            reader.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
