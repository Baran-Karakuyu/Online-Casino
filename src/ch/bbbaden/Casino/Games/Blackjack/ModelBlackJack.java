/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Blackjack;

import Casino.DataBase.Query;
import Casino.DataBase.User;
import ch.bbbaden.Casino.MainApp;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Andrei Oleniuc
 */
public class ModelBlackJack {

    //Changes used for MVVM to Bring Data to the Listener in this case the ViewModelBlackjack
    protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    //The MainApp, is here to be able to go back to the Menu or to different games/views
    private MainApp mainApp;
    //Query Class which Handles Database operation 
    private final Query sql = new Query();
    //Our User that Plays right now
    private User player;
    
    //The Taken Card which saves the random number
    private int card = 0;
    private Double dbCredit = 0.0;
    private Random r = new Random();
    //Represents all already taken Cards
    private ArrayList<Integer> allCards = new ArrayList<>();
    
    //Starts the game after the Money has been Put
    public void play() throws SQLException, ClassNotFoundException {
        if (sql.getCreditUser(player.getName()) <= 0) {
            System.out.println("Not enough Money");
        } else {
            allCards.clear();
            sql.updateUser();
            int oldcard = card;
            card = newCard();
            changes.firePropertyChange("card1P", oldcard, card);
            card = newCard();
            changes.firePropertyChange("card1G", oldcard, card);
            card = newCard();
            changes.firePropertyChange("card2P", oldcard, card);
            card = newCard();
            changes.firePropertyChange("card2G", oldcard, card);
        }
    }
    //Transer the Credit over to the Local Files
    public void credit() throws SQLException, ClassNotFoundException {
        userDataTransfer();
    }
    
    //Handles the event of taking cards in case of the Player
    public void hitaction(int cardshit) {
        int oldcard = card;
        switch (cardshit) {
            case 2:
                card = newCard();
                changes.firePropertyChange("card3P", oldcard, card);
                break;
            case 3:
                card = newCard();
                changes.firePropertyChange("card4P", oldcard, card);
                break;
            case 4:
                card = newCard();
                changes.firePropertyChange("card5P", oldcard, card);
                break;
        }
    }
    //Handles the event of taking cards in case of the Dealer
    public void holdaction(int sumGroupier, int idcard) {
        int oldcard = card;
        if (sumGroupier < 17) {
            card = newCard();
            changes.firePropertyChange("card" + idcard + "G", oldcard, card);
        }
    }
    
    //Handles the event of taking the double down Card
    public void doubleAction() {
        int oldcard = card;
        card = newCard();
        changes.firePropertyChange("cardDouble", oldcard, card);
    }

    //Sets the Credit from DB to View
    public void userDataTransfer() throws SQLException, ClassNotFoundException {
        String oldcredit = "";
        sql.updateUser();
        dbCredit = sql.getCreditUser(player.getName());
        changes.firePropertyChange("credit", oldcredit, Double.toString(dbCredit));
    }

    //Sets the new Credit 
    public void setNewCredit(double credit) throws SQLException, ClassNotFoundException {
        String oldcredit = "";
        sql.updateCredit(credit, player.getName());
        changes.firePropertyChange("credit", oldcredit, Double.toString(credit));
    }
    //The Listener listenes to these Changes
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }
    //Sets MainApp
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    //Lets the User go back to the Menu
    public void backToMenu() throws IOException, SQLException, ClassNotFoundException {
        mainApp.startMenu();
    }
    
    //Takes a new Card that hasent been already taken
    private int newCard() {
        int cardTaken = 0;
        cardTaken = r.nextInt(52) + 1;
        for (Integer allCard : allCards) {
            if (allCard.equals(cardTaken)) {
                cardTaken = r.nextInt(52) + 1;
                if (allCard.equals(cardTaken)) {
                    cardTaken = r.nextInt(52) + 1;
                    if (allCard.equals(cardTaken)) {
                        cardTaken = r.nextInt(52) + 1;
                    }
                }
            }
        }
        allCards.add(cardTaken);
        return cardTaken;
    }
    //Sets the User and Displays it
    public void setUser(User user) {
        this.player = user;
        changes.firePropertyChange("name", "", this.player.getName());
    }
    //Updates the Statistics of the Player and the game after every round ends
    public void statistics(double creditput, boolean winorlose, boolean insuranceWoL, double insuranceMoney,boolean even) throws SQLException, ClassNotFoundException {
        if (even==true) {
            if(insuranceMoney==0){
                
            }else{
                if (insuranceWoL == true) {
                    player.userStats(2, player.getUid(), creditput+insuranceMoney, insuranceMoney, 0.0);
                } else { 
                    player.userStats(2, player.getUid(), creditput+insuranceMoney, 0.0, insuranceMoney);
                }
            }
        } else {
            if (insuranceMoney == 0) {// No Money in Insurance so No Insurance
                if (winorlose == true) { //He wins
                    player.userStats(2, player.getUid(), creditput, creditput, 0.0);
                } else { //He Loses
                    player.userStats(2, player.getUid(), creditput, 0.0, creditput);
                }
            } else {
                if (insuranceWoL == true) {// Money in Insurance so Insurance and he won Insurance
                    if (winorlose == true) {//He wins the Game
                        player.userStats(2, player.getUid(), creditput + insuranceMoney, creditput + insuranceMoney, 0.0); //Correct
                    } else { //He loses the game
                        if (insuranceMoney > creditput) { //He loses but he won the Insurance if the Insurance is higher then his Bet
                            player.userStats(2, player.getUid(), creditput + insuranceMoney, insuranceMoney - creditput, 0.0);
                        } else if (insuranceMoney < creditput) { //He loses but he won the Insurance if the Bet Money is higher then the Insurance 
                            player.userStats(2, player.getUid(), creditput + insuranceMoney, 0.0, creditput - insuranceMoney);
                        } else { //He Loses and the Insurance and the Bet Money are the same so he doesnt win money nor loose so 0.0
                            player.userStats(2, player.getUid(), creditput + insuranceMoney, 0.0, 0.0);
                        }
                    }
                } else { // Money in Insurance but he didnt Win insurance
                    if (winorlose == true) {//If Player Wins
                        if (insuranceMoney > creditput) {//If the Insurance is higher then the Credit
                            player.userStats(2, player.getUid(), creditput + insuranceMoney, 0.0, insuranceMoney - creditput);
                        } else if (insuranceMoney < creditput) {//If the Insurance is lower then the Credit
                            player.userStats(2, player.getUid(), creditput + insuranceMoney, creditput - insuranceMoney, 0.0);
                        } else {//If they are the Same
                            player.userStats(2, player.getUid(), creditput + insuranceMoney, 0.0, 0.0);
                        }
                    } else {//if he loses and the insurance too
                        player.userStats(2, player.getUid(), creditput + insuranceMoney, 0.0, creditput + insuranceMoney);
                    }
                }
            }
        }
    }
}
