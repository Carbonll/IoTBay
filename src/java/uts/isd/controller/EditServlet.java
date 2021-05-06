/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBManager manager = (DBManager) session.getAttribute("manager");
        User user = null;

        try {
            user = manager.authenticateUser(email, password);
            if (user != null) {
                session.setAttribute("user", user);
                request.getRequestDispatcher("edit.jsp").include(request, response);
            } else {
                session.setAttribute("existErr", "User does not exist");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
    }
}
