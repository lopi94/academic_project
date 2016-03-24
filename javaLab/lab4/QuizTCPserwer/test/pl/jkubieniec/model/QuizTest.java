/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * package pl.jkubieniec.modelcointain class responsible for program logic 
 */
package pl.jkubieniec.model;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class responsible for testting class Quiz
 * @author Julia Kubieniec
 * @version 1.0
 */
public class QuizTest {
    
    public QuizTest() {
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
     * Test of createNewQuiz method, of class Quiz.
     */
    @Test
    public void testCreateNewQuizIncorect() throws Exception {
        System.out.println("createNewQuiz - incorect situation");
        String path = "incorectfile";
        Quiz instance = new Quiz();
        boolean expResult = true;
        boolean result = instance.createNewQuiz(path);
        assertEquals(expResult, result);   
    }
    
    /**
     * Test of createNewQuiz method, of class Quiz.
     */
    @Test
    public void testCreateNewQuizCorect() throws Exception {
        System.out.println("createNewQuiz - corect situation");
        String path = "quiz1.txt";
        Quiz instance = new Quiz();
        boolean expResult = true;
        boolean result = instance.createNewQuiz(path);
        assertEquals(expResult, result);   
    }

    /**
     * Test of getResultsFromFile method, of class Quiz.
     */
    @Test
    public void testGetResultsFromFileIncorect() throws Exception {
        System.out.println("getResultsFromFile - incorect situation");
        Quiz instance = new Quiz();
        boolean expResult = false;
        boolean result = instance.getResultsFromFile();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getResultsFromFile method, of class Quiz.
     */
    @Test
    public void testGetResultsFromFileCorect() throws Exception {
        System.out.println("getResultsFromFile - corect situation");
        Quiz instance = new Quiz();
        boolean expResult = true;
        boolean result = instance.getResultsFromFile();
        assertEquals(expResult, result);
    }

    /**
     * Test of saveResultsToFile method, of class Quiz.
     */
    @Test
    public void testSaveResultsToFile() throws Exception {
        System.out.println("saveResultsToFile");
        String nick = "";
        String quiz = "";
        int score = 0;
        Quiz instance = new Quiz();
        instance.saveResultsToFile(nick, quiz, score);
    }

    /**
     * Test of calculateScore method, of class Quiz.
     */
    @Test
    public void testCalculateScoreIncorect() throws IOException, MyException {
        System.out.println("calculateScore - incorect situation");
        int quizId = 0;
        Quiz instance = new Quiz();
        instance.createNewQuiz("quiz1.txt");
        instance.setAnswerUser(0, 0, "B");
        instance.setAnswerUser(0, 1, "A");
        instance.setAnswerUser(0, 2, "B");
        instance.setAnswerUser(0, 3, "C");
        instance.setAnswerUser(0, 4, "A");
        int expResult = 7;
        int result = instance.calculateScore(quizId);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of calculateScore method, of class Quiz.
     */
    @Test
    public void testCalculateScoreCorect() throws IOException, MyException {
        System.out.println("calculateScore - corect situation");
        int quizId = 0;
        Quiz instance = new Quiz();
        instance.createNewQuiz("quiz1.txt");
        instance.setAnswerUser(0, 0, "B");
        instance.setAnswerUser(0, 1, "A");
        instance.setAnswerUser(0, 2, "B");
        instance.setAnswerUser(0, 3, "C");
        instance.setAnswerUser(0, 4, "A");
        int expResult = 5;
        int result = instance.calculateScore(quizId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getScore method, of class Quiz.
     */
    @Test
    public void testGetScore() throws IOException, MyException {
        System.out.println("getScore");
        Quiz instance = new Quiz();
        instance.createNewQuiz("quiz1.txt");
        instance.setAnswerUser(0, 0, "B");
        instance.setAnswerUser(0, 1, "A");
        instance.setAnswerUser(0, 2, "B");
        instance.setAnswerUser(0, 3, "C");
        instance.setAnswerUser(0, 4, "A");
        int expResult = instance.calculateScore(0);
        int result = instance.getScore();
        assertEquals(expResult, result);
    }

}
