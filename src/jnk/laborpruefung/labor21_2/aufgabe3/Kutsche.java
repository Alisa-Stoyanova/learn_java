package jnk.laborpruefung.labor21_2.aufgabe3;

/**
 * Vor einer Kutsche können mehrere Pferde in einer Reihe eingespannt sein.
 */
public class Kutsche {

    /**
     * Dies ist das Pferd direkt vor der Kutsche.
     */
    private Pferd pferd;

    /// +++ Hier eigenen Code einfügen
    public int getAnzahlPferde() {
        int anzahl = 0;
        if (pferd == null) {
            return anzahl;
        }
        Pferd current = pferd;
        while (current != null) {
            anzahl++;
            current = current.getDavorPferd();
        }
        return anzahl;
    }

    public void einspannen(Pferd neuesPferd) {
        if (neuesPferd == null || neuesPferd.getDavorPferd() != null) {
            throw new IllegalArgumentException();
        }
        if (pferd == null) {
            pferd = neuesPferd;
            pferd.setDavorPferd(null);
        } else {
            Pferd current = pferd;
            while (current.getDavorPferd() != null) {
                current = current.getDavorPferd();
            }
            current.setDavorPferd(neuesPferd);
            neuesPferd.setDavorPferd(null);
        }
    }

    public Pferd[] ausspannen(int startIndex, int anzahl) {
        if (anzahl < 0 || startIndex < 0 || getAnzahlPferde() < startIndex + anzahl) {
            return null;
        }

        Pferd[] out = new Pferd[anzahl];
        Pferd current = pferd;
        Pferd prev = current;
        for (int i = 0; i < startIndex; i++) {
            prev = current;
            current = current.getDavorPferd();
        }

        Pferd remaining = prev;
        for(int i = 0; i < anzahl; i++) {
            Pferd removed = current;
            Pferd next = removed.getDavorPferd();

            out[i] = removed;
            removed.setDavorPferd(null);
            current = next;
        }

        if (startIndex == 0) {
            pferd = current;
        } else {
            remaining.setDavorPferd(current);
        }

        return out;
    }

/*    public Pferd[] ausspannen(int startIndex, int anzahl) {
        if (getAnzahlPferde() < anzahl) {
            return null;
        }
        if (anzahl < 0) {
            return null;
        }
        Pferd[] out = new Pferd[anzahl];
        Pferd current = pferd;
        for (int i = 0; i < startIndex; i++) {
            current = current.getDavorPferd();
        }
        while (startIndex < anzahl) {
            out[startIndex] = current;
            current = current.getDavorPferd();
            startIndex++;
        }
        return out;
    }*/
}

