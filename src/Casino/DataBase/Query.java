/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casino.DataBase;

import Casino.DataBase.JDBCConnection;
import Casino.DataBase.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Andrei Oleniuc
 */
public class Query {

    //Connects jdbc with query
    private JDBCConnection jdbc = JDBCConnection.getInstance();

    private ArrayList<User> users = new ArrayList<>();

    public void updateUser() throws SQLException, ClassNotFoundException {
        int id = 0;
        String name = "";
        String email = "";
        String password = "";
        int credits = 0;

        Connection conn = jdbc.createConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from users ");

        //while theres a new set with id, name, email and password it will be set into the variable
        while (rs.next()) {
            id = rs.getInt(1);
            name = rs.getString(2);
            email = rs.getString(3);
            password = rs.getString(4);
            credits = rs.getInt(5);

            users.add(new User(id, name, email, password, credits, "normal"));

        }

    }

    public void selectUsers() throws SQLException, ClassNotFoundException {

        Connection con = jdbc.createConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select * from users");
        while (rs.next()) {
            for (int i = 1; i < 6; i++) {
                System.out.println("| " + rs.getString(i));

            }
            System.out.println("|");
        }
    }

    public void insertUsers(int id, String name, String email, String password, int credit, String role) throws SQLException, ClassNotFoundException {
        Connection con = jdbc.createConnection();
        Statement st = con.createStatement();
        String insert = "Insert into users values('" + id + "','" + name + "','" + email + "','" + password + "','" + credit + "','" + role + "')";

        st.executeUpdate(insert);

        users.add(new User(id, name, email, password, credit, role));

    }

    public void insertStatistic() {

    }

    public void updateCredit(int credit, String name) throws SQLException, ClassNotFoundException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                users.get(i).setCredit(credit);
            } else {

            }
            System.out.println("Kontostand: " + users.get(i).getCredit());
            System.out.println("Done");
        }
        Connection con = jdbc.createConnection();
        Statement st = con.createStatement();
        String addCredit = "update users set credits = " + credit + " where name ='" + name + "'";

        st.execute(addCredit);
    }

    public int getCreditUser(String name) throws SQLException, ClassNotFoundException {
        int credits = 0;

        Connection conn = jdbc.createConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from users  where name = '" + name + "'");

        while (rs.next()) {
            credits = rs.getInt(5);
        }
        return credits;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

}
