/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.User;
import uts.isd.model.dao.*;

/**
 *
 * @author melvi
 */
public class TestDB {

    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private DBManager db;

    public static void main(String[] args) throws SQLException {
        (new TestDB()).runQueries();
    }

    public TestDB() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new DBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private char readChoice() {
        System.out.print("Please enter your CRUDS operation. * to exit");
        return in.nextLine().charAt(0);
    }

    private void runQueries() {
        char choice;

        while ((choice = readChoice()) != '*') {
            switch (choice) {
                case 'C':
                    testCreate();
                    break;
                case 'R':
                    testRead();
                    break;
                case 'U':
                    testUpdate();
                    break;
                case 'D':
                    testDelete();
                    break;
                case 'S':
                    testShowAll();
                    break;
//                case '?':
//                    testHelp();
//                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }
    }

    private void testCreate() {
        System.out.print("Please enter the following:");
        System.out.println("Username: ");
        String name = in.nextLine();
        System.out.print("Email: ");
        String email = in.nextLine();
        System.out.print("Phone: ");
        String phone = in.nextLine();
        System.out.print("Password: ");
        String password = in.nextLine();

        try {
            db.addUser(name, email, phone, password);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("New user successfully added to database");
    }

    private void testRead() {
        System.out.print("Please enter the following:");
        System.out.println("User ID: ");
        int ID = Integer.parseInt(in.nextLine());
        System.out.print("Email: ");
        String email = in.nextLine();
        try {
            User user = db.findUser(ID, email);
            if (user != null) {
                System.out.println("User " + user.getName() + " exists within the database.");
            } else {
                System.out.println("User does not exist within the database.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private char readUpdateChoice() {
        System.out.print("Please choose the field to update. ");
        System.out.println("1 Username");
        System.out.println("2 Email");
        System.out.println("3 Phone");
        System.out.println("4 Password");
        System.out.println("5 All");
        System.out.println("6 Cancel");
        return in.nextLine().charAt(0);
    }

    private void testUpdate() {
        char choice;

        while ((choice = readUpdateChoice()) != '6') {
            switch (choice) {
                case '1':
                    updateName();
                    break;
                case '2':
                    updateEmail();
                    break;
                case '3':
                    updatePhone();
                    break;
                case '4':
                    updatePassword();
                    break;
                case '5':
                    updateAll();
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }
    }

    private void updateName() {
        System.out.print("Please enter the user to update:");
        System.out.println("User ID: ");
        int ID = Integer.parseInt(in.nextLine());
        System.out.println("Email: ");
        String email = in.nextLine();

        try {
            if (db.findUser(ID, email) != null) {
                System.out.print("New username: ");
                String newName = in.nextLine();
                db.updateName(ID, newName);
                System.out.println("User successfully updated.");
            } else {
                System.out.println("User does not exist within the database.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateEmail() {
        System.out.print("Please enter the user to update:");
        System.out.println("User ID: ");
        int ID = Integer.parseInt(in.nextLine());
        System.out.println("Email: ");
        String email = in.nextLine();

        try {
            if (db.findUser(ID, email) != null) {
                System.out.print("New email: ");
                String newEmail = in.nextLine();
                db.updateEmail(ID, newEmail);
                System.out.println("User successfully updated.");
            } else {
                System.out.println("User does not exist within the database.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updatePhone() {
        System.out.print("Please enter the user to update:");
        System.out.println("User ID: ");
        int ID = Integer.parseInt(in.nextLine());
        System.out.println("Email: ");
        String email = in.nextLine();

        try {
            if (db.findUser(ID, email) != null) {
                System.out.print("New phone: ");
                String newPhone = in.nextLine();
                db.updatePhone(ID, newPhone);
                System.out.println("User successfully updated.");
            } else {
                System.out.println("User does not exist within the database.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updatePassword() {
        System.out.print("Please enter the user to update:");
        System.out.println("User ID: ");
        int ID = Integer.parseInt(in.nextLine());
        System.out.println("Email: ");
        String email = in.nextLine();

        try {
            if (db.findUser(ID, email) != null) {
                System.out.print("New password: ");
                String newPw = in.nextLine();
                db.updatePassword(ID, newPw);
                System.out.println("User successfully updated.");
            } else {
                System.out.println("User does not exist within the database.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateAll() {
        System.out.print("Please enter the user to update:");
        System.out.println("User ID: ");
        int ID = Integer.parseInt(in.nextLine());
        System.out.println("Email: ");
        String email = in.nextLine();

        try {
            if (db.findUser(ID, email) != null) {
                System.out.print("New username: ");
                String newName = in.nextLine();
                System.out.print("New email: ");
                String newEmail = in.nextLine();
                System.out.print("New phone: ");
                String newPhone = in.nextLine();
                System.out.print("New password: ");
                String newPw = in.nextLine();
                db.updateUser(ID, newName, newEmail, newPhone, newPw);
                System.out.println("User successfully updated.");
            } else {
                System.out.println("User does not exist within the database.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testDelete() {
        System.out.print("Please enter the user to delete:");
        testShowAll();
        System.out.println("User ID: ");
        int ID = Integer.parseInt(in.nextLine());
        System.out.println("Email: ");
        String email = in.nextLine();

        try {
            if (db.findUser(ID, email) != null) {
                db.deleteUser(ID);
                System.out.println("User successfully deleted.");
            } else {
                System.out.println("User does not exist within the database.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void testShowAll() {
        try {
            ArrayList<User> users = db.fetchUsers();
            System.out.println("USERS TABLE:");
            users.stream().forEach((user) -> {
                System.out.printf("%-10s %-20s %-30s %-20s %-10s \n", user.getID(), user.getName(), user.getEmail(), user.getPassword(), user.getPhone());
            });
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
