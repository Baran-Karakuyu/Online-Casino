/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Blackjack;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Andrei Oleniuc
 */
public class ViewModelBlackJack implements PropertyChangeListener{
    private final ModelBlackJack mo;

    public ViewModelBlackJack(ModelBlackJack mo) {
        this.mo = mo;
    }
    
    IntegerProperty card1P = new SimpleIntegerProperty();
    IntegerProperty card1G = new SimpleIntegerProperty();
    IntegerProperty card2P = new SimpleIntegerProperty();
    IntegerProperty card2G = new SimpleIntegerProperty();
    IntegerProperty card3P = new SimpleIntegerProperty();
    IntegerProperty card3G = new SimpleIntegerProperty();
    IntegerProperty card4P = new SimpleIntegerProperty();
    IntegerProperty card4G = new SimpleIntegerProperty();
    IntegerProperty card5P = new SimpleIntegerProperty();
    IntegerProperty card5G = new SimpleIntegerProperty();
    IntegerProperty cardDouble = new SimpleIntegerProperty();
    StringProperty credit= new SimpleStringProperty();

    public void play() throws SQLException, ClassNotFoundException {
        mo.play();
    }

    public IntegerProperty getCard1P() {
        return card1P;
    }

    public IntegerProperty getCard1G() {
        return card1G;
    }

    public IntegerProperty getCard2P() {
        return card2P;
    }

    public IntegerProperty getCard2G() {
        return card2G;
    }

    public IntegerProperty getCard3P() {
        return card3P;
    }

    public IntegerProperty getCard3G() {
        return card3G;
    }

    public IntegerProperty getCard4P() {
        return card4P;
    }

    public IntegerProperty getCard4G() {
        return card4G;
    }

    public IntegerProperty getCard5P() {
        return card5P;
    }

    public IntegerProperty getCard5G() {
        return card5G;
    }

    public IntegerProperty getCardDouble() {
        return cardDouble;
    }

    public StringProperty getCredit() {
        return credit;
    }
    


    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        switch (pce.getPropertyName()) {
            case "card1P":
                card1P.set((int) pce.getNewValue());
                break;
            case "card1G":
                card1G.set((int) pce.getNewValue());
                break;
            case "card2P":
                card2P.set((int) pce.getNewValue());
                break;
            case "card2G":
                card2G.set((int) pce.getNewValue());
                break;
            case "card3P":
                card3P.set((int) pce.getNewValue());
                break;
            case "card3G":
                card3G.set((int) pce.getNewValue());
                break;
            case "card4P":
                card4P.set((int) pce.getNewValue());
                break;
            case "card4G":
                card4G.set((int) pce.getNewValue());
                break;
            case "card5P":
                card5P.set((int) pce.getNewValue());
                break;
            case "card5G":
                card5G.set((int) pce.getNewValue());
                break;
            case "cardDouble":
                cardDouble.set((int) pce.getNewValue());
                break;
            case "credit":
                credit.set(pce.getNewValue().toString());
                break;
                
        }
    }

    public void hitaction(int cards) {
        mo.hitaction(cards);
    }

    public void holdaction(int cardsDealer,int idcard) {
        mo.holdaction(cardsDealer,idcard);
    }

    public void doubleaction() {
        mo.doubleAction();
    }
    public void credit() throws SQLException, ClassNotFoundException{
        mo.credit();
    }
    public void updatePlayer() throws SQLException, ClassNotFoundException{
        mo.userDataTransfer();
    }
    public void setNewCredit(int credit) throws SQLException, ClassNotFoundException{
        mo.setNewCredit(credit);
    }
    public void insurance(int credit,int sum) throws SQLException, ClassNotFoundException{
        mo.insurance(credit, sum);
    }

    public void backToMenu() throws IOException, SQLException, ClassNotFoundException {
        mo.backToMenu();
    }

    public void setNewStatitcs(int creditput,boolean winorlose) throws SQLException, ClassNotFoundException {
        mo.statistics(creditput,winorlose);
    }
    
   
}
