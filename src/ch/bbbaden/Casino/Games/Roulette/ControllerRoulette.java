package ch.bbbaden.Casino.Games.Roulette;

import Casino.DataBase.Query;
import Casino.DataBase.User;
import ch.bbbaden.Casino.MainApp;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ControllerRoulette implements Initializable {

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Button btnQuit;
    @FXML
    private Button btnConfirm;
    @FXML
    private Label lblGuthaben;
    @FXML
    private Label lblUser;
    @FXML
    private Label lbl2Splitt3;
    @FXML
    private ImageView TenChip;
    @FXML
    private ImageView OneHundredChip;
    @FXML
    private ImageView TwoFifthyChip;
    @FXML
    private ImageView ThousandChip;
    @FXML
    private ImageView FifthyChip;
    @FXML
    private Button btnReset;
    @FXML
    private ImageView BackgroundImage;
    @FXML
    private Label lbl5Splitt6;
    @FXML
    private Label lb0;
    @FXML
    private Label lbl18to19;
    @FXML
    private Label lbl19to36;
    @FXML
    private Label lblEven;
    @FXML
    private Label lblOdd;
    @FXML
    private Label lblRed;
    @FXML
    private Label lbl18to191;
    @FXML
    private Label lblStreet1;
    @FXML
    private Label lblStreet2;
    @FXML
    private Label lblStreet3;
    @FXML
    private Label lblStreet4;
    @FXML
    private Label lblStreet5;
    @FXML
    private Label lblStreet6;
    @FXML
    private Label lblStreet7;
    @FXML
    private Label lblStreet8;
    @FXML
    private Label lblStreet9;
    @FXML
    private Label lblStreet10;
    @FXML
    private Label lblStreet11;
    @FXML
    private Label lblStreet12;
    @FXML
    private Label lblThird1;
    @FXML
    private Label lblThird2;
    @FXML
    private Label lblThird3;
    @FXML
    private Label lbl2to1One;
    @FXML
    private Label lbl2to1Two;
    @FXML
    private Label lbl2to1Three;
    @FXML
    private Label lblCornerOneToFive;
    @FXML
    private Label lblCornerTwoToSix;
    @FXML
    private Label lblField3;
    @FXML
    private Label lbl1Splitt2;
    @FXML
    private Label lblField2;
    @FXML
    private Label lbl4Splitt5;
    @FXML
    private Label lblCornerFiveToNine;
    @FXML
    private Label lblCornerFEightToOneTwo;
    @FXML
    private Label lblCornerOneOnetoOneFive;
    @FXML
    private Label lblCornerOneFourToOneEight;
    @FXML
    private Label lblCornerOneSevenToTwoOne;
    @FXML
    private Label lblCornerTwoZeroToTwoFour;
    @FXML
    private Label lblCornerTwoThreeToTwoSeven;
    @FXML
    private Label lblCornerTwoSixToThreeZero;
    @FXML
    private Label lblCornerTwoNineToThreeThree;
    @FXML
    private Label lblCornerThreeTwoToThreeSix;
    @FXML
    private Label lblCornerThreeOneToThreeFive;
    @FXML
    private Label lblCornerTwoEightToThreeTwo;
    @FXML
    private Label lblCornerTwoFiveToTwoNine;
    @FXML
    private Label lblCornerOneNineToTwoThree;
    @FXML
    private Label lblCornerTwoTwoToTwoSix;
    @FXML
    private Label lblCornerOneSixToTwoZero;
    @FXML
    private Label lblCornerOneThreeToOneSeven;
    @FXML
    private Label lblCornerOneZeroToOneFour;
    @FXML
    private Label lblCornerSevenToEleven;
    @FXML
    private Label lblCornerFourToEight;
    @FXML
    private Label lbl8Splitt9;
    @FXML
    private Label lbl11Splitt12;
    @FXML
    private Label lbl14Splitt15;
    @FXML
    private Label lbl17Splitt18;
    @FXML
    private Label lbl20Splitt21;
    @FXML
    private Label lbl23Splitt24;
    @FXML
    private Label lbl26Splitt27;
    @FXML
    private Label lbl29Splitt30;
    @FXML
    private Label lbl32Splitt33;
    @FXML
    private Label lbl35Splitt36;
    @FXML
    private Label lbl34Splitt35;
    @FXML
    private Label lbl31Splitt32;
    @FXML
    private Label lbl28Splitt29;
    @FXML
    private Label lbl25Splitt26;
    @FXML
    private Label lbl22Splitt23;
    @FXML
    private Label lbl19Splitt20;
    @FXML
    private Label lbl16Splitt17;
    @FXML
    private Label lbl13Splitt14;
    @FXML
    private Label lbl10Splitt11;
    @FXML
    private Label lbl7Splitt8;
    @FXML
    private Label lbl1Splitt4;
    @FXML
    private Label lbl4Splitt7;
    @FXML
    private Label lbl7Splitt10;
    @FXML
    private Label lbl10Splitt13;
    @FXML
    private Label lbl13Splitt16;
    @FXML
    private Label lbl16Splitt19;
    @FXML
    private Label lbl19Splitt22;
    @FXML
    private Label lbl22Splitt25;
    @FXML
    private Label lbl25Splitt28;
    @FXML
    private Label lbl28Splitt31;
    @FXML
    private Label lbl31Splitt34;
    @FXML
    private Label lbl8Splitt11;
    @FXML
    private Label lbl5Splitt8;
    @FXML
    private Label lbl2Splitt5;
    @FXML
    private Label lblField1;
    @FXML
    private Label lbl14Splitt17;
    @FXML
    private Label lbl11Splitt14;
    @FXML
    private Label lbl32Splitt35;
    @FXML
    private Label lbl29Splitt32;
    @FXML
    private Label lbl26Splitt29;
    @FXML
    private Label lbl23Splitt26;
    @FXML
    private Label lbl20Splitt23;
    @FXML
    private Label lbl17Splitt20;
    @FXML
    private Label lbl3Splitt6;
    @FXML
    private Label lbl6Splitt9;
    @FXML
    private Label lbl9Splitt12;
    @FXML
    private Label lbl12Splitt15;
    @FXML
    private Label lbl15Splitt18;
    @FXML
    private Label lbl18Splitt21;
    @FXML
    private Label lbl21Splitt24;
    @FXML
    private Label lbl24Splitt27;
    @FXML
    private Label lbl27Splitt30;
    @FXML
    private Label lbl30Splitt33;
    @FXML
    private Label lbl33Splitt36;
    @FXML
    private Label lblField4;
    @FXML
    private Label lblField5;
    @FXML
    private Label lblField8;
    @FXML
    private Label lblField11;
    @FXML
    private Label lblField14;
    @FXML
    private Label lblField17;
    @FXML
    private Label lblField20;
    @FXML
    private Label lblField23;
    @FXML
    private Label lblField26;
    @FXML
    private Label lblField29;
    @FXML
    private Label lblField32;
    @FXML
    private Label lblField35;
    @FXML
    private Label lblField7;
    @FXML
    private Label lblWin;
    @FXML
    private Label lblField10;
    @FXML
    private Label lblField6;
    @FXML
    private Label lblField13;
    @FXML
    private Label lblField16;
    @FXML
    private Label lblField19;
    @FXML
    private Label lblField22;
    @FXML
    private Label lblField25;
    @FXML
    private Label lblField28;
    @FXML
    private Label lblField31;
    @FXML
    private Label lblField34;
    @FXML
    private Label lblField9;
    @FXML
    private Label lblField15;
    @FXML
    private Label lblField12;
    @FXML
    private Label lblField21;
    @FXML
    private Label lblField27;
    @FXML
    private Label lblField33;
    @FXML
    private Label lblField18;
    @FXML
    private Label lblField24;
    @FXML
    private Label lblField30;
    @FXML
    private Label lblField36;
    @FXML
    private Label PlaceholderUsername;
    @FXML
    private Label PlaceholderGuthaben;
    @FXML
    private Label lblNumber;
    private Query sql = new Query();
    RouletteBetType rbt = new RouletteBetType();
    public int konto ;
    public int ChipValue = 0;
    private User user;
    private MainApp mainApp;
    @FXML
    private Label lblBlack;
    @FXML
    private Label lblText;
    @FXML
    private Button btnMainMenu;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        root.setId("pane");
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().addAll(this.getClass().getResource("Styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    //-------------------------------------------------------------------------------------
//Controll Buttons
    @FXML
    private void ConfirmBets(ActionEvent event) {
        rbt.GenerateRandNumber();
        lblWin.setText("You have won " + rbt.getWin());
        lblNumber.setText("Number " + rbt.getRandom() + " has been drawn.");
        PlaceholderGuthaben.setText(Integer.toString(konto));

    }

    @FXML

    private void ButtonHandlingQuit(ActionEvent event) {
        Stage stage = (Stage) btnQuit.getScene().getWindow();
        stage.close();
    }


    //ToDo
    @FXML
    private void ButtonHandlingResetBets(ActionEvent event) {
        
    }

    //-------------------------------------------------------------------------------------
    //Fieldbets -> Payout = 
    @FXML
    private void BetField0(MouseEvent event) {
        Integer[] Betnumbers = {0};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet " + "for " + ChipValue);
    }

    @FXML
    private void BetField3(MouseEvent event) {
        Integer[] Betnumbers = {3};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 3 " + "for " + ChipValue);
    }

    @FXML
    private void BetField2(MouseEvent event) {
        Integer[] Betnumbers = {2};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 2 " + "for " + ChipValue);
    }

    @FXML
    private void BetField1(MouseEvent event) {
        Integer[] Betnumbers = {1};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 1 " + "for " + ChipValue);
    }

    @FXML
    private void BetField4(MouseEvent event) {
        Integer[] Betnumbers = {4};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 4 " + "for " + ChipValue);
    }

    @FXML
    private void BetField5(MouseEvent event) {
        Integer[] Betnumbers = {5};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 5 " + "for " + ChipValue);
    }

    @FXML
    private void BetField8(MouseEvent event) {
        Integer[] Betnumbers = {8};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 8 " + "for " + ChipValue);
    }

    @FXML
    private void BetField11(MouseEvent event) {
        Integer[] Betnumbers = {11};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 11 " + "for " + ChipValue);
    }

    @FXML
    private void BetField14(MouseEvent event) {
        Integer[] Betnumbers = {14};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 14 " + "for " + ChipValue);
    }

    @FXML
    private void BetField17(MouseEvent event) {
        Integer[] Betnumbers = {17};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 17 " + "for " + ChipValue);
    }

    @FXML
    private void BetField20(MouseEvent event) {
        Integer[] Betnumbers = {20};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 20 " + "for " + ChipValue);
    }

    @FXML
    private void BetField23(MouseEvent event) {
        Integer[] Betnumbers = {23};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 23 " + "for " + ChipValue);
    }

    @FXML
    private void BetField26(MouseEvent event) {
        Integer[] Betnumbers = {26};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 26 " + "for " + ChipValue);
    }

    @FXML
    private void BetField29(MouseEvent event) {
        Integer[] Betnumbers = {29};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 29 " + "for " + ChipValue);
    }

    @FXML
    private void BetField32(MouseEvent event) {
        Integer[] Betnumbers = {32};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 32 " + "for " + ChipValue);
    }

    @FXML
    private void BetField35(MouseEvent event) {
        Integer[] Betnumbers = {35};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 35 " + "for " + ChipValue);
    }

    @FXML
    private void BetField7(MouseEvent event) {
        Integer[] Betnumbers = {7};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 7 " + "for " + ChipValue);
    }

    @FXML
    private void BetField10(MouseEvent event) {
        Integer[] Betnumbers = {10};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 10 " + "for " + ChipValue);
    }

    @FXML
    private void BetField6(MouseEvent event) {
        Integer[] Betnumbers = {6};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 6 " + "for " + ChipValue);
    }

    @FXML
    private void BetField13(MouseEvent event) {
        Integer[] Betnumbers = {13};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 13 " + "for " + ChipValue);
    }

    @FXML
    private void BetField16(MouseEvent event) {
        Integer[] Betnumbers = {16};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 16 " + "for " + ChipValue);
    }

    @FXML
    private void BetField19(MouseEvent event) {
        Integer[] Betnumbers = {19};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 19 " + "for " + ChipValue);
    }

    @FXML
    private void BetField22(MouseEvent event) {
        Integer[] Betnumbers = {22};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 22 " + "for " + ChipValue);
    }

    @FXML
    private void BetField25(MouseEvent event) {
        Integer[] Betnumbers = {25};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 25 " + "for " + ChipValue);
    }

    @FXML
    private void BetField28(MouseEvent event) {
        Integer[] Betnumbers = {28};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 28 " + "for " + ChipValue);
    }

    @FXML
    private void BetField31(MouseEvent event) {
        Integer[] Betnumbers = {31};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 31 " + "for " + ChipValue);
    }

    @FXML
    private void BetField34(MouseEvent event) {
        Integer[] Betnumbers = {34};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 34 " + "for " + ChipValue);
    }

    @FXML
    private void BetField9(MouseEvent event) {
        Integer[] Betnumbers = {9};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 9 " + "for " + ChipValue);
    }

    @FXML
    private void BetField15(MouseEvent event) {
        Integer[] Betnumbers = {15};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 15 " + "for " + ChipValue);
    }

    @FXML
    private void BetField12(MouseEvent event) {
        Integer[] Betnumbers = {12};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 12 " + "for " + ChipValue);
    }

    @FXML
    private void BetField21(MouseEvent event) {
        Integer[] Betnumbers = {21};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 21 " + "for " + ChipValue);
    }

    @FXML
    private void BetField27(MouseEvent event) {
        Integer[] Betnumbers = {27};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 27 " + "for " + ChipValue);
    }

    @FXML
    private void BetField33(MouseEvent event) {
        Integer[] Betnumbers = {33};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 33 " + "for " + ChipValue);
    }

    @FXML
    private void BetField18(MouseEvent event) {
        Integer[] Betnumbers = {18};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 18 " + "for " + ChipValue);
    }

    @FXML
    private void BetField24(MouseEvent event) {
        Integer[] Betnumbers = {24};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 24 " + "for " + ChipValue);
    }

    @FXML
    private void BetField30(MouseEvent event) {
        Integer[] Betnumbers = {30};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 30 " + "for " + ChipValue);
    }

    @FXML
    private void BetField36(MouseEvent event) {
        Integer[] Betnumbers = {36};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Straight Bet on Field 36 " + "for " + ChipValue);
    }

    //-------------------------------------------------------------------------------------
    //TopBets
    @FXML
    private void BetField1to18(MouseEvent event) {
        Integer[] Betnumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Low Bet on 1 - 18 " + "for " + ChipValue);
    }

    @FXML
    private void BetField19to36(MouseEvent event) {
        Integer[] Betnumbers = {19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "High Bet on 19 - 36 " + "for " + ChipValue);
    }

    @FXML
    private void BetFieldEven(MouseEvent event) {
        Integer[] Betnumbers = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Bet on Even  " + "for " + ChipValue);
    }

    @FXML
    private void BetFieldOdd(MouseEvent event) {
        Integer[] Betnumbers = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + "Bet on Odd " + "for " + ChipValue);
    }

    @FXML
    private void BetFieldBlack(MouseEvent event) {
        Integer[] Betnumbers = {2, 4, 6, 8, 10, 11, 13, 14, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Bet on Black " + "for " + ChipValue);
    }

    @FXML
    private void BetFieldRed(MouseEvent event) {
        Integer[] Betnumbers = {1, 3, 5, 7, 9, 12, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Bet on Red " + "for " + ChipValue);
    }

    //-------------------------------------------------------------------------------------
    //BottomBets
    @FXML
    private void BetFieldThird1(MouseEvent event) {
        Integer[] Betnumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Bet on 1st Third " + "for " + ChipValue);
    }

    @FXML
    private void BetFieldThird2(MouseEvent event) {
        Integer[] Betnumbers = {13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Bet on 2nd Third " + "for " + ChipValue);
    }

    @FXML
    private void BetFieldThird3(MouseEvent event) {
        Integer[] Betnumbers = {25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Bet on 3rd Third " + "for " + ChipValue);
    }

    //-------------------------------------------------------------------------------------
    //StreetBets
    @FXML
    private void StreetBet1(MouseEvent event) {
        Integer[] Betnumbers = {1, 2, 3};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Street Bet on 1-3 " + "for " + ChipValue);
    }

    @FXML
    private void StreetBet2(MouseEvent event) {
        Integer[] Betnumbers = {4, 5, 6};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Street Bet on 4-6 " + "for " + ChipValue);
    }

    @FXML
    private void StreetBet3(MouseEvent event) {
        Integer[] Betnumbers = {7, 8, 9};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Street Bet on 7-9 " + "for " + ChipValue);
    }

    @FXML
    private void StreetBet4(MouseEvent event) {
        Integer[] Betnumbers = {10, 11, 12};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Street Bet on 10-12 " + "for " + ChipValue);
    }

    @FXML
    private void StreetBet5(MouseEvent event) {
        Integer[] Betnumbers = {13, 14, 15};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Street Bet on 12-15 " + "for " + ChipValue);
    }

    @FXML
    private void StreetBet6(MouseEvent event) {
        Integer[] Betnumbers = {16, 17, 18};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Street Bet on 16-18 " + "for " + ChipValue);
    }

    @FXML
    private void StreetBet7(MouseEvent event) {
        Integer[] Betnumbers = {19, 20, 21};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Street Bet on 19-21 " + "for " + ChipValue);
    }

    @FXML
    private void StreetBet8(MouseEvent event) {
        Integer[] Betnumbers = {22, 23, 24};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Street Bet on 22-24 " + "for " + ChipValue);
    }

    @FXML
    private void StreetBet9(MouseEvent event) {
        Integer[] Betnumbers = {25, 26, 27};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Street Bet on 25-27 " + "for " + ChipValue);
    }

    @FXML
    private void StreetBet10(MouseEvent event) {
        Integer[] Betnumbers = {28, 29, 30};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Street Bet on 28-30 " + "for " + ChipValue);
    }

    @FXML
    private void StreetBet11(MouseEvent event) {
        Integer[] Betnumbers = {31, 32, 33};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Street Bet on 31-33 " + "for " + ChipValue);
    }

    @FXML
    private void StreetBet12(MouseEvent event) {
        Integer[] Betnumbers = {34, 35, 36};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Street Bet on 34-36 " + "for " + ChipValue);
    }

    //-------------------------------------------------------------------------------------
    //Chip Usage
    @FXML
    private void UseChip10(MouseEvent event) {
        ChipValue = 10;
        System.out.println("Chipvalue = " + ChipValue);
    }

    @FXML
    private void UseChip100(MouseEvent event) {
        ChipValue = 100;
        System.out.println("Chipvalue = " + ChipValue);
    }

    @FXML
    private void UseChip250(MouseEvent event) {
        ChipValue = 250;
        System.out.println("Chipvalue = " + ChipValue);
    }

    @FXML
    private void UseChip1000(MouseEvent event) {
        ChipValue = 1000;
        System.out.println("Chipvalue = " + ChipValue);
    }

    @FXML
    private void UseChip50(MouseEvent event) {
        ChipValue = 50;
        System.out.println("Chipvalue = " + ChipValue);
    }
    //-------------------------------------------------------------------------------------
    //Side Bets

    @FXML
    private void BetField2To1One(MouseEvent event) {
        Integer[] Betnumbers = {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " 2 to 1 Bet 1st Line " + "for " + ChipValue);
    }

    @FXML
    private void BetField2To1Two(MouseEvent event) {
        Integer[] Betnumbers = {2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " 2 to 1 Bet 2nd Line " + "for " + ChipValue);
    }

    @FXML
    private void BetField2To1Three(MouseEvent event) {
        Integer[] Betnumbers = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " 2 to 1 Bet 3rd Line " + "for " + ChipValue);
    }

    //-------------------------------------------------------------------------------------
    //Corner Bets
    @FXML
    private void CornerBet1To5(MouseEvent event) {
        Integer[] Betnumbers = {1, 2, 4, 5};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 1,2 - 4,5 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet2To6(MouseEvent event) {
        Integer[] Betnumbers = {2, 3, 5, 6};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 2,3 - 5,6 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet5To9(MouseEvent event) {
        Integer[] Betnumbers = {5, 6, 8, 9};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 5,6 - 8,9 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet8To12(MouseEvent event) {
        Integer[] Betnumbers = {8, 9, 11, 12};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 8,9 - 11,12 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet11To15(MouseEvent event) {
        Integer[] Betnumbers = {11, 12, 14, 15};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 11,12 - 14,15 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet14To18(MouseEvent event) {
        Integer[] Betnumbers = {14, 15, 17, 18};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 14,15  - 17,18 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet17To21(MouseEvent event) {
        Integer[] Betnumbers = {17, 18, 20, 21};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 17,18  - 20,21 " + "for " + ChipValue);

    }

    @FXML
    private void CornerBet20To24(MouseEvent event) {
        Integer[] Betnumbers = {20, 21, 23, 24};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 20,21  - 23,24 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet23To27(MouseEvent event) {
        Integer[] Betnumbers = {23, 24, 26, 27};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 23,24  - 26,27 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet26To30(MouseEvent event) {
        Integer[] Betnumbers = {26, 27, 30, 31};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 26,27  - 30,31 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet29To33(MouseEvent event) {
        Integer[] Betnumbers = {29, 30, 32, 33};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 29,30  - 32,33 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet32To36(MouseEvent event) {
        Integer[] Betnumbers = {32, 33, 35, 36};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 32,33  - 35,36 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet31To35(MouseEvent event) {
        Integer[] Betnumbers = {31, 32, 34, 35};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 31,32  - 34,35 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet28To32(MouseEvent event) {
        Integer[] Betnumbers = {28, 29, 31, 32};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 28,29  - 31,32 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet25To29(MouseEvent event) {
        Integer[] Betnumbers = {25, 26, 28, 29};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 25,26  - 38,29 " + "for " + ChipValue);

    }

    @FXML
    private void CornerBet19To23(MouseEvent event) {
        Integer[] Betnumbers = {19, 20, 22, 23};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 19,20  - 22,23 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet22To26(MouseEvent event) {
        Integer[] Betnumbers = {22, 23, 25, 26};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 22,23- 25,26 " + "for " + ChipValue);

    }

    @FXML
    private void CornerBet16To20(MouseEvent event) {
        Integer[] Betnumbers = {16, 17, 19, 20};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 22,23- 25,26 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet13To17(MouseEvent event) {
        Integer[] Betnumbers = {13, 14, 16, 17};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 13,14- 16,17 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet10To14(MouseEvent event) {
        Integer[] Betnumbers = {10, 11, 13, 14};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 10,11- 13,14 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet7To11(MouseEvent event) {
        Integer[] Betnumbers = {7, 8, 10, 11};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 7,8- 10,11 " + "for " + ChipValue);
    }

    @FXML
    private void CornerBet4To8(MouseEvent event) {
        Integer[] Betnumbers = {4, 5, 7, 8};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Corner Bet on 4,5- 7,8 " + "for " + ChipValue);
    }

    //-------------------------------------------------------------------------------------
    //Splitbets auf X-Achse
    @FXML
    private void SplittBet5To6(MouseEvent event) {
        Integer[] Betnumbers = {5, 6};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 5,6 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet2To3(MouseEvent event) {
        Integer[] Betnumbers = {2, 3};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 2,3 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet1To2(MouseEvent event) {
        Integer[] Betnumbers = {1, 2};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 1,2 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet8To9(MouseEvent event) {
        Integer[] Betnumbers = {8, 9};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 8,9 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet11To12(MouseEvent event) {
        Integer[] Betnumbers = {11, 12};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 11,12 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet14To15(MouseEvent event) {
        Integer[] Betnumbers = {14, 15};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 14,15 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet17To18(MouseEvent event) {
        Integer[] Betnumbers = {17, 18};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 17,18 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet20To21(MouseEvent event) {
        Integer[] Betnumbers = {20, 21};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 20,21 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet23To24(MouseEvent event) {
        Integer[] Betnumbers = {23, 24};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 23,24 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet26To27(MouseEvent event) {
        Integer[] Betnumbers = {26, 27};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 26,27 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet29To30(MouseEvent event) {
        Integer[] Betnumbers = {29, 30};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 29,30 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet4To5(MouseEvent event) {
        Integer[] Betnumbers = {4, 5};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 4,5 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet32To33(MouseEvent event) {
        Integer[] Betnumbers = {32, 33};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 29,30 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet35To36(MouseEvent event) {
        Integer[] Betnumbers = {35, 36};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 35,36 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet34To35(MouseEvent event) {
        Integer[] Betnumbers = {34, 35};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 34,35 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet31To32(MouseEvent event) {
        Integer[] Betnumbers = {31, 32};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 31,32 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet28To29(MouseEvent event) {
        Integer[] Betnumbers = {28, 29};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 28,29 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet25To26(MouseEvent event) {
        Integer[] Betnumbers = {25, 26};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 25,26 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet22To23(MouseEvent event) {
        Integer[] Betnumbers = {22, 23};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 22,23 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet19To20(MouseEvent event) {
        Integer[] Betnumbers = {19, 20};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 19,20 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet16To17(MouseEvent event) {
        Integer[] Betnumbers = {16, 17};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 16,17 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet13To14(MouseEvent event) {
        Integer[] Betnumbers = {13, 14};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 13,14 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet10To11(MouseEvent event) {
        Integer[] Betnumbers = {10, 11};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 10,11 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet7To8(MouseEvent event) {
        Integer[] Betnumbers = {7, 8};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 7,8 " + "for " + ChipValue);

    }

    //-------------------------------------------------------------------------------------
    //Splitbets auf Y-Achse-> Payout = 
    @FXML
    private void SplittBet1To4(MouseEvent event) {
        Integer[] Betnumbers = {1, 4,};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 1,4 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet4To7(MouseEvent event) {
        Integer[] Betnumbers = {4, 7};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 4,7 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet7To10(MouseEvent event) {
        Integer[] Betnumbers = {7, 10};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 7,10 " + "for " + ChipValue);
    }

    @FXML
    private void SplittBet10To13(MouseEvent event) {
        Integer[] Betnumbers = {10, 13};
        rbt.addbet(Betnumbers, this.ChipValue);
        konto = konto - this.ChipValue;
        PlaceholderGuthaben.setText(Integer.toString(konto));
        lblText.setText("You have confirmed a " + " Splitt Bet on 71013 " + "for " + ChipValue);

    }

    @FXML
    private void SplittBet13To16(MouseEvent event) {
        Integer[] Betnumbers = {13, 16};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet16To19(MouseEvent event) {
        Integer[] Betnumbers = {16, 19};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet19To22(MouseEvent event) {
        Integer[] Betnumbers = {19, 22};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet22To25(MouseEvent event) {
        Integer[] Betnumbers = {22, 25};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet25To28(MouseEvent event) {
        Integer[] Betnumbers = {25, 28};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet28To31(MouseEvent event) {
        Integer[] Betnumbers = {28, 31};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet31To34(MouseEvent event) {
        Integer[] Betnumbers = {31, 34};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet8To11(MouseEvent event) {
        Integer[] Betnumbers = {8, 11};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet5To8(MouseEvent event) {
        Integer[] Betnumbers = {5, 8};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet2To5(MouseEvent event) {
        Integer[] Betnumbers = {2, 5};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet14To17(MouseEvent event) {
        Integer[] Betnumbers = {14, 17};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet11To14(MouseEvent event) {
        Integer[] Betnumbers = {11, 14};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet32To35(MouseEvent event) {
        Integer[] Betnumbers = {32, 35};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet29To32(MouseEvent event) {
        Integer[] Betnumbers = {29, 32};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet26To29(MouseEvent event) {
        Integer[] Betnumbers = {26, 29};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet23To26(MouseEvent event) {
        Integer[] Betnumbers = {23, 26};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet20To23(MouseEvent event) {
        Integer[] Betnumbers = {20, 23};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet17To20(MouseEvent event) {
        Integer[] Betnumbers = {17, 20};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet3To6(MouseEvent event) {
        Integer[] Betnumbers = {3, 6};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet6To9(MouseEvent event) {
        Integer[] Betnumbers = {6, 9};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet9To12(MouseEvent event) {
        Integer[] Betnumbers = {9, 12};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet12To15(MouseEvent event) {
        Integer[] Betnumbers = {12, 15};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet15To18(MouseEvent event) {
        Integer[] Betnumbers = {15, 18};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet18To21(MouseEvent event) {
        Integer[] Betnumbers = {18, 21};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet21To24(MouseEvent event) {
        Integer[] Betnumbers = {21, 24};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet24To27(MouseEvent event) {
        Integer[] Betnumbers = {24, 27};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet27To30(MouseEvent event) {
        Integer[] Betnumbers = {27, 30};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet30To33(MouseEvent event) {
        Integer[] Betnumbers = {30, 33};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void SplittBet33To36(MouseEvent event) {
        Integer[] Betnumbers = {33, 36};
        rbt.addbet(Betnumbers, this.ChipValue);
        PlaceholderGuthaben.setText(Integer.toString(konto));
    }

    @FXML
    private void ButtonHandlingLeaveToMenu(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        mainApp.startMenu();
    }

    public void setUser(User user) {
       this.user= user;
    }

    public void setMainApp(MainApp aThis) {
       this.mainApp= aThis;
    }
    public void setCreditUser() throws SQLException, ClassNotFoundException{
        konto= (int) sql.getCreditUser(user.getName());
        PlaceholderGuthaben.setText(Integer.toString(konto));        
    }
}
