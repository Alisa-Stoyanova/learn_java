package jnk.laborpruefung.labor17.aufgabe3;

import java.util.ArrayList;
import java.util.List;

/**
 * Eine Hand im Kartenspiel verwaltet eine Liste von Spielkarten.
 */
public class Hand {

    /**
     * Liste der Spielkarten in der Hand.
     */
    private List<Spielkarte> karten = new ArrayList<Spielkarte>();

    /**
     * Konstruktor für die Initialisierung der Hand mit beliebig vielen
     * Spielkarten.
     */
    public Hand(Spielkarte... karten) {
        for (Spielkarte karte : karten) {
            this.karten.add(karte);
        }
    }


}