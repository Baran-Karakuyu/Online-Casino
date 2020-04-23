/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Blackjack;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Andrei Oleniuc
 */
public class ViewGameController implements Initializable {

    private ViewModelBlackJack viewModel;
    @FXML
    private Button hitBtn;
    @FXML
    private Button holdBtn;
    @FXML
    private Button doubleBtn;
    @FXML
    private Button putBtn;
    @FXML
    private Button backBtn;
    @FXML
    private ImageView card1Groupier;
    @FXML
    private ImageView card2Groupier;
    @FXML
    private ImageView card3Groupier;
    @FXML
    private ImageView card4Groupier;
    @FXML
    private ImageView card5Groupier;
    @FXML
    private ImageView card1Player;
    @FXML
    private ImageView card2Player;
    @FXML
    private ImageView card3Player;
    @FXML
    private ImageView card4Player;
    @FXML
    private ImageView card5Player;
    @FXML
    private ImageView doubleDownCard;
    @FXML
    private Label label;
    @FXML
    private Label label11;
    @FXML
    private Label creditKonto;
    @FXML
    private ImageView chip10;
    @FXML
    private ImageView chip50;
    @FXML
    private ImageView chip100;
    @FXML
    private ImageView chip250;
    @FXML
    private ImageView chip1000;
    @FXML
    private Label chipsvalue;
    @FXML
    private ImageView chips;
    @FXML
    private ImageView chips1;
    @FXML
    private ImageView chips2;
    @FXML
    private ImageView chips3;
    @FXML
    private ImageView chips4;
    @FXML
    private ImageView chips5;
    @FXML
    private ImageView chips6;
    @FXML
    private ImageView chips7;
    @FXML
    private ImageView chips8;
    @FXML
    private ImageView chips9;
    @FXML
    private ImageView chips10;
    @FXML
    private ImageView chips11;
    @FXML
    private ImageView chips12;
    @FXML
    private ImageView chips13;
    @FXML
    private ImageView chips14;
    @FXML
    private ImageView chips15;
    @FXML
    private ImageView chips16;
    @FXML
    private ImageView chips17;
    @FXML
    private ImageView chips18;
    @FXML
    private Label endLbl;
    
    public void setViewModel(ViewModelBlackJack viewModel) {
        this.viewModel = viewModel;
    }
    public void bind(){
        
    }

    //Start
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void hitAction(ActionEvent event) {
    }

    @FXML
    private void holdAction(ActionEvent event) {
    }

    @FXML
    private void doubledownAction(ActionEvent event) {
    }

    @FXML
    private void putAction(ActionEvent event) {
    }

    @FXML
    private void closeBtn(ActionEvent event) {
    }

    @FXML
    private void chip10(MouseEvent event) {
    }

    @FXML
    private void chip50(MouseEvent event) {
    }

    @FXML
    private void chip100(MouseEvent event) {
    }

    @FXML
    private void chip250(MouseEvent event) {
    }

    @FXML
    private void chip1000(MouseEvent event) {
    }

}
