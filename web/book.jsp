<%-- 
    Document   : Book
    Created on : Jun 20, 2022, 1:55:26 AM
    Author     : alish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
        <p><b>New Booking Record</b></p>
        <form name="frmAddBooking" action="BookController" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Date :</td>
                        <td><input type="text" name="date" value="" size="25" required /></td>
                    </tr>
                    <tr>
                        <td>Time :</td>
                        <td><input type="text" name="Time" value="" size="40" /></td>
                    </tr>
                    <tr>
                        <td>Court Name : </td>
                        <td><input type="text" name="courtname" value="" size="40" /></td>
                    </tr>
                    <tr>
                        <td>Category Sport : </td>
                        <td><input type="text" name="categorysport" value="" size="40" /></td>
                    </tr>
                    <tr>
                        <td>Email : </td>
                        <td><input type="text" name="email" value="" size="40" /></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="action" value="insert"/></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Submit" name="submit"/>
                            <input type="reset" value="Cancel" name="cancel"/>
                        </td>
                    </tr>
                </tbody>
            </table>         
        </form>
    </body>
</html>

