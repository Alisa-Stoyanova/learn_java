package jnk.laborpruefung.probe.aufgabe1;

import jnk.laborpruefung.probe.TestBasisklasse;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse für die Klasse Imperativ.
 */
public class TestAufgabe1 extends TestBasisklasse {

    /**
     * Testmethode für Aufgabe 1.1
     */
    @Test
    public void testKleinBuchstabenstringAusArray() {
        Imperativ imperativ = new Imperativ();
        List<char[]> input = Arrays.asList(
                new char[]{' ', 'a', ',', 'B', 'b'},
                new char[]{},
                new char[]{'a', 'a', 'a', 'a', 'a'},
                new char[]{'/', 'G', 'R', '§'});
        List<String> expected = Arrays.asList("ab", "", "aaaaa", "");
        for (int i = 0; i < input.size(); i++) {
            String ist = imperativ.kleinbuchstabenstringAusArray(input.get(i));
            assertEquals(expected.get(i), ist, "Rückgabe entspricht nicht der Erwartung.");
        }
    }

    /**
     * Testmethode für Aufgabe 1.2 (Umdrehen)
     */
    @Test
    public void testStringVerarbeitenUmdrehen() {
        Imperativ imperativ = new Imperativ();

        // Umdrehen
        List<String> input = Arrays.asList("Ilona", "abcde", "", "(%§%");
        List<String> expected = Arrays.asList("anolI", "edcba", "", "%§%(");
        for (int i = 0; i < input.size(); i++) {
            String ist = imperativ.stringVerarbeiten(Vorgaben.StringOperation.UMDREHEN, input.get(i));
            assertEquals(expected.get(i), ist, "Fehler bei der Umdrehen-Operation.");
        }
    }

    /**
     * Testmethode für Aufgabe 1.2 (ohne E)
     */
    @Test
    public void testStringVerarbeitenOhneE() {
        Imperativ imperativ = new Imperativ();

        List<String> input = Arrays.asList("Eec,E%E", "", "dnasjdbkjas", "EEEE");
        List<String> expected = Arrays.asList("ec,%", "", "dnasjdbkjas", "");
        for (int i = 0; i < input.size(); i++) {
            String ist = imperativ.stringVerarbeiten(Vorgaben.StringOperation.OHNE_E, input.get(i));
            assertEquals(expected.get(i), ist, "Fehler bei der Ohne-E-Operation.");
        }
    }

    /**
     * Testmethode für Aufgabe 1.2 (ohne E)
     */
    @Test
    public void testStringVerarbeitenIstLang() {
        Imperativ imperativ = new Imperativ();

        List<String> input = Arrays.asList(
                "Ilona",
                "012345678910",
                "",
                "dw8ehd owidasdi asoid  nase",
                "            ");
        List<String> expected = Arrays.asList("KURZ", "LANG", "KURZ", "LANG", "LANG");
        for (int i = 0; i < input.size(); i++) {
            String ist = imperativ.stringVerarbeiten(Vorgaben.StringOperation.IST_LANG, input.get(i));
            assertEquals(expected.get(i), ist, "Fehler bei der Ist-Lang-Operation.");
        }
    }

