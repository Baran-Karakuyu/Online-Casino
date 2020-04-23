/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Login;

import Casino.DataBase.Query;
import Casino.DataBase.User;
import ch.bbbaden.Casino.MainApp;
import ch.bbbaden.Casino.Model.Model;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Andrei Oleniuc
 */
public class LoginViewController implements Initializable {

   @FXML
    private Button btnSubmit;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    
    private String name="";
    private String email = "";
    private String password = "";
    private int id= 0;
    Query sql = new Query();
    ArrayList<User> benutzer = new ArrayList<>();
    @FXML
    private Button close;
    private Model mo;
    private MainApp mainApp;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try {
           // TODO
           sql.updateUser();
       } catch (SQLException ex) {
           Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
       }
        

        for(int i=0;i<sql.getUsers().size();i++){
            benutzer.add(sql.getUsers().get(i));
        }
        
       try {
           sql.selectUsers();
       } catch (SQLException ex) {
           Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }    

    @FXML
    private void loginaction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
//        sql.updateUser();
        email = txtUsername.getText();
        password = txtPassword.getText();
        for(int i= 0;i<sql.getUsers().size();i++){
            if(benutzer.get(i).getEmail().equals(email)){
                if(benutzer.get(i).getPassword().equals(password)){
                    System.out.println("Gut");
                    mo.setUser(benutzer.get(i).getEmail(), benutzer.get(i).getPassword());
                    mainApp.startMenu();
                }else{
                    System.out.println("Password Falsch");
                }
            }
        }
    }   

    @FXML
    private void signUp(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("RegisterView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
        
        
        
    }
    
    public void createUser(String name,String email,String password) throws SQLException, ClassNotFoundException{
                
        sql.insertUsers(id, name, email, password, 0);
        sql.updateUser();
        sql.selectUsers();
        
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
