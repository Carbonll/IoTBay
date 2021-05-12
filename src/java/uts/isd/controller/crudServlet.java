/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author jesse h
 */
public class crudServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertUser(request, response);
                break;
            case "/delete":
                deleteUser(request, response);
                break;
            case "/edit":
                editUserForm(request, response);
                break;
            case "/update":
                updateUser(request, response);
                break;
            default:
                listUser(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userDAO.listAllUser();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("userList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("userForm.jsp");
        dispatcher.forward(request, response);
    }
 
    private void editUserForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        User existingUser = userDAO.getUser(ID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("userForm.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
 
    }
 
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        int roleID = Integer.parseInt(request.getParameter("roleID"));
 
        User newUser = new User(name, email, phone, password, roleID);
        userDAO.insertUser(newUser);
        response.sendRedirect("list");
    }
 
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        // int ID = Integer.parseInt(request.getParameter("ID"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        int roleID = Integer.parseInt(request.getParameter("roleID"));
 
        User user = new User(name, email, phone, password, roleID);
        userDAO.insertUser(user);
        response.sendRedirect("list");
    }
 
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int ID = Integer.parseInt(request.getParameter("ID"));
 
        User user = new User(ID);
        userDAO.deleteUser(user);
        response.sendRedirect("list");
 
    }
}
