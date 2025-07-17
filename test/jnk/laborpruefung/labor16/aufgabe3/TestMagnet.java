package jnk.laborpruefung.labor16.aufgabe3;

import jnk.laborpruefung.labor16.base.TestBasisklasse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Testklasse für @Magnet
 *
 * @author Philipp Jenke
 */
public class TestMagnet extends TestBasisklasse {
    private static final String BEZEICHNER_NAME = "name";
    private static final String BEZEICHNER_ANLIEGENDE_MAGNETE =
            "anliegendeMagnete";
    private static final String BEZEICHNER_ANLEGEN = "anlegen";
    private static final String BEZEICHNER_ENUM_POL = "Pol";
    private static final String BEZEICHNER_ENUM_POL_PLUS = "PLUS";
    private static final String BEZEICHNER_ENUM_POL_MINUS = "MINUS";
    private static final String BEZEICHNER_GET_MINUSPOS_MAGNET =
            "getMinusPolMagnet";
    private static final String BEZEICHNER_TO_STRING = "toString";
    private static final String BEZEICHNER_KETTE_ALS_STRING = "ketteAlsString";
    private static final String BEZEICHNER_GET_ANZAHL_ANLIEGENDER_MAGNETE =
            "getAnzahlAnliegendeMagnete";
    private static final String BEZEICHNER_GET_ANZAHL_MAGNETE_IN_KETTE =
            "getAnzahlMagneteInKette";

    /**
     * Erzeugt ein Magnet-Objekt.
     */
    public static Object erzeugeMagnet(String name) {
        Class<?>[] typen = {String.class};
        Object[] werte = {name};
        Object magnet = erzeugeInstanz(Magnet.class, typen, werte);
        return magnet;
    }

    /**
     * Liefert den anliegenden Magneten in der angegebenen Polrichtung.
     */
    private Object getAnliegendenMagneten(Object magnet, String polRichtung) {
        Class<?> enumKlasse = getEnum(Magnet.class, BEZEICHNER_ENUM_POL);
        Object anliegendeMagnete =
                getWertObjektVariable(magnet, BEZEICHNER_ANLIEGENDE_MAGNETE);
        Magnet[] anliegendeMagneteArray = (Magnet[]) anliegendeMagnete;
        int ordinal = getEnumOrdinal(enumKlasse, polRichtung);
        return anliegendeMagneteArray[ordinal];
    }

    /**
     * Setzt den anliegenden Magneten in der angegebenen Polrichtung.
     */
    private void setzeAnliegendenMagneten(Object magnet, String polRichtung,
                                          Object anzulegenderMagnet) {
        Class<?> enumKlasse = getEnum(Magnet.class, BEZEICHNER_ENUM_POL);
        Object polRichtungKonstante = getEnumKonstante(enumKlasse, polRichtung);
        Class<?>[] parameterListe = {enumKlasse, Magnet.class};
        Object[] argumentenListe = {polRichtungKonstante, anzulegenderMagnet};
        werteMethodeAus(magnet, BEZEICHNER_ANLEGEN, parameterListe, argumentenListe);
    }

    @Test
    public void testeVariableName() {
        assertTrue(
                "Klasse Magnet hat nicht geforderte Objektvariable " + BEZEICHNER_NAME,
                testHatObjektVariable(Magnet.class, BEZEICHNER_NAME, String.class));
    }

    @Test
    public void testeVariableAnliegendeMagnete() {
        assertTrue(
                "Klasse Magnet hat nicht geforderte Objektvariable "
                        + BEZEICHNER_ANLIEGENDE_MAGNETE,
                testHatObjektVariable(Magnet.class, BEZEICHNER_ANLIEGENDE_MAGNETE,
                        Magnet[].class));
    }

    @Test
    public void testeKonstruktor() {
        Class<?>[] parameter = {String.class};
        assertTrue("Klasse Magnet hat nicht geforderten Konstruktor.",
                hatKonstruktor(Magnet.class, parameter));

        // Erzeuge Dvd
        String name = "Magnet 1";
        Object magnet = erzeugeMagnet(name);

        Object istName = getWertObjektVariable(magnet, BEZEICHNER_NAME);
        assertTrue(BEZEICHNER_NAME + " wurde in Konstruktor nicht korrekt gesetzt.",
                name.equals(istName));
    }

