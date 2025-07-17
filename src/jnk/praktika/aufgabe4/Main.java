package jnk.praktika.aufgabe4;

public class Main {

    public static void main(String[] args) {
        Zug z = new Zug();
        System.out.println("Erster Wagen " + z.getErsterWagen());
        System.out.println("Erster Wagen " + (z.getErsterWagen() == null ? "\0" : z.getErsterWagen().getID()));
        System.out.println("Erster Wagen " + (z.getErsterWagen() == null ? null : z.getErsterWagen().getID()));

        Wagen w = new Wagen();
        z.anhaengenIter(w);
        System.out.println("Erster Wagen " + z.getErsterWagen().getID());

        Wagen v = new Wagen();
        z.anhaengenIter(v);
        System.out.println("Zweiter Wagen " + z.getErsterWagen().getNext().getID());

        Wagen u = new Wagen();
        z.anhaengenRec(u);
        System.out.println("Dritter Wagen " + z.getErsterWagen().getNext().getNext().getID());

        System.out.println(z.abhaengen(v));
        System.out.println(z.abhaengen(new Wagen()));
    }
}