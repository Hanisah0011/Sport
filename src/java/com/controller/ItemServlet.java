/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Items;
import com.Dao.ItemDAO;
import java.io.PrintWriter;


public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ItemDAO itemDAO;   
    
	public void init() {
		itemDAO = new ItemDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            String action = request.getServletPath();
            System.out.println("path"+ action);
            PrintWriter out=response.getWriter();
            out.println(action);
        try {
            switch (action) {
                case "/ItemServlet/item/new":
                    showNewForm(request, response);
                    break;
                case "/ItemServlet/item/insert":
                    insertItem(request, response);
                    break;
                case "/ItemServlet/item/delete":
                    deleteItem(request, response);
                    break;
                case "/ItemServlet/item/edit":
                    showEditForm(request, response);
                    break;
                case "/ItemServlet/item/update":
                    updateItem(request, response);
                    break;
                case "/ItemServlet/item/list":
                    listItem(request, response);
                    break;
                default:
                    listItem(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	private void listItem(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Items > listItem =itemDAO.selectAllItems() ;
		        request.setAttribute("listItem", listItem);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/item-list.jsp");
		        dispatcher.forward(request, response);
   }

		    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/item-form.jsp");
		        dispatcher.forward(request, response);
		    }

		    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Items existingItem =itemDAO.selectItem(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/item-form.jsp");
		        request.setAttribute("item", existingItem);
		        dispatcher.forward(request, response);

		    }

		    private void insertItem(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		    	int id=Integer.parseInt(request.getParameter("id"));
		        String name = request.getParameter("name");
		        int rupee=Integer.parseInt(request.getParameter("rupee"));
		        Items newItem = new Items(id,name, rupee);
		        itemDAO.insertItem(newItem);
		        response.sendRedirect("list");
		    }

		    private void updateItem(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String name = request.getParameter("name");
		        int rupee = Integer.parseInt(request.getParameter("rupee"));

		        Items book = new Items(id, name, rupee);
		        itemDAO.updateItem(book);
		        response.sendRedirect("list");
		    }

		    private void deleteItem(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        itemDAO.deleteItem(id);
		        response.sendRedirect("list");

		    }



}