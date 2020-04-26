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
    public final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private MainApp mainApp;
    Query sql = new Query();
    ArrayList<User> benutzer = new ArrayList<>();
    int creditPlayer = 0;
    String card1 = "";
    int card = 0;
    String newCredit="";
    private String name;
    int dbCredit=0;
    Random r = new Random();
    ArrayList<Integer> allCards= new ArrayList<>();

    public void play() throws SQLException, ClassNotFoundException {
        allCards.clear();
        sql.updateUser();
        int oldcard = card;
        card = newCard();
        changes.firePropertyChange("card1P", oldcard, card);
        card = newCard();
        changes.firePropertyChange("card1G", oldcard, card);
        card = newCard();
        changes.firePropertyChange("card2P", oldcard, card);
        card =newCard();
        changes.firePropertyChange("card2G", oldcard, card);
    }

    public void credit() throws SQLException, ClassNotFoundException {
        UserDataTransfer();
    }

    public void hitaction(int cardshit) {
        int oldcard = card;
        switch (cardshit) {
            case 2:
                card = newCard();
                changes.firePropertyChange("card3P", oldcard, card);
                break;
            case 3:
                card =  newCard();
                changes.firePropertyChange("card4P", oldcard, card);
                break;
            case 4:
                card =  newCard();
                changes.firePropertyChange("card5P", oldcard, card);
                break;
        }
    }

    public void holdaction(int summeGroupier, int idcard) {
        int oldcard = card;
        if (summeGroupier < 17) {
            card =  newCard();
            changes.firePropertyChange("card" + idcard + "G", oldcard, card);
        }
    }

    public void doubleAction() {
        int oldcard = card;
        card =  newCard();
        changes.firePropertyChange("cardDouble", oldcard, card);
    }
    public void checkPlayer(int sumP,int sumG,int creditPut,int creditNow){
        String oldcredit= newCredit;
        int a=0;
        boolean notNegativeP = false;
        boolean notNegativeG = false;
        if (21 - sumP < 0) {
            System.out.println("You Lost");
            newCredit = Integer.toString(creditNow);
            notNegativeP = true;
        } else {
            notNegativeP = false;
        }

        if (21 - sumG < 0) {
            notNegativeG = true;
            System.out.println("You Won");
            a+= creditPut;
            a+= creditPut;
            creditNow+=a;
            newCredit = Integer.toString(creditNow);
        } else {
            notNegativeG = false;
        }

        if (notNegativeP == false && notNegativeG == false) {
            if (21 - sumP < 21 - sumG) {
                System.out.println("You Won");
                a+= creditPut;
                a+= creditPut;
                creditNow+=a;
                newCredit = Integer.toString(creditNow);
            } else if (21 - sumP > 21 - sumG) {
                System.out.println("You Lost");
                newCredit = Integer.toString(creditNow);
            } else {
                System.out.println("Even");
                a += creditPut;
                creditNow= a;
                newCredit = Integer.toString(creditNow);
            }
        }
        changes.firePropertyChange("credit", oldcredit, newCredit);
    }
    //Sets the Credit from DB to View
    public void UserDataTransfer() throws SQLException, ClassNotFoundException{
        String oldcredit="";
        sql.updateUser();
        sql.selectUsers();
        dbCredit = sql.getCreditUser(name);
        changes.firePropertyChange("credit", oldcredit, Integer.toString(dbCredit));
        creditPlayer= dbCredit;
    }
    //Sets the new Credit 
    public void setNewCredit(int credit) throws SQLException, ClassNotFoundException{
        String oldcredit="";
        sql.updateCredit(credit,name);
        changes.firePropertyChange("credit", oldcredit, credit);
    }
    
    public void versichern(int credit,int summe) throws SQLException, ClassNotFoundException{
        int credits=0;
        credits =  sql.getCreditUser(name);
        if(summe ==21){
            credits+=credit;
        }else{
            credits-=credit;
        }
        setNewCredit(credits);
    }
    
        public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);

    }
        
    public void setPlayer(String name){
        this.name= name;
    }
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void backToMenu() throws IOException, SQLException, ClassNotFoundException {
        mainApp.startMenu();
    }
   
    
    private int newCard(){
        int cardTaken=0;
        cardTaken=r.nextInt((52)+1) + 1;
        for (Integer allCard : allCards) {
            if(allCard.equals(cardTaken)){
                cardTaken=r.nextInt((52)+1) + 1;
                if(cardTaken==0){
                    cardTaken=r.nextInt((52)+1) + 1;
                }
                }
            }    
        allCards.add(cardTaken);
        return cardTaken;
    }
}
