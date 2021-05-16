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
import uts.isd.model.User;
import uts.isd.model.dao.DBManager;

public class UserManageServlet { //Needs work // For search Function

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();//?
        session.setAttribute("nameErr", "");
        session.setAttribute("phoneErr", "");
        //User user = (User) session.getAttribute("user"); //Not sure if used properly, probz should be a aviable linked to searched values
        ArrayList<User> users = new ArrayList();
        DBManager manager = (DBManager) session.getAttribute("manager");

        String name = request.getParameter("name"); //where is it recieving the parameter from, what is the value?
        String nameErr = request.getParameter("nameErr");
        String phone = request.getParameter("phone");
        String phoneErr = request.getParameter("phoneErr");

        try {
            if (name == null && phone == null) { //no search = all users
                users = manager.fetchUsers();
                session.setAttribute("users", users);
                request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);

            } else if (phone == null && name != null) { // search by name = all userID data where name = name searched
                session.setAttribute("users", users);
                request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);
                
                if (validator.validateName(name)) {
                    users = manager.findUserByName(name); // Not sure how to apply the sql requry method using the inputs of the search function on the jsp page, to put into a list which can then be put back to the jsp table for viewing the selected data 
                    session.setAttribute("users", users);
                    request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);
                } else {
                    session.setAttribute("nameErr", "Invalid name format");
                    request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);
                }
                
            } else { //(name == null && phone != null) {  // search by phone = all userID data where phone = phone searched
                session.setAttribute("users", users);
                request.getRequestDispatcher("SysAdminUserManage.jsp").include(request, response);
                
                if (validator.validatePhone(phone)) {
                    users = manager.findUserByPhone(phone); // Not sure how to apply the sql requry method using the inputs of the search function on the jsp page, to put into a list which can then be put back to the jsp table for viewing the selected data 
                    session.setAttribute("users", users);
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
