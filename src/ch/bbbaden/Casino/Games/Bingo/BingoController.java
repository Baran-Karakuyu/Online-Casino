/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Bingo;

import ch.bbbaden.Casino.Games.Bingo.BingoViewModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Emirh
 */
public class BingoController implements Initializable {

    ArrayList<Button> cards = new ArrayList<Button>();
    ArrayList<StringProperty> texts = new ArrayList<>();
    ArrayList<Integer> randomNumbers = new ArrayList<>();

    private BingoViewModel viewModel;

    private Timeline timeline;
    private int startTime = 1;
    private Integer timeSeconds = startTime;

    Random rnd = new Random();

    @FXML
    private Label lblCredits;
    private boolean ende = false;
    @FXML
    private Label lblAlleNummer;

    public ArrayList<Integer> getRandomNumbers() {
        for (int i = 1; i <= 75; i++) {
            randomNumbers.add(i);

        }
        Collections.shuffle(randomNumbers);

        return randomNumbers;

    }

    public void startTimer() {
        final ArrayList<Integer> list = getRandomNumbers();
        final ArrayList<String> anzuzeigenderNummern = new ArrayList<>();

        timeline = new Timeline(30);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1),
                new EventHandler<ActionEvent>() {

            @Override

            public void handle(ActionEvent event) {
                lblZeit.setText(timeSeconds + " sekunden");

                timeSeconds--;

                if (timeSeconds == -1) {

                    timeline.stop();
                    for (int i = 0; i < 1; i++) {
                        
                        String aktuelleNummer = (list.get(i)).toString();

                        lblAktuelleNummer.setText(aktuelleNummer);

                        anzuzeigenderNummern.add(aktuelleNummer);
                        
                        lblAlleNummer.setText(lblAlleNummer.getText() + lblAktuelleNummer.getText() + ", ");

                    }

                    timeSeconds = 1;

                    if (!ende) {
                        startTimer();
                    }

                }
            }
        }
        );

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(keyFrame);

        timeline.play();
    }

    @FXML
    private Button btnCross1;
    @FXML
    private Button btnCross6;
    @FXML
    private Button btnCross11;
    @FXML
    private Button btnCross16;
    @FXML
    private Button btnCross21;
    @FXML
    private Button btnCross2;
    @FXML
    private Button btnCross7;
    @FXML
    private Button btnCross12;
    @FXML
    private Button btnCross17;
    @FXML
    private Button btnCross22;
    @FXML
    private Button btnCross3;
    @FXML
    private Button btnCross8;
    @FXML
    private Button btnCross13;
    @FXML
    private Button btnCross18;
    @FXML
    private Button btnCross23;
    @FXML
    private Button btnCross4;
    @FXML
    private Button btnCross9;
    @FXML
    private Button btnCross14;
    @FXML
    private Button btnCross19;
    @FXML
    private Button btnCross24;
    @FXML
    private Button btnCross5;
    @FXML
    private Button btnCross10;
    @FXML
    private Button btnCross15;
    @FXML
    private Button btnCross20;
    @FXML
    private Button btnCross25;

    @FXML
    private Label lblZeit;
    @FXML
    private Label lblAktuelleNummer;

    public void setViewModel(BingoViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public BingoController() {
//        cards.add(btnCross1);
//        cards.add(btnCross2);
//        cards.add(btnCross3);
//        cards.add(btnCross4);
//        cards.add(btnCross5);
//        cards.add(btnCross6);
//        cards.add(btnCross7);
//        cards.add(btnCross8);
//        cards.add(btnCross9);
//        cards.add(btnCross10);
//        cards.add(btnCross11);
//        cards.add(btnCross12);
//        cards.add(btnCross13);
//        cards.add(btnCross14);
//        cards.add(btnCross15);
//        cards.add(btnCross16);
//        cards.add(btnCross17);
//        cards.add(btnCross18);
//        cards.add(btnCross19);
//        cards.add(btnCross20);
//        cards.add(btnCross21);
//        cards.add(btnCross22);
//        cards.add(btnCross23);
//        cards.add(btnCross24);
//        cards.add(btnCross25);
    }

    public void bind() {
        btnCross1.textProperty().bind(viewModel.getStr1());
        btnCross2.textProperty().bind(viewModel.getStr2());
        btnCross3.textProperty().bind(viewModel.getStr3());
        btnCross4.textProperty().bind(viewModel.getStr4());
        btnCross5.textProperty().bind(viewModel.getStr5());
        btnCross6.textProperty().bind(viewModel.getStr6());
        btnCross7.textProperty().bind(viewModel.getStr7());
        btnCross8.textProperty().bind(viewModel.getStr8());
        btnCross9.textProperty().bind(viewModel.getStr9());
        btnCross10.textProperty().bind(viewModel.getStr10());
        btnCross11.textProperty().bind(viewModel.getStr11());
        btnCross12.textProperty().bind(viewModel.getStr12());
        btnCross13.textProperty().bind(viewModel.getStr13());
        btnCross14.textProperty().bind(viewModel.getStr14());
        btnCross15.textProperty().bind(viewModel.getStr15());
        btnCross16.textProperty().bind(viewModel.getStr16());
        btnCross17.textProperty().bind(viewModel.getStr17());
        btnCross18.textProperty().bind(viewModel.getStr18());
        btnCross19.textProperty().bind(viewModel.getStr19());
        btnCross20.textProperty().bind(viewModel.getStr20());
        btnCross21.textProperty().bind(viewModel.getStr21());
        btnCross22.textProperty().bind(viewModel.getStr22());
        btnCross23.textProperty().bind(viewModel.getStr23());
        btnCross24.textProperty().bind(viewModel.getStr24());
        btnCross25.textProperty().bind(viewModel.getStr25());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void ActionCross1(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross1.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross6(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross6.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross11(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross11.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross16(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross16.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross21(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross21.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross2(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross2.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross7(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross7.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross12(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross12.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross17(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross17.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross22(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross22.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross3(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross3.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross8(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross8.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross13(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross13.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross18(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross18.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross23(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross23.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross4(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross4.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross9(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross9.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross14(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross14.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross19(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross19.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross24(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross24.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross5(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross5.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross10(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross10.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross15(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross15.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross20(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross20.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionCross25(ActionEvent event) {

        for (int i = 0; i < 7; i++) {

            btnCross25.setStyle("-fx-base: rgb(" + (10 * i) + "," + (20 * i) + "," + (10 * i) + ");");
        }
    }

    @FXML
    private void ActionBingo(ActionEvent event) {
    }

    @FXML
    private void ActionVerlassen(MouseEvent event) {
        System.exit(0);
    }

    public void countdown() {
//        lblZeit.setText(count + "");
//        count--; //count down 

    }

//    public void showCards() {
//        viewModel.showCards();
//    }
}
