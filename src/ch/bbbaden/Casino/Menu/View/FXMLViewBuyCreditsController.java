/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Menu.View;

import ch.bbbaden.Casino.Menu.ViewModel.ViewModelBuyCredits;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Baran
 */
public class FXMLViewBuyCreditsController implements Initializable {

    @FXML
    private TextField tfAmountNumber;

    ViewModelBuyCredits vm;
    @FXML
    private Button btnBuyCredits;
    @FXML
    private Button btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void BuyButtonActionHandling(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        int amount = 0;
        boolean numberChecker = false;

        try {
            numberChecker = false;
            amount = Integer.valueOf(tfAmountNumber.getText());
        } catch (Exception e) {
            numberChecker = true;
            JOptionPane.showMessageDialog(null, "Bitte nur Zahlen eingeben!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }

        if (numberChecker == false) {
            vm.buyCredits(amount);
        }
    }

    @FXML
    private void CancelButtonActionHandling(ActionEvent event) {
    }

    public void setVm(ViewModelBuyCredits vm) {
        this.vm = vm;
    }
}
