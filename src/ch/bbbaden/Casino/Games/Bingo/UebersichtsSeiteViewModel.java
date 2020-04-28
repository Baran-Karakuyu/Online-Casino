/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.ims.programmierwochen.bingo.ViewModel;

import ch.bbbaden.Casino.Games.UebersichtsSeiteModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

/**
 *
 * @author Emirh
 */
public class UebersichtsSeiteViewModel implements PropertyChangeListener {

    private UebersichtsSeiteModel uebersichtsSeiteModel;

    public UebersichtsSeiteViewModel(UebersichtsSeiteModel uebersichtsSeiteModel) {
        this.uebersichtsSeiteModel = uebersichtsSeiteModel;
    }

   

    public void showSpielkarteAuswahl() throws IOException {

        uebersichtsSeiteModel.showSpielkarteAuswahl();

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

}
