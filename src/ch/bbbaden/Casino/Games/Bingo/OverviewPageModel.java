/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Bingo;

import Casino.DataBase.User;
import ch.bbbaden.Casino.MainApp;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Emirhan Karaca
 */
public class OverviewPageModel {

    private MainApp mainApp;
    private CardSelectionModel cardSelectionModel;
    private User user;
    private Stage stage;

    //declaration of variable
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);

    //shows the "CardSelection" Scene
    public void showCardSelection() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CardSelection.fxml"));
        Parent root;
        root = loader.load();

        CardSelectionController cardSelectionController = loader.getController();
        this.cardSelectionModel = new CardSelectionModel(mainApp);
        cardSelectionModel.setStage(stage);
        CardSelectionViewModel cardSelectionViewModel = new CardSelectionViewModel(cardSelectionModel, mainApp);
        cardSelectionController.setCardSelectionViewModel(cardSelectionViewModel);
        cardSelectionController.setMainApp(mainApp);
        cardSelectionController.setUser(user);
        cardSelectionModel.addPropertyChangeListner(cardSelectionViewModel);
        cardSelectionController.bind();
        Scene scene = new Scene(root);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    //adds the listener
    public void addPropertyChangeListner(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }
}
