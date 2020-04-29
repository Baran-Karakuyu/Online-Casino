/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Bingo;

import ch.bbbaden.Casino.MainApp;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Emirhan Karaca
 */
public class BingoViewModel implements PropertyChangeListener {

    BingoModel bingoModel;
    MainApp mainApp;

    //declaration of variables
    StringProperty str1 = new SimpleStringProperty();
    StringProperty str2 = new SimpleStringProperty();
    StringProperty str3 = new SimpleStringProperty();
    StringProperty str4 = new SimpleStringProperty();
    StringProperty str5 = new SimpleStringProperty();
    StringProperty str6 = new SimpleStringProperty();
    StringProperty str7 = new SimpleStringProperty();
    StringProperty str8 = new SimpleStringProperty();
    StringProperty str9 = new SimpleStringProperty();
    StringProperty str10 = new SimpleStringProperty();
    StringProperty str11 = new SimpleStringProperty();
    StringProperty str12 = new SimpleStringProperty();
    StringProperty str13 = new SimpleStringProperty();
    StringProperty str14 = new SimpleStringProperty();
    StringProperty str15 = new SimpleStringProperty();
    StringProperty str16 = new SimpleStringProperty();
    StringProperty str17 = new SimpleStringProperty();
    StringProperty str18 = new SimpleStringProperty();
    StringProperty str19 = new SimpleStringProperty();
    StringProperty str20 = new SimpleStringProperty();
    StringProperty str21 = new SimpleStringProperty();
    StringProperty str22 = new SimpleStringProperty();
    StringProperty str23 = new SimpleStringProperty();
    StringProperty str24 = new SimpleStringProperty();
    StringProperty str25 = new SimpleStringProperty();

    public BingoViewModel(BingoModel bingoModel) {
        this.bingoModel = bingoModel;
    }

    //if change is fired this method is called, sets values of String with different cases
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        switch (evt.getPropertyName()) {
            case "bingoNumbers1":
                str1.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers2":
                str2.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers3":
                str3.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers4":
                str4.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers5":
                str5.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers6":
                str6.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers7":
                str7.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers8":
                str8.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers9":
                str9.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers10":
                str10.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers11":
                str11.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers12":
                str12.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers13":
                str13.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers14":
                str14.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers15":
                str15.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers16":
                str16.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers17":
                str17.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers18":
                str18.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers19":
                str19.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers20":
                str20.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers21":
                str21.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers22":
                str22.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers23":
                str23.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers24":
                str24.set(evt.getNewValue().toString());

                break;
            case "bingoNumbers25":
                str25.set(evt.getNewValue().toString());

                break;

        }
    }

    //All Getters for the Strings
    public StringProperty getStr1() {
        return str1;
    }

    public StringProperty getStr2() {
        return str2;
    }

    public StringProperty getStr3() {
        return str3;
    }

    public StringProperty getStr4() {
        return str4;
    }

    public StringProperty getStr5() {
        return str5;
    }

    public StringProperty getStr6() {
        return str6;
    }

    public StringProperty getStr7() {
        return str7;
    }

    public StringProperty getStr8() {
        return str8;
    }

    public StringProperty getStr9() {
        return str9;
    }

    public StringProperty getStr10() {
        return str10;
    }

    public StringProperty getStr11() {
        return str11;
    }

    public StringProperty getStr12() {
        return str12;
    }

    public StringProperty getStr13() {
        return str13;
    }

    public StringProperty getStr14() {
        return str14;
    }

    public StringProperty getStr15() {
        return str15;
    }

    public StringProperty getStr16() {
        return str16;
    }

    public StringProperty getStr17() {
        return str17;
    }

    public StringProperty getStr18() {
        return str18;
    }

    public StringProperty getStr19() {
        return str19;
    }

    public StringProperty getStr20() {
        return str20;
    }

    public StringProperty getStr21() {
        return str21;
    }

    public StringProperty getStr22() {
        return str22;
    }

    public StringProperty getStr23() {
        return str23;
    }

    public StringProperty getStr24() {
        return str24;
    }

    public StringProperty getStr25() {
        return str25;
    }

}
