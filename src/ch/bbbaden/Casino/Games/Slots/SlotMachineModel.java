/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Slots;

import Casino.DataBase.User;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Baran
 */
public class SlotMachineModel {
    
    private double playerAccountNumber = 0;
    private double win = 0;
    private int riskCounter = -1;
    private int cardNr = 8;
    private double risk = 0.0;
    private boolean depositChecker = false;
    private Symbol symbol = Symbol.CHERRY;
    private final HashMap<Integer, Symbol> allSymbols = new HashMap<>();
    private final ArrayList<Symbol> spinnerSelectedSymbol = new ArrayList<>();
    private final ArrayList<Integer> allRisks = new ArrayList<>();
    private final DecimalFormat doubleFormatter = new DecimalFormat("#.##");
    private User user;
    private double betNumber;
    protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private double balanceNumber;

    public void spinSpinners() throws InterruptedException {
        if (allSymbols.isEmpty()) {
            allSymbols.put(0, Symbol.CHERRY);
            allSymbols.put(1, Symbol.TRAUBE);
            allSymbols.put(2, Symbol.BANANE);
            allSymbols.put(3, Symbol.ORANGE);
            allSymbols.put(4, Symbol.ZITRONE);
            allSymbols.put(5, Symbol.MELONE);
            allSymbols.put(6, Symbol.GLOCKE);
            allSymbols.put(7, Symbol.SIEBEN);
            allSymbols.put(8, Symbol.BAR);
            allSymbols.put(9, Symbol.STERN);
        }

        if (spinnerSelectedSymbol.size() >= 3) {
            spinnerSelectedSymbol.clear();
        }
        if (spinnerSelectedSymbol.size() < 1 && depositChecker == false) {
            managingPlayMoney((risk), 4);
            depositChecker = true;
            return;
        }

        depositChecker = false;

        Random r = new Random();
        cardNr = r.nextInt(9) + 1;

        Symbol oldSymbol = symbol;
        symbol = allSymbols.get(cardNr);

        //Die Werte in der ArrayList dienen zur Gewinnüberprüfung
        spinnerSelectedSymbol.add(allSymbols.get(cardNr));

        changes.firePropertyChange("spinSpinners", oldSymbol, symbol);
    }

    public void managingPlayMoney(double insert, int key) {
        switch (key) {
            //Geld ins Spielerkonto einwerfen
            case 0: {
                if (balanceNumber > insert) {
                    double oldPlayerAccountNumber = playerAccountNumber;
                    double oldBalanceNumber = balanceNumber;

                    playerAccountNumber = playerAccountNumber + insert;
                    balanceNumber = balanceNumber - insert;

                    changes.firePropertyChange("PlayerAccountDeposit", oldPlayerAccountNumber, doubleFormatter.format(playerAccountNumber));
                    changes.firePropertyChange("BalancePayOut", oldBalanceNumber, doubleFormatter.format(balanceNumber));
                }
                break;
            }
            //Spielerkonto und Gewinn ins Konto auszahlen
            case 1: {
                double oldplayerAccountNumber = playerAccountNumber;
                double oldBalanceNumber = balanceNumber;
                double oldGewinn = insert - playerAccountNumber;

                balanceNumber = balanceNumber + insert;
                playerAccountNumber = 0;
                win = 0;

                changes.firePropertyChange("BalanceDeposit", oldBalanceNumber, doubleFormatter.format(balanceNumber));
                changes.firePropertyChange("PlayerAccountPayOut", oldplayerAccountNumber, doubleFormatter.format(playerAccountNumber));
                changes.firePropertyChange("WinPayOut", oldGewinn, doubleFormatter.format(win));
                break;
            }
            //Gewinn erhöhen
            case 2: {
                double oldGewinn = win;

                win = insert;

                changes.firePropertyChange("GewinnErhöhen", oldGewinn, doubleFormatter.format(win));
                break;
            }
            //Gewinn ins Spielerkonto übertragen
            case 3: {
                double oldSpielerkonto = playerAccountNumber;
                double oldGewinn = win;

                playerAccountNumber = playerAccountNumber + insert;
                win = 0;

                changes.firePropertyChange("SpielerkontoerhöhungDurchGewinn", oldSpielerkonto, doubleFormatter.format(playerAccountNumber));
                changes.firePropertyChange("GewinnInsSpielerkonto", oldGewinn, doubleFormatter.format(win));
                break;
            }
            //Geld vom Spielerkonto zum Spielen nutzen
            case 4: {
                double oldSpielerkonto = playerAccountNumber;

                playerAccountNumber = playerAccountNumber - insert;

                changes.firePropertyChange("SpielerkontogeldZumSpielenNutzen", oldSpielerkonto, doubleFormatter.format(playerAccountNumber));
            }
            default:
                break;
        }
    }

