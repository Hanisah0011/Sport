<%-- 
    Document   : payment-list
    Created on : 19 Jun 2022, 11:53:35 pm
    Author     : adylh
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
        <head>
            <title>Sport Facilitiy Management</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>
        <body>
             <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="http://www.nacreservices.com" class="navbar-brand"> Payment
                           Records </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Payments</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
               

                <div class="container">
                    <h3 class="text-center">List of Payments</h3>
                    
                       <hr>
                <div class="container text-center">
                    <a href="<%=request.getContextPath()%>/homePage.html" class="btn btn-success">Home</a>
                </div>
                <br> 
                    <hr>
                    <div class="container text-center">

                        <a href="<%=request.getContextPath()%>/PaymentServlet/payment/new" class="btn btn-success">Add New Payments</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Booking ID</th>
                                <th>Customer Name</th>
                                <th>Invoice</th>
                                <th>Amount</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            <c:forEach var="payment" items="${listPayment}">

                                <tr>
                                    <td>
                                        <c:out value="${payment.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${payment.name}" />
                                    </td>
                                    <td>
                                        <c:out value="${payment.invoice}" />
                                    </td>
                                    <td>
                                        <c:out value="${payment.amount}" />
                                    </td>
                                    <td><a href="edit?id=<c:out value='${payment.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="delete?id=<c:out value='${payment.id}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>
       
</html>

