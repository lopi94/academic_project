/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package pl.jkubieniec.controler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.jkubieniec.model.MyException;
import pl.jkubieniec.model.Question;
import pl.jkubieniec.model.Quiz;

/**
 * Class responsible for comunication beetwen model dan servlets
 * @author Julia Kubieniec
 * @version 1.3
 */
public class DataExchange {
    /** variable holding the main object  */
    private Quiz controler; 
    /**
     * variable holds model data
     */
    private List<String> outData = new ArrayList();
    
    /**
     * construktor
     */
    DataExchange() {
        
    }

    /**
     * Method responsible for get request from client and choose correct method 
     * to realize operation choose by client
     */
    public List<String> sendRequest(String answer)  {
        try {
            outData.clear();
            char sign = answer.charAt(0);
            // e - end quiz
            switch (sign) {
                case 'e':  EndQuiz(answer);
                    break;
            }
            outData.add("EOT");
        } catch ( IOException | StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
            outData.add("Error: ");
            outData.add("e");
            Logger.getLogger(DataExchange.class.getName()).log(Level.SEVERE, null, e); 
        }
        return outData;
    }
    
    /**
     * Method responsible for get user answer from servlet and save it in main object 
     * @param line - request from client
     */
    private void GetAnswers(String line) {
        //line[1] - quizNumber, line[2...6] - UserAnwser
        String quizNumber = "" +  line.charAt(1);
        String questionNumber = "" +  line.charAt(2);
        String userAnswer;
        for(int i = 0; i < 5; i++ ) {
            userAnswer = "" +  line.charAt(i+2);
            controler.setAnswerUser(Integer.parseInt(quizNumber),i,userAnswer);
        }
    }
    
    /**
     * Method responsible for get servlet ended quiz, save result in main object,
     * and send to servlet user scoer
     * @param line - request from client
     * @throws IOException 
     */
    private List<String> EndQuiz(String line) throws IOException {
        //line[1] - quizNumber; line[2...6] - userAnsewrs line[7...] - nick;
        String tmpQuizNumber = "" +  line.charAt(1);
        int quizNumber = Integer.parseInt(tmpQuizNumber);
        String nick = "";
        for(int i = 7; i < line.length(); i++) {
            nick += line.charAt(i);
        }
        GetAnswers(line);
        controler.calculateScore(quizNumber);
        outData.add(Integer.toString(controler.getScore()));
        for(int i = 0; i < 5; i++){
            controler.setAnswerUser(quizNumber, i, "");
        }
        return outData;
    }
    
    /**
     * Method responsible for init Quizzes
     * @param list list of the question that create quiz
     * @throws IOException
     * @throws java.io.FileNotFoundException
     * @throws pl.jkubieniec.model.MyException
     */
    public void initQuizzesData(List<Question<String>> list) throws IOException, FileNotFoundException, MyException {
            
        controler = new Quiz();
        controler.createNewQuiz(list);
    }
   
}
