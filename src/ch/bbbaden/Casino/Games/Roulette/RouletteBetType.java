/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Roulette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Denis Silvia Meira
 */
public class RouletteBetType {

    ArrayList<RouletteBet> bets = new ArrayList<RouletteBet>(36);
    double TotalWin = 0;
    Random randnumber = new Random();
    int number = 0;

    //Wette hinzufügen und nach Wettenart Überprüfen! PS: Thanks for the Help
    public void addbet(Integer[] Betnumbers, double Betvalue) {

        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(Betnumbers));

        if (numbers.size() == 1) {
            // straight up
            this.bets.add(new RouletteBet("Straight", Betnumbers, Betvalue));
        } else if (numbers.size() == 2) {
            // splitt bet
            this.bets.add(new RouletteBet("Splitt", Betnumbers, Betvalue));
        } else if (numbers.size() == 3) {
            // street
            this.bets.add(new RouletteBet("Corner", Betnumbers, Betvalue));
        } else if (numbers.size() == 4) {
            // corner
            this.bets.add(new RouletteBet("Street", Betnumbers, Betvalue));
        } else if (numbers.size() == 6) {
            // line
            this.bets.add(new RouletteBet("Line", Betnumbers, Betvalue));
        } else if (numbers.size() == 12) {
            // Dozens
            if (numbers.contains(1) && numbers.contains(12)) {
                this.bets.add(new RouletteBet("Dozen", Betnumbers, Betvalue));
            } else if (numbers.contains(13) && numbers.contains(24)) {
                this.bets.add(new RouletteBet("Dozen", Betnumbers, Betvalue));
            } else if (numbers.contains(25) && numbers.contains(36)) {
                this.bets.add(new RouletteBet("Dozen", Betnumbers, Betvalue));
            } // rows
            else if ((numbers.contains(1) && numbers.contains(34)) || (numbers.contains(2) && numbers.contains(35)) || (numbers.contains(3) && numbers.contains(36))) {
                this.bets.add(new RouletteBet("Row", Betnumbers, Betvalue));
            }
        } else if (numbers.size() == 17) {
            //  red
            if (numbers.contains(5) && numbers.contains(12) && numbers.contains(23) && numbers.contains(32)) {
                this.bets.add(new RouletteBet("Red", Betnumbers, Betvalue));
            }
        } else if (numbers.size() == 18) {
            // even
        } else if (numbers.contains(4) && numbers.contains(6) && numbers.contains(22) && numbers.contains(36)) {
            this.bets.add(new RouletteBet("Even", Betnumbers, Betvalue));
        } // odd
        else if (numbers.contains(3) && numbers.contains(5) && numbers.contains(21) && numbers.contains(33)) {
            this.bets.add(new RouletteBet("Odd", Betnumbers, Betvalue));
        } // low
        else if (numbers.get(numbers.size() - 1) == 18) {
            this.bets.add(new RouletteBet("Low", Betnumbers, Betvalue));
        } // high
        else if (numbers.get(numbers.size() - 1) == 36) {
            this.bets.add(new RouletteBet("High", Betnumbers, Betvalue));
        } else if (numbers.size() == 19) {
            this.bets.add(new RouletteBet("Black", Betnumbers, Betvalue));
        }
    }

    //Ausgabe des Gewinnes und Vergleich Wettzahlen und Rand Zahl.
    public double getWin() {
        double TotalWin = 0;

        for (RouletteBet RB : this.bets) {
            RB.setRandomNumber(number);
            TotalWin += RB.Bet();
        }

        return TotalWin;
    }

    //Methode für Ausgabe im Controller für die Rand Number
    public double getRandom() {
        return number;
    }

    //Methode für Generierung der Rand Number
    public void GenerateRandNumber() {
        number = (int) (randnumber.nextDouble() * 36);
    }

    public double resetWin() {
        return TotalWin = 0;
    }
}
