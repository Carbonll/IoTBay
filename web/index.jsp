<%-- 
    Document   : index
    Created on : 17/03/2021, 12:22:28 PM
    Author     : melvi
--%>

<%@page import="uts.isd.model.*"%>

<%@page import="uts.isd.controller.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
    </head>
    <body>
        <div>
            <h1><a href="index.jsp">IoTBay</a></h1>
            <a href="login.jsp">login</a>
            <a href="register.jsp">register</a>
        </div>
        <br>
        <div>
            <h2>Welcome to the IoTBay online store!</h2>
            <p>Lorem Ipsum</p>
        </div>
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
