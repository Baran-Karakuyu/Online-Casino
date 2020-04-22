/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Slots;


import java.net.URL;
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

/**
 *
 * @author Baran
 */
public class FXMLSlotsController implements Initializable {

    @FXML
    private AnchorPane apSlots;
    @FXML
    private Rectangle recOben;
    @FXML
    private Rectangle recUnten;
    @FXML
    private Button btnAuszahlen;
    @FXML
    private Button btnEInwerfen;
    @FXML
    private Spinner<Integer> spnEinwerfen;
    @FXML
    private Label lblSpielerkonto;
    @FXML
    private Label lblGewinn;
    @FXML
    private Label lblSpielerkontoZahl;
    @FXML
    private Label lblGewinnZahl;
    @FXML
    private Button btnMystery;
    @FXML
    private Button btnBet;
    @FXML
    private Button btnGamble;
    @FXML
    private Button btnStop;
    @FXML
    private Rectangle recWalzen;
    @FXML
    private Rectangle recWins;
    @FXML
    private Button btnAbbrechen;
    @FXML
    private Label lblKontostand;
    @FXML
    private Label lblKontostandZahl;
    @FXML
    private Rectangle rec5x;
    @FXML
    private Rectangle rec3x;
    @FXML
    private Rectangle rec2x;
    @FXML
    private Rectangle rec2x1;
    @FXML
    private Label lblWalze1;
    @FXML
    private Label lblWalze2;
    @FXML
    private Label lblWalze3;
    @FXML
    private Label lblLightLeft;
    @FXML
    private Label lblLightMiddle;
    @FXML
    private Label lblLightRight;
    @FXML
    private Label lblLightStop;
    @FXML
    private Label lblBONUS;
    @FXML
    private Label lblWIN;
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
    private Label lblTenTimesScreen;
    @FXML
    private ImageView ivWalze1;
    @FXML
    private ImageView ivWalze2;
    @FXML
    private ImageView ivWalze3;
    @FXML
    private ImageView ivWalzeStop;
    @FXML
    private ImageView ivSpinnerForm;
    @FXML
    private ImageView ivPentagon;
    @FXML
    private Label lblCherryCollectSteps;
    @FXML
    private Label lblCC5x1;
    @FXML
    private Label lblCC5x2;
    @FXML
    private Label lblCC10x;
    @FXML
    private Label lblCC100x;
    @FXML
    private Label lblCCAction;
    @FXML
    private Label lblRisikoZahl;
    @FXML
    private Label lblHold;
    @FXML
    private Label lblStep;
    @FXML
    private Label lblM2x;
    @FXML
    private Label lblM3x;
    @FXML
    private Label lblM5x;

