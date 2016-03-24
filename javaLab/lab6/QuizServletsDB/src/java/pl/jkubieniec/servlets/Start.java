/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jkubieniec.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import pl.jkubieniec.DAO.QuizDAO;
import static pl.jkubieniec.controler.Controler.CONTROLER;
import pl.jkubieniec.database.Connector;
import pl.jkubieniec.model.MyException;

/**
 * Class which is run when the server starts.
 * It creates default tables for the database to work properly.
 * @author Julia Kubieniec
 * @version 1.3
 */
public final class Start extends HttpServlet {

     /**
     * Conects with the database
     */
    private Connection connection = null;
    /**
     * Creates the initial question
     * @throws ServletException if problem with servlet occured
     */
    @Override
    public void init() throws ServletException {
        if (Connector.getConnection() == null) {
            if (Connector.setConnection(this.getServletContext())) {
                this.connection = Connector.getConnection();
                try {
                    CONTROLER.initQuizzesData(QuizDAO.getAllQuestion());
                } catch (IOException ex) {
                    Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MyException ex) {
                    Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
                } catch (StringIndexOutOfBoundsException ex) {
                    Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
