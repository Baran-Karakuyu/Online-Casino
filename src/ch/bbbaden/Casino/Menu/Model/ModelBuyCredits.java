/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Menu.Model;

import Casino.DataBase.Query;
import ch.bbbaden.Casino.MainApp;
import ch.bbbaden.Casino.Menu.View.FXMLDocumentController;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Rojda-Baran Karakuyu
 */
public class ModelBuyCredits {

    private final Query sql = new Query();
    private FXMLDocumentController viewMenu;
    private MainApp mainApp;
    
    public void buyCredits(int amount) throws SQLException, ClassNotFoundException, IOException {
        int currentBalance = Integer.valueOf(viewMenu.getLblCredit().getText());
        sql.updateCredit(currentBalance + amount, mainApp.getUser().getName());
        mainApp.startMenu();
    }
    
    public void openMenu() throws IOException, SQLException, ClassNotFoundException {
        mainApp.startMenu();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setViewMenu(FXMLDocumentController viewMenu) {
        this.viewMenu = viewMenu;
    }
}
