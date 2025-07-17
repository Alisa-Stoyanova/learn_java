package jnk.laborpruefung.labor19.aufgabe3;

public class Addition implements Grundrechenart {
    @Override
    public int auswerten(int a, int b) {
        return a + b;
    }

    @Override
    public String getSymbol() {
        return "+";
    }
}