    @Test
    public void testEnumKonstanten() {
        Class<?> enumKlasse = getEnum(Magnet.class, BEZEICHNER_ENUM_POL);
        assertNotNull("Enum-Konstanten nicht gefunden", enumKlasse);
        Object[] enumKonstanten = getEnumKonstanten(enumKlasse);
        List<String> vorhandeneKonstanten = new ArrayList<String>();
        for (Object enumKonstante : enumKonstanten) {
            vorhandeneKonstanten.add(enumKonstante.toString());
        }
        assertTrue(
                "enum-Konstante " + BEZEICHNER_ENUM_POL_PLUS + " nicht gefunden.",
                vorhandeneKonstanten.contains(BEZEICHNER_ENUM_POL_PLUS));
        assertTrue(
                "enum-Konstante " + BEZEICHNER_ENUM_POL_MINUS + " nicht gefunden.",
                vorhandeneKonstanten.contains(BEZEICHNER_ENUM_POL_MINUS));
    }

    @Test
    public void testeSet() {
        Class<?> enumKlasse = getEnum(Magnet.class, BEZEICHNER_ENUM_POL);

        Class<?>[] parameter = {enumKlasse, Magnet.class};
        assertTrue(
                "Klasse Magnet hat nicht geforderte Methode " + BEZEICHNER_ANLEGEN + ".",
                hatMethode(Magnet.class, BEZEICHNER_ANLEGEN, parameter));

        assertTrue("Methode " + BEZEICHNER_ANLEGEN + " hat falschen Rückgabetyp.",
                getRueckgabeTyp(Magnet.class, BEZEICHNER_ANLEGEN, parameter) == void.class);

        // Teste Magnet ohne Verkettung
        Object magnet1 = erzeugeMagnet("Magnet 1");

        assertNull("Anliegender Magnet Plus sollten zu Beginn null sein.",
                getAnliegendenMagneten(magnet1, BEZEICHNER_ENUM_POL_PLUS));
        assertNull("Anliegender Magnet Minus sollten zu Beginn null sein.",
                getAnliegendenMagneten(magnet1, BEZEICHNER_ENUM_POL_MINUS));

        // Teste Magnet mit Verkettung in Plus-Richtung
        Object magnet2 = erzeugeMagnet("Magnet 2");
        setzeAnliegendenMagneten(magnet1, BEZEICHNER_ENUM_POL_PLUS, magnet2);
        assertTrue("Anliegender Magnet Plus ist falsch gesetzt.",
                magnet2 == getAnliegendenMagneten(magnet1, BEZEICHNER_ENUM_POL_PLUS));
        // Teste Magnet mit Verkettung in beiden Richtungen
        Object magnet3 = erzeugeMagnet("Magnet 3");
        setzeAnliegendenMagneten(magnet1, BEZEICHNER_ENUM_POL_MINUS, magnet3);
        assertTrue("Anliegender Magnet Plus ist falsch gesetzt.",
                magnet2 == getAnliegendenMagneten(magnet1, BEZEICHNER_ENUM_POL_PLUS));
        assertTrue("Anliegender Magnet Minus ist falsch gesetzt.",
                magnet3 == getAnliegendenMagneten(magnet1, BEZEICHNER_ENUM_POL_MINUS));
    }

