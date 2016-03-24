/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.jkubieniec.view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class responsivle for create own dialog,
 * and for get nick from user
 * @author Julia Kubieniec
 * @version 1.1
 */
public class Nick {
    
    String nick;
    
    /**
     * Method responsivle for create own dialog,
     * and for get nick from user
     * @return nick - user name 
     */
    public String getNick() {
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
                nick = txt.getText();
                if(nick.equals("")) {
                    JOptionPane.showMessageDialog(null,"Enter Your nick !!!");
                }
            }
        } while(nick.equals(""));

        return nick;
    }

}
