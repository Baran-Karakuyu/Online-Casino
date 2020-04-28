package ch.bbbaden.Casino.Games.Yatzy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author yanni
 */
public class FXMLDocumentController implements Initializable {

    //UserInformation
    public int kontostand = 20000;

    //Objekte
    private int wetteinsatzWert;
    Würfel w1 = new Würfel();
    Würfel w2 = new Würfel();
    Würfel w3 = new Würfel();
    Würfel w4 = new Würfel();
    Würfel w5 = new Würfel();

    EinfacheKombinationen einfacheKombination = new EinfacheKombinationen();
    SchwierigeKombinationen schwierigeKombination = new SchwierigeKombinationen();

    int[] würfel = new int[5];

    Image img1 = new Image("CasinoIMG/Yatzy/1.png");
    Image img2 = new Image("CasinoIMG/Yatzy/2.png");
    Image img3 = new Image("CasinoIMG/Yatzy/3.png");
    Image img4 = new Image("CasinoIMG/Yatzy/4.png");
    Image img5 = new Image("CasinoIMG/Yatzy/5.png");
    Image img6 = new Image("CasinoIMG/Yatzy/6.png");

    private int verbleibendeZüge = 300;
    private int ergebnis = 0;
    public int betrag;

    //Update Objekte
    boolean lockedEiner = false;
    boolean lockedZweier = false;
    boolean lockedDreier = false;
    boolean lockedVierer = false;
    boolean lockedFünfer = false;
    boolean lockedSechser = false;
    boolean lockedDreierPasch = false;
    boolean lockedViererPasch = false;
    boolean lockedFullHouse = false;
    boolean lockedKleineStrasse = false;
    boolean lockedGrosseStrasse = false;
    boolean lockedYatzy = false;
    boolean lockedChance = false;
    FXMLWettsystemController controller = new FXMLWettsystemController();
    boolean bonusused = false;
    private int runde = 0;
    public int total = 0;
    private int bonus = 0;

    //Bot Objekte
    private int zufallBot = 13;

    private int gewählteZahl;

    private int bottotal = 0;

    private int botbonus = 0;

    private boolean botbonusused = false;

    ArrayList<String> botKombinationen = new ArrayList<String>();

    private int arrayZahl;

    @FXML
    private CheckBox halten1;

    @FXML
    private CheckBox halten2;

    @FXML
    private CheckBox halten3;

    @FXML
    private CheckBox halten4;

    @FXML
    private CheckBox halten5;

    @FXML
    private ImageView würfel1;

    @FXML
    private ImageView würfel2;

    @FXML
    private ImageView würfel3;

    @FXML
    private ImageView würfel4;

    @FXML
    private ImageView würfel5;

    @FXML
    private Label verbleibend;

    @FXML
    private TextField txtEiner;

    @FXML
    private TextField txtZweier;

    @FXML
    private TextField txtDreier;

    @FXML
    private TextField txtVierer;

    @FXML
    private TextField txtFünfer;

    @FXML
    private TextField txtSechser;

    @FXML
    private TextField txtdreierPasch;
    @FXML
    private TextField txtviererPasch;

    @FXML
    private TextField txtkleineStrasse;

    @FXML
    private TextField txtgrosseStrasse;

    @FXML
    private TextField txtfullHouse;

    @FXML
    private TextField txtChance;

    @FXML
    private TextField txtYatzy;

    @FXML
    private Button buttonWürfeln;

    @FXML
    private Button einer;
    @FXML
    private Button zweier;
    @FXML
    private Button dreier;
    @FXML
    private Button vierer;
    @FXML
    private Button fünfer;
    @FXML
    private Button sechser;
    @FXML
    private Button dreierPasch;
    @FXML
    private Button viererPasch;

    @FXML
    private Button kleineStrasse;

    @FXML
    private Button grosseStrasse;

    @FXML
    private Button fullHouse;
    @FXML
    private Button yatzy;

    @FXML
    private Button chance;
    @FXML
    private Button buttonNext;

    @FXML
    private Button wettsystem;

