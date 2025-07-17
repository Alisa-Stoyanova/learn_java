package jnk.laborpruefung.midterm.aufgabe1;

import jnk.laborpruefung.midterm.LaborpruefungException;
import jnk.laborpruefung.midterm.TestBasisklasse;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testklasse für die Klasse Kontrollstrukturen - Midterm PM1/PT SS21
 */
public class TestAufgabe1 extends TestBasisklasse {

    private static final String NAME_METHODE_SUMME_GERADER_ZAHLEN = "summeGeraderZahlen";
    private static final String NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE = "gleitkomma2Kleinbuchstabe";
    private static final String NAME_METHODE_RECHNER = "rechner";

    /**
     * Test für gleitkomma2Kleinbuchstabe()
     */
    @Test
    public void testGleitkomma2Kleinbuchstabe() throws LaborpruefungException {
        Kontrollstrukturen k = new Kontrollstrukturen();

        Class<?>[] paramListe = {double.class};
        assertTrue(hatMethode(k.getClass(), NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE, paramListe),
                "Kontrollstrukturen hat nicht die geforderte Methode " + NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE);
        assertTrue(methodeHatModifizierer(k.getClass(), NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE, paramListe, istPublic),
                "Methode " + NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE + " hat nicht die richtige Sichtbarkeit");
        assertEquals(char.class, getRueckgabeTyp(Kontrollstrukturen.class, NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE,
                paramListe), "Methode " + NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE +
                " hat nicht den richtigen Rückgabetyp");

        List<Double> testFaelleParam = Arrays.asList(-0.5, 25.4, 17.7, 0.4, 0.5);
        List<Character> erwartungswerte = Arrays.asList('a', 'z', 's', 'a', 'b');
        System.out.println("### Teste " + NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE + "()");
        for (int i = 0; i < testFaelleParam.size(); i++) {
            Object[] argListe = {testFaelleParam.get(i)};
            //System.out.println("Teste mit '" + testFaelleParam.get(i) + "'");
            char zeichen = (Character) methodeAufrufen(k, NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE, paramListe, argListe);
            assertEquals(erwartungswerte.get(i), zeichen, "Falsches Ergebnis für Testargument " +
                    testFaelleParam.get(i));
        }
    }

    /**
     * Test für summeGeraderZahlen()
     */
    @Test
    public void testSummeGeraderZahlen() throws LaborpruefungException {
        Kontrollstrukturen k = new Kontrollstrukturen();

        Class<?>[] paramListe = {int.class, int.class};
        assertTrue(hatMethode(k.getClass(), NAME_METHODE_SUMME_GERADER_ZAHLEN, paramListe),
                "Kontrollstrukturen hat nicht die geforderte Methode " + NAME_METHODE_SUMME_GERADER_ZAHLEN);
        assertTrue(methodeHatModifizierer(k.getClass(), NAME_METHODE_SUMME_GERADER_ZAHLEN, paramListe, istPublic),
                "Methode " + NAME_METHODE_SUMME_GERADER_ZAHLEN + " hat nicht die richtige Sichtbarkeit");
        assertEquals(int.class, getRueckgabeTyp(Kontrollstrukturen.class, NAME_METHODE_SUMME_GERADER_ZAHLEN,
                paramListe), "Methode " + NAME_METHODE_SUMME_GERADER_ZAHLEN +
                " hat nicht den richtigen Rückgabetyp");

        List<Integer> testFaelleParam1 = Arrays.asList(5, -4, 0, 3, 5, 6);
        List<Integer> testFaelleParam2 = Arrays.asList(10, 3, 0, -2, 5, 6);
        List<Integer> erwartungswerte = Arrays.asList(24, -4, 0, 0, 0, 6);
        System.out.println("### Teste " + NAME_METHODE_SUMME_GERADER_ZAHLEN + "()");
        for (int i = 0; i < testFaelleParam1.size(); i++) {
            Object[] argListe = {testFaelleParam1.get(i), testFaelleParam2.get(i)};
            //System.out.println("Teste mit '" + testFaelleParam1.get(i) + "' und '" + testFaelleParam2.get(i) + "'");
            int anzahl = (Integer) methodeAufrufen(k, NAME_METHODE_SUMME_GERADER_ZAHLEN, paramListe,
                    argListe);
            assertEquals(erwartungswerte.get(i), anzahl, "Falsches Ergebnis für Testargumente " +
                    testFaelleParam1.get(i) + " und " + testFaelleParam2.get(i));
        }
    }

