/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Blackjack;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Andrei Oleniuc
 */
public class ViewModelBlackJack implements PropertyChangeListener{
    private final ModelBlackJack mo;

    public ViewModelBlackJack(ModelBlackJack mo) {
        this.mo = mo;
    }
    
    
    
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        
    }
    
}
