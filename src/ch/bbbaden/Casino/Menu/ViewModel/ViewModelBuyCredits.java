/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Menu.ViewModel;

import ch.bbbaden.Casino.Menu.Model.ModelBuyCredits;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Baran
 */
public class ViewModelBuyCredits {

    private ModelBuyCredits m;

    public ViewModelBuyCredits(ModelBuyCredits m) {
        this.m = m;
    }

    public void buyCredits(int amount) throws SQLException, ClassNotFoundException, IOException {
        m.buyCredits(amount);
    }
    
    public void openMenu() throws SQLException, ClassNotFoundException, IOException {
        m.openMenu();
    }
}
