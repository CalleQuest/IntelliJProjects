package clientapp;

import java.io.*;
import java.net.Socket;

public class Client {
    Socket client;

    OutputStream out;
    PrintWriter writer;

    InputStream in;
    BufferedReader reader;

    public void createClient() {
        try
        {
            client = new Socket("localhost", 5555);
            System.out.println("Client gestartet");

            //Daten an Server senden
            out = client.getOutputStream();
            writer = new PrintWriter(out);

            //Daten, welche vom Server gesendet werden
            in = client.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));

            writer.write("Hallo Server!\n");
            writer.flush();

            String s = null;

            while ((s = reader.readLine())!= null)
            {
                System.out.println("Empfangen vom Server:" + s);
            }
            writer.close();
            reader.close();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }

}
