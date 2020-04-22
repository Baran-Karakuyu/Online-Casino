/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Slots;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Baran
 */
public class SlotMachineViewModel implements PropertyChangeListener {

    SlotMachineModel m;
    StringProperty Spielerkonto = new SimpleStringProperty();
    StringProperty kontostandszahl = new SimpleStringProperty();
    StringProperty walzenZahl = new SimpleStringProperty();
    StringProperty GewinnZahl = new SimpleStringProperty();
    StringProperty RisikoBetrag = new SimpleStringProperty();

    public SlotMachineViewModel(SlotMachineModel m) {
        this.m = m;
        kontostandszahl.setValue(String.valueOf(m.getKontostand()));
        walzenZahl.set("0");
        GewinnZahl.setValue("0.0");
        RisikoBetrag.setValue("1");
        Spielerkonto.setValue("0.0");
    }

    public void einwurf(double betrag) {
        m.spielgeldFuehren(betrag, 0);
    }

    public void auszahlen(double betrag) {
        m.spielgeldFuehren(betrag, 1);
    }

    public void gewinn(double betrag) {
        m.spielgeldFuehren(betrag, 2);
    }

    public void gewinnInsSpielerkonto(double betrag) {
        m.spielgeldFuehren(betrag, 3);
    }

    public void walzenDrehen() throws InterruptedException {
        m.walzenDrehen();
    }

    public void bet() {
        m.bet();
    }

    public void gamblen() {
        m.gamble();
    }

    public void mystery() {
        m.mystery();
    }

    public void gewinnUeberpruefen(double einsatz) {
        m.win(einsatz);
    }

    public void shuffle(int randomUpTo) {
        m.shuffle(randomUpTo);
    }

    public void tenTimes(int randomUpTo) {
        m.tenTimes(randomUpTo);
    }

    public void cherryCollect(int randomUpTo) {
        m.cherryCollection(randomUpTo);
    }

    public void holdAndStep(int removeNumber, int randomUpTo) {
        m.holdAndStep(removeNumber, randomUpTo);
    }
    
    public void holdCherry(int removeNumber, int randomUpTo) {
        m.holdCherry(removeNumber, randomUpTo);
    }
    
    public void changeSelected(int removeNumber, String strSymbol) {
        m.changeSelected(removeNumber, strSymbol);
    }

    public StringProperty getEinwurf() {
        return Spielerkonto;
    }

    public StringProperty getKontostand() {
        return kontostandszahl;
    }

    public StringProperty getGewinn() {
        return GewinnZahl;
    }

    public StringProperty getWalzenZahl() {
        return walzenZahl;
    }

    public StringProperty getRisikoBetrag() {
        return RisikoBetrag;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("SpielerkontoEinwerfen")) {
            Spielerkonto.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("KontoAbheben")) {
            kontostandszahl.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("KontoEinzahlen")) {
            kontostandszahl.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("SpielerkontoAuszahlen")) {
            Spielerkonto.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("GewinnAuszahlen")) {
            GewinnZahl.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("GewinnAuszahlen")) {
            GewinnZahl.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("WalzenDrehen")) {
            walzenZahl.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("GewinnErhöhen")) {
            GewinnZahl.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("Bet")) {
            RisikoBetrag.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("Gamble")) {
            GewinnZahl.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("Mystery")) {
            GewinnZahl.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("SpielerkontoerhöhungDurchGewinn")) {
            Spielerkonto.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("SpielerkontogeldZumSpielenNutzen")) {
            Spielerkonto.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("GewinnInsSpielerkonto")) {
            GewinnZahl.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("Shuffle")) {
            walzenZahl.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("tenTimes")) {
            walzenZahl.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("cherryCollect")) {
            walzenZahl.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals("hold")) {
            walzenZahl.set(evt.getNewValue().toString());
        }
    }
}
