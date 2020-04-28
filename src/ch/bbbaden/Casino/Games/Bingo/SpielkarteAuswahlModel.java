/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Bingo;

import ch.bbbaden.Casino.Games.MainApp;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Emirh
 */
public class SpielkarteAuswahlModel {

    ArrayList<Integer> randomNumbers = new ArrayList<>();

    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    String str8;
    String str9;
    String str10;
    String str11;
    String str12;
    String str13;
    String str14;
    String str15;
    String str16;
    String str17;
    String str18;
    String str19;
    String str20;
    String str21;
    String str22;
    String str23;
    String str24;
    String str25;
    PropertyChangeSupport changes = new PropertyChangeSupport(this);

    MainApp mainApp;

    public SpielkarteAuswahlModel(MainApp mainApp) {
        this.mainApp = mainApp;

    }

    public ArrayList<Integer> getRandomNumbers() {
        for (int i = 1; i <= 75; i++) {
            randomNumbers.add(i);

        }
        Collections.shuffle(randomNumbers);

        return randomNumbers;

    }

    public void showBingo() {

        mainApp.showBingo();
    }

    public void ActionAendern() {
        ArrayList<Integer> list = getRandomNumbers();

        String oldstr1 = str1;
        str1 = list.get(0).toString();

        changes.firePropertyChange("bingoNumbers1", oldstr1, str1);

        String oldstr2 = str2;
        str2 = list.get(1).toString();

        changes.firePropertyChange("bingoNumbers2", oldstr2, str2);

        String oldstr3 = str3;
        str3 = list.get(2).toString();

        changes.firePropertyChange("bingoNumbers3", oldstr3, str3);

        String oldstr4 = str4;
        str4 = list.get(3).toString();

        changes.firePropertyChange("bingoNumbers4", oldstr4, str4);

        String oldstr5 = str5;
        str5 = list.get(4).toString();

        changes.firePropertyChange("bingoNumbers5", oldstr5, str5);

        String oldstr6 = str6;
        str6 = list.get(5).toString();

        changes.firePropertyChange("bingoNumbers6", oldstr6, str6);

        String oldstr7 = str7;
        str7 = list.get(6).toString();

        changes.firePropertyChange("bingoNumbers7", oldstr7, str7);

        String oldstr8 = str8;
        str8 = list.get(7).toString();

        changes.firePropertyChange("bingoNumbers8", oldstr8, str8);

        String oldstr9 = str9;
        str9 = list.get(8).toString();

        changes.firePropertyChange("bingoNumbers9", oldstr9, str9);

        String oldstr10 = str10;
        str10 = list.get(9).toString();

        changes.firePropertyChange("bingoNumbers10", oldstr10, str10);

        String oldstr11 = str11;
        str11 = list.get(10).toString();

        changes.firePropertyChange("bingoNumbers11", oldstr11, str11);

        String oldstr12 = str12;
        str12 = list.get(11).toString();

        changes.firePropertyChange("bingoNumbers12", oldstr12, str12);

        String oldstr13 = str13;
        str13 = list.get(12).toString();

        changes.firePropertyChange("bingoNumbers13", oldstr13, str13);

        String oldstr14 = str14;
        str14 = list.get(13).toString();

        changes.firePropertyChange("bingoNumbers14", oldstr14, str14);

        String oldstr15 = str15;
        str15 = list.get(14).toString();

        changes.firePropertyChange("bingoNumbers15", oldstr15, str15);

        String oldstr16 = str16;
        str16 = list.get(15).toString();

        changes.firePropertyChange("bingoNumbers16", oldstr16, str16);

        String oldstr17 = str17;
        str17 = list.get(16).toString();

        changes.firePropertyChange("bingoNumbers17", oldstr17, str17);

        String oldstr18 = str18;
        str18 = list.get(17).toString();

        changes.firePropertyChange("bingoNumbers18", oldstr18, str18);

        String oldstr19 = str19;
        str19 = list.get(18).toString();

        changes.firePropertyChange("bingoNumbers19", oldstr19, str19);

        String oldstr20 = str20;
        str20 = list.get(19).toString();

        changes.firePropertyChange("bingoNumbers20", oldstr20, str20);

        String oldstr21 = str21;
        str21 = list.get(20).toString();

        changes.firePropertyChange("bingoNumbers21", oldstr21, str21);

        String oldstr22 = str22;
        str22 = list.get(21).toString();

        changes.firePropertyChange("bingoNumbers22", oldstr22, str22);

        String oldstr23 = str23;
        str23 = list.get(22).toString();

        changes.firePropertyChange("bingoNumbers23", oldstr23, str23);

        String oldstr24 = str24;
        str24 = list.get(23).toString();

        changes.firePropertyChange("bingoNumbers24", oldstr24, str24);

        String oldstr25 = str25;
        str25 = list.get(24).toString();
        changes.firePropertyChange("bingoNumbers25", oldstr25, str25);

    }

    public void addPropertyChangeListner(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }

}
