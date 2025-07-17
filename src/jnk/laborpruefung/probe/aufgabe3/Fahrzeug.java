package jnk.laborpruefung.probe.aufgabe3;

public abstract class Fahrzeug {
    /**
     * Marke des Fahrzeugs
     */
    protected String marke;

    /**
     * Modell des Fahrzeugs.
     */
    protected String modell;

    /**
     * Baujahr des Fahrzeugs.
     */
    protected int baujahr;

    public Fahrzeug(String marke, String modell, int baujahr) {
        this.marke = marke;
        this.modell = modell;
        this.baujahr = baujahr;
    }

    /**
     * Liefert alle Informationen aus Objektvariablen in einem String.
     */
    public abstract String getInfo();

    public String getMarke() {
        return marke;
    }

    public String getModell() {
        return modell;
    }

    public int getBaujahr() {
        return baujahr;
    }
}