    @Test
    public void testeSetGegenrichtung() {
        // Teste Magnet ohne Verkettung
        Object magnet1 = erzeugeMagnet("Magnet 1");
        // Teste Magnet mit Verkettung in Plus-Richtung
        Object magnet2 = erzeugeMagnet("Magnet 2");
        setzeAnliegendenMagneten(magnet1, BEZEICHNER_ENUM_POL_PLUS, magnet2);
        // Prüfe, ob in beide Richtungen gesetzt wurde
        assertEquals("Magnet in Gegenrichtung wurde nicht gesetzt.", magnet1,
                getAnliegendenMagneten(magnet2, BEZEICHNER_ENUM_POL_MINUS));
        // Teste Magnet mit Verkettung in beiden Richtungen
        Object magnet3 = erzeugeMagnet("Magnet 3");
        setzeAnliegendenMagneten(magnet1, BEZEICHNER_ENUM_POL_MINUS, magnet3);
        // Prüfe, ob in beide Richtungen gesetzt wurde
        assertEquals("Magnet in Gegenrichtung wurde nicht gesetzt.", magnet1,
                getAnliegendenMagneten(magnet3, BEZEICHNER_ENUM_POL_PLUS));
    }

    @Test
    public void testeGetMinusPolMagnet() {
        Class<?>[] parameterListe = {};
        assertTrue(
                "Klasse Magnet hat nicht geforderte Methode "
                        + BEZEICHNER_GET_MINUSPOS_MAGNET + ".",
                hatMethode(Magnet.class, BEZEICHNER_GET_MINUSPOS_MAGNET,
                        parameterListe));

        assertTrue(
                "Methode " + BEZEICHNER_GET_MINUSPOS_MAGNET
                        + " hat falschen Rückgabetyp.",
                getRueckgabeTyp(Magnet.class, BEZEICHNER_GET_MINUSPOS_MAGNET,
                        parameterListe) == Magnet.class);

        // Erstelle Kette aus drei Magneten.
        Object magnet1 = erzeugeMagnet("Magnet 1");
        Object magnet2 = erzeugeMagnet("Magnet 2");
        Object magnet3 = erzeugeMagnet("Magnet 3");
        setzeAnliegendenMagneten(magnet1, BEZEICHNER_ENUM_POL_PLUS, magnet2);
        setzeAnliegendenMagneten(magnet2, BEZEICHNER_ENUM_POL_PLUS, magnet3);

        // Prüfe Methode für Magnet am Minus-Pol
        Object minusMagnet =
                werteMethodeAus(magnet1, BEZEICHNER_GET_MINUSPOS_MAGNET);
        assertEquals(
                "Magnet am Minus-Pol falsch berechnet (Magnet selber müsste Minus-Pol sein).",
                magnet1, minusMagnet);

        // Prüfe Methode für mittleren Magneten
        minusMagnet = werteMethodeAus(magnet2, BEZEICHNER_GET_MINUSPOS_MAGNET);
        assertEquals("Magnet am Minus-Pol falsch berechnet.", magnet1, minusMagnet);

        // Prüfe Methode für Magneten am Plus-Pol
        minusMagnet = werteMethodeAus(magnet3, BEZEICHNER_GET_MINUSPOS_MAGNET);
        assertEquals("Magnet am Minus-Pol falsch berechnet.", magnet1, minusMagnet);
    }

    @Test
    public void testToString() {
        Class<?>[] parameterListe = {};
        assertTrue(
                "Klasse Magnet hat nicht geforderte Methode " + BEZEICHNER_TO_STRING
                        + ".",
                hatMethode(Magnet.class, BEZEICHNER_TO_STRING, parameterListe));

        assertTrue("Methode " + BEZEICHNER_TO_STRING + " hat falschen Rückgabetyp.",
                getRueckgabeTyp(Magnet.class, BEZEICHNER_TO_STRING,
                        parameterListe) == String.class);

        // Prüfe toString() Ergebnis
        String name = "Magnet 1";
        Object magnet = erzeugeMagnet(name);
        String erwartung = "[- " + name + " +]";
        Object istToString = werteMethodeAus(magnet, BEZEICHNER_TO_STRING);
        assertEquals("Methode " + BEZEICHNER_TO_STRING
                + " liefert nicht korrektes Ergebnis.", erwartung, istToString);
    }

