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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.jkubieniec.controler.Controler;

/**
 * Servlet responsible for get results from serwer and show them
 * @author Julia Kubieniec
 * @version 1.2
 */
public class Results extends HttpServlet implements Controler{

     /**
     * variable holds data form serwer
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            inData.clear();
            inData = CONTROLER.sendRequest("r");
            
            boolean flag = true;
            
            for (int i = 0; i < inData.size(); i++ ) {
                if (inData.get(i).equals("Error: ")){
                    response.sendError(response.SC_BAD_REQUEST, inData.get(i) +  inData.get(i+1));
                    flag = false;
                }
            }
            if(flag){
                out.println("<html>\n<body>\n<h1> Results: </h1>\n");
                int i = 0;
                out.println("<table border=\"5\">");
                out.println("<td>Nick</td> <td>Quiz</td> <td>Score</td>");
                while(i < inData.size()-2) {
                    out.println("<tr>");
                    out.println("<td>" + inData.get(i++) + "</td> <td>" + inData.get(i++) + 
                            "</td> <td>" + inData.get(i++) + "</td>\n");
                    out.println("</tr>");
                }
                out.println("</table>");
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
