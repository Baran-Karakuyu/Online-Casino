/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Blackjack;

import java.awt.Event;
import java.io.IOException;
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
    int versichern = 0;
    boolean versicherV = false;
    int versicherMoneyPut = 0;
    int zwischensum = 0;
    @FXML
    private ImageView cardHide;
    @FXML
    private Button resetBtn;
    @FXML
    private Button versichernBtn;
    @FXML
    private ChoiceBox<Integer> versichernChoice;
    boolean checkPlayer= false;

    public void setViewModel(ViewModelBlackJack viewModel) {
        this.viewModel = viewModel;
    }

    public void bind() throws SQLException, ClassNotFoundException {
        cardP.bind(viewModel.getCard1P());
        cardG.bind(viewModel.getCard1G());
        card2P.bind(viewModel.getCard2P());
        card2G.bind(viewModel.getCard2G());
        card3P.bind(viewModel.getCard3P());
        card3G.bind(viewModel.getCard3G());
        card4P.bind(viewModel.getCard4P());
        card4G.bind(viewModel.getCard4G());
        card5P.bind(viewModel.getCard5P());
        card5G.bind(viewModel.getCard5G());
        cardDouble.bind(viewModel.getCardDouble());

        viewModel.credit();
        creditKonto.textProperty().bind(viewModel.getCredit());
        creditHere = Integer.parseInt(creditKonto.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        versichernChoice.getItems().add(10);
        versichernChoice.getItems().add(50);
        versichernChoice.getItems().add(100);
        versichernChoice.getItems().add(250);
        versichernChoice.getItems().add(1000);
        versichernChoice.getItems().add(2000);
        versichernChoice.getItems().add(3000);
        versichernChoice.getItems().add(4000);
        versichernChoice.getItems().add(5000);
        versichernChoice.getItems().add(6000);
        versichernChoice.getItems().add(7000);
        versichernChoice.getItems().add(8000);
        versichernChoice.getItems().add(9000);
        versichernChoice.getItems().add(10000);
        versichernChoice.getItems().add(20000);
        versichernChoice.getItems().add(30000);
        versichernChoice.getItems().add(40000);
        versichernChoice.getItems().add(50000);
        chip10.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
        chip50.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
        chip100.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip100.png"));
        chip250.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip250.png"));
        chip1000.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip1000.png"));
        doubleBtn.setDisable(false);
        doubleBtn.opacityProperty().set(0.1);
        versichernBtn.setDisable(true);
        versichernChoice.setDisable(true);
        versichernBtn.opacityProperty().set(0.0);
        versichernChoice.opacityProperty().set(0.0);
    }

    @FXML
    private void hitAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        doubleBtn.setDisable(true);
        doubleBtn.opacityProperty().set(0.5);
        viewModel.hitaction(cardshit);
        if (summep > 20) {
            holding();
            hitBtn.opacityProperty().set(0.1);
        } else {
            switch (cardshit) {
                case 2:
                    summep = 0;
                    for (int i = 0; i < playerCards.size(); i++) {
                        summep += playerCards.get(i).getValue();
                    }
                    if (summep > 10) {
                        cardsPlayer(card3P, card3Player, "CasinoIMG/BlackJack/Card", 1);
                    } else {
                        cardsPlayer(card3P, card3Player, "CasinoIMG/BlackJack/Card", 11);
                    }
                    summep = 0;
                    for (int i = 0; i < playerCards.size(); i++) {
                        summep += playerCards.get(i).getValue();
                    }

                    if (summep > 21) {
                        hitBtn.setDisable(true);
                        holding();
                    }
                    break;
                case 3:
                    summep = 0;
                    for (int i = 0; i < playerCards.size(); i++) {
                        summep += playerCards.get(i).getValue();
                    }
                    if (summep > 10) {
                        cardsPlayer(card4P, card4Player, "CasinoIMG/BlackJack/Card", 1);
                    } else {
                        cardsPlayer(card4P, card4Player, "CasinoIMG/BlackJack/Card", 11);
                    }
                    summep = 0;
                    for (int i = 0; i < playerCards.size(); i++) {
                        summep += playerCards.get(i).getValue();
                    }
                    if (summep > 21) {
                        hitBtn.setDisable(true);
                        holding();
                    }
                    break;
                case 4:
                    summep = 0;
                    for (int i = 0; i < playerCards.size(); i++) {
                        summep += playerCards.get(i).getValue();
                    }
                    if (summep > 10) {
                        cardsPlayer(card5P, card5Player, "CasinoIMG/BlackJack/Card", 1);
                    } else {
                        cardsPlayer(card5P, card5Player, "CasinoIMG/BlackJack/Card", 11);
                    }
                    summep = 0;
                    for (int i = 0; i < playerCards.size(); i++) {
                        summep += playerCards.get(i).getValue();
                    }
                    hitBtn.setDisable(true);
                    holding();
                    break;
            }
        }

        summep = 0;
        for (int i = 0; i < playerCards.size(); i++) {
            summep += playerCards.get(i).getValue();
        }
        label.setText(Integer.toString(summep));
        viewModel.updatePlayer();
    }

    @FXML
    private void holdAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        doubleBtn.setDisable(true);
        holdBtn.setDisable(true);
        hitBtn.setDisable(true);
        doubleBtn.opacityProperty().set(0.5);
        hitBtn.opacityProperty().set(0.5);
        holdBtn.opacityProperty().set(0.5);

        summeg = 0;
        for (int i = 0; i < dealerCards.size(); i++) {
            summeg += dealerCards.get(i).getValue();
            System.out.println("Values :" + dealerCards.get(i).getValue());
        }
        viewModel.holdaction(summeg, cardsDealer);
        System.out.println("Summeg ist " + summeg);

        //card4Show();
        cardHide.setImage(null);

        summeg = 0;
        for (int i = 0; i < dealerCards.size(); i++) {
            summeg += dealerCards.get(i).getValue();
        }
        System.out.println("Die Summe bei Hold: " + summeg);
        if (summeg < 17) {

            viewModel.holdaction(summeg, cardsDealer);
            if (summeg > 10) {
                cardsDealer(card3G, card3Groupier, "CasinoIMG/BlackJack/Card", 1);
            } else {
                cardsDealer(card3G, card3Groupier, "CasinoIMG/BlackJack/Card", 11);
            }
            summeg = 0;
            for (int i = 0; i < dealerCards.size(); i++) {
                summeg += dealerCards.get(i).getValue();
            }
            if (summeg < 17) {
                viewModel.holdaction(summeg, cardsDealer);
                if (summeg > 10) {
                    cardsDealer(card4G, card4Groupier, "CasinoIMG/BlackJack/Card", 1);
                } else {
                    cardsDealer(card4G, card4Groupier, "CasinoIMG/BlackJack/Card", 11);
                }
                summeg = 0;
                for (int i = 0; i < dealerCards.size(); i++) {
                    summeg += dealerCards.get(i).getValue();
                }
                if (summeg < 17) {
                    viewModel.holdaction(summeg, cardsDealer);
                    if (summeg > 10) {
                        cardsDealer(card5G, card5Groupier, "CasinoIMG/BlackJack/Card", 1);
                    } else {
                        cardsDealer(card5G, card5Groupier, "CasinoIMG/BlackJack/Card", 11);
                    }
                    summeg = 0;
                    for (int i = 0; i < dealerCards.size(); i++) {
                        summeg += dealerCards.get(i).getValue();
                    }
                }
            }
        }

        summeg = 0;
        for (int i = 0; i < dealerCards.size(); i++) {
            summeg += dealerCards.get(i).getValue();
            System.out.println("Values :" + dealerCards.get(i).getValue());
        }
        summep = 0;
        for (int i = 0; i < playerCards.size(); i++) {
            summep += playerCards.get(i).getValue();
        }
        checkPlayer(summep, summeg);
        label11.setText(Integer.toString(summeg));
        summeg = 0;
        viewModel.updatePlayer();

    }

    //Dealer Actions after Double or Bust
    private void holding() throws SQLException, ClassNotFoundException {
        doubleBtn.setDisable(true);
        holdBtn.setDisable(true);
        hitBtn.setDisable(true);
        doubleBtn.opacityProperty().set(0.5);
        hitBtn.opacityProperty().set(0.5);
        holdBtn.opacityProperty().set(0.5);

        summeg = 0;
        for (int i = 0; i < dealerCards.size(); i++) {
            summeg += dealerCards.get(i).getValue();
            System.out.println("Values :" + dealerCards.get(i).getValue());
        }
        viewModel.holdaction(summeg, cardsDealer);
        System.out.println("Summeg ist " + summeg);

        //card4Show();
        cardHide.setImage(null);
        summeg = 0;
        for (int i = 0; i < dealerCards.size(); i++) {
            summeg += dealerCards.get(i).getValue();
        }
        System.out.println("Die Summe bei Hold: " + summeg);
        summep = 0;
        for (int i = 0; i < playerCards.size(); i++) {
            summep += playerCards.get(i).getValue();
        }

        if (summep > 21) {
            summeg = 0;
            for (int i = 0; i < dealerCards.size(); i++) {
                summeg += dealerCards.get(i).getValue();
                System.out.println("Values :" + dealerCards.get(i).getValue());
            }
        } else {
            if (summeg > 10) {
                cardsDealer(card3G, card3Groupier, "CasinoIMG/BlackJack/Card", 1);
            } else {
                cardsDealer(card3G, card3Groupier, "CasinoIMG/BlackJack/Card", 11);
            }
            summeg = 0;
            for (int i = 0; i < dealerCards.size(); i++) {
                summeg += dealerCards.get(i).getValue();
                System.out.println("Values :" + dealerCards.get(i).getValue());
            }
            if (summeg < 17) {
                viewModel.holdaction(summeg, cardsDealer);
                if (summeg > 10) {
                    cardsDealer(card4G, card4Groupier, "CasinoIMG/BlackJack/Card", 1);
                } else {
                    cardsDealer(card4G, card4Groupier, "CasinoIMG/BlackJack/Card", 11);
                }
                summeg = 0;
                for (int i = 0; i < dealerCards.size(); i++) {
                    summeg += dealerCards.get(i).getValue();
                }
                if (summeg < 17) {
                    viewModel.holdaction(summeg, cardsDealer);
                    if (summeg > 10) {
                        cardsDealer(card5G, card5Groupier, "CasinoIMG/BlackJack/Card", 1);
                    } else {
                        cardsDealer(card5G, card5Groupier, "CasinoIMG/BlackJack/Card", 11);
                    }
                    summeg = 0;
                    for (int i = 0; i < dealerCards.size(); i++) {
                        summeg += dealerCards.get(i).getValue();
                    }
                }
            }
        }
        summeg = 0;
        for (int i = 0; i < dealerCards.size(); i++) {
            summeg += dealerCards.get(i).getValue();
            System.out.println("Values :" + dealerCards.get(i).getValue());
        }
        summep = 0;
        for (int i = 0; i < playerCards.size(); i++) {
            summep += playerCards.get(i).getValue();
        }
        checkPlayer(summep, summeg);
        label11.setText(Integer.toString(summeg));
        viewModel.updatePlayer();
    }

    @FXML
    private void doubledownAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        summep = 0;
        for (int i = 0; i < playerCards.size(); i++) {
            summep += playerCards.get(i).getValue();
        }
        if (summep > 8 && summep < 12) {

            zwischensum += creditGesetzt;
            creditGesetzt += creditGesetzt;
            chipsvalue.setText(Integer.toString(creditGesetzt));
            creditGesetzt = zwischensum;

            doubleBtn.setTextFill(Color.DARKGOLDENROD);
            hitBtn.setTextFill(Color.DARKGOLDENROD);
            holdBtn.setTextFill(Color.DARKGOLDENROD);
            hitBtn.setDisable(true);
            holdBtn.setDisable(true);
            hitBtn.opacityProperty().set(0.5);
            holdBtn.opacityProperty().set(0.5);

            viewModel.doubleaction();
            cardsPlayer(cardDouble, doubleDownCard, "CasinoIMG/BlackJack/CardsDoubleDown", 11);
            summep = 0;
            for (int i = 0; i < playerCards.size(); i++) {
                summep += playerCards.get(i).getValue();
            }
            label.setText(Integer.toString(summep));
            doub = true;
            holding();

        } else {

        }

    }

    @FXML
    private void putAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        versichernBtn.setDisable(true);
        versichernChoice.setDisable(true);
        versichernBtn.opacityProperty().set(0.0);
        versichernChoice.opacityProperty().set(0.0);
        if (creditGesetzt == 0) {
            System.out.println("Setzte Geld");
        } else {
            viewModel.play();

            cardsPlayer(cardP, card1Player, "CasinoIMG/BlackJack/Card", 11);
            cardsDealer(cardG, card1Groupier, "CasinoIMG/BlackJack/Card", 11);
            if (playerCards.get(0).getValue() == 11) {
                cardsPlayer(card2P, card2Player, "CasinoIMG/BlackJack/Card", 1);
            } else {
                cardsPlayer(card2P, card2Player, "CasinoIMG/BlackJack/Card", 11);
            }

            if (dealerCards.get(0).getValue() == 11) {
                cardsDealer(card2G, card2Groupier, "CasinoIMG/BlackJack/Card", 1);
            } else {
                cardsDealer(card2G, card2Groupier, "CasinoIMG/BlackJack/Card", 11);
            }
            cardHide.setImage(new Image("CasinoIMG/BlackJack/Card/Back.png"));

            summep = 0;
            summeg = 0;

            if (dealerCards.get(0).getValue() == 11) {
                versichernBtn.setDisable(false);
                versichernBtn.opacityProperty().set(1.0);
                versichernChoice.setDisable(false);
                versichernChoice.opacityProperty().set(1.0);
            }
            for (int i = 0; i < playerCards.size(); i++) {
                summep += playerCards.get(i).getValue();
            }
            if (summep > 8 && summep < 12) {
                doubleBtn.setDisable(false);
                doubleBtn.opacityProperty().set(1.0);
            }
            label11.setText(Integer.toString(dealerCards.get(0).getValue()));
            label.setText(Integer.toString(summep));

            for (int i = 0; i < dealerCards.size(); i++) {
                summeg += dealerCards.get(i).getValue();
                System.out.println("Values :" + dealerCards.get(i).getValue());
            }
            if (summep > 20) {
                holding();
                hitBtn.opacityProperty().set(0.5);
            }

//            creditHere = Integer.parseInt(creditKonto.getText());
            putBtn.opacityProperty().set(0.0);
        }

        viewModel.updatePlayer();

    }

    //Checks who Won and put Money into DataBase
    //Resets everything to play on
    private void checkPlayer(int sumP, int sumG) throws SQLException, ClassNotFoundException {
        boolean notNegativeP = false;
        boolean notNegativeG = false;
        if (21 - sumP < 0) {
            System.out.println("Lost");
            endLbl.setText("LOST");
            notNegativeP = true;
            if (doub == true) {
                creditHere -= creditGesetzt;
                creditHere -= creditGesetzt;
            } else {
                creditHere -= creditGesetzt;
            }
            viewModel.setNewCredit(creditHere);
        } else {
            notNegativeP = false;
        }

        if (21 - sumG < 0) {
            notNegativeG = true;
            System.out.println("You Won");
            endLbl.setText("WON");
            if (doub == true) {
                creditHere += creditGesetzt;
                creditHere += creditGesetzt;
            } else {
                creditHere += creditGesetzt;
            }
            viewModel.setNewCredit(creditHere);
        } else {
            notNegativeG = false;
        }

        if (notNegativeP == false && notNegativeG == false) {
            if (21 - sumP < 21 - sumG) {
                System.out.println("Won");
                endLbl.setText("WON");
                if (doub == true) {
                    creditHere += creditGesetzt;
                    creditHere += creditGesetzt;
                } else {
                    creditHere += creditGesetzt;
                }
                viewModel.setNewCredit(creditHere);
            } else if (21 - sumP > 21 - sumG) {
                System.out.println("You Lost");
                endLbl.setText("LOST");
                if (doub == true) {
                    creditHere -= creditGesetzt;
                    creditHere -= creditGesetzt;
                } else {
                    creditHere -= creditGesetzt;
                }
                viewModel.setNewCredit(creditHere);
            } else {
                System.out.println("Even");
                endLbl.setText("EVEN!!!");
                viewModel.setNewCredit(creditHere);
            }
        }
        if (versicherV == true) {
            versicherMethode(versicherMoneyPut);
        } else {
            System.out.println("");
        }
        checkPlayer= true;
    }

    @FXML
    private void versichern(ActionEvent event) {
        if (versichernChoice.getValue() == 0) {

        } else {
            versichernBtn.setTextFill(Color.FUCHSIA);
            versicherV = true;
            versicherMoneyPut = versichernChoice.getValue();
        }
    }

    //Insurance Methode to Connect with Model
    private void versicherMethode(int credit) throws SQLException, ClassNotFoundException {
        summeg = 0;
        for (int i = 0; i < dealerCards.size(); i++) {
            summeg += dealerCards.get(i).getValue();
            System.out.println("Values :" + dealerCards.get(i).getValue());
        }
        viewModel.versichern(credit, summeg);
    }

    @FXML
    private void closeBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(checkPlayer=true){
            System.exit(0);   
        }else{
        creditHere -= creditGesetzt;
        viewModel.setNewCredit(creditHere);
        System.exit(0);     
        }
    }

    @FXML
    private void reset(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        if(checkPlayer==true){
            viewModel.backToMenu();
        }else{
            creditHere -= creditGesetzt;
            viewModel.setNewCredit(creditHere);
        }
        hitBtn.setDisable(false);
        hitBtn.opacityProperty().set(1.0);
        hitBtn.textFillProperty().set(Color.WHITE);
        holdBtn.setDisable(false);
        holdBtn.opacityProperty().set(1.0);
        holdBtn.textFillProperty().set(Color.WHITE);
        doubleBtn.setDisable(false);
        doubleBtn.opacityProperty().set(1.0);
        doubleBtn.textFillProperty().set(Color.WHITE);
        putBtn.setDisable(false);
        putBtn.opacityProperty().set(1.0);
        putBtn.textFillProperty().set(Color.WHITE);
        backBtn.setDisable(false);
        backBtn.opacityProperty().set(1.0);
        backBtn.textFillProperty().set(Color.WHITE);
        versichernBtn.setDisable(true);
        versichernBtn.opacityProperty().set(0.0);
        versichernBtn.textFillProperty().set(Color.WHITE);
        versichernChoice.setDisable(true);
        versichernChoice.opacityProperty().set(0.0);
        versichernChoice.getSelectionModel().clearSelection();
        hitBtn.setDisable(false);
        hitBtn.setVisible(true);
        hitBtn.opacityProperty().set(1.0);
        cardHide.setImage(null);
        card1Player.setImage(null);
        card2Player.setImage(null);
        card3Player.setImage(null);
        card4Player.setImage(null);
        card5Player.setImage(null);
        card1Groupier.setImage(null);
        card2Groupier.setImage(null);
        card3Groupier.setImage(null);
        card4Groupier.setImage(null);
        card5Groupier.setImage(null);
        doubleDownCard.setImage(null);
        chips.setImage(null);
        chips1.setImage(null);
        chips2.setImage(null);
        chips3.setImage(null);
        chips4.setImage(null);
        chips5.setImage(null);
        chips6.setImage(null);
        chips7.setImage(null);
        chips8.setImage(null);
        chips9.setImage(null);
        chips10.setImage(null);
        chips11.setImage(null);
        chips12.setImage(null);
        chips13.setImage(null);
        chips14.setImage(null);
        chips15.setImage(null);
        chips16.setImage(null);
        chips17.setImage(null);
        chips18.setImage(null);
        endLbl.setText(null);
        label.setText(null);
        label11.setText(null);
        playerCards.clear();
        checkPlayer= false;
        dealerCards.clear();
        versichern = 0;
        doub = false;
        versicherV = false;
        versicherMoneyPut = 0;
        zwischensum = 0;
        creditGesetzt = 0;
        creditGoV = 0;
        chip = 0;
        chipsvalue.setText(null);
        cardshit = 0;
        cardsDealer = 1;
        playTimes = 0;
        cardsTaken = 0;

        creditKonto.textProperty().bind(viewModel.getCredit());
        creditHere = Integer.parseInt(creditKonto.getText());
    }

    @FXML
    private void chip10(MouseEvent event) {
        creditGesetzt += 10;
        chipsvalue.setText(Integer.toString(creditGesetzt));
        chip++;
        switch (chip) {
            case 1:
                chips.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 2:
                chips1.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 3:
                chips2.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 4:
                chips3.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 5:
                chips4.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 6:
                chips5.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 7:
                chips6.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 8:
                chips7.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 9:
                chips8.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 10:
                chips9.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 11:
                chips10.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 12:
                chips11.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 13:
                chips12.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 14:
                chips13.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 15:
                chips14.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 16:
                chips15.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 18:
                chips16.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 19:
                chips17.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;
            case 20:
                chips18.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip10.png"));
                break;

        }
    }

    @FXML
    private void chip50(MouseEvent event) {
        creditGesetzt += 50;
        chipsvalue.setText(Integer.toString(creditGesetzt));
        chip++;
        switch (chip) {
            case 1:
                chips.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 2:
                chips1.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 3:
                chips2.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 4:
                chips3.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 5:
                chips4.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 6:
                chips5.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 7:
                chips6.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 8:
                chips7.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 9:
                chips8.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 10:
                chips9.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 11:
                chips10.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 12:
                chips11.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 13:
                chips12.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 14:
                chips13.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 15:
                chips14.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 16:
                chips15.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 18:
                chips16.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 19:
                chips17.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
            case 20:
                chips13.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip50.png"));
                break;
        }
    }

    @FXML
    private void chip100(MouseEvent event) {
        creditGesetzt += 100;
        chipsvalue.setText(Integer.toString(creditGesetzt));
        chip++;
        switch (chip) {
            case 1:
                chips.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip100.png"));
                break;
            case 2:
                chips1.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip100.png"));
                break;
            case 3:
                chips2.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip100.png"));
                break;
            case 4:
                chips3.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip100.png"));
                break;
            case 5:
                chips4.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip100.png"));
                break;
            case 6:
                chips5.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip100.png"));
                break;
            case 7:
                chips6.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip100.png"));
                break;
            case 8:
                chips7.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip100.png"));
                break;
            case 9:
                chips8.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip100.png"));
                break;
            case 10:
                chips9.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip100.png"));
                break;
            case 11:
                chips10.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip100.png"));
                break;
            case 12:
                chips11.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip100.png"));
                break;
            case 13:
                chips12.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip100.png"));
                break;
        }
    }

    @FXML
    private void chip250(MouseEvent event) {
        creditGesetzt += 250;
        chipsvalue.setText(Integer.toString(creditGesetzt));
        chip++;
        switch (chip) {
            case 1:
                chips.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip250.png"));
                break;
            case 2:
                chips1.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip250.png"));
                break;
            case 3:
                chips2.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip250.png"));
                break;
            case 4:
                chips3.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip250.png"));
                break;
            case 5:
                chips4.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip250.png"));
                break;
            case 6:
                chips5.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip250.png"));
                break;
            case 7:
                chips6.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip250.png"));
                break;
            case 8:
                chips7.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip250.png"));
                break;
            case 9:
                chips8.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip250.png"));
                break;
            case 10:
                chips9.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip250.png"));
                break;
            case 11:
                chips10.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip250.png"));
                break;
            case 12:
                chips11.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip250.png"));
                break;
            case 13:
                chips12.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip250.png"));
                break;
        }
    }

    @FXML
    private void chip1000(MouseEvent event) {
        creditGesetzt += 1000;
        chipsvalue.setText(Integer.toString(creditGesetzt));
        chip++;
        switch (chip) {
            case 1:
                chips.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip1000.png"));
                break;
            case 2:
                chips1.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip1000.png"));
                break;
            case 3:
                chips2.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip1000.png"));
                break;
            case 4:
                chips3.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip1000.png"));
                break;
            case 5:
                chips4.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip1000.png"));
                break;
            case 6:
                chips5.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip1000.png"));
                break;
            case 7:
                chips6.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip1000.png"));
                break;
            case 8:
                chips7.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip1000.png"));
                break;
            case 9:
                chips8.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip1000.png"));
                break;
            case 10:
                chips9.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip1000.png"));
                break;
            case 11:
                chips10.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip1000.png"));
                break;
            case 12:
                chips11.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip1000.png"));
                break;
            case 13:
                chips12.setImage(new Image("CasinoIMG/BlackJack/Chips/Chip1000.png"));
                break;
        }
    }

    //Cards Displayer
    private void cardsPlayer(IntegerProperty card, ImageView cardView, String set, int aceValue) {
        cardshit++;
        switch (card.get()) {
            case 1:
                cardView.setImage(new Image(set + "/2C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(1, 2));
                break;
            case 2:
                cardView.setImage(new Image(set + "/2D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(2, 2));
                break;

            case 3:
                cardView.setImage(new Image(set + "/2H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(3, 2));
                break;
            case 4:
                cardView.setImage(new Image(set + "/2S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(4, 2));
                break;
            case 5:
                cardView.setImage(new Image(set + "/3C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(5, 3));
                break;
            case 6:
                cardView.setImage(new Image(set + "/3D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(6, 3));
                break;
            case 7:
                cardView.setImage(new Image(set + "/3H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(7, 3));
                break;
            case 8:
                cardView.setImage(new Image(set + "/3S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(8, 3));
                break;
            case 9:
                cardView.setImage(new Image(set + "/4C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(9, 4));
                break;
            case 10:
                cardView.setImage(new Image(set + "/4D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(10, 4));
                break;
            case 11:
                cardView.setImage(new Image(set + "/4H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(11, 4));
                break;
            case 12:
                cardView.setImage(new Image(set + "/4S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(12, 4));
                break;
            case 13:
                cardView.setImage(new Image(set + "/5C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(13, 5));
                break;
            case 14:
                cardView.setImage(new Image(set + "/5D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(14, 5));
                break;
            case 15:
                cardView.setImage(new Image(set + "/5H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(15, 5));
                break;
            case 16:
                cardView.setImage(new Image(set + "/5S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(16, 5));
                break;
            case 17:
                cardView.setImage(new Image(set + "/6C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(17, 6));
                break;
            case 18:
                cardView.setImage(new Image(set + "/6D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(18, 6));
                break;
            case 19:
                cardView.setImage(new Image(set + "/6H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(19, 6));
                break;
            case 20:
                cardView.setImage(new Image(set + "/6S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(20, 6));
                break;
            case 21:
                cardView.setImage(new Image(set + "/7C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(21, 7));
                break;
            case 22:
                cardView.setImage(new Image(set + "/7D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(22, 7));
                break;
            case 23:
                cardView.setImage(new Image(set + "/7H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(23, 7));
                break;
            case 24:
                cardView.setImage(new Image(set + "/7S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(24, 7));
                break;
            case 25:
                cardView.setImage(new Image(set + "/8C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(25, 8));
                break;
            case 26:
                cardView.setImage(new Image(set + "/8D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(26, 8));
                break;
            case 27:
                cardView.setImage(new Image(set + "/8H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(27, 8));
                break;
            case 28:
                cardView.setImage(new Image(set + "/8S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(28, 8));
                break;
            case 29:
                cardView.setImage(new Image(set + "/9C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(29, 9));
                break;
            case 30:
                cardView.setImage(new Image(set + "/9D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(30, 9));
                break;
            case 31:
                cardView.setImage(new Image(set + "/9H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(31, 9));
                break;
            case 32:
                cardView.setImage(new Image(set + "/9S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(32, 9));
                break;
            case 33:
                cardView.setImage(new Image(set + "/10C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(33, 10));
                break;
            case 34:
                cardView.setImage(new Image(set + "/10D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(34, 10));
                break;
            case 35:
                cardView.setImage(new Image(set + "/10H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(35, 10));
                break;
            case 36:
                cardView.setImage(new Image(set + "/10S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(36, 10));
                break;
            case 37:
                cardView.setImage(new Image(set + "/AC.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(37, aceValue));
                break;
            case 38:
                cardView.setImage(new Image(set + "/AD.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(38, aceValue));
                break;
            case 39:
                cardView.setImage(new Image(set + "/AH.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(39, aceValue));
                break;
            case 40:
                cardView.setImage(new Image(set + "/AS.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(40, aceValue));
                break;
            case 41:
                cardView.setImage(new Image(set + "/JC.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(41, 10));
                break;
            case 42:
                cardView.setImage(new Image(set + "/JD.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(42, 10));
                break;
            case 43:
                cardView.setImage(new Image(set + "/JH.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(43, 10));
                break;
            case 44:
                cardView.setImage(new Image(set + "/JS.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(44, 10));
                break;
            case 45:
                cardView.setImage(new Image(set + "/KC.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(45, 10));
                break;
            case 46:
                cardView.setImage(new Image(set + "/KD.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(46, 10));
                break;
            case 47:
                cardView.setImage(new Image(set + "/KH.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(47, 10));
                break;
            case 48:
                cardView.setImage(new Image(set + "/KS.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(48, 10));
                break;
            case 49:
                cardView.setImage(new Image(set + "/QC.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(49, 10));
                break;
            case 50:
                cardView.setImage(new Image(set + "/QD.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(50, 10));
                break;
            case 51:
                cardView.setImage(new Image(set + "/QH.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(51, 10));
                break;
            case 52:
                cardView.setImage(new Image(set + "/QS.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                playerCards.add(new Cards(51, 10));
                break;
            default:
                System.out.println("Card 0");
                break;

        }
    }

    private void cardsDealer(IntegerProperty card, ImageView cardView, String set, int aceValue) {
        cardsDealer++;
        switch (card.get()) {
            case 1:
                cardView.setImage(new Image(set + "/2C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(1, 2));
                break;
            case 2:
                cardView.setImage(new Image(set + "/2D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(2, 2));
                break;

            case 3:
                cardView.setImage(new Image(set + "/2H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(3, 2));
                break;
            case 4:
                cardView.setImage(new Image(set + "/2S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(4, 2));
                break;
            case 5:
                cardView.setImage(new Image(set + "/3C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(5, 3));
                break;
            case 6:
                cardView.setImage(new Image(set + "/3D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(6, 3));
                break;
            case 7:
                cardView.setImage(new Image(set + "/3H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(7, 3));
                break;
            case 8:
                cardView.setImage(new Image(set + "/3S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(8, 3));
                break;
            case 9:
                cardView.setImage(new Image(set + "/4C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(9, 4));
                break;
            case 10:
                cardView.setImage(new Image(set + "/4D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(10, 4));
                break;
            case 11:
                cardView.setImage(new Image(set + "/4H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(11, 4));
                break;
            case 12:
                cardView.setImage(new Image(set + "/4S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(12, 4));
                break;
            case 13:
                cardView.setImage(new Image(set + "/5C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(13, 5));
                break;
            case 14:
                cardView.setImage(new Image(set + "/5D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(14, 5));
                break;
            case 15:
                cardView.setImage(new Image(set + "/5H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(15, 5));
                break;
            case 16:
                cardView.setImage(new Image(set + "/5S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(16, 5));
                break;
            case 17:
                cardView.setImage(new Image(set + "/6C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(17, 6));
                break;
            case 18:
                cardView.setImage(new Image(set + "/6D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(18, 6));
                break;
            case 19:
                cardView.setImage(new Image(set + "/6H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(19, 6));
                break;
            case 20:
                cardView.setImage(new Image(set + "/6S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(20, 6));
                break;
            case 21:
                cardView.setImage(new Image(set + "/7C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(21, 7));
                break;
            case 22:
                cardView.setImage(new Image(set + "/7D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(22, 7));
                break;
            case 23:
                cardView.setImage(new Image(set + "/7H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(23, 7));
                break;
            case 24:
                cardView.setImage(new Image(set + "/7S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(24, 7));
                break;
            case 25:
                cardView.setImage(new Image(set + "/8C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(25, 8));
                break;
            case 26:
                cardView.setImage(new Image(set + "/8D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(26, 8));
                break;
            case 27:
                cardView.setImage(new Image(set + "/8H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(27, 8));
                break;
            case 28:
                cardView.setImage(new Image(set + "/8S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(28, 8));
                break;
            case 29:
                cardView.setImage(new Image(set + "/9C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(29, 9));
                break;
            case 30:
                cardView.setImage(new Image(set + "/9D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(30, 9));
                break;
            case 31:
                cardView.setImage(new Image(set + "/9H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(31, 9));
                break;
            case 32:
                cardView.setImage(new Image(set + "/9S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(32, 9));
                break;
            case 33:
                cardView.setImage(new Image(set + "/10C.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(33, 10));
                break;
            case 34:
                cardView.setImage(new Image(set + "/10D.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(34, 10));
                break;
            case 35:
                cardView.setImage(new Image(set + "/10H.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(35, 10));
                break;
            case 36:
                cardView.setImage(new Image(set + "/10S.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(36, 10));
                break;
            case 37:
                cardView.setImage(new Image(set + "/AC.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(37, aceValue));
                break;
            case 38:
                cardView.setImage(new Image(set + "/AD.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(38, aceValue));
                break;
            case 39:
                cardView.setImage(new Image(set + "/AH.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(39, aceValue));
                break;
            case 40:
                cardView.setImage(new Image(set + "/AS.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(40, aceValue));
                break;
            case 41:
                cardView.setImage(new Image(set + "/JC.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(41, 10));
                break;
            case 42:
                cardView.setImage(new Image(set + "/JD.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(42, 10));
                break;
            case 43:
                cardView.setImage(new Image(set + "/JH.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(43, 10));
                break;
            case 44:
                cardView.setImage(new Image(set + "/JS.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(44, 10));
                break;
            case 45:
                cardView.setImage(new Image(set + "/KC.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(45, 10));
                break;
            case 46:
                cardView.setImage(new Image(set + "/KD.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(46, 10));
                break;
            case 47:
                cardView.setImage(new Image(set + "/KH.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(47, 10));
                break;
            case 48:
                cardView.setImage(new Image(set + "/KS.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(48, 10));
                break;
            case 49:
                cardView.setImage(new Image(set + "/QC.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(49, 10));
                break;
            case 50:
                cardView.setImage(new Image(set + "/QD.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(50, 10));
                break;
            case 51:
                cardView.setImage(new Image(set + "/QH.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(51, 10));
                break;
            case 52:
                cardView.setImage(new Image(set + "/QS.png"));
                cardsTaken++;
                System.out.println(cardsTaken);
                dealerCards.add(new Cards(51, 10));
                break;
            default:
                System.out.println("Card 0");
                break;

        }
    }

    @FXML
    private void backToMenu(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        if(checkPlayer==true){
            viewModel.backToMenu();
        }else{
            creditHere -= creditGesetzt;
            viewModel.setNewCredit(creditHere);
            viewModel.backToMenu();
        }
    }

}
