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
        for (int i = 0; i < startIndex - 1; i++) {
            current = current.getDavorPferd();
        }
        int idx = 0;
        int lastIndex = startIndex + anzahl;
        while (startIndex < lastIndex) {
            out[idx] = current.getDavorPferd();
            Pferd tmp = current.getDavorPferd();
            current.setDavorPferd(null);
            current = tmp;
            startIndex++;
            idx++;
        }
        /*Pferd tmp = pferd;
        for (int i = 0; i < out.length; i++) {
            while (tmp != null) {
                if (tmp == out[i]) {
                    tmp.setDavorPferd(null);
                }
            }
        }*/
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

