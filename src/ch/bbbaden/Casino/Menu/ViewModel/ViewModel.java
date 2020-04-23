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

    private Model m;
    private StringProperty name = new SimpleStringProperty();

    public ViewModel(Model m) {
        this.m = m;
    }

    public void startSlots() throws IOException {
        m.startSlots();
    }

    public void startBlackJack() throws IOException, SQLException, ClassNotFoundException {
        m.startBlackJack();
    }

    public void startRoulette() throws IOException {
        m.startRoulette();
    }

    public void startYatzy() throws IOException {
        m.startYatzy();
    }

    public void startBingo() throws IOException, SQLException, ClassNotFoundException {
        m.startBingo();
    }

    public StringProperty getName() {
        return name;
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        switch (pce.getPropertyName()) {
            case "name":
                name.set(pce.getNewValue().toString());
                break;
        }
    }
}
