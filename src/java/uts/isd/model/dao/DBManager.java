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

//Find user by email and password in the database   
    public User findUser(int ID, String email) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"USER\" WHERE ID = " + ID + " AND EMAIL = '" + email + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int userID = Integer.parseInt(rs.getString(1));
            String userEmail = rs.getString(3);
            if (userID == ID && userEmail.equals(email)) {
                String userName = rs.getString(2);
                String userPh = rs.getString(4);
                String userPw = rs.getString(5);
                return new User(userName, userEmail, userPh, userPw);
            }
        }
        return null;
    }

//Add a user-data into the database   
    public void addUser(String name, String email, String phone, String password) throws SQLException {
        st.executeUpdate("INSERT INTO IOTUSER.\"USER\"(\"NAME\", EMAIL, PHONE, PASSWORD)" + "VALUES ('" + name + "', '" + email + "', '" + phone + "', '" + password + "')");
    }

//update a user details in the database   
    public void updateUser(int ID, String name, String email, String phone, String password) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.\"USER\" SET NAME = '" + name + "', '" + email + "', '" + phone + "', '" + password + "' WHERE ID = " + ID);
    }

    public void updateName(int ID, String name) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.\"USER\" SET NAME = '" + name + "' WHERE ID = " + ID);
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

//delete a user from the database   
    public void deleteUser(int ID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.\"USER\" WHERE ID = " + ID);
    }

    public ArrayList<User> fetchUsers() throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"USER\"";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> result = new ArrayList();

        while (rs.next()) {
            int ID = Integer.parseInt(rs.getString(1));
            String name = rs.getString(2);
            String email = rs.getString(3);
            String phone = rs.getString(4);
            String password = rs.getString(5);
            result.add(new User(ID, name, email, phone, password));
        }
        return result;
    }
}
