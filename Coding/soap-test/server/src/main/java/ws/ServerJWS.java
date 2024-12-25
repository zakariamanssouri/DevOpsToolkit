package ws;

import jakarta.xml.ws.Endpoint;

public class ServerJWS {
    public static void main(String args[])
    {
        BanqueService banqueService = new BanqueService();
        String url = "http://0.0.0.0:8888/WS/BanqueService";
        Endpoint.publish(url, banqueService);
        System.out.println("Server started on " + url);
    }
}
