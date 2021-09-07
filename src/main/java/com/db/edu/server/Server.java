package com.db.edu.server;

import java.io.*;
import java.net.ServerSocket;

public class Server {
    private int port;
    private String historyFilePath;
    private ServerSocketConnectionController controller = new ServerSocketConnectionController();

    /**
     * Class Server implements a logic of Metaphora chat server.
     *
     * @param port - number of port server should be listening
     */
    Server(int port, String historyFilePath) {
        this.port = port;
        this.historyFilePath = historyFilePath;
    }

    /**
     * Start listening given port. Create new Socket when connection established.
     */
    public void start() {
        new Thread(controller).start();
        try (final ServerSocket listener = new ServerSocket(port)) {
            while (true) {
                controller.pushNewConnection(new ServerSocketConnection(listener.accept(), historyFilePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}