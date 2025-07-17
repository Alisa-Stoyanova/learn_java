package codeabbey;

import codeabbey.utils.InputReader;
import codeabbey.utils.Printer;

public class CombinationsCounting {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        int amount = reader.readInt();
        Long[] results = new Long[amount];
        for (int i = 0; i < amount; i++) {
            int[] input = reader.readIntAry();
            int n = input[0];
            int k = input[1];
            results[i] = calcFactorial(n) / (calcFactorial(k) * (calcFactorial(n - k)));
        }
        Printer.prettyPrint(results);
    }

    public static long calcFactorial(int n) {
        long nFactorial = 1; // n = 0, n! = 1; n = 1, n! = 1
        for (int j = 1; j <= n; j++) {
            nFactorial *= j;
        }
        return nFactorial;
    }
}