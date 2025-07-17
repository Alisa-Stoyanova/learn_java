package codeabbey;

import java.util.Scanner;

public class MedianOfThree {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String amountStr = scan.nextLine();
        int amount = Integer.parseInt(amountStr);
        //System.out.println(amount);

        String[][] tripletsStrAry = new String[amount][]; // ?
        for (int i = 0; i < amount; i++) {
            String tripletsStr = scan.nextLine();
            tripletsStrAry[i] = tripletsStr.split(" ");
        }
        //System.out.println(Arrays.deepToString(tripletsStrAry));

        int[][] tripletsIntAry = new int[amount][];
        for (int i = 0; i < amount; i++) {
            tripletsIntAry[i] = new int[tripletsStrAry[i].length];
            for (int j = 0; j < tripletsStrAry[i].length; j++) {
                tripletsIntAry[i][j] = Integer.parseInt(tripletsStrAry[i][j]);
            }
        }
        //System.out.println(Arrays.deepToString(tripletsIntAry));

        for (int i = 0; i < amount; i++) {
            for (int k = tripletsIntAry[i].length; k > 0; k--) { //
                for (int j = 0; j < tripletsIntAry[i].length - 1; j++) {
                    if (tripletsIntAry[i][j] > tripletsIntAry[i][j + 1]) {
                        int temp = tripletsIntAry[i][j];
                        tripletsIntAry[i][j] = tripletsIntAry[i][j + 1];
                        tripletsIntAry[i][j + 1] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < amount; i++) {
            int median = tripletsIntAry[i].length / 2; // will not work if amount is even
            System.out.print(tripletsIntAry[i][median] + " ");
        }
    }
}
