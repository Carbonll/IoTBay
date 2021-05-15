<%-- 
    Document   : updateProduct
    Created on : 13/05/2021, 2:10:01 PM
    Author     : Peter
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.controller.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product Page</title>
    </head>
    <body>        
        <%
           ArrayList<Product> product = (ArrayList<Product>) session.getAttribute("product");
           String idErr = (String) session.getAttribute("idErr");
           String priceErr = (String) session.getAttribute("priceErr");
           String stockErr = (String) session.getAttribute("stockErr");
           String updatedProduct = (String) session.getAttribute("updatedProduct");
           String deletedProduct = (String) session.getAttribute("deletedProduct");
           String updateErr = (String) session.getAttribute("updateErr");           
        %>
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
        <h2>Update Product</h2>
        <form action="SearchProductIDServlet" method="get">
            <p>Search by ProductID <input type="text" name="productIDSearch"><input type="submit" value="Search"></p>
        </form>
            <% if (product != null) { %>
            <form action="UpdateProductServlet" method="post">
                <table>
                    <% for (Product row : product) {%>
                    <%String formattedPrice = String.format("%.2f", row.getPrice()); %>
                    <input type="hidden" name="productID" value="<%= row.getID()%>"
                    <tr><td>ID</td><td><%= row.getID()%></td></tr>
                    <tr><td>Name</td><td><input type="text" name="originalName" value="<%= row.getName()%>" required></td></tr>
                    <tr><td>Category</td><td><input type="text" name="originalCategory" value="<%= row.getCategory()%>" required></td></tr>
                    <tr><td>Price</td><td><input type="text" name="originalPrice" value="<%= formattedPrice %>" required></td></tr>
                    <tr><td>Stock</td><td><input type="text" name="originalStock" value="<%= row.getStock()%>" required></td></tr>
                    <tr>    
                    <td><input type="submit" name="updated" value="Update"></td> 
                    <td><input type="submit" name="deleted" value="Delete"></td>  
                    </tr>                  
                    <% } %>
                </table>  
            </form>
            <% } else { %>             
            <% } %>
            <p><%= idErr != null ? idErr : ""%></p>
            <p><%= updateErr != null ? updateErr : ""%></p>
            <p><%= deletedProduct != null ? deletedProduct : ""%></p> 
            <p><%= priceErr != null ? priceErr : ""%></p>
            <p><%= stockErr != null ? stockErr : ""%>  </p>              
            <p><%= updatedProduct != null ? updatedProduct : ""%></p> 
            <% session.setAttribute("idErr", ""); %>
            <% session.setAttribute("updatedProduct", ""); %>
            <% session.setAttribute("deletedProduct", ""); %>
            <% session.setAttribute("priceErr", ""); %>
            <% session.setAttribute("stockErr", ""); %>  
            <% session.setAttribute("updateErr", ""); %> 
            
    </body>
</html>
