package codeabbey;

import java.util.Scanner;

public class SumsInLoop {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the amount of pairs");
        String amountAsString = myScanner.nextLine();
        int amount = Integer.parseInt(amountAsString);

        int[] sums = new int[amount];

        System.out.println("Enter the pairs of numbers to sum");

        for (int i = 0; i < amount; i++) {
            String pair = myScanner.nextLine();
            String[] pairStringAry = pair.split(" ");
            int sum = 0;
            for (int j = 0; j < 2; j++) {
                int num = Integer.parseInt(pairStringAry[j]);
                sum += num;
            }
            sums[i] = sum;
        }
        System.out.println("The sums are:");
        for (int k = 0; k < amount; k++) {
            System.out.print(sums[k] + " ");
        }
    }
}
