<%-- 
    Document   : index
    Created on : 17/03/2021, 12:22:28 PM
    Author     : Anthony
--%>
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
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
            <a href="BrowseServlet">browse</a>
        </div>
    </html>
   <% OrderCart cart = (OrderCart) session.getAttribute("OrderCart");

// Create new cart if user doesnt have one.
     if(cart == null){
         cart = new OrderCart();
         session.setAttribute("OrderCart",cart);
    } 
// Get products from cart

     Vector items = cart.getProducts();

// If no products, cart is empty
     if(items.size() == 0){
      out.println("<h3>Cart is empty.</h3>");
     } else
       {

   %>
  <br>
  <table>
     <tr>
        <th>Product ID</th>
        <th>Name</th>
        <th>Category</th>
        <th>Price</th>
        <th>Stock</th>
     </tr>

     <% 
        int numProduct = items.size();
        for(int i = 0; i < numProduct; i++){
            Product products = (Product) items.elementAt(i);
        
            out.print("<tr><td>");
            out.print(products.getID());
            out.print("</td><td>");
            out.print(products.getName());
            out.print("</td><td>");
            out.print(products.getCategory());
            out.print("</td><td>");
            out.print(products.getPrice());
            out.print("</td><td>");
            out.print(products.getStock());
            out.println("<a href=\"/shoppingcart/RemoveItemServlet?item="+
                i+"\">Remove</a></td></tr>");
           }
         }

     %>
  </table>        