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

    protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private MainApp mainApp;
    private final Query sql = new Query();
    private ArrayList<User> users = new ArrayList<>();
    private int card = 0;
    private User player;
    private Double dbCredit = 0.0;
    private Random r = new Random();
    private ArrayList<Integer> allCards = new ArrayList<>();

    public void play() throws SQLException, ClassNotFoundException {
        if (sql.getCreditUser(player.getName()) <= 0) {
            System.out.println("YOU BROKE ASS");
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

    public void credit() throws SQLException, ClassNotFoundException {
        userDataTransfer();
    }

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

    public void holdaction(int sumGroupier, int idcard) {
        int oldcard = card;
        if (sumGroupier < 17) {
            card = newCard();
            changes.firePropertyChange("card" + idcard + "G", oldcard, card);
        }
    }

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

    //todo
//    public void insurance(double credit, int sum) throws SQLException, ClassNotFoundException {
//        double credits = 0;
//        credits = sql.getCreditUser(player.getName());
//        if (sum == 21) {
//            credits += credit;
//        } else {
//            credits -= credit;
//        }
//        setNewCredit(credits);
//    }
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void backToMenu() throws IOException, SQLException, ClassNotFoundException {
        mainApp.startMenu();
    }

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

    public void setUser(User user) {
        this.player = user;
        changes.firePropertyChange("name", "", this.player.getName());
    }

    public void statistics(double creditput, boolean winorlose, boolean insuranceWoL, double insuranceMoney) throws SQLException, ClassNotFoundException {
        if (insuranceMoney == 0) {// No Money in Insurance so No Insurance
            if (winorlose == true) { //He wins
                player.userStats(2, player.getUid(), creditput, creditput, 0.0);
            } else { //He Loses
                player.userStats(2, player.getUid(), creditput, 0.0, creditput);
            }
        } else {
            if (insuranceWoL == true) {// Money in Insurance so Insurance and he won Insurance
                if (winorlose == true) {//He wins the Game
                    player.userStats(2, player.getUid(), creditput+insuranceMoney, creditput+insuranceMoney, 0.0); //Correct
                } else { //He loses the game
                    if(insuranceMoney>creditput){ //He loses but he won the Insurance if the Insurance is higher then his Bet
                        player.userStats(2, player.getUid(), creditput+insuranceMoney,  insuranceMoney-creditput,0.0);
                    }else if(insuranceMoney<creditput){ //He loses but he won the Insurance if the Bet Money is higher then the Insurance 
                        player.userStats(2, player.getUid(), creditput+insuranceMoney,  0.0, creditput-insuranceMoney);
                    }else{ //He Loses and the Insurance and the Bet Money are the same so he doesnt win money nor loose so 0.0
                         player.userStats(2, player.getUid(), creditput+insuranceMoney,  0.0, 0.0);
                    }     
                }
            }else{ // Money in Insurance but he didnt Win insurance
               if (winorlose == true) {//If Player Wins
                   if(insuranceMoney>creditput){//If the Insurance is higher then the Credit
                       player.userStats(2, player.getUid(), creditput+insuranceMoney, 0.0, insuranceMoney-creditput);
                   }else if(insuranceMoney<creditput){//If the Insurance is lower then the Credit
                       player.userStats(2, player.getUid(), creditput+insuranceMoney, creditput-insuranceMoney, 0.0);
                   }else{//If they are the Same
                       player.userStats(2, player.getUid(), creditput+insuranceMoney, 0.0, 0.0);
                   }
                } else {//if he loses and the insurance too
                    player.userStats(2, player.getUid(), creditput+insuranceMoney, 0.0, creditput+insuranceMoney);
                } 
            }
        }

    }
}