    @Test
    public void testSumme() {
        Imperativ imperativ = new Imperativ();
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 1, 1),
                Arrays.asList(100, 32, 12)
        );
        List<Integer> expected = Arrays.asList(6, 3, 144);
        Vorgaben.resetNumCalls();
        for (int i = 0; i < input.size(); i++) {
            int ist = imperativ.summe(input.get(i).get(0), input.get(i).get(1), input.get(i).get(2));
            assertEquals(expected.get(i), ist, "Fehler bei Berechnung der Summe.");
            assertTrue(Vorgaben.getNumCalls() > 0, "Methode Vorgaben.positiveSumme() wurde nicht verwendet.");
        }
    }

    @Test
    public void testSummeException() {
        Imperativ imperativ = new Imperativ();
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1, 2, -1),
                Arrays.asList(1, -1, 1),
                Arrays.asList(-1, 32, 12)
        );
        List<Integer> expected = Arrays.asList(-1, -1, -1);
        for (int i = 0; i < input.size(); i++) {
            int ist = imperativ.summe(input.get(i).get(0), input.get(i).get(1), input.get(i).get(2));
            assertEquals(expected.get(i), ist, "Fehler bei Berechnung der Summe (Exception-Fall).");
            assertTrue(Vorgaben.getNumCalls() > 0, "Methode Vorgaben.positiveSumme() wurde nicht verwendet.");
        }
    }

    @Test
    public void testSummeGroesserWert() {
        Imperativ imperativ = new Imperativ();

        // Ohne Exception
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(4, 2, 3),
                Arrays.asList(4, 2, 10),
                Arrays.asList(1, 2, 3)
        );
        List<Boolean> expected = Arrays.asList(true, false, false);
        for (int i = 0; i < input.size(); i++) {
            try {
                boolean ist = imperativ.summeGroesserWert(input.get(i).get(0), input.get(i).get(1), input.get(i).get(2));
                assertEquals(expected.get(i), ist, "Fehler beim Summe-Wert-Vergleich.");
                assertTrue(Vorgaben.getNumCalls() > 0, "Methode Vorgaben.positiveSumme() wurde nicht verwendet.");
            } catch (Exception e) {
                fail("Hier sollte keine Negativ-Exception auftreten.");
            }
        }

        // Mit Exception
        input = Arrays.asList(
                Arrays.asList(4, -4, 3),
                Arrays.asList(-1, 2, 10),
                Arrays.asList(-4, -1, 3)
        );
        for (int i = 0; i < input.size(); i++) {
            final int arg1 = input.get(i).get(0);
            final int arg2 = input.get(i).get(1);
            final int arg3 = input.get(i).get(2);
            assertThrows(NegativException.class, () -> {
                        imperativ.summeGroesserWert(arg1, arg2, arg3);
                    },
                    "NegativException erwartet.");
            assertTrue(Vorgaben.getNumCalls() > 0, "Methode Vorgaben.positiveSumme() wurde nicht verwendet.");
        }
    }

    /*
    @Test
    public void testEinfuegen() {
        Imperativ imperativ = new Imperativ();

        List<int[]> input1 = Arrays.asList(
                new int[]{1, 2, 4},
                new int[]{-10, 0, 100});
        List<Integer> input2 = Arrays.asList(
                3,
                -9);
        List<int[]> expected = Arrays.asList(
                new int[]{1, 2, 3, 4},
                new int[]{-10, -9, 0, 100});
        for (int i = 0; i < input1.size(); i++) {
            int[] ist = imperativ.einfuegen(input1.get(i), input2.get(i));
            assertNotNull(ist, "Rückgabe sollte nicht null sein.");
            assertEquals(expected.get(i).length, ist.length, "Länge des Rückgabe-Arrays stimmt nicht.");
            for (int j = 0; j < expected.get(i).length; j++) {
                assertEquals(expected.get(i)[j], ist[j], "Falscher Elementwert im Array.");
            }
        }
    }

    @Test
    public void testEinfuegenLeer() {
        Imperativ imperativ = new Imperativ();

        List<int[]> input1 = Arrays.asList(
                new int[]{});
        List<Integer> input2 = Arrays.asList(
                3);
        List<int[]> expected = Arrays.asList(
                new int[]{3});
        for (int i = 0; i < input1.size(); i++) {
            int[] ist = imperativ.einfuegen(input1.get(i), input2.get(i));
            assertNotNull(ist, "Rückgabe sollte nicht null sein.");
            assertEquals(expected.get(i).length, ist.length, "Länge des Rückgabe-Arrays stimmt nicht.");
            for (int j = 0; j < expected.get(i).length; j++) {
                assertEquals(expected.get(i)[j], ist[j], "Falscher Elementwert im Array.");
            }
        }
    }

    @Test
    public void testEinfuegenNull() {
        Imperativ imperativ = new Imperativ();

        List<int[]> input1 = new ArrayList();
        input1.add(null);
        List<Integer> input2 = Arrays.asList(
                3);
        List<int[]> expected = Arrays.asList(
                new int[]{3});
        for (int i = 0; i < input1.size(); i++) {
            int[] ist = imperativ.einfuegen(input1.get(i), input2.get(i));
            assertNotNull(ist, "Rückgabe sollte nicht null sein.");
            assertEquals(expected.get(i).length, ist.length, "Länge des Rückgabe-Arrays stimmt nicht.");
            for (int j = 0; j < expected.get(i).length; j++) {
                assertEquals(expected.get(i)[j], ist[j], "Falscher Elementwert im Array.");
            }
        }
    }
    */
}
