/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Menu.Model;

import Casino.DataBase.Query;
import Casino.DataBase.User;
import ch.bbbaden.Casino.MainApp;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Baran
 */
public class Model {

    protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private User user;
    private final ArrayList<User> benutzer = new ArrayList<>();
    private final Query sql = new Query();

    private MainApp mainApp;

    public void startSlots() throws IOException {
        mainApp.startSlots();
    }

    public void startBlackJack() throws IOException, SQLException, ClassNotFoundException {
        mainApp.startBlackjack();
    }

    public void startRoulette() throws IOException {
        mainApp.startSlots();
    }

    public void startYatzy() throws IOException {
        mainApp.startSlots();
    }

    public void startBingo() throws IOException, SQLException, ClassNotFoundException {
        mainApp.startSlots();
    }

    public void openBuyCredits() throws IOException, SQLException, ClassNotFoundException {
        mainApp.openBuyCredits();
    }

    public void startLogin() throws IOException, SQLException, ClassNotFoundException {
        mainApp.start(new Stage());
        JOptionPane.showMessageDialog(null, "Erfolgreich abgemeldet.", "Abmeldung", JOptionPane.INFORMATION_MESSAGE);
    }

    public void openStatistics() throws IOException, SQLException, ClassNotFoundException {
        mainApp.openStatistics();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setUser(User user) throws SQLException, ClassNotFoundException {
        String name = "";
        int credit = 0;
        String role = "";

        sql.updateUser();
        this.user = user;
        
        int oldCredits = credit;
        String oldName = name;
        String oldRole = role;

        for (int i = 0;
                i < sql.getUsers()
                        .size(); i++) {
            benutzer.add(sql.getUsers().get(i));
        }

//        for (int i = 0; i < sql.getUsers().size(); i++) {
//            if (sql.getUsers().get(i).getEmail().equals(email)) {
//                if (sql.getUsers().get(i).getPassword().equals(password)) {
//                    name = sql.getUsers().get(i).getName();
//                    credit = sql.getCreditUser(name);
//                    System.out.println(name);
//                } else {
//
//                }
//            }
//        }
//        for (int i = 0; i < user.getUid; i++) {
//            if (user.getEmail().equals(email)) {
//                if (user.getPassword().equals(password)) {
        name = user.getName();
        credit = user.getCredit();
        role = user.getRole();

        System.out.println(name);
//                } else {
//
//                }
//            }
//        }

        changes.firePropertyChange("name", oldName, name);
        changes.firePropertyChange("credit", oldCredits, credit);
        changes.firePropertyChange("role", oldRole, role);
    }

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);

    }
}
