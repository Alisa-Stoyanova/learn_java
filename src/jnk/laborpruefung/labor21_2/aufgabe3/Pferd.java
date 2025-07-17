package jnk.laborpruefung.labor21_2.aufgabe3;

/**
 * Ein Pferd in einem Gespann vor einer Kutsche. Diese Klasse müssen Sie gar nicht ändern.
 */
public class Pferd {

    /**
     * Diese Referenz zeigt auf das vor dem Pferd eingespannte Pferd.
     */
    private Pferd davorPferd;

    /**
     * Name des Pferdes
     */
    private final String name;

    public Pferd(String name) {
        this.name = name;
    }

    /**
     * Liefert das Pferd, das vor dem this-Pferd eingespannt ist.
     */
    public Pferd getDavorPferd() {
        return davorPferd;
    }

    /**
     * Setzt das Pferd, das vor dem this-Pferd eingespannt ist.
     */
    public void setDavorPferd(Pferd neuesDavorPferd) {
        davorPferd = neuesDavorPferd;
    }

    /**
     * Liefert den Namen des Pferdes.
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pferd " + getName();
    }
}
