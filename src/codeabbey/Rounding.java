package codeabbey;

// import java.util.Arrays;

import java.util.Scanner;

public class Rounding {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String amountStr = scan.nextLine();
        int amount = Integer.parseInt(amountStr);

        String[][] pairAryStr = new String[amount][2];
        int i = 0;
        while (i < amount) {
            String pairStr = scan.nextLine();
            pairAryStr[i] = pairStr.split(" ");
            i++;
        }

        double[][] pairAry = new double[amount][2];
        i = 0;
        int j = 0;
        while (i < amount) {
            while (j < 2) {
                pairAry[i][j] = Double.parseDouble(pairAryStr[i][j]);
                j++;
            }
            j = 0;
            i++;
        }
        //System.out.println(Arrays.deepToString(pairAry));

        int[] resultAry = new int[amount];
        i = 0;
        //j = 0; // ueberfluessig wegen Zeile 28
/*        while(i < amount) {
            pairAry[i][j] /= pairAry[i][j + 1];
            double fraction = pairAry[i][j] - (int)pairAry[i][j];
            //System.out.println(fraction);
            if(fraction == 0.5) {
                resultAry[i] = (int)(pairAry[i][j] + 0.5);
            } else if(fraction == -0.5) {
                resultAry[i] = (int)(pairAry[i][j] - 0.5);
            } else if(fraction > 0.5) {
                resultAry[i] = (int)(pairAry[i][j] + 1);
            } else if(fraction < -0.5) {
                resultAry[i] = (int)(pairAry[i][j] - 1);
            } else {
                resultAry[i] = (int)pairAry[i][j];
            }
            i++;
        }*/

        while (i < amount) {
            pairAry[i][j] /= pairAry[i][j + 1];
            double fraction = pairAry[i][j] - (int) pairAry[i][j];
            if (fraction >= 0.5) {
                resultAry[i] = (int) (pairAry[i][j] + 1);
            } else if (fraction <= -0.5) {
                resultAry[i] = (int) (pairAry[i][j] - 1);
            } else {
                resultAry[i] = (int) pairAry[i][j];
            }
            i++;
        }

        i = 0;
        while (i < amount) {
            System.out.print(resultAry[i] + " ");
            i++;
        }
    }
}