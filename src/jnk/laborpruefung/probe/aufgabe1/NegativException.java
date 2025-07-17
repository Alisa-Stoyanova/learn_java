package jnk.laborpruefung.probe.aufgabe1;

/**
 * Eine eigene Exception-Implementierung für Ausnahmesituationen mit nicht-positiven Zahlen.
 */
public class NegativException extends Exception {
    public NegativException() {
        super("Zahl muss positiv sein.");
    }
}
