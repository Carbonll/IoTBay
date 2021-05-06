/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

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

    public User(String name, String email, String phone, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
    
    public User(int ID, String name, String email, String phone, String password) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public void updateInfo(String name, String email, String phone, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        setPhone(phone);
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        if (name == null) {
            return ""; //Returns an empty string instead of null, if a variable is null. Useful so that an optional field, e.g. phone, doesn't display null
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
