/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Bingo;

import ch.bbbaden.Casino.MainApp;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

/**
 *
 * @author Emirhan Karaca
 */
public class OverviewPageViewModel implements PropertyChangeListener {

    private OverviewPageModel overviewPageModel;

    public OverviewPageViewModel(OverviewPageModel overviewPageModel) {
        this.overviewPageModel = overviewPageModel;
    }

    //invokes the method from the CardSelectionModel
    public void showCardSelection() throws IOException {
        overviewPageModel.showCardSelection();
    }

    public void setMainApp(MainApp mainApp) {
        overviewPageModel.setMainApp(mainApp);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}
