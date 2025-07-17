package jnk.praktika.aufgabe4;

public class Wagen {
    private static int zaehler;
    private final String id;
    private Wagen next;

    public Wagen() {
        id = "" + zaehler; // id = String.valueOf(zaehler);
        zaehler++;
    }

    public String getID() {
        return id;
    }

    public Wagen getNext() {
        return next;
    }

    public void setNext(Wagen next) {
        this.next = next;
    }
}
