/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.jkubieniec.controler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.exit;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static pl.jkubieniec.controler.Main.PORT;

/**
 * Class responsible for connection client to serwer, 
 * and for comunication beetween client and server
 * @author Julia Kubieniec
 * @version 1.1
 */
public class ConnectionClient {
    /** socket representing connection to the client */
    private Socket socket;
    /** buffered input character stream */
    private BufferedReader in;
    /** Formatted output character stream */
    private PrintWriter out;
    /** Create server name */
    String serverName;
    /** data from serwer*/
    private List<String> inData =  new ArrayList();
    
    /**
     * construktor
     */
    public ConnectionClient() {
        serverName = "localhost";
        try{
            socket = new Socket(serverName,PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Error: " +  e, "Error", JOptionPane.ERROR_MESSAGE);
            exit(1);
        }
    }
    
    /**
     * Method responsible for close socket which representing connection to the client
     * @throws IOException 
     */
    public void closeClient() throws IOException {
        socket.close();
    }
    
    /**
     * Method responsible for send request to server and get answer from serwer
     * @param request - request that is send to server
     * @return inData - data get from server
     * @throws IOException 
     */
    public List<String> sendRequest(String request) throws IOException {
        
        out.println(request);
        inData.clear();
        boolean flag = true;
        while(flag){
            while(in.ready()) {
                inData.add(in.readLine());
                if(inData.get(inData.size()-1).equals("EOT") ) {
                    flag = false;
                }
            }
        }
        
        return inData;
    }
    
}
