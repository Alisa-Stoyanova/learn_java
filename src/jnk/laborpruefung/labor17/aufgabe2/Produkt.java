package jnk.laborpruefung.labor17.aufgabe2;

/**
 * Ein Produkt setzt sich aus einem Preis und einem Namen zusammen.
 */
public class Produkt {
    /**
     * Name des Produktes.
     */
    private String name;

    /**
     * Preis des Produktes.
     */
    private double preis;

    /**
     * Konstruktor zur Initialisierung von Namen und Preis.
     *
     * @param name
     * @param preis
     */
    public Produkt(String name, double preis) {
        this.name = name;
        this.preis = preis;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", name, preis);
    }

    public String getName() {
        return name;
    }

    public double getPreis() {
        return preis;
    }

}