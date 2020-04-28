/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.Casino.Games.Yatzy;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author yanni
 */
public class SchwierigeKombinationen {

    public int Yatzy(int[] würfel) {
        int ergebnis = 0;
        int b = würfel[0];

        for (int zahl : würfel) {

            if (zahl == b) {
                ergebnis++;

            }
        }

        if (ergebnis == 5) {
            return 50;
        }

        return 0;

    }

    public int DreierPasch(int[] würfel) {
        int ergebnis = 0;
        int gleiche = 0;
        int letztezahl = 0;
        Arrays.sort(würfel);

        for (int zahl : würfel) {
            if (zahl == letztezahl) {
                gleiche++;
                ergebnis = ergebnis + zahl;
            } else if (zahl != letztezahl) {
                ergebnis = ergebnis + zahl;
            }

            letztezahl = zahl;

        }

        if (gleiche >= 2) {
            return (ergebnis);
        }
        return 0;
    }

    public int ViererPasch(int[] würfel) {
        int ergebnis = 0;
        int gleiche = 0;
        int letztezahl = 0;
        Arrays.sort(würfel);

        for (int zahl : würfel) {
            if (zahl == letztezahl) {
                gleiche++;
                ergebnis = ergebnis + zahl;
            } else {
                ergebnis = ergebnis + zahl;
            }

            letztezahl = zahl;

        }

        if (gleiche >= 3) {
            return (ergebnis);
        }
        return 0;
    }

    public int KleineStrasse(int[] würfel) {
        int ergebnis = 0;
        int grössere = 0;
        int letztezahl = 1;
        Arrays.sort(würfel);

        for (int zahl : würfel) {
            if (zahl == letztezahl + 1) {
                grössere++;

            }

            if (zahl - 2 == letztezahl && grössere > 1 && grössere < 3) {
                return 0;
            }

            letztezahl = zahl;

        }

        if (grössere >= 3) {
            return 30;
        }
        return 0;
    }

    public int GrosseStrasse(int[] würfel) {
        int ergebnis = 0;
        int grössere = 0;
        int letztezahl = 1;
        Arrays.sort(würfel);

        for (int zahl : würfel) {
            if (zahl == letztezahl + 1) {
                grössere++;

            }

            letztezahl = zahl;

        }

        if (grössere >= 4) {
            return 40;
        }
        return 0;
    }

    public int Chance(int[] würfel) {
        int ergebnis = 0;
        
        Arrays.sort(würfel);

        for (int zahl : würfel) {
            ergebnis = ergebnis + zahl;
        }

        return ergebnis;
    }

    public int FullHouse(int[] würfel) {
        Arrays.sort(würfel);

        if (würfel[0] == würfel[1] && würfel[1] == würfel[2] && würfel[3] == würfel[4] && würfel[0] != würfel[4]) {
            return 25;
        } else if (würfel[0] == würfel[1] && würfel[2] == würfel[3] && würfel[3] == würfel[4] && würfel[0] != würfel[4]) {
            return 25;
        }

        return 0;
    }

}
