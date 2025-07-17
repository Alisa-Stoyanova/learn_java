package jnk.praktika.aufgabe6;

public class Brettspiel {
    private final String titel;
    private final int[] spielerzahl; // eine minimale und eine maximale Anzahl (beispielsweise 1-4)
    private final int mindestalter;

    public Brettspiel(String titel, int[] spielerzahl, int mindestalter) {
        this.titel = titel;
        this.spielerzahl = spielerzahl;
        this.mindestalter = mindestalter;
    }

    public String getTitel() {
        return titel;
    }

    public int[] getSpielerzahl() {
        return spielerzahl;
    }

    public int getMindestalter() {
        return mindestalter;
    }

    public void ausgeben() { // TODO why not toString()?
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return String.format("%s (%d-%d Spieler:innen, ab %d Jahren)", titel, spielerzahl[0], spielerzahl[1], mindestalter);
    }
}
