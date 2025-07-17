package jnk.laborpruefung.probe.aufgabe1;


import static jnk.laborpruefung.probe.aufgabe1.Vorgaben.positiveSumme;

/**
 * Dies ist die Vorgabeklasse für die Aufgabe 1. Alle Lösungen für Aufgabe 1 müssen in den bereits angelegten
 * Methodenrümpfen implementiert werden.
 */
public class Imperativ {

    /**
     * Aufgabe 1.1
     */
    public String kleinbuchstabenstringAusArray(char[] zeichenArray) {
        String kleinbuchstabenstring = "";
        for (int i = 0; i < zeichenArray.length; i++) {
            if (zeichenArray[i] >= 'a' && zeichenArray[i] <= 'z') {
                String buchstabe = "" + zeichenArray[i];
                kleinbuchstabenstring += buchstabe;
            }
        }
        return kleinbuchstabenstring;
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    /**
     * Aufgabe 1.2
     */
    public String stringVerarbeiten(Vorgaben.StringOperation op, String text) {
        String verarbeitet = "";
        switch (op) {
            case UMDREHEN -> {
                for (int i = text.length() - 1; i >= 0; i--) {
                    String s = "" + text.charAt(i);
                    verarbeitet += s;
                }
            }
            case OHNE_E -> {
                for (int i = 0; i < text.length(); i++) {
                    if (text.charAt(i) != 'E') {
                        String s = "" + text.charAt(i);
                        verarbeitet += s;
                    }
                }
            }
            case IST_LANG -> {
                if (text.length() > 10) {
                    return "LANG";
                }
                return "KURZ";
            }
        }
        return verarbeitet;
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    /**
     * Aufgabe 1.3.a
     */
    public int summe(int a, int b, int c) {
        int sum;
        try {
            sum = positiveSumme(a, b);
            sum = positiveSumme(sum, c);
        } catch (NegativException e) {
            return -1;
        }
        return sum;
    }

    /**
     * Aufgabe 1.3.b
     */
    public boolean summeGroesserWert(int a, int b, int wert) throws NegativException {
        int sum = positiveSumme(a, b);
        return sum > wert;
    }

    /**
     * Hier können die Implementierungen getestet werden. Nicht Teil der Bewertung.
     */
    public static void main(String[] args) {
        Imperativ imp = new Imperativ();

        // Hier können Sie Ausprobieren.
    }
}
