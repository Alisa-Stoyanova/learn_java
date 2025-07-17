package codeabbey.utils;

public class Printer {
    public static void prettyPrint(Object[] output) {
        for (Object out : output) {
            System.out.print(out + " ");
        }
    }
}
