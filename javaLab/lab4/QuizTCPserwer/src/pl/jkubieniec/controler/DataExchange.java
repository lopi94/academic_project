/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.jkubieniec.controler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import javax.swing.JOptionPane;
import pl.jkubieniec.model.MyException;
import pl.jkubieniec.model.Quiz;
import pl.jkubieniec.model.Results;
import static pl.jkubieniec.controler.Main.PORT;

/**
 * Class responsible for connection server to client, 
 * and for comunication beetween client and server
 * @author Julia Kubieniec
 * @version 1.1
 */
public class DataExchange extends Thread {
    /** buffered input character stream */
    private BufferedReader in;
    /** Formatted output character stream */
    private PrintWriter out;
    /** variable holding the controller of the main class  */
    private Quiz controler; 
    /** variable to define if save result to file results.txt  */
    private boolean saveResults = false;
    
    /**
     * construktor
     * @throws IOException 
     */
    public DataExchange(Socket client) throws IOException {
        controler = new Quiz();
            
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
    }
    
    /**
     * Method responsible for get request from client and choose correct method 
     * to realize operation choose by client
     */
    @Override
    public void run()  {
        try {
            while (true) {
                while(in.ready()) {
                    String clientAnswer = in.readLine();
                    char sign = clientAnswer.charAt(0);
                    String serwerAnswer = "";
                    //i - initQuiz; a - get answer; q - show previous/next question; e - end quiz
                    switch (sign) {
                        case 'i':   serwerAnswer = initQuiz(); 
                            break;
                        case 'a':   serwerAnswer = GetAnswer(clientAnswer);
                            break;
                        case 'q':   serwerAnswer = ShowQuestionAndAnswers(clientAnswer);
                            break;
                        case 'e':   serwerAnswer = EndQuiz(clientAnswer);
                            break;
                    }
                    out.println(serwerAnswer);
                    out.println("EOT");
                }
            }
        } catch ( IOException  e) {
            JOptionPane.showMessageDialog(null,"Error: " +  e, "Server Error", JOptionPane.ERROR_MESSAGE);  
        } 
    }
    
    /**
     * Method responsible for get user answer from client and save it on server 
     * @param line - request from client
     * @return serwer Answer
     */
    private String GetAnswer(String line) {
        //line[1] - quizNumber, line[2] - questionNumber line[3] - UserAnwser
        String quizNumber = "" +  line.charAt(1);
        String questionNumber = "" +  line.charAt(2);
        String userAnswer = "" +  line.charAt(3);
        controler.setAnswerUser(Integer.parseInt(quizNumber),Integer.parseInt(questionNumber),userAnswer);
        return "Downloaded reply";
    }
    
    /**
     * Method responsible for get client change question and send to client 
     * next/prewious question  
     * @param line - request from client
     * @return serwer Answer
     */
    private String ShowQuestionAndAnswers(String line) {
        //line[1] - quizNumber; line[2] - questionNumber;
        String tmpQuizNumber = "" +  line.charAt(1);
        String tmpQuestionNumber = "" +  line.charAt(2);
        int quizNumber = Integer.parseInt(tmpQuizNumber); 
        int questionNumber = Integer.parseInt(tmpQuestionNumber);
        out.println(controler.getText(quizNumber, questionNumber, "Q"));
        out.println(controler.getText(quizNumber, questionNumber, "A"));
        out.println(controler.getText(quizNumber, questionNumber, "B"));
        out.println(controler.getText(quizNumber, questionNumber, "C"));
        out.println(controler.getText(quizNumber, questionNumber, "U"));
        
        return "Change questions";
    }
    
    /**
     * Method responsible for get client ended quiz, save result on server,
     * and send to client user scoer and first question  
     * @param line - request from client
     * @return serwer Answer
     * @throws IOException 
     */
    private String EndQuiz(String line) throws IOException {
        //line[1] - quizNumber; line[2...] - nick;
        String tmpQuizNumber = "" +  line.charAt(1);
        int quizNumber = Integer.parseInt(tmpQuizNumber);
        String nick = "";
        for(int i = 2; i < line.length(); i++) {
            nick += line.charAt(i);
        }
        controler.setResults(quizNumber,nick);
        out.println(controler.getScore());
        if(saveResults) { 
            String tmp = "Quiz #" + quizNumber;
            controler.saveResultsToFile(nick, tmp, controler.getScore());
        }
        for(int i = 0; i < 5; i++){
            controler.setAnswerUser(quizNumber, i, "");
        }
        
        out.println(controler.getText(quizNumber, 0, "Q"));
        out.println(controler.getText(quizNumber, 0, "A"));
        out.println(controler.getText(quizNumber, 0, "B"));
        out.println(controler.getText(quizNumber, 0, "C"));
        out.println(controler.getText(quizNumber, 0, "U"));
       
        return "Quiz ended, result saved";
    }
    
    /**
     * Method responsible for get results from file results.txt,
     * and send it to client
     * @throws IOException 
     */
    private void GetResultsFromFile() throws IOException {
        
        try {
            if(controler.getResultsFromFile()){
                List<Results<String,Integer>> tmp = controler.getResults();
                for(Results x : tmp){ 
                    out.println(x.getNick());
                    out.println(x.getWhichQuiz());
                    out.println(x.getScore());
                }
                saveResults = true;
            }
        } catch (FileNotFoundException | StringIndexOutOfBoundsException e) {
            out.println("Error: ");
            out.println(e);
        }
    }
    
    /**
     * Method responsible for init Quiz that mean:
     * get questions from file,
     * send first questions for all quizes to client
     * send actual results to client
     * @return server Answer
     * @throws IOException 
     */
    private String initQuiz() throws IOException {
        
        try{
        controler.createNewQuiz("quiz1.txt");
        controler.createNewQuiz("quiz2.txt");
        controler.createNewQuiz("quiz3.txt");
        } catch (FileNotFoundException | MyException | StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
            out.println("Error: ");
            out.println(e);
        }
        
        for(int i = 0; i < 3; i++) {
            out.println(controler.getText(i, 0, "Q"));
            out.println(controler.getText(i, 0, "A"));
            out.println(controler.getText(i, 0, "B"));
            out.println(controler.getText(i, 0, "C"));
        }
        
        GetResultsFromFile();
        
        return "Quizzes launched";
    }
    
}
