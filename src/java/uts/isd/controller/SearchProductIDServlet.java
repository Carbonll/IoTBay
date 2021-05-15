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
 * @author putra
 */
public class SearchProductIDServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        ArrayList<Product> products = new ArrayList();
        DBManager manager = (DBManager) session.getAttribute("manager");        
        String prodID = request.getParameter("productIDSearch");
        session.setAttribute("idErr", "");

        try {
            if (validator.validateNumber(prodID)) {
                session.setAttribute("idErr", "Invalid ID Format");
                request.getRequestDispatcher("updateProduct.jsp").include(request, response);
            } else {
                int productID = Integer.parseInt(prodID);
                products = manager.fetchProductByID(productID);
                session.setAttribute("product", products);
                request.getRequestDispatcher("updateProduct.jsp").include(request, response);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() == null ? "Unable to search product" : "product found");
        }
    }
}
