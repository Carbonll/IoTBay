/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

/**
 *
 * @author melvi
 */
public class Validator implements Serializable {

    private String emailPattern = "^(.+)@(.+)$";
    private String namePattern = "[a-zA-Z0-9]{3,}";
    private String passwordPattern = "^[a-zA-Z0-9!@#$&]{4,}";
    private String phonePattern = "([0]{1}[4]{1}[0-9]{8})*";

    public Validator() {}

    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }

    public boolean checkEmpty(String email, String password) {
        return email.isEmpty() || password.isEmpty();
    }

    public boolean validateEmail(String email) {
        return validate(emailPattern, email);
    }

    public boolean validateName(String name) {
        return validate(namePattern, name);
    }

    public boolean validatePassword(String password) {
        return validate(passwordPattern, password);
    }
    
    public boolean validatePhone(String phone) {
        return validate(phonePattern, phone);
    }
    
    public void clear(HttpSession session) {
        session.setAttribute("emailErr", "Enter Email");
        session.setAttribute("passErr", "Enter Password");
        session.setAttribute("existErr", "");
        session.setAttribute("nameErr", "Enter Name");
        session.setAttribute("phoneErr", "Enter Phone");
    }
}
