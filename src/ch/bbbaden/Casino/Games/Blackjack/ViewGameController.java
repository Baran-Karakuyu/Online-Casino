/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Blackjack;

import java.awt.Event;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


/**
 * FXML Controller class
 *
 * @author Andrei Oleniuc
 */
public class ViewGameController implements Initializable {

    private ViewModelBlackJack viewModel;
    //Buttons
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

    //Cards
    @FXML
    private ImageView card1Player;
    @FXML
    private ImageView card1Groupier;
    @FXML
    private ImageView card2Player;
    @FXML
    private ImageView card2Groupier;
    @FXML
    private ImageView card3Player;
    @FXML
    private ImageView card3Groupier;
    @FXML
    private ImageView card4Player;
    @FXML
    private ImageView card5Player;
    @FXML
    private ImageView card4Groupier;
    @FXML
    private ImageView card5Groupier;

    //Card Ids
    IntegerProperty cardP = new SimpleIntegerProperty();
    IntegerProperty card2P = new SimpleIntegerProperty();
    IntegerProperty card3P = new SimpleIntegerProperty();
    IntegerProperty card4P = new SimpleIntegerProperty();
    IntegerProperty card5P = new SimpleIntegerProperty();
    IntegerProperty cardDouble = new SimpleIntegerProperty();

    IntegerProperty cardG = new SimpleIntegerProperty();
    IntegerProperty card2G = new SimpleIntegerProperty();
    IntegerProperty card3G = new SimpleIntegerProperty();
    IntegerProperty card4G = new SimpleIntegerProperty();
    IntegerProperty card5G = new SimpleIntegerProperty();

    //Label and ChoiceBox
    @FXML
    private Label label;
    @FXML
    private Label label11;
    private ChoiceBox<Integer> chipsSelection;
    //Variables
    private int cardsTaken = 0;
    ArrayList<Cards> playerCards = new ArrayList<>();
    ArrayList<Cards> dealerCards = new ArrayList<>();
    private int cardshit = 0;
    private int cardsDealer = 1;
    int summep;
    int summeg;
    int playTimes = 0;

    @FXML
    private ImageView doubleDownCard;
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
    int chip = 0;
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
    //Credit Part
    @FXML
    private Label creditKonto;

    int creditGesetzt;
    int creditGoV;
    int creditHere = 0;

    @FXML
    private Label endLbl;

    boolean doub = false;
    @FXML
    private ChoiceBox<Integer> versichernChoice;
    @FXML
    private Button versichernBtn;
    int versichern = 0;
    boolean versicherV = false;
    int versicherMoneyPut = 0;
    int zwischensum = 0;

    
    public void setViewModel(ViewModelBlackJack viewModel) {
        this.viewModel = viewModel;
    }
    public void bind(){
        
    }
    
    @Override
   public void initialize(URL url, ResourceBundle rb) {
//        chip10.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
//        chip50.setImage(new Image("CasinoIMG/BlackJack/Chips/Chips/Chip50.png"));
//        chip100.setImage(new Image("CasinoIMG/BlackJack/Chips/Chips/Chip100.png"));
//        chip250.setImage(new Image("CasinoIMG/BlackJack/Chips/Chips/Chip250.png"));
//        chip1000.setImage(new Image("CasinoIMG/BlackJack/Chips/Chips/Chip1000.png"));
//        versichernChoice.getItems().add(10);
//        versichernChoice.getItems().add(50);
//        versichernChoice.getItems().add(100);
//        versichernChoice.getItems().add(250);
//        versichernChoice.getItems().add(1000);
//        versichernChoice.getItems().add(2000);
//        versichernChoice.getItems().add(3000);
//        versichernChoice.getItems().add(4000);
//        versichernChoice.getItems().add(5000);
//        versichernChoice.getItems().add(6000);
//        versichernChoice.getItems().add(7000);
//        versichernChoice.getItems().add(8000);
//        versichernChoice.getItems().add(9000);
//        versichernChoice.getItems().add(10000);
//        versichernChoice.getItems().add(20000);
//        versichernChoice.getItems().add(30000);
//        versichernChoice.getItems().add(40000);
//        versichernChoice.getItems().add(50000);
//        doubleBtn.setDisable(false);
//        doubleBtn.opacityProperty().set(0.1);
//        versichernBtn.setDisable(true);
//        versichernBtn.opacityProperty().set(0.0);
//        versichernChoice.setDisable(true);
//        versichernChoice.opacityProperty().set(0.0);
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
