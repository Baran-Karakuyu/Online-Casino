/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Model;

import ch.bbbaden.Casino.Games.Slots.FXMLSlotsController;
import ch.bbbaden.Casino.Games.Slots.SlotMachineModel;
import ch.bbbaden.Casino.Games.Slots.SlotMachineViewModel;
import ch.bbbaden.Casino.MainApp;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Baran
 */
public class Model {

    private MainApp mainApp;

    public void startSlots() throws IOException {
        System.out.println("p");
        mainApp.startSlots();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
