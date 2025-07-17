package jnk.laborpruefung.probe.aufgabe2;

import jnk.laborpruefung.probe.TestBasisklasse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Testklasse für die Klasse Spielzeugauto.
 */
public class TestAufgabe2 extends TestBasisklasse {
    @Test
    public void testAmEndeAnhaengenDirekt() {
        // Direkt dahinter anhängen
        Spielzeugauto auto1 = new Spielzeugauto("auto1");
        Spielzeugauto auto2 = new Spielzeugauto("auto2");
        auto1.amEndeAnhaengen(auto2);

        // Auto 1
        assertNull(auto1.getDavor());
        assertEquals(auto2, auto1.getDahinter());
        // Auto 2
        assertEquals(auto1, auto2.getDavor());
        assertNull(auto2.getDahinter());
    }

    @Test
    public void testAmEndeAnhaengenUeberspringen() {
        // Direkt dahinter anhängen
        Spielzeugauto auto1 = new Spielzeugauto("auto1");
        Spielzeugauto auto2 = new Spielzeugauto("auto2");
        auto1.amEndeAnhaengen(auto2);

        // Auto überspringen
        Spielzeugauto auto3 = new Spielzeugauto("auto3");
        auto1.amEndeAnhaengen(auto3);

        // Auto 1
        assertNull(auto1.getDavor());
        assertEquals(auto2, auto1.getDahinter());
        // Auto 2
        assertEquals(auto1, auto2.getDavor());
        assertEquals(auto3, auto2.getDahinter());
        // Auto 3
        assertEquals(auto2, auto3.getDavor());
        assertNull(auto3.getDahinter());

        // Auto überspringen
        Spielzeugauto auto4 = new Spielzeugauto("auto4");
        auto2.amEndeAnhaengen(auto4);

        // Auto 1
        assertNull(auto1.getDavor());
        assertEquals(auto2, auto1.getDahinter());
        // Auto 2
        assertEquals(auto1, auto2.getDavor());
        assertEquals(auto3, auto2.getDahinter());
        // Auto 3
        assertEquals(auto2, auto3.getDavor());
        assertEquals(auto4, auto3.getDahinter());
        // Auto 4
        assertEquals(auto3, auto4.getDavor());
        assertNull(auto4.getDahinter());
    }

    @Test
    public void einfuegenDahinterVorherNix() {
        // Vorher kein Auto dahinter
        Spielzeugauto auto1 = new Spielzeugauto("auto1");
        Spielzeugauto auto2 = new Spielzeugauto("auto2");
        auto1.einfuegenDahinter(auto2);

        // Auto 1
        assertNull(auto1.getDavor());
        assertEquals(auto2, auto1.getDahinter());
        // Auto 2
        assertEquals(auto1, auto2.getDavor());
        assertNull(auto2.getDahinter());

        Spielzeugauto auto3 = new Spielzeugauto("auto3");
        auto2.einfuegenDahinter(auto3);

        // Auto 1
        assertNull(auto1.getDavor());
        assertEquals(auto2, auto1.getDahinter());
        // Auto 2
        assertEquals(auto1, auto2.getDavor());
        assertEquals(auto3, auto2.getDahinter());
        // Auto 3
        assertEquals(auto2, auto3.getDavor());
        assertNull(auto3.getDahinter());
    }

    @Test
    public void einfuegenDahinterVorherBelegt() {
        Spielzeugauto auto1 = new Spielzeugauto("auto1");
        Spielzeugauto auto2 = new Spielzeugauto("auto2");
        auto1.einfuegenDahinter(auto2);

        Spielzeugauto auto3 = new Spielzeugauto("auto3");
        auto1.einfuegenDahinter(auto3);
        // Auto 1
        assertNull(auto1.getDavor());
        assertEquals(auto3, auto1.getDahinter());
        // Auto 2
        assertEquals(auto1, auto3.getDavor());
        assertEquals(auto2, auto3.getDahinter());
        // Auto 3
        assertEquals(auto3, auto2.getDavor());
        assertNull(auto2.getDahinter());

        Spielzeugauto auto4 = new Spielzeugauto("auto4");
        auto3.einfuegenDahinter(auto4);
        // Auto 1
        assertNull(auto1.getDavor());
        assertEquals(auto3, auto1.getDahinter());
        // Auto 3
        assertEquals(auto1, auto3.getDavor());
        assertEquals(auto4, auto3.getDahinter());
        // Auto 4
        assertEquals(auto3, auto4.getDavor());
        assertEquals(auto2, auto4.getDahinter());
        // Auto 2
        assertEquals(auto4, auto2.getDavor());
        assertNull(auto2.getDahinter());
    }

    @Test
    public void entfernenAmEnde() {
        Spielzeugauto auto1 = new Spielzeugauto("auto1");
        Spielzeugauto auto2 = new Spielzeugauto("auto2");
        auto1.amEndeAnhaengen(auto2);

        // Auto 1
        assertNull(auto1.getDavor());
        assertEquals(auto2, auto1.getDahinter());
        // Auto 2
        assertEquals(auto1, auto2.getDavor());
        assertNull(auto2.getDahinter());

        auto2.entfernen();
        // Auto 1
        assertNull(auto1.getDavor());
        assertNull(auto1.getDahinter());
        // Auto 2
        assertNull(auto2.getDavor());
        assertNull(auto2.getDahinter());
    }

    @Test
    public void entfernenInDerMitte() {
        Spielzeugauto auto1 = new Spielzeugauto("auto1");
        Spielzeugauto auto2 = new Spielzeugauto("auto2");
        Spielzeugauto auto3 = new Spielzeugauto("auto2");
        auto1.amEndeAnhaengen(auto2);
        auto2.amEndeAnhaengen(auto3);

        auto2.entfernen();
        // Auto 1
        assertNull(auto1.getDavor());
        assertNull(auto3.getDahinter());
        // Auto 2
        assertNull(auto2.getDavor());
        assertNull(auto2.getDahinter());
        // Auto 3
        assertEquals(auto1, auto3.getDavor());
        assertNull(auto3.getDahinter());
    }
}
