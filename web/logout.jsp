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
        <title>Home Page</title>
    </head>
    <body>
        <div>
            <h1><a href="index.jsp">IoTBay</a></h1>
        </div>
        <div>
            <p>You have successfully logged out. Click <a href="login.jsp">here</a> to login.</p>
        </div>
        <% session.invalidate(); %> <!--Clear the user's session-->
    </body>
</html>
