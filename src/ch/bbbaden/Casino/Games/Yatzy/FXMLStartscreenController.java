/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Yatzy;

import Casino.DataBase.User;
import ch.bbbaden.Casino.MainApp;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXMLStartscreenController
 *
 * @author Yannick Wulf
 */
public class FXMLStartscreenController implements Initializable {

    @FXML
    private Button btnStart;

    @FXML
    private Button btnBeenden;
    
    private User user;
    private MainApp mainApp;
    private Stage stage;

    @FXML
    private void closeButtonAction() throws IOException, SQLException, ClassNotFoundException {
        stage = (Stage) btnBeenden.getScene().getWindow();
        stage.close();

        mainApp.startMenu();
    }

    @FXML
    public void starten(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
//        Parent root;
//        root = loader.load();
//
//        FXMLMainYatzy view = loader.getController();
//        view.setUser(user);
//        view.setStage(stage);
//        view.setMainApp(mainApp);
//        Scene scene = new Scene(root);
//
//        stage.setScene(scene);
//        stage.show();
          mainApp.startYatzy(0);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
