/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.sql.*;
import java.io.Serializable;

/**
 *
 * @author melvi
 */
public class User implements Serializable {

    private int ID;
    private String name;
    private String email;
    private String password;
    private String phone;
    private int roleID;
    private int paymentID;
    private int shipmentID;

    public User(int ID, String name, String email, String phone, String password, int roleID) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.roleID = roleID;
    }

    public User(ResultSet rs) { //uses an sql result set's rows to fill in User attributes
        try {
            this.ID = rs.getInt(1);
            this.name = rs.getString(2);
            this.email = rs.getString(3);
            this.phone = rs.getString(4);
            this.password = rs.getString(5);
            this.roleID = rs.getInt(6);
            this.paymentID = rs.getInt(7);
            this.shipmentID = rs.getInt(8);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() == null ? "Unable to load user" : "New user object created");
        }
    }

    public int getID() {
        return ID;
    }
    
    public int getRoleID() {
        return roleID;
    }
    
    public int getPaymentID() {
        return paymentID;
    }
    
    public int getShipmentID() {
        return shipmentID;
    }

    public String getName() {
        if (name == null) {
            return "";
        }
        return name;
    }

    public String getEmail() {
        if (email == null) {
            return "";
        }
        return email;
    }

    public String getPassword() {
        if (password == null) {
            return "";
        }
        return password;
    }

    public String getPhone() {
        if (phone == null) {
            return "";
        }
        return phone;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}

