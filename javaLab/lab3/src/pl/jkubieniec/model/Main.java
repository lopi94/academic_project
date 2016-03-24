/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * package pl.jkubieniec.model cointain class responsible for program logic 
 */
package pl.jkubieniec.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.CodeSource;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pl.jkubieneic.view.InterfaceJFrame;

/**
 * My own Topic: Quiz
 * @author Julia Kubieniec
 * @version 1.0
 */ 
public class Main {
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Quiz quiz = new Quiz();
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
            String[] options = {"OK"};
            JPanel panel = new JPanel();
            JLabel lbl = new JLabel("Enter Your nick: ");
            JTextField txt = new JTextField(10);
            panel.add(lbl);
            panel.add(txt);
            do{
                int selectedOption = JOptionPane.showOptionDialog(null, panel, "Nick", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);

                if(selectedOption == 0)
                {
                    tmpNick = txt.getText();
                    if(tmpNick.equals("")) {
                        JOptionPane.showMessageDialog(null,"Enter Your nick !!!");
                    }
                }
            } while(tmpNick.equals(""));
        }
       
        try {    
           //.getFile()
            quiz.createNewQuiz("quiz1.txt");
            quiz.createNewQuiz("quiz2.txt");
            quiz.createNewQuiz("quiz3.txt");
//            quiz.createNewQuiz(Main.class.getResource("quiz1.txt").getPath());
//            quiz.createNewQuiz(Main.class.getResource("quiz2.txt").getPath());
//            quiz.createNewQuiz(Main.class.getResource("quiz3.txt").getPath());
        } catch(IOException | MyException | StringIndexOutOfBoundsException
                    | ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null,"Error: " +  e, "Error", JOptionPane.ERROR_MESSAGE);
        }
         
        final String nick = tmpNick;
            
           // Create and display the form 
        java.awt.EventQueue.invokeLater(() -> {
            new InterfaceJFrame(quiz,nick).setVisible(true);
        });
    }
}
