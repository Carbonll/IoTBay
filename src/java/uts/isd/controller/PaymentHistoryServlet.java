/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Audit;
import uts.isd.model.PaymentHistory;
import uts.isd.model.User;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author Leon
 */

public class PaymentHistoryServlet extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        
        session.setAttribute("paymentErr", "");
        User user = (User) session.getAttribute("user");
        ArrayList<PaymentHistory> log = new ArrayList();
        DBManager manager = (DBManager) session.getAttribute("manager");

        String date = request.getParameter("date"); // date for search
        String payment_id = request.getParameter("payment_id");
        String paymentErr = request.getParameter("paymentErr");
        int x= 0;
            
        try {
            if (date == null) {
                log = manager.fetchPaymentHistoryByUserID(user.getID());
                session.setAttribute("log", log);
                request.getRequestDispatcher("paymentHistory.jsp").include(request, response);
            } 
            else if (payment_id == null){
                try {
                    log = manager.fetchPaymentHistoryByUserID(user.getID());
                    session.setAttribute("log", log);
                    request.getRequestDispatcher("paymentHistory.jsp").include(request, response);
                } catch(Exception e){
                    
                }
            }
            else { // Search function
                if (validator.validateDate(date) && validator.validatePaymentID(payment_id)) { 
                    x = Integer.parseInt(request.getParameter("payment_id"));
                    log = manager.fetchPaymentHistoryByDateAndPaymentID(user.getID(), date, x);
                    session.setAttribute("log", log);
                    request.getRequestDispatcher("paymentHistory.jsp").include(request, response);
                } else { 
                    session.setAttribute("paymentErr", "Invalid format.");
                    request.getRequestDispatcher("paymentHistory.jsp").include(request, response);
                }
            }      
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() == null ? "Unable to obtain logs" : ex.getMessage());
        }
    }
}
