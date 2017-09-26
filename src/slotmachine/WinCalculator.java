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
public class WinCalculator {
// Denna klass ska innehålla funktioner för hur maskinen ska fungera

    double betAmount, winAmount;/*, win1, win2, win3, win4, win5, win6, win7, win8, jackpot;*/
    double win1 = 1,
            win2 = 1.5,
            win3 = 2,
            win4 = 2.5,
            win5 = 4,
            win6 = 5,
            win7 = 8,
            win8 = 10,
            jackpot = 5000;

    public WinCalculator(int betAmount) {
        this.betAmount = betAmount;
    }

    public WinCalculator() {

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

    String slotCalculator() {
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

    double winCalculator(int betAmount, String leftSlot, String middleSlot, String rightSlot) {
        switch (leftSlot + middleSlot + rightSlot) {
            case "111":
                winAmount = betAmount * win1;
                break;
            case "222":
                winAmount = betAmount * win2;
                break;
            case "333":
                winAmount = betAmount * win3;
                break;
            case "444":
                winAmount = betAmount * win4;
                break;
            case "555":
                winAmount = betAmount * win5;
                break;
            case "666":
                winAmount = betAmount * win6;
                break;
            case "777":
                winAmount = betAmount * win7;
                break;
            case "888":
                winAmount = betAmount * win8;
                break;
            case "999":
                winAmount = betAmount + jackpot;
                break;
        }
        return 0.0;
    }

    // vit, blå, grön, lila, gul, pengar, pengajackpot, eridium l, eridium s,
}
