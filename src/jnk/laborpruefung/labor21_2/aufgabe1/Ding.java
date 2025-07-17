package jnk.laborpruefung.labor21_2.aufgabe1;

/**
 * Gemeinsame Basisklasse für alle Dinge im Wilden Westen. Jedes Ding hat eine
 * ganzzahlige Größe.
 */
public abstract class Ding {

    /**
     * Die Größe des Dings in Grundfläche-Einheiten.
     */
    protected final int groesse;

    public Ding(int groesse) {
        if (groesse < 1 || groesse > 10) {
            throw new IllegalArgumentException("Größe muss aus [1,10] sein.");
        }
        this.groesse = groesse;
    }

    /**
     * Liefert die Größe des Dings in Grundfläche-Einheiten.
     */
    public int getGroesse() {
        return groesse;
    }
}
