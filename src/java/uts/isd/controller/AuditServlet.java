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
public class AuditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        
        session.setAttribute("dateErr", "");
        User user = (User) session.getAttribute("user");
        ArrayList<Audit> log = new ArrayList();
        DBManager manager = (DBManager) session.getAttribute("manager");

        String date = request.getParameter("date");
        String dateErr = request.getParameter("dateErr");

        try {
            if (date == null) {
                log = manager.fetchAuditsByUserID(user.getID());
                session.setAttribute("log", log);
                request.getRequestDispatcher("auditlog.jsp").include(request, response);
            } else {
                if (validator.validateDate(date)) {
                    log = manager.fetchAuditsByDate(user.getID(), date);
                    session.setAttribute("log", log);
                    request.getRequestDispatcher("auditlog.jsp").include(request, response);
                } else {
                    session.setAttribute("dateErr", "Invalid date format");
                    request.getRequestDispatcher("auditlog.jsp").include(request, response);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() == null ? "Unable to obtain logs" : "Logs acquired");
        }
    }
}
