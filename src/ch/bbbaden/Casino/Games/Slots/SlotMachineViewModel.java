/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Slots;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Baran
 */
public class SlotMachineViewModel implements PropertyChangeListener {

    private final SlotMachineModel m;
    private final StringProperty playerAccountNumber = new SimpleStringProperty();
    private final StringProperty balanceNumber = new SimpleStringProperty();
    private final StringProperty spinnerNumber = new SimpleStringProperty();
    private final StringProperty winNumber = new SimpleStringProperty();
    private final StringProperty riskNumber = new SimpleStringProperty();
    private final StringProperty bonusNumber = new SimpleStringProperty();

    public SlotMachineViewModel(SlotMachineModel m) {
        this.m = m;
        balanceNumber.setValue(String.valueOf(m.getBalanceNumber()));
        spinnerNumber.set("0");
        winNumber.setValue("0.0");
        riskNumber.setValue("0.0");
        playerAccountNumber.setValue("0.0");
    }

    public void deposit(double insert) {
        m.managingPlayMoney(insert, 0);
    }

    public void payOut(double insert) {
        m.managingPlayMoney(insert, 1);
    }

    public void win(double insert) {
        m.managingPlayMoney(insert, 2);
    }

    public void winToPlayerAccountNumber(double insert) {
        m.managingPlayMoney(insert, 3);
    }

    public void spinSpinners() throws InterruptedException {
        m.spinSpinners();
    }

    public void bet() {
        m.bet();
    }

    public void gamble() {
        m.gamble();
    }

    public void mystery() {
        m.mystery();
    }

    public void checkWin(double insert) throws SQLException, ClassNotFoundException {
        m.win(insert);
    }

    public void shuffle(int randomUpTo) {
        m.shuffle(randomUpTo);
    }

    public void tenTimes(int randomUpTo) {
        m.tenTimes(randomUpTo);
    }

    public void cherryCollect(int randomUpTo) {
        m.cherryCollect(randomUpTo);
    }

    public void holdAndStep(int removeNumber, int randomUpTo) {
        m.holdAndStep(removeNumber, randomUpTo);
    }
    
    public void holdCherry(int removeNumber, int randomUpTo) {
        m.holdCherry(removeNumber, randomUpTo);
    }
    
    public void changeSelected(int removeNumber, String strSymbol, boolean firstColumnChecker, String[] addingSymbols) {
        m.changeSelected(removeNumber, strSymbol, firstColumnChecker, addingSymbols);
    }

    public void fruitStop(int randomUpTo) {
        m.fruitStop(randomUpTo);
    }
    
    public StringProperty getPlayerAccountNumber() {
        return playerAccountNumber;
    }

    public StringProperty getBalanceNumber() {
        return balanceNumber;
    }

    public StringProperty getWinNumber() {
        return winNumber;
    }

    public StringProperty getSpinnerNumber() {
        return spinnerNumber;
    }

    public StringProperty getRiskNumber() {
        return riskNumber;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("PlayerAccountDeposit")) {
            playerAccountNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("BalancePayOut")) {
            balanceNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("BalanceDeposit")) {
            balanceNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("PlayerAccountPayOut")) {
            playerAccountNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("WinPayOut")) {
            winNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("spinSpinners")) {
            spinnerNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("GewinnErhöhen")) {
            winNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("Bet")) {
            riskNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("Gamble")) {
            winNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("Mystery")) {
            winNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("SpielerkontoerhöhungDurchGewinn")) {
            playerAccountNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("SpielerkontogeldZumSpielenNutzen")) {
            playerAccountNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("GewinnInsSpielerkonto")) {
            winNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("Shuffle")) {
            spinnerNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("tenTimes")) {
            spinnerNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("fruitStop")) {
            spinnerNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("cherryCollect")) {
            spinnerNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("holdAndStep")) {
            spinnerNumber.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("Bonus")) {
            bonusNumber.set(evt.getNewValue().toString());
        }
    }
}
