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
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        DBManager manager = (DBManager) session.getAttribute("manager");
        User user = null;

        if (!validator.validateName(name)) {
            session.setAttribute("nameErr", "Invalid Name Format");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Invalid Email Format");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validatePhone(phone)) {
            session.setAttribute("phoneErr", "Invalid Phone Format");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passwordErr", "Invalid Password Format");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else {
            try {
                user = manager.findUserByEmail(email);
                if (user == null) {
                    manager.addUser(name, email, phone, password);
                    user = new User(name, email, phone, password);
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                } else {
                    session.setAttribute("existErr", "Email is already in use");
                    request.getRequestDispatcher("register.jsp").include(request, response);
                }
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "User doesn't exist" : "Welcome!");
            }
        }
        validator.clear(session);
    }
}
