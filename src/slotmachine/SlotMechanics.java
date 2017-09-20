/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import java.util.Random;

/**
 *
 * @author Alexander
 */
public class SlotMechanics {
// Denna klass ska innehålla funktioner för hur maskinen ska fungera

    double betAmount, winAmount, win1, win2, win3, win4, win5, win6, win7, win8, jackpot;

    public SlotMechanics(int betAmount) {
        this.betAmount = betAmount;
    }

    private void winAmounts() {
        //Denna ska definiera alla olika vinsters värde. om man vinner ska man som minst få tillbaka insättningen.
        win1 = 1;
        win2 = 1.5;
        win3 = 2;
        win4 = 2.5;
        win5 = 4;
        win6 = 5;
        win7 = 8;
        win8 = 10;
        jackpot = 1;//Hämta jackpoten här
    }

    private String slotCalculator() {
        Random random = new Random();
        double randomNumber = random.nextInt(100);

        if (randomNumber >= 50) {
            return "1";
        } else if (randomNumber < 50 && randomNumber >= 25) {
            return "2";
        } else if (randomNumber < 25 && randomNumber >= 13.5) {
            return "3";
        } else if (randomNumber < 13.5 && randomNumber >= 6.8) {
            return "4";
        } else if (randomNumber < 6.8 && randomNumber >= 3.4) {
            return "5";
        } else if (randomNumber < 3.4 && randomNumber >= 2.7) {
            return "6";
        } else if (randomNumber < 2.7 && randomNumber >= 1.35) {
            return "7";
        } else if (randomNumber < 1.35 && randomNumber >= 0) {
            return "8";
        } else {
            return "";
        }
    }

    private double winCalculator() {
        return 0.0;
    }

    // vit, blå, grön, lila, gul, pengar, pengajackpot, eridium l, eridium s,
}
