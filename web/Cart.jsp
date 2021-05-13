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
        <title>Cart Page</title>
    </head>
    <body>
        <div>
            <h1><a href="index.jsp">IoTBay</a></h1>
            <a href="register.jsp">register</a>
            <a href="login.jsp">login</a>
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
                <tbody>
                <tr>
                     <th>Product ID</th>
                     <th>Name</th>
                     <th>Category</th>
                     <th>Price</th>
                     <th>Stock</th>
                </tr>
                <% 
                     ServletContext sc = getServletConfig().getServletContext();
                     if(session.getAttribute("shop") != null){
                     OrderCart cart = (OrderCart)session.getAttribute("shop");
                     ArrayList<Product> list = cart.getIt();
                      for(int i = 0; i< list.size(); i++){
                       out.println("<span class='price'>"+list.get(i).getPrice()+"</span>");
                       }
                    }else{
                   }
                   %>             
                </tbody>
            </table>
        </div>
    </body>
</html>
