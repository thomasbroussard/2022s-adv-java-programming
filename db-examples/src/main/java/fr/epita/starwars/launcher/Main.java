package fr.epita.starwars.launcher;

import com.sun.net.httpserver.HttpServer;
import fr.epita.starwars.datamodel.Planet;
import fr.epita.starwars.services.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        long beforeInit = System.currentTimeMillis();
        PlanetDAO dao = new PlanetNeo4JDAO();
        StringConversionService stringService = new JsonConversionService();
        HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0",8098), 0);
        server.createContext("/test", exchange -> {
            String requestMethod = exchange.getRequestMethod();
            switch (requestMethod) {
                case "GET":
                    List<Planet> planets = dao.search(new Planet());
                    String test_received = String.valueOf(stringService.convert(planets));
                    exchange.sendResponseHeaders(200, test_received.getBytes().length);
                    exchange.getResponseBody().write(test_received.getBytes());
                    break;
            }
            exchange.close();
        });
        server.start();
        long afterInit = System.currentTimeMillis();
        System.out.println("initialization in " + (afterInit - beforeInit) +" ms");
    }
}