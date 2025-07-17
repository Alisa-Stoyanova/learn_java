package codeabbey;

import java.util.Scanner;

public class MinOfTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int amount = Integer.parseInt(scan.nextLine()) * 2;

        int[] pairs = new int[amount];

        int i = 0;
        while (i < amount) {
            String pairStr = scan.nextLine();
            String[] pairStrAry = pairStr.split(" ");
            int j = 0;
            while (j < 2) {
                pairs[i] = Integer.parseInt(pairStrAry[j]);
                i++;
                j++;
            }
        }
        //System.out.println(Arrays.toString(pairs));

        i = 0;
        while (i < amount - 1) {
            if (pairs[i] > pairs[i + 1]) {
                pairs[i] = pairs[i + 1];
            }
            i += 2;
        }

        i = 0;
        while (i < amount) {
            System.out.print(pairs[i] + " ");
            i += 2;
        }
    }
}
