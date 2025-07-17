package jnk.laborpruefung.probe.aufgabe2;

/**
 * Spielzeugautos können hintereinander gehängt werden. Dabei merkt sich jedes Spielzeugauto
 * jeweils das Spielzeugauto davor und das Spielzeugauto dahinter. Zusammen bilden die so
 * zusammengehängten Spielzeugautos eine Kette. Das erste Spielzeugauto hat kein
 * Spielzeugauto davor (null) und das letzte Spielzeugauto in der Kette hat kein
 * Spielzeugauto dahinter (null).
 */
public class Spielzeugauto {

    private Spielzeugauto davor;
    private Spielzeugauto dahinter;
    private final String name;

    public Spielzeugauto(String name) {
        davor = null;
        dahinter = null;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + (dahinter != null ? " <-> " + dahinter.toString() : " ->|");
    }

    public Spielzeugauto getDavor() {
        return davor;
    }

    public Spielzeugauto getDahinter() {
        return dahinter;
    }

    // +++++++++++++++++ Im Folgenden Ihre Lösung einbauen ++++++++++++++

    /**
     * Fügt ein Spielzeugauto ganz am Ende der Kette an.
     */
    public void amEndeAnhaengen(Spielzeugauto auto) {
        // dahinter = next, davor = prev
        if (dahinter == null) { // last Node
            dahinter = auto;
            auto.davor = this;
            return;
        }
        Spielzeugauto currentAuto = this;
        while (currentAuto.dahinter != null) {
            currentAuto = dahinter;
        }
        currentAuto.dahinter = auto;
        currentAuto.dahinter.davor = currentAuto;
    }

    /**
     * Fügt ein Spielzeugauto direkt hinter dem this-Holzauto an.
     */
    public void einfuegenDahinter(Spielzeugauto auto) {
        // dahinter = next, davor = prev
        if (dahinter != null) {
            dahinter.davor = auto;
            auto.dahinter = dahinter;
            dahinter = auto;
            auto.davor = this;
        } else {
            dahinter = auto;
            auto.davor = this;
        }
    }

    /**
     * Entfernt das this-Spielzeugauto aus der Kette.
     */
    public void entfernen() {
        // dahinter = next, davor = prev
        if (dahinter != null) {
            davor.dahinter = dahinter;
            dahinter.davor = davor;
            dahinter = null;
            davor = null;
        } else {
            davor.dahinter = null;
            davor = null;
        }
    }

    public static void main(String[] args) {
        Spielzeugauto fiat = new Spielzeugauto("fiat");
        Spielzeugauto mini = new Spielzeugauto("mini");
        System.out.println(fiat.dahinter);
        fiat.amEndeAnhaengen(mini);
        System.out.println(fiat.dahinter);
    }
}
