/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casino.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author Andrei Oleniuc
 */
public class Query {

    //Connects jdbc with query
    private final JDBCConnection jdbc = JDBCConnection.getInstance();
    private final ArrayList<User> users = new ArrayList<>();

    public void updateUser() throws SQLException, ClassNotFoundException {
        users.clear();
        int id;
        String name;
        String email;
        String password;
        int credits;
        String role;

        Connection conn = jdbc.createConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from users;");

        //while theres a new set with id, name, email and password it will be set into the variable
        while (rs.next()) {
            id = rs.getInt(1);
            name = rs.getString(2);
            email = rs.getString(3);
            password = rs.getString(4);
            credits = rs.getInt(5);
            role = rs.getString(6);

            users.add(new User(id, name, email, password, credits, role));
        }

        conn.close();
        jdbc.closeConnection();
    }

    public void selectUsers() throws SQLException, ClassNotFoundException {
        Connection conn = jdbc.createConnection();
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("Select * from users;");
        while (rs.next()) {
            for (int i = 1; i < 7; i++) {
                System.out.println("| " + rs.getString(i));

            }
            System.out.println("|");
        }

        conn.close();
        jdbc.closeConnection();
    }

    public void insertUsers(int id, String name, String email, String password, int credit) throws SQLException, ClassNotFoundException {
        String queryCreateUser = "Insert into users (name, email, password, credits, role) values (?,?,?,?,'normal');";
        Connection conn = jdbc.createConnection();
        PreparedStatement ps = conn.prepareStatement(queryCreateUser);

        password = BCrypt.hashpw(password, BCrypt.gensalt());

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, password);
        ps.setInt(4, credit);
        ps.execute();
        ps.close();

        conn.close();
        jdbc.closeConnection();

        users.add(new User(id, name, email, password, credit, "normal"));
    }

    public void insertStatistic(int gid, int usid, double bet, double win, double lost) throws SQLException, ClassNotFoundException {
        String queryStatistic = "Insert into statistic (gid, usid, bet, win, lost) values (?,?,?,?,?)";
        Connection conn = jdbc.createConnection();
        PreparedStatement ps = conn.prepareStatement(queryStatistic);

        ps.setInt(1, gid);
        ps.setInt(2, usid);
        ps.setDouble(3, bet);
        ps.setDouble(4, win);
        ps.setDouble(5, lost);
        ps.execute();
        ps.close();

        conn.close();
        jdbc.closeConnection();
    }

    public ArrayList<String> getUserStatistics(String name) throws ClassNotFoundException, SQLException {
        ArrayList<String> output = new ArrayList<>();
        String queryStatistic = String.format("Select games.name, statistic.bet, statistic.win, statistic.lost from statistic, games, users where users.name = '%s' && users.usid = statistic.usid && games.gid = statistic.gid;", name);

        Connection conn = jdbc.createConnection();
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(queryStatistic);

        int columns = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            String input = "";
            for (int i = 1; i < columns + 1; i++) {
                input += String.format("%-15s", rs.getString(i));
            }
            output.add(input);
        }

        rs.close();
        st.close();
        conn.close();
        jdbc.closeConnection();

        return output;
    }

    public void updateCredit(double credit, String name) throws SQLException, ClassNotFoundException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                users.get(i).setCredit(credit);
            } else {

            }
            System.out.println("Kontostand: " + users.get(i).getCredit());
            System.out.println("Done");
        }
        Connection conn = jdbc.createConnection();
        Statement st = conn.createStatement();

        String addCredit = "update users set credits = " + credit + " where name ='" + name + "';";

        st.execute(addCredit);

        conn.close();
        jdbc.closeConnection();
    }

    public double getCreditUser(String name) throws SQLException, ClassNotFoundException {
        int credits = 0;

        Connection conn = jdbc.createConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from users  where name = '" + name + "';");

        while (rs.next()) {
            credits = rs.getInt(5);
        }

        conn.close();
        jdbc.closeConnection();

        return credits;
    }

    public int getUserId(String name) throws SQLException, ClassNotFoundException {
        Connection conn = jdbc.createConnection();
        Statement st = conn.createStatement();
        int id = 0;

        ResultSet rs = st.executeQuery("Select * from users where name = '" + name + "';");
        System.out.println(rs.getInt(0));
        System.out.println(rs.getInt(1));
        id = rs.getInt(1);

        conn.close();
        jdbc.closeConnection();

        return id;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<String> getGameStatistics(String game) throws SQLException, ClassNotFoundException {
        ArrayList<String> output = new ArrayList<>();
        String queryStatistic = String.format("Select users.name, games.name, statistic.bet, statistic.win, lost from statistic, games, users where games.name = '%s' && games.gid = statistic.gid && users.usid = statistic.usid;", game);

        Connection conn = jdbc.createConnection();
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(queryStatistic);
        int c = 0;

        int columns = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            String input = "";
            for (int i = 1; i < columns + 1; i++) {
                input += String.format("%-15s", rs.getString(i));
            }
            output.add(input);
        }

        System.out.println(output);
        rs.close();
        st.close();
        conn.close();
        jdbc.closeConnection();

        return output;
    }
}
