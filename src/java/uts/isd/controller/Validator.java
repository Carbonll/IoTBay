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
    private String codePattern = "1234*"; //staff registration code
    private String datePattern = "^\\d{2}-\\d{2}-\\d{4}$"; //doesn't really check for valid months/days, but it'll work
    
    private String cardNoPattern = "(.*?)";
    private String cardHolderPattern = "(.*?)";
    private String cardCvvPattern = "(.*?)";
    private String cardExpPattern = "(.*?)";

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
    
    public boolean validateCode(String code) {
        return validate(codePattern, code);
    }
    
    public boolean validateDate(String date) {
        return validate(datePattern, date);
    }
    
    public boolean validateCardNo(String card_no) {
        return validate(cardNoPattern, card_no);
    }
    
    public boolean validateCardHolder(String card_name) {
        return validate(cardHolderPattern, card_name);
    }
    
    public boolean validateCardCvv(String card_cvv) {
        return validate(cardCvvPattern, card_cvv);
    }
    
    public boolean validateCardExp(String card_exp) {
        return validate(cardExpPattern, card_exp);
    }
    
    public void clear(HttpSession session) {
        session.setAttribute("emailErr", "Enter Email");
        session.setAttribute("passErr", "Enter Password");
        session.setAttribute("existErr", "");
        session.setAttribute("nameErr", "Enter Name");
        session.setAttribute("phoneErr", "Enter Phone");
    }
    public void clearCode(HttpSession session) {
        session.setAttribute("codeErr", "Enter Code");
    }
}
