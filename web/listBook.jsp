<%-- 
    Document   : listBook
    Created on : 19 Jun 2022, 8:56:41 pm
    Author     : Cahaya Bulan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking Lists</title>
    </head>
    <body>
        <p>List of Booking...!</p>
        <table border=1>
            <thead>
                <tr>
                    <th>Book Id</th>
                    <th>Date </th>
                    <th>Time</th>
                    <th>Category Sport</th>
                    <th>Email</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${booking}" var="book">
                    <tr>
                        <td><c:out value="${book.bookid}" /></td>
                        <td><c:out value="${book.date}" /></td>
                        <td><c:out value="${book.Time}"/></td>
                        <td><c:out value="${book.categorysport}"/></td>
                        <td><c:out value="${book.email}"/></td>
                        <td><a href="BookController?action=edit&bookid=<c:out value="${book.bookid}"/>">Update</a></td>
                        <td><a href="BookController?action=delete&bookid=<c:out value="${book.bookid}"/>">Delete</a></td>
                    </tr>  
                </c:forEach>
            </tbody>
        </table>
        <p><a href="BookController?action=insert">Add New Booking</a></p>
    </body>
</html>
