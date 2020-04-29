/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Bingo;

import Casino.DataBase.User;
import ch.bbbaden.Casino.MainApp;
import ch.bbbaden.Casino.Menu.ViewModel.ViewModel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Emirh
 */
public class UebersichtsSeiteController implements Initializable {

    private UebersichtsSeiteViewModel uebersichtsSeiteViewModel;
    private ViewModel viewModel;
    private User user;

    @FXML
    private Label lblCredits;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnRegeln;

    private MainApp mainApp;
    @FXML
    private Label imgVerlassen;

    public void setUebersichtsSeiteViewModel(UebersichtsSeiteViewModel uebersichtsSeiteViewModel) {
        this.uebersichtsSeiteViewModel = uebersichtsSeiteViewModel;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ActionStart(ActionEvent event) throws IOException {

        uebersichtsSeiteViewModel.setMainApp(mainApp);

        uebersichtsSeiteViewModel.showSpielkarteAuswahl();

    }

    public void bind() {

    }

    @FXML
    private void ActionVerlassen(MouseEvent event) throws IOException, SQLException, ClassNotFoundException {
        Stage stage = (Stage) imgVerlassen.getScene().getWindow();
        stage.close();

        mainApp.startMenu();
        
    }

    @FXML
    private void ActionRegeln(ActionEvent event) {

        JOptionPane.showMessageDialog(null,
                "Die Teilnehmer kaufen Lose oder auch Teilnahmecoupons, \n "
                + "die mit einer Anzahl von Zahlen bedruckt sind. \n "
                + "Ein Conférencier zieht wie beim Lotto per Zufall \naus einer Trommel Kugeln  "
                + "mit aufgedruckten  Zahlen. Er ruft diese Zahlen aus, woraufhin \n "
                + "die Teilnehmer sie auf ihren Spielkarten mit einem Farbstempel oder einem Stein markieren – sofern \n "
                + "sie die ausgerufenen Zahlen auf ihrem Teilnahmecoupon haben. \n "
                + "Sobald der erste Teilnehmer auf seinem Los alle 5 Zahlen einer waagerechten oder senkrechten Reihe oder Diagonale markieren konnte, \n "
                + "ruft er laut und vernehmlich „Bingo!“. […] Nach der Überprüfung \n seines Spielscheins ist er der Gewinner, erhält einen Sach- oder Geldpreis, \n "
                + "und die Spielrunde ist abgeschlossen.»",
                "Regeln des Bingo-Spiels",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
    }

    public void setUser(User user) {
        this.user = user;
        lblCredits.setText(Double.toString(user.getCredit()));
    }

}
