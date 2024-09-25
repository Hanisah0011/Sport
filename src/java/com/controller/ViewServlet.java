/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Dao.BookingDao;
import com.model.Booking;
import java.util.List;

/**
 *
 * @author Cahaya Bulan
 */
public class ViewServlet extends HttpServlet {

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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<a href='bookingForm.html'>Add New Booking</a>");
        out.println("<h1>Booking List</h1>");
        
        List<Booking> list=BookingDao.getAllBooking();
        
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>BookID</th><th>Date</th><th>Time</th><th>Category Sport</th><th>Court Name</th><th>Email</th>"
                + "<th>Edit</th><th>Delete</th></tr>");
        
        for (Booking e:list) {
            
            out.print ("<tr><td>"
                    +e.getBookid()+"</td><td>"
                    +e.getDate()+"</td><td>"
                    +e.getTime()+"</td><td>"
                    +e.getCourtname()+"</td><td>"
                    +e.getCategorysport()+"</td><td>"
                    +e.getEmail()+"</td><td><a href='EditServlet?id="
                    +e.getBookid()+"'>Accept</a></td> <td><a href='DeleteServlet?id="
                    +e.getBookid()+"'>Reject</a></td></tr>");
        }
        
        out.print("</table>");
        
        out.close();
        
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