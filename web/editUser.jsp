<%-- 
    Document   : editUser
    Created on : Jun 17, 2022, 7:18:39 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User</title>
          <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <header> 
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
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
                    
                
                    <h1>Update Customer Profile</h1>
        <form name="frmEditUser" action="UserController" method="POST">
            <table border="0">
                <tbody>
                    
               <br/><br/>
                    <tr>
                        <td>Customer ID :</td>
                        <td><input type="text" name="userid" readonly="readonly" value="<c:out value="${user.userid}"/>" size="25" /></td>
                    </tr>
                    </fieldset
                
                    <tr>
                        <td>Customer Name :</td>
                        <td><input type="text" name="name"  value="<c:out value="${user.name}"/>" size="25" /></td>
                    </tr>
                    <tr>
                        <td>Type of facilities :</td>
                        <td><input type="text" name="facilities" value="<c:out value="${user.facilities}"/>" size="40" /></td>
                    </tr>
                    <tr>
                        <td>Customer Phone Number:</td>
                        <td><input type="text" name="phonenumber" value="<c:out value="${user.phonenumber}"/>" size="40" /></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="hidden" name="action" value="edit"/>
                        </td>
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
