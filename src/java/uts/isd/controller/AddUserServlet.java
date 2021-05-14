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


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author jesse
 */
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        int roleID = Integer.parseInt(request.getParameter("roleID"));
        String roleErr = null;

        DBManager manager = (DBManager) session.getAttribute("manager");

        if (!validator.validateName(name)) {
            session.setAttribute("nameErr", "Invalid Name Format");
            request.getRequestDispatcher("SysAdminUserAdd.jsp").include(request, response);
        } else if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Invalid Email Format");
            request.getRequestDispatcher("SysAdminUserAdd.jsp").include(request, response);
        } else if (!validator.validatePhone(phone)) {
            session.setAttribute("phoneErr", "Invalid Phone Format");
            request.getRequestDispatcher("SysAdminUserAdd.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passwordErr", "Invalid Password Format");
            request.getRequestDispatcher("SysAdminUserAdd.jsp").include(request, response);
        } else {
            try {
                User check = manager.findUserByEmail(email);
                if (check == null) { //check if the inputted email already exists
                    if (roleID == 3) { //if roleID = 3, register as customer
                        manager.addUser(name, email, phone, password, 3);
                        User user = manager.findUserByEmail(email);
                        Date date = Calendar.getInstance().getTime();
                        manager.addAudit(user.getID(), "User Created", date);
                        request.getRequestDispatcher("SysAdminUserAdd.jsp").include(request, response);
                    } else { //user has attempted to input staff code
                        if (roleID == 2) { //if roleID = 2, register as staff
                            manager.addUser(name, email, phone, password, 2);
                            User user = manager.findUserByEmail(email);
                            Date date = Calendar.getInstance().getTime();
                            manager.addAudit(user.getID(), "User Created", date);
                            request.getRequestDispatcher("SysAdminUserAdd.jsp").include(request, response);
                        } else {
                            if (roleID == 1) { //if roleID = 1, register as system admin
                                manager.addUser(name, email, phone, password, 1);
                                User user = manager.findUserByEmail(email);
                                Date date = Calendar.getInstance().getTime();
                                manager.addAudit(user.getID(), "User Created", date);
                                request.getRequestDispatcher("SysAdminUserAdd.jsp").include(request, response);
                            } else {
                                session.setAttribute("roleErr", "Invalid Role Value");
                                request.getRequestDispatcher("SysAdminUserAdd.jsp").include(request, response);
                            }
                        }
                    }
                } else {
                    session.setAttribute("existErr", "Email is already in use");
                    request.getRequestDispatcher("SysAdminUserAdd.jsp").include(request, response);

                }
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "User doesn't exist" : "User Created!");
            }
            validator.clear(session);
        }
    }
}
