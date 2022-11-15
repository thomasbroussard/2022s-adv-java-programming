package org.example;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws IOException {
        long beforeInit = System.currentTimeMillis();
        HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0",8098), 0);
        server.createContext("/test", exchange -> {
            String requestMethod = exchange.getRequestMethod();
            switch (requestMethod) {
                case "GET":
                    String test_received = "test received";
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