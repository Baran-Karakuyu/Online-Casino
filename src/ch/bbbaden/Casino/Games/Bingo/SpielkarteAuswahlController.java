/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Bingo;

import ch.bbbaden.Casino.Games.Bingo.SpielkarteAuswahlViewModel;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Emirh
 */
public class SpielkarteAuswahlController implements Initializable {

    private Random rnd = new Random();
    int randomNumber = rnd.nextInt(75) + 1;

    ArrayList<String> numbers = new ArrayList<>();

    private SpielkarteAuswahlViewModel viewModel;

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
    private Button btnAendern;
    @FXML
    private Button btnAuswaehlen;
    @FXML
    private Label lblKosten;

    public SpielkarteAuswahlController() {


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

    }

    @FXML
    private void ActionCross6(ActionEvent event) {
    }

    @FXML
    private void ActionCross11(ActionEvent event) {
    }

    @FXML
    private void ActionCross16(ActionEvent event) {
    }

    @FXML
    private void ActionCross21(ActionEvent event) {
    }

    @FXML
    private void ActionCross2(ActionEvent event) {
    }

    @FXML
    private void ActionCross7(ActionEvent event) {
    }

    @FXML
    private void ActionCross12(ActionEvent event) {
    }

    @FXML
    private void ActionCross17(ActionEvent event) {
    }

    @FXML
    private void ActionCross22(ActionEvent event) {
    }

    @FXML
    private void ActionCross3(ActionEvent event) {
    }

    @FXML
    private void ActionCross8(ActionEvent event) {
    }

    @FXML
    private void ActionCross13(ActionEvent event) {
    }

    @FXML
    private void ActionCross18(ActionEvent event) {
    }

    @FXML
    private void ActionCross23(ActionEvent event) {
    }

    @FXML
    private void ActionCross4(ActionEvent event) {
    }

    @FXML
    private void ActionCross9(ActionEvent event) {
    }

    @FXML
    private void ActionCross14(ActionEvent event) {
    }

    @FXML
    private void ActionCross19(ActionEvent event) {
    }

    @FXML
    private void ActionCross24(ActionEvent event) {
    }

    @FXML
    private void ActionCross5(ActionEvent event) {
    }

    @FXML
    private void ActionCross10(ActionEvent event) {
    }

    @FXML
    private void ActionCross15(ActionEvent event) {
    }

    @FXML
    private void ActionCross20(ActionEvent event) {
    }

    @FXML
    private void ActionCross25(ActionEvent event) {
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

    @FXML
    private void ActionAendern(ActionEvent event) {

        viewModel.ActionAendern();
    }

    @FXML
    private void ActionAuswaehlen(ActionEvent event) throws IOException {
        viewModel.showBingo();
    }

    public void setViewModel(SpielkarteAuswahlViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @FXML
    private void ActionVerlassen(MouseEvent event) {
        System.exit(0);
    }

}