    @Test
    public void testKetteAlsString() {
        Class<?>[] parameterListe = {};
        assertTrue(
                "Klasse Magnet hat nicht geforderte Methode "
                        + BEZEICHNER_KETTE_ALS_STRING + ".",
                hatMethode(Magnet.class, BEZEICHNER_KETTE_ALS_STRING, parameterListe));

        assertTrue(
                "Methode " + BEZEICHNER_KETTE_ALS_STRING + " hat falschen Rückgabetyp.",
                getRueckgabeTyp(Magnet.class, BEZEICHNER_KETTE_ALS_STRING,
                        parameterListe) == String.class);

        // Erstelle Kette aus drei Magneten.
        String name1 = "Magnet 1";
        String name2 = "Magnet 2";
        String name3 = "Magnet 3";
        Object magnet1 = erzeugeMagnet(name1);
        Object magnet2 = erzeugeMagnet(name2);
        Object magnet3 = erzeugeMagnet(name3);
        setzeAnliegendenMagneten(magnet1, BEZEICHNER_ENUM_POL_PLUS, magnet2);
        setzeAnliegendenMagneten(magnet2, BEZEICHNER_ENUM_POL_PLUS, magnet3);

        String erwartet =
                "[- " + name1 + " +] " + "[- " + name2 + " +] " + "[- " + name3 + " +]";
        Object istErgebnis = werteMethodeAus(magnet1, BEZEICHNER_KETTE_ALS_STRING);
        assertEquals(
                "Methode " + BEZEICHNER_KETTE_ALS_STRING
                        + " liefert falsches Ergebnis.",
                erwartet, (istErgebnis instanceof String)
                        ? ((String) istErgebnis).trim() : istErgebnis);

        istErgebnis = werteMethodeAus(magnet2, BEZEICHNER_KETTE_ALS_STRING);
        assertEquals(
                "Methode " + BEZEICHNER_KETTE_ALS_STRING
                        + " liefert falsches Ergebnis.",
                erwartet, (istErgebnis instanceof String)
                        ? ((String) istErgebnis).trim() : istErgebnis);

        istErgebnis = werteMethodeAus(magnet3, BEZEICHNER_KETTE_ALS_STRING);
        assertEquals(
                "Methode " + BEZEICHNER_KETTE_ALS_STRING
                        + " liefert falsches Ergebnis.",
                erwartet, (istErgebnis instanceof String)
                        ? ((String) istErgebnis).trim() : istErgebnis);
    }

    @Test
    public void testGetAnzahlAnliegendeMagnete() {
        Class<?> enumKlasse = getEnum(Magnet.class, BEZEICHNER_ENUM_POL);
        Class<?>[] parameterListe = {enumKlasse};
        assertTrue(
                "Klasse Magnet hat nicht geforderte Methode "
                        + BEZEICHNER_GET_ANZAHL_ANLIEGENDER_MAGNETE + ".",
                hatMethode(Magnet.class, BEZEICHNER_GET_ANZAHL_ANLIEGENDER_MAGNETE,
                        parameterListe));

        assertTrue(
                "Methode " + BEZEICHNER_GET_ANZAHL_ANLIEGENDER_MAGNETE
                        + " hat falschen Rückgabetyp.",
                getRueckgabeTyp(Magnet.class, BEZEICHNER_GET_ANZAHL_ANLIEGENDER_MAGNETE,
                        parameterListe) == int.class);

        // Erstelle Kette aus drei Magneten.
        String name1 = "Magnet 1";
        String name2 = "Magnet 2";
        String name3 = "Magnet 3";
        Object magnet1 = erzeugeMagnet(name1);
        Object magnet2 = erzeugeMagnet(name2);
        Object magnet3 = erzeugeMagnet(name3);
        setzeAnliegendenMagneten(magnet1, BEZEICHNER_ENUM_POL_PLUS, magnet2);
        setzeAnliegendenMagneten(magnet2, BEZEICHNER_ENUM_POL_PLUS, magnet3);

        int erwartet = 0;
        Object[] argumentenListe =
                {getEnumKonstante(enumKlasse, BEZEICHNER_ENUM_POL_MINUS)};
        Object istErgebnis =
                werteMethodeAus(magnet1, BEZEICHNER_GET_ANZAHL_ANLIEGENDER_MAGNETE,
                        parameterListe, argumentenListe);
        assertEquals(
                "Methode " + BEZEICHNER_GET_ANZAHL_ANLIEGENDER_MAGNETE
                        + " liefert falsches Ergebnis.",
                erwartet,
                (istErgebnis instanceof Integer) ? (Integer) istErgebnis : -1);

        erwartet = 1;
        argumentenListe[0] =
                getEnumKonstante(enumKlasse, BEZEICHNER_ENUM_POL_MINUS);
        istErgebnis =
                werteMethodeAus(magnet2, BEZEICHNER_GET_ANZAHL_ANLIEGENDER_MAGNETE,
                        parameterListe, argumentenListe);
        assertEquals(
                "Methode " + BEZEICHNER_GET_ANZAHL_ANLIEGENDER_MAGNETE
                        + " liefert falsches Ergebnis.",
                erwartet,
                (istErgebnis instanceof Integer) ? (Integer) istErgebnis : -1);

        erwartet = 2;
        argumentenListe[0] = getEnumKonstante(enumKlasse, BEZEICHNER_ENUM_POL_PLUS);
        istErgebnis =
                werteMethodeAus(magnet1, BEZEICHNER_GET_ANZAHL_ANLIEGENDER_MAGNETE,
                        parameterListe, argumentenListe);
        assertEquals(
                "Methode " + BEZEICHNER_GET_ANZAHL_ANLIEGENDER_MAGNETE
                        + " liefert falsches Ergebnis.",
                erwartet,
                (istErgebnis instanceof Integer) ? (Integer) istErgebnis : -1);
    }

