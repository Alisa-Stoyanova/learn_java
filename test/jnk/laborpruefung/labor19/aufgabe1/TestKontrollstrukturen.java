package jnk.laborpruefung.labor19.aufgabe1;

import jnk.laborpruefung.labor19.base.TestBasisklasse;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.*;


/**
 * Testklasse für Kontrollstrukturen
 *
 * @author Philipp Jenke
 */
public class TestKontrollstrukturen extends TestBasisklasse {

    public static final String PACKAGE_NAME = "jnk.laborpruefung.labor19.aufgabe1";
    public static final String KLASSE_BEZEICHNER_KONTROLLSTRUKTUREN = "Kontrollstrukturen";
    public static final String METHODE_BEZEICHNER_HARMONISCHE_REIHE = "harmonischeReihe";
    public static final String ENUM_BEZEICHNER_FARBE = "Farbe";
    public static final String ENUM_BEZEICHNER_FARBE_ROT = "ROT";
    public static final String ENUM_BEZEICHNER_FARBE_GRUEN = "GRUEN";
    public static final String ENUM_BEZEICHNER_FARBE_BLAU = "BLAU";
    public static final String METHODE_BEZEICHNER_FARBE_2_STRING = "farbe2String";
    public static final String METHODE_BEZEICHNER_KAPAZITAET_VERDOPPELN = "kapazitaetVerdoppeln";

