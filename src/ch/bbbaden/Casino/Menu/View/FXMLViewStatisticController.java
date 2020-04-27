/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Menu.View;

import ch.bbbaden.Casino.Menu.ViewModel.ViewModelStatistic;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
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

    private ViewModelStatistic viewModel;
    
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
}
