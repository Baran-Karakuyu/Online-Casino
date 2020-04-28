/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Bingo;

//import ch.bbbaden.ims.programmierwochen.bingo.MainApp;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Emirh
 */
public class UebersichtsSeiteModel {

    MainApp mainApp;

    PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public UebersichtsSeiteModel(MainApp mainApp) {
        this.mainApp = mainApp;

    }

    public void showSpielkarteAuswahl() {

        mainApp.showSpielkarteAuswahl();
    }

    public void addPropertyChangeListner(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }
}
