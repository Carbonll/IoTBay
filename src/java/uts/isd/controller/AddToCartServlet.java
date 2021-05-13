/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.*;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author Peter
 */
public class AddToCartServlet extends HttpServlet {

    private OrderCart cart = new OrderCart();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
     // Obtain product values from request   
    int productID = Integer.parseInt(request.getParameter("ID"));
    String productName = request.getParameter("name");
    String productCat = request.getParameter("category");
    double productPrice = Double.parseDouble(request.getParameter("price"));
    int productStock = Integer.parseInt(request.getParameter("stock"));
    
    // Create product for the cart
    Product products = new Product(productID, productName, productCat, productPrice, productStock);
    HttpSession session = request.getSession();
    
    // Get cart
    OrderCart cart = (OrderCart) session.getAttribute("OrderCart");
    
    // If none, create one
    if(cart == null){
        cart = new OrderCart();
        
        session.setAttribute("OrderCart",cart);
    }
    cart.addProduct(products);
    // Display cart
    response.sendRedirect(response.encodeRedirectURL("Cart.jsp"));
    }
}
