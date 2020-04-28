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
    public void insurance(double credit, int sum) throws SQLException, ClassNotFoundException {
        double credits = 0;
        credits = sql.getCreditUser(player.getName());
        if (sum == 21) {
            credits += credit;
        } else {
            credits -= credit;
        }
        setNewCredit(credits);
    }

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
    }

    public void statistics(double creditput, boolean winorlose) throws SQLException, ClassNotFoundException {
        if(winorlose==true){
            player.userStats(2, player.getUid(), creditput, creditput, 0.0);
        }else{
            player.userStats(2, player.getUid(), creditput, 0.0, creditput);
        }
    }
}
