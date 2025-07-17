package jnk.laborpruefung.labor17.aufgabe2;

import java.util.ArrayList;
import java.util.List;

/**
 * Ein Warenkorb verwaltet eine Liste von Produkten.
 */
public class Warenkorb {

    /**
     * Liste der Produkte im Warenkorb.
     */
    private List<Produkt> produkte = new ArrayList<Produkt>();

    /**
     * Einfügen eines neuen Produktes am Ende der Produkt-Liste.
     */
    public void einfuegen(Produkt produkt) {
        produkte.add(produkt);
    }
}