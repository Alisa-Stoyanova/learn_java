package jnk.laborpruefung.probe.aufgabe3;

/**
 * Mit der Werkstatt kann man Fahrzeug-Objekte generieren und Informationen aus einem Fahrzeug extrahieren.
 */
public class Werkstatt {

    /**
     * Die möglichen Typen von Fahrzeugen
     */
    public enum Typ {AUTO, MOTORRAD, BAGGER}

    /**
     * Erstellt ein Fahrzeug von dem übergebenen Typ.
     */
    public static Fahrzeug erstelleFahrzeug(Typ fahrzeugTyp) {
        if (fahrzeugTyp == Typ.AUTO) {
            return new Auto("", "", 0, 0);
        } else if (fahrzeugTyp == Typ.MOTORRAD) {
            return new Motorrad("", "", 0, false);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Liefert die Anzahl an Türen, wenn das übergebene Fahrzeug ein Auto ist. Wirft ansonsten eine
     * IllegalArgumentException.
     */
    public static int getAnzahlTueren(Fahrzeug fahrzeug) {
        if (fahrzeug instanceof Auto) {
            return ((Auto) fahrzeug).getAnzahlTueren();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Hier können Sie Ausprobieren.
     */
    public static void main(String[] args) {
    }
}
