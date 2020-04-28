/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Bingo;

//import ch.bbbaden.ims.programmierwochen.bingo.MainApp;
import ch.bbbaden.Casino.MainApp;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Emirh
 */
public class BingoModel {

//    private MainApp mainApp;
    private SpielkarteAuswahlModel spielkarteAuswahlModel;
    private MainApp mainApp;
    private String str1 = "";
    private String str2 = "";
    private String str3 = "";
    private String str4 = "";
    private String str5 = "";
    private String str6 = "";
    private String str7 = "";
    private String str8 = "";
    private String str9 = "";
    private String str10 = "";
    private String str11 = "";
    private String str12 = "";
    private String str13 = "";
    private String str14 = "";
    private String str15 = "";
    private String str16 = "";
    private String str17 = "";
    private String str18 = "";
    private String str19 = "";
    private String str20 = "";
    private String str21 = "";
    private String str22 = "";
    private String str23 = "";
    private String str24 = "";
    private String str25 = "";
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public BingoModel(MainApp mainApp, SpielkarteAuswahlModel model) {
        this.mainApp = mainApp;
        this.spielkarteAuswahlModel = model;

    }

    public void showCards() {
        String oldstr1 = "";
        str1 = spielkarteAuswahlModel.str1;
        changes.firePropertyChange("bingoNumbers1", oldstr1, str1);

        String oldstr2 = "";
        str2 = spielkarteAuswahlModel.str2;
        changes.firePropertyChange("bingoNumbers2", oldstr2, str2);

        String oldstr3 = "";
        str3 = spielkarteAuswahlModel.str3;
        changes.firePropertyChange("bingoNumbers3", oldstr3, str3);

        String oldstr4 = "";
        str4 = spielkarteAuswahlModel.str4;
        changes.firePropertyChange("bingoNumbers4", oldstr4, str4);

        String oldstr5 = "";
        str5 = spielkarteAuswahlModel.str5;
        changes.firePropertyChange("bingoNumbers5", oldstr5, str5);

        String oldstr6 = "";
        str6 = spielkarteAuswahlModel.str6;
        changes.firePropertyChange("bingoNumbers6", oldstr6, str6);

        String oldstr7 = "";
        str7 = spielkarteAuswahlModel.str7;
        changes.firePropertyChange("bingoNumbers7", oldstr7, str7);

        String oldstr8 = "";
        str8 = spielkarteAuswahlModel.str8;
        changes.firePropertyChange("bingoNumbers8", oldstr8, str8);

        String oldstr9 = "";
        str9 = spielkarteAuswahlModel.str9;
        changes.firePropertyChange("bingoNumbers9", oldstr9, str9);

        String oldstr10 = "";
        str10 = spielkarteAuswahlModel.str10;
        changes.firePropertyChange("bingoNumbers10", oldstr10, str10);

        String oldstr11 = "";
        str11 = spielkarteAuswahlModel.str11;
        changes.firePropertyChange("bingoNumbers11", oldstr11, str11);

        String oldstr12 = "";
        str12 = spielkarteAuswahlModel.str12;
        changes.firePropertyChange("bingoNumbers12", oldstr12, str12);

        String oldstr13 = "";
        str13 = spielkarteAuswahlModel.str13;
        changes.firePropertyChange("bingoNumbers13", oldstr13, str13);

        String oldstr14 = "";
        str14 = spielkarteAuswahlModel.str14;
        changes.firePropertyChange("bingoNumbers14", oldstr14, str14);

        String oldstr15 = "";
        str15 = spielkarteAuswahlModel.str15;
        changes.firePropertyChange("bingoNumbers15", oldstr15, str15);

        String oldstr16 = "";
        str16 = spielkarteAuswahlModel.str16;
        changes.firePropertyChange("bingoNumbers16", oldstr16, str16);

        String oldstr17 = "";
        str17 = spielkarteAuswahlModel.str17;
        changes.firePropertyChange("bingoNumbers17", oldstr17, str17);

        String oldstr18 = "";
        str18 = spielkarteAuswahlModel.str18;
        changes.firePropertyChange("bingoNumbers18", oldstr18, str18);

        String oldstr19 = "";
        str19 = spielkarteAuswahlModel.str19;
        changes.firePropertyChange("bingoNumbers19", oldstr19, str19);

        String oldstr20 = "";
        str20 = spielkarteAuswahlModel.str20;
        changes.firePropertyChange("bingoNumbers20", oldstr20, str20);

        String oldstr21 = "";
        str21 = spielkarteAuswahlModel.str21;
        changes.firePropertyChange("bingoNumbers21", oldstr21, str21);

        String oldstr22 = "";
        str22 = spielkarteAuswahlModel.str22;
        changes.firePropertyChange("bingoNumbers22", oldstr22, str22);

        String oldstr23 = "";
        str23 = spielkarteAuswahlModel.str23;
        changes.firePropertyChange("bingoNumbers23", oldstr23, str23);

        String oldstr24 = "";
        str24 = spielkarteAuswahlModel.str24;
        changes.firePropertyChange("bingoNumbers24", oldstr24, str24);

        String oldstr25 = "";
        str25 = spielkarteAuswahlModel.str25;
        changes.firePropertyChange("bingoNumbers25", oldstr25, str25);

    }

    public void addPropertyChangeListner(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }
}
