package jnk.laborpruefung.probe;

/**
 * Exception für Probleme beim Evaluieren von Laborprüfungstests.
 */
public class LaborpruefungException extends Exception {
    public LaborpruefungException(String msg) {
        super(msg);
    }
}
