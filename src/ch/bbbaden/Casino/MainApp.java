/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino;

import ch.bbbaden.Casino.Games.Blackjack.ModelBlackJack;
import ch.bbbaden.Casino.Games.Blackjack.ViewGameController;
import ch.bbbaden.Casino.Games.Blackjack.ViewModelBlackJack;
import ch.bbbaden.Casino.Games.Slots.FXMLSlotsController;
import ch.bbbaden.Casino.Games.Slots.SlotMachineModel;
import ch.bbbaden.Casino.Games.Slots.SlotMachineViewModel;
import ch.bbbaden.Casino.Login.LoginViewController;
import ch.bbbaden.Casino.Menu.Model.Model;
import ch.bbbaden.Casino.Menu.View.FXMLDocumentController;
import ch.bbbaden.Casino.Menu.ViewModel.ViewModel;
import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Baran
 */
public class MainApp extends Application {

    Stage stage;
    String email;
    String password;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login/LoginView.fxml"));
        Parent root;
        root = loader.load();
        LoginViewController view = loader.getController();
        view.setMainApp(this);
        
        this.stage = stage;
        
        final Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void startMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu/View/FXMLDocument.fxml"));
        Parent root;
        root = loader.load();
        FXMLDocumentController view = loader.getController();
        Model model = new Model();
        model.setMainApp(this);
        model.setUser(email, password);
        final ViewModel viewModel = new ViewModel(model);
        view.setViewModel(viewModel);
        
        final Scene scene = new Scene(root);

        stage.setTitle("Menü");
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public void startSlots() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Games/Slots/FXMLDocument.fxml"));
        Parent root;
        root = loader.load();
        FXMLSlotsController view = loader.getController();
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

    public void startBlackjack() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Games/Blackjack/ViewGame.fxml"));
        Parent root;
        root = loader.load();

        ViewGameController view = loader.getController();
        ModelBlackJack model = new ModelBlackJack();
        final ViewModelBlackJack viewModel = new ViewModelBlackJack(model);
        view.setViewModel(viewModel);
        model.addPropertyChangeListener(viewModel);
        view.bind();

        final Scene scene = new Scene(root);

        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }
    
    public void userData(String email,String password){
        this.email= email;
        this.password= password;
        System.out.println(this.email);
        System.out.println(this.password);
    }
    
}
