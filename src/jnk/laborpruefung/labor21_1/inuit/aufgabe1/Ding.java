package jnk.laborpruefung.labor21_1.inuit.aufgabe1;

public abstract class Ding {
    private int groesse;

    protected Ding(int groesse) {
        this.groesse = groesse;
    }

    public int getGroesse() {
        return groesse;
    }
}
