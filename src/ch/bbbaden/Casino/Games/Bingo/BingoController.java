/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Bingo;

import Casino.DataBase.User;
import ch.bbbaden.Casino.MainApp;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Emirhan Karaca
 */
public class BingoController implements Initializable {

    private BingoViewModel viewModel;
    private MainApp mainApp;
    private User user;

    //declaration of variables
    private Timeline timeline;
    private int startTime = 30;
    private Integer timeSeconds = startTime;
    ArrayList<Integer> randoms = new ArrayList<>();
    private boolean end = false;

    @FXML
    private Label lblCredits;
    @FXML
    private Label lblAllNumbers;
    @FXML
    private Label imgLeave;
    @FXML
    private Label lblTime;
    @FXML
    private Label lblCurrentNumbers;

    //Cards
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

    public void setBingoViewModel(BingoViewModel viewModel) {
        this.viewModel = viewModel;
    }

    //generates random numbers and then shuffles it so there are no duplicates
    public ArrayList<Integer> getRandomNumbers() {
        for (int i = 1; i <= 75; i++) {
            randoms.add(i);

        }
        Collections.shuffle(randoms);

        return randoms;

    }

    //timer which counts down from 30, if hits 0, generate a new random number
    public void startTimer() {
        final ArrayList<Integer> list = getRandomNumbers();

        timeline = new Timeline(30);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
            // update timerLabel
            lblTime.setText(timeSeconds + " sekunden");

            //time -1;
            timeSeconds--;

            if (timeSeconds == -1) {

                timeline.stop();

                for (int i = 0; i < 1; i++) {

                    String aktuelleNummer = (list.get(i)).toString();

                    lblCurrentNumbers.setText(aktuelleNummer);

                    lblAllNumbers.setText(lblAllNumbers.getText() + lblCurrentNumbers.getText() + ", ");

                }
                //set timer to 30
                timeSeconds = 30;

                if (!end) {
                    startTimer();
                }

            }
        });

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(keyFrame);

        timeline.play();
    }

    //binding of the cards
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

    //Cards can be marked
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
    private void ActionLeave(MouseEvent event) throws IOException, SQLException, ClassNotFoundException {

        Stage stage = (Stage) imgLeave.getScene().getWindow();
        stage.close();

        mainApp.startMenu();

    }
    //setMainApp
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    //setUser
    public void setUser(User user) {
        this.user = user;
        //set Credits of the user
        lblCredits.setText(Double.toString(user.getCredit()));
    }

}
