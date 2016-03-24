/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * package pl.jkubieniec.model cointain class responsible for program logic 
 */
package pl.jkubieniec.model;

/**
 * Class responsible for my own exception
 * @author Julia Kubieniec
 * @version 1.2
 */
public class MyException extends Exception {
    
    /** detalis variable will store the detalis of exception */
    private String detalis;
    
    public MyException(String detalis) {
        this.detalis = detalis;
    }
    
    /**
     * overriding the toString() method to view the content of exception
     * @return the content of exception 
     */
    @Override
    public String toString() {
        return "My Exception: Wrong file type. Required filename.txt been: " + detalis;
    }
}
