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
        String code = request.getParameter("code");
        int roleID = Integer.parseInt(request.getParameter("roleID"));

        DBManager manager = (DBManager) session.getAttribute("manager");
        //added section by jesse //For SysAdmin Creating accounts
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
                    User check = manager.findUserByEmail(email);
                    if (check == null) { //check if the inputted email already exists
                        if (code.isEmpty()) { //if user didnt attempt to input staff code, register as customer
                            manager.addUser(name, email, phone, password, 3);
                            User user = manager.findUserByEmail(email);
                            Date date = Calendar.getInstance().getTime();
                            manager.addAudit(user.getID(), "Register", date);
                            session.setAttribute("user", user);
                            request.getRequestDispatcher("main.jsp").include(request, response);
                        } else { //user has attempted to input staff code
                            if (validator.validateCode(code)) { //if staff code is correct, register as staff
                                manager.addUser(name, email, phone, password, 2);
                                User user = manager.findUserByEmail(email);
                                Date date = Calendar.getInstance().getTime();
                                manager.addAudit(user.getID(), "Register", date);
                                session.setAttribute("user", user);
                                request.getRequestDispatcher("main.jsp").include(request, response);
                            } else {
                                session.setAttribute("codeErr", "Incorrect Code");
                                request.getRequestDispatcher("register.jsp").include(request, response);
                            }
                        }
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

