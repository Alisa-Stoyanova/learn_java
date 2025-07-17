package jnk.laborpruefung.labor19.aufgabe2;

import jnk.laborpruefung.labor19.base.TestBasisklasse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;


public class TestAlgorithmen extends TestBasisklasse {

    public static final String PACKAGE_NAME = "jnk.laborpruefung.labor19.aufgabe2";
    public static final String KLASSE_BEZEICHNER_ALGORITHMEN = "Algorithmen";
    public static final String METHODE_BEZEICHNER_ZEICHEN_ZAEHLEN = "zeichenZaehlen";
    public static final String METHODE_BEZEICHNER_SORTIEREN = "sortieren";
    public static final String METHODE_BEZEICHNER_TEXT_FINDEN = "textFinden";

    /**
     * Liefert das class-Objekt zu Algorithmen.
     */
    public Class<?> getKlasseAlgorithmen() {
        Class<?> klasseAlgorithmen;
        try {
            klasseAlgorithmen = Class
                    .forName(PACKAGE_NAME + "." + KLASSE_BEZEICHNER_ALGORITHMEN);
            return klasseAlgorithmen;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    @Test
    public void testZeichenZaehlen() {
        // Debugging
        System.out.println(
                "Teste Methode " + METHODE_BEZEICHNER_ZEICHEN_ZAEHLEN + " ...");

        // Klasse
        Class<?> klasseAlgorithmen = getKlasseAlgorithmen();
        Object algorithmenInstanz = erzeugeInstanz(klasseAlgorithmen);
        assertNotNull(
                "Klasse " + KLASSE_BEZEICHNER_ALGORITHMEN + " nicht gefunden.");
        Class<?>[] parameterTypListe = new Class<?>[]{char.class, String.class};
        assertTrue(
                "Klasse " + KLASSE_BEZEICHNER_ALGORITHMEN + " hat nicht die Methode "
                        + METHODE_BEZEICHNER_ZEICHEN_ZAEHLEN,
                hatMethode(klasseAlgorithmen, METHODE_BEZEICHNER_ZEICHEN_ZAEHLEN,
                        parameterTypListe));
        assertEquals(
                "Methode " + METHODE_BEZEICHNER_ZEICHEN_ZAEHLEN
                        + " hat nicht den Rückgabetyp int",
                int.class, getRueckgabeTyp(klasseAlgorithmen,
                        METHODE_BEZEICHNER_ZEICHEN_ZAEHLEN, parameterTypListe));

        List<Object[]> params = new ArrayList<>();
        List<Integer> erwartungswerte = new ArrayList<>();

        // Testfall 1
        params.add(new Object[]{'l', "Hallo Welt"});
        erwartungswerte.add(3);

        // Testfall 2
        params.add(new Object[]{'z', "Hallo Welt"});
        erwartungswerte.add(0);

        // Testfall 3
        params.add(new Object[]{'z', ""});
        erwartungswerte.add(0);

        // Testfall 4
        params.add(new Object[]{'a', "aaaaaaa"});
        erwartungswerte.add(7);

        for (int i = 0; i < params.size(); i++) {

            Object[] param = params.get(i);
            int erwartungswert = erwartungswerte.get(i);

            Object wert = (int) werteMethodeAus(algorithmenInstanz,
                    METHODE_BEZEICHNER_ZEICHEN_ZAEHLEN, parameterTypListe, param);
            assertEquals("Methode " + METHODE_BEZEICHNER_ZEICHEN_ZAEHLEN
                    + " liefert nicht den richtigen Wert.", erwartungswert, wert);

            // Debugging
            System.out.println("  " + param[0] + ", " + param[1] + " -> " + wert + "/"
                    + erwartungswert);

        }
    }

    /**
     * Zählt die Vorkommen von element in elemente
     */
    private int getAnzahlVorkommen(String element, String[] elemente) {
        int anzahl = 0;
        for (String text : elemente) {
            if (text.equals(element)) {
                anzahl++;
            }
        }
        return anzahl;
    }

    @Test
    public void testSortierenPivotElementeAmAnfang() {
        // Debugging
        System.out
                .println("Teste Methode " + METHODE_BEZEICHNER_SORTIEREN + " ...");

        // Klasse
        Class<?> klasseAlgorithmen = getKlasseAlgorithmen();
        Object algorithmenInstanz = erzeugeInstanz(klasseAlgorithmen);
        assertNotNull(
                "Klasse " + KLASSE_BEZEICHNER_ALGORITHMEN + " nicht gefunden.");
        Class<?>[] parameterTypListe = new Class<?>[]{String.class,
                String[].class};
        assertTrue(
                "Klasse " + KLASSE_BEZEICHNER_ALGORITHMEN + " hat nicht die Methode "
                        + METHODE_BEZEICHNER_SORTIEREN,
                hatMethode(klasseAlgorithmen, METHODE_BEZEICHNER_SORTIEREN,
                        parameterTypListe));
        assertEquals(
                "Methode " + METHODE_BEZEICHNER_SORTIEREN
                        + " hat nicht den Rückgabetyp void",
                void.class, getRueckgabeTyp(klasseAlgorithmen,
                        METHODE_BEZEICHNER_SORTIEREN, parameterTypListe));

        List<Object[]> params = new ArrayList<>();

        // Testfall 1
        params.add(new Object[]{"Zwei",
                new String[]{"Eins", "Zwei", "Drei", "Zwei", "Eins"}});

        // Testfall 2
        params.add(new Object[]{"Zwei",
                new String[]{"Eins", "Sieben", "Drei", "Elf", "Eins"}});

        // Testfall 3
        params.add(new Object[]{"Zwei", new String[]{}});

        // Testfall 4
        params.add(new Object[]{null,
                new String[]{"Eins", "Sieben", "Drei", "Elf", "Eins"}});

        // Testfall 5
        params.add(new Object[]{"Zwei",
                new String[]{"Zwei", "Zwei", "Zwei", "Zwei", "Zwei"}});

        for (int i = 0; i < params.size(); i++) {

            Object[] param = params.get(i);

            // Kopie erstellen
            String[] elemente = (String[]) param[1];
            String[] elementeKopie = new String[elemente.length];
            System.arraycopy(elemente, 0, elementeKopie, 0, elemente.length);
            String pivotElement = (String) param[0];

            // Sortieren
            werteMethodeAus(algorithmenInstanz, METHODE_BEZEICHNER_SORTIEREN,
                    parameterTypListe, param);

            // Pivot-Elemente am Anfang
            int anzahlVorkommenElement = getAnzahlVorkommen(pivotElement,
                    elementeKopie);
            for (int j = 0; j < anzahlVorkommenElement; j++) {
                assertEquals(
                        "Pivot-Element-Vorkommen wurden nicht an den Anfang sortiert",
                        pivotElement, elemente[j]);
            }
        }

        System.out.println("  " + params.size() + " Testfälle erfolgreich.");
    }

    @Test
    public void testSortierenAlleElementeVorhanden() {
        // Debugging
        System.out
                .println("Teste Methode " + METHODE_BEZEICHNER_SORTIEREN + " ...");

        // Klasse
        Class<?> klasseAlgorithmen = getKlasseAlgorithmen();
        Object algorithmenInstanz = erzeugeInstanz(klasseAlgorithmen);
        assertNotNull(
                "Klasse " + KLASSE_BEZEICHNER_ALGORITHMEN + " nicht gefunden.");
        Class<?>[] parameterTypListe = new Class<?>[]{String.class,
                String[].class};
        assertTrue(
                "Klasse " + KLASSE_BEZEICHNER_ALGORITHMEN + " hat nicht die Methode "
                        + METHODE_BEZEICHNER_SORTIEREN,
                hatMethode(klasseAlgorithmen, METHODE_BEZEICHNER_SORTIEREN,
                        parameterTypListe));
        assertEquals(
                "Methode " + METHODE_BEZEICHNER_SORTIEREN
                        + " hat nicht den Rückgabetyp void",
                void.class, getRueckgabeTyp(klasseAlgorithmen,
                        METHODE_BEZEICHNER_SORTIEREN, parameterTypListe));

        List<Object[]> params = new ArrayList<>();

        // Testfall 1
        params.add(new Object[]{"Zwei",
                new String[]{"Eins", "Zwei", "Drei", "Zwei", "Eins"}});

        // Testfall 2
        params.add(new Object[]{"Zwei",
                new String[]{"Eins", "Sieben", "Drei", "Elf", "Eins"}});

        // Testfall 3
        params.add(new Object[]{"Zwei", new String[]{}});

        // Testfall 4
        params.add(new Object[]{null,
                new String[]{"Eins", "Sieben", "Drei", "Elf", "Eins"}});

        // Testfall 5
        params.add(new Object[]{"Zwei",
                new String[]{"Zwei", "Zwei", "Zwei", "Zwei", "Zwei"}});

        for (int i = 0; i < params.size(); i++) {

            Object[] param = params.get(i);

            // Kopie erstellen
            String[] elemente = (String[]) param[1];
            String[] elementeKopie = new String[elemente.length];
            System.arraycopy(elemente, 0, elementeKopie, 0, elemente.length);

            // Sortieren
            werteMethodeAus(algorithmenInstanz, METHODE_BEZEICHNER_SORTIEREN,
                    parameterTypListe, param);

            // Alle Ursprungselemente vorhanden
            for (int j = 0; j < elemente.length; j++) {
                assertEquals(
                        "Anzahl der Vorkommen eines Elements nach dem Sortieren stimmt nicht.",
                        getAnzahlVorkommen(elementeKopie[j], elementeKopie),
                        getAnzahlVorkommen(elementeKopie[j], elemente));
            }
        }

        System.out.println("  " + params.size() + " Testfälle erfolgreich.");
    }

    @Test
    public void testTextFinden() {
        // Debugging
        System.out
                .println("Teste Methode " + METHODE_BEZEICHNER_TEXT_FINDEN + " ...");

        // Klasse
        Class<?> klasseAlgorithmen = getKlasseAlgorithmen();
        Object algorithmenInstanz = erzeugeInstanz(klasseAlgorithmen);
        assertNotNull(
                "Klasse " + KLASSE_BEZEICHNER_ALGORITHMEN + " nicht gefunden.");
        Class<?>[] parameterTypListe = new Class<?>[]{String.class,
                char[].class};
        assertTrue(
                "Klasse " + KLASSE_BEZEICHNER_ALGORITHMEN + " hat nicht die Methode "
                        + METHODE_BEZEICHNER_TEXT_FINDEN,
                hatMethode(klasseAlgorithmen, METHODE_BEZEICHNER_TEXT_FINDEN,
                        parameterTypListe));
        assertEquals(
                "Methode " + METHODE_BEZEICHNER_TEXT_FINDEN
                        + " hat nicht den Rückgabetyp boolean",
                boolean.class, getRueckgabeTyp(klasseAlgorithmen,
                        METHODE_BEZEICHNER_TEXT_FINDEN, parameterTypListe));

        List<Object[]> params = new ArrayList<>();
        List<Boolean> erwartungswerte = new ArrayList<>();

        // Testfall 1
        params.add(new Object[]{"Mike", new char[]{'M', 'i', 'k', 'e', 'e'}});
        erwartungswerte.add(true);

        // Testfall 2
        params.add(new Object[]{"Mike", new char[]{'M', 'e', 'k', 'e', 'e'}});
        erwartungswerte.add(false);

        // Testfall 3
        params.add(new Object[]{"Mike", new char[]{'M', 'e', 'k',}});
        erwartungswerte.add(false);

        // Testfall 4
        params.add(new Object[]{"g", new char[]{'g', 'h', 'i',}});
        erwartungswerte.add(true);

        // Testfall 5
        params.add(new Object[]{"ab", new char[]{'g', 'a', 'b',}});
        erwartungswerte.add(true);

        for (int i = 0; i < params.size(); i++) {
            Object[] param = params.get(i);
            boolean erwartungswert = erwartungswerte.get(i);

            boolean ergebnis = (boolean) werteMethodeAus(algorithmenInstanz,
                    METHODE_BEZEICHNER_TEXT_FINDEN, parameterTypListe, param);

            System.out.print("Testfall " + (i + 1) + " ...");

            assertEquals("Methode " + METHODE_BEZEICHNER_TEXT_FINDEN
                    + " liefert falschen Wert.", erwartungswert, ergebnis);

            System.out.println(" erfolgreich");
        }
        System.out.println("  " + params.size() + " Testfälle erfolgreich.");

    }
}
