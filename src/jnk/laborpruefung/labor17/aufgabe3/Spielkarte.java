package jnk.laborpruefung.labor17.aufgabe3;

/**
 * Eine Spielkarte hat eine Farbe (Rot, Schwarz, Blau) und ein Symbol (Bube,
 * Dame, König).
 */
public class Spielkarte {

    /**
     * Mögliche Farben
     */
    enum Farbe {
        ROT, SCHWARZ, BLAU
    }

    /**
     * Mögliche Symbole.
     */
    enum Symbol {
        BUBE, DAME, KOENIG
    }

    /**
     * Farbe der Spielkarte
     */
    private Farbe farbe;

    /**
     * Symbol des Spielkarte.
     */
    private Symbol symbol;

    /**
     * Konstruktor zur Initialisierung von Farbe und Symbol.
     */
    public Spielkarte(Farbe farbe, Symbol symbol) {
        this.farbe = farbe;
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public Farbe getFarbe() {
        return farbe;
    }


}
