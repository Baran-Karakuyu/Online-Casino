/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Bingo;

import ch.bbbaden.Casino.MainApp;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Emirh
 */
public class SpielkarteAuswahlModel {

    private ArrayList<Integer> randomNumbers = new ArrayList<>();
    
    private Stage stage;
    public String str1;
    public String str2;
    public String str3;
    public String str4;
    public String str5;
    public String str6;
    public String str7;
    public String str8;
    public String str9;
    public String str10;
    public String str11;
    public String str12;
    public String str13;
    public String str14;
    public String str15;
    public String str16;
    public String str17;
    public String str18;
    public String str19;
    public String str20;
    public String str21;
    public String str22;
    public String str23;
    public String str24;
    public String str25;
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private BingoModel bingoModel;
    private MainApp mainApp;

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

    public void showBingo() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Bingo.fxml"));
        Parent root;

        root = loader.load();

        BingoController view = loader.getController();

        bingoModel = new BingoModel(mainApp, this);

        BingoViewModel bingoViewModel = new BingoViewModel(bingoModel);
        view.setViewModel(bingoViewModel);
        bingoModel.addPropertyChangeListner(bingoViewModel);
        view.bind();

        view.startTimer();
        bingoModel.showCards();
        Scene scene = new Scene(root);
        stage.resizableProperty().setValue(Boolean.FALSE);
        scene.getStylesheets().add("/styles/Bingo.css");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
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

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void addPropertyChangeListner(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }

}
