
package pl.polsl.java.lab.project.numbersconversion.Main;

import javax.swing.JOptionPane;
import pl.polsl.java.lab.project.numbersconversion.Calculations.Conversion;
import pl.polsl.java.lab.project.numbersconversion.Display.MenuCommandLine;
import pl.polsl.java.lab.project.numbersconversion.Display.MenuConsole;
import pl.polsl.java.lab.project.numbersconversion.Exception.MyException;

/**
 * Topic 8: Replacement of Arabic numbers into Roman
 * @author Julia Kubieniec
 * @version 1.1
 */
public class ProjectLabJava  {

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
        
        MenuConsole dataConsole = new MenuConsole();
        MenuCommandLine dataCommandLine = new MenuCommandLine();
        Conversion number = new Conversion();
        int tmp;
        
        if (args.length == 0) {
            try {
                tmp = dataConsole.getNumber();
                dataConsole.showNumberArabic(tmp);
                dataConsole.showNumberRoman(number.arabicToRoman(tmp));
            } catch (MyException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Error: " +  e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try {
                tmp = dataCommandLine.getNumber(args[0]);
                dataCommandLine.showNumberArabic(tmp);
                dataCommandLine.showNumberRoman(number.arabicToRoman(tmp));
            } catch (MyException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Error: " +  e, "Error" , JOptionPane.ERROR_MESSAGE );
            }
        }
    }
}