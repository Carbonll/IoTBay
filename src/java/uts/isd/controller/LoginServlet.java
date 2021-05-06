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
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBManager manager = (DBManager) session.getAttribute("manager");
        User user = null;

        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Invalid Email Format");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Invalid Password Format");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else {
            try {
                user = manager.authenticateUser(email, password);
                if (user != null) {
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                } else {
                    session.setAttribute("existErr", "Incorrect email or password. Please try again");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                }
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "User doesn't exist" : "Welcome!");
            }
        }
        validator.clear(session);
    }
}
