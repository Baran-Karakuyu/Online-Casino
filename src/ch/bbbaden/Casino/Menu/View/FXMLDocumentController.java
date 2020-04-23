/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Menu.View;

import ch.bbbaden.Casino.Menu.ViewModel.ViewModel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Baran
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnBuyCredits;
    @FXML
    private ImageView btnYatzy;
    @FXML
    private ImageView btnBlackJack;

    private ViewModel viewModel;
    @FXML
    private Button lblAbmelden;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void BlackJackButtonActionHandling(MouseEvent event) throws IOException, SQLException, ClassNotFoundException {
        viewModel.startBlackJack();
    }

    @FXML
    private void YatzyButtonActionHandling(MouseEvent event) throws IOException {
        viewModel.startYatzy();
    }

    @FXML
    private void RouletteButtonActionHandling(MouseEvent event) throws IOException {
        viewModel.startRoulette();
    }

    @FXML
    private void BingoButtonActionHandling(MouseEvent event) throws IOException, SQLException, ClassNotFoundException {
        viewModel.startBingo();
    }

    @FXML
    private void SlotsButtonActionHandling(MouseEvent event) throws IOException {
        viewModel.startSlots();
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
