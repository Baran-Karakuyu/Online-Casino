/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casino.DataBase;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andrei Oleniuc
 */
public class User {
    private int uid;
    private String name;
    private String email;
    private String password;
    private double credit;
    private String role;
    private final Query sql = new Query();

    public User(int uid, String name, String email, String password, int credit, String role) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.credit = credit;
        this.role = role;
    }

    public String getRole() {
        return role;
    }
    
    public int getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) throws SQLException, ClassNotFoundException {
        this.credit = credit;
        sql.updateCredit(credit, name);
    }

    public void setUid(int uid) {
        this.uid = uid;
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
    
    public void userStats(int gid, int usid, double bet, double win, double lost) throws SQLException, ClassNotFoundException {
        sql.insertStatistic(gid, usid, bet, win, lost);
    }
    
    public ArrayList<String> getUserStats(String name) throws SQLException, ClassNotFoundException {
        return sql.getUserStatistics(name);
    }
}
