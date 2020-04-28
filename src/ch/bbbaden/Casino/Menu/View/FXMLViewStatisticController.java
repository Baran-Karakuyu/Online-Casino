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
    private final ArrayList<String> userRecords = new ArrayList<>();
    private final ArrayList<String> gameRecords = new ArrayList<>();

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

        for (User user : allUser) {
            cbPlayers.getItems().add(user.getName());
            try {
                userRecords.addAll(user.getUserStats(user.getName()));
            } catch (SQLException ex) {
                Logger.getLogger(FXMLViewStatisticController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FXMLViewStatisticController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for (User user : allUser) {
            
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
    private void PlayerComboboxActionHandling(ActionEvent event) {
        for (int i = 0; i < allUser.size(); i++) {
            for (String userRecord : userRecords) {
                System.out.println(userRecord);
                if (cbPlayers.getSelectionModel().getSelectedItem().equals(allUser.get(i).getName())) {
                    lvPlayers.getItems().add(userRecord);
                }
            }
        }
    }

    @FXML
    private void GameComboboxActionHandling(ActionEvent event) {
        for (int i = 0; i < allUser.size(); i++) {
            for (String gameRecord : gameRecords) {
                if (sql.getGameStatistics(cbGames.getSelectionModel().getSelectedItem()))) {
                    lvGames.getItems().add(userRecord);
                }
            }
        }
    }
}
