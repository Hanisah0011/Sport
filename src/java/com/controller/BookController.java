/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.*;
import com.model.*;


/**
 *
 * @author Cahaya Bulan
 */
public class BookController extends HttpServlet {

    private static String INSERT = "/book.jsp";
    private static String EDIT = "/editBook.jsp";
    private static String LIST_BOOK = "/listBook.jsp";
    private BookDao dao;
    
    public BookController() throws ClassNotFoundException{
        super();
        dao = new BookDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("delete")){
            String bookid = request.getParameter("bookid");
            dao.deleteBooking(bookid);
            forward = LIST_BOOK;
            request.setAttribute("book", dao.getAllBooking());
            
        } else if (action.equalsIgnoreCase("edit")){
            forward = EDIT;
            String bookid = request.getParameter("bookid");
            Book book = dao.getBookingById(bookid);
            request.setAttribute("book", book);
            
        } else if (action.equalsIgnoreCase("listBook")){
            forward = LIST_BOOK;
            request.setAttribute("book", dao.getAllBooking());
            
        } else if(action.equalsIgnoreCase("insert")){
            forward = INSERT;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String action = request.getParameter("action");
        
        Book book = new Book();
        book.setBookid(Integer.parseInt(request.getParameter("bookid")));
        book.setDate(request.getParameter("date"));
        book.setTime(request.getParameter("Time"));
        book.setCourtname(request.getParameter("courtname"));
        book.setCategorysport(request.getParameter("categorysport"));
        book.setEmail(request.getParameter("email"));
        
        if(action.equalsIgnoreCase("edit")){
            dao.updateBooking(book);
        } else {
            dao.addBooking(book);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_BOOK);
        request.setAttribute("book", dao.getAllBooking());
        view.forward(request, response);
    }
}
