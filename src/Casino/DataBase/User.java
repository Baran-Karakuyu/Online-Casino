/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casino.DataBase;

/**
 *
 * @author Andrei Oleniuc
 */
public class User {
    private int uid;
    private String name;
    private String email;
    private String password;
    private int credit;
    private String role;

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

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
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
    
    
}
