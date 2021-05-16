/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

/**
 *
 * @author jesse
 */
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

public class UserManageServlet { //Needs work // For search Function

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();//?
        session.setAttribute("nameErr", "");
        session.setAttribute("phoneErr", "");
        User user = (User) session.getAttribute("user"); //Not sure if used properly, probz should be a aviable linked to searched values
        ArrayList<User> fetchUsers = new ArrayList();
        DBManager manager = (DBManager) session.getAttribute("manager");

        String name = request.getParameter("name"); //where is it recieving the parameter from, what is the value?
        String nameErr = request.getParameter("nameErr");
        String phone = request.getParameter("phone");
        String phoneErr = request.getParameter("phoneErr");

        try {
            if (name == null && phone == null) {
                fetchUsers = manager.fetchUsers();
                session.setAttribute("fetchUsers", fetchUsers);
                request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);

            } else if (phone == null && name != null) {
                user = manager.findUserByName(user.getName());
                request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);
            } else if (name == null && phone != null) {
                user = manager.findUserByPhone(user.getPhone());
                request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);

            } else {
                if (validator.validateName(name)) {
                    user = manager.findUserByName(user.getName());
                    request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);
                } else {
                    session.setAttribute("nameErr", "Invalid name format");
                    request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);
                }
                if (validator.validatePhone(phone)) {
                    user = manager.findUserByPhone(user.getPhone());
                    request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);
                } else {
                    session.setAttribute("phoneErr", "Invalid phone number format");
                    request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() == null ? "Unable to view an account" : " Account acquired");
        }
    }
}
