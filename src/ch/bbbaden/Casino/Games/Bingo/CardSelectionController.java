/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Bingo;

import Casino.DataBase.User;
import ch.bbbaden.Casino.MainApp;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Emirhan Karaca
 */
public class CardSelectionController implements Initializable {

    private CardSelectionViewModel viewModel;
    private MainApp mainApp;
    private User user;

    
    @FXML
    private Label imgLeave;
    @FXML
    private Label lblKosten;

    //Cards
    @FXML
    private Button btnCross1;
    @FXML
    private Button btnCross6;
    @FXML
    private Button btnCross11;
    @FXML
    private Button btnCross16;
    @FXML
    private Button btnCross21;
    @FXML
    private Button btnCross2;
    @FXML
    private Button btnCross7;
    @FXML
    private Button btnCross12;
    @FXML
    private Button btnCross17;
    @FXML
    private Button btnCross22;
    @FXML
    private Button btnCross3;
    @FXML
    private Button btnCross8;
    @FXML
    private Button btnCross13;
    @FXML
    private Button btnCross18;
    @FXML
    private Button btnCross23;
    @FXML
    private Button btnCross4;
    @FXML
    private Button btnCross9;
    @FXML
    private Button btnCross14;
    @FXML
    private Button btnCross19;
    @FXML
    private Button btnCross24;
    @FXML
    private Button btnCross5;
    @FXML
    private Button btnCross10;
    @FXML
    private Button btnCross15;
    @FXML
    private Button btnCross20;
    @FXML
    private Button btnCross25;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    //binding the cards
    public void bind() {
        btnCross1.textProperty().bind(viewModel.getStr1());
        btnCross2.textProperty().bind(viewModel.getStr2());
        btnCross3.textProperty().bind(viewModel.getStr3());
        btnCross4.textProperty().bind(viewModel.getStr4());
        btnCross5.textProperty().bind(viewModel.getStr5());
        btnCross6.textProperty().bind(viewModel.getStr6());
        btnCross7.textProperty().bind(viewModel.getStr7());
        btnCross8.textProperty().bind(viewModel.getStr8());
        btnCross9.textProperty().bind(viewModel.getStr9());
        btnCross10.textProperty().bind(viewModel.getStr10());
        btnCross11.textProperty().bind(viewModel.getStr11());
        btnCross12.textProperty().bind(viewModel.getStr12());
        btnCross13.textProperty().bind(viewModel.getStr13());
        btnCross14.textProperty().bind(viewModel.getStr14());
        btnCross15.textProperty().bind(viewModel.getStr15());
        btnCross16.textProperty().bind(viewModel.getStr16());
        btnCross17.textProperty().bind(viewModel.getStr17());
        btnCross18.textProperty().bind(viewModel.getStr18());
        btnCross19.textProperty().bind(viewModel.getStr19());
        btnCross20.textProperty().bind(viewModel.getStr20());
        btnCross21.textProperty().bind(viewModel.getStr21());
        btnCross22.textProperty().bind(viewModel.getStr22());
        btnCross23.textProperty().bind(viewModel.getStr23());
        btnCross24.textProperty().bind(viewModel.getStr24());
        btnCross25.textProperty().bind(viewModel.getStr25());

    }

    //by pressing the "Andere Spielkarte" button, it invokes the method from the CardSelectionModel
    @FXML
    private void ActionOtherCard(ActionEvent event) {

        viewModel.ActionOtherCards();
    }

    //by pressing the "Weiter" button, it invokes the method from the CardSelectionModel
    @FXML
    private void ActionShowBingo(ActionEvent event) throws IOException {
        viewModel.showBingo(user);
    }

    public void setCardSelectionViewModel(CardSelectionViewModel viewModel) {
        this.viewModel = viewModel;
    }

    //Closes the current scene and opens up the menu of the casino
    @FXML
    private void ActionLeave(MouseEvent event) throws IOException, ClassNotFoundException, SQLException {

        Stage stage = (Stage) imgLeave.getScene().getWindow();
        stage.close();

        mainApp.startMenu();

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }

    public void setUser(User user) {
        this.user = user;
    }

}
