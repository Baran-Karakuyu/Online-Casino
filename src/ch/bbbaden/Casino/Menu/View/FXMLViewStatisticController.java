/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Menu.View;

import Casino.DataBase.Query;
import Casino.DataBase.User;
import ch.bbbaden.Casino.Menu.ViewModel.ViewModelStatistic;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javax.swing.text.View;

/**
 * FXML Controller class
 *
 * @author Baran
 */
public class FXMLViewStatisticController implements Initializable {

    @FXML
    private ComboBox<String> cbPlayers;
    @FXML
    private ListView<String> lvPlayers;
    @FXML
    private ListView<String> lvGames;
    @FXML
    private ComboBox<String> cbGames;
    @FXML
    private Button btnCancel;

    private Query sql = new Query();
    private ViewModelStatistic viewModel;
    private ArrayList<User> allUser = new ArrayList<>();
    private ArrayList<String> userRecords = new ArrayList<>();
    private ArrayList<String> gameRecords = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbGames.getItems().add("Slots");
        cbGames.getItems().add("Blackjack");
        cbGames.getItems().add("Roulette");
        cbGames.getItems().add("Bingo");
        cbGames.getItems().add("Yatzy");

        try {
            sql.updateUser();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLViewStatisticController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLViewStatisticController.class.getName()).log(Level.SEVERE, null, ex);
        }

        allUser = sql.getUsers();

        //adding all Users to combobox and getting all stats
        for (User user : allUser) {
            cbPlayers.getItems().add(user.getName());
        }
    }

    @FXML
    private void CancelButtonActionHandling(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();

        viewModel.openMenu();
    }

    public void setViewModel(ViewModelStatistic viewModel) {
        this.viewModel = viewModel;
    }

    @FXML
    private void PlayerComboboxActionHandling(ActionEvent event) throws ClassNotFoundException, SQLException {
        lvPlayers.getItems().clear();

        //creating topbar
        userRecords = sql.getUserStatistics(cbPlayers.getValue());
        String topList = String.format("%-18s", "Spiel");
        topList += String.format("%-18s", "Bet");
        topList += String.format("%-18s", "Win");
        topList += String.format("%-18s", "Lost");

        //adding topbar
        lvPlayers.getItems().add(topList);
        lvPlayers.getItems().addAll(userRecords);
    }

    @FXML
    private void GameComboboxActionHandling(ActionEvent event) throws ClassNotFoundException, SQLException {
        lvGames.getItems().clear();

        //creating topbar
        gameRecords = sql.getGameStatistics(cbGames.getValue());
        String topList = String.format("%-18s", "Spieler");
        topList += String.format("%-18s", "Spiel");
        topList += String.format("%-18s", "Bet");
        topList += String.format("%-18s", "Win");
        topList += String.format("%-18s", "Lost");

        //adding topbar
        lvGames.getItems().add(topList);
        lvGames.getItems().addAll(gameRecords);
    }
}
