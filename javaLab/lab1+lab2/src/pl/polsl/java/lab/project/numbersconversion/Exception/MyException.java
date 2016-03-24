
package pl.polsl.java.lab.project.numbersconversion.Exception;

/**
 * Class responsible for my own exception
 * @author Julia Kubieniec
 * @version 1.1
 */
public class MyException extends Exception {
    
    /** detalis variable will store the detalis of exception */
    private int detalis;
    
    public MyException(int detalis) {
        this.detalis = detalis;
    }
    
    /**
     * overriding the toString() method to view the content of exception
     * @return the content of exception 
     */
    @Override
    public String toString() {
        return "My Exception: Out of range: <1;3999> number: " + detalis;
    }
}
