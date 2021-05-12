/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Leon
 */
public class PaymentHistory implements Serializable {
    
    private int ID; // Payment ID
    private int userID;
    private int orderID;
    private String date;
    
    public PaymentHistory (ResultSet rs) {
        try {
            this.ID = rs.getInt(1);
            this.userID = rs.getInt(2);
            this.orderID = rs.getInt(3);
            this.date = rs.getString(4);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() == null ? "Unable to load payment history" : ex.getMessage());
        }
    }

    public int getID() {
        return ID;
    }

    public int getUserID() {
        return userID;
    }

    public int getOrder() {
        return orderID;
    }

    public String getDate() {
        return date;
    }
    
}
