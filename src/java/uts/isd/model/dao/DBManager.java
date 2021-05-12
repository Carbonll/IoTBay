/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import uts.isd.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author melvi
 */
public class DBManager {

    private Statement st;

    public DBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    //USER DAO METHODS
    public User authenticateUser(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"USER\" WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String userEmail = rs.getString(3);
            String userPw = rs.getString(5);
            if (userEmail.equalsIgnoreCase(email) && userPw.equals(password)) {
                return new User(rs);
            }
        }
        return null;
    }

    public void addUser(String name, String email, String phone, String password, int roleID) throws SQLException {
        st.executeUpdate("INSERT INTO IOTUSER.\"USER\"(\"NAME\", EMAIL, PHONE, PASSWORD, ROLE_ID)" + "VALUES ('" + name + "', '" + email + "', '" + phone + "', '" + password + "', " + roleID + ")");
    }

    public void updateName(int ID, String name) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.\"USER\" SET \"NAME\" = '" + name + "' WHERE ID = " + ID);
        System.out.println("Updated " + name + " of ID " + ID);
    }

    public void updateEmail(int ID, String email) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.\"USER\" SET EMAIL = '" + email + "' WHERE ID = " + ID);
    }

    public void updatePhone(int ID, String phone) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.\"USER\" SET PHONE = '" + phone + "' WHERE ID = " + ID);
    }

    public void updatePassword(int ID, String password) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.\"USER\" SET PASSWORD = '" + password + "' WHERE ID = " + ID);
    }

    public void deleteUser(int ID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.\"USER\" WHERE ID = " + ID);
    }

    public User findUserByID(int ID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"USER\" WHERE ID = " + ID;
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int userID = rs.getInt(1);
            if (userID == ID) {
                return new User(rs);
            }
        }
        return null;
    }

    public User findUserByEmail(String email) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"USER\" WHERE EMAIL = '" + email + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String userEmail = rs.getString(3);
            if (userEmail.equals(email)) {
                return new User(rs);
            }
        }
        return null;
    }
    
    public User findUserByName(String name) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"USER\" WHERE NAME = '" + name + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String userName = rs.getString(2);
            if (userName.equals(name)) {
                return new User(rs);
            }
        }
        return null;
    }

    public ArrayList<User> fetchUsers() throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"USER\"";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> result = new ArrayList();

        while (rs.next()) {
            result.add(new User(rs));
        }
        return result;
    }

    //AUDIT LOG DAO METHODS
    public void addAudit(int userID, String event, Date date) throws SQLException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String strDate = dateFormat.format(date);
        st.executeUpdate("INSERT INTO IOTUSER.AUDITS (USER_ID, AUDIT_EVENT, AUDIT_DATE)" + "VALUES (" + userID + ", '" + event + "', '" + strDate + "')");
    }
    
    public ArrayList<Audit> fetchAudits() throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.AUDITS";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Audit> result = new ArrayList();
        
        while (rs.next()) {
            result.add(new Audit(rs));
        }
        return result;
    }
    
    public ArrayList<Audit> fetchAuditsByUserID(int userID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.AUDITS WHERE USER_ID = " + userID;
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Audit> result = new ArrayList();
        
        while (rs.next()) {
            result.add(new Audit(rs));
        }
        return result;
    }
    
    public ArrayList<Audit> fetchAuditsByDate(int userID, String date) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.AUDITS WHERE USER_ID = " + userID + " AND AUDIT_DATE LIKE '%" + date + "%'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Audit> result = new ArrayList();
        
        while (rs.next()) {
            result.add(new Audit(rs));
        }
        return result;
    }
    
    public void deleteAudit(int ID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.AUDITS WHERE USER_ID = " + ID);
    }
    
    //PAYMENT DAO METHODS
    
    public void addPaymentID(int userID) throws SQLException {
        st.executeUpdate("INSERT INTO IOTUSER.PAYMENT (USERID)" + "VALUES (" + userID + ")");
    }
        
    public Payment findPaymentDetailsByID(int userID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"PAYMENT\" WHERE USERID = " + userID;
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int paymentid = rs.getInt(9);
            if (paymentid == userID) {
                return new Payment(rs);
            }
        }
        return null;
    }
    
    public void addPayment(String cardname, String cardno, String cardexp, String cardcvv) throws SQLException {
        st.executeUpdate("INSERT INTO IOTUSER.\"PAYMENT\"(\"CARD_NAME\", CARD_NO, CARD_EXP, CARD_CVV)" + "VALUES ('" + cardname + "', '" + cardno + "', '" + cardexp + "', '" + cardcvv + ")");
    }
    
    public void updateCardNo(int ID, String cardNo) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.\"PAYMENT\" SET CARD_NO = '" + cardNo + "' WHERE USERID = " + ID);
    }
    
    public void updateCardName(int ID, String cardName) throws SQLException {  
        st.executeUpdate("UPDATE IOTUSER.\"PAYMENT\" SET CARD_NAME = '" + cardName + "' WHERE USERID = " + ID);
    }
    
    public void updateCardExp(int ID, String cardExp) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.\"PAYMENT\" SET CARD_EXP = '" + cardExp + "' WHERE USERID = " + ID);
    }
    
    public void updateCardCvv(int ID, String cardCvv) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.\"PAYMENT\" SET CARD_CVV = '" + cardCvv + "' WHERE USERID = " + ID);
    }
    
    public void updatePaymentMethod(int ID, String paymentMethod) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.\"PAYMENT\" SET PAYMENT_METHOD = '" + paymentMethod + "' WHERE USERID = " + ID);
    }   
    
    //PAYMENT HISTORY DAO METHODS
    public ArrayList<PaymentHistory> fetchPaymentHistoryByUserID(int userID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.PAYMENTHISTORY WHERE USER_ID = " + userID;
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<PaymentHistory> result = new ArrayList();
        
        while (rs.next()) {
            result.add(new PaymentHistory(rs));
        }
        return result;
    }
    
    public ArrayList<PaymentHistory> fetchPaymentHistoryByDateAndPaymentID(int userID, String date, int paymentID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.PAYMENTHISTORY WHERE USER_ID = " + userID + " AND PAYMENT_DATE LIKE '%" + date + "%'" + " AND ID = " + paymentID + "";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<PaymentHistory> result = new ArrayList();
        
        while (rs.next()) {
            result.add(new PaymentHistory(rs));
        }
        return result;
    }
    
    public void addPaymentHistory(int userID, int orderID, Date date) throws SQLException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String strDate = dateFormat.format(date);
        st.executeUpdate("INSERT INTO IOTUSER.PAYMENTHISTORY (USER_ID, ORDER_ID, PAYMENT_DATE)" + "VALUES (" + userID + ", '" + orderID + "', '" + strDate + "')");
    }
    
    public void deletePayment(int ID) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.\"PAYMENT\" SET PAYMENT_METHOD = NULL, CARD_NO = NULL, CARD_EXP = NULL, CARD_CVV = NULL, CARD_NAME = NULL WHERE USERID = " + ID);
    }
}
