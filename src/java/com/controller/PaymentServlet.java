
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

import com.model.Payments;
import com.Dao.PaymentDAO;
import java.io.PrintWriter;

public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PaymentDAO paymentDAO;   
    
	public void init() {
		paymentDAO = new PaymentDAO();
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
                case "/PaymentServlet/payment/new":
                    showNewForm(request, response);
                    break;
                case "/PaymentServlet/payment/insert":
                    insertPayment(request, response);
                    break;
                case "/PaymentServlet/payment/delete":
                    deletePayment(request, response);
                    break;
                case "/PaymentServlet/payment/edit":
                    showEditForm(request, response);
                    break;
                case "/PaymentServlet/payment/update":
                    updatePayment(request, response);
                    break;
                case "/PaymentServlet/payment/list":
                    listPayment(request, response);
                    break;
                default:
                    listPayment(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	private void listPayment(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Payments > listPayment = paymentDAO.selectAllPayments() ;
		        request.setAttribute("listPayment", listPayment);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/payment-list.jsp");
		        dispatcher.forward(request, response);
   }

		    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/payment-form.jsp");
		        dispatcher.forward(request, response);
		    }

		    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Payments existingPayment = paymentDAO.selectPayment(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/payment-form.jsp");
		        request.setAttribute("payment", existingPayment);
		        dispatcher.forward(request, response);

		    }

		    private void insertPayment(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		    	int id=Integer.parseInt(request.getParameter("id"));
		        String name = request.getParameter("name");
                        String invoice = request.getParameter("invoice");
		        int amount =Integer.parseInt(request.getParameter("amount"));
		        Payments newPayment = new Payments(id,name,invoice,amount);
		        paymentDAO.insertPayment(newPayment);
		        response.sendRedirect("list");
		    }

		    private void updatePayment(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String name = request.getParameter("name");
                        String invoice = request.getParameter("invoice");
		        int amount = Integer.parseInt(request.getParameter("amount"));

		        Payments book = new Payments(id, name, invoice, amount);
		        paymentDAO.updatePayment(book);
		        response.sendRedirect("list");
		    }

		    private void deletePayment(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        paymentDAO.deletePayment(id);
		        response.sendRedirect("list");

		    }



}