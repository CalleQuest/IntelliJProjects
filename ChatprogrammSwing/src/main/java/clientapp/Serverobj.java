package clientapp;

public class Serverobj {

    private String serverName;
    private String ipAdresse;
    private int port;

    public Serverobj(String serverName, String ipAdresse, int port) {
        this.serverName = serverName;
        this.ipAdresse = ipAdresse;
        this.port = port;
    }

    public String getServerName() {
        return serverName;
    }

    public String getIpAdresse() {
        return ipAdresse;
    }

    public int getPort() {
        return port;
    }
    @Override
    public String toString() {
        return serverName;
    }
}
