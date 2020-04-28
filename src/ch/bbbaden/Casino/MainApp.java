/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino;

import Casino.DataBase.User;
import ch.bbbaden.Casino.Games.Bingo.SpielkarteAuswahlController;
import ch.bbbaden.Casino.Games.Bingo.SpielkarteAuswahlViewModel;
import ch.bbbaden.Casino.Games.Bingo.UebersichtsSeiteController;
import ch.bbbaden.Casino.Games.Bingo.UebersichtsSeiteModel;
import ch.bbbaden.Casino.Games.Bingo.UebersichtsSeiteViewModel;
import ch.bbbaden.Casino.Games.Blackjack.ModelBlackJack;
import ch.bbbaden.Casino.Games.Blackjack.ViewGameController;
import ch.bbbaden.Casino.Games.Blackjack.ViewModelBlackJack;
import ch.bbbaden.Casino.Games.Roulette.ControllerRoulette;
import ch.bbbaden.Casino.Games.Slots.FXMLSlotsController;
import ch.bbbaden.Casino.Games.Slots.SlotMachineModel;
import ch.bbbaden.Casino.Games.Slots.SlotMachineViewModel;
import ch.bbbaden.Casino.Games.Yatzy.FXMLStartscreenController;
import ch.bbbaden.Casino.Login.LoginViewController;
import ch.bbbaden.Casino.Login.RegisterViewController;
import ch.bbbaden.Casino.Menu.Model.Model;
import ch.bbbaden.Casino.Menu.Model.ModelBuyCredits;
import ch.bbbaden.Casino.Menu.Model.ModelStatistic;
import ch.bbbaden.Casino.Menu.View.FXMLDocumentController;
import ch.bbbaden.Casino.Menu.View.FXMLViewBuyCreditsController;
import ch.bbbaden.Casino.Menu.View.FXMLViewStatisticController;
import ch.bbbaden.Casino.Menu.ViewModel.ViewModel;
import ch.bbbaden.Casino.Menu.ViewModel.ViewModelBuyCredits;
import ch.bbbaden.Casino.Menu.ViewModel.ViewModelStatistic;
import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Baran
 */
public class MainApp extends Application {

    private Stage stage;
//    private String email;
//    private String password;
//    private String name;
    private FXMLDocumentController viewMenu;
    private User user;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login/LoginView.fxml"));
        Parent root;
        root = loader.load();
        LoginViewController view = loader.getController();

        this.stage = stage;
        view.setMainApp(this);
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

    public void startMenu() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu/View/FXMLDocument.fxml"));
        Parent root;
        root = loader.load();

        viewMenu = loader.getController();
        Model model = new Model();
        model.setMainApp(this);
        final ViewModel viewModel = new ViewModel(model);
        viewMenu.setViewModel(viewModel);
        model.addPropertyChangeListener(viewModel);
        model.setUser(user);
        viewMenu.bind();
        viewMenu.unlockStatistic();
        model.setNewCredit();

