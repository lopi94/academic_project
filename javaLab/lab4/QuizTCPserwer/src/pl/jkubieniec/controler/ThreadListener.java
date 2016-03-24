/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jkubieniec.controler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static pl.jkubieniec.controler.Main.PORT;

/**
 * Class responsible for connection between client and server 
 * @author Julia Kubieniec
 * @version 1.2
 */
public class ThreadListener extends Thread {
    
     /** socket representing connection to the client */
    private Socket client;
     /** socket representing serwer */
    private ServerSocket server;
    
    
    @Override
    public void run() {
        try {
            server = new ServerSocket(PORT,1000);
            while(true){
                client = server.accept();

                new DataExchange(client).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
