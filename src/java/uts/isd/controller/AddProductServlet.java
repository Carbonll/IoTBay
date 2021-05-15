/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        ArrayList<Product> products = new ArrayList();
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        String productName = request.getParameter("newName");
        String productCategory = request.getParameter("newCategory");
        String productPrice = request.getParameter("newPrice");
        String productStock = request.getParameter("newStock");
        session.setAttribute("added", "");
        session.setAttribute("existProductErr", "");
        session.setAttribute("priceErr", "");
        session.setAttribute("stockErr", "");
        
        if (!validator.validatePrice(productPrice)) {
            session.setAttribute("priceErr", "Price must be decimal");
            request.getRequestDispatcher("addProduct.jsp").include(request, response);
        } else if (!validator.validateStock(productStock)) {
            session.setAttribute("stockErr", "Stock must be positive");
            request.getRequestDispatcher("addProduct.jsp").include(request, response);
        } else {
        try {
            double newPrice = Double.parseDouble(productPrice);
            int newStock = Integer.parseInt(productStock);            
            Product checkExist = manager.findProductByName(productName);
                
            if (checkExist == null) { //check if the inputted product name already exists          
                manager.addProduct(productName, productCategory, newPrice, newStock);
                session.setAttribute("products", products);
                session.setAttribute("added", "Product successfully added.");
                request.getRequestDispatcher("addProduct.jsp").include(request, response);                
                } else {
                    session.setAttribute("existProductErr", "Product name is already in use");
                    request.getRequestDispatcher("addProduct.jsp").include(request, response);
                }                
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() == null ? "Unable to add product" : "product added");
        }
        }
    validator.clearProductForm(session);
    }
}
