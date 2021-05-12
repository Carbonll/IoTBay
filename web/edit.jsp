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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <title>Edit Page</title>
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
        
    <!--Navigation Menu-->   
  
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="main.jsp">
        <!--<img src="https://getbootstrap.com/docs/4.3/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="">-->
        <div class="ms-3"> IoTBay </div>
        </a>
        <form class="form-inline">
          <input class="form-control" type="search" placeholder="Search for items" aria-label="Search">
        </form>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <div class="me-auto"></div>
                <ul class="navbar-nav my-2 my-lg-0">
                <li class="nav-item">
                  <a class="nav-link" href="main.jsp">Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link active" href="EditServlet">Account</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="AuditServlet">Access Log</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="PaymentHistoryServlet">Payment History</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="LogoutServlet">Logout</a>
                </li>
              </ul>
        </div>
    </nav>
        
    <!--Main-->
        
        <div class="ms-5 mt-3">
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
        <div class="ms-5 mt-3">
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
                        <td><input type="text" placeholder="<%= cExpErr != null ? cExpErr : "MM/YY"%>" name="card_exp" value="${payment.cardExp}" required></td>
                    </tr>
                    <tr>
                        <td>Card CVV</td>
                        <td><input type="text" placeholder="<%= cCvvErr != null ? cCvvErr : "CVV"%>" name="card_cvv" value="${payment.cardCvv}" required></td>
                    </tr>
                    </table>
                <input type="submit" value="save"> <a href="deletePayment.jsp">Delete Payment Details</a>
            </form>
            <p><%= c_updated != null ? c_updated : ""%></p>
        </div>
        <br>
        <div class="ms-5 mt-3">
            <p>Your current saved shipment details are:</p>
        </div>
 
        <!--Footer-->
        <!-- Popper.js, then Bootstrap JS -->
        <script src="https://unpkg.com/@popperjs/core@2/dist/umd/popper.js"></script>
        <script src="js/bootstrap.js"></script>
    </body>
</html>
