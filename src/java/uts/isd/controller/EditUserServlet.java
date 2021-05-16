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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.*;
import java.io.PrintWriter;
import uts.isd.model.User;
/**
 *
 * @author jesse
 */ //!FOR USE BY SYSTEM ADMIN, IN SysAdminUserManage.jsp
public class EditUserServlet {
    //Should have user edit form
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
 
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update User</h1>");  
        String sID=request.getParameter("ID");  
        int ID=Integer.parseInt(sID);
        DBManager manager = (DBManager) session.getAttribute("manager");
          
        User user = DBManager.findUserByID(ID);  //? not sure 
          
        out.print("<form action='UpdateUserServlet' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='ID' value='"+user.getID()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+user.getName()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+user.getEmail()+"'/></td></tr>");  
        out.print("<tr><td>Phone:</td><td><input type='text' name='phone' value='"+user.getPhone()+"'/></td></tr>");  
        out.print("<tr><td>Password:</td><td><input type='text' name='password' value='"+user.getPassword()+"'/></td></tr>");  
        out.print("<tr><td>Role ID:</td><td><input type='text' name='roleID' value='"+user.getRoleID()+"'/></td></tr>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  