    /**
     * Test für gleitkomma2Kleinbuchstabe()
     */
    @Test
    public void testGleitkomma2KleinbuchstabeWertebereich() throws LaborpruefungException {
        testSummeGeraderZahlen();

        Kontrollstrukturen k = new Kontrollstrukturen();

        Class<?>[] paramListe = {double.class};
        assertTrue(hatMethode(k.getClass(), NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE, paramListe),
                "Kontrollstrukturen hat nicht die geforderte Methode " + NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE);
        assertTrue(methodeHatModifizierer(k.getClass(), NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE, paramListe, istPublic),
                "Methode " + NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE + " hat nicht die richtige Sichtbarkeit");
        assertEquals(char.class, getRueckgabeTyp(Kontrollstrukturen.class, NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE,
                paramListe), "Methode " + NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE +
                " hat nicht den richtigen Rückgabetyp");

        List<Double> testFaelleParam = Arrays.asList(-0.51, 25.5);
        List<Character> erwartungswerte = Arrays.asList(null, null);
        System.out.println("### Teste " + NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE + "()");
        for (int i = 0; i < testFaelleParam.size(); i++) {
            Object[] argListe = {testFaelleParam.get(i)};
            try {
                methodeAufrufenExceptionErwartet(k, NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE,
                        paramListe, argListe);
                assertTrue(false, "Methode " + NAME_METHODE_GLEITKOMMA_2_KLEINBUCHSTABE + " wirft nicht " +
                        "die geforderte Exception");
            } catch (Throwable t) {
                assertEquals(IllegalArgumentException.class, t.getClass());
            }
        }
    }

    /**
     * Test für rechner()
     */
    @Test
    public void testRechner() throws LaborpruefungException {
        Kontrollstrukturen k = new Kontrollstrukturen();

        Class<?>[] paramListe = {char.class, int.class, int.class};
        assertTrue(hatMethode(k.getClass(), NAME_METHODE_RECHNER, paramListe),
                "Kontrollstrukturen hat nicht die geforderte Methode " + NAME_METHODE_RECHNER);
        assertTrue(methodeHatModifizierer(k.getClass(), NAME_METHODE_RECHNER, paramListe, istPublic),
                "Methode " + NAME_METHODE_RECHNER + " hat nicht die richtige Sichtbarkeit");
        assertEquals(int.class, getRueckgabeTyp(Kontrollstrukturen.class, NAME_METHODE_RECHNER,
                paramListe), "Methode " + NAME_METHODE_RECHNER +
                " hat nicht den richtigen Rückgabetyp");

        List<Character> testFaelleParam1 = Arrays.asList('+', '-', 'h', '+', '-', '*', 'Q');
        List<Integer> testFaelleParam2 = Arrays.asList(2, 5, 23, -3, 23, 34, 23);
        List<Integer> testFaelleParam3 = Arrays.asList(3, 1, 42, -4, 22, 3, 4);
        List<Integer> erwartungswerte = Arrays.asList(5, 4, 0, -7, 1, 0, 0);
        System.out.println("### Teste " + NAME_METHODE_RECHNER + "()");
        for (int i = 0; i < testFaelleParam1.size(); i++) {
            Object[] argListe = {testFaelleParam1.get(i), testFaelleParam2.get(i), testFaelleParam3.get(i)};
            int ergebnis = (Integer) methodeAufrufen(k, NAME_METHODE_RECHNER, paramListe, argListe);
            assertEquals(erwartungswerte.get(i), ergebnis, "Falsches Ergebnis für Testargumente " +
                    testFaelleParam1.get(i) + " " + testFaelleParam2.get(i) + " " + testFaelleParam3.get(i));
        }
    }
}
