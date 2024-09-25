<%-- 
    Document   : listUser
    Created on : Jun 17, 2022, 7:12:48 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Customer</title>
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
         <header>
             <nav class="navbar navbar-expand-md navbar-dark" style="background-color:#cc6600">
                <div>
                    <a href="" class="navbar-brand"> SPORT FACILITIES BOOKING SYSTEM </a>
                </div>

                <ul class="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Customers</a></li>

                </ul>
            </nav>
        </header>
                    <br>
        
            <div class="row">

            <div  class="container">
                <h3 class="text-center"> List of Customers</h3>

                  <hr>
                <div class="container text-center">
                    <a href="homePage.html" class="btn btn-success">Home</a>
                </div>
                <br> 
                
                <hr>
                <div class="container text-center">
                    <a href="UserController?action=insert" class="btn btn-success">Add New Customer</a>
                </div>
                <br> 
                
              
                
                <table class="table table-bordered"> 
                    <thead>
                <tr>
                    <th>Customer Id</th>
                    <th>Customer Name </th>
                    <th>Type Of Facilities</th>
                    <th>Customer Phone Number</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td><c:out value="${user.userid}" /></td>
                        <td><c:out value="${user.name}" /></td>
                        <td><c:out value="${user.facilities}"/></td>
                        <td><c:out value="${user.phonenumber}"/></td>
                        <td><a href="UserController?action=edit&userId=<c:out value="${user.userid}"/>">Update</a></td>
                        <td><a href="UserController?action=delete&userId=<c:out value="${user.userid}"/>">Delete</a></td>
                    </tr>  
                </c:forEach>
            </tbody>
        </table>
        
    </body>
</html>
