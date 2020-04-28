/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Menu.ViewModel;

import ch.bbbaden.Casino.Menu.Model.Model;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Baran
 */
public class ViewModel implements PropertyChangeListener {

    private final Model m;
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty credit = new SimpleStringProperty();
    private final StringProperty role = new SimpleStringProperty();
    
    public ViewModel(Model m) {
        this.m = m;
    }

    public void startSlots() throws IOException {
        m.startSlots();
    }

    public void startBlackJack() throws IOException, SQLException, ClassNotFoundException {
        m.startBlackJack();
    }

    public void startRoulette() throws IOException, SQLException, ClassNotFoundException {
        m.startRoulette();
    }

    public void startYatzy() throws IOException, SQLException, ClassNotFoundException {
        m.startYatzy();
    }

    public void startBingo() throws IOException, SQLException, ClassNotFoundException {
        m.startBingo();
    }
    
    public void openBuyCredits() throws IOException, SQLException, ClassNotFoundException {
        m.openBuyCredits();
    }
    
    public void startLogin() throws IOException, SQLException, ClassNotFoundException {
        m.startLogin();
    }
    
    public void openStatistics() throws IOException, SQLException, ClassNotFoundException {
        m.openStatistics();
    }

    public StringProperty getCredit() {
        return credit;
    }

    public StringProperty getName() {
        return name;
    }
    
    public StringProperty getRole() {
        return role;
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        switch (pce.getPropertyName()) {
            case "name":
                name.set(pce.getNewValue().toString());
                break;
            case "credit":
                credit.set(pce.getNewValue().toString());
                break;
            case "role":
                role.set(pce.getNewValue().toString());
                break;
        }
    }
}
