package codeabbey;

import java.util.Scanner;

public class MaximumOfArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputStr = scan.nextLine();
        String[] inputStrAry = inputStr.split(" ");
        int length = inputStrAry.length;
        int[] inputIntAry = new int[length];
        for (int i = 0; i < length; i++) {
            inputIntAry[i] = Integer.parseInt(inputStrAry[i]);
        }

        int max = inputIntAry[0];
        int min = inputIntAry[0];
        for (int i = 1; i < length; i++) {
            if (inputIntAry[i] > max) {
                max = inputIntAry[i];
            }
            if (inputIntAry[i] < min) {
                min = inputIntAry[i];
            }
        }
        System.out.print(max + " " + min);
    }
}
