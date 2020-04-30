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

    //Sets the Connection
    public ViewModelBlackJack(ModelBlackJack mo) {
        this.mo = mo;
    }
    //Saves the name of the player
    StringProperty name= new SimpleStringProperty();
    
    //Saves the Values of the Cards so they can be given over to the ViewController
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
    
    
    //Saves the Credit of the Player in the ViewModel to be prepared for the ViewController
    StringProperty credit= new SimpleStringProperty();

    //Lets the game start after starting a round
    public void play() throws SQLException, ClassNotFoundException {
        mo.play();
    }
    //All getters for the Cards random Numbers
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
    //Getter for the Credit so it Bindable
    public StringProperty getCredit() {
        return credit;
    }
    //Getter for the Name so it Bindable
    public StringProperty getName() {
        return name;
    }
    

    //Changes the Values of the Properties when a Change occurs in the Model
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
            case "name":
                name.set(pce.getNewValue().toString());
                break;
        }
    }

    //Lets the Hitting action start in the Model
    public void hitaction(int cards) {
        mo.hitaction(cards);
    }
    //lets the Standing/Holding Action start in the Model
    public void holdaction(int cardsDealer,int idcard) {
        mo.holdaction(cardsDealer,idcard);
    }
    //Lets the doubledown Action start in the Model
    public void doubleaction() {
        mo.doubleAction();
    }
    //Updates the Credit at the begging of the Round
    public void credit() throws SQLException, ClassNotFoundException{
        mo.credit();
    }
    //Updates the Data of the Credit to the newest 
    public void updatePlayer() throws SQLException, ClassNotFoundException{
        mo.userDataTransfer();
    }
    //Sets the new Credit whenever it Changes,  Parameters go over to the Model
    public void setNewCredit(double credit) throws SQLException, ClassNotFoundException{
        mo.setNewCredit(credit);
    }
    //Goes back to the Menu
    public void backToMenu() throws IOException, SQLException, ClassNotFoundException {
        mo.backToMenu();
    }
    //Creates a new Statistic in for the game and the player, Parameters go over to the Model
    public void setNewStatitcs(double creditput,boolean winorlose,boolean insuranceWoL,double insuranceMoney,boolean even) throws SQLException, ClassNotFoundException {
        mo.statistics(creditput,winorlose,insuranceWoL,insuranceMoney,even);
    }
    
   
}
