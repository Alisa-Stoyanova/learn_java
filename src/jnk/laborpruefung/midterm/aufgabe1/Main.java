package jnk.laborpruefung.midterm.aufgabe1;

import jnk.laborpruefung.midterm.aufgabe2.Tupel;

public class Main {
    public static void main(String[] args) {
        System.out.println(summeGeraderZahlen(5, 10)); // 24
        System.out.println(summeGeraderZahlen(-4, 3)); // -4

        System.out.println(gleitkomma2Kleinbuchstabe(-0.5)); // a
        System.out.println(gleitkomma2Kleinbuchstabe(25.4)); // z
        System.out.println(gleitkomma2Kleinbuchstabe(17.7)); // s

        System.out.println(rechner('+', 2, 3)); // 5
        System.out.println(rechner('-', 5, 1)); // 4
        System.out.println(rechner('h', 23, 42)); // 0

        Tupel t1 = new Tupel(23, 'a');
        Tupel t2 = new Tupel(42, 'c');
        System.out.println((t1.zusammen(t2))); // (65, a)

        Tupel t3 = new Tupel(-2, 'k');
        Tupel t4 = new Tupel(3, 'b');
        System.out.println((t3.zusammen(t4))); // (1, b)

        System.out.println((t3 == t3.zusammen(null))); // other object (address)

        Tupel t5 = new Tupel(100, 'a');
        t5.flip();
        System.out.println(t5); // (97, d)

        Tupel t6 = new Tupel(-1, 'c');
        t6.flip();
        System.out.println(t6); // (99, \u0000)
    }

    public static int summeGeraderZahlen(int start, int ende) {
        int sum = 0;
        for (int i = start; i <= ende; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static char gleitkomma2Kleinbuchstabe(double wert) {
        if (wert < -0.5 || wert > 25.4) {
            throw new IllegalArgumentException();
        } else {
            int newWert = (int) wert; // wert = -2.5; newWert = -2
            double nachkomma = wert - newWert; // -2.5 - -2 = -2.5 + 2 = -0.5
            if (nachkomma >= 0.5) {
                newWert++;
            }
            return (char) (newWert + 'a'); // + 97 --> ASCII for 'a'
        }
    }

    public static int rechner(char operator, int op1, int op2) {
        if (operator == '+') {
            return op1 + op2;
        }
        if (operator == '-') {
            return op1 - op2;
        }
        return 0;
    }
}

