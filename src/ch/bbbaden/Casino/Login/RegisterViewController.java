/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Login;

import ch.bbbaden.Casino.MainApp;
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
 * @author Andrei Oleniuc
 */
public class RegisterViewController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button close;
    @FXML
    private Label StartMoneyField;
    @FXML
    private TextField creditField;

    private MainApp mainApp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void signUp(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        String name = "";
        String email = "";
        String password = "";
        int credits = 0;
        LoginViewController controller1 = new LoginViewController();
        String AllowedChars = "[a-zA-Z0-9@.]*";
        boolean invalidChecker = false;

        //Check name for unallowed chars
        try {
            if (nameField.getText().matches(AllowedChars)) {
                name = nameField.getText();
                invalidChecker = false;
            } else {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie einen Namen ein!", "Fehler", JOptionPane.ERROR_MESSAGE);
                invalidChecker = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bitte verwenden Sie nur Buchstaben und Zahlen!", "Fehler", JOptionPane.ERROR_MESSAGE);
            invalidChecker = true;
        }

        //Check email for unallowed chars
        try {
            if (emailField.getText().matches(AllowedChars)) {
                email = emailField.getText();
                invalidChecker = false;
            } else {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie eine Email an!", "Fehler", JOptionPane.ERROR_MESSAGE);
                invalidChecker = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bitte verwenden Sie nur Buchstaben und Zahlen!", "Fehler", JOptionPane.ERROR_MESSAGE);
            invalidChecker = true;
        }

        //Check password for unallowed chars
        try {
            if (passwordField.getText().matches(AllowedChars) && (!(passwordField.getText().isEmpty()))) {
                password = passwordField.getText();
                invalidChecker = false;
            } else {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie ein Passwort ein ein!", "Fehler", JOptionPane.ERROR_MESSAGE);
                invalidChecker = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bitte verwenden Sie nur Buchstaben und Zahlen!", "Fehler", JOptionPane.ERROR_MESSAGE);
            invalidChecker = true;
        }

        //Check if credits are int
        try {
            invalidChecker = false;
            credits = Integer.parseInt(creditField.getText());
        } catch (NumberFormatException ee) {
            if (creditField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie Ihr Startgeld ein!", "Fehler", JOptionPane.ERROR_MESSAGE);
                invalidChecker = true;
            } else {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie nur Zahlen ein!", "Fehler", JOptionPane.ERROR_MESSAGE);
                invalidChecker = true;
            }
        }

        if (nameField.getText().isEmpty() != true && emailField.getText().isEmpty() != true && passwordField.getText().isEmpty() != true && creditField.getText().isEmpty() != true && invalidChecker == false) {
            mainApp.startLogin();
            controller1.createUser(name, email, password, credits);
        } else {
            System.out.println("Kein neuer User");
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

}
