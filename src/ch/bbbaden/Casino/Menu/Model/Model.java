/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Menu.Model;

import ch.bbbaden.Casino.MainApp;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Baran
 */
public class Model {

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

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void setUser(String email,String password){
        
    }
}