    private SlotMachineViewModel viewModel;
    private final HashMap<String, Image> imagesSymbol = new HashMap<>();
    private int stopFunctionKey = 0;
    private int shuffleCounter = 0;
    private int spinCounter = 0;
    private int step = 0;
    private int cherryCollectPaintCounter = 0;
    private ArrayList<String> selectedSymbolsString = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999999, 0);
        this.spnEinwerfen.setValueFactory(svf);
        lblGewinnZahl.setText("0");
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
    private void handleAuszahlenButtonAction(ActionEvent event) {
        double geld = (Double.valueOf(lblGewinnZahl.getText()) + (Double.valueOf(lblSpielerkontoZahl.getText())));
        viewModel.auszahlen(geld);
    }

    @FXML
    private void handleEinwerfenButtonAction(ActionEvent event) {
        int einwurf = spnEinwerfen.getValue();
        viewModel.einwurf(einwurf);

        //Spinner wieder auf 0 setzen
        SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999999, 0);
        this.spnEinwerfen.setValueFactory(svf);
    }

    @FXML
    private void handleMysteryButtonAction(ActionEvent event) {
        lblWIN.setTextFill(Paint.valueOf("#000077"));
        double oldGewinn = Double.valueOf(lblGewinnZahl.getText());
        viewModel.mystery();
        double gewinn = Double.valueOf(lblGewinnZahl.getText());

        if (gewinn > oldGewinn) {
            lblWIN.setTextFill(Paint.valueOf("#0000ff"));
            if (gewinn / 2 == oldGewinn) {
                lblM3x.setTextFill(Paint.valueOf("#000075"));
                lblM5x.setTextFill(Paint.valueOf("#750000"));
                lblM2x.setTextFill(Paint.valueOf("#00ff00"));
            } else if (gewinn / 3 == oldGewinn) {
                lblM5x.setTextFill(Paint.valueOf("#750000"));
                lblM2x.setTextFill(Paint.valueOf("#007500"));
                lblM3x.setTextFill(Paint.valueOf("#0000ff"));
            } else if (gewinn / 5 == oldGewinn) {
                lblM2x.setTextFill(Paint.valueOf("#007500"));
                lblM3x.setTextFill(Paint.valueOf("#000075"));
                lblM5x.setTextFill(Paint.valueOf("#ff0000"));
            }
        } else {
            lblWIN.setTextFill(Paint.valueOf("#000077"));
        }
    }

    @FXML
    private void handleBetButtonAction(ActionEvent event) {
        lblWIN.setTextFill(Paint.valueOf("#000077"));
        viewModel.bet();
    }

    @FXML
    private void handleGambleButtonAction(ActionEvent event) {
        lblWIN.setTextFill(Paint.valueOf("#000077"));
        viewModel.gamblen();
    }

    @FXML
    private void handleStopButtonAction(ActionEvent event) throws InterruptedException {
        lblWIN.setTextFill(Paint.valueOf("#000077"));
        lichterspiel();
        //Welche Funktion ausgewählt wird
        switch (stopFunctionKey) {
            //Normale Funktion
            case 0: {
                if (Double.valueOf(lblSpielerkontoZahl.getText()) > 0.0 && (Double.valueOf(lblSpielerkontoZahl.getText()) - (Double.valueOf(lblRisikoZahl.getText()) * 0.1) >= 0.0)) {
                    //Zahlt Gewinn in Spielerkonto ein
                    if (!(lblGewinnZahl.getText().equals("0"))) {
                        viewModel.gewinnInsSpielerkonto(Double.valueOf(lblGewinnZahl.getText()));
                    }

                    lblTenTimes.setTextFill(Paint.valueOf("#550088"));
                    lblShuffleTwo.setTextFill(Paint.valueOf("#007575"));
                    lblShuffleFour.setTextFill(Paint.valueOf("#007500"));
                    lblTenTimesScreen.setOpacity(0);
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

                    //Bei drei Sternen wird zufällig eine Funktion vom Pentagon ausgewahlt
                    if (ivWalze1.getImage() == imagesSymbol.get("STERN") && ivWalze2.getImage() == imagesSymbol.get("STERN") && ivWalze3.getImage() == imagesSymbol.get("STERN")) {
                        Random r = new Random();
                        stopFunctionKey = r.nextInt(4) + 1;
                    } else {
                        spinAnimation(0);
                    }
                }
                break;
            }
            //2x Shuffle
            case 1: {
                if (shuffleCounter >= 1) {
                    stopFunctionKey = 0;
                    shuffleCounter = 0;
                    break;
                }
                lblShuffleTwo.setTextFill(Paint.valueOf("#00ffff"));
                spinAnimation(1);
                break;
            }
            //4x Shuffle
            case 2: {
                if (shuffleCounter >= 3) {
                    stopFunctionKey = 0;
                    shuffleCounter = 0;
                    break;
                }
                lblShuffleFour.setTextFill(Paint.valueOf("#00ff00"));
                spinAnimation(1);
                break;
            }
            //10x Shuffle
            case 3: {
                stopFunctionKey = 0;
                lblTenTimes.setTextFill(Paint.valueOf("#9d00ff"));
                spinAnimation(2);
                break;
            }
            //Cherry Collect
            case 4: {
                lblCherryCollect.setTextFill(Paint.valueOf("#ff0000"));
                spinAnimation(3);

                if (step == 0) {
                    stopFunctionKey = 0;
                    lblCherryCollectSteps.setText("0");
                }
                break;
            }
        }

    }

    @FXML
    private void handleAbbrechenButtonAction(ActionEvent event) {
        System.exit(0);
    }

    private void lichterspiel() {

    }

    private void spinAnimation(int AfterSpinKey) throws InterruptedException {
        spinCounter = 0;
        viewModel.walzenDrehen();

        btnStop.setDisable(true);
        btnBet.setDisable(true);
        btnGamble.setDisable(true);
        btnMystery.setDisable(true);
        btnAuszahlen.setDisable(true);

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
            ivWalze1.setImage(imagesSymbol.get(animationSymolNames.get(r.nextInt(10))));
            ivWalze2.setImage(imagesSymbol.get(animationSymolNames.get(r.nextInt(10))));
            ivWalze3.setImage(imagesSymbol.get(animationSymolNames.get(r.nextInt(10))));
            spinCounter++;
            pause.play();
            if (spinCounter == 15) {
                pause.stop();
                if (AfterSpinKey == 0) {
                    try {
                        normalSpin();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FXMLSlotsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (AfterSpinKey == 1) {
                    shuffleSpin();
                } else if (AfterSpinKey == 2) {
                    tenTimes();
                } else if (AfterSpinKey == 3) {
                    cherryCollect();
                }
            }
        });
        pause.play();
    }

    public void normalSpin() throws InterruptedException {
        String strWalze1Symbol;
        String strWalze2Symbol;
        String strWalze3Symbol;
        selectedSymbolsString.clear();

        viewModel.walzenDrehen();
        ivWalze1.setImage(imagesSymbol.get(lblWalze1.getText()));
        strWalze1Symbol = lblWalze1.getText();

        viewModel.walzenDrehen();
        ivWalze2.setImage(imagesSymbol.get(lblWalze2.getText()));
        strWalze2Symbol = lblWalze2.getText();

        viewModel.walzenDrehen();
        ivWalze3.setImage(imagesSymbol.get(lblWalze3.getText()));
        strWalze3Symbol = lblWalze3.getText();

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
        int holdStepChsoser = r.nextInt(4);

        //Choose between hold and step (hold 75% chance, step 25% chance)
        if (holdStepChsoser <= 2) {
            hold();
        } else {
            step();
        }

        viewModel.gewinnUeberpruefen(0.1 * (Integer.valueOf(lblRisikoZahl.getText())));

        btnStop.setDisable(false);
        btnBet.setDisable(false);
        btnAuszahlen.setDisable(false);
        checkButtonUnlock();
    }

    public void shuffleSpin() {
        shuffleCounter++;

        viewModel.shuffle(9);
        ivWalze1.setImage(imagesSymbol.get(lblWalze1.getText()));
        ivWalze2.setImage(imagesSymbol.get(lblWalze2.getText()));
        ivWalze3.setImage(imagesSymbol.get(lblWalze3.getText()));

        viewModel.gewinnUeberpruefen(0.1 * (Integer.valueOf(lblRisikoZahl.getText())));
        checkButtonUnlock();
    }

    public void tenTimes() {
        lblTenTimesScreen.setOpacity(1);

        viewModel.tenTimes(9);
        ivWalze1.setImage(imagesSymbol.get(lblWalze1.getText()));
        viewModel.tenTimes(9);
        ivWalze2.setImage(imagesSymbol.get(lblWalze2.getText()));
        viewModel.tenTimes(9);
        ivWalze3.setImage(imagesSymbol.get(lblWalze3.getText()));

        viewModel.gewinnUeberpruefen(0.1 * (Integer.valueOf(lblRisikoZahl.getText()) * 10));
        checkButtonUnlock();
    }

    public void cherryCollect() {
        if (lblCherryCollectSteps.getText().isEmpty() || lblCherryCollectSteps.getText().equals("0")) {
            Random r = new Random();
            ArrayList<Integer> stepsNumbers = new ArrayList<>();
            stepsNumbers.add(5);
            stepsNumbers.add(10);
            stepsNumbers.add(15);

            step = stepsNumbers.get(r.nextInt(3));
        }
        lblCherryCollectSteps.setText(String.valueOf(step));

        viewModel.cherryCollect(10);
        ivWalze1.setImage(imagesSymbol.get(lblWalze1.getText()));
        viewModel.cherryCollect(10);
        ivWalze2.setImage(imagesSymbol.get(lblWalze2.getText()));
        viewModel.cherryCollect(10);
        ivWalze3.setImage(imagesSymbol.get(lblWalze3.getText()));

        step--;

        if (ivWalze1.getImage() == imagesSymbol.get("CHERRY") || ivWalze2.getImage() == imagesSymbol.get("CHERRY") || ivWalze3.getImage() == imagesSymbol.get("CHERRY")) {
            cherryCollectAction();
        }
    }

    private void cherryCollectAction() {
        double ccBerechnung;

        if (cherryCollectPaintCounter == 0) {
            lblCC5x1.setTextFill(Paint.valueOf("#ffff00"));
            ccBerechnung = (Double.valueOf(lblRisikoZahl.getText()) * 0.1) * 5;
            viewModel.gewinn(ccBerechnung);
            checkButtonUnlock();
            cherryCollectPaintCounter++;
        } else if (cherryCollectPaintCounter == 1) {
            lblCC5x2.setTextFill(Paint.valueOf("#ffff00"));
            ccBerechnung = (Double.valueOf(lblRisikoZahl.getText()) * 0.1) * 5;
            viewModel.gewinn(ccBerechnung);
            checkButtonUnlock();
            cherryCollectPaintCounter++;
        } else if (cherryCollectPaintCounter == 2) {
            lblCC10x.setTextFill(Paint.valueOf("#ffbb00"));
            ccBerechnung = (Double.valueOf(lblRisikoZahl.getText()) * 0.1) * 10;
            viewModel.gewinn(ccBerechnung);
            checkButtonUnlock();
            cherryCollectPaintCounter++;
        } else if (cherryCollectPaintCounter == 3) {
            lblCC100x.setTextFill(Paint.valueOf("#ff5630"));
            ccBerechnung = (Double.valueOf(lblRisikoZahl.getText()) * 0.1) * 100;
            viewModel.gewinn(ccBerechnung);
            checkButtonUnlock();
            cherryCollectPaintCounter++;
        } else if (cherryCollectPaintCounter == 4) {
            lblCCAction.setTextFill(Paint.valueOf("#ff0000"));
            ccBerechnung = (Double.valueOf(lblRisikoZahl.getText()) * 0.1) * 400;
            viewModel.gewinn(ccBerechnung);
            checkButtonUnlock();
        }
    }

    public void hold() {
        PauseTransition ptSpinner1 = new PauseTransition(Duration.millis(750));
        ptSpinner1.setOnFinished(event -> {
            if (selectedSymbolsString.get(0).equals(selectedSymbolsString.get(1))) {
                lblHold.setTextFill(Paint.valueOf("#ff00ff"));
                viewModel.holdAndStep(2, 10);
                ivWalze3.setImage(imagesSymbol.get(lblWalze3.getText()));
                viewModel.gewinnUeberpruefen(0.1 * (Integer.valueOf(lblRisikoZahl.getText())));
            } else if (selectedSymbolsString.get(0).equals(selectedSymbolsString.get(2))) {
                lblHold.setTextFill(Paint.valueOf("#ff00ff"));
                viewModel.holdAndStep(1, 10);
                ivWalze2.setImage(imagesSymbol.get(lblWalze2.getText()));
                viewModel.gewinnUeberpruefen(0.1 * (Integer.valueOf(lblRisikoZahl.getText())));
            } else if (selectedSymbolsString.get(1).equals(selectedSymbolsString.get(2))) {
                lblHold.setTextFill(Paint.valueOf("#ff00ff"));
                viewModel.holdAndStep(0, 10);
                ivWalze1.setImage(imagesSymbol.get(lblWalze1.getText()));
                viewModel.gewinnUeberpruefen(0.1 * (Integer.valueOf(lblRisikoZahl.getText())));
            }
        });
        ptSpinner1.play();
    }

    public void step() {
        if (!(selectedSymbolsString.get(0).equals(selectedSymbolsString.get(1)) && (selectedSymbolsString.get(1).equals(selectedSymbolsString.get(2))))) {
            spinCounter = 0;

            PauseTransition ptSpinners = new PauseTransition(Duration.millis(500));
            ptSpinners.setOnFinished(event -> {
                if (selectedSymbolsString.get(0).equals(selectedSymbolsString.get(1))) {
                    lblStep.setTextFill(Paint.valueOf("#00ffff"));
                    viewModel.holdAndStep(2, 10);
                    ivWalze3.setImage(imagesSymbol.get(lblWalze3.getText()));
                    if (lblWalze3.getText().equals("CHERRY")) {
                        stepCherryChecker(2);
                        ptSpinners.stop();
                        return;
                    }
                    spinCounter++;
                    ptSpinners.play();
                    if (spinCounter == 4 || lblWalze3.getText().equals(selectedSymbolsString.get(0))) {
                        ivWalze3.setImage(imagesSymbol.get(selectedSymbolsString.get(0)));
                        viewModel.changeSelected(2, selectedSymbolsString.get(0));
                        viewModel.gewinnUeberpruefen(0.1 * (Integer.valueOf(lblRisikoZahl.getText())));
                        checkButtonUnlock();
                        ptSpinners.stop();
                    }
                } else if (selectedSymbolsString.get(0).equals(selectedSymbolsString.get(2))) {
                    lblStep.setTextFill(Paint.valueOf("#00ffff"));
                    viewModel.holdAndStep(1, 10);
                    ivWalze2.setImage(imagesSymbol.get(lblWalze2.getText()));
                    if (lblWalze2.getText().equals("CHERRY")) {
                        stepCherryChecker(1);
                        ptSpinners.stop();
                        return;
                    }
                    spinCounter++;
                    ptSpinners.play();
                    if (spinCounter == 5 || lblWalze2.getText().equals(selectedSymbolsString.get(0))) {
                        ivWalze2.setImage(imagesSymbol.get(selectedSymbolsString.get(0)));
                        viewModel.changeSelected(1, selectedSymbolsString.get(0));
                        viewModel.gewinnUeberpruefen(0.1 * (Integer.valueOf(lblRisikoZahl.getText())));
                        checkButtonUnlock();
                        ptSpinners.stop();
                    }
                } else if (selectedSymbolsString.get(1).equals(selectedSymbolsString.get(2))) {
                    lblStep.setTextFill(Paint.valueOf("#00ffff"));
                    viewModel.holdAndStep(0, 10);
                    ivWalze1.setImage(imagesSymbol.get(lblWalze1.getText()));
                    if (lblWalze1.getText().equals("CHERRY")) {
                        stepCherryChecker(0);
                        ptSpinners.stop();
                        return;
                    }
                    spinCounter++;
                    ptSpinners.play();
                    if (spinCounter == 3 || lblWalze1.getText().equals(selectedSymbolsString.get(1))) {
                        ivWalze1.setImage(imagesSymbol.get(selectedSymbolsString.get(1)));
                        viewModel.changeSelected(0, selectedSymbolsString.get(1));
                        viewModel.gewinnUeberpruefen(0.1 * (Integer.valueOf(lblRisikoZahl.getText())));
                        checkButtonUnlock();
                        ptSpinners.stop();
                    }
                }
            });
            ptSpinners.play();

            //Stepanimation für die Walzen
//            if (selectedSymbolsString.get(0).equals(selectedSymbolsString.get(1))) {
//                lblStep.setTextFill(Paint.valueOf("#00ffff"));
//                PauseTransition ptSpinner1 = new PauseTransition(Duration.millis(500));
//                ptSpinner1.setOnFinished(event -> {
//                    viewModel.holdAndStep(2, 10);
//                    ivWalze3.setImage(imagesSymbol.get(lblWalze3.getText()));
//                    if (lblWalze3.getText().equals("CHERRY")) {
//                        stepCherryChecker(2);
//                        ptSpinner1.stop();
//                        return;
//                    }
//                    spinCounter++;
//                    ptSpinner1.play();
//                    if (spinCounter == 4 || lblWalze3.getText().equals(selectedSymbolsString.get(0))) {
//                        ivWalze3.setImage(imagesSymbol.get(selectedSymbolsString.get(0)));
//                        viewModel.changeSelected(2, selectedSymbolsString.get(0));
//                        viewModel.gewinnUeberpruefen(0.1 * (Integer.valueOf(lblRisikoZahl.getText())));
//                        ptSpinner1.stop();
//                    }
//                });
//                ptSpinner1.play();
//            } else if (selectedSymbolsString.get(0).equals(selectedSymbolsString.get(2))) {
//                lblStep.setTextFill(Paint.valueOf("#00ffff"));
//                PauseTransition ptSpinner2 = new PauseTransition(Duration.millis(500));
//                ptSpinner2.setOnFinished(event -> {
//                    viewModel.holdAndStep(1, 10);
//                    ivWalze2.setImage(imagesSymbol.get(lblWalze2.getText()));
//                    if (lblWalze2.getText().equals("CHERRY")) {
//                        stepCherryChecker(1);
//                        ptSpinner2.stop();
//                        return;
//                    }
//                    spinCounter++;
//                    ptSpinner2.play();
//                    if (spinCounter == 5 || lblWalze2.getText().equals(selectedSymbolsString.get(0))) {
//                        ivWalze2.setImage(imagesSymbol.get(selectedSymbolsString.get(0)));
//                        viewModel.changeSelected(1, selectedSymbolsString.get(0));
//                        viewModel.gewinnUeberpruefen(0.1 * (Integer.valueOf(lblRisikoZahl.getText())));
//                        ptSpinner2.stop();
//                    }
//                });
//                ptSpinner2.play();
//            } else if (selectedSymbolsString.get(1).equals(selectedSymbolsString.get(2))) {
//                lblStep.setTextFill(Paint.valueOf("#00ffff"));
//                PauseTransition ptSpinner3 = new PauseTransition(Duration.millis(500));
//                ptSpinner3.setOnFinished(event -> {
//                    viewModel.holdAndStep(0, 10);
//                    ivWalze1.setImage(imagesSymbol.get(lblWalze1.getText()));
//                    if (lblWalze1.getText().equals("CHERRY")) {
//                        stepCherryChecker(0);
//                        ptSpinner3.stop();
//                        return;
//                    }
//                    spinCounter++;
//                    ptSpinner3.play();
//                    if (spinCounter == 3 || lblWalze1.getText().equals(selectedSymbolsString.get(1))) {
//                        ivWalze1.setImage(imagesSymbol.get(selectedSymbolsString.get(1)));
//                        viewModel.changeSelected(0, selectedSymbolsString.get(1));
//                        viewModel.gewinnUeberpruefen(0.1 * (Integer.valueOf(lblRisikoZahl.getText())));
//                        ptSpinner3.stop();
//                    }
//                });
//                ptSpinner3.play();
//            }
        }
    }

    public void stepCherryChecker(int cherryPosition) {
        //Stepanimation für die Walzen
        if (cherryPosition == 0) {
            PauseTransition ptCherrySpinner1 = new PauseTransition(Duration.millis(500));
            ptCherrySpinner1.setOnFinished(event -> {
                viewModel.holdCherry(1, 9);
                ivWalze2.setImage(imagesSymbol.get(lblWalze2.getText()));
                viewModel.holdCherry(2, 9);
                ivWalze3.setImage(imagesSymbol.get(lblWalze3.getText()));
                spinCounter++;
                ptCherrySpinner1.play();
                if (spinCounter == 4) {
                    ivWalze2.setImage(imagesSymbol.get("CHERRY"));
                    ivWalze3.setImage(imagesSymbol.get("CHERRY"));
                    viewModel.changeSelected(1, "CHERRY");
                    viewModel.changeSelected(2, "CHERRY");
                    viewModel.gewinnUeberpruefen(0.1 * (Integer.valueOf(lblRisikoZahl.getText())));
                    checkButtonUnlock();
                    ptCherrySpinner1.stop();
                }
            });
            ptCherrySpinner1.play();
        } else if (cherryPosition == 1) {
            PauseTransition ptCherrySpinner2 = new PauseTransition(Duration.millis(500));
            ptCherrySpinner2.setOnFinished(event -> {
                viewModel.holdCherry(0, 9);
                ivWalze1.setImage(imagesSymbol.get(lblWalze2.getText()));
                viewModel.holdCherry(2, 9);
                ivWalze3.setImage(imagesSymbol.get(lblWalze3.getText()));
                spinCounter++;
                ptCherrySpinner2.play();
                if (spinCounter == 3) {
                    ivWalze1.setImage(imagesSymbol.get("CHERRY"));
                    ivWalze3.setImage(imagesSymbol.get("CHERRY"));
                    viewModel.changeSelected(0, "CHERRY");
                    viewModel.changeSelected(2, "CHERRY");
                    viewModel.gewinnUeberpruefen(0.1 * (Integer.valueOf(lblRisikoZahl.getText())));
                    checkButtonUnlock();
                    ptCherrySpinner2.stop();
                }
            });
            ptCherrySpinner2.play();
        } else if (cherryPosition == 2) {
            PauseTransition ptCherrySpinner3 = new PauseTransition(Duration.millis(500));
            ptCherrySpinner3.setOnFinished(event -> {
                viewModel.holdCherry(0, 9);
                ivWalze1.setImage(imagesSymbol.get(lblWalze2.getText()));
                viewModel.holdCherry(1, 9);
                ivWalze2.setImage(imagesSymbol.get(lblWalze3.getText()));
                spinCounter++;
                ptCherrySpinner3.play();
                if (spinCounter == 5) {
                    ivWalze1.setImage(imagesSymbol.get("CHERRY"));
                    ivWalze2.setImage(imagesSymbol.get("CHERRY"));
                    viewModel.changeSelected(0, "CHERRY");
                    viewModel.changeSelected(1, "CHERRY");
                    viewModel.gewinnUeberpruefen(0.1 * (Integer.valueOf(lblRisikoZahl.getText())));
                    checkButtonUnlock();
                    ptCherrySpinner3.stop();
                }
            });
            ptCherrySpinner3.play();
        }
    }

    private void checkButtonUnlock() {
        if ((Double.valueOf(lblGewinnZahl.getText()) > 0.0)) {
            btnGamble.setDisable(false);
            btnMystery.setDisable(false);
        } else {
            btnStop.setDisable(false);
            btnBet.setDisable(false);
            btnAuszahlen.setDisable(false);
            btnGamble.setDisable(true);
            btnMystery.setDisable(true);
        }
    }

    public void bind() {
        lblSpielerkontoZahl.textProperty().bind(viewModel.getEinwurf());
        lblKontostandZahl.textProperty().bind(viewModel.getKontostand());
        lblWalze1.textProperty().bind(viewModel.getWalzenZahl());
        lblWalze2.textProperty().bind(viewModel.getWalzenZahl());
        lblWalze3.textProperty().bind(viewModel.getWalzenZahl());
        lblGewinnZahl.textProperty().bind(viewModel.getGewinn());
        lblRisikoZahl.textProperty().bind(viewModel.getRisikoBetrag());
    }

    public void setViewModel(SlotMachineViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
