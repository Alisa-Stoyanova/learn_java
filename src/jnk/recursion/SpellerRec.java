package jnk.recursion;

public class SpellerRec {

    public static void main(String[] args) {
        String word = "Hello";
        printIter(word);
        System.out.println();
        printRec(word);
        System.out.println();
        printTailRec(word);
    }

    public static void printIter(String word) {
        for (int i = 0; i < word.length(); i++) {
            System.out.print(word.charAt(i));
        }
    }

    public static void printRec(String word) {
        int start = 0;
        if (start == word.length()) {
            return;
        }
        System.out.print(word.charAt(start));
        printTailRec(word.substring(start + 1));
    }

    public static void printTailRec(String word) {
        int start = 0;
        if (start == word.length()) {
            return;
        }
        System.out.print(word.charAt(start));
        printTailRec(word.substring(start + 1));
    }
}
