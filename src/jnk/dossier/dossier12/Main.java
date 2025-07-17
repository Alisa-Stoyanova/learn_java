package jnk.dossier.dossier12;

public class Main {
    public static void main(String[] args) {
        System.out.println("Betrag: " + betrag(-5));
        System.out.print("printWithSpaceIter: ");
        printWithSpaceIter("Recursion");
        System.out.println();
        System.out.print("printWithSpaceRec: ");
        printWithSpaceRec("Excursion");
    }

    public static int betrag(int zahl) {
        //int betrag = Math.abs(zahl);
        return zahl >= 0 ? zahl : -zahl;
    }

    public static void printWithSpaceIter(String text) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i) + " ");
        }
    }

    public static void printWithSpaceRec(String text) {
        printWithSpaceRec(text, 0);
    }

    public static void printWithSpaceRec(String text, int i) {
        if (text.length() == 0) {
            System.out.println(text);
        }
        System.out.print(text.charAt(i) + " ");
        if (i < text.length()) {
            printWithSpaceRec(text, i + 1);
        }
    }
}
