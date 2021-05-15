/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class SearchProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Product> products = new ArrayList();
        DBManager manager = (DBManager) session.getAttribute("manager");        
        String productSearch = request.getParameter("productSearch");

        try {
            if (user != null) { //Check for anonymous user
                products = manager.fetchProductsByNameAndCategory(productSearch);
                session.setAttribute("products", products);
                request.getRequestDispatcher("browse.jsp").include(request, response);
            }
            else {
                products = manager.fetchProductsByNameAndCategory(productSearch);
                session.setAttribute("products", products);
                request.getRequestDispatcher("browseAnon.jsp").include(request, response);                           
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() == null ? "Unable to search product" : "Product found");
        }
    }
}
