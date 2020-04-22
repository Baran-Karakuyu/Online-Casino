/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.CasinoMenü.View;

import ch.bbbaden.CasinoMenü.ViewModel.ViewModel;
import java.io.IOException;
import java.net.URL;
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
public class FXMLMenüController implements Initializable {
    
    @FXML
    private Button btnBuyCredits;
    @FXML
    private ImageView btnYatzy;
    @FXML
    private ImageView btnBlackJack;
    
    private ViewModel viewModel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void YatzyButtonActionHandling(MouseEvent event) throws IOException {
        viewModel.startSlots();
    }

    @FXML
    private void BlackJackButtonActionHandling(MouseEvent event) throws IOException {
        
    }
    
     public void bind() {
        
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
