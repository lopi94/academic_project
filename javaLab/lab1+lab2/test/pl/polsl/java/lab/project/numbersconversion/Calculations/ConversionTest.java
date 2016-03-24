/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.java.lab.project.numbersconversion.Calculations;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Julia Kubieniec
 * @version 1.1
 */
public class ConversionTest {
    
    public ConversionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of arabicToRoman method, of class Conversion.
     */
    @Test
    public void testArabicToRomanCorect() {
        System.out.println("arabicToRoman - corect situation");
        int number = 17;
        Conversion instance = new Conversion();
        String expResult = "XVII";
        String result = instance.arabicToRoman(number);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of arabicToRoman method, of class Conversion.
     */
    @Test
    public void testArabicToRomanIncorect() {
        System.out.println("arabicToRoman - incorect situation");
        int number = 0;
        Conversion instance = new Conversion();
        String expResult = "";
        String result = instance.arabicToRoman(number);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of arabicToRoman method, of class Conversion.
     */
    @Test
    public void testArabicToRomanBorder() {
        System.out.println("arabicToRoman - border situation");
        int number = 3999;
        Conversion instance = new Conversion();
        String expResult = "MMMCMXCIX";
        String result = instance.arabicToRoman(number);
        assertEquals(expResult, result);
    }
    
}
