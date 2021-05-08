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
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        int ID = Integer.parseInt(request.getParameter("ID"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        User user = new User(ID, name, email, phone, password);
        DBManager manager = (DBManager) session.getAttribute("manager");

        if (!validator.validateName(name)) {
            session.setAttribute("updated", "Invalid Name Format");
            request.getRequestDispatcher("edit.jsp").include(request, response);
        } else if (!validator.validateEmail(email)) {
            session.setAttribute("updated", "Invalid Email Format");
            request.getRequestDispatcher("edit.jsp").include(request, response);
        } else if (!validator.validatePhone(phone)) {
            session.setAttribute("updated", "Invalid Phone Format");
            request.getRequestDispatcher("edit.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("updated", "Invalid Password Format");
            request.getRequestDispatcher("edit.jsp").include(request, response);
        } else {
            try {
                User check = manager.findUserByEmail(email);
                if (check == null || check.getEmail().equals(email)) {
                    session.setAttribute("user", user);
                    manager.updateName(ID, name);
                    manager.updateEmail(ID, email);
                    manager.updatePhone(ID, phone);
                    manager.updatePassword(ID, password);
                    session.setAttribute("updated", "Details successfully updated.");
                    System.out.println("Updated User");
                    request.getRequestDispatcher("edit.jsp").include(request, response);
                } else {
                    session.setAttribute("updated", "Email is already in use");
                    request.getRequestDispatcher("edit.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
            }
            response.sendRedirect("edit.jsp");
        }
    }
}