    /**
     * Liefert das class-Objekt zu Kontrollstrukturen.
     */
    public Class<?> getKlasseKontrollstrukturen() {
        Class<?> klasseKontrollstrukturen;
        try {
            klasseKontrollstrukturen = Class
                    .forName(PACKAGE_NAME + "." + KLASSE_BEZEICHNER_KONTROLLSTRUKTUREN);
            return klasseKontrollstrukturen;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    @Test
    /**
     * Testmethode für Aufgaben 1.1, harmonische Reihe
     */
    public void testHarmonischeReihe() {
        // Debugging
        System.out.println(
                "Teste Methode " + METHODE_BEZEICHNER_HARMONISCHE_REIHE + " ...");

        Class<?> klasseKontrollstrukturen = getKlasseKontrollstrukturen();
        assertNotNull(
                "Kann Klasse " + KLASSE_BEZEICHNER_KONTROLLSTRUKTUREN + " nicht finden", klasseKontrollstrukturen
        );
        Object kontrollstrukturenInstanz = erzeugeInstanz(klasseKontrollstrukturen);
        Class<?>[] parameterliste = new Class<?>[]{int.class};
        assertTrue(
                "Methode " + METHODE_BEZEICHNER_HARMONISCHE_REIHE
                        + " fehlt oder hat falsche Parameterliste.",
                hatMethode(klasseKontrollstrukturen,
                        METHODE_BEZEICHNER_HARMONISCHE_REIHE, parameterliste));

        int[] testParameter = {1, 2, 6, 10};
        double[] testErwartungswerte = {1, 1.5, 2.45, 2.928968253};
        for (int i = 0; i < testParameter.length; i++) {
            int param = testParameter[i];
            double expected = testErwartungswerte[i];
            double wert = (double) werteMethodeAus(kontrollstrukturenInstanz,
                    METHODE_BEZEICHNER_HARMONISCHE_REIHE, parameterliste,
                    new Object[]{param});
            assertEquals(METHODE_BEZEICHNER_HARMONISCHE_REIHE + "(): Erwartungswert: "
                    + expected + " , erhalten: " + wert, wert, expected, 1e-5);

            // Debugging
            System.out.println("  " + param + " -> " + expected + "/" + wert);
        }
    }

    @Test
    /**
     * Testmethode für Aufgaben 1.2, Aufzählung
     */
    public void testAufzaehlung() {
        // Debugging
        System.out
                .println("Teste Aufzählungstyp " + ENUM_BEZEICHNER_FARBE + " ...");

        Class<?> klasseKontrollstrukturen = getKlasseKontrollstrukturen();
        assertNotNull(
                "Kann Klasse " + KLASSE_BEZEICHNER_KONTROLLSTRUKTUREN + " nicht finden",
                klasseKontrollstrukturen);
        Class<?> enumFarbe = getEnum(klasseKontrollstrukturen,
                ENUM_BEZEICHNER_FARBE);
        assertNotNull(
                "Aufzählungstyp " + ENUM_BEZEICHNER_FARBE + " nicht gefunden.",
                enumFarbe);
        Object farbeRot = getEnumKonstante(enumFarbe, ENUM_BEZEICHNER_FARBE_ROT);
        assertNotNull("Farbe " + ENUM_BEZEICHNER_FARBE_ROT + " nicht gefunden",
                farbeRot);
        Object farbeGruen = getEnumKonstante(enumFarbe,
                ENUM_BEZEICHNER_FARBE_GRUEN);
        assertNotNull("Farbe " + ENUM_BEZEICHNER_FARBE_GRUEN + " nicht gefunden",
                farbeGruen);
        Object farbeBlau = getEnumKonstante(enumFarbe, ENUM_BEZEICHNER_FARBE_BLAU);
        assertNotNull("Farbe " + ENUM_BEZEICHNER_FARBE_BLAU + " nicht gefunden",
                farbeBlau);
    }

    @Test
    /**
     * Testmethode für Aufgaben 1.2, String-Umwandlung
     */
    public void testFarbe2String() {
        // Debugging
        System.out
                .println("Teste Methode " + METHODE_BEZEICHNER_FARBE_2_STRING + " ...");

        Class<?> klasseKontrollstrukturen = getKlasseKontrollstrukturen();
        assertNotNull(
                "Kann Klasse " + KLASSE_BEZEICHNER_KONTROLLSTRUKTUREN + " nicht finden",
                klasseKontrollstrukturen);
        Object kontrollstrukturenInstanz = erzeugeInstanz(klasseKontrollstrukturen);

        Class<?> enumFarbe = getEnum(klasseKontrollstrukturen,
                ENUM_BEZEICHNER_FARBE);
        Object farbeRot = getEnumKonstante(enumFarbe, ENUM_BEZEICHNER_FARBE_ROT);
        Object farbeGruen = getEnumKonstante(enumFarbe,
                ENUM_BEZEICHNER_FARBE_GRUEN);
        Object farbeBlau = getEnumKonstante(enumFarbe, ENUM_BEZEICHNER_FARBE_BLAU);

        Class<?>[] parameterliste = {enumFarbe};
        assertTrue(
                "Methode " + METHODE_BEZEICHNER_FARBE_2_STRING
                        + " fehlt oder hat falsche Parameterliste.",
                hatMethode(klasseKontrollstrukturen, METHODE_BEZEICHNER_FARBE_2_STRING,
                        parameterliste));

        Object[] params = new Object[]{farbeRot, farbeGruen, farbeBlau};
        String[] erwartungswerte = new String[]{"rot", "gruen", "blau"};
        for (int i = 0; i < params.length; i++) {
            String expected = erwartungswerte[i];
            Object param = params[i];
            Object wert = werteMethodeAus(kontrollstrukturenInstanz,
                    METHODE_BEZEICHNER_FARBE_2_STRING, parameterliste,
                    new Object[]{param});
            assertEquals("Methode " + METHODE_BEZEICHNER_FARBE_2_STRING
                    + " liefert falschen Wert für " + param, expected, wert);

            // Debugging
            System.out.println("  " + param + " -> " + wert + "/" + expected);
        }
    }

    @Test
    public void testKapazitaetVerdoppeln() {
        // Debugging
        System.out.println(
                "Teste Methode " + METHODE_BEZEICHNER_KAPAZITAET_VERDOPPELN + " ...");

        Class<?> klasseKontrollstrukturen = getKlasseKontrollstrukturen();
        assertNotNull(
                "Kann Klasse " + KLASSE_BEZEICHNER_KONTROLLSTRUKTUREN + " nicht finden",
                klasseKontrollstrukturen);
        Object kontrollstrukturenInstanz = erzeugeInstanz(klasseKontrollstrukturen);

        Class<?>[] parameterliste = {String[].class};
        assertTrue(
                "Methode " + METHODE_BEZEICHNER_KAPAZITAET_VERDOPPELN
                        + " fehlt oder hat falsche Parameterliste.",
                hatMethode(klasseKontrollstrukturen,
                        METHODE_BEZEICHNER_KAPAZITAET_VERDOPPELN, parameterliste));

        Object[] params = new Object[]{new String[]{"Hallo", "Welt"},
                new String[]{"23"}, new String[]{"a", "b", "c", "d", "e"}};
        for (int i = 0; i < params.length; i++) {
            String[] param = (String[]) params[i];
            Object wert = werteMethodeAus(kontrollstrukturenInstanz,
                    METHODE_BEZEICHNER_KAPAZITAET_VERDOPPELN, parameterliste,
                    new Object[]{param});
            assertTrue("Rückgabetyp von " + METHODE_BEZEICHNER_KAPAZITAET_VERDOPPELN
                    + " muss String[] sein", wert instanceof String[]);
            String[] ergebnis = (String[]) wert;
            assertEquals("Falsche Länge des Ergebnisarrays.",
                    Math.max(1, param.length * 2), ergebnis.length);
            for (int j = 0; j < ergebnis.length; j++) {
                if (j < param.length) {
                    assertEquals("String nicht übertragen", param[j], ergebnis[j]);
                }
            }

            // Debugging
            System.out.print("  ");
            Arrays.stream(param).forEach(text -> System.out.print(text + " "));
            System.out.print(" -> ");
            Arrays.stream(ergebnis).forEach(text -> System.out.print(text + " "));
            System.out.println();
        }
    }

    @Test
    public void testKapazitaetVerdoppelnEmpty() {
        // Debugging
        System.out
                .println("Teste Methode " + METHODE_BEZEICHNER_KAPAZITAET_VERDOPPELN
                        + ", Spezialfall Länge = 0 ...");

        Class<?> klasseKontrollstrukturen = getKlasseKontrollstrukturen();
        assertNotNull(
                "Kann Klasse " + KLASSE_BEZEICHNER_KONTROLLSTRUKTUREN + " nicht finden",
                klasseKontrollstrukturen);
        Object kontrollstrukturenInstanz = erzeugeInstanz(klasseKontrollstrukturen);

        Class<?>[] parameterliste = {String[].class};
        assertTrue(
                "Methode " + METHODE_BEZEICHNER_KAPAZITAET_VERDOPPELN
                        + " fehlt oder hat falsche Parameterliste.",
                hatMethode(klasseKontrollstrukturen,
                        METHODE_BEZEICHNER_KAPAZITAET_VERDOPPELN, parameterliste));

        Object[] params = new Object[]{new String[]{}};
        for (int i = 0; i < params.length; i++) {
            String[] param = (String[]) params[i];
            Object wert = werteMethodeAus(kontrollstrukturenInstanz,
                    METHODE_BEZEICHNER_KAPAZITAET_VERDOPPELN, parameterliste,
                    new Object[]{param});
            assertTrue("Rückgabetyp von " + METHODE_BEZEICHNER_KAPAZITAET_VERDOPPELN
                    + " muss String[] sein", wert instanceof String[]);
            String[] ergebnis = (String[]) wert;
            assertEquals("Falsche Länge des Ergebnisarrays.",
                    Math.max(1, param.length * 2), ergebnis.length);
            for (int j = 0; j < ergebnis.length; j++) {
                if (j < param.length) {
                    assertEquals("String nicht übertragen", param[j], ergebnis[j]);
                }
            }

            // Debugging
            System.out.print("  ");
            Arrays.stream(param).forEach(text -> System.out.print(text + " "));
            System.out.print(" -> ");
            Arrays.stream(ergebnis).forEach(text -> System.out.print(text + " "));
            System.out.println();
        }
    }
}
