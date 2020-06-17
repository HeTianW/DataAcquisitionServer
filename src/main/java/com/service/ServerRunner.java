package com.service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerRunner {
    public static void main(String[] args) {
        try {

            Server server = new Server(2020, "127.0.0.1");
            new Thread(server).start();

        } catch (IOException ex) {
            Logger.getLogger(ServerRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
