package codeabbey.utils;

public class Rounder {
    public static int round(double number) {
        int result;
        double fraction = number - (int) number;
        if (fraction >= 0.5) {
            result = (int) number + 1;
        } else if (fraction <= -0.5) { // for negative numbers
            result = (int) number - 1;
        } else {
            result = (int) number;
        }
        return result;
    }
}