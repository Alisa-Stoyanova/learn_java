package codeabbey;

import codeabbey.utils.InputReader;
import codeabbey.utils.Printer;

public class Triangles {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        int amount = reader.readInt();
        Integer[] result = new Integer[amount];
        int i = 0;
        while (i < amount) {
            int[] sides = reader.readIntAry();
            if (sides[0] + sides[1] > sides[2]
                    && sides[1] + sides[2] > sides[0]
                    && sides[2] + sides[0] > sides[1]) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
            i++;
        }
        Printer.prettyPrint(result);
    }
}
