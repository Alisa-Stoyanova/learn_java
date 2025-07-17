package codeabbey;

import codeabbey.utils.Printer;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        //InputReader reader = new InputReader();
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        Number[] results = new Number[amount]; // for both integers und doubles
        for (int i = 0; i < amount; i++) {
            int x = scanner.nextInt(); // the given value for which to perform calculations
            int n = scanner.nextInt(); // number of steps to perform
            results[i] = convertToIntIfNeeded(calcSqrt(x, n));
        }
        Printer.prettyPrint(results);
    }

    public static double calcSqrt(int x, int n) {
        double root = 1;
        int j = 0;
        while (j < n) {
            root = (root + x / root) / 2;
            j++;
        }
        return root;
    }

    public static Number convertToIntIfNeeded(double root) { // numbers with fractions won't be converted
        double fraction = root - (int) root;
        Number rootConverted = root;
        if (fraction == 0) {
            rootConverted = (int) root;
        }
        return rootConverted;
    }
}