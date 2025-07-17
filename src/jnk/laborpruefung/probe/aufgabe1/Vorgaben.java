package jnk.laborpruefung.probe.aufgabe1;

/**
 * In dieser Klasse finden Sie weitere Vorgaben für Aufgabe 1.
 */
public class Vorgaben {
    /**
     * Berechnet die Summe der beiden Zahlen a und b. Wirft eine NegativException, wenn eine
     * der beiden Zahlen negativ ist.
     */
    public static int positiveSumme(int a, int b) throws NegativException {

        // Diese Zeile ignorieren, nicht für die Aufgaben relevant.
        numCalls++;

        if (a < 0 || b < 0) {
            throw new NegativException();
        }
        return a + b;
    }

    /**
     * Ein Aufzählungstyp für String-Operationen.
     */
    public enum StringOperation {
        UMDREHEN, OHNE_E, IST_LANG
    }

    // +++++ Code ab hier ignorieren, nicht für die Aufgaben relevant. ++++++
    private static int numCalls;

    public static int getNumCalls() {
        return numCalls;
    }

    public static int resetNumCalls() {
        return numCalls = 0;
    }
}
