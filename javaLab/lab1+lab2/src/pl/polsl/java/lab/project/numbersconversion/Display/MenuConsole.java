
package pl.polsl.java.lab.project.numbersconversion.Display;
import java.util.Scanner;
import pl.polsl.java.lab.project.numbersconversion.Exception.MyException;

/**
 * Class responsible for communication with the user using the console
 * @author Julia Kubieniec
 * @version 1.1
 */
public class MenuConsole extends Menu{
    
     /**
     * method to load the Arabic numerals from the user 
     * @return number - the number given by a user
     * @throws pl.polsl.java.lab.project.numbersconversion.Exception.MyException
     * @throws NumberFormatException
     */
    public int getNumber () throws NumberFormatException, MyException {   
        System.out.println("Enter the number for conversion (permitted range <1, 3999>): ");
        Scanner odczyt = new Scanner(System.in);
        number = Integer.parseInt(odczyt.nextLine());
        
        if (number < 1 || number > 3999) {
            throw new MyException(number);
        }

        return number;
    }
    
}
