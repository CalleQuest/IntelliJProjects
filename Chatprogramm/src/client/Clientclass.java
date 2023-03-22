package client;

import java.io.*;
import java.net.Socket;

public class Clientclass {
    public static void main(String[] args) {
        try
        {
            Socket client = new Socket("localhost", 5555);
            System.out.println("Client gestartet");

            //Daten an Server senden
            OutputStream out = client.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            //Daten, welche vom Server gesendet werden
            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

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
