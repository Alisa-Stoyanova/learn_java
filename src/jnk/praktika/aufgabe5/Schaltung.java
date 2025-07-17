package jnk.praktika.aufgabe5;

public class Schaltung {

    public static void main(String[] args) {
        Eingang e1 = new Eingang(false);
        Eingang e2 = new Eingang(true);
        Eingang e3 = new Eingang(true);

        Und und = new Und(e1, e2);
        Oder oder = new Oder(e3, und);
        Nicht nicht = new Nicht(oder);

        System.out.println(nicht);
        System.out.println(nicht.getOutput());

        System.out.println(oder);
        System.out.println(oder.getOutput());

        System.out.println(und);
        System.out.println(und.getOutput());

        System.out.println(e1);
    }
}
