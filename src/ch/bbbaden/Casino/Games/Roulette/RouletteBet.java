/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Roulette;

/**
 *
 * @author Denis Silvia Meira
 */
public class RouletteBet {

    //Multiplikatoren für Gewinnausrechnung
    private final double RedMultiplicator = 1.0;
    private final double BlackMultiplicator = 1.0;
    private final double EvenMultiplicator = 1.0;
    private final double OddMultiplicator = 1.0;
    private final double LowMultiplicator = 1.0;
    private final double HighMultiplicator = 1.0;
    private final double RowMultiplicator = 2.0;
    private final double DozenMultiplicator = 2.0;
    private final double StraightMultiplicator = 35.0;
    private final double SplittMultiplicator = 17.0;
    private final double CornerMultiplicator = 8.0;
    private final double StreetMultiplicator = 11.0;
    private final double LineMultiplicator = 5.0;

    //Wettenart Variable für Bestimmung
    private String bettype;
    //Array für maximale Anzahl Wert auf einem Feld
    private Integer BetNumbers[] = new Integer[18];
    //Einsatzmenge für Wette
    private double Betvalue = 0;
    //Gezogene Zahl für Überprüfung mit Wetten
    private int randomNumber;

    
    public RouletteBet(String bettype, Integer[] BetNumbers, double Betvalue) {
        this.BetNumbers = BetNumbers;
        this.bettype = bettype;
        this.Betvalue = Betvalue;
    }

    //Ausmultiplikation der Wettarten
    public double Bet() {
        boolean numberCheck = false;
        double win = 0.0;

        for (int i = 0; i < this.BetNumbers.length; i++) {
            if (this.BetNumbers[i] == randomNumber) {
                numberCheck = true;
            }
        }

        if (numberCheck) {

            switch (bettype) {

                case "Red":
                    win = this.Betvalue * RedMultiplicator;
                    break;
                case "Black":
                    win = this.Betvalue * BlackMultiplicator;
                    break;
                case "EVEN":
                    win = this.Betvalue * EvenMultiplicator;
                    break;
                case "ODD":
                    win = this.Betvalue * OddMultiplicator;
                    break;
                case "Low":
                    win = this.Betvalue * LowMultiplicator;
                    break;
                case "High":
                    win = this.Betvalue * HighMultiplicator;
                    break;
                case "Row":
                    win = this.Betvalue * RowMultiplicator;
                    break;
                case "Dozen":
                    win = this.Betvalue * DozenMultiplicator;
                    break;
                case "Straight":
                    win = this.Betvalue * StraightMultiplicator;
                    break;
                case "Splitt":
                    win = this.Betvalue * SplittMultiplicator;
                    break;
                case "Corner":
                    win = this.Betvalue * CornerMultiplicator;
                    break;
                case "Street":
                    win = this.Betvalue * StreetMultiplicator;
                    break;
                case "Line":
                    win = this.Betvalue * LineMultiplicator;
                    break;

            }
        }
        return win;

    }

    //Setter für Rand Zahlen.
    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

}
