/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.CasinoMenü.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import javafx.stage.Stage;

/**
 *
 * @author Baran
 */
public class Model {
    private Stage stage;
    protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public void startSlots() throws IOException {

    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }
}
