/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * package pl.jkubieniec.model cointain class responsible for program logic 
 */
package pl.jkubieniec.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for create tne quizzes, calculate score of quizzes and 
 * set answer of the User
 * @author Julia Kubieniec
 * @version 1.3
 */
public class Quiz {

    /**
     * List of qiuzzes cointains Q&A 
     */
    private List<List<Question<String>>> quizy = new ArrayList<>();
    /**
     * variable to get amount of score in quiz
     */
    private int score;   
    
    /**
     * method to create new quiz from the txt file
     * @param list
     * @return true if quiz was added correctly, otherwise false
     * @throws FileNotFoundException
     * @throws IOException
     * @throws MyException 
     * @throws StringIndexOutOfBoundsException
     * @throws ArrayIndexOutOfBoundsException
     */
    public boolean createNewQuiz(List<Question<String>> list) throws FileNotFoundException, IOException,
            MyException, StringIndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
        
        List<Question<String>> quiz = new ArrayList<>();
        
        for(int i = 0; i < 5; i++) {
            quiz.add(list.get(i));
        }
        quizy.add(quiz);
        
        for(int i = 5; i < 10; i++) {
            quiz.add(list.get(i));
        }
        quizy.add(quiz);
        
        for(int i = 10; i < 15; i++) {
            quiz.add(list.get(i));
        }
        quizy.add(quiz);
        
        
        if (quizy.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
        
    /**
     * method to calculate amount of points scored in the quiz
     * @param quizId the quizId to get correct quiz
     * @return the amount of score
     */
    public int calculateScore(int quizId){
        score = 0;
        for (Question q : quizy.get(quizId)) {
            if(q.getAnswerUser().equals(q.getAnswerOk())){
                score += 1;
            }
        }
        
        return score;
    }
 
    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }
    
     /**    
     * method to set the anwserUser 
     * @param quizId the quizId to get correct quiz
     * @param questionId the questionId to get correct question
     * @param answer the answerUser to set
     */
    public void setAnswerUser(int quizId, int questionId, String answer) {
        quizy.get(quizId).get(questionId).setAnswerUser(answer);
    }

}
