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
        try {
            ServletContext thisContext = getServletContext();
            
            HttpSession session = request.getSession(true);
            OrderCart cart = (OrderCart)session.getAttribute("cart");
            
            String name = request.getParameter("name");
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/iotdb","iotuser","admin");
            
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM PRODUCT WHERE PRODUCT_NAME = '"+name+"'");
                while(rs.next()){
                    Product p = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5));
                    if(cart == null) {
                        cart = new OrderCart();
                        session.setAttribute("cart", cart);
                    }
                    cart.addProduct(p);
                    thisContext.setAttribute("cart", cart.getIt());
                    for(int i = 0; i< cart.getIt().size(); i++){
                        System.out.println(cart.getIt().get(i)+":"+ cart.getIt().get(i).getPrice());
                    }
                    response.sendRedirect("Cart.jsp?addedto=success");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
    }

}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}

}
