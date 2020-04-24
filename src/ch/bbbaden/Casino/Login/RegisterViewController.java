/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Login;

import Casino.DataBase.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    ArrayList<User> benutzer = new ArrayList<>();
    String name = "";
    String email = "";
    String password = "";
    int credits=0;
    LoginViewController controller1 = new LoginViewController();
    @FXML
    private Button close;
    @FXML
    private Label StartMoneyField;
    @FXML
    private TextField creditField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void signUp(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        name = nameField.getText();
        email = emailField.getText();
        password = passwordField.getText();
        try{
            credits= Integer.parseInt(creditField.getText());
        }catch(Exception ee){
            System.out.println("Geben sie richtiges Format ein");
        }
        
        if (nameField.getText().isEmpty()!=true&&emailField.getText().isEmpty()!=true&&passwordField.getText().isEmpty()!=true) {
            controller1.createUser(name, email, password,credits);

            //Go Back to View 1
            Stage stage = (Stage) close.getScene().getWindow();

            Parent tableViewParent = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
            
        } else {
            System.out.println("Kein neuer User");
        }

    }
}
