package jnk.laborpruefung.labor19.aufgabe4;

public class Perle {
    private Perle nachfolgerin;
/*    private String name;

    public Perle(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Perle{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Perle p1 = new Perle("p1");
        Perle p2 = new Perle("p2");
        Perle p3 = new Perle("p3");
        p1.setNachfolgerin(p2);
        p2.setNachfolgerin(p3);
        p3.setNachfolgerin(p1);
        System.out.println(p1.entfernen(1));
        System.out.println(p1.nachfolgerin);
    }*/

    public void setNachfolgerin(Perle nachfolgerin) {
        this.nachfolgerin = nachfolgerin;
    }

    public void einfuegen(int index, Perle perle) {
        Perle current = findAtIndex(index);
        perle.setNachfolgerin(current.nachfolgerin);
        current.setNachfolgerin(perle);
    }

    public Perle entfernen(int index) {
        Perle current = findAtIndex(index);
        Perle entferntePerle = current.nachfolgerin;
        current.setNachfolgerin(entferntePerle.nachfolgerin);
        entferntePerle.setNachfolgerin(null);
        return entferntePerle;
    }

    private Perle findAtIndex(int index) {
        Perle current = this;
        for (int i = 0; i < index; i++) {
            current = current.nachfolgerin;
        }
        return current;
    }
}