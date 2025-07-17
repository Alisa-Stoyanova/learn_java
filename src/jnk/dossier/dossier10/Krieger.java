package jnk.dossier.dossier10;

/**
 * Ein Krieger hat einen Namen und eine Anzahl von Lebenspunkten.
 * Fällt die Anzahl der Lebenspunkte auf 0, ist der Krieger bewusstlos.
 * Er hat je einen Wert für Angriff und Verteidigung aus [1; 20].
 * Beim Angriff würfelt man mit einem 20-seitigen Würfel.
 * Ist die Augenzahl kleiner oder gleich dem Angriffswert, dann ist der Angriff erfolgreich (analog bei der Verteidigung).
 */
public class Krieger {
    private final String name;
    private final int angriff;
    private final int verteidigung;
    private int lebenspunkte;

    /**
     * initialisiert den Krieger
     */
    public Krieger(String name, int angriff, int verteidigung, int lebenspunkte) {
        this.name = name;
        this.angriff = angriff;
        this.verteidigung = verteidigung;
        this.lebenspunkte = lebenspunkte;
    }

    public String getName() {
        return name;
    }

    /**
     * liefert true, wenn der Angriff mit dem gegebenen Wurf erfolgreich war
     * param zahl: die mit dem Würfel gewürfelte Zahl
     */
    private boolean angreifen(int zahl) {
        return zahl <= angriff;
    }

    /**
     * liefert true, wenn die Verteidigung mit dem gegebenen Wurf erfolgreich war
     * param zahl: die mit dem Würfel gewürfelte Zahl
     */
    private boolean verteidigen(int zahl) {
        return zahl <= verteidigung;
    }

    /**
     * liefert true, wenn die Anzahl der Lebenspunkte kleiner oder gleich 0 ist
     */
    public boolean istBewusstlos() {
        return lebenspunkte <= 0;
    }

    /**
     * Bei jedem erfolgreichen Angriff, falls Verteidigung scheitert, wird dem Gegner ein Lebenspunkt abgezogen
     */
    public void zugAusfuehren(Krieger gegner, Wuerfel wuerfel) {
        System.out.print("Vor dem Zug ");
        System.out.println(gegner);
        if (angreifen(wuerfel.wuerfeln())) {
            if (gegner.verteidigen(wuerfel.wuerfeln())) {
                gegner.lebenspunkte--;
            }
        }
        System.out.print("Nach dem Zug ");
        System.out.println(gegner + "\n");
    }

    public String toString() {
        return name + " hat " + lebenspunkte + " Lebenspunkte";
    }
}
