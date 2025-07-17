package jnk.laborpruefung.labor16.aufgabe1;


import jnk.laborpruefung.labor16.base.TestBasisklasse;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Testklasse für @ZahlTerm
 *
 * @author Philipp Jenke
 */
public class TestZahlTerm extends TestBasisklasse {

    private static final String VARIABLEN_BEZEICHNER_WERT = "wert";
    private static final String METHODEN_BEZEICHNER_GET_WERT = "getWert";
    private static final String METHODEN_BEZEICHNER_TO_STRING = "toString";
    private static final String METHODEN_BEZEICHNER_EQUALS = "equals";

    @Test
    public void testeKlassenSignatur() {
        assertTrue("Klasse ZahlTerm implementiert nicht das geforderte Interface.",
                testImplementiertInterface(ZahlTerm.class, Term.class));
    }

    @Test
    public void testeWertVariable() {
        assertTrue("Klasse ZahlTerm hat nicht geforderte Objektvariable.",
                testHatObjektVariable(ZahlTerm.class, VARIABLEN_BEZEICHNER_WERT,
                        double.class));
    }

    @Test
    public void testeKonstruktor() {
        Class<?>[] parameter = {double.class};
        assertTrue("Klasse ZahlTerm hat nicht den geforderten Konstruktor.",
                hatKonstruktor(ZahlTerm.class, parameter));

        // Erzeuge ZahlTerm(PI)
        double zahl = 23;
        Class<?>[] typen = {double.class};
        Object[] werte = {zahl};
        Object term = erzeugeInstanz(ZahlTerm.class, typen, werte);

        Object wert = getWertObjektVariable(term, VARIABLEN_BEZEICHNER_WERT);
        Double doubleWert = (Double) wert;
        assertTrue("Zahlenwert wurde in Konstruktor nicht korrekt initialisiert",
                Math.abs(doubleWert.doubleValue() - zahl) < 1e-5);
    }

    @Test
    public void testeGetWert() {
        Class<?>[] parameter = {};
        assertTrue(
                "Klasse ZahlTerm hat nicht geforderte Methode "
                        + METHODEN_BEZEICHNER_GET_WERT + ".",
                hatMethode(ZahlTerm.class, METHODEN_BEZEICHNER_GET_WERT, parameter));

        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_GET_WERT + " hat falschen Rückgabetyp",
                getRueckgabeTyp(ZahlTerm.class, METHODEN_BEZEICHNER_GET_WERT,
                        parameter) == double.class);

        // Erzeuge ZahlTerm(PI)
        double zahl = 23;
        Class<?>[] typen = {double.class};
        Object[] werte = {zahl};
        Object term = erzeugeInstanz(ZahlTerm.class, typen, werte);

        // Werte getWert() aus
        Object ergebnis = werteMethodeAus(term, METHODEN_BEZEICHNER_GET_WERT);
        assertNotNull("Methode " + METHODEN_BEZEICHNER_GET_WERT
                + " liefert falsches Ergebnis.", ergebnis);

        // Assert auf Ergebnis
        Double doubleWert = (Double) ergebnis;
        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_GET_WERT
                        + " liefert nicht korrekten Wert.",
                Math.abs(doubleWert.doubleValue() - zahl) < 1e-5);
    }

    @Test
    public void testeToString() {
        Class<?>[] parameter = {};
        assertTrue(
                "Klasse ZahlTerm hat nicht geforderte Methode "
                        + METHODEN_BEZEICHNER_TO_STRING + ".",
                hatMethode(ZahlTerm.class, METHODEN_BEZEICHNER_TO_STRING, parameter));

        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_TO_STRING
                        + " hat falschen Rückgabetyp.",
                getRueckgabeTyp(ZahlTerm.class, METHODEN_BEZEICHNER_TO_STRING,
                        parameter) == String.class);

        // Erzeuge ZahlTerm(PI)
        Class<?>[] typen = {double.class};
        Object[] werte = {Math.PI};
        Object term = erzeugeInstanz(ZahlTerm.class, typen, werte);

        // Methodenaufruf toString()
        Object[] argumente = {};
        Class<?>[] methodenParameter = {};
        Object ergebnis = werteMethodeAus(term, METHODEN_BEZEICHNER_TO_STRING,
                methodenParameter, argumente);
        assertTrue("Ungültige Rückgabe bei " + METHODEN_BEZEICHNER_TO_STRING,
                ergebnis != null && ergebnis instanceof String);
        String stringErgebnis = (String) ergebnis;

        // Assert auf Ergebnis
        String erwartungKomma = "3,14";
        String erwartungPunkt = "3.14";
        assertTrue(
                "Term wird durch " + METHODEN_BEZEICHNER_TO_STRING
                        + " falsch dargestellt (erwartet: " + erwartungKomma + ", ergebnis:"
                        + stringErgebnis + ").",
                stringErgebnis.equals(erwartungKomma)
                        || stringErgebnis.equals(erwartungPunkt));
    }

    @Test
    public void testeEquals() {
        Class<?>[] parameter = {Object.class};
        assertTrue(
                "Klasse ZahlTerm hat nicht geforderte Methode "
                        + METHODEN_BEZEICHNER_EQUALS + ".",
                hatMethode(ZahlTerm.class, METHODEN_BEZEICHNER_EQUALS, parameter));

        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_EQUALS + " hat falschen Rückgabetyp.",
                getRueckgabeTyp(ZahlTerm.class, METHODEN_BEZEICHNER_EQUALS,
                        parameter) == boolean.class);

        // Erzeuge ZahlTerm(PI)
        Class<?>[] typen = {double.class};
        Object[] werte = {Math.PI};
        Object term = erzeugeInstanz(ZahlTerm.class, typen, werte);
        Class<?>[] methodenParameter = {Object.class};

        // Methodenaufruf equals(null)
        Object vergleich1 = null;
        Object[] argumente = {vergleich1};
        Object ergebnis = werteMethodeAus(term, METHODEN_BEZEICHNER_EQUALS,
                methodenParameter, argumente);

        // Assert auf ergebnis
        assertTrue("equals()-Vergleich mit " + vergleich1 + " fehlgeschlagen.",
                ergebnis != null && ergebnis instanceof Boolean
                        && (Boolean) ergebnis == false);
    }
}
