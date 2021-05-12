<%-- 
    Document   : Error
    Created on : 12/05/2021, 6:26:58 PM
    Author     : jesse h
    For my weird crud operations implamentation
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Error!</h1>
        <h2><%=exception.getMessage() %><br/></h2>
    </body>
</html>