    public void bonus() throws SQLException, ClassNotFoundException {
        Random r = new Random();
        int randomBonus = r.nextInt(10) + 1;

        double oldBonus = 0;
        double bonus = 0.1 * allRisks.get(riskCounter);

        //A 10% chance of getting a bonus
        if (randomBonus == 1) {
            managingPlayMoney(bonus, 2);
            changes.firePropertyChange("Bonus", oldBonus, bonus);
        } else {
            user.userStats(1, user.getUid(), betNumber, 0, betNumber);
            user.setCredit(balanceNumber - betNumber);
        }
    }

    public void gamble() {
        Random r = new Random();
        int randomNumber = r.nextInt(100) + 1;

        double oldGewinn = win;

        if (randomNumber <= 50) {
            win = win * 2;
            changes.firePropertyChange("Gamble", oldGewinn, win);
        } else {
            win = 0;
            changes.firePropertyChange("Gamble", oldGewinn, win);
        }
    }

    public void bet() {
        if (allRisks.isEmpty()) {
            allRisks.add(1);
            allRisks.add(2);
            allRisks.add(5);
            allRisks.add(10);
            allRisks.add(20);
            allRisks.add(50);
        }

        riskCounter++;

        if (riskCounter > 5) {
            riskCounter = 0;
        }

        double oldRisk = risk;
        risk = 0.1 * allRisks.get(riskCounter);

        changes.firePropertyChange("Bet", oldRisk, risk);
    }

    public void mystery() {
        double oldGewinn = win;

        Random r = new Random();
        int randomNumber = r.nextInt(100) + 1;

        if (randomNumber <= 50) {
            win = 0;
        } else if (randomNumber <= 67 && randomNumber > 50) {
            win = win * 2;
        } else if (randomNumber <= 84 && randomNumber > 67) {
            win = win * 3;
        } else {
            win = win * 5;
        }

        changes.firePropertyChange("Mystery", oldGewinn, win);
    }

    public void shuffle(int randomUpTo) {
        if (spinnerSelectedSymbol.size() >= 3) {
            spinnerSelectedSymbol.clear();
        }

        Random r = new Random();
        cardNr = r.nextInt(randomUpTo);

        Symbol oldSymbol = symbol;
        symbol = allSymbols.get(cardNr);

        depositChecker = false;

        //Die Werte in der ArrayList dienen zur Gewinnüberprüfung
        spinnerSelectedSymbol.add(allSymbols.get(cardNr));
        spinnerSelectedSymbol.add(allSymbols.get(cardNr));
        spinnerSelectedSymbol.add(allSymbols.get(cardNr));

        changes.firePropertyChange("Shuffle", oldSymbol, symbol);
    }

    public void tenTimes(int randomUpTo) {
        if (spinnerSelectedSymbol.size() >= 3) {
            spinnerSelectedSymbol.clear();
        }

        Random r = new Random();
        cardNr = r.nextInt(randomUpTo);

        Symbol oldSymbol = symbol;
        symbol = allSymbols.get(cardNr);

        depositChecker = false;

        //Die Werte in der ArrayList dienen zur Gewinnüberprüfung
        spinnerSelectedSymbol.add(allSymbols.get(cardNr));

        changes.firePropertyChange("tenTimes", oldSymbol, symbol);
    }

