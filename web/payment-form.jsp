<%-- 
    Document   : payment-form
    Created on : 19 Jun 2022, 11:53:17 pm
    Author     : adylh
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Sport Facility Management</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
                  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
                  crossorigin="anonymous">
        </head>

        <head>
            <title>Payment Record List</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
                  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
                  crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="homePage.html" class="navbar-brand"> Payment Records </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Payments</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${payment != null}">
                            <form action="<%= request.getContextPath() %>/PaymentServlet/payment/update" method="post">
                        </c:if>
                        <c:if test="${payment == null}">
                            <form action="<%= request.getContextPath() %>/PaymentServlet/payment/insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${payment != null}">
                                    Edit Payment
                                </c:if>
                                <c:if test="${payment == null}">
                                    Add New Payment
                                </c:if>
                            </h2>
                        </caption>

                        <fieldset class="form-group">
                            <label>Booking Id :</label> <input type="text" value="<c:out value='${payment.id}' />" class="form-control" name="id" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Customer Name :</label> <input type="text" value="<c:out value='${payment.name}' />" class="form-control" name="name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Invoice :</label> <input type="text" value="<c:out value='${payment.invoice}' />" class="form-control" name="invoice">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Amount :</label> <input type="text" value="<c:out value='${payment.amount}' />" class="form-control" name="amount">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>
