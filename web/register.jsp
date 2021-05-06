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
        <title>Register Page</title>
    </head>
    <body>
        <div>
            <h1><a href="index.jsp">IoTBay</a></h1>
            <a href="login.jsp">login</a>
            <a href="register.jsp">register</a>
        </div>
        <div>
            <form action="welcome.jsp" method="post"> <!--"action" tag is the destination URL once form is submitted, "post" is an attribute for method which hides the form values from the address bar after submission-->
                <table>
                    <tr>
                        <td>Name</td><td><input type="text" name="name" required></td> <!--Extremely useful tag that disables submit button if field is empty-->
                    </tr>
                    <tr>
                        <td>Email</td><td><input type="text" name="email" required></td>
                    </tr>
                    <tr>
                        <td>Phone</td><td><input type="text" name="phone"></td>
                    </tr>
                    <tr>
                        <td>Password</td><td><input type="text" name="password" required></td>
                    </tr>
                </table>
                <input type="submit" value="sign up">
            </form>
        </div>
    </body>
</html>
