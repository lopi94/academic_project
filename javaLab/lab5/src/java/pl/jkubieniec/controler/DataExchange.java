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
import pl.jkubieniec.model.Quiz;
import pl.jkubieniec.model.Results;

/**
 * Class responsible for comunication beetwen model dan servlets
 * @author Julia Kubieniec
 * @version 1.2
 */
public class DataExchange {
    /** variable holding the main object  */
    private Quiz controler; 
    /** variable to define if save result to file results.txt  */
    private boolean saveResults = false;
    /**
     * variable holds model data
     */
    private List<String> outData = new ArrayList();
    /**
     * variable holds results
     */
    private List<String> outResults = new ArrayList();
    
    /**
     * construktor
     */
    DataExchange(){
        try {
            initQuizzesData();
        } catch (IOException ex) {
            Logger.getLogger(DataExchange.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MyException ex) {
            Logger.getLogger(DataExchange.class.getName()).log(Level.SEVERE, null, ex);
        } catch (StringIndexOutOfBoundsException ex) {
            Logger.getLogger(DataExchange.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Logger.getLogger(DataExchange.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Method responsible for get request from client and choose correct method 
     * to realize operation choose by client
     */
    public List<String> sendRequest(String answer)  {
        try {
            outData.clear();
            char sign = answer.charAt(0);
            //0,1,2 - initQuiz; r - get results; e - end quiz
            switch (sign) {
                case '0':  initQuiz(0); 
                    break;
                case '1':  initQuiz(1);
                    break;
                case '2':  initQuiz(2);
                    break;
                case 'e':  EndQuiz(answer);
                    break;
                case 'r':  GetResultsFromFile();
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
        controler.setResults(quizNumber,nick);
        outData.add(Integer.toString(controler.getScore()));
        for(int i = 0; i < 5; i++){
            controler.setAnswerUser(quizNumber, i, "");
        }
        return outData;
    }
    
    /**
     * Method responsible for get results from model,
     * and send it to serwlet
     * @throws IOException 
     */
    private void GetResultsFromFile() throws IOException {
        outData.clear();
        try {
            if(saveResults) {
                List<Results<String,Integer>> tmp = controler.getResults();
                for(Results x : tmp){ 
                    outData.add((String)x.getNick());
                    outData.add((String)x.getWhichQuiz());
                    outData.add((String)x.getScoreString());
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            outData.add("Error: ");
            outData.add("e");
        }
    }
    
    /**
     * Method responsible for init Quizzes that mean:
     * get questions from file,
     * get results from file results.txt
     * @throws IOException,FileNotFoundException, MyException, StringIndexOutOfBoundsException, ArrayIndexOutOfBoundsException 
     */
    private void initQuizzesData() throws IOException, FileNotFoundException, MyException, 
            StringIndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
            
        controler = new Quiz();
        controler.createNewQuiz("quiz1.txt");
        controler.createNewQuiz("quiz2.txt");
        controler.createNewQuiz("quiz3.txt");
        if(controler.getResultsFromFile()){
            List<Results<String,Integer>> tmp = controler.getResults();
            for(Results x : tmp){ 
                    outResults.add((String)x.getNick());
                    outResults.add((String)x.getWhichQuiz());
                    outResults.add((String)x.getScoreString());
                }
            saveResults = true;
        }
    }
    
    /**
     * Method responsible for send questions for quizNumber quiz to servlet
     * @throws IOException 
     */
    private void initQuiz(int quizNumber) throws IOException {
  
        for(int i = 0; i < 5; i++) {
            outData.add(controler.getText(quizNumber, i, "Q"));
            outData.add(controler.getText(quizNumber, i, "A"));
            outData.add(controler.getText(quizNumber, i, "B"));
            outData.add(controler.getText(quizNumber, i, "C"));
        }
        
    }
   
}
