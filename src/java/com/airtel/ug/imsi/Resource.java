/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airtel.ug.imsi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author humphrey
 */
@WebServlet(name = "Resource", urlPatterns = {"/Resource"})
public class Resource extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        Random rand = new Random();
        try {
            String OPERATION = request.getParameter("OPERATION");

            if (OPERATION.equals("GETIMSI")) {
                String[] imsis = {"101028", "101038", "122200", "142000", "146001", "148022"};

                //Generate a random number between 0 - 5
                //Use that number to get a value from imsis
                int number = rand.nextInt(6);
                int otherNumbers = rand.nextInt(1000000000);
                String finalimsi = imsis[number] + otherNumbers;
                out.println(finalimsi);

            } else if (OPERATION.equals("GETGEN")) {
                String[] generations = {"2G", "3G", "4G"};
                int genNumber = rand.nextInt(3);
                out.println(generations[genNumber]);
            } else {
                out.println("Unkown Request");
            }
        } catch (Exception e) {
            out.println("An Error Occured");
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
