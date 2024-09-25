<%-- 
    Document   : indexBook
    Created on : Jun 20, 2022, 1:57:38 AM
    Author     : alish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample Perform CRUD Using Java Servlet</title>
    </head>
    <body>
        <h1>Sample Perform CRUD Using Java Servlet!</h1>
        <jsp:forward page="/BookController?action=listBook" />
    </body>
</html