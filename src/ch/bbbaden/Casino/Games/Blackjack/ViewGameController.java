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
import javax.swing.JOptionPane;

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
    private IntegerProperty cardP = new SimpleIntegerProperty();
    private IntegerProperty card2P = new SimpleIntegerProperty();
    private IntegerProperty card3P = new SimpleIntegerProperty();
    private IntegerProperty card4P = new SimpleIntegerProperty();
    private IntegerProperty card5P = new SimpleIntegerProperty();
    private IntegerProperty cardDouble = new SimpleIntegerProperty();

    private IntegerProperty cardG = new SimpleIntegerProperty();
    private IntegerProperty card2G = new SimpleIntegerProperty();
    private IntegerProperty card3G = new SimpleIntegerProperty();
    private IntegerProperty card4G = new SimpleIntegerProperty();
    private IntegerProperty card5G = new SimpleIntegerProperty();

    //Label and ChoiceBox
    @FXML
    private Label playerValue;
    @FXML
    private Label dealerValue;
    //Variables
    private int cardsTaken = 0;
    private ArrayList<Cards> playerCards = new ArrayList<>();
    private ArrayList<Cards> dealerCards = new ArrayList<>();
    private int cardsHit = 0;
    private int cardsDealer = 1;
    private int sumP;
    private int sumG;

    @FXML
    private ImageView doubleDownCard;
    //Chips
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
    //Credit Part
    @FXML
    private Label creditKonto;

    private double creditPut;
    private double creditHere = 0;
    private int chipAmount = 0;
    @FXML
    private Label endLbl;

    private boolean doubleActive = false;
    private boolean insuranceActive = false;
    private double insuranceMoneyPut = 0;
    private double innerSum = 0;
    @FXML
    private ImageView cardHide;
    @FXML
    private Button resetBtn;
    @FXML
    private ChoiceBox<Double> insuranceChoice;
    //Booleans to Check
    private boolean checkPlayer = false;
    private boolean blackjack = false;
    private boolean put = false;
    private boolean chipsActive = true;
    @FXML
    private Button insuranceBtn;
    //Unsername
    @FXML
    private Label username;
    //Insurance Boolean
    private boolean insuranceWoL = false;
    
    //ViewModel Setter
    public void setViewModel(ViewModelBlackJack viewModel) {
        this.viewModel = viewModel;
    }

    //Binding
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
        username.textProperty().bind(viewModel.getName());
        viewModel.credit();
        creditKonto.textProperty().bind(viewModel.getCredit());
        creditHere = Double.parseDouble(creditKonto.getText());
    }
    //Adding Pictures and ChoiceBox Items
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        insuranceChoice.getItems().add(10.0);
        insuranceChoice.getItems().add(50.0);
        insuranceChoice.getItems().add(100.0);
        insuranceChoice.getItems().add(250.0);
        insuranceChoice.getItems().add(1000.0);
        insuranceChoice.getItems().add(2000.0);
        insuranceChoice.getItems().add(3000.0);
        insuranceChoice.getItems().add(4000.0);
        insuranceChoice.getItems().add(5000.0);
        insuranceChoice.getItems().add(6000.0);
        insuranceChoice.getItems().add(7000.0);
        insuranceChoice.getItems().add(8000.0);
        insuranceChoice.getItems().add(9000.0);
        insuranceChoice.getItems().add(10000.0);
        insuranceChoice.getItems().add(20000.0);
        insuranceChoice.getItems().add(30000.0);
        insuranceChoice.getItems().add(40000.0);
        insuranceChoice.getItems().add(50000.0);
        chip10.setImage(new Image("CasinoIMG/Chips4All/Chip10.png"));
        chip50.setImage(new Image("CasinoIMG/Chips4All/Chip50.png"));
        chip100.setImage(new Image("CasinoIMG/Chips4All/Chip100.png"));
        chip250.setImage(new Image("CasinoIMG/Chips4All/Chip250.png"));
        chip1000.setImage(new Image("CasinoIMG/Chips4All/Chip1000.png"));
        doubleBtn.setDisable(false);
        doubleBtn.opacityProperty().set(0.1);
        insuranceBtn.setDisable(true);
        insuranceChoice.setDisable(true);
        insuranceBtn.opacityProperty().set(0.0);
        insuranceChoice.opacityProperty().set(0.0);
    }
    //Method to take Cards
    @FXML
    private void hitAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        //Checks if Round started
        if (put == false) {
            JOptionPane.showMessageDialog(null, "Start the game first with Put", "Fail", JOptionPane.ERROR_MESSAGE);
        } else {
            doubleBtn.setDisable(true);
            doubleBtn.opacityProperty().set(0.5);
            viewModel.hitaction(cardsHit);
            if (sumP > 20) {
                holding();
                hitBtn.opacityProperty().set(0.1);
            } else {
                //Checks for the next Card
                switch (cardsHit) {
                    case 2:
                        sumP = 0;
                        for (int i = 0; i < playerCards.size(); i++) {
                            sumP += playerCards.get(i).getValue();
                        }
                        //if sum already over 10 ace 1 otherwise ace 11
                        if (sumP > 10) {
                            cardsPlayer(card3P, card3Player, "CasinoIMG/BlackJack/Card", 1);
                        } else {
                            cardsPlayer(card3P, card3Player, "CasinoIMG/BlackJack/Card", 11);
                        }
                        sumP = 0;
                        for (int i = 0; i < playerCards.size(); i++) {
                            sumP += playerCards.get(i).getValue();
                        }
                        //if 21 or over 21 dealer plays and he cant hit nomore
                        if (sumP > 20) {
                            hitBtn.setDisable(true);
                            holding();
                        }
                        break;
                    case 3:
                        sumP = 0;
                        for (int i = 0; i < playerCards.size(); i++) {
                            sumP += playerCards.get(i).getValue();
                        }
                        if (sumP > 10) {
                            cardsPlayer(card4P, card4Player, "CasinoIMG/BlackJack/Card", 1);
                        } else {
                            cardsPlayer(card4P, card4Player, "CasinoIMG/BlackJack/Card", 11);
                        }
                        sumP = 0;
                        for (int i = 0; i < playerCards.size(); i++) {
                            sumP += playerCards.get(i).getValue();
                        }
                        if (sumP > 20) {
                            hitBtn.setDisable(true);
                            holding();
                        }
                        break;
                    case 4:
                        sumP = 0;
                        for (int i = 0; i < playerCards.size(); i++) {
                            sumP += playerCards.get(i).getValue();
                        }
                        if (sumP > 10) {
                            cardsPlayer(card5P, card5Player, "CasinoIMG/BlackJack/Card", 1);
                        } else {
                            cardsPlayer(card5P, card5Player, "CasinoIMG/BlackJack/Card", 11);
                        }
                        sumP = 0;
                        for (int i = 0; i < playerCards.size(); i++) {
                            sumP += playerCards.get(i).getValue();
                        }
                        if (sumP > 21) {
                            hitBtn.setDisable(true);
                            holding();
                        }
                        holding();
                        break;
                }
            }

            sumP = 0;
            for (int i = 0; i < playerCards.size(); i++) {
                sumP += playerCards.get(i).getValue();
            }
            //Displays Sum
            playerValue.setText(Integer.toString(sumP));
            viewModel.updatePlayer();
        }
    }
    //Hold Action for Button Dealer Takes Card
    @FXML
    private void holdAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        //Checks if Round started
        if (put == false) {
            JOptionPane.showMessageDialog(null, "Start the game first with Put", "Fail", JOptionPane.ERROR_MESSAGE);
        } else {
            doubleBtn.setDisable(true);
            holdBtn.setDisable(true);
            hitBtn.setDisable(true);
            doubleBtn.opacityProperty().set(0.5);
            hitBtn.opacityProperty().set(0.5);
            holdBtn.opacityProperty().set(0.5);

            sumG = 0;
            for (int i = 0; i < dealerCards.size(); i++) {
                sumG += dealerCards.get(i).getValue();
            }
            viewModel.holdaction(sumG, cardsDealer);

            //Hides the second card so dealer second card revealed
            cardHide.setImage(null);

            sumG = 0;
            for (int i = 0; i < dealerCards.size(); i++) {
                sumG += dealerCards.get(i).getValue();
            }
            //If he under 17 he takes Cards
            if (sumG < 17) {

                viewModel.holdaction(sumG, cardsDealer);
                if (sumG > 10) {
                    cardsDealer(card3G, card3Groupier, "CasinoIMG/BlackJack/Card", 1);
                } else {
                    cardsDealer(card3G, card3Groupier, "CasinoIMG/BlackJack/Card", 11);
                }
                sumG = 0;
                for (int i = 0; i < dealerCards.size(); i++) {
                    sumG += dealerCards.get(i).getValue();
                }
                if (sumG < 17) {
                    viewModel.holdaction(sumG, cardsDealer);
                    if (sumG > 10) {
                        cardsDealer(card4G, card4Groupier, "CasinoIMG/BlackJack/Card", 1);
                    } else {
                        cardsDealer(card4G, card4Groupier, "CasinoIMG/BlackJack/Card", 11);
                    }
                    sumG = 0;
                    for (int i = 0; i < dealerCards.size(); i++) {
                        sumG += dealerCards.get(i).getValue();
                    }
                    if (sumG < 17) {
                        viewModel.holdaction(sumG, cardsDealer);
                        if (sumG > 10) {
                            cardsDealer(card5G, card5Groupier, "CasinoIMG/BlackJack/Card", 1);
                        } else {
                            cardsDealer(card5G, card5Groupier, "CasinoIMG/BlackJack/Card", 11);
                        }
                        sumG = 0;
                        for (int i = 0; i < dealerCards.size(); i++) {
                            sumG += dealerCards.get(i).getValue();
                        }
                    }
                }
            }

            sumG = 0;
            for (int i = 0; i < dealerCards.size(); i++) {
                sumG += dealerCards.get(i).getValue();
            }
            sumP = 0;
            for (int i = 0; i < playerCards.size(); i++) {
                sumP += playerCards.get(i).getValue();
            }
            //Checks Result
            checkPlayer(sumP, sumG);
            //Displays new Sum
            dealerValue.setText(Integer.toString(sumG));
            sumG = 0;
            viewModel.updatePlayer();
        }
    }

    //Dealer Actions after Double or Bust
    private void holding() throws SQLException, ClassNotFoundException {
        //Checks if Round started
        if (put == false) {
            JOptionPane.showMessageDialog(null, "Start the game first with Put", "Fail", JOptionPane.ERROR_MESSAGE);
        } else {
            doubleBtn.setDisable(true);
            holdBtn.setDisable(true);
            hitBtn.setDisable(true);
            doubleBtn.opacityProperty().set(0.5);
            hitBtn.opacityProperty().set(0.5);
            holdBtn.opacityProperty().set(0.5);
            //Lets the Dealer play
            sumG = 0;
            for (int i = 0; i < dealerCards.size(); i++) {
                sumG += dealerCards.get(i).getValue();
            }
            viewModel.holdaction(sumG, cardsDealer);            
            //Hides the second card so dealer second card revealed
            cardHide.setImage(null);
            sumG = 0;
            for (int i = 0; i < dealerCards.size(); i++) {
                sumG += dealerCards.get(i).getValue();
            }
            sumP = 0;
            for (int i = 0; i < playerCards.size(); i++) {
                sumP += playerCards.get(i).getValue();
            }
            //if player over 21 dealer takes 2 cards
            if (sumP > 21) {
                sumG = 0;
                for (int i = 0; i < dealerCards.size(); i++) {
                    sumG += dealerCards.get(i).getValue();
                    System.out.println("Values :" + dealerCards.get(i).getValue());
                }
            } else {// else he takes cards as long as he under 17
                if (sumG < 17) {
                    if (sumG > 10) {
                        cardsDealer(card3G, card3Groupier, "CasinoIMG/BlackJack/Card", 1);
                    } else {
                        cardsDealer(card3G, card3Groupier, "CasinoIMG/BlackJack/Card", 11);
                    }
                    sumG = 0;
                    for (int i = 0; i < dealerCards.size(); i++) {
                        sumG += dealerCards.get(i).getValue();
                    }
                    if (sumG < 17) {
                        viewModel.holdaction(sumG, cardsDealer);
                        if (sumG > 10) {
                            cardsDealer(card4G, card4Groupier, "CasinoIMG/BlackJack/Card", 1);
                        } else {
                            cardsDealer(card4G, card4Groupier, "CasinoIMG/BlackJack/Card", 11);
                        }
                        sumG = 0;
                        for (int i = 0; i < dealerCards.size(); i++) {
                            sumG += dealerCards.get(i).getValue();
                        }
                        if (sumG < 17) {
                            viewModel.holdaction(sumG, cardsDealer);
                            if (sumG > 10) {
                                cardsDealer(card5G, card5Groupier, "CasinoIMG/BlackJack/Card", 1);
                            } else {
                                cardsDealer(card5G, card5Groupier, "CasinoIMG/BlackJack/Card", 11);
                            }
                            sumG = 0;
                            for (int i = 0; i < dealerCards.size(); i++) {
                                sumG += dealerCards.get(i).getValue();
                            }
                        }
                    }
                } else {

                }
            }

            sumG = 0;
            for (int i = 0; i < dealerCards.size(); i++) {
                sumG += dealerCards.get(i).getValue();
            }
            sumP = 0;
            for (int i = 0; i < playerCards.size(); i++) {
                sumP += playerCards.get(i).getValue();
            }
            //Checks Result
            checkPlayer(sumP, sumG);
            //Displays Result
            dealerValue.setText(Integer.toString(sumG));
            viewModel.updatePlayer();
        }
    }
    //Takes Double Card
    @FXML
    private void doubledownAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        //Checks if the Round Started
        if (put == false) {
            JOptionPane.showMessageDialog(null, "Start the game first with Put", "Fail", JOptionPane.ERROR_MESSAGE);
        } else {
            //Doubles the Money and gives the Player the Third card plus makes the Dealer play
            sumP = 0;
            for (int i = 0; i < playerCards.size(); i++) {
                sumP += playerCards.get(i).getValue();
            }
            if (sumP > 8 && sumP < 12) {

                innerSum += creditPut;
                creditPut += creditPut;
                chipsvalue.setText(Double.toString(creditPut));
                creditPut = innerSum;

                doubleBtn.setTextFill(Color.DARKGOLDENROD);
                hitBtn.setTextFill(Color.DARKGOLDENROD);
                holdBtn.setTextFill(Color.DARKGOLDENROD);
                hitBtn.setDisable(true);
                holdBtn.setDisable(true);
                hitBtn.opacityProperty().set(0.5);
                holdBtn.opacityProperty().set(0.5);

                viewModel.doubleaction();
                cardsPlayer(cardDouble, doubleDownCard, "CasinoIMG/BlackJack/CardsDoubleDown", 11);
                sumP = 0;
                for (int i = 0; i < playerCards.size(); i++) {
                    sumP += playerCards.get(i).getValue();
                }
                playerValue.setText(Integer.toString(sumP));
                doubleActive = true;
                holding();

            } else {

            }
        }
    }   
    //Putting the Money down and starting the Game
    @FXML
    private void putAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        putBtn.setDisable(true);
        insuranceBtn.setDisable(true);
        insuranceChoice.setDisable(true);
        insuranceBtn.opacityProperty().set(0.0);
        insuranceChoice.opacityProperty().set(0.0);
        //Checks if Player broke
        if (Double.parseDouble(creditKonto.getText()) <= 0.0) {
            JOptionPane.showMessageDialog(null, "You need more Money", "Fail", JOptionPane.ERROR_MESSAGE);
        } else {
            //Checks if Money has been Put
            if (creditPut == 0.0) {
                System.out.println("Set Money Geld");
            } else {
                put = true;
                chipsActive = false;
                viewModel.play();
                //Gives the first For cards
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

                sumP = 0;
                sumG = 0;
                //Checks for Insurance Possibility
                if (dealerCards.get(0).getValue() == 11) {
                    insuranceBtn.setDisable(false);
                    insuranceBtn.opacityProperty().set(1.0);
                    insuranceChoice.setDisable(false);
                    insuranceChoice.opacityProperty().set(1.0);
                }
                for (int i = 0; i < playerCards.size(); i++) {
                    sumP += playerCards.get(i).getValue();
                }
                //Checks for Double Possibility
                if (sumP > 8 && sumP < 12) {
                    doubleBtn.setDisable(false);
                    doubleBtn.opacityProperty().set(1.0);
                }
                dealerValue.setText(Integer.toString(dealerCards.get(0).getValue()));
                playerValue.setText(Integer.toString(sumP));

                for (int i = 0; i < dealerCards.size(); i++) {
                    sumG += dealerCards.get(i).getValue();
                }
                //Checks for Blackjack
                if (sumP > 20) {
                    holding();
                    insuranceBtn.setDisable(true);
                    insuranceBtn.setVisible(false);
                    insuranceChoice.setDisable(true);
                    insuranceChoice.setVisible(false);
                    blackjack = true;
                    hitBtn.opacityProperty().set(0.5);
                }
                putBtn.opacityProperty().set(0.0);
            }
            //Checks if Picture Display has Failed
            if (card1Player.getImage() == null || card2Player.getImage() == null || card1Groupier.getImage() == null || card1Groupier.getImage() == null) {
                System.out.println("Fail");
            }
            viewModel.updatePlayer();
        }
    }

    //Checks who Won and put Money into DataBase
    //Resets everything to play on
    private void checkPlayer(int sumP, int sumG) throws SQLException, ClassNotFoundException {
        boolean notNegativeP = false;
        boolean notNegativeG = false;
        //Looks if Player over 21
        if (21 - sumP < 0) {
            System.out.println("Lost");
            endLbl.setText("LOST");
            notNegativeP = true;
            
            if (insuranceActive == true) {
                insuranceMethod(insuranceMoneyPut);
            } else {
                System.out.println("");
            }
            
            if (doubleActive == true) {
                creditHere -= creditPut;
                creditHere -= creditPut;
                viewModel.setNewStatitcs((creditPut * 2), false, insuranceWoL, insuranceMoneyPut,false);
            } else {
                creditHere -= creditPut;
                viewModel.setNewStatitcs(creditPut, false, insuranceWoL, insuranceMoneyPut,false);
            }
            viewModel.setNewCredit(creditHere);
        } else {
            notNegativeP = false;
        }
        //Looks if Dealer over 21
        if (21 - sumG < 0) {
            notNegativeG = true;
            System.out.println("You Won");
            endLbl.setText("WON");
            
            if (insuranceActive == true) {
                insuranceMethod(insuranceMoneyPut);
            } else {
                System.out.println("");
            }
            
            if (doubleActive == true) {
                creditHere += creditPut;
                creditHere += creditPut;
                viewModel.setNewStatitcs((creditPut * 2), true, insuranceWoL, insuranceMoneyPut,false);
            } else {
                if (blackjack == true) {
                    creditHere += creditPut;
                    creditHere += (creditPut / 2);
                    viewModel.setNewStatitcs(creditPut + (creditPut / 2), true, insuranceWoL, insuranceMoneyPut,false);
                } else {
                    creditHere += creditPut;
                    viewModel.setNewStatitcs(creditPut, true, insuranceWoL, insuranceMoneyPut,false);
                }
            }
            viewModel.setNewCredit(creditHere);
        } else {
            notNegativeG = false;
        }
        //Happens if both under 21
        if (notNegativeP == false && notNegativeG == false) {
            if (21 - sumP < 21 - sumG) {
                System.out.println("Won");
                endLbl.setText("WON");
                
                if (insuranceActive == true) {
                    insuranceMethod(insuranceMoneyPut);
                } else {
                    System.out.println("");
                }
                
                if (doubleActive == true) {
                    creditHere += creditPut;
                    creditHere += creditPut;
                    viewModel.setNewStatitcs((creditPut * 2), true, insuranceWoL, insuranceMoneyPut,false);
                } else {
                    if (blackjack == true) {
                        creditHere += creditPut;
                        creditHere += (creditPut / 2);
                        viewModel.setNewStatitcs(creditPut + (creditPut / 2), true, insuranceWoL, insuranceMoneyPut,false);
                    } else {
                        creditHere += creditPut;
                        viewModel.setNewStatitcs(creditPut, true, insuranceWoL, insuranceMoneyPut,false);
                    }
                }
                viewModel.setNewCredit(creditHere);
            } else if (21 - sumP > 21 - sumG) {
                System.out.println("You Lost");
                endLbl.setText("LOST");
                
                if (insuranceActive == true) {
                    insuranceMethod(insuranceMoneyPut);
                } else {
                    System.out.println("");
                }
                
                if (doubleActive == true) {
                    creditHere -= creditPut;
                    creditHere -= creditPut;
                    viewModel.setNewStatitcs((creditPut * 2), false, insuranceWoL, insuranceMoneyPut,false);
                } else {
                    creditHere -= creditPut;
                    viewModel.setNewStatitcs(creditPut, false, insuranceWoL, insuranceMoneyPut,false);
                }
                viewModel.setNewCredit(creditHere);
            } else {
                //todo
                System.out.println("Even");
                endLbl.setText("EVEN!!!");
                if (insuranceActive == true) {
                    insuranceMethod(insuranceMoneyPut);
                } else {
                    System.out.println("");
                }
                viewModel.setNewStatitcs(creditPut, false, insuranceWoL, insuranceMoneyPut,true);
                
                viewModel.setNewCredit(creditHere);
            }
        }
        //Makes checkPlayer true because the Check of the Sums and the round itself is done
        checkPlayer = true;
    }
    //Insurance Button Saves Insurance Amount and sets the Boolean Insurance on True
    @FXML
    private void insurance(ActionEvent event) {
        if (insuranceChoice.getValue() == 0) {
            JOptionPane.showMessageDialog(null, "Select amount", "Fail", JOptionPane.ERROR_MESSAGE);
        } else {
            insuranceBtn.setTextFill(Color.FUCHSIA);
            insuranceActive = true;
            insuranceMoneyPut = insuranceChoice.getValue();
            double bank = Double.parseDouble(creditKonto.getText()) - creditPut;
            //if not Enough Money shows Message
            if (bank < insuranceMoneyPut) {
                insuranceActive = false;
                insuranceBtn.setTextFill(Color.WHITE);
                JOptionPane.showMessageDialog(null, "Not enough Money", "Fail", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //Insurance Methode to Connect with Model
    private void insuranceMethod(double credit) throws SQLException, ClassNotFoundException {
        sumG = 0;
        for (int i = 0; i < dealerCards.size(); i++) {
            sumG += dealerCards.get(i).getValue();
        }
        //viewModel.insurance(credit, sumG);
        //Checks if Dealer has 21 to Add or Substract Money from Credit
        if (sumG == 21) {
            creditHere += credit;
            insuranceWoL = true;
        } else {
            creditHere -= credit;
            insuranceWoL = false;
        }
    }
    //Closes the Programm
    @FXML
    private void closeBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
       //if Player already ended the Round nothing happens if not he looses that Money he put on the Table
        if (checkPlayer = true) {
            System.exit(0);
        } else {
            creditHere -= creditPut;
            viewModel.setNewCredit(creditHere);
            System.exit(0);
        }
    }
    //Resets everything
    @FXML
    private void reset(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        if (checkPlayer == true) {

        } else {
            creditHere -= creditPut;
            viewModel.setNewCredit(creditHere);
        }
        hitBtn.setDisable(false);
        hitBtn.opacityProperty().set(1.0);
        hitBtn.textFillProperty().set(Color.WHITE);
        holdBtn.setDisable(false);
        holdBtn.opacityProperty().set(1.0);
        holdBtn.textFillProperty().set(Color.WHITE);
        doubleBtn.setDisable(true);
        doubleBtn.opacityProperty().set(0.1);
        doubleBtn.textFillProperty().set(Color.WHITE);
        putBtn.setDisable(false);
        putBtn.opacityProperty().set(1.0);
        putBtn.textFillProperty().set(Color.WHITE);
        backBtn.setDisable(false);
        backBtn.opacityProperty().set(1.0);
        backBtn.textFillProperty().set(Color.WHITE);
        insuranceBtn.setDisable(true);
        insuranceBtn.opacityProperty().set(0.0);
        insuranceBtn.textFillProperty().set(Color.WHITE);
        insuranceChoice.setDisable(true);
        insuranceChoice.opacityProperty().set(0.0);
        insuranceChoice.getSelectionModel().clearSelection();
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
        playerValue.setText(null);
        dealerValue.setText(null);
        playerCards.clear();
        checkPlayer = false;
        dealerCards.clear();
        doubleActive = false;
        insuranceActive = false;
        insuranceMoneyPut = 0.0;
        innerSum = 0;
        creditPut = 0.0;
        chipAmount = 0;
        chipsvalue.setText(null);
        cardsHit = 0;
        cardsDealer = 1;
        cardsTaken = 0;
        putBtn.setDisable(false);
        put = false;
        chipsActive = true;
        //Gets the newest Credit of the Player again
        creditKonto.textProperty().bind(viewModel.getCredit());
        creditHere = Double.parseDouble(creditKonto.getText());
        insuranceWoL=false;
    }
    //Displays Chips if Pressed
    @FXML
    private void chip10(MouseEvent event) {
        if (chipsActive == true) {
            double credit = Double.parseDouble(creditKonto.getText());
            double sum = creditPut + 10.0;
            //Looks if enough Credit
            if (credit <= 0.0 || credit < 10.0 || credit < sum) {
                JOptionPane.showMessageDialog(null, "You need Money", "Fehler", JOptionPane.ERROR_MESSAGE);
            } else {
                //Put more Credit
                creditPut += 10.0;
                chipsvalue.setText(Double.toString(creditPut));
                chipAmount++;
                //Displays Different next Chip on the Table
                switch (chipAmount) {
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
        }
    }
    //Displays Chips if Pressed
    @FXML
    private void chip50(MouseEvent event) {
        if (chipsActive == true) {
            double credit = Double.parseDouble(creditKonto.getText());
            double sum = creditPut + 50.0;
            //Looks if enough Credit
            if (credit <= 0.0 || credit < 50.0 || credit < sum) {
                JOptionPane.showMessageDialog(null, "You need Money", "Fail", JOptionPane.ERROR_MESSAGE);
            } else {
                 //Put more Credit
                creditPut += 50.0;
                chipsvalue.setText(Double.toString(creditPut));
                chipAmount++;
                //Displays Different next Chip on the Table
                switch (chipAmount) {
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
        }
    }
    //Displays Chips if Pressed
    @FXML
    private void chip100(MouseEvent event) {
        if (chipsActive == true) {
            double credit = Double.parseDouble(creditKonto.getText());
            double sum = creditPut + 100.0;
            //Looks if enough Credit
            if (credit <= 0.0 || credit < 100.0 || credit < sum) {
                JOptionPane.showMessageDialog(null, "You need Money", "Fail", JOptionPane.ERROR_MESSAGE);
            } else {
                 //Put more Credit
                creditPut += 100.0;
                chipsvalue.setText(Double.toString(creditPut));
                chipAmount++;
                //Displays Different next Chip on the Table
                switch (chipAmount) {
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
        }
    }
    //Displays Chips if Pressed
    @FXML
    private void chip250(MouseEvent event) {
        if (chipsActive == true) {
            double credit = Double.parseDouble(creditKonto.getText());
            double sum = creditPut + 250.0;
            //Looks if enough Credit
            if (credit <= 0.0 || credit < 250.0 || credit < sum) {
                JOptionPane.showMessageDialog(null, "You need Money", "Fail", JOptionPane.ERROR_MESSAGE);
            } else {
                 //Put more Credit
                creditPut += 250.0;
                chipsvalue.setText(Double.toString(creditPut));
                chipAmount++;
                //Displays Different next Chip on the Table                
                switch (chipAmount) {
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
        }
    }
    //Displays Chips if Pressed
    @FXML
    private void chip1000(MouseEvent event) {
        if (chipsActive == true) {
            double credit = Double.parseDouble(creditKonto.getText());
            double sum = creditPut + 1000.0;
            //Looks if enough Credit
            if (credit <= 0.0 || credit < 1000.0 || credit < sum) {
                JOptionPane.showMessageDialog(null, "You need Money", "Fail", JOptionPane.ERROR_MESSAGE);
            } else {
                 //Put more Credit
                creditPut += 1000.0;
                chipsvalue.setText(Double.toString(creditPut));
                chipAmount++;
                //Displays Different next Chip on the Table                
                switch (chipAmount) {
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
        }
    }

    //Displays Cards of the Player
    private void cardsPlayer(IntegerProperty card, ImageView cardView, String set, int aceValue) {
        cardsHit++;
        //Checks what Random Number is given and what Card is taken
        switch (card.get()) {
            case 1:
                cardView.setImage(new Image(set + "/2C.png"));
                cardsTaken++;
                //Adds a new Card to the ArrrayList of PlayerCards
                playerCards.add(new Cards(1, 2));
                break;
            case 2:
                cardView.setImage(new Image(set + "/2D.png"));
                cardsTaken++;

                playerCards.add(new Cards(2, 2));
                break;

            case 3:
                cardView.setImage(new Image(set + "/2H.png"));
                cardsTaken++;

                playerCards.add(new Cards(3, 2));
                break;
            case 4:
                cardView.setImage(new Image(set + "/2S.png"));
                cardsTaken++;

                playerCards.add(new Cards(4, 2));
                break;
            case 5:
                cardView.setImage(new Image(set + "/3C.png"));
                cardsTaken++;

                playerCards.add(new Cards(5, 3));
                break;
            case 6:
                cardView.setImage(new Image(set + "/3D.png"));
                cardsTaken++;

                playerCards.add(new Cards(6, 3));
                break;
            case 7:
                cardView.setImage(new Image(set + "/3H.png"));
                cardsTaken++;

                playerCards.add(new Cards(7, 3));
                break;
            case 8:
                cardView.setImage(new Image(set + "/3S.png"));
                cardsTaken++;

                playerCards.add(new Cards(8, 3));
                break;
            case 9:
                cardView.setImage(new Image(set + "/4C.png"));
                cardsTaken++;

                playerCards.add(new Cards(9, 4));
                break;
            case 10:
                cardView.setImage(new Image(set + "/4D.png"));
                cardsTaken++;

                playerCards.add(new Cards(10, 4));
                break;
            case 11:
                cardView.setImage(new Image(set + "/4H.png"));
                cardsTaken++;

                playerCards.add(new Cards(11, 4));
                break;
            case 12:
                cardView.setImage(new Image(set + "/4S.png"));
                cardsTaken++;

                playerCards.add(new Cards(12, 4));
                break;
            case 13:
                cardView.setImage(new Image(set + "/5C.png"));
                cardsTaken++;

                playerCards.add(new Cards(13, 5));
                break;
            case 14:
                cardView.setImage(new Image(set + "/5D.png"));
                cardsTaken++;

                playerCards.add(new Cards(14, 5));
                break;
            case 15:
                cardView.setImage(new Image(set + "/5H.png"));
                cardsTaken++;

                playerCards.add(new Cards(15, 5));
                break;
            case 16:
                cardView.setImage(new Image(set + "/5S.png"));
                cardsTaken++;

                playerCards.add(new Cards(16, 5));
                break;
            case 17:
                cardView.setImage(new Image(set + "/6C.png"));
                cardsTaken++;

                playerCards.add(new Cards(17, 6));
                break;
            case 18:
                cardView.setImage(new Image(set + "/6D.png"));
                cardsTaken++;

                playerCards.add(new Cards(18, 6));
                break;
            case 19:
                cardView.setImage(new Image(set + "/6H.png"));
                cardsTaken++;

                playerCards.add(new Cards(19, 6));
                break;
            case 20:
                cardView.setImage(new Image(set + "/6S.png"));
                cardsTaken++;

                playerCards.add(new Cards(20, 6));
                break;
            case 21:
                cardView.setImage(new Image(set + "/7C.png"));
                cardsTaken++;

                playerCards.add(new Cards(21, 7));
                break;
            case 22:
                cardView.setImage(new Image(set + "/7D.png"));
                cardsTaken++;

                playerCards.add(new Cards(22, 7));
                break;
            case 23:
                cardView.setImage(new Image(set + "/7H.png"));
                cardsTaken++;

                playerCards.add(new Cards(23, 7));
                break;
            case 24:
                cardView.setImage(new Image(set + "/7S.png"));
                cardsTaken++;

                playerCards.add(new Cards(24, 7));
                break;
            case 25:
                cardView.setImage(new Image(set + "/8C.png"));
                cardsTaken++;

                playerCards.add(new Cards(25, 8));
                break;
            case 26:
                cardView.setImage(new Image(set + "/8D.png"));
                cardsTaken++;

                playerCards.add(new Cards(26, 8));
                break;
            case 27:
                cardView.setImage(new Image(set + "/8H.png"));
                cardsTaken++;

                playerCards.add(new Cards(27, 8));
                break;
            case 28:
                cardView.setImage(new Image(set + "/8S.png"));
                cardsTaken++;

                playerCards.add(new Cards(28, 8));
                break;
            case 29:
                cardView.setImage(new Image(set + "/9C.png"));
                cardsTaken++;

                playerCards.add(new Cards(29, 9));
                break;
            case 30:
                cardView.setImage(new Image(set + "/9D.png"));
                cardsTaken++;

                playerCards.add(new Cards(30, 9));
                break;
            case 31:
                cardView.setImage(new Image(set + "/9H.png"));
                cardsTaken++;

                playerCards.add(new Cards(31, 9));
                break;
            case 32:
                cardView.setImage(new Image(set + "/9S.png"));
                cardsTaken++;

                playerCards.add(new Cards(32, 9));
                break;
            case 33:
                cardView.setImage(new Image(set + "/10C.png"));
                cardsTaken++;

                playerCards.add(new Cards(33, 10));
                break;
            case 34:
                cardView.setImage(new Image(set + "/10D.png"));
                cardsTaken++;

                playerCards.add(new Cards(34, 10));
                break;
            case 35:
                cardView.setImage(new Image(set + "/10H.png"));
                cardsTaken++;

                playerCards.add(new Cards(35, 10));
                break;
            case 36:
                cardView.setImage(new Image(set + "/10S.png"));
                cardsTaken++;

                playerCards.add(new Cards(36, 10));
                break;
            case 37:
                cardView.setImage(new Image(set + "/AC.png"));
                cardsTaken++;

                playerCards.add(new Cards(37, aceValue));
                break;
            case 38:
                cardView.setImage(new Image(set + "/AD.png"));
                cardsTaken++;

                playerCards.add(new Cards(38, aceValue));
                break;
            case 39:
                cardView.setImage(new Image(set + "/AH.png"));
                cardsTaken++;

                playerCards.add(new Cards(39, aceValue));
                break;
            case 40:
                cardView.setImage(new Image(set + "/AS.png"));
                cardsTaken++;

                playerCards.add(new Cards(40, aceValue));
                break;
            case 41:
                cardView.setImage(new Image(set + "/JC.png"));
                cardsTaken++;

                playerCards.add(new Cards(41, 10));
                break;
            case 42:
                cardView.setImage(new Image(set + "/JD.png"));
                cardsTaken++;

                playerCards.add(new Cards(42, 10));
                break;
            case 43:
                cardView.setImage(new Image(set + "/JH.png"));
                cardsTaken++;

                playerCards.add(new Cards(43, 10));
                break;
            case 44:
                cardView.setImage(new Image(set + "/JS.png"));
                cardsTaken++;

                playerCards.add(new Cards(44, 10));
                break;
            case 45:
                cardView.setImage(new Image(set + "/KC.png"));
                cardsTaken++;

                playerCards.add(new Cards(45, 10));
                break;
            case 46:
                cardView.setImage(new Image(set + "/KD.png"));
                cardsTaken++;

                playerCards.add(new Cards(46, 10));
                break;
            case 47:
                cardView.setImage(new Image(set + "/KH.png"));
                cardsTaken++;

                playerCards.add(new Cards(47, 10));
                break;
            case 48:
                cardView.setImage(new Image(set + "/KS.png"));
                cardsTaken++;

                playerCards.add(new Cards(48, 10));
                break;
            case 49:
                cardView.setImage(new Image(set + "/QC.png"));
                cardsTaken++;

                playerCards.add(new Cards(49, 10));
                break;
            case 50:
                cardView.setImage(new Image(set + "/QD.png"));
                cardsTaken++;

                playerCards.add(new Cards(50, 10));
                break;
            case 51:
                cardView.setImage(new Image(set + "/QH.png"));
                cardsTaken++;

                playerCards.add(new Cards(51, 10));
                break;
            case 52:
                cardView.setImage(new Image(set + "/QS.png"));
                cardsTaken++;

                playerCards.add(new Cards(51, 10));
                break;
        }
    }
    //Displays Cards of Dealer
    private void cardsDealer(IntegerProperty card, ImageView cardView, String set, int aceValue) {
        cardsDealer++;
        //Checks what Random Number is given and what Card is taken
        switch (card.get()) {
            case 1:
                cardView.setImage(new Image(set + "/2C.png"));
                cardsTaken++;
                //Adds a new Card to the ArrrayList of DealerCards
                dealerCards.add(new Cards(1, 2));
                break;
            case 2:
                cardView.setImage(new Image(set + "/2D.png"));
                cardsTaken++;

                dealerCards.add(new Cards(2, 2));
                break;

            case 3:
                cardView.setImage(new Image(set + "/2H.png"));
                cardsTaken++;

                dealerCards.add(new Cards(3, 2));
                break;
            case 4:
                cardView.setImage(new Image(set + "/2S.png"));
                cardsTaken++;

                dealerCards.add(new Cards(4, 2));
                break;
            case 5:
                cardView.setImage(new Image(set + "/3C.png"));
                cardsTaken++;

                dealerCards.add(new Cards(5, 3));
                break;
            case 6:
                cardView.setImage(new Image(set + "/3D.png"));
                cardsTaken++;

                dealerCards.add(new Cards(6, 3));
                break;
            case 7:
                cardView.setImage(new Image(set + "/3H.png"));
                cardsTaken++;

                dealerCards.add(new Cards(7, 3));
                break;
            case 8:
                cardView.setImage(new Image(set + "/3S.png"));
                cardsTaken++;

                dealerCards.add(new Cards(8, 3));
                break;
            case 9:
                cardView.setImage(new Image(set + "/4C.png"));
                cardsTaken++;

                dealerCards.add(new Cards(9, 4));
                break;
            case 10:
                cardView.setImage(new Image(set + "/4D.png"));
                cardsTaken++;

                dealerCards.add(new Cards(10, 4));
                break;
            case 11:
                cardView.setImage(new Image(set + "/4H.png"));
                cardsTaken++;

                dealerCards.add(new Cards(11, 4));
                break;
            case 12:
                cardView.setImage(new Image(set + "/4S.png"));
                cardsTaken++;

                dealerCards.add(new Cards(12, 4));
                break;
            case 13:
                cardView.setImage(new Image(set + "/5C.png"));
                cardsTaken++;

                dealerCards.add(new Cards(13, 5));
                break;
            case 14:
                cardView.setImage(new Image(set + "/5D.png"));
                cardsTaken++;

                dealerCards.add(new Cards(14, 5));
                break;
            case 15:
                cardView.setImage(new Image(set + "/5H.png"));
                cardsTaken++;

                dealerCards.add(new Cards(15, 5));
                break;
            case 16:
                cardView.setImage(new Image(set + "/5S.png"));
                cardsTaken++;

                dealerCards.add(new Cards(16, 5));
                break;
            case 17:
                cardView.setImage(new Image(set + "/6C.png"));
                cardsTaken++;

                dealerCards.add(new Cards(17, 6));
                break;
            case 18:
                cardView.setImage(new Image(set + "/6D.png"));
                cardsTaken++;

                dealerCards.add(new Cards(18, 6));
                break;
            case 19:
                cardView.setImage(new Image(set + "/6H.png"));
                cardsTaken++;

                dealerCards.add(new Cards(19, 6));
                break;
            case 20:
                cardView.setImage(new Image(set + "/6S.png"));
                cardsTaken++;

                dealerCards.add(new Cards(20, 6));
                break;
            case 21:
                cardView.setImage(new Image(set + "/7C.png"));
                cardsTaken++;

                dealerCards.add(new Cards(21, 7));
                break;
            case 22:
                cardView.setImage(new Image(set + "/7D.png"));
                cardsTaken++;

                dealerCards.add(new Cards(22, 7));
                break;
            case 23:
                cardView.setImage(new Image(set + "/7H.png"));
                cardsTaken++;

                dealerCards.add(new Cards(23, 7));
                break;
            case 24:
                cardView.setImage(new Image(set + "/7S.png"));
                cardsTaken++;

                dealerCards.add(new Cards(24, 7));
                break;
            case 25:
                cardView.setImage(new Image(set + "/8C.png"));
                cardsTaken++;

                dealerCards.add(new Cards(25, 8));
                break;
            case 26:
                cardView.setImage(new Image(set + "/8D.png"));
                cardsTaken++;

                dealerCards.add(new Cards(26, 8));
                break;
            case 27:
                cardView.setImage(new Image(set + "/8H.png"));
                cardsTaken++;

                dealerCards.add(new Cards(27, 8));
                break;
            case 28:
                cardView.setImage(new Image(set + "/8S.png"));
                cardsTaken++;

                dealerCards.add(new Cards(28, 8));
                break;
            case 29:
                cardView.setImage(new Image(set + "/9C.png"));
                cardsTaken++;

                dealerCards.add(new Cards(29, 9));
                break;
            case 30:
                cardView.setImage(new Image(set + "/9D.png"));
                cardsTaken++;

                dealerCards.add(new Cards(30, 9));
                break;
            case 31:
                cardView.setImage(new Image(set + "/9H.png"));
                cardsTaken++;

                dealerCards.add(new Cards(31, 9));
                break;
            case 32:
                cardView.setImage(new Image(set + "/9S.png"));
                cardsTaken++;

                dealerCards.add(new Cards(32, 9));
                break;
            case 33:
                cardView.setImage(new Image(set + "/10C.png"));
                cardsTaken++;

                dealerCards.add(new Cards(33, 10));
                break;
            case 34:
                cardView.setImage(new Image(set + "/10D.png"));
                cardsTaken++;

                dealerCards.add(new Cards(34, 10));
                break;
            case 35:
                cardView.setImage(new Image(set + "/10H.png"));
                cardsTaken++;

                dealerCards.add(new Cards(35, 10));
                break;
            case 36:
                cardView.setImage(new Image(set + "/10S.png"));
                cardsTaken++;

                dealerCards.add(new Cards(36, 10));
                break;
            case 37:
                cardView.setImage(new Image(set + "/AC.png"));
                cardsTaken++;

                dealerCards.add(new Cards(37, aceValue));
                break;
            case 38:
                cardView.setImage(new Image(set + "/AD.png"));
                cardsTaken++;

                dealerCards.add(new Cards(38, aceValue));
                break;
            case 39:
                cardView.setImage(new Image(set + "/AH.png"));
                cardsTaken++;

                dealerCards.add(new Cards(39, aceValue));
                break;
            case 40:
                cardView.setImage(new Image(set + "/AS.png"));
                cardsTaken++;

                dealerCards.add(new Cards(40, aceValue));
                break;
            case 41:
                cardView.setImage(new Image(set + "/JC.png"));
                cardsTaken++;

                dealerCards.add(new Cards(41, 10));
                break;
            case 42:
                cardView.setImage(new Image(set + "/JD.png"));
                cardsTaken++;

                dealerCards.add(new Cards(42, 10));
                break;
            case 43:
                cardView.setImage(new Image(set + "/JH.png"));
                cardsTaken++;

                dealerCards.add(new Cards(43, 10));
                break;
            case 44:
                cardView.setImage(new Image(set + "/JS.png"));
                cardsTaken++;

                dealerCards.add(new Cards(44, 10));
                break;
            case 45:
                cardView.setImage(new Image(set + "/KC.png"));
                cardsTaken++;

                dealerCards.add(new Cards(45, 10));
                break;
            case 46:
                cardView.setImage(new Image(set + "/KD.png"));
                cardsTaken++;

                dealerCards.add(new Cards(46, 10));
                break;
            case 47:
                cardView.setImage(new Image(set + "/KH.png"));
                cardsTaken++;

                dealerCards.add(new Cards(47, 10));
                break;
            case 48:
                cardView.setImage(new Image(set + "/KS.png"));
                cardsTaken++;

                dealerCards.add(new Cards(48, 10));
                break;
            case 49:
                cardView.setImage(new Image(set + "/QC.png"));
                cardsTaken++;

                dealerCards.add(new Cards(49, 10));
                break;
            case 50:
                cardView.setImage(new Image(set + "/QD.png"));
                cardsTaken++;

                dealerCards.add(new Cards(50, 10));
                break;
            case 51:
                cardView.setImage(new Image(set + "/QH.png"));
                cardsTaken++;

                dealerCards.add(new Cards(51, 10));
                break;
            case 52:
                cardView.setImage(new Image(set + "/QS.png"));
                cardsTaken++;

                dealerCards.add(new Cards(51, 10));
                break;
        }
    }
    //Goes back to the Menu
    @FXML
    private void backToMenu(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        //Checks if Mid Round or the end of the Round
        if (checkPlayer == true) {
            viewModel.backToMenu();
        } else { 
            //Takes away the Money because he Left the game
            creditHere -= creditPut;
            viewModel.setNewCredit(creditHere);
            viewModel.backToMenu();
        }
    }

}
