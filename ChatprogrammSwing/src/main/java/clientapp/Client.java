package clientapp;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable {

    public String getUsername() {
        return username;
    }

    private String username;
    private Socket client;

    private OutputStream out;
    private PrintWriter writer;

    private InputStream in;
    private BufferedReader reader;

    private String message;

    public void createClient(Serverobj server, String username) {
        try
        {
            client = new Socket(server.getIpAdresse(), server.getPort());
            System.out.println("Client gestartet");

            //Daten an Server senden setup
            out = client.getOutputStream();
            writer = new PrintWriter(out);

            //Daten, welche vom Server gesendet werden setup
            in = client.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));

            this.username = username;



        }
        catch (IOException e)
        {
            System.out.println(e);
        }

    }
    public void dataSend(String message)
    {
        writer.write(message + "\n");
        writer.flush();
    }

    public void datenEmpfang()
    {
        try {
            String s = null;

            while ((s = reader.readLine())!= null)
            {
                System.out.println("Empfangen vom Server:" + s);
            }
            writer.close();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

   /* Thread dataEmpfaenger = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                String s = null;

                while ((s = reader.readLine())!= null)
                {
                    System.out.println("Empfangen vom Server:" + s);
                }
                writer.close();
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    });*/
    // Messagereceiver
    @Override
    public void run() {
        datenEmpfang();
    }
}
