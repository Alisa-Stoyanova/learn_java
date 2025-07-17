package jnk.praktika.aufgabe6;

public class Brettspielsammlung {
    private Brettspiel[] sammlung = new Brettspiel[0];
    private int belegt;

    // TODO add IllegalArgumentException when called with null as argument --> Test
    public void hinzufuegen(Brettspiel brettspiel) {
        if (brettspiel == null) {
            throw new IllegalArgumentException();
        }
        if (sammlung.length == 0) {
            adjustLength();
        }
        if (belegt == sammlung.length) {
            verdoppeln();
        }
        sammlung[belegt] = brettspiel;
        belegt++;
    }

    public void entfernen(Brettspiel brettspiel) {
        for (int i = 0; i < sammlung.length; i++) {
            if (sammlung[i] == brettspiel) {
                sammlung[i] = null;
                belegt--;
                kopieren(i, belegt - i - 1); // end: belegt - 1
            }
        }
    }

    public void leeren() {
        sammlung = new Brettspiel[sammlung.length];
    }

    public void ausgeben() {
        for (Brettspiel spiel : sammlung) {
            if (spiel != null) {
                System.out.println(spiel.toString());
            } else {
                break;
            }
        }
    }

    public Brettspiel getBrettspielAtIndex(int idx) {
        if (idx >= sammlung.length) {
            throw new IllegalArgumentException("Ungültige Angabe.");
        }
        return sammlung[idx];
    }

    public int getAnzahlBrettspiele() {
        return belegt;
    }

    public int getIndexFuer(Brettspiel brettspiel) {
        if (brettspiel == null) {
            return -1;
        }
        for (int i = 0; i < sammlung.length; i++) {
            if (sammlung[i] == brettspiel) {
                return i;
            }
        }
        return -1;
    }

    private void adjustLength() {
        sammlung = new Brettspiel[1];
    }

    private void verdoppeln() {
        Brettspiel[] tmp = sammlung;
        sammlung = new Brettspiel[sammlung.length * 2];
        kopieren(tmp);
    }

    private void kopieren(Brettspiel[] tmp) {
        for (int i = 0; i < tmp.length; i++) {
            sammlung[i] = tmp[i];
        }
    }

    private void kopieren(int start, int anzahl) {
        for (int i = start; i <= anzahl; i++) {
            sammlung[i] = sammlung[i + 1];
        }
    }

    public int getLength() {
        return sammlung.length;
    }
}
