package jnk.laborpruefung.labor16.aufgabe2;

import jnk.laborpruefung.labor16.base.TestBasisklasse;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Testklasse für @Dvd
 *
 * @author Philipp Jenke
 */
public class TestDvd extends TestBasisklasse {

    private static String BEZEICHNER_TITEL = "titel";
    private static String BEZEICHNER_LAUFZEIT = "laufzeit";
    private static String BEZEICHNER_ALTERSFREIGABE = "altersfreigabe";
    private static String BEZEICHNER_GET_TITEL = "getTitel";
    private static String BEZEICHNER_GET_ALTERSFREIGABE = "getAltersfreigabe";
    private static String BEZEICHNER_GET_LAUFZEIT = "getLaufzeit";

    /**
     * Erzeugt ein DVD-Objekt.
     */
    public static Object erzeugeDvd(String titel, int laufzeit,
                                    int altersfreigabe) {
        Class<?>[] typen = {String.class, int.class, int.class};
        Object[] werte =
                {titel, new Integer(laufzeit), new Integer(altersfreigabe)};
        Object dvd = erzeugeInstanz(Dvd.class, typen, werte);
        return dvd;
    }

    @Test
    public void testeVariableTitel() {
        assertTrue(
                "Klasse Dvd hat nicht geforderte Objektvariable " + BEZEICHNER_TITEL,
                testHatObjektVariable(Dvd.class, BEZEICHNER_TITEL, String.class));
    }

    @Test
    public void testeVariableLaufzeit() {
        assertTrue(
                "Klasse Dvd hat nicht geforderte Objektvariable " + BEZEICHNER_LAUFZEIT,
                testHatObjektVariable(Dvd.class, BEZEICHNER_LAUFZEIT, int.class));
    }

    @Test
    public void testeVariableAltersfreigabe() {
        assertTrue(
                "Klasse Dvd hat nicht geforderte Objektvariable "
                        + BEZEICHNER_ALTERSFREIGABE,
                testHatObjektVariable(Dvd.class, BEZEICHNER_ALTERSFREIGABE, int.class));
    }

    @Test
    public void testeKonstruktor() {
        Class<?>[] parameter = {String.class, int.class, int.class};
        assertTrue("Klasse Dvd hat nicht geforderten Konstruktor.",
                hatKonstruktor(Dvd.class, parameter));

        // Erzeuge Dvd
        String titel = "Stirb langsam";
        int laufzeit = 120;
        int altersfreigabe = 16;
        Object dvd = erzeugeDvd(titel, laufzeit, altersfreigabe);

        Object istTitel = getWertObjektVariable(dvd, BEZEICHNER_TITEL);
        assertTrue(BEZEICHNER_TITEL + " wurde in Konstruktor nicht korrekt gesetzt.",
                titel.equals(istTitel));

        Object istLaufzeit = getWertObjektVariable(dvd, BEZEICHNER_LAUFZEIT);
        int istLaufzeitInt = (Integer) istLaufzeit;
        assertTrue(
                BEZEICHNER_LAUFZEIT + " wurde in Konstruktor nicht korrekt gesetzt.",
                laufzeit == istLaufzeitInt);

        Object istAltersfreigabe =
                getWertObjektVariable(dvd, BEZEICHNER_ALTERSFREIGABE);
        int istAltersfreigabeInt = (Integer) istAltersfreigabe;
        assertTrue(
                BEZEICHNER_ALTERSFREIGABE
                        + " wurde in Konstruktor nicht korrekt gesetzt.",
                altersfreigabe == istAltersfreigabeInt);
    }

    @Test
    public void testeGetTitel() {
        Class<?>[] parameter = {};
        assertTrue(
                "Klasse Dvd hat nicht geforderte Methode " + BEZEICHNER_GET_TITEL + ".",
                hatMethode(Dvd.class, BEZEICHNER_GET_TITEL, parameter));

        assertTrue("Methode " + BEZEICHNER_GET_TITEL + " hat falschen Rückgabetyp.",
                getRueckgabeTyp(Dvd.class, BEZEICHNER_GET_TITEL,
                        parameter) == String.class);

        // Erzeuge Dvd
        String titel = "Stirb langsam";
        int laufzeit = 120;
        int altersfreigabe = 16;
        Object dvd = erzeugeDvd(titel, laufzeit, altersfreigabe);

        // Werte Methode aus
        Object ergebnis = werteMethodeAus(dvd, BEZEICHNER_GET_TITEL);
        assertNotNull(
                "Methode " + BEZEICHNER_GET_TITEL + " liefert falsches Ergebnis.",
                ergebnis);

        // Assert auf Ergebnis
        String istTitel = (String) ergebnis;
        assertTrue(
                "Methode " + BEZEICHNER_GET_TITEL + " liefert nicht korrekten Wert.",
                titel.equals(istTitel));
    }

    @Test
    public void testeGetLaufzeit() {
        Class<?>[] parameter = {};
        assertTrue("Klasse Dvd hat nicht geforderte Methode "
                        + BEZEICHNER_GET_LAUFZEIT + ".",
                hatMethode(Dvd.class, BEZEICHNER_GET_LAUFZEIT, parameter));

        assertTrue(
                "Methode " + BEZEICHNER_GET_LAUFZEIT + " hat falschen Rückgabetyp.",
                getRueckgabeTyp(Dvd.class, BEZEICHNER_GET_LAUFZEIT,
                        parameter) == int.class);

        // Erzeuge Dvd
        String titel = "Stirb langsam";
        int laufzeit = 120;
        int altersfreigabe = 16;
        Object dvd = erzeugeDvd(titel, laufzeit, altersfreigabe);

        // Werte Methode aus
        Object ergebnis = werteMethodeAus(dvd, BEZEICHNER_GET_LAUFZEIT);
        assertNotNull(
                "Methode " + BEZEICHNER_GET_LAUFZEIT + " liefert falsches Ergebnis.",
                ergebnis);

        // Assert auf Ergebnis
        Integer istLaufzeit = (Integer) ergebnis;
        assertTrue(
                "Methode " + BEZEICHNER_GET_LAUFZEIT + " liefert nicht korrekten Wert.",
                laufzeit == istLaufzeit);
    }

    @Test
    public void testeGetAltersfreigabe() {
        Class<?>[] parameter = {};
        assertTrue(
                "Klasse Dvd hat nicht geforderte Methode "
                        + BEZEICHNER_GET_ALTERSFREIGABE + ".",
                hatMethode(Dvd.class, BEZEICHNER_GET_ALTERSFREIGABE, parameter));

        assertTrue(
                "Methode " + BEZEICHNER_GET_ALTERSFREIGABE
                        + " hat falschen Rückgabetyp.",
                getRueckgabeTyp(Dvd.class, BEZEICHNER_GET_ALTERSFREIGABE,
                        parameter) == int.class);

        // Erzeuge Dvd
        String titel = "Stirb langsam";
        int laufzeit = 120;
        int altersfreigabe = 16;
        Object dvd = erzeugeDvd(titel, laufzeit, altersfreigabe);

        // Werte Methode aus
        Object ergebnis = werteMethodeAus(dvd, BEZEICHNER_GET_ALTERSFREIGABE);
        assertNotNull("Methode " + BEZEICHNER_GET_ALTERSFREIGABE
                + " liefert falsches Ergebnis.", ergebnis);

        // Assert auf Ergebnis
        Integer istAltersfreigabe = (Integer) ergebnis;
        assertTrue(
                "Methode " + BEZEICHNER_GET_LAUFZEIT + " liefert nicht korrekten Wert.",
                altersfreigabe == istAltersfreigabe);
    }
}
