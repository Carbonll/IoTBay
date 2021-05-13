<%-- 
    Document   : index
    Created on : 17/03/2021, 12:22:28 PM
    Author     : melvi
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.controller.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <%
            ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");
        %>
        <div>
            <h1><a href="index.jsp">IoTBay</a></h1>
            <a href="register.jsp">register</a>
            <a href="login.jsp">login</a>
            <a href="Cart.jsp">Cart</a>
        </div>
        <br>
        <div>
            <h2>Welcome</h2>
        </div>
        <div>
                    <table>
                <colgroup>
                    <col span="3" style="width: 100px">
                </colgroup>
                <thead>
                    <tr>
                        <th>Product ID</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Stock</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Product row : products){
                    
                    %>
                    
                <form action="AddToCartServlet" method="post">
                    <tr>
                        <td style="text-align: center"><%= row.getID()%></td>
                        <td style="text-align: center"><%= row.getName()%></td>
                        <td style="text-align: center"><%= row.getCategory()%></td>
                        <td style="text-align: center"><%= row.getPrice()%></td>
                        <td style="text-align: center"><%= row.getStock()%></td>
                        <td style="text-align: center">
                       <input type="submit" value="Add to Order"></a></td>
                </form>
                    </tr>
                    <% }%>
                </tbody>
                </table>
        </div>
    </body>
</html>
