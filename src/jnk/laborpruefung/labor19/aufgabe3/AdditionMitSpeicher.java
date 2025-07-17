package jnk.laborpruefung.labor19.aufgabe3;

public class AdditionMitSpeicher extends Addition {
    private int speicher;

    @Override
    public int auswerten(int a, int b) {
        speicher++;
        return speicher + super.auswerten(a, b);
    }
}