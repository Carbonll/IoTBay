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

public class UserManageServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();

        session.setAttribute("nameErr", "");
        session.setAttribute("phoneErr", "");
        User user = (User) session.getAttribute("user");
        ArrayList<Audit> log = new ArrayList();
        DBManager manager = (DBManager) session.getAttribute("manager");

        String name = request.getParameter("name");
        String nameErr = request.getParameter("nameErr");
        String phone = request.getParameter("phone");
        String phoneErr = request.getParameter("phoneErr");

        try {
            if (name == null) {
                log = manager.fetchAuditsByUserID(user.getID());
                session.setAttribute("log", log);
                request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);
            } else if (phone == null) {
                log = manager.fetchAuditsByname(user.getID());
                session.setAttribute("log", log);
                request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);   
            } else {
                if (validator.validateDate(name)) {
                    log = manager.fetchAuditsByDate(user.getID(), name);
                    session.setAttribute("log", log);
                    request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);
                } else {
                    session.setAttribute("nameErr", "Invalid name format");
                    request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);
                }      
                if (validator.validateDate(phone)) {
                    log = manager.fetchAuditsByDate(user.getID(), phone);
                    session.setAttribute("log", log);
                    request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);
                } else {
                    session.setAttribute("phoneErr", "Invalid phone number format");
                    request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);
                }
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() == null ? "Unable to obtain logs" : "Logs acquired");
        }
    }
}


