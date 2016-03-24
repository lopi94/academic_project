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
import pl.jkubieniec.controler.Controler;

/**
 * Servlet responsible for get quiz question from serwer and show them
 * @author Julia Kubieniec
 * @version 1.2
 */
public class Quiz extends HttpServlet implements Controler{
    
    /**
     * variable holds data form serwer
     */
    private List<String> inData = new ArrayList();
    
    /**
     * Method responsible for get question from sewer and show them
     * @param quizNumber - number of active quiz
     * @param nick - user name
     * @param request - HttpServletRequest
     * @param response - HttpServletResponse
     * @param out - PrintWriter
     * @throws IOException 
     */
    public void takeQuiz(String quizNumber, String nick, HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
        inData.clear();
        inData = CONTROLER.sendRequest(quizNumber);
        boolean flag = true;
        
        for (int i = 0; i < inData.size(); i++ ) {
            if (inData.get(i).equals("Error: ")){
                response.sendError(response.SC_BAD_REQUEST, inData.get(i) +  inData.get(i+1));
                flag = false;
            }
        }
        
        if(flag) { 
            out.println("<form action=" + "EndQuiz" + ">");
            int i = 0;
            int j = 1;
            String name;
            while(i < 19) {
                name = "answer" + Integer.toString(j);
                out.println("<html>\n<body>\n<h3> " + inData.get(i) + "</h3>\n");
                i++;
                out.println("<html>\n<body>\n<p><input type=radio name=" + name + " value=A checked>" + inData.get(i) +"</p>\n");
                i++;
                out.println("<html>\n<body>\n<p><input type=radio name=" + name + " value=B checked>" + inData.get(i) +"</p>\n");
                i++;
                out.println("<html>\n<body>\n<p><input type=radio name=" + name + " value=C checked>" + inData.get(i) +"</p>\n");
                i++;
                j++;
            }
            out.println("<html>\n<body>\n<input type=" + "submit " + " value=" + "End Quiz" + "/>\n");
            
            out.println("</form>");
        }
    }
    
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
        
        // Create cookies for nick and quizNumber.      
      Cookie nickCookie = new Cookie("nick", request.getParameter("nick"));
      Cookie quizNumberCookie = new Cookie("quizNumber", request.getParameter("whichQuiz"));

      // Set expiry date after 24 Hrs for both the cookies.
      nickCookie.setMaxAge(60*60*24); 
      quizNumberCookie.setMaxAge(60*60*24); 

      // Add both the cookies in the response header.
      response.addCookie( nickCookie );
      response.addCookie( quizNumberCookie );
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Get parameter values - nick i whichQuiz
            String nick = request.getParameter("nick");
            String whichQuiz = request.getParameter("whichQuiz");
            
            if (nick.length() == 0) {
                response.sendError(response.SC_BAD_REQUEST, "You should give nick!");
            } else {
                out.println("<html>\n<body>\n<h1>Hello " + nick + "!!!</h1>\n");
                
                switch (whichQuiz) {
                    case "0": out.println("<html>\n<body>\n<h1>Quiz 1</h1>\n");
                    break;
                    case "1": out.println("<html>\n<body>\n<h1>Quiz 2</h1>\n");
                    break;
                    case "2": out.println("<html>\n<body>\n<h1>Quiz 3</h1>\n");
                    break;
                } 
              
                takeQuiz(whichQuiz, nick, request, response, out);
            }
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