    public void fruitStop(int randomUpTo) {
        if (spinnerSelectedSymbol.size() >= 3) {
            spinnerSelectedSymbol.clear();
        }

        Random r = new Random();
        cardNr = r.nextInt(randomUpTo);

        Symbol oldSymbol = symbol;
        symbol = allSymbols.get(cardNr);

        depositChecker = false;

        //Die Werte in der ArrayList dienen zur Gewinnüberprüfung
        spinnerSelectedSymbol.add(allSymbols.get(cardNr));

        changes.firePropertyChange("fruitStop", oldSymbol, symbol);
    }

    public void cherryCollect(int randomUpTo) {
        if (spinnerSelectedSymbol.size() >= 3) {
            spinnerSelectedSymbol.clear();
        }

        Random r = new Random();
        cardNr = r.nextInt(randomUpTo);

        Symbol oldSymbol = symbol;
        symbol = allSymbols.get(cardNr);

        depositChecker = false;

        //Die Werte in der ArrayList dienen zur Gewinnüberprüfung
        spinnerSelectedSymbol.add(allSymbols.get(cardNr));

        changes.firePropertyChange("cherryCollect", oldSymbol, symbol);
    }

    public void holdAndStep(int removeNumber, int randomUpTo) {
        spinnerSelectedSymbol.remove(removeNumber);

        Random r = new Random();
        cardNr = r.nextInt(randomUpTo);

        Symbol oldSymbol = symbol;
        symbol = allSymbols.get(cardNr);

        depositChecker = false;

        //Ein Wert wird in der vorher entfernten Position eingefügt
        spinnerSelectedSymbol.add(removeNumber, allSymbols.get(cardNr));

        changes.firePropertyChange("holdAndStep", oldSymbol, symbol);
    }

    public void holdCherry(int removeNumber, int randomUpTo) {
        spinnerSelectedSymbol.remove(removeNumber);

        Random r = new Random();
        cardNr = r.nextInt(randomUpTo) + 1;

        Symbol oldSymbol = symbol;
        symbol = allSymbols.get(cardNr);

        depositChecker = false;

        //Ein Wert wird in der vorher entfernten Position eingefügt
        spinnerSelectedSymbol.add(removeNumber, allSymbols.get(cardNr));

        changes.firePropertyChange("holdAndStep", oldSymbol, symbol);
    }

    public void changeSelected(int removeNumber, String strSymbol, boolean firstColumnChecker, String[] addingSymbols) {
        HashMap<String, Integer> changeSymbolOptions = new HashMap<>();
        changeSymbolOptions.put("CHERRY", 0);
        changeSymbolOptions.put("TRAUBE", 1);
        changeSymbolOptions.put("BANANE", 2);
        changeSymbolOptions.put("ORANGE", 3);
        changeSymbolOptions.put("ZITRONE", 4);
        changeSymbolOptions.put("MELONE", 5);
        changeSymbolOptions.put("GLOCKE", 6);
        changeSymbolOptions.put("SIEBEN", 7);
        changeSymbolOptions.put("BAR", 8);
        changeSymbolOptions.put("STERN", 9);

        if (firstColumnChecker == true) {
            spinnerSelectedSymbol.clear();
            spinnerSelectedSymbol.add(0, allSymbols.get(changeSymbolOptions.get(addingSymbols[0])));
            spinnerSelectedSymbol.add(1, allSymbols.get(changeSymbolOptions.get(addingSymbols[1])));
            spinnerSelectedSymbol.add(2, allSymbols.get(changeSymbolOptions.get(addingSymbols[2])));
        }

        spinnerSelectedSymbol.remove(removeNumber);

        //Ein Wert wird Manuel in der vorher entfernten Position eingefügt
        spinnerSelectedSymbol.add(removeNumber, allSymbols.get(changeSymbolOptions.get(strSymbol)));
    }

    public void win(double bet) throws SQLException, ClassNotFoundException {
        betNumber = bet;
        //Winchecking from highest to lowest
        if (spinnerSelectedSymbol.get(0) == Symbol.BAR && spinnerSelectedSymbol.get(1) == Symbol.BAR && spinnerSelectedSymbol.get(2) == Symbol.BAR) {
            managingPlayMoney((bet * 400), 2);
            user.userStats(1, user.getUid(), bet, bet * 400, 0);
            user.setCredit(balanceNumber + bet * 400);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.SIEBEN && spinnerSelectedSymbol.get(1) == Symbol.SIEBEN && spinnerSelectedSymbol.get(2) == Symbol.SIEBEN) {
            managingPlayMoney((bet * 50), 2);
            user.userStats(1, user.getUid(), bet, bet * 50, 0);
            user.setCredit(balanceNumber + bet * 50);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.CHERRY && spinnerSelectedSymbol.get(1) == Symbol.CHERRY && spinnerSelectedSymbol.get(2) == Symbol.CHERRY) {
            managingPlayMoney((bet * 20), 2);
            user.userStats(1, user.getUid(), bet, bet * 20, 0);
            user.setCredit(balanceNumber + bet * 20);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.GLOCKE && spinnerSelectedSymbol.get(1) == Symbol.GLOCKE && spinnerSelectedSymbol.get(2) == Symbol.GLOCKE) {
            managingPlayMoney((bet * 10), 2);
            user.userStats(1, user.getUid(), bet, bet * 10, 0);
            user.setCredit(balanceNumber + bet * 10);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.MELONE && spinnerSelectedSymbol.get(1) == Symbol.MELONE && spinnerSelectedSymbol.get(2) == Symbol.MELONE) {
            managingPlayMoney((bet * 10), 2);
            user.userStats(1, user.getUid(), bet, bet * 10, 0);
            user.setCredit(balanceNumber + bet * 10);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.ZITRONE && spinnerSelectedSymbol.get(1) == Symbol.ZITRONE && spinnerSelectedSymbol.get(2) == Symbol.ZITRONE) {
            managingPlayMoney((bet * 5), 2);
            user.userStats(1, user.getUid(), bet, bet * 5, 0);
            user.setCredit(balanceNumber + bet * 5);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.ORANGE && spinnerSelectedSymbol.get(1) == Symbol.ORANGE && spinnerSelectedSymbol.get(2) == Symbol.ORANGE) {
            managingPlayMoney((bet * 5), 2);
            user.userStats(1, user.getUid(), bet, bet * 5, 0);
            user.setCredit(balanceNumber + bet * 5);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.BANANE && spinnerSelectedSymbol.get(1) == Symbol.BANANE && spinnerSelectedSymbol.get(2) == Symbol.BANANE) {
            managingPlayMoney((bet * 2), 2);
            user.userStats(1, user.getUid(), bet, bet * 2, 0);
            user.setCredit(balanceNumber + bet * 2);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.TRAUBE && spinnerSelectedSymbol.get(1) == Symbol.TRAUBE && spinnerSelectedSymbol.get(2) == Symbol.TRAUBE) {
            managingPlayMoney((bet * 2), 2);
            user.userStats(1, user.getUid(), bet, bet * 2, 0);
            user.setCredit(balanceNumber + bet * 2);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.CHERRY && spinnerSelectedSymbol.get(1) == Symbol.CHERRY) {
            managingPlayMoney((bet * 4), 2);
            user.userStats(1, user.getUid(), bet, bet * 4, 0);
            user.setCredit(balanceNumber + bet * 4);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.CHERRY || spinnerSelectedSymbol.get(2) == Symbol.CHERRY) {
            managingPlayMoney((bet * 2), 2);
            user.userStats(1, user.getUid(), bet, bet * 2, 0);
            user.setCredit(balanceNumber + bet * 2);
        } else {
            bonus();
        }
    }

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }

    public double getBalanceNumber() {
        return balanceNumber;
    }

    public void setUser(User user) {
        this.user = user;
        balanceNumber = user.getCredit();
    }
}
