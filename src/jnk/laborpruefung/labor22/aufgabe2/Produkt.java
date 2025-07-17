package jnk.laborpruefung.labor22.aufgabe2;

/**
 * Ein Produkt hat einen Namen und belegt in einem Behälter ein Volumen.
 */
public interface Produkt {

    /**
     * Liefert den Namen des Produktes.
     */
    String getName();

    /**
     * Liefert das Volumen des Produktes in Litern.
     */
    int getVolumen();
}
