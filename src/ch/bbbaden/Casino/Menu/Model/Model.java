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

/**
 *
 * @author Baran
 */
public class Model {
    String name="";
    int credit=0;
    protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private Query sql = new Query();
    ArrayList<User> benutzer = new ArrayList<>();

    private MainApp mainApp;

    public void startSlots() throws IOException {
        mainApp.startSlots();
    }

    public void startBlackJack() throws IOException, SQLException, ClassNotFoundException {
        mainApp.setName(name);
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

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setUser(String email, String password) throws SQLException, ClassNotFoundException {
        sql.updateUser();
        String oldName = name;

        for (int i = 0; i < sql.getUsers().size(); i++) {
            benutzer.add(sql.getUsers().get(i));
        }
        for (int i = 0; i < sql.getUsers().size(); i++) {
            if (sql.getUsers().get(i).getEmail().equals(email)) {
                if (sql.getUsers().get(i).getPassword().equals(password)) {
                    name =sql.getUsers().get(i).getName();
                    credit= sql.getCreditUser(name);
                    System.out.println(name);
                } else {

                }
               
            }
        }
        changes.firePropertyChange("name", oldName, name);
        changes.firePropertyChange("credit", oldName, credit);
    }

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);

    }
}
