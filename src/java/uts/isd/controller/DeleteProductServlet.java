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
public class DeleteProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Product> products = new ArrayList();
        DBManager manager = (DBManager) session.getAttribute("manager");        
        String proID = request.getParameter("productID");
        String productName = request.getParameter("originalName");
        String productCategory = request.getParameter("originalCategory");
        String prodPrice = request.getParameter("originalPrice");
        String prodStock = request.getParameter("originalStock");
        int currentID = Integer.parseInt(proID);
        String updatePressed = request.getParameter("updated");
        String deletePressed = request.getParameter("deleted");
        
        try {
            manager.deleteProduct(currentID);
            session.setAttribute("deletedProduct", "Product successfully deleted.");
            session.setAttribute("product", null);
            request.getRequestDispatcher("updateProduct.jsp").include(request, response);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() == null ? "Unable to delete product" : "Product deleted");
        }
    }
}
