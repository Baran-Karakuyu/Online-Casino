/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.CasinoMenü;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void YatzyButtonActionHandling(MouseEvent event) throws IOException {
        
    }

    @FXML
    private void BlackJackButtonActionHandling(MouseEvent event) throws IOException {
        
    }
    
}
