/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.jkubieniec.controler;

import pl.jkubieniec.view.InterfaceJFrame;
import pl.jkubieniec.view.Nick;

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
        
         String tmpNick = "";
    
         // Set the Nimbus look and feel 
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            // If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            //  For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(InterfaceJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(InterfaceJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(InterfaceJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(InterfaceJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            
        if(args.length != 0) {
            tmpNick = args[0];
        } else {
            Nick nick = new Nick();
            tmpNick = nick.getNick();
        }

        final String nick = tmpNick;

        ConnectionClient connect = new ConnectionClient();

       // Create and display the form 
        java.awt.EventQueue.invokeLater(() -> {
            new InterfaceJFrame(connect,nick).setVisible(true);
        });
    }
}