    @FXML
    private Button starten;
    @FXML
    private TextField botZweier;
    @FXML
    private TextField botDreier;
    @FXML
    private TextField botVierer;
    @FXML
    private TextField botFünfer;
    @FXML
    private TextField botSechser;
    @FXML
    private TextField botBonus;
    @FXML
    private TextField botDreierPasch;
    @FXML
    private TextField botViererPasch;
    @FXML
    private TextField botFullHouse;
    @FXML
    private TextField botKleineStrasse;
    @FXML
    private TextField botGrosseStrasse;
    @FXML
    private TextField botYatzy;
    @FXML
    private TextField botTotal;
    @FXML
    private TextField botEiner;
    @FXML
    private TextField botChance;
    @FXML
    private TextField txtBonus;
    @FXML
    private TextField txtTotal;
    @FXML
    private Label rundenzahl;
    @FXML
    private Pane winscreen;
    private Label Wetteinsatz;
    @FXML
    private Label gewinner;
    @FXML
    private Label gewonnenesGeld;
    @FXML
    private Label gewonnenesWert;
    @FXML
    private Label neuerKontostand;
    @FXML
    private Label wetteinsatz;
    @FXML
    private Label Punkte;
    @FXML
    private Label botPunkte;

    @FXML
    private Button beenden;
    @FXML
    private Button neueRunde;
    @FXML
    private Label verbleibend3;
    @FXML
    private Label verbleibend1;
    @FXML
    private Label verbleibend11;
    @FXML
    private Label verbleibend31;
    @FXML
    private Label verbleibend311;
    @FXML
    private Label verbleibend12;
    @FXML
    private Label verbleibend111;
    @FXML
    private Button ablauf;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        fülleArray();
        // TOD
        /*
        betrag = controller.getWetteinsatz();
        eeee.setText("" + betrag);
        
         */
    }

    @FXML
    private void würfeln(ActionEvent event) {
        update();

        halten1.setDisable(false);
        halten2.setDisable(false);
        halten3.setDisable(false);
        halten4.setDisable(false);
        halten5.setDisable(false);

        if (verbleibendeZüge > 0) {

            verbleibendeZüge--;
            verbleibend.setText("Verbleibende Züge: " + verbleibendeZüge);
            if (!halten1.isSelected()) {
                w1.würfle();
            }
            if (!halten2.isSelected()) {
                w2.würfle();
            }
            if (!halten3.isSelected()) {
                w3.würfle();
            }
            if (!halten4.isSelected()) {
                w4.würfle();
            }
            if (!halten5.isSelected()) {
                w5.würfle();
            }
        }

        würfel[0] = w1.getValue();
        würfel[1] = w2.getValue();
        würfel[2] = w3.getValue();
        würfel[3] = w4.getValue();
        würfel[4] = w5.getValue();

        switch (würfel[0]) {
            case 1:
                würfel1.setImage(img1);
                break;

            case 2:
                würfel1.setImage(img2);
                break;
            case 3:
                würfel1.setImage(img3);
                break;
            case 4:
                würfel1.setImage(img4);
                break;
            case 5:
                würfel1.setImage(img5);
                break;
            case 6:
                würfel1.setImage(img6);
                break;

        }

        switch (würfel[1]) {
            case 1:
                würfel2.setImage(img1);
                break;
            case 2:
                würfel2.setImage(img2);
                break;
            case 3:
                würfel2.setImage(img3);
                break;
            case 4:
                würfel2.setImage(img4);
                break;
            case 5:
                würfel2.setImage(img5);
                break;
            case 6:
                würfel2.setImage(img6);
                break;

        }

        switch (würfel[2]) {
            case 1:
                würfel3.setImage(img1);
                break;
            case 2:
                würfel3.setImage(img2);
                break;
            case 3:
                würfel3.setImage(img3);
                break;
            case 4:
                würfel3.setImage(img4);
                break;
            case 5:
                würfel3.setImage(img5);
                break;
            case 6:
                würfel3.setImage(img6);
                break;

        }

        switch (würfel[3]) {
            case 1:
                würfel4.setImage(img1);
                break;
            case 2:
                würfel4.setImage(img2);
                break;
            case 3:
                würfel4.setImage(img3);
                break;
            case 4:
                würfel4.setImage(img4);
                break;
            case 5:
                würfel4.setImage(img5);
                break;
            case 6:
                würfel4.setImage(img6);
                break;

        }

        switch (würfel[4]) {
            case 1:
                würfel5.setImage(img1);
                break;
            case 2:
                würfel5.setImage(img2);
                break;
            case 3:
                würfel5.setImage(img3);
                break;
            case 4:
                würfel5.setImage(img4);
                break;
            case 5:
                würfel5.setImage(img5);
                break;
            case 6:
                würfel5.setImage(img6);
                break;

        }

    }

    @FXML
    private void nächsterZug(ActionEvent event) {
        verbleibendeZüge = 3;
        verbleibend.setText("Verbleibende Züge: " + verbleibendeZüge);
        halten1.setDisable(true);
        halten2.setDisable(true);
        halten3.setDisable(true);
        halten4.setDisable(true);
        halten5.setDisable(true);
        halten1.setSelected(false);
        halten2.setSelected(false);
        halten3.setSelected(false);
        halten4.setSelected(false);
        halten5.setSelected(false);

        würfel1.setImage(img1);
        würfel2.setImage(img1);
        würfel3.setImage(img1);
        würfel4.setImage(img1);
        würfel5.setImage(img1);

        wähleKombination();
        runde++;

        buttonNext.setDisable(true);

    }

    @FXML
    private void starten(ActionEvent event) {

        buttonWürfeln.setDisable(false);
        verbleibendeZüge = 3;
        verbleibend.setText("Verbleibende Züge: " + verbleibendeZüge);
        halten1.setDisable(true);
        halten2.setDisable(true);
        halten3.setDisable(true);
        halten4.setDisable(true);
        halten5.setDisable(true);
        halten1.setSelected(false);
        halten2.setSelected(false);
        halten3.setSelected(false);
        halten4.setSelected(false);
        halten5.setSelected(false);

        würfel1.setImage(img1);
        würfel2.setImage(img1);
        würfel3.setImage(img1);
        würfel4.setImage(img1);
        würfel5.setImage(img1);
        runde = 1;
        starten.setDisable(true);
        update();
        lockAll();

    }

    @FXML
    private void einer(ActionEvent event) {

        ergebnis = einfacheKombination.Einer(würfel);
        total = total + ergebnis;
        bonus = bonus + ergebnis;
        update();

        txtEiner.setText("" + ergebnis);
        einer.setDisable(true);
        lockAll();
        lockedEiner = true;
        buttonNext.setDisable(false);

    }

    @FXML
    private void zweier(ActionEvent event) {

        ergebnis = einfacheKombination.Zweier(würfel);
        total = total + ergebnis;
        bonus = bonus + ergebnis;
        update();

        txtZweier.setText("" + ergebnis);
        zweier.setDisable(true);
        lockAll();
        lockedZweier = true;
        buttonNext.setDisable(false);

    }

    @FXML
    private void dreier(ActionEvent event) {

        ergebnis = einfacheKombination.Dreier(würfel);
        total = total + ergebnis;
        bonus = bonus + ergebnis;
        update();

        txtDreier.setText("" + ergebnis);
        dreier.setDisable(true);
        lockAll();
        lockedDreier = true;
        buttonNext.setDisable(false);

    }

    @FXML
    private void vierer(ActionEvent event) {

        ergebnis = einfacheKombination.Vierer(würfel);
        total = total + ergebnis;
        bonus = bonus + ergebnis;
        update();

        txtVierer.setText("" + ergebnis);
        vierer.setDisable(true);
        lockAll();
        lockedVierer = true;
        buttonNext.setDisable(false);

    }

    @FXML
    private void fünfer(ActionEvent event) {

        ergebnis = einfacheKombination.Fünfer(würfel);
        total = total + ergebnis;
        bonus = bonus + ergebnis;
        update();

        txtFünfer.setText("" + ergebnis);
        fünfer.setDisable(true);
        lockAll();
        lockedFünfer = true;
        buttonNext.setDisable(false);

    }

    @FXML
    private void sechser(ActionEvent event) {

        ergebnis = einfacheKombination.Sechser(würfel);
        total = total + ergebnis;
        bonus = bonus + ergebnis;
        update();

        txtSechser.setText("" + ergebnis);
        sechser.setDisable(true);
        lockAll();
        lockedSechser = true;
        buttonNext.setDisable(false);

    }

    @FXML
    private void dreierPasch(ActionEvent event) {
        ergebnis = schwierigeKombination.DreierPasch(würfel);
        total = total + ergebnis;
        update();
        txtdreierPasch.setText("" + ergebnis);
        dreierPasch.setDisable(true);
        lockAll();
        lockedDreierPasch = true;
        buttonNext.setDisable(false);

    }

    @FXML
    private void viererPasch(ActionEvent event) {
        ergebnis = schwierigeKombination.ViererPasch(würfel);
        total = total + ergebnis;
        update();
        txtviererPasch.setText("" + ergebnis);
        viererPasch.setDisable(true);
        lockAll();
        lockedViererPasch = true;
        buttonNext.setDisable(false);

    }

    @FXML
    private void kleineStrasse(ActionEvent event) {
        ergebnis = schwierigeKombination.KleineStrasse(würfel);
        total = total + ergebnis;
        update();
        txtkleineStrasse.setText("" + ergebnis);
        kleineStrasse.setDisable(true);
        lockAll();
        lockedKleineStrasse = true;
        buttonNext.setDisable(false);

    }

    @FXML
    private void grosseStrasse(ActionEvent event) {
        ergebnis = schwierigeKombination.GrosseStrasse(würfel);
        total = total + ergebnis;
        update();
        txtgrosseStrasse.setText("" + ergebnis);
        grosseStrasse.setDisable(true);
        lockAll();
        lockedGrosseStrasse = true;
        buttonNext.setDisable(false);

    }

    @FXML
    private void yatzy(ActionEvent event) {
        ergebnis = schwierigeKombination.Yatzy(würfel);
        total = total + ergebnis;
        update();
        txtYatzy.setText("" + ergebnis);
        yatzy.setDisable(true);
        lockAll();
        lockedYatzy = true;
        buttonNext.setDisable(false);

    }

    @FXML
    private void chance(ActionEvent event) {
        ergebnis = schwierigeKombination.Chance(würfel);
        total = total + ergebnis;
        update();
        txtChance.setText("" + ergebnis);
        chance.setDisable(true);
        lockAll();
        lockedChance = true;
        buttonNext.setDisable(false);

    }

    @FXML
    private void fullHouse(ActionEvent event) {
        ergebnis = schwierigeKombination.FullHouse(würfel);
        total = total + ergebnis;
        update();
        txtfullHouse.setText("" + ergebnis);
        fullHouse.setDisable(true);
        lockAll();
        lockedFullHouse = true;
        buttonNext.setDisable(false);

    }

    @FXML
    private void wettsystemöffnen(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLWettsystem.fxml"));

        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setTitle("Bet");
        stage.setScene(scene);
        stage.show();

        starten.toFront();
        wettsystem.setDisable(false);
        wettsystem.setVisible(false);
        Stage stage2 = (Stage) wettsystem.getScene().getWindow();
        stage2.close();

    }

    public void update() {
        if (lockedEiner == false) {
            einer.setDisable(false);

        }

        if (lockedZweier == false) {
            zweier.setDisable(false);

        }

        if (lockedDreier == false) {
            dreier.setDisable(false);

        }

        if (lockedVierer == false) {
            vierer.setDisable(false);

        }

        if (lockedFünfer == false) {
            fünfer.setDisable(false);

        }
        if (lockedSechser == false) {
            sechser.setDisable(false);

        }

        if (lockedDreierPasch == false) {
            dreierPasch.setDisable(false);

        }
        if (lockedViererPasch == false) {
            viererPasch.setDisable(false);

        }

        if (lockedKleineStrasse == false) {
            kleineStrasse.setDisable(false);

        }

        if (lockedGrosseStrasse == false) {
            grosseStrasse.setDisable(false);

        }

        if (lockedFullHouse == false) {
            fullHouse.setDisable(false);
        }

        if (lockedYatzy == false) {
            yatzy.setDisable(false);

        }

        if (lockedChance == false) {
            chance.setDisable(false);

        }

        if (bonus > 63 && bonusused == false) {
            txtBonus.setText("" + 35);
            total = total + 35;
            bonusused = true;
        }

        txtTotal.setText("" + total);

        if (runde < 14) {
            rundenzahl.setText("" + runde);
        }

        if (runde == 14) {
            makeWinscreen();
        }

    }

    private void lockAll() {
        einer.setDisable(true);
        zweier.setDisable(true);
        dreier.setDisable(true);
        vierer.setDisable(true);
        fünfer.setDisable(true);
        sechser.setDisable(true);
        dreierPasch.setDisable(true);
        viererPasch.setDisable(true);
        fullHouse.setDisable(true);
        kleineStrasse.setDisable(true);
        grosseStrasse.setDisable(true);
        yatzy.setDisable(true);
        chance.setDisable(true);
    }

    //Bot Mechanik
    private void fülleArray() {
        botKombinationen.add("Einer");
        botKombinationen.add("Zweier");
        botKombinationen.add("Dreier");
        botKombinationen.add("Vierer");
        botKombinationen.add("Fünfer");
        botKombinationen.add("Sechser");
        botKombinationen.add("DreierPasch");
        botKombinationen.add("ViererPasch");
        botKombinationen.add("FullHouse");
        botKombinationen.add("KleineStrasse");
        botKombinationen.add("GrosseStrasse");
        botKombinationen.add("Yatzy");
        botKombinationen.add("Chance");
    }

    private void wähleKombination() {

        Random rnd = new Random();

        gewählteZahl = rnd.nextInt(zufallBot);

        zufallBot -= 1;

        String gewählteMethode = botKombinationen.get(gewählteZahl);
        botKombinationen.remove(gewählteZahl);
        Random random = new Random();

        int i = random.nextInt(10 + 1);

        switch (gewählteMethode) {
            case "Einer":
                Random randomEiner = new Random();
                int reiner = randomEiner.nextInt(2);

                switch (reiner) {
                    case 0:
                        botEiner.setText("" + 3);
                        bottotal = bottotal + 3;
                        botbonus = botbonus + 3;
                        botUpdate();
                        break;
                    case 1:
                        botEiner.setText("" + 4);
                        bottotal = bottotal + 4;
                        botbonus = botbonus + 4;
                        botUpdate();
                        break;

                    case 2:
                        botEiner.setText("" + 5);
                        bottotal = bottotal + 5;
                        botbonus = botbonus + 5;
                        botUpdate();
                        break;
                }

                break;
            case "Zweier":
                Random randomZweier = new Random();
                int rzweier = randomZweier.nextInt(2);

                switch (rzweier) {
                    case 0:
                        botZweier.setText("" + 6);
                        bottotal = bottotal + 6;
                        botbonus = botbonus + 6;
                        botUpdate();
                        break;
                    case 1:
                        botZweier.setText("" + 8);
                        bottotal = bottotal + 8;
                        botbonus = botbonus + 8;
                        botUpdate();
                        break;

                    case 2:
                        botZweier.setText("" + 10);
                        bottotal = bottotal + 10;
                        botbonus = botbonus + 10;
                        botUpdate();
                        break;
                }

                break;
            case "Dreier":
                Random randomDreier = new Random();
                int rdreier = randomDreier.nextInt(2);
                switch (rdreier) {
                    case 0:
                        botDreier.setText("" + 9);
                        bottotal = bottotal + 9;
                        botbonus = botbonus + 9;
                        botUpdate();
                        break;
                    case 1:
                        botDreier.setText("" + 12);
                        bottotal = bottotal + 12;
                        botbonus = botbonus + 12;
                        botUpdate();

                    case 2:
                        botDreier.setText("" + 15);
                        bottotal = bottotal + 15;
                        botbonus = botbonus + 15;
                        botUpdate();
                        break;
                }

                break;
            case "Vierer":
                Random randomVierer = new Random();
                int rvierer = randomVierer.nextInt(2);

                switch (rvierer) {
                    case 0:
                        botVierer.setText("" + 12);
                        bottotal = bottotal + 12;
                        botbonus = botbonus + 12;
                        botUpdate();
                        break;
                    case 1:
                        botVierer.setText("" + 16);
                        bottotal = bottotal + 16;
                        botbonus = botbonus + 16;
                        botUpdate();
                        break;

                    case 2:
                        botVierer.setText("" + 20);
                        bottotal = bottotal + 20;
                        botbonus = botbonus + 20;
                        botUpdate();
                        break;
                }

                break;
            case "Fünfer":
                Random randomFünfer = new Random();
                int rfünfer = randomFünfer.nextInt(2);

                switch (rfünfer) {
                    case 0:
                        botFünfer.setText("" + 15);
                        bottotal = bottotal + 15;
                        botbonus = botbonus + 15;
                        botUpdate();
                        break;
                    case 1:
                        botFünfer.setText("" + 20);
                        bottotal = bottotal + 20;
                        botbonus = botbonus + 20;
                        botUpdate();
                        break;

                    case 2:
                        botFünfer.setText("" + 25);
                        bottotal = bottotal + 25;
                        botbonus = botbonus + 25;
                        botUpdate();
                        break;
                }

                break;
            case "Sechser":
                Random randomSechser = new Random();
                int rsechser = randomSechser.nextInt(2);

                switch (rsechser) {
                    case 0:
                        botSechser.setText("" + 18);
                        bottotal = bottotal + 18;
                        botbonus = botbonus + 18;
                        botUpdate();
                        break;
                    case 1:
                        botSechser.setText("" + 24);
                        bottotal = bottotal + 24;
                        botbonus = botbonus + 24;
                        botUpdate();

                        break;

                    case 2:
                        botSechser.setText("" + 30);
                        bottotal = bottotal + 30;
                        botbonus = botbonus + 30;
                        botUpdate();
                        break;
                }

                break;
            case "DreierPasch":
                Random randomDreierPasch = new Random();
                int rdreierpasch = randomDreierPasch.nextInt(10 + 1) + 20;

                botDreierPasch.setText("" + rdreierpasch);
                bottotal = bottotal + rdreierpasch;
                botUpdate();

                break;
            case "ViererPasch":
                Random randomViererPasch = new Random();
                int rviererpasch = randomViererPasch.nextInt(10 + 1) + 20;

                botViererPasch.setText("" + rviererpasch);
                bottotal = bottotal + rviererpasch;
                botUpdate();

                break;
            case "FullHouse":
                switch (i) {
                    case 1:
                        botFullHouse.setText("" + 0);
                        break;

                    case 5:
                        botFullHouse.setText("" + 0);
                        break;

                    case 9:
                        botFullHouse.setText("" + 0);
                        break;

                    default:
                        botFullHouse.setText("" + 25);
                        bottotal = bottotal + 25;
                        botUpdate();
                        break;

                }

                break;
            case "KleineStrasse":
                switch (i) {
                    case 1:
                        botKleineStrasse.setText("" + 0);
                        break;

                    case 5:
                        botKleineStrasse.setText("" + 0);
                        break;

                    case 9:
                        botKleineStrasse.setText("" + 0);
                        break;

                    default:
                        botKleineStrasse.setText("" + 30);
                        bottotal = bottotal + 30;
                        botUpdate();
                        break;

                }

                break;
            case "GrosseStrasse":
                switch (i) {
                    case 1:
                        botGrosseStrasse.setText("" + 0);
                        break;

                    case 5:
                        botGrosseStrasse.setText("" + 0);
                        break;

                    case 9:
                        botGrosseStrasse.setText("" + 0);
                        break;
                    default:
                        botGrosseStrasse.setText("" + 40);
                        bottotal = bottotal + 40;
                        botUpdate();
                        break;

                }

                break;
            case "Yatzy":
                switch (i) {
                    case 1:
                        botYatzy.setText("" + 0);
                        break;

                    case 5:
                        botYatzy.setText("" + 0);
                        break;

                    case 9:
                        botYatzy.setText("" + 0);
                        break;

                    default:
                        botYatzy.setText("" + 50);
                        bottotal = bottotal + 50;
                        botUpdate();
                        break;

                }

                break;
            case "Chance":
                Random randomChance = new Random();
                int rchance = randomChance.nextInt(10 + 1) + 20;

                botChance.setText("" + rchance);
                bottotal = bottotal + rchance;
                botUpdate();

                break;

        }

    }

    private void botUpdate() {

        if (botbonus > 63 && botbonusused == false) {
            botBonus.setText("" + 35);
            bottotal = bottotal + 35;
            botbonusused = true;
        }

        botTotal.setText("" + bottotal);
    }

    //Winscreen Code
    private void makeWinscreen() {

        winscreen.setVisible(true);
        winscreen.setDisable(false);

        if (bottotal > total) {
            gewinner.setText("Verloren");
            gewonnenesGeld.setText("Verlorenes Geld:");
            gewonnenesWert.setText("" + wetteinsatzWert);

        } else {
            gewinner.setText("Gewonnen");
            gewonnenesGeld.setText("Gewonnenes Geld:");
            gewonnenesWert.setText("" + (wetteinsatzWert * 2));
            kontostand = kontostand + wetteinsatzWert * 2;
        }

        Punkte.setText("" + total);
        botPunkte.setText("" + bottotal);
        neuerKontostand.setText("" + kontostand);

    }

    public void getÜbergabe(int gesetzterBetrag) {
        wetteinsatzWert = gesetzterBetrag;
        wetteinsatz.setText("" + gesetzterBetrag);
        kontostand = kontostand - gesetzterBetrag;
        wettsystem.setDisable(true);
        wettsystem.setVisible(false);
    }

    @FXML
    public void beenden() {
        Platform.exit();
    }

    @FXML
    public void neustart() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

        Stage stage2 = (Stage) neueRunde.getScene().getWindow();
        stage2.close();
    }

    @FXML
    private void info(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLInfo.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void beenden(ActionEvent event) throws IOException {
        Stage stage = (Stage) beenden.getScene().getWindow();
        stage.close();

    }

}
