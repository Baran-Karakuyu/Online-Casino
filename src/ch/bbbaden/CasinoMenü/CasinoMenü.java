/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.CasinoMenü;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Baran
 */
public class CasinoMenü extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMenü.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void showSlots() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/FXMLDocument.fxml"));
        Parent root;
        root = loader.load();
        FXMLDocumentController view = loader.getController();
        SlotMachineModel model = new SlotMachineModel();
        final SlotMachineViewModel viewModel = new SlotMachineViewModel(model);
        view.setViewModel(viewModel);
        model.addPropertyChangeListener(viewModel);
        view.bind();

        final Scene scene = new Scene(root);
        
        stage.setTitle("Super Cherry");
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }
}
