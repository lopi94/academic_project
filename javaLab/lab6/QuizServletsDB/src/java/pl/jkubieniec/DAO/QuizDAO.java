/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jkubieniec.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pl.jkubieniec.database.Connector;
import pl.jkubieniec.model.Question;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for selecting data about quizzes from the database
 * @author Julia Kubieniec
 * @version 1.3
 */
public class QuizDAO {
   
    /**
     * Gets all the existing questions from the database
     * 
     * @return the list of questions as objects of Question class
     */
    public static List<Question<String>> getAllQuestion() {
        try {
            List<Question<String>> list = new ArrayList<>();
            Connection connection = Connector.getConnection();
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM Quizzes");
                while (rs.next()) {
                    list.add(new Question<String>(rs.getString("Question"), 
                            rs.getString("AnswerA"),rs.getString("AnswerB"),
                            rs.getString("AnswerB"),rs.getString("AnswerOk"), ""));
                }
            }
            return list;
        } catch (SQLException e) {
             Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    /**
     * Gets question's by given unique id
     *
     * @param id is the id of searched question
     * @return question's and answer A, B, C if exists, null if not
     */
    public static List<String> getQuestionByID(int id) {
        try {
            List<String> list = new ArrayList<>();
            Statement statement = Connector.getConnection().createStatement();
            String query = "SELECT * FROM Quizzes WHERE Id = " + id + "";
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                list.add(rs.getString(2));
                list.add(rs.getString(3));
                list.add(rs.getString(4));
                list.add(rs.getString(5));
                return list;
            } else {
                return null;
            }
        } catch (SQLException e) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
}
