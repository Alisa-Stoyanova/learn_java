package jnk.laborpruefung.labor22.aufgabe2;

/**
 * Ein Behälter kann durch Inhalt belegt werden.
 */
public abstract class Behaelter {

    private String name;

    public Behaelter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Liefert das bereits durch Inhalt belegte Volumen.
     */
    public abstract int getBelegt();
}
