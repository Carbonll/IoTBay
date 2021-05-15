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
import javax.servlet.RequestDispatcher;
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
public class UpdateProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        ArrayList<Product> product = new ArrayList();
        DBManager manager = (DBManager) session.getAttribute("manager");        
        String proID = request.getParameter("productID");
        String productName = request.getParameter("originalName");
        String productCategory = request.getParameter("originalCategory");
        String prodPrice = request.getParameter("originalPrice");
        String prodStock = request.getParameter("originalStock");
        int currentID = Integer.parseInt(proID);
        String updatePressed = request.getParameter("updated");
        String deletePressed = request.getParameter("deleted");
        session.setAttribute("updatedProduct", "");
        session.setAttribute("updateErr", "");
                    
        try {

            if (!validator.validatePrice(prodPrice)) {
                session.setAttribute("priceErr", "Price must have 2 decimal places");
                request.getRequestDispatcher("updateProduct.jsp").include(request, response);
            } else if (validator.validateNumber(prodStock)) {
                session.setAttribute("stockErr", "Stock must be positive number");
                request.getRequestDispatcher("updateProduct.jsp").include(request, response);
            } else {
                if (updatePressed != null) {
                    double productPrice = Double.parseDouble(prodPrice);
                    int productStock = Integer.parseInt(prodStock);
                    Product checkExist = manager.findOtherProductByName(productName, currentID);
                        if (checkExist == null) { //check if the inputted product name already exists  
                            manager.updateProductName(currentID, productName);
                            manager.updateProductCategory(currentID, productCategory);
                            manager.updateProductPrice(currentID, productPrice);
                            manager.updateProductStock(currentID, productStock);
                            session.setAttribute("updatedProduct", "Product successfully updated.");
                            session.setAttribute("product", null);
                            request.getRequestDispatcher("updateProduct.jsp").include(request, response);
                        }
                        else {
                            session.setAttribute("updateErr", "Another product already exists with the same name");
                            request.getRequestDispatcher("updateProduct.jsp").include(request, response);
                        }
                }
                else {
                    RequestDispatcher rd = request.getRequestDispatcher("DeleteProductServlet");
                    rd.forward(request, response);
                }
                }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() == null ? "Unable to update product" : "product updated");
        }
    }
}
