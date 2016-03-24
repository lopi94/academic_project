/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jkubieniec.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.jkubieniec.DAO.ResultDAO;
import pl.jkubieniec.controler.Controler;

/**
 * Servlet responsible for end quiz and get amount of user score from server
 * @author Julia Kubieniec
 * @version 1.3
 */
public class EndQuiz extends HttpServlet implements Controler {

    /**
     * variable holds data form model
     */
    private List<String> inData = new ArrayList();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
	Cookie[] cookies = null;
         // Get an array of Cookies associated with this domain
        cookies = request.getCookies();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            String quizNumber = cookies[cookies.length - 1].getValue();
            String nick = cookies[cookies.length - 2].getValue();
            
            String end = "e" + quizNumber + request.getParameter("answer1") + request.getParameter("answer2") + 
                    request.getParameter("answer3") + request.getParameter("answer4") + 
                    request.getParameter("answer5") + nick;
            
            inData.clear();
            inData = CONTROLER.sendRequest(end);
            for (int k = 0; k < inData.size(); k++ ) {
                if (inData.get(k).equals("Error: ")){
                    response.sendError(response.SC_BAD_REQUEST, inData.get(k) +  inData.get(k+1));
                }
            }

            out.println("<html>\n<body>\n<h2> Your score: " + inData.get(0) + "</h2>\n");
            Integer tmp = Integer.parseInt(quizNumber);
            tmp++;
            quizNumber = tmp.toString();
            ResultDAO.addResult(nick, quizNumber, Integer.parseInt(inData.get(0)));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
