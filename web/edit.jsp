<%-- 
    Document   : index
    Created on : 17/03/2021, 12:22:28 PM
    Author     : melvi
--%>

<%@page import="uts.isd.model.Payment"%>
<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
        <!--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">-->
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            Payment payment = (Payment) session.getAttribute("payment");
            String updated = (String) session.getAttribute("updated");
            String c_updated = (String) session.getAttribute("c_updated");
            
            String cNameErr = (String) session.getAttribute("cNameErr");
            String cNoErr = (String) session.getAttribute("cNoErr");
            String cExpErr = (String) session.getAttribute("cExpErr");
            String cCvvErr = (String) session.getAttribute("cCvvErr");
        %>
        <div>
            <h1><a href="main.jsp">IoTBay</a></h1>
            <a href="LogoutServlet">logout</a>
            <a href="main.jsp">main</a>
            <a href="EditServlet">account</a>
            <a href="AuditServlet">access log</a>
        </div>
        <br>
        <div>
            <p>Your current account details are:</p>
            <form action="UpdateServlet" method="post">
                <input type="hidden" name="ID" value="${user.ID}">
                <table>
                    <tr>
                        <td>Name</td><td><input type="text" name="name" value="${user.name}" required></td>
                    </tr>
                    <tr>
                        <td>Email</td><td><input type="text" name="email" value="${user.email}" required></td>
                    </tr>
                    <tr>
                        <td>Phone</td><td><input type="text" name="phone" value="${user.phone}"></td>
                    </tr>
                    <tr>
                        <td>Password</td><td><input type="text" name="password" value="${user.password}" required></td>
                    </tr>
                </table>
                <p>Please edit the fields above to update any information.</p>
                <p><input type="submit" value="update"> <a href="deleteAcc.jsp">Delete account</a></p>
            </form>
            <p><%= updated != null ? updated : ""%></p>
        </div>
        <br>
        <div>
            <p>Your current saved payment details are:</p>
            <form action=PaymentServlet method="post">
                <input type="hidden" name="ID" value="${user.ID}">
                <table>
                    <tr>
                        <td>Payment Method</td>
                        <td>
                            <input type="radio" id="card" name="payment_method" value="card"  
                                    <% if (payment.getPaymentMethod() != null) { 
                                       if (payment.getPaymentMethod().equals("card")) { 
                                            out.print("checked=\"checked\""); } }
                                    %> 
                            >
                            <label for="card">Credit Card</label><br>
                            <input type="radio" id="paypal" name="payment_method" value="paypal" 
                                   <% if (payment.getPaymentMethod() != null) { 
                                       if (payment.getPaymentMethod().equals("paypal")) { 
                                            out.print("checked=\"checked\""); } }
                                    %> 
                            >
                            <label for="paypal">Paypal</label><br>
                        </td>
                    </tr>
                    <tr>
                        <td>Card Holder</td>
                        <td><input type="text" name="card_name" value="${payment.cardName}" placeholder="<%= cNameErr != null ? cNameErr : "Full Name"%>" required></td>
                    </tr>
                    <tr>
                        <td>Card No</td>
                        <td><input type="text" placeholder="<%= cNoErr != null ? cNoErr : "**** **** **** ****"%>" name="card_no" value="${payment.cardNo}" required></td>
                    </tr>
                    <tr>
                        <td>Card Expiry</td>
                        <td><input type="text" placeholder="<%= cExpErr != null ? cExpErr : "MM/YYYY"%>" name="card_exp" value="${payment.cardExp}" required></td>
                    </tr>
                    <tr>
                        <td>Card CVV</td>
                        <td><input type="text" placeholder="<%= cCvvErr != null ? cCvvErr : "CVV"%>" name="card_cvv" value="${payment.cardCvv}" required></td>
                    </tr>
                    </table>
                <input type="submit" value="save">
            </form>
            <p><%= c_updated != null ? c_updated : ""%></p>
        </div>
        <br>
        <div>
            <p>Your current saved shipment details are:</p>
        </div>
        <script src="https://unpkg.com/@popperjs/core@2/dist/umd/popper.js"></script>
        <script src="js/bootstrap.js"></script>
    </body>
</html>
