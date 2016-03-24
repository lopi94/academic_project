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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for create tne quizzes, calculate score of quizzes and 
 * set answer of the User
 * @author Julia Kubieniec
 * @version 1.0
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
     * List of results of the user in quizzes
     */
    private List<Results<String,Integer>> results = new ArrayList<>();
    
    /**
     * method to create new quiz from the txt file
     * @param path the path to the file
     * @return true if quiz was added correctly, otherwise false
     * @throws FileNotFoundException
     * @throws IOException
     * @throws MyException 
     * @throws StringIndexOutOfBoundsException
     * @throws ArrayIndexOutOfBoundsException
     */
    public boolean createNewQuiz(String path) throws FileNotFoundException, IOException,
            MyException, StringIndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
        
        if(!(path.substring(path.length()-4, path.length()).equals(".txt"))) {
           throw new MyException(path);
        }
        
        List<Question<String>> quiz = new ArrayList<>();
       BufferedReader file = new BufferedReader(new InputStreamReader(
            Quiz.class.getResourceAsStream(path)
        ));
        try{
            while(file.ready()){
                String s = file.readLine();
                String[] data = s.split("-",5);
                quiz.add(new Question(data[0],data[1],data[2],data[3],data[4],""));
        }
        } finally {
            if(file != null) {
                file.close();
            }
        }
        quizy.add(quiz);
        if (quizy.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * method to create new result list from results.txt file
     * @return true if you manage to get the data, otherwise false
     * @throws FileNotFoundException
     * @throws IOException
     * @throws StringIndexOutOfBoundsException 
     */
    public boolean getResultsFromFile() throws FileNotFoundException, IOException,
            StringIndexOutOfBoundsException {
        
        Results<String,Integer> tmp;
  //      BufferedReader file = new BufferedReader(new InputStreamReader(
  //          Quiz.class.getResourceAsStream("results.txt")
  //      ));
        BufferedReader file = new BufferedReader(new FileReader("results.txt"));
        try{
            while(file.ready()){
                String s = file.readLine();
                String[] data = s.split("-",3);
                results.add(new Results(data[0],data[1],data[2]));
        }
        } finally {
            if(file != null) {
                file.close();
            }
        }
        if (results.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * method to save single result to results.txt file
     * @param nick user nick
     * @param quiz name of the quiz
     * @param score amount of score that user get in the quiz
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void saveResultsToFile(String nick, String quiz, int score) throws FileNotFoundException, IOException {
        RandomAccessFile file = null;
        try{
            file = new RandomAccessFile("results.txt", "rw");
            file.seek(file.length());           
            file.writeBytes("\r\n"+nick + "-"+quiz+"-"+Integer.toString(score));
        } finally {
            if(file != null) {
                file.close();
            }
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
     * method to save user results
     * @param quizId the quizId to get correct quiz
     * @param nick user nick in this quiz
     */
    public void setResults(int quizId, String nick) {
        String tmp = "Quiz #" + Integer.toString(quizId);
        results.add(new Results(nick, tmp, calculateScore(quizId)));
    }
    
    /**
     * method to get users reults 
     * @return users results
     */
    public List<Results<String,Integer>> getResults() {
        return results;
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
    
    /**
     * metod to get data from file, depending on the quizId and questionId
     * @param quizId the quizId to get correct quiz
     * @param questionId the questionId to get correct question / anwser
     * @param parameter determines what to get:
     * Q - question
     * A - anwser A
     * B - anwser B
     * C - anwser C
     * U - user anwser 
     * @return Q or A or B or C or U depending on quizId and QuestionId 
     */
    public String getText( int quizId, int questionId, String parameter ) {
        String tmp = "";
        switch(parameter) {
            case "Q" : tmp =  quizy.get(quizId).get(questionId).getQuestion();
                break;
            case "A" : tmp =  quizy.get(quizId).get(questionId).getAnswerA();
                break;
            case "B" : tmp =  quizy.get(quizId).get(questionId).getAnswerB();
                break;
            case "C" : tmp =  quizy.get(quizId).get(questionId).getAnswerC();
                break;
            case "U" : tmp =  quizy.get(quizId).get(questionId).getAnswerUser();
                break;
        }
        return tmp;
    }
}
