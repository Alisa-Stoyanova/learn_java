package codeabbey;

import codeabbey.utils.InputReader;
import codeabbey.utils.Printer;

public class SmoothingTheWeather {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        reader.readInt();
        double[] msrmnts = reader.readDoubleAry(); //measurements
        int amount = msrmnts.length;
        double[] smoothed = new double[amount];
        Double[] results = new Double[amount];
        smoothed[0] = msrmnts[0];
        smoothed[amount - 1] = msrmnts[amount - 1];
        int i = 1;
        while (i < amount - 1) {
            smoothed[i] = (msrmnts[i - 1] + msrmnts[i] + msrmnts[i + 1]) / 3;
            i++;
        }
        for (int j = 0; j < amount; j++) {
            results[j] = smoothed[j];
        }
        Printer.prettyPrint(results);
    }
}
