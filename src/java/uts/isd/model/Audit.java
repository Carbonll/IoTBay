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
 * @author putra
 */
public class Audit implements Serializable {

    private int ID;
    private int userID;
    private String event;
    private String date;

    public Audit(ResultSet rs) {
        try {
            this.ID = rs.getInt(1);
            this.userID = rs.getInt(2);
            this.event = rs.getString(3);
            this.date = rs.getString(4);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() == null ? "Unable to load audit" : "New audit object created");
        }
    }

    public int getID() {
        return ID;
    }

    public int getUserID() {
        return userID;
    }

    public String getEvent() {
        return event;
    }

    public String getDate() {
        return date;
    }
}
