<%-- 
    Document   : user
    Created on : Jun 17, 2022, 7:14:49 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Record</title>
        
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <header> 
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #cc6600">
                <div>
                    <a href="" class="navbar-brand"> SPORT FACILITIES BOOKING SYSTEM </a>

                </div>

                <ul class ="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/list" class="nav-link">SPORT</a></li>
                </ul>
            </nav>
        </header>
                
        <br>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    
    </head>
    <body>
        <br/>
        <p><b>New Customer Record</b></p>
        <form name="frmAddUser" action="UserController" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Customer ID : </td>
                        <td><input type="text" name="userid" value="" size="25" required /></td>
                    </tr>
                    <tr>
                        <td>Customer Name </td>
                        <td><input type="text" name="name" value="" size="25" required /></td>
                    </tr>
                    <tr>
                        <td>Type of facilities : </td>
                        <td><input type="text" name="facilities" value="" size="25" /></td>
                    </tr>
                    <tr>
                        <td>Customer Phone number : </td>
                        <td><input type="text" name="phonenumber" value="" size="25" /></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="action" value="insert"/></td>
                    </tr>
                    <tr>
                        <td>
                            <button type="submit" class="btn btn-success">Save</button>
                            
                            
                        </td>
                    </tr>
                </tbody>
            </table>         
        </form>
    </body>
</html>

