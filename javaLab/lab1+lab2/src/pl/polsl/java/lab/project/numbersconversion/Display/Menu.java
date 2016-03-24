/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.java.lab.project.numbersconversion.Display;

/**
 * Class responsible for communication with the user
 * @author Julia Kubieniec
 * @version 1.1
 */
public class Menu {
    
    /** number variable will store the number given by user */
    protected int number;
       
    /**
     * This metod display arabic number
     * @param number - the number entered by the user
     */
    public void showNumberArabic (int number) {
        System.out.println("Given the number: " + number);
    }
    
    /**
     *  This metod display roman number
     * @param number - the number calculated by the arabicToRoman method
     */
    public void showNumberRoman (String number) {
        System.out.println("The number after conversion: " + number);
    }
    
}
