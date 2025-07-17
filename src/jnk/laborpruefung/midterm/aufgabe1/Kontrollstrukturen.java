package jnk.laborpruefung.midterm.aufgabe1;

/**
 * In dieser Klasse implementieren Sie die in Aufgabe 1 geforderten Methoden
 */
public class Kontrollstrukturen {

    /**
     * Aufgabe 1.1
     */
    public int summeGeraderZahlen(int start, int ende) {
        int sum = 0;
        for (int i = start; i <= ende; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * Aufgabe 1.2
     */
    public char gleitkomma2Kleinbuchstabe(double wert) {
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

    public char gleitkomma2KleinbuchstabeJNK(double wert) {
        if (wert < -0.5 || wert > 25.4) {
            throw new IllegalArgumentException("Wert außerhalb des Wertebereichs");
        }
        int index = (int) (wert + 0.5);
        char zeichen = (char) (index + 'a');
        return zeichen;
    }

    /**
     * Aufgabe 1.3
     */
    public int rechner(char operator, int op1, int op2) {
        if (operator == '+') {
            return op1 + op2;
        }
        if (operator == '-') {
            return op1 - op2;
        }
        return 0;
    }

    /**
     * Hier können Sie Ihre Methoden ausprobieren.
     */
    public static void main(String[] args) {
        Kontrollstrukturen k = new Kontrollstrukturen();

        // Aufgabe 1.1
        System.out.println(k.summeGeraderZahlen(5, 10));
        System.out.println(k.summeGeraderZahlen(-4, 3));

        // Aufgabe 1.2
        System.out.println(k.gleitkomma2Kleinbuchstabe(-0.5));
        System.out.println(k.gleitkomma2Kleinbuchstabe(25.4));
        System.out.println(k.gleitkomma2Kleinbuchstabe(17.7));
    }
}
