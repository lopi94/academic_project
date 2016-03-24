/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.jkubieniec.controler;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * My own Topic: Quiz 
 * @author Julia Kubieniec
 * @version 1.1
 */
public class Main {

    /** port number */
    static int PORT = 2345;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            new ThreadListener().start();
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Error: " +  e, "Server Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


