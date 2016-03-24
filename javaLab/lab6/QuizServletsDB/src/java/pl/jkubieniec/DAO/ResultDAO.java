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
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.jkubieniec.database.Connector;
import pl.jkubieniec.model.Results;

/**
 * Class for inserting and selecting data about results from the database
 * @author Julia Kubieniec
 * @version 1.3
 */
public class ResultDAO {
    
    /**
     * Gets all the existing results from the database
     * 
     * @return the list of results as objects of Results class
     */
    public static List<Results<String,Integer>> getAllResults() {
        try {
            List<Results<String,Integer>> list = new ArrayList<>();
            Connection connection = Connector.getConnection();
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM Results");
                while (rs.next()) {
                    list.add(new Results(rs.getString("Nick"),
                            rs.getString("QuizNumber"),rs.getInt("Score")));
                }
            }
            return list;
        } catch (SQLException e) {
        }
        return null;
    }
    
     /**
     * Adds new result do the database
     * 
     * @param nick user nick
     * @param quizNumber the number of executed quiz
     * @param score number of scored points 
     * @return true if successfully added, false if not
     */
    public static boolean addResult(String nick, String quizNumber, Integer score) {
        Connector.getConnection();
        try {
            Statement statement = Connector.getConnection().createStatement();
            String query = "INSERT INTO Results "
                    + " VALUES('" + nick + "'"
                    + " , 'Quiz #" + quizNumber + "'"
                    + " , " + score + ")";
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(ResultDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}
