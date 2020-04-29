/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Bingo;

//import ch.bbbaden.ims.programmierwochen.bingo.MainApp;
import Casino.DataBase.User;
import ch.bbbaden.Casino.MainApp;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Emirh
 */
public class UebersichtsSeiteModel {

    private MainApp mainApp;
    private SpielkarteAuswahlModel model;
    private User user;
    private Stage stage;
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public void showSpielkarteAuswahl() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SpielKarteAuswahl.fxml"));
        Parent root;
        root = loader.load();

        SpielkarteAuswahlController view = loader.getController();
        this.model = new SpielkarteAuswahlModel(mainApp);
        model.setStage(stage);
        SpielkarteAuswahlViewModel viewModel = new SpielkarteAuswahlViewModel(model, mainApp);
        view.setViewModel(viewModel);
        view.setMainApp(mainApp);
        view.setUser(user);
        model.addPropertyChangeListner(viewModel);
        view.bind();

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

    public void addPropertyChangeListner(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }
}
