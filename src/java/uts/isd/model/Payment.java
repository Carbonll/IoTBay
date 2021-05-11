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
 * @author leon
 */
public class Payment implements Serializable {

    private int ID;
    private String paymentMethod;
    private String cardName;
    private String cardNo;
    private String cardExp;
    private String cardCvv;
    private int user_ID;

    public Payment(ResultSet rs) {
        try {
            this.ID = rs.getInt(1);
            this.paymentMethod = rs.getString(2);
            this.cardName = rs.getString(5);
            this.cardNo = rs.getString(6);
            this.cardExp = rs.getString(7);
            this.cardCvv = rs.getString(8);
            this.user_ID = rs.getInt(9);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() == null ? "Unable to load payment" : "New payment object created");
        }
    }

    public int getID() {
        return ID;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public String getCardExp() {
        return cardExp;
    }

    public String getCardCvv() {
        return cardCvv;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }  
}
