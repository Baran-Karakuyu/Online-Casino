/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Slots;

import ch.bbbaden.Casino.MainApp;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author Baran
 */
public class FXMLSlotsController implements Initializable {
    
    @FXML
    private AnchorPane apSlots;
    @FXML
    private Rectangle recBottom;
    @FXML
    private ImageView ivImageBottom;
    @FXML
    private Rectangle recSpinners;
    @FXML
    private ImageView ivSpinnerStop;
    @FXML
    private ImageView ivSpinnerForm;
    @FXML
    private Rectangle recTop;
    @FXML
    private ImageView ivImageTop;
    @FXML
    private ImageView ivPentagon;
    @FXML
    private Rectangle recConsoleBottom;
    @FXML
    private Rectangle recConsoleTop;
    @FXML
    private Rectangle rec5x;
    @FXML
    private Rectangle rec3x;
    @FXML
    private Rectangle rec2x;
    @FXML
    private Button btnPayOut;
    @FXML
    private Button btnDeposit;
    @FXML
    private Spinner<Integer> spnDeposit;
    @FXML
    private Label lblPlayerAccount;
    @FXML
    private Label lblWin;
    @FXML
    private Label lblPlayerAccountNumber;
    @FXML
    private Label lblWinNumber;
    @FXML
    private Button btnMystery;
    @FXML
    private Button btnBet;
    @FXML
    private Button btnGamble;
    @FXML
    private Button btnStop;
    @FXML
    private Rectangle recWins;
    @FXML
    private Button btnCancel;
    @FXML
    private Label lblBalance;
    @FXML
    private Label lblBalanceNumber;
    @FXML
    private Label lblM2x;
    @FXML
    private Label lblM3x;
    @FXML
    private Label lblM5x;
    @FXML
    private Rectangle recCC;
    @FXML
    private Label lblCC5x1;
    @FXML
    private Label lblCC5x2;
    @FXML
    private Label lblCC10x;
    @FXML
    private Label lblCC100x;
    @FXML
    private Label lblSpinner1;
    @FXML
    private Label lblSpinner2;
    @FXML
    private Label lblSpinner3;
    @FXML
    private Label lblBONUS;
    @FXML
    private Label lblWIN;
    @FXML
    private Label lblRiskNumber;
    @FXML
    private Label lblShuffleTwo;
    @FXML
    private Label lblShuffleFour;
    @FXML
    private Label lblCherryCollect;
    @FXML
    private Label lblTenTimes;
    @FXML
    private Label lblFruitStop1;
    @FXML
    private Label lblFruitStop2;
    @FXML
    private ImageView ivSpinner1;
    @FXML
    private ImageView ivSpinner2;
    @FXML
    private ImageView ivSpinner3;
    @FXML
    private ImageView ivWinTable;
    @FXML
    private Label lblConsole;
    @FXML
    private Label lblCCAction;
    @FXML
    private Label lblHold;
    @FXML
    private Label lblStep;
    @FXML
    private Label lblSuperCherryLogo;
    
    private SlotMachineViewModel viewModel;
    private final HashMap<String, Image> imagesSymbol = new HashMap<>();
    private int stopFunctionKey = 0;
    private int shuffleCounter = 0;
    private int spinCounter = 0;
    private int step = 1;
    private int cherryCollectPaintCounter = 0;
    private boolean shuffleChecker = false;
    private final ArrayList<String> selectedSymbolsString = new ArrayList<>();
    private MainApp mainApp;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnGamble.setDisable(true);
        btnMystery.setDisable(true);
        btnStop.setDisable(true);

        SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999999, 0);
        this.spnDeposit.setValueFactory(svf);
        lblWinNumber.setText("0");
        imagesSymbol.put("CHERRY", new Image("CasinoIMG/Slots/SlotsSymbole/Cherry.png"));
        imagesSymbol.put("TRAUBE", new Image("CasinoIMG/Slots/SlotsSymbole/Traube.png"));
        imagesSymbol.put("BANANE", new Image("CasinoIMG/Slots/SlotsSymbole/Banane.png"));
        imagesSymbol.put("ORANGE", new Image("CasinoIMG/Slots/SlotsSymbole/Orange.png"));
        imagesSymbol.put("ZITRONE", new Image("CasinoIMG/Slots/SlotsSymbole/Zitrone.png"));
        imagesSymbol.put("MELONE", new Image("CasinoIMG/Slots/SlotsSymbole/Melone.png"));
        imagesSymbol.put("BAR", new Image("CasinoIMG/Slots/SlotsSymbole/Bar.png"));
        imagesSymbol.put("GLOCKE", new Image("CasinoIMG/Slots/SlotsSymbole/Glocke.png"));
        imagesSymbol.put("SIEBEN", new Image("CasinoIMG/Slots/SlotsSymbole/7.png"));
        imagesSymbol.put("STERN", new Image("CasinoIMG/Slots/SlotsSymbole/Stern.png"));
    }

    @FXML
    private void handlePayOutButtonAction(ActionEvent event) {
        double geld = (Double.valueOf(lblWinNumber.getText()) + (Double.valueOf(lblPlayerAccountNumber.getText())));
        viewModel.payOut(geld);
    }

    @FXML
    private void handleDepositButtonAction(ActionEvent event) {
        int deposit = spnDeposit.getValue();
        viewModel.deposit(deposit);

        //Spinner wieder auf 0 setzen
        SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999999, 0);
        this.spnDeposit.setValueFactory(svf);
    }

    @FXML
    private void handleMysteryButtonAction(ActionEvent event) {
        lblWIN.setTextFill(Paint.valueOf("#000077"));
        double oldGewinn = Double.valueOf(lblWinNumber.getText());
        viewModel.mystery();
        double win = Double.valueOf(lblWinNumber.getText());

        if (win > oldGewinn) {
            lblWIN.setTextFill(Paint.valueOf("#0000ff"));
            if (win / 2 == oldGewinn) {
                lblM3x.setTextFill(Paint.valueOf("#000075"));
                lblM5x.setTextFill(Paint.valueOf("#750000"));
                lblM2x.setTextFill(Paint.valueOf("#00ff00"));
            } else if (win / 3 == oldGewinn) {
                lblM5x.setTextFill(Paint.valueOf("#750000"));
                lblM2x.setTextFill(Paint.valueOf("#007500"));
                lblM3x.setTextFill(Paint.valueOf("#0000ff"));
            } else if (win / 5 == oldGewinn) {
                lblM2x.setTextFill(Paint.valueOf("#007500"));
                lblM3x.setTextFill(Paint.valueOf("#000075"));
                lblM5x.setTextFill(Paint.valueOf("#ff0000"));
            }
        } else {
            lblM5x.setTextFill(Paint.valueOf("#750000"));
            lblM2x.setTextFill(Paint.valueOf("#007500"));
            lblM3x.setTextFill(Paint.valueOf("#000075"));
            lblWIN.setTextFill(Paint.valueOf("#000077"));
        }
    }

    @FXML
    private void handleBetButtonAction(ActionEvent event) {
        lblWIN.setTextFill(Paint.valueOf("#000077"));
        if (Double.valueOf(lblPlayerAccountNumber.getText()) > 0) {
            btnStop.setDisable(false);
            viewModel.bet();
        }
    }

    @FXML
    private void handleGambleButtonAction(ActionEvent event) {
        lblWIN.setTextFill(Paint.valueOf("#000077"));
        viewModel.gamble();
    }

    @FXML
    private void handleStopButtonAction(ActionEvent event) throws InterruptedException {
        lblWIN.setTextFill(Paint.valueOf("#000077"));

        //With three stars, a function is randomly selected from the pentagon
        if (ivSpinner1.getImage() == imagesSymbol.get("STERN") && ivSpinner2.getImage() == imagesSymbol.get("STERN") && ivSpinner3.getImage() == imagesSymbol.get("STERN")) {
            Random r = new Random();
            stopFunctionKey = r.nextInt(4) + 1;
        }

        //choosing the function
        switch (stopFunctionKey) {
            //Normal Spin
            case 0: {
                if (Double.valueOf(lblPlayerAccountNumber.getText()) > 0.0 && (Double.valueOf(lblPlayerAccountNumber.getText()) - (Double.valueOf(lblRiskNumber.getText())) >= 0.0)) {
                    //Zahlt Gewinn in Spielerkonto ein
                    if (!(lblWinNumber.getText().equals("0"))) {
                        viewModel.winToPlayerAccountNumber(Double.valueOf(lblWinNumber.getText()));
                    }

                    lblTenTimes.setTextFill(Paint.valueOf("#550088"));
                    lblShuffleTwo.setTextFill(Paint.valueOf("#007575"));
                    lblShuffleFour.setTextFill(Paint.valueOf("#007500"));
                    lblConsole.setText("0");
                    lblConsole.setOpacity(0);
                    lblCherryCollect.setTextFill(Paint.valueOf("#770000"));
                    lblCC5x1.setTextFill(Paint.valueOf("#7a7a00"));
                    lblCC5x2.setTextFill(Paint.valueOf("#7a7a00"));
                    lblCC10x.setTextFill(Paint.valueOf("#7a5a00"));
                    lblCC100x.setTextFill(Paint.valueOf("#7c2916"));
                    lblCCAction.setTextFill(Paint.valueOf("#7a0000"));
                    lblHold.setTextFill(Paint.valueOf("#750075"));
                    lblStep.setTextFill(Paint.valueOf("#007575"));
                    lblM2x.setTextFill(Paint.valueOf("#007500"));
                    lblM3x.setTextFill(Paint.valueOf("#000075"));
                    lblM5x.setTextFill(Paint.valueOf("#750000"));
                    cherryCollectPaintCounter = 0;
                    lblFruitStop1.setTextFill(Paint.valueOf("#000088"));
                    lblFruitStop2.setTextFill(Paint.valueOf("#880000"));

                    spinAnimation(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte Geld in den Automaten einzahlen!", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
            //2x Shuffle
            case 1: {
                //Zahlt Gewinn in Spielerkonto ein
                if (!(lblWinNumber.getText().equals("0"))) {
                    viewModel.winToPlayerAccountNumber(Double.valueOf(lblWinNumber.getText()));
                }

                lblShuffleTwo.setTextFill(Paint.valueOf("#00ffff"));
                if (shuffleCounter == 0 && shuffleChecker == false) {
                    shuffleCounter = 2;
                    shuffleChecker = true;
                }
                lblConsole.setText(String.valueOf(shuffleCounter) + " Spins");
                lblConsole.setOpacity(1);

                if (shuffleCounter == 0) {
                    stopFunctionKey = 0;
                    shuffleChecker = false;
                    break;
                }

                spinAnimation(1);
                shuffleCounter--;
                break;
            }
            //4x Shuffle
            case 2: {
                //Zahlt Gewinn in Spielerkonto ein
                if (!(lblWinNumber.getText().equals("0"))) {
                    viewModel.winToPlayerAccountNumber(Double.valueOf(lblWinNumber.getText()));
                }

                lblShuffleFour.setTextFill(Paint.valueOf("#00ff00"));
                if (shuffleCounter == 0 && shuffleChecker == false) {
                    shuffleCounter = 4;
                    shuffleChecker = true;
                }
                lblConsole.setText(String.valueOf(shuffleCounter) + " Spins");
                lblConsole.setOpacity(1);

                if (shuffleCounter == 0) {
                    stopFunctionKey = 0;
                    shuffleChecker = false;
                    break;
                }

                spinAnimation(1);
                shuffleCounter--;
                break;
            }
            //10x Shuffle
            case 3: {
                //Zahlt Gewinn in Spielerkonto ein
                if (!(lblWinNumber.getText().equals("0"))) {
                    viewModel.winToPlayerAccountNumber(Double.valueOf(lblWinNumber.getText()));
                }

                stopFunctionKey = 0;
                lblTenTimes.setTextFill(Paint.valueOf("#9d00ff"));
                lblConsole.setText("10x");
                lblConsole.setOpacity(1);
                spinAnimation(2);
                break;
            }
            //Cherry Collect
            case 4: {
                lblCherryCollect.setTextFill(Paint.valueOf("#ff0000"));

                if (step == 0) {
                    stopFunctionKey = 0;
                    lblConsole.setText("0");
                }

                spinAnimation(3);
                step--;
                break;
            }
            //Fruit Stop
            case 5: {
                //Zahlt Gewinn in Spielerkonto ein
                if (!(lblWinNumber.getText().equals("0"))) {
                    viewModel.winToPlayerAccountNumber(Double.valueOf(lblWinNumber.getText()));
                }

                stopFunctionKey = 0;
                lblFruitStop1.setTextFill(Paint.valueOf("#0000ff"));
                lblFruitStop2.setTextFill(Paint.valueOf("#ff0000"));
                spinAnimation(4);
                break;
            }
        }
    }

    @FXML
    private void handleCancelButtonAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        mainApp.startMenu();
    }

    private void spinAnimation(int AfterSpinKey) throws InterruptedException {
        spinCounter = 0;
        if (stopFunctionKey != 4) {
            viewModel.spinSpinners();
        }

        btnStop.setDisable(true);
        btnBet.setDisable(true);
        btnGamble.setDisable(true);
        btnMystery.setDisable(true);
        btnPayOut.setDisable(true);

        HashMap<Integer, String> animationSymolNames = new HashMap<>();
        animationSymolNames.put(0, "CHERRY");
        animationSymolNames.put(1, "TRAUBE");
        animationSymolNames.put(2, "BANANE");
        animationSymolNames.put(3, "ORANGE");
        animationSymolNames.put(4, "ZITRONE");
        animationSymolNames.put(5, "MELONE");
        animationSymolNames.put(6, "GLOCKE");
        animationSymolNames.put(7, "SIEBEN");
        animationSymolNames.put(8, "BAR");
        animationSymolNames.put(9, "STERN");

        PauseTransition pause = new PauseTransition(Duration.millis(150));
        pause.setOnFinished(event -> {
            Random r = new Random();
            ivSpinner1.setImage(imagesSymbol.get(animationSymolNames.get(r.nextInt(10))));
            ivSpinner2.setImage(imagesSymbol.get(animationSymolNames.get(r.nextInt(10))));
            ivSpinner3.setImage(imagesSymbol.get(animationSymolNames.get(r.nextInt(10))));
            spinCounter++;
            pause.play();
            if (spinCounter == 15) {
                pause.stop();
                if (AfterSpinKey == 0) {
                    try {
                        try {
                            normalSpin();
                        } catch (SQLException ex) {
                            Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (AfterSpinKey == 1) {
                    try {
                        shuffleSpin();
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (AfterSpinKey == 2) {
                    try {
                        tenTimes();
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (AfterSpinKey == 3) {
                    try {
                        cherryCollect();
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (AfterSpinKey == 4) {
                    fruitStop();
                }
            }
        });
        pause.play();
    }

    private void normalSpin() throws InterruptedException, SQLException, ClassNotFoundException {
        String strWalze1Symbol;
        String strWalze2Symbol;
        String strWalze3Symbol;
        selectedSymbolsString.clear();

        viewModel.spinSpinners();
        ivSpinner1.setImage(imagesSymbol.get(lblSpinner1.getText()));
        strWalze1Symbol = lblSpinner1.getText();

        viewModel.spinSpinners();
        ivSpinner2.setImage(imagesSymbol.get(lblSpinner2.getText()));
        strWalze2Symbol = lblSpinner2.getText();

        viewModel.spinSpinners();
        ivSpinner3.setImage(imagesSymbol.get(lblSpinner3.getText()));
        strWalze3Symbol = lblSpinner3.getText();

        //Speichert die Bilder der Walzen von links nach rechts ein
        for (String keyW1 : imagesSymbol.keySet()) {
            if (strWalze1Symbol.equals(keyW1)) {
                selectedSymbolsString.add(keyW1);
                for (String keyW2 : imagesSymbol.keySet()) {
                    if (strWalze2Symbol.equals(keyW2)) {
                        selectedSymbolsString.add(keyW2);
                        for (String keyW3 : imagesSymbol.keySet()) {
                            if (strWalze3Symbol.equals(keyW3)) {
                                selectedSymbolsString.add(keyW3);
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }

        Random r = new Random();
        int holdStepChooser = r.nextInt(4);

        //Choose between hold and step (hold 75% chance, step 25% chance)
        if (holdStepChooser <= 2) {
            hold();
        } else {
            step();
        }

        viewModel.checkWin(Double.valueOf(lblRiskNumber.getText()));

        checkButtonUnlock();
    }

    private void shuffleSpin() throws SQLException, ClassNotFoundException {
        viewModel.shuffle(9);
        ivSpinner1.setImage(imagesSymbol.get(lblSpinner1.getText()));
        ivSpinner2.setImage(imagesSymbol.get(lblSpinner2.getText()));
        ivSpinner3.setImage(imagesSymbol.get(lblSpinner3.getText()));

        viewModel.checkWin(Double.valueOf(lblRiskNumber.getText()));
        checkButtonUnlock();
    }

    private void tenTimes() throws SQLException, ClassNotFoundException, ClassNotFoundException {
        viewModel.tenTimes(9);
        ivSpinner1.setImage(imagesSymbol.get(lblSpinner1.getText()));
        viewModel.tenTimes(9);
        ivSpinner2.setImage(imagesSymbol.get(lblSpinner2.getText()));
        viewModel.tenTimes(9);
        ivSpinner3.setImage(imagesSymbol.get(lblSpinner3.getText()));

        viewModel.checkWin(Double.valueOf(lblRiskNumber.getText()) * 10);
        checkButtonUnlock();
    }

    private void cherryCollect() throws SQLException, ClassNotFoundException, ClassNotFoundException{
        if (lblConsole.getText().isEmpty() || lblConsole.getText().equals("0")) {
            Random r = new Random();
            ArrayList<Integer> stepsNumbers = new ArrayList<>();
            stepsNumbers.add(5);
            stepsNumbers.add(10);
            stepsNumbers.add(15);

            step = stepsNumbers.get(r.nextInt(3));
        }
        lblConsole.setText(String.valueOf(step));
        lblConsole.setOpacity(1);

        viewModel.cherryCollect(10);
        ivSpinner1.setImage(imagesSymbol.get(lblSpinner1.getText()));
        viewModel.cherryCollect(10);
        ivSpinner2.setImage(imagesSymbol.get(lblSpinner2.getText()));
        viewModel.cherryCollect(10);
        ivSpinner3.setImage(imagesSymbol.get(lblSpinner3.getText()));

        viewModel.checkWin(Double.valueOf(lblRiskNumber.getText()));
        checkButtonUnlock();

        if (ivSpinner1.getImage() == imagesSymbol.get("CHERRY") || ivSpinner2.getImage() == imagesSymbol.get("CHERRY") || ivSpinner3.getImage() == imagesSymbol.get("CHERRY")) {
            cherryCollectAction();
        }
    }

    private void cherryCollectAction() throws SQLException, ClassNotFoundException, ClassNotFoundException{
        double ccBerechnung;

        //checks if there was a cherry and the lights the labels one an other on top left of the GUI up
        if (cherryCollectPaintCounter == 0) {
            lblCC5x1.setTextFill(Paint.valueOf("#ffff00"));
            ccBerechnung = (Double.valueOf(lblRiskNumber.getText())) * 5;
            viewModel.win(ccBerechnung);
            checkButtonUnlock();
            cherryCollectPaintCounter++;
        } else if (cherryCollectPaintCounter == 1) {
            lblCC5x2.setTextFill(Paint.valueOf("#ffff00"));
            ccBerechnung = (Double.valueOf(lblRiskNumber.getText())) * 5;
            viewModel.win(ccBerechnung);
            checkButtonUnlock();
            cherryCollectPaintCounter++;
        } else if (cherryCollectPaintCounter == 2) {
            lblCC10x.setTextFill(Paint.valueOf("#ffbb00"));
            ccBerechnung = (Double.valueOf(lblRiskNumber.getText())) * 10;
            viewModel.win(ccBerechnung);
            checkButtonUnlock();
            cherryCollectPaintCounter++;
        } else if (cherryCollectPaintCounter == 3) {
            lblCC100x.setTextFill(Paint.valueOf("#ff5630"));
            ccBerechnung = (Double.valueOf(lblRiskNumber.getText())) * 100;
            viewModel.win(ccBerechnung);
            checkButtonUnlock();
            cherryCollectPaintCounter++;
        } else if (cherryCollectPaintCounter == 4) {
            lblCCAction.setTextFill(Paint.valueOf("#ff0000"));
            ccBerechnung = (Double.valueOf(lblRiskNumber.getText())) * 400;
            viewModel.win(ccBerechnung);
            checkButtonUnlock();
        }
    }

    private void hold() throws SQLException, ClassNotFoundException, ClassNotFoundException{
        //waiting for a second, then showing an other symbol
        if (!(selectedSymbolsString.get(0).equals(selectedSymbolsString.get(1)) && (selectedSymbolsString.get(1).equals(selectedSymbolsString.get(2))))) {
            PauseTransition ptSpinner1 = new PauseTransition(Duration.millis(1000));
            ptSpinner1.setOnFinished(event -> {
                //selecting in wich place a new symbol has to be choosed
                if (selectedSymbolsString.get(0).equals(selectedSymbolsString.get(1))) {                try {
                    //right spinner
                    lblHold.setTextFill(Paint.valueOf("#ff00ff"));
                    viewModel.changeSelected(2, selectedSymbolsString.get(2), true, new String[]{selectedSymbolsString.get(0), selectedSymbolsString.get(1), selectedSymbolsString.get(2)});
                    viewModel.holdAndStep(2, 10);
                    ivSpinner3.setImage(imagesSymbol.get(lblSpinner3.getText()));
                    viewModel.checkWin(Double.valueOf(lblRiskNumber.getText()));
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (selectedSymbolsString.get(0).equals(selectedSymbolsString.get(2))) {         try {
                    //middle spinner
                    lblHold.setTextFill(Paint.valueOf("#ff00ff"));
                    viewModel.changeSelected(1, selectedSymbolsString.get(1), true, new String[]{selectedSymbolsString.get(0), selectedSymbolsString.get(1), selectedSymbolsString.get(2)});
                    viewModel.holdAndStep(1, 10);
                    ivSpinner2.setImage(imagesSymbol.get(lblSpinner2.getText()));
                    viewModel.checkWin(Double.valueOf(lblRiskNumber.getText()));
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (selectedSymbolsString.get(1).equals(selectedSymbolsString.get(2))) {         try {
                    //left spinner
                    lblHold.setTextFill(Paint.valueOf("#ff00ff"));
                    viewModel.changeSelected(0, selectedSymbolsString.get(0), true, new String[]{selectedSymbolsString.get(0), selectedSymbolsString.get(1), selectedSymbolsString.get(2)});
                    viewModel.holdAndStep(0, 10);
                    ivSpinner1.setImage(imagesSymbol.get(lblSpinner1.getText()));
                    viewModel.checkWin(Double.valueOf(lblRiskNumber.getText()));
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                checkButtonUnlock();
            });
            ptSpinner1.play();
        }
    }

    private void step() throws SQLException, ClassNotFoundException, ClassNotFoundException{
        if (!(selectedSymbolsString.get(0).equals(selectedSymbolsString.get(1)) && (selectedSymbolsString.get(1).equals(selectedSymbolsString.get(2))))) {
            spinCounter = 0;

            PauseTransition ptSpinners = new PauseTransition(Duration.millis(500));
            ptSpinners.setOnFinished(event -> {
                if (selectedSymbolsString.get(0).equals(selectedSymbolsString.get(1))) {                //right spinner
                    lblStep.setTextFill(Paint.valueOf("#00ffff"));
                    viewModel.holdAndStep(2, 10);
                    ivSpinner3.setImage(imagesSymbol.get(lblSpinner3.getText()));

                    //checking if randomly choosen Symbol is a cherry, then changes to stepCherryChecker
                    if (lblSpinner3.getText().equals("CHERRY")) {
                        stepCherryChecker(2);
                        ptSpinners.stop();
                        return;
                    }
                    spinCounter++;
                    ptSpinners.play();
                    if (spinCounter == 4 || lblSpinner3.getText().equals(selectedSymbolsString.get(0))) {
                        try {
                            ivSpinner3.setImage(imagesSymbol.get(selectedSymbolsString.get(0)));
                            viewModel.changeSelected(2, selectedSymbolsString.get(0), false, new String[0]);
                            viewModel.checkWin(Double.valueOf(lblRiskNumber.getText()));
                            checkButtonUnlock();
                            ptSpinners.stop();
                        } catch (SQLException ex) {
                            Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else if (selectedSymbolsString.get(0).equals(selectedSymbolsString.get(2))) {         //middle spinner
                    lblStep.setTextFill(Paint.valueOf("#00ffff"));
                    viewModel.holdAndStep(1, 10);
                    ivSpinner2.setImage(imagesSymbol.get(lblSpinner2.getText()));

                    //checking if randomly choosen Symbol is a cherry, then changes to stepCherryChecker
                    if (lblSpinner2.getText().equals("CHERRY")) {
                        stepCherryChecker(1);
                        ptSpinners.stop();
                        return;
                    }
                    spinCounter++;
                    ptSpinners.play();
                    if (spinCounter == 5 || lblSpinner2.getText().equals(selectedSymbolsString.get(0))) {
                        try {
                            ivSpinner2.setImage(imagesSymbol.get(selectedSymbolsString.get(0)));
                            viewModel.changeSelected(1, selectedSymbolsString.get(0), false, new String[0]);
                            viewModel.checkWin(Double.valueOf(lblRiskNumber.getText()));
                            checkButtonUnlock();
                            ptSpinners.stop();
                        } catch (SQLException ex) {
                            Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else if (selectedSymbolsString.get(1).equals(selectedSymbolsString.get(2))) {         //left spinner
                    lblStep.setTextFill(Paint.valueOf("#00ffff"));
                    viewModel.holdAndStep(0, 10);
                    ivSpinner1.setImage(imagesSymbol.get(lblSpinner1.getText()));

                    //checking if randomly choosen Symbol is a cherry, then changes to stepCherryChecker
                    if (lblSpinner1.getText().equals("CHERRY")) {
                        stepCherryChecker(0);
                        ptSpinners.stop();
                        return;
                    }
                    spinCounter++;
                    ptSpinners.play();
                    if (spinCounter == 3 || lblSpinner1.getText().equals(selectedSymbolsString.get(1))) {
                        try {
                            ivSpinner1.setImage(imagesSymbol.get(selectedSymbolsString.get(1)));
                            viewModel.changeSelected(0, selectedSymbolsString.get(1), false, new String[0]);
                            viewModel.checkWin(Double.valueOf(lblRiskNumber.getText()));
                            checkButtonUnlock();
                            ptSpinners.stop();
                        } catch (SQLException ex) {
                            Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
            ptSpinners.play();
        }
    }

    private void stepCherryChecker(int cherryPosition) {
        spinCounter = 0;

        //replaces the symbols on the spinner with a cherry
        //Stepanimation for the spinners
        if (cherryPosition == 0) {
            PauseTransition ptCherrySpinner1 = new PauseTransition(Duration.millis(500));
            ptCherrySpinner1.setOnFinished(event -> {
                viewModel.holdCherry(1, 9);
                ivSpinner2.setImage(imagesSymbol.get(lblSpinner2.getText()));
                viewModel.holdCherry(2, 9);
                ivSpinner3.setImage(imagesSymbol.get(lblSpinner3.getText()));
                spinCounter++;
                ptCherrySpinner1.play();

                if (spinCounter == 4) {
                    try {
                        ivSpinner2.setImage(imagesSymbol.get("CHERRY"));
                        ivSpinner3.setImage(imagesSymbol.get("CHERRY"));
                        viewModel.changeSelected(1, "CHERRY", false, new String[0]);
                        viewModel.changeSelected(2, "CHERRY", false, new String[0]);
                        viewModel.checkWin(Double.valueOf(lblRiskNumber.getText()));
                        checkButtonUnlock();
                        ptCherrySpinner1.stop();
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            ptCherrySpinner1.play();
        } else if (cherryPosition == 1) {
            PauseTransition ptCherrySpinner2 = new PauseTransition(Duration.millis(500));
            ptCherrySpinner2.setOnFinished(event -> {
                viewModel.holdCherry(0, 9);
                ivSpinner1.setImage(imagesSymbol.get(lblSpinner2.getText()));
                viewModel.holdCherry(2, 9);
                ivSpinner3.setImage(imagesSymbol.get(lblSpinner3.getText()));
                spinCounter++;
                ptCherrySpinner2.play();

                if (spinCounter == 3) {
                    try {
                        ivSpinner1.setImage(imagesSymbol.get("CHERRY"));
                        ivSpinner3.setImage(imagesSymbol.get("CHERRY"));
                        viewModel.changeSelected(0, "CHERRY", false, new String[0]);
                        viewModel.changeSelected(2, "CHERRY", false, new String[0]);
                        viewModel.checkWin(Double.valueOf(lblRiskNumber.getText()));
                        checkButtonUnlock();
                        ptCherrySpinner2.stop();
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            ptCherrySpinner2.play();
        } else if (cherryPosition == 2) {
            PauseTransition ptCherrySpinner3 = new PauseTransition(Duration.millis(500));
            ptCherrySpinner3.setOnFinished(event -> {
                viewModel.holdCherry(0, 9);
                ivSpinner1.setImage(imagesSymbol.get(lblSpinner2.getText()));
                viewModel.holdCherry(1, 9);
                ivSpinner2.setImage(imagesSymbol.get(lblSpinner3.getText()));
                spinCounter++;
                ptCherrySpinner3.play();

                if (spinCounter == 5) {
                    try {
                        ivSpinner1.setImage(imagesSymbol.get("CHERRY"));
                        ivSpinner2.setImage(imagesSymbol.get("CHERRY"));
                        viewModel.changeSelected(0, "CHERRY", false, new String[0]);
                        viewModel.changeSelected(1, "CHERRY", false, new String[0]);
                        viewModel.checkWin(Double.valueOf(lblRiskNumber.getText()));
                        checkButtonUnlock();
                        ptCherrySpinner3.stop();
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            ptCherrySpinner3.play();
        }
    }

    private void fruitStop() {
        ArrayList<String> symbolOptions = new ArrayList<>();

        //choosing random symbols
        viewModel.fruitStop(9);
        ivSpinner1.setImage(imagesSymbol.get(lblSpinner1.getText()));
        symbolOptions.add(lblSpinner1.getText());

        viewModel.fruitStop(9);
        ivSpinner2.setImage(imagesSymbol.get(lblSpinner2.getText()));
        symbolOptions.add(lblSpinner1.getText());

        viewModel.fruitStop(9);
        ivSpinner3.setImage(imagesSymbol.get(lblSpinner3.getText()));
        symbolOptions.add(lblSpinner1.getText());

        //waits 1 seconds
        PauseTransition pause = new PauseTransition(Duration.millis(1000));
        pause.setOnFinished(event -> {
            if (btnStop.isPressed() == false) {
                try {
                    Random r = new Random();
                    int auswahl = r.nextInt(3);
                    
                    //randomly chooses one spinner and replaces the other symbols with the choosen one
                    if (auswahl == 0) {
                        ivSpinner2.setImage(imagesSymbol.get(symbolOptions.get(0)));
                        ivSpinner3.setImage(imagesSymbol.get(symbolOptions.get(0)));
                        viewModel.changeSelected(1, symbolOptions.get(0), false, new String[0]);
                        viewModel.changeSelected(2, symbolOptions.get(0), false, new String[0]);
                    } else if (auswahl == 1) {
                        ivSpinner1.setImage(imagesSymbol.get(symbolOptions.get(1)));
                        ivSpinner3.setImage(imagesSymbol.get(symbolOptions.get(1)));
                        viewModel.changeSelected(0, symbolOptions.get(1), false, new String[0]);
                        viewModel.changeSelected(2, symbolOptions.get(1), false, new String[0]);
                    } else if (auswahl == 2) {
                        ivSpinner1.setImage(imagesSymbol.get(symbolOptions.get(2)));
                        ivSpinner2.setImage(imagesSymbol.get(symbolOptions.get(2)));
                        viewModel.changeSelected(0, symbolOptions.get(2), false, new String[0]);
                        viewModel.changeSelected(1, symbolOptions.get(2), false, new String[0]);
                    }
                    viewModel.checkWin(Double.valueOf(lblRiskNumber.getText()));
                    checkButtonUnlock();
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        pause.play();
    }

    private void checkButtonUnlock() {
        if ((Double.valueOf(lblWinNumber.getText()) > 0.0)) {      //Unlocks all buttons if player won
            btnGamble.setDisable(false);
            btnMystery.setDisable(false);
            btnStop.setDisable(false);
            btnBet.setDisable(false);
            btnPayOut.setDisable(false);
        } else {                                                    //disables two buttons if player didn't win
            btnStop.setDisable(false);
            btnBet.setDisable(false);
            btnPayOut.setDisable(false);
            btnGamble.setDisable(true);
            btnMystery.setDisable(true);
        }
    }
    
    public void bind() {
        lblPlayerAccountNumber.textProperty().bind(viewModel.getPlayerAccountNumber());
        lblBalanceNumber.textProperty().bind(viewModel.getBalanceNumber());
        lblSpinner1.textProperty().bind(viewModel.getSpinnerNumber());
        lblSpinner2.textProperty().bind(viewModel.getSpinnerNumber());
        lblSpinner3.textProperty().bind(viewModel.getSpinnerNumber());
        lblWinNumber.textProperty().bind(viewModel.getWinNumber());
        lblRiskNumber.textProperty().bind(viewModel.getRiskNumber());
    }

    public void setViewModel(SlotMachineViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
