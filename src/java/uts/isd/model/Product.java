/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;
import java.sql.*;

/**
 *
 * @author Peter
 */
public class Product implements Serializable {
    private int ID;
    private String name;
    private String category;
    private double price;
    private int stock;

    public Product(int ID, String name, String category, double price, int stock) {
        this.ID = ID;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public Product(ResultSet rs) {
        try {
            this.ID = rs.getInt(1);
            this.name = rs.getString(2);
            this.category = rs.getString(3);
            this.price = rs.getDouble(4);
            this.stock = rs.getInt(5);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() == null ? "Unable to load user" : "New user object created");
        }
    }

    
    public void updateInfo(int ID, String name, String category, double price, int stock){
        this.ID = ID;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
