
package pl.polsl.java.lab.project.numbersconversion.Display;

import pl.polsl.java.lab.project.numbersconversion.Exception.MyException;

/**
 * Class responsible for communication with the user using the command line
 * @author Julia Kubieniec
 * @version 1.1
 */
public class MenuCommandLine extends Menu {
      
    /**
     * method to load the Arabic numerals from the user
     * @param arg - the text given by a user 
     * @return number - the text given by a user after conversion to int
     * @throws pl.polsl.java.lab.project.numbersconversion.Exception.MyException
     * @throws NumberFormatException
     */
    public int getNumber (String arg) throws NumberFormatException, MyException {   
        
        number = Integer.parseInt(arg);
        
        if (number < 1 || number > 3999) {
            throw new MyException(number);
        }
        
        return number;
    }
 
}
