/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.User;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author melvi
 */
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        DBManager manager = (DBManager) session.getAttribute("manager");

        try {
            Date date = Calendar.getInstance().getTime();
            manager.addAudit(user.getID(), "Logout", date);
            session.invalidate();
            request.getRequestDispatcher("logout.jsp").include(request, response);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() == null ? "Unable to logout" : "User logged out");
        }
    }
}
