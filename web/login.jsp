<%-- 
    Document   : index
    Created on : 17/03/2021, 12:22:28 PM
    Author     : melvi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <div>
            <h1><a href="index.jsp">IoTBay</a></h1>
            <a href="login.jsp">login</a>
            <a href="register.jsp">register</a>
             <table>
                <tr>
                    <td>Email</td><td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <td>Password</td><td><input type="text" name="password"></td>
                </tr>
            </table>
            <input type="submit" value="login">
        </div>
    </body>
</html>
