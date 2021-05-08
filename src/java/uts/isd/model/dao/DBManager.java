/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import uts.isd.model.User;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author melvi
 */
public class DBManager {

    private Statement st;

    public DBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    public User findUserByID(int ID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"USER\" WHERE ID = " + ID;
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int userID = rs.getInt(1);
            if (userID == ID) {
                return new User(rs);
            }
        }
        return null;
    }
    
    public User findUserByEmail(String email) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"USER\" WHERE EMAIL = '" + email + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String userEmail = rs.getString(3);
            if (userEmail.equals(email)) {
                return new User(rs);
            }
        }
        return null;
    }
    
    public User authenticateUser(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"USER\" WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String userEmail = rs.getString(3);
            String userPw = rs.getString(5);
            if (userEmail.equalsIgnoreCase(email) && userPw.equals(password)) {
                return new User(rs);
            }
        }
        return null;
    }
 
    public void addUser(String name, String email, String phone, String password, int roleID) throws SQLException {
        st.executeUpdate("INSERT INTO IOTUSER.\"USER\"(\"NAME\", EMAIL, PHONE, PASSWORD, ROLE_ID)" + "VALUES ('" + name + "', '" + email + "', '" + phone + "', '" + password + "', " + roleID + ")");
    }

    public void updateName(int ID, String name) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.\"USER\" SET \"NAME\" = '" + name + "' WHERE ID = " + ID);
        System.out.println("Updated " + name + " of ID " + ID);
    }

    public void updateEmail(int ID, String email) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.\"USER\" SET EMAIL = '" + email + "' WHERE ID = " + ID);
    }

    public void updatePhone(int ID, String phone) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.\"USER\" SET PHONE = '" + phone + "' WHERE ID = " + ID);
    }

    public void updatePassword(int ID, String password) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.\"USER\" SET PASSWORD = '" + password + "' WHERE ID = " + ID);
    }

    public void deleteUser(int ID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.\"USER\" WHERE ID = " + ID);
    }

    public ArrayList<User> fetchUsers() throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"USER\"";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> result = new ArrayList();

        while (rs.next()) {
            result.add(new User(rs));
        }
        return result;
    }
}