    @Test
    public void testGetAnzahlMagneteInKette() {
        Class<?>[] parameterListe = {};
        assertTrue(
                "Klasse Magnet hat nicht geforderte Methode "
                        + BEZEICHNER_GET_ANZAHL_MAGNETE_IN_KETTE + ".",
                hatMethode(Magnet.class, BEZEICHNER_GET_ANZAHL_MAGNETE_IN_KETTE,
                        parameterListe));

        assertTrue(
                "Methode " + BEZEICHNER_GET_ANZAHL_MAGNETE_IN_KETTE
                        + " hat falschen Rückgabetyp.",
                getRueckgabeTyp(Magnet.class, BEZEICHNER_GET_ANZAHL_MAGNETE_IN_KETTE,
                        parameterListe) == int.class);

        // Erstelle Kette aus drei Magneten.
        String name1 = "Magnet 1";
        String name2 = "Magnet 2";
        String name3 = "Magnet 3";
        Object magnet1 = erzeugeMagnet(name1);
        Object magnet2 = erzeugeMagnet(name2);
        Object magnet3 = erzeugeMagnet(name3);

        int erwartet = 1;
        Object[] argumentenListe = {};
        Object istErgebnis =
                werteMethodeAus(magnet1, BEZEICHNER_GET_ANZAHL_MAGNETE_IN_KETTE,
                        parameterListe, argumentenListe);
        assertEquals(
                "Methode " + BEZEICHNER_GET_ANZAHL_MAGNETE_IN_KETTE
                        + " liefert falsches Ergebnis.",
                erwartet,
                (istErgebnis instanceof Integer) ? (Integer) istErgebnis : -1);

        setzeAnliegendenMagneten(magnet1, BEZEICHNER_ENUM_POL_PLUS, magnet2);
        setzeAnliegendenMagneten(magnet2, BEZEICHNER_ENUM_POL_PLUS, magnet3);

        erwartet = 3;
        istErgebnis =
                werteMethodeAus(magnet1, BEZEICHNER_GET_ANZAHL_MAGNETE_IN_KETTE,
                        parameterListe, argumentenListe);
        assertEquals(
                "Methode " + BEZEICHNER_GET_ANZAHL_MAGNETE_IN_KETTE
                        + " liefert falsches Ergebnis.",
                erwartet,
                (istErgebnis instanceof Integer) ? (Integer) istErgebnis : -1);
    }
}