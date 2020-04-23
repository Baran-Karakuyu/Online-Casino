/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Slots;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Baran
 */
public class SlotMachineModel {

    private double kontostand = 500;
    private double spielerkonto = 0;
    private double gewinn = 0;
    private int riskCounter = 1;
    private int cardNr = 8;
    private int risk = 1;
    private boolean EinzahlungsChecker = false;
    private Symbol symbol = Symbol.CHERRY;
    private final HashMap<Integer, Symbol> allSymbols = new HashMap<>();
    private final ArrayList<Symbol> spinnerSelectedSymbol = new ArrayList<>();
    private final ArrayList<Integer> allRisks = new ArrayList<>();
    DecimalFormat doubleFormatter = new DecimalFormat("#.##");
    protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public void walzenDrehen() throws InterruptedException {
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
        if (spinnerSelectedSymbol.size() < 1 && EinzahlungsChecker == false) {
            spielgeldFuehren((risk * 0.1), 4);
            EinzahlungsChecker = true;
            return;
        }

        EinzahlungsChecker = false;

        Random r = new Random();
        cardNr = r.nextInt(9)+1;

        Symbol oldSymbol = symbol;
        symbol = allSymbols.get(cardNr);

        //Die Werte in der ArrayList dienen zur Gewinnüberprüfung
        spinnerSelectedSymbol.add(allSymbols.get(cardNr));

        changes.firePropertyChange("WalzenDrehen", oldSymbol, symbol);
    }

    public void spielgeldFuehren(double betrag, int schluessel) {
        switch (schluessel) {
            //Geld ins Spielerkonto einwerfen
            case 0: {
                if (kontostand > betrag) {
                    double oldSpielerkonto = spielerkonto;
                    double oldKontostand = kontostand;

                    spielerkonto = spielerkonto + betrag;
                    kontostand = kontostand - betrag;

                    changes.firePropertyChange("SpielerkontoEinwerfen", oldSpielerkonto, spielerkonto);
                    changes.firePropertyChange("KontoAbheben", oldKontostand, kontostand);
                }
                break;
            }
            //Spielerkonto und Gewinn ins Konto auszahlen
            case 1: {
                double oldspielerkonto = spielerkonto;
                double oldKontostand = kontostand;
                double oldGewinn = betrag - spielerkonto;

                kontostand = kontostand + betrag;
                spielerkonto = 0;
                gewinn = 0;

                changes.firePropertyChange("KontoEinzahlen", oldKontostand, kontostand);
                changes.firePropertyChange("SpielerkontoAuszahlen", oldspielerkonto, spielerkonto);
                changes.firePropertyChange("GewinnAuszahlen", oldGewinn, gewinn);
                break;
            }
            //Gewinn erhöhen
            case 2: {
                double oldGewinn = gewinn;

                gewinn = betrag;

                changes.firePropertyChange("GewinnErhöhen", oldGewinn, doubleFormatter.format(gewinn));
                break;
            }
            //Gewinn ins Spielerkonto übertragen
            case 3: {
                double oldSpielerkonto = spielerkonto;
                double oldGewinn = gewinn;

                spielerkonto = spielerkonto + betrag;
                gewinn = 0;

                changes.firePropertyChange("SpielerkontoerhöhungDurchGewinn", oldSpielerkonto, spielerkonto);
                changes.firePropertyChange("GewinnInsSpielerkonto", oldGewinn, gewinn);
                break;
            }
            //Geld vom Spielerkonto zum Spielen nutzen
            case 4: {
                double oldSpielerkonto = spielerkonto;

                spielerkonto = spielerkonto - betrag;

                changes.firePropertyChange("SpielerkontogeldZumSpielenNutzen", oldSpielerkonto, doubleFormatter.format(spielerkonto));
            }
            default:
                break;
        }
    }

    public void bonus() {

    }

    public void gamble() {
        double oldGewinn = gewinn;
        Random r = new Random();
        int randomNumber = r.nextInt(100) + 1;

        if (randomNumber <= 50) {
            gewinn = gewinn * 2;
            changes.firePropertyChange("Gamble", oldGewinn, gewinn);
        } else {
            gewinn = 0;
            changes.firePropertyChange("Gamble", oldGewinn, gewinn);
        }
    }

    public void bet() {
        //fügt beim ersten mal die Risikowerte in eine ArrayList hinzu
        if (allRisks.isEmpty()) {
            allRisks.add(1);
            allRisks.add(2);
            allRisks.add(5);
            allRisks.add(10);
            allRisks.add(20);
            allRisks.add(50);
        }
        if (riskCounter > 5) {
            riskCounter = 0;
        }

        int oldRisk = risk;
        risk = allRisks.get(riskCounter);
        riskCounter++;

        changes.firePropertyChange("Bet", oldRisk, risk);
    }

    public void mystery() {
        double oldGewinn = gewinn;

        Random r = new Random();
        int randomNumber = r.nextInt(100) + 1;

        if (randomNumber <= 50) {
            gewinn = 0;
        } else if (randomNumber <= 67 && randomNumber > 50) {
            gewinn = gewinn * 2;
        } else if (randomNumber <= 84 && randomNumber > 67) {
            gewinn = gewinn * 3;
        } else {
            gewinn = gewinn * 5;
        }

        changes.firePropertyChange("Mystery", oldGewinn, gewinn);
    }

    public void shuffle(int randomUpTo) {
        if (spinnerSelectedSymbol.size() >= 3) {
            spinnerSelectedSymbol.clear();
        }

        Random r = new Random();
        cardNr = r.nextInt(randomUpTo);

        Symbol oldSymbol = symbol;
        symbol = allSymbols.get(cardNr);

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

        //Die Werte in der ArrayList dienen zur Gewinnüberprüfung
        spinnerSelectedSymbol.add(allSymbols.get(cardNr));
        
        changes.firePropertyChange("fruitStop", oldSymbol, symbol);
    }

    public void cherryCollection(int randomUpTo) {
        if (spinnerSelectedSymbol.size() >= 3) {
            spinnerSelectedSymbol.clear();
        }

        Random r = new Random();
        cardNr = r.nextInt(randomUpTo);

        Symbol oldSymbol = symbol;
        symbol = allSymbols.get(cardNr);

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

    public void win(double einsatz) {
        //Gewinnüberprüfung vom höchsten zum tiefsten
        if (spinnerSelectedSymbol.get(0) == Symbol.BAR && spinnerSelectedSymbol.get(1) == Symbol.BAR && spinnerSelectedSymbol.get(2) == Symbol.BAR) {
            spielgeldFuehren((einsatz * 400), 2);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.SIEBEN && spinnerSelectedSymbol.get(1) == Symbol.SIEBEN && spinnerSelectedSymbol.get(2) == Symbol.SIEBEN) {
            spielgeldFuehren((einsatz * 50), 2);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.CHERRY && spinnerSelectedSymbol.get(1) == Symbol.CHERRY && spinnerSelectedSymbol.get(2) == Symbol.CHERRY) {
            spielgeldFuehren((einsatz * 20), 2);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.GLOCKE && spinnerSelectedSymbol.get(1) == Symbol.GLOCKE && spinnerSelectedSymbol.get(2) == Symbol.GLOCKE) {
            spielgeldFuehren((einsatz * 10), 2);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.MELONE && spinnerSelectedSymbol.get(1) == Symbol.MELONE && spinnerSelectedSymbol.get(2) == Symbol.MELONE) {
            spielgeldFuehren((einsatz * 10), 2);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.ZITRONE && spinnerSelectedSymbol.get(1) == Symbol.ZITRONE && spinnerSelectedSymbol.get(2) == Symbol.ZITRONE) {
            spielgeldFuehren((einsatz * 5), 2);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.ORANGE && spinnerSelectedSymbol.get(1) == Symbol.ORANGE && spinnerSelectedSymbol.get(2) == Symbol.ORANGE) {
            spielgeldFuehren((einsatz * 5), 2);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.BANANE && spinnerSelectedSymbol.get(1) == Symbol.BANANE && spinnerSelectedSymbol.get(2) == Symbol.BANANE) {
            spielgeldFuehren((einsatz * 2), 2);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.TRAUBE && spinnerSelectedSymbol.get(1) == Symbol.TRAUBE && spinnerSelectedSymbol.get(2) == Symbol.TRAUBE) {
            spielgeldFuehren((einsatz * 2), 2);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.CHERRY && spinnerSelectedSymbol.get(1) == Symbol.CHERRY) {
            spielgeldFuehren((einsatz * 4), 2);
        } else if (spinnerSelectedSymbol.get(0) == Symbol.CHERRY || spinnerSelectedSymbol.get(2) == Symbol.CHERRY) {
            spielgeldFuehren((einsatz * 2), 2);
        }
    }

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }

    public double getKontostand() {
        return kontostand;
    }
}
