package jnk.dossier.dossier10;

public class Wuerfel {
    private final int anzahlAugen;

    public Wuerfel(int anzahlAugen) {
        this.anzahlAugen = anzahlAugen;
    }

    /**
     * Bei Angriff bzw. Verteidigung würfelt man mit einem 20-seitigen Würfel
     */
    public int wuerfeln() {
        return (int) (Math.random() * (anzahlAugen + 1));
    }
}
