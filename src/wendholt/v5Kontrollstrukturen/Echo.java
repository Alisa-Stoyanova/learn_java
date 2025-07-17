package wendholt.v5Kontrollstrukturen;

import java.util.Scanner;

public class Echo { // nachprüfende/fußgesteuerte Schleife
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String input;
        do {
            String input = scanner.next();
            if (input.equals("bye")) {
                break;
            }
            System.out.println(input);
        } while (scanner.hasNext());
        scanner.close();
    }
}