/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.CasinoMenü;

import ch.bbbaden.CasinoMenü.Model.Model;
import ch.bbbaden.CasinoMenü.View.FXMLMenüController;
import ch.bbbaden.CasinoMenü.ViewModel.ViewModel;
import java.beans.PropertyChangeListener;
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/FXMLMenü.fxml"));
        Parent root;
        root = loader.load();
        FXMLMenüController view = loader.getController();
        Model model = new Model();
        final ViewModel viewModel = new ViewModel(model);
        view.setViewModel(viewModel);
        model.addPropertyChangeListener(viewModel);
        view.bind();

        final Scene scene = new Scene(root);
        
        stage.setTitle("Super Cherry");
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
