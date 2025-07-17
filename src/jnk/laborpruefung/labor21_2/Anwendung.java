package jnk.laborpruefung.labor21_2;

import jnk.laborpruefung.labor21_2.aufgabe2.Lager;
import jnk.laborpruefung.labor21_2.aufgabe3.Kutsche;
import jnk.laborpruefung.labor21_2.aufgabe3.Pferd;

/**
 * In dieser Anwendung kann man mit den Klassen aus dem Wilden Westen experimentieren.
 * Auf diese Klasse beziehen sich keine Tests, Sie kann also beliebig verändert werden.
 */
public class Anwendung {

    public static void main(String[] args) {
        // Lager
        Lager lager = new Lager(10);

        // Gespann
        Kutsche kutsche = new Kutsche();
        Pferd jollyJumper = new Pferd("Jolly Jumper");
        Pferd fury = new Pferd("Fury");
    }
}
