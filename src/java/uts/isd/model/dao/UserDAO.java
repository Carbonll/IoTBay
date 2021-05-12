/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uts.isd.model.User;
/**
 *
 * @author jesse h
 */
public class UserDAO {
   
    private String jdbcURL; //needs updating
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) { // Needs updating
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean insertUser(User user) throws SQLException {
        String sql = "INSERT INTO USER (name, email, phone, password, role_ID) VALUES (?, ?, ?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(2, user.getName());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getPhone());
        statement.setString(5, user.getPassword());
        statement.setInt(6, user.getRoleID());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<User> listAllUsers() throws SQLException {
        List<User> listUser = new ArrayList<>(); //needs fixing
         
        String sql = "SELECT * FROM user";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int ID = resultSet.getInt("ID");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            String password = resultSet.getString("password");
            int roleID = resultSet.getInt("role_ID");
             
            User user = new User(ID,name, email, phone, password, roleID);
            listUser.add(user);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listUser;
    }
     
    public boolean deleteUser(User user) throws SQLException {
        String sql = "DELETE FROM user where email = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, user.getID()); // Not sure bout this 
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE user SET name = ?, email = ?, password = ?, phone = ?, roleID = ?";
        sql += " WHERE email = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(2, user.getName());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getPhone());
        statement.setString(5, user.getPassword());
        statement.setInt(6, user.getRoleID());
        
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public User getUser(String name, String email) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM user WHERE name = ?";
        sql += " AND email = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, ID); // use of id needs to be changed, id is not used in db but ID is double check things first before making changes
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            int ID = resultSet.getInt("ID");
            name = resultSet.getString("name");
            email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            String password = resultSet.getString("password");
            int roleID = resultSet.getInt("role_ID");
             
            user = new User(ID, name, email, phone, password, roleID); //check use of id here also, ID may or may not need to be used here as 
        }
         
        resultSet.close();
        statement.close();
         
        return user;
    }
}