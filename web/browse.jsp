<%-- 
    Document   : index
    Created on : 17/03/2021, 12:22:28 PM
    Author     : melvi
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.controller.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Browse Page</title>
    </head>
    <body>
        <%
            ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");
            User user = (User) session.getAttribute("user");
        %>
        <% if (user.getRoleID() == 2) { %>
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
        <% } else { %>
        <div>
            <h1><a href="main.jsp">IoTBay</a></h1>
            <a href="LogoutServlet">logout</a>
            <a href="main.jsp">main</a>
            <a href="EditServlet">account</a>
            <a href="AuditServlet">access log</a>
            <a href="BrowseServlet">browse</a>
        </div>
        <% } %>
        <br>
        <div>
            <h2>Welcome,&nbsp;<%= user.getRoleID() == 2 ? "Staff Member " + user.getName() : user.getRoleID() == 1 ? "System Admin" : user.getName() %></h2>
        </div>
        <div>
        <form action="SearchProductServlet">
            <p>Search by Name or Category <input type="text" name="productSearch"><input type="submit" value="Search"></p>
        </form>
            <% if (user.getRoleID() == 2) { %>
            <form action=updateProduct.jsp method="post">
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
                    <% for (Product row : products) {%>
                    <%String formattedPrice = String.format("%.2f", row.getPrice()); %>
                    <tr>
                        <td style="text-align: center"><%= row.getID()%></td>
                        <td style="text-align: center"><%= row.getName()%></label></td>
                        <td style="text-align: center"><%= row.getCategory()%></td>
                        <td style="text-align: center"><%= formattedPrice %></td>
                        <td style="text-align: center"><%= row.getStock()%></td>
                        <input type="hidden" name="productID" value="<%= row.getID()%>">
                    </tr>
                    <% }%>
                    <% } else {%>
            <form action=updateProduct.jsp method="post">
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
                    <% for (Product row : products) {%>
                    <tr>
                    <input type="hidden" name="productName" value="<%= row.getName()%>">
                    <input type="hidden" name="productCategory" value="<%= row.getCategory()%>">
                    <input type="hidden" name="productPrice" value="<%= row.getPrice()%>">
                    <input type="hidden" name="productStock" value="<%= row.getStock()%>">
                        <td style="text-align: center"><%= row.getID()%></td>
                        <td style="text-align: center"><label for="name"><%= row.getName()%></label></td>
                        <td style="text-align: center"><%= row.getCategory()%></td>
                        <td style="text-align: center"><%= row.getPrice()%></td>
                        <td style="text-align: center"><%= row.getStock()%></td>
                        <td style="text-align: center"><input type="submit" value="Add to order"></td>
                    </tr>
                    <% }%>
                    <% }%>
                    
                </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
