package jnk.laborpruefung.midterm.aufgabe2;

public class Tupel {
    private int zahl;
    private char zeichen;

    public Tupel(int zahl, char zeichen) {
        this.zahl = zahl;
        this.zeichen = zeichen;
    }

    public Tupel(Tupel t) {
        this(t.zahl, t.zeichen);
    }

    public int getZahl() {
        return zahl;
    }

    public char getZeichen() {
        return zeichen;
    }

    public Tupel zusammen(Tupel t) {
        if (t == null) {
            return new Tupel(this);
        }
        int newZahl = this.zahl + t.zahl;
        char newZeichen;
        if (this.zeichen < t.zeichen) {
            newZeichen = this.zeichen;
        } else {
            newZeichen = t.zeichen;
        }
        Tupel newT = new Tupel(newZahl, newZeichen);
        return newT;
    }

    public void flip() {
        if (zahl < 0) {
            zahl = 0;
        }
        if (zahl > 127) {
            zahl = 127;
        }
        int tmp = zeichen;
        zeichen = (char) zahl;
        zahl = tmp;
    }

    public String toString() {
        return zahl + " " + zeichen;
    }
}