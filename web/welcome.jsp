<%-- 
    Document   : index
    Created on : 17/03/2021, 12:22:28 PM
    Author     : melvi
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");
        %> <!--Fetch inputted fields from register.jsp-->
        <div>
            <h1><a href="main.jsp">IoTBay</a></h1>
            <a href="logout.jsp">logout</a>
            <a href="main.jsp">main</a>
        </div>
        <div>
            <h2>Welcome,&nbsp;<%= name%>!</h2>
            <p>We hope you enjoy your stay.</p>
        </div>
        <%
           User user = new User(name,email,phone,password);
           session.setAttribute("user",user);
        %> <!--Store fetched fields into a new User object, make a session for that user-->
    </body>
</html>
