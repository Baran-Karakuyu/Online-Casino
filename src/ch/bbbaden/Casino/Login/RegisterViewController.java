/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Login;

import Casino.DataBase.Query;
import ch.bbbaden.Casino.MainApp;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    private final Query sql = new Query();

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
        String AllowedChars = "[a-zA-Z0-9@.]*";
        Pattern pattern = Pattern.compile("[A-Za-z0-9.]+@[A-Za-z0-9.]+\\.[A-Za-z]{2,4}");
        boolean nameInvalidChecker = false;
        boolean emailInvalidChecker = false;
        boolean passwordInvalidChecker = false;
        boolean balanceInvalidChecker = false;

        //Check name for unallowed chars
        try {
            if (nameField.getText().matches(AllowedChars)) {
                name = nameField.getText();
                nameInvalidChecker = false;
            } else {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie einen Namen ein!", "Fehler", JOptionPane.ERROR_MESSAGE);
                nameInvalidChecker = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bitte verwenden Sie nur Buchstaben und Zahlen!", "Fehler", JOptionPane.ERROR_MESSAGE);
            nameInvalidChecker = true;
        }

        //Check email for unallowed chars
        try {
            Matcher matEmail = pattern.matcher(emailField.getText());
            
            if (matEmail.matches()) {
                email = emailField.getText();
                emailInvalidChecker = false;
            } else {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie eine Email an!", "Fehler", JOptionPane.ERROR_MESSAGE);
                emailInvalidChecker = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bitte verwenden Sie nur Buchstaben und Zahlen!", "Fehler", JOptionPane.ERROR_MESSAGE);
            emailInvalidChecker = true;
        }

        //Check password for unallowed chars
        try {
            if (passwordField.getText().matches(AllowedChars) && (!(passwordField.getText().isEmpty()))) {
                password = passwordField.getText();
                passwordInvalidChecker = false;
            } else {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie ein Passwort ein ein!", "Fehler", JOptionPane.ERROR_MESSAGE);
                passwordInvalidChecker = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bitte verwenden Sie nur Buchstaben und Zahlen!", "Fehler", JOptionPane.ERROR_MESSAGE);
            passwordInvalidChecker = true;
        }

        //Check if credits are integer
        try {
            balanceInvalidChecker = false;
            credits = Integer.parseInt(creditField.getText());
        } catch (NumberFormatException ee) {
            if (creditField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie Ihr Startgeld ein!", "Fehler", JOptionPane.ERROR_MESSAGE);
                balanceInvalidChecker = true;
            } else {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie nur Zahlen ein!", "Fehler", JOptionPane.ERROR_MESSAGE);
                balanceInvalidChecker = true;
            }
        }

        if (nameField.getText().isEmpty() != true && emailField.getText().isEmpty() != true && passwordField.getText().isEmpty() != true && creditField.getText().isEmpty() != true && nameInvalidChecker == false && emailInvalidChecker == false && passwordInvalidChecker == false && balanceInvalidChecker == false) {
            mainApp.startLogin();
            createUser(name, email, password, credits);
        } else {
            System.out.println("Kein neuer User");
        }
    }

    public void createUser(String name, String email, String password, int credits) throws SQLException, ClassNotFoundException {
        sql.insertUsers(0, name, email, password, credits);
        sql.updateUser();
        sql.selectUsers();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void closeBtn(ActionEvent event) {
        System.exit(0);
    }

}
