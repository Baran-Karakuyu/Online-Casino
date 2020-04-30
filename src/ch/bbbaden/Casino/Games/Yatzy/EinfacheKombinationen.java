package ch.bbbaden.Casino.Games.Yatzy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yannick Wulf
 */
public class EinfacheKombinationen {



    public int Einer(int[] würfel) {
        int ergebnis = 0;

        for (int zahl : würfel) {
            if (zahl == 1) {
                ergebnis = ergebnis + zahl;

            }
        }

        return ergebnis;
    }

    public int Zweier(int[] würfel) {
        int ergebnis = 0;

        for (int zahl : würfel) {
            if (zahl == 2) {
                ergebnis = ergebnis + zahl;

            }
        }

        return ergebnis;
    }

    public int Dreier(int[] würfel) {
        int ergebnis = 0;

        for (int zahl : würfel) {
            if (zahl == 3) {
                ergebnis = ergebnis + zahl;

            }
        }

        return ergebnis;
    }

    public int Vierer(int[] würfel) {
        int ergebnis = 0;

        for (int zahl : würfel) {
            if (zahl == 4) {
                ergebnis = ergebnis + zahl;

            }
        }

        return ergebnis;
    }

    public int Fünfer(int[] würfel) {
        int ergebnis = 0;

        for (int zahl : würfel) {
            if (zahl == 5) {
                ergebnis = ergebnis + zahl;

            }
        }

        return ergebnis;
    }

    public int Sechser(int[] würfel) {
        int ergebnis = 0;

        for (int zahl : würfel) {
            if (zahl == 6) {
                ergebnis = ergebnis + zahl;

            }
        }

        return ergebnis;
    }
}
