/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Menu.ViewModel;

import ch.bbbaden.Casino.Menu.Model.ModelStatistic;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Andrei Oleniuc und Rojda-Baran Karakuyu
 */
public class ViewModelStatistic {
    private ModelStatistic m;

    public ViewModelStatistic(ModelStatistic m) {
        this.m = m;
    }
    
    public void openMenu() throws IOException, SQLException, ClassNotFoundException {
        m.openMenu();
    }
}
