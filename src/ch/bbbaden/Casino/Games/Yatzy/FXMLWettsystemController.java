package ch.bbbaden.Casino.Games.Yatzy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author yanni
 */
public class FXMLWettsystemController implements Initializable {

    @FXML
    private Label warnung;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    //Objekte BetSystem

    public int wetteinsatz = 0;

    private boolean erhöhen = true;

    @FXML
    private Label lblWetteinsatz;

    @FXML
    private ImageView chip50;

    @FXML
    private ImageView chip100;

    @FXML
    private ImageView chip250;

    @FXML
    private ImageView chip10;

    @FXML
    private ImageView chip1000;
    @FXML
    private ImageView minus;
    @FXML
    private ImageView plus;
    @FXML
    private Button btnBestätigen;

    //Code für Betsystem
    private void updateBet() {
        if (wetteinsatz < 0) {
            wetteinsatz = 0;
        }

        lblWetteinsatz.setText(wetteinsatz + " CHF");

    }

    @FXML
    private void einsatzErhöhen(MouseEvent event) {
        erhöhen = true;
    }

    @FXML
    private void einsatzVertiefen(MouseEvent event) {
        erhöhen = false;
    }

    @FXML
    private void auswahlChip50(MouseEvent event) {
        if (erhöhen) {
            wetteinsatz += 50;
        } else {
            wetteinsatz -= 50;
        }

        updateBet();

    }

    @FXML
    private void auswahlChip100(MouseEvent event) {
        if (erhöhen) {
            wetteinsatz += 100;
        } else {
            wetteinsatz -= 100;
        }

        updateBet();

    }

    @FXML
    private void auswahlChip250(MouseEvent event) {
        if (erhöhen) {
            wetteinsatz += 250;
        } else {
            wetteinsatz -= 250;
        }

        updateBet();

    }

    @FXML
    private void auswahlChip10(MouseEvent event) {

        if (erhöhen) {
            wetteinsatz += 10;
        } else {
            wetteinsatz -= 10;
        }

        updateBet();

    }

    @FXML
    private void auswahlChip1000(MouseEvent event) {
        if (erhöhen) {
            wetteinsatz += 1000;
        } else {
            wetteinsatz -= 1000;
        }

        updateBet();

    }

    @FXML
    private void setWetteinsatz(ActionEvent event) throws IOException {

FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));

            Parent root = loader.load();

            FXMLDocumentController DocumentController = loader.getController();

            

            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.setScene(scene);
            
            if(wetteinsatz <= DocumentController.kontostand){
            stage.show();
            
           DocumentController.getÜbergabe(wetteinsatz);
           
           Stage stage2 = (Stage) btnBestätigen.getScene().getWindow();
             stage2.close();
            }
            
            else{
                warnung.setVisible(true);
            }

    }

}
