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
 *@author Andrei Oleniuc und Rojda-Baran Karakuyu
 */
public class ModelStatistic {
    private MainApp mainApp;
    
    public void openMenu() throws IOException, SQLException, ClassNotFoundException {
        mainApp.startMenu();
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