        final Scene scene = new Scene(root);
        stage.setTitle("Menü");
        stage.setScene(scene);
        stage.show();
    }

    public void startSlots() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Games/Slots/FXMLDocument.fxml"));
        Parent root;
        root = loader.load();

        FXMLSlotsController view = loader.getController();
        view.setMainApp(this);
        SlotMachineModel model = new SlotMachineModel();
        model.setUser(user);
        final SlotMachineViewModel viewModel = new SlotMachineViewModel(model);
        view.setViewModel(viewModel);
        model.addPropertyChangeListener(viewModel);
        view.bind();

        final Scene scene = new Scene(root);

        stage.setTitle("Super Cherry");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void startBlackjack() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Games/Blackjack/ViewGame.fxml"));
        Parent root;
        root = loader.load();

        ViewGameController view = loader.getController();
        ModelBlackJack model = new ModelBlackJack();
        model.setMainApp(this);
        final ViewModelBlackJack viewModel = new ViewModelBlackJack(model);
        view.setViewModel(viewModel);
        model.addPropertyChangeListener(viewModel);
        model.setUser(user);

        view.bind();

        final Scene scene = new Scene(root);

        stage.setMaximized(true);
        stage.setTitle("BlackJack");
        stage.setScene(scene);
        stage.show();
    }

    public void startYatzy() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Games/Yatzy/FXMLStartscreen.fxml"));
        Parent root;
        root = loader.load();

        FXMLStartscreenController view = loader.getController();

        //view.setMainApp(this);
        final Scene scene = new Scene(root);

        stage.setTitle("Yatzy");
        stage.setScene(scene);
        stage.show();
    }

    public void startBingo() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Games/Bingo/UebersichtsSeite.fxml"));
        Parent root;
        root = loader.load();

        UebersichtsSeiteController view = loader.getController();
        view.setMainApp(this);
        UebersichtsSeiteModel model = new UebersichtsSeiteModel();
        model.setUser(user);
        model.setStage(stage);
        final UebersichtsSeiteViewModel viewModel = new UebersichtsSeiteViewModel(model);
        view.setUebersichtsSeiteViewModel(viewModel);
        model.addPropertyChangeListner(viewModel);
        view.bind();

        final Scene scene = new Scene(root);

        stage.setTitle("Bingo");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void startRoulette()throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader=  new FXMLLoader(getClass().getResource("Games/Roulette/Scene.fxml"));
        Parent root;
        root= loader.load();
        
        ControllerRoulette view= loader.getController();
        view.setUser(user);
        view.setMainApp(this);
        
        final Scene scene= new Scene(root);
        
        stage.setTitle("Roulette");
        stage.setScene(scene);
        stage.show();
    }

//    public void openNextBingo() throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SpielKarteAuswahl.fxml"));
//        Parent root;
//        root = loader.load();
//        SpielkarteAuswahlController view = loader.getController();
//        this.model = new SpielkarteAuswahlModel(this);
//        SpielkarteAuswahlViewModel viewModel = new SpielkarteAuswahlViewModel(model, this);
//        view.setViewModel(viewModel);
//        model.addPropertyChangeListner(viewModel);
//        view.bind();
//        Scene scene = new Scene(root);
//        stage.resizableProperty().setValue(Boolean.FALSE);
//        scene.getStylesheets().add("/styles/Bingo.css");
//        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
//        stage.show();
//    }

    public void openBuyCredits() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu/View/FXMLViewBuyCredits.fxml"));
        Parent root;
        root = loader.load();

        FXMLViewBuyCreditsController view = loader.getController();
        ModelBuyCredits model = new ModelBuyCredits();
        model.setViewMenu(viewMenu);
        model.setMainApp(this);
        final ViewModelBuyCredits viewModel = new ViewModelBuyCredits(model);
        view.setVm(viewModel);

        final Scene scene = new Scene(root);
        stage.setTitle("Guthaben kaufen");
        stage.setScene(scene);
        stage.show();
    }

    public void registerStart() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login/RegisterView.fxml"));
        Parent root;
        root = loader.load();
        RegisterViewController view = loader.getController();

        view.setMainApp(this);
        final Scene scene = new Scene(root);

        stage.setTitle("Registrieren");
        stage.setScene(scene);
        stage.show();
    }

    public void startLogin() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login/LoginView.fxml"));
        Parent root;
        root = loader.load();
        LoginViewController view = loader.getController();

        view.setMainApp(this);
        final Scene scene = new Scene(root);

        stage.setTitle("Anmelden");
        stage.setScene(scene);
        stage.show();
    }

    public void openStatistics() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu/View/FXMLViewStatistic.fxml"));
        Parent root;
        root = loader.load();

        FXMLViewStatisticController view = loader.getController();
        ModelStatistic model = new ModelStatistic();
        model.setMainApp(this);
        final ViewModelStatistic viewModel = new ViewModelStatistic(model);
        view.setViewModel(viewModel);

        final Scene scene = new Scene(root);
        stage.setTitle("Statistik");
        stage.setScene(scene);
        stage.show();
    }

    public void setUser(User u) {
        this.user = u;
    }

    public User getUser() {
        return user;
    }
}
