/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author Leon
 */
public class PaymentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        
        int ID = Integer.parseInt(request.getParameter("ID"));
        String cardName = request.getParameter("card_name");
        String cardNo = request.getParameter("card_no");
        String cardExp = request.getParameter("card_exp");
        String cardCvv = request.getParameter("card_cvv");
        
        DBManager manager = (DBManager) session.getAttribute("manager");
        session.setAttribute("c_updated", ""); //clear any error messages
        
        if (!validator.validateCardNo(cardNo)) { //validate format for all fields
            session.setAttribute("c_updated", "Invalid Card No");
            request.getRequestDispatcher("edit.jsp").include(request, response);
        } else if (!validator.validateCardHolder(cardName)) {
            session.setAttribute("c_updated", "Invalid Name");
            request.getRequestDispatcher("edit.jsp").include(request, response);
        } else if (!validator.validateCardExp(cardExp)) {
            session.setAttribute("c_updated", "Invalid Date Format");
            request.getRequestDispatcher("edit.jsp").include(request, response);
        } else if (!validator.validateCardCvv(cardCvv)) {
            session.setAttribute("c_updated", "Invalid CVV Format");
            request.getRequestDispatcher("edit.jsp").include(request, response);
        } else {
            try {
                Payment check = manager.findPaymentDetailsByID(ID);
                if (check!=null) {
                    manager.updateCardNo(ID, cardNo);
                    manager.updateCardName(ID, cardName);
                    manager.updateCardExp(ID, cardExp);
                    manager.updateCardCvv(ID, cardCvv);
                    Payment user = manager.findPaymentDetailsByID(ID);
                    session.setAttribute("user", user);
                    session.setAttribute("c_updated", "Payment details successfully updated.");
                    request.getRequestDispatcher("edit.jsp").include(request, response);
                } else {
                    manager.addPayment(cardName, cardNo, cardExp, cardCvv);
                    Payment user = manager.findPaymentDetailsByID(ID);
                    session.setAttribute("user", user);
//                    session.setAttribute("c_updated", "Please try again.");
                    request.getRequestDispatcher("edit.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage() == null ? "Unable to update payment details" : "Payment details updated");
            }
            response.sendRedirect("edit.jsp");
        }
    }
}
