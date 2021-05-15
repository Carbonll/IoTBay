<%-- 
    Document   : addProduct
    Created on : 13/05/2021, 5:52:05 PM
    Author     : Peter
--%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.controller.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product Page</title>
    </head>
        <%
            String priceErr = (String) session.getAttribute("priceErr");
            String stockErr = (String) session.getAttribute("stockErr");
            String added = (String) session.getAttribute("added");
            String existProductErr = (String) session.getAttribute("existProductErr");
        %>    
    <body>
        <div>
            <h1><a href="main.jsp">IoTBay</a></h1>
            <a href="LogoutServlet">logout</a>
            <a href="main.jsp">main</a>
            <a href="EditServlet">account</a>
            <a href="AuditServlet">access log</a>
            <a href="BrowseServlet">browse</a>
            <a href="addProduct.jsp">Add Product</a>
            <a href="updateProduct.jsp">Update Product</a>
        </div>
        <div>
            <h2>Add Product</h2>
        </div>
            <form action="AddProductServlet" method="post">
                <table>
                    <tr><td>Name</td><td><input type="text" name="newName" required></td></tr>
                    <tr><td>Category</td><td><input type="text" name="newCategory" required></td></tr>
                    <tr><td>Price</td><td><input type="text" placeholder="<%= priceErr != null ? priceErr : ""%>" name="newPrice" required></td></tr>
                    <tr><td>Stock</td><td><input type="text" placeholder="<%= stockErr != null ? stockErr : ""%>" name="newStock" required></td></tr>
                    <tr>
                        <td><input type="submit" value="Add"></td>
                    </tr>
                </table>  
            </form>
            <p><%= added != null ? added : ""%></p>           
            <p><%= existProductErr != null ? existProductErr : ""%></p>
            <% session.setAttribute("added", ""); %>
            <% session.setAttribute("existProductErr", ""); %>
    </body>
</html>
