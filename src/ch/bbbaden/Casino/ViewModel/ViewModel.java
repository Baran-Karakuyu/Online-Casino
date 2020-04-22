/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.ViewModel;

import ch.bbbaden.Casino.Model.Model;
import java.io.IOException;

/**
 *
 * @author Baran
 */
public class ViewModel {
    Model m;

    public ViewModel(Model m) {
        this.m = m;
    }
    
    public void startSlots() throws IOException {
        m.startSlots();
    }
}
