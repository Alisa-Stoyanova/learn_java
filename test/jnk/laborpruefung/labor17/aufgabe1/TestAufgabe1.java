package jnk.laborpruefung.labor17.aufgabe1;

import jnk.laborpruefung.labor17.basis.TestBasisklasse;
import org.junit.Test;

import static junit.framework.Assert.*;


public class TestAufgabe1 extends TestBasisklasse {

    public static final String VARIABLEN_BEZEICHNER_REAL = "real";
    public static final String VARIABLEN_BEZEICHNER_KOMPLEX = "komplex";
    public static final String KLASSENBEZEICHNER = "KomplexeZahl";
    public static final Class<?> KOMPLEXE_ZAHL_CLASS = KomplexeZahl.class;
    public static final String METHODEN_BEZEICHNER_TO_STRING = "toString";
    public static final String METHODEN_BEZEICHNER_EQUALS = "equals";
    public static final String METHODEN_BEZEICHNER_ADDIEREN = "addieren";
    public static final String METHODEN_BEZEICHNER_SUBTRAHIEREN = "subtrahieren";
    public static final String METHODEN_BEZEICHNER_BETRAG = "betrag";
    public static final String METHODEN_BEZEICHNER_FINDE_GROESSTE = "findeGroesste";
    public static final double EPSILON = 1e-5;

    /**
     * Testmethode für Unteraufgabe 1
     */
    @Test
    public void testUnteraufgabe1() {

        // ADDIEREN
        Class<?>[] parameter = {KOMPLEXE_ZAHL_CLASS};
        assertTrue(
                "Klasse " + KLASSENBEZEICHNER + " hat nicht geforderte Methode "
                        + METHODEN_BEZEICHNER_ADDIEREN + ".",
                hatMethode(KOMPLEXE_ZAHL_CLASS, METHODEN_BEZEICHNER_ADDIEREN,
                        parameter));

        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_ADDIEREN + " hat falschen Rückgabetyp",
                getRueckgabeTyp(KOMPLEXE_ZAHL_CLASS, METHODEN_BEZEICHNER_ADDIEREN,
                        parameter) == KOMPLEXE_ZAHL_CLASS);

        double real1 = 23;
        double komplex1 = 42;
        Class<?>[] typen = {double.class, double.class};
        Object[] werte = {real1, komplex1};
        Object zahl1 = erzeugeInstanz(KOMPLEXE_ZAHL_CLASS, typen, werte);

        double real2 = 1;
        double komplex2 = 2;
        werte = new Object[]{real2, komplex2};
        Object zahl2 = erzeugeInstanz(KOMPLEXE_ZAHL_CLASS, typen, werte);

        Object[] argumente = {zahl2};
        Object rueckgabe = werteMethodeAus(zahl1, METHODEN_BEZEICHNER_ADDIEREN,
                parameter, argumente);
        double realRueckgabe = (Double) getWertObjektVariable(rueckgabe,
                VARIABLEN_BEZEICHNER_REAL);
        double komplexRueckgabe = (Double) getWertObjektVariable(rueckgabe,
                VARIABLEN_BEZEICHNER_KOMPLEX);
        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_ADDIEREN
                        + " liefert falschen Real-Wert.",
                Math.abs(realRueckgabe - (real1 + real2)) < EPSILON);
        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_ADDIEREN
                        + " liefert falschen Komplex-Wert.",
                Math.abs(komplexRueckgabe - (komplex1 + komplex2)) < EPSILON);

        // SUBTRAIEREN
        assertTrue(
                "Klasse " + KLASSENBEZEICHNER + " hat nicht geforderte Methode "
                        + METHODEN_BEZEICHNER_SUBTRAHIEREN + ".",
                hatMethode(KOMPLEXE_ZAHL_CLASS, METHODEN_BEZEICHNER_SUBTRAHIEREN,
                        parameter));

        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_SUBTRAHIEREN
                        + " hat falschen Rückgabetyp",
                getRueckgabeTyp(KOMPLEXE_ZAHL_CLASS, METHODEN_BEZEICHNER_SUBTRAHIEREN,
                        parameter) == KOMPLEXE_ZAHL_CLASS);

        real1 = 23;
        komplex1 = 42;
        werte = new Object[]{real1, komplex1};
        zahl1 = erzeugeInstanz(KOMPLEXE_ZAHL_CLASS, typen, werte);

        real2 = 1;
        komplex2 = 2;
        werte = new Object[]{real2, komplex2};
        zahl2 = erzeugeInstanz(KOMPLEXE_ZAHL_CLASS, typen, werte);

        argumente = new Object[]{zahl2};
        rueckgabe = werteMethodeAus(zahl1, METHODEN_BEZEICHNER_SUBTRAHIEREN,
                parameter, argumente);
        realRueckgabe = (Double) getWertObjektVariable(rueckgabe,
                VARIABLEN_BEZEICHNER_REAL);
        komplexRueckgabe = (Double) getWertObjektVariable(rueckgabe,
                VARIABLEN_BEZEICHNER_KOMPLEX);
        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_SUBTRAHIEREN
                        + " liefert falschen Real-Wert.",
                Math.abs(realRueckgabe - (real1 - real2)) < EPSILON);
        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_SUBTRAHIEREN
                        + " liefert falschen Komplex-Wert.",
                Math.abs(komplexRueckgabe - (komplex1 - komplex2)) < EPSILON);
    }

    /**
     * Testmethode für Unteraufgabe 2
     */
    @Test
    public void testUnteraufgabe2() {
        Class<?>[] parameter = {};
        assertTrue(
                "Klasse " + KLASSENBEZEICHNER + " hat nicht geforderte Methode "
                        + METHODEN_BEZEICHNER_BETRAG + ".",
                hatMethode(KOMPLEXE_ZAHL_CLASS, METHODEN_BEZEICHNER_BETRAG, parameter));

        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_BETRAG + " hat falschen Rückgabetyp",
                getRueckgabeTyp(KOMPLEXE_ZAHL_CLASS, METHODEN_BEZEICHNER_BETRAG,
                        parameter) == double.class);

        // 1+1i
        double real1 = 1;
        double komplex1 = 1;
        Class<?>[] typen = {double.class, double.class};
        Object[] werte = {real1, komplex1};
        Object zahl = erzeugeInstanz(KOMPLEXE_ZAHL_CLASS, typen, werte);
        double rueckgabe = (Double) werteMethodeAus(zahl,
                METHODEN_BEZEICHNER_BETRAG);
        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_BETRAG + " liefert falschen Wert.",
                Math.abs(rueckgabe - Math.sqrt(2)) < EPSILON);

        // 4+3i
        real1 = 4;
        komplex1 = 3;
        werte = new Object[]{real1, komplex1};
        zahl = erzeugeInstanz(KOMPLEXE_ZAHL_CLASS, typen, werte);
        rueckgabe = (Double) werteMethodeAus(zahl, METHODEN_BEZEICHNER_BETRAG);
        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_BETRAG + " liefert falschen Wert.",
                Math.abs(rueckgabe - 5) < EPSILON);
    }

    /**
     * Testmethode für Unteraufgabe 3
     */
    @Test
    public void testUnteraufgabe3() {
        Class<?>[] parameter = {};
        assertTrue(
                "Klasse " + KLASSENBEZEICHNER + " hat nicht geforderte Methode "
                        + METHODEN_BEZEICHNER_TO_STRING + ".",
                hatMethode(KOMPLEXE_ZAHL_CLASS, METHODEN_BEZEICHNER_TO_STRING,
                        parameter));

        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_TO_STRING
                        + " hat falschen Rückgabetyp",
                getRueckgabeTyp(KOMPLEXE_ZAHL_CLASS, METHODEN_BEZEICHNER_TO_STRING,
                        parameter) == String.class);

        double real = 23.6;
        double komplex = 42.947834;
        Class<?>[] typen = {double.class, double.class};
        Object[] werte = {real, komplex};
        Object zahl = erzeugeInstanz(KOMPLEXE_ZAHL_CLASS, typen, werte);
        Object rueckgabe = werteMethodeAus(zahl, METHODEN_BEZEICHNER_TO_STRING);
        String toStringRueckgabe = (String) rueckgabe;
        assertEquals(
                "Methode " + METHODEN_BEZEICHNER_TO_STRING + " liefert falschen Wert",
                "\u2102: 23,60 + 42,95i", toStringRueckgabe);
    }

    /**
     * Testmethode für Unteraufgabe 4
     */
    @Test
    public void testUnteraufgabe4() {
        Class<?>[] parameter = {Object.class};
        assertTrue(
                "Klasse " + KLASSENBEZEICHNER + " hat nicht geforderte Methode "
                        + METHODEN_BEZEICHNER_EQUALS + ".",
                hatMethode(KOMPLEXE_ZAHL_CLASS, METHODEN_BEZEICHNER_EQUALS, parameter));

        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_EQUALS + " hat falschen Rückgabetyp",
                getRueckgabeTyp(KOMPLEXE_ZAHL_CLASS, METHODEN_BEZEICHNER_EQUALS,
                        parameter) == boolean.class);

        double real1 = 23.6;
        double komplex1 = 42.947834;
        Class<?>[] typen = {double.class, double.class};
        Object[] werte = {real1, komplex1};
        Object zahl1 = erzeugeInstanz(KOMPLEXE_ZAHL_CLASS, typen, werte);

        double real2 = 23.6;
        double komplex2 = 42.947835;
        werte = new Object[]{real2, komplex2};
        Object zahl2 = erzeugeInstanz(KOMPLEXE_ZAHL_CLASS, typen, werte);

        double real3 = 23.6;
        double komplex3 = 42.1;
        werte = new Object[]{real3, komplex3};
        Object zahl3 = erzeugeInstanz(KOMPLEXE_ZAHL_CLASS, typen, werte);

        double real4 = 1;
        double komplex4 = 42.947835;
        werte = new Object[]{real4, komplex4};
        Object zahl4 = erzeugeInstanz(KOMPLEXE_ZAHL_CLASS, typen, werte);

        Object[] argumente = {zahl2};
        Object rueckgabe = werteMethodeAus(zahl1, METHODEN_BEZEICHNER_EQUALS,
                parameter, argumente);
        boolean booleanRueckgabe = (Boolean) rueckgabe;
        assertEquals("Methode " + METHODEN_BEZEICHNER_EQUALS
                + " liefert falschen Rückgabewert.", true, booleanRueckgabe);

        argumente = new Object[]{zahl3};
        rueckgabe = werteMethodeAus(zahl1, METHODEN_BEZEICHNER_EQUALS, parameter,
                argumente);
        booleanRueckgabe = (Boolean) rueckgabe;
        assertEquals("Methode " + METHODEN_BEZEICHNER_EQUALS
                + " liefert falschen Rückgabewert.", false, booleanRueckgabe);

        argumente = new Object[]{zahl4};
        rueckgabe = werteMethodeAus(zahl1, METHODEN_BEZEICHNER_EQUALS, parameter,
                argumente);
        booleanRueckgabe = (Boolean) rueckgabe;
        assertEquals("Methode " + METHODEN_BEZEICHNER_EQUALS
                + " liefert falschen Rückgabewert.", false, booleanRueckgabe);

        argumente = new Object[]{"Test"};
        rueckgabe = werteMethodeAus(zahl1, METHODEN_BEZEICHNER_EQUALS, parameter,
                argumente);
        booleanRueckgabe = (Boolean) rueckgabe;
        assertEquals("Methode " + METHODEN_BEZEICHNER_EQUALS
                + " liefert falschen Rückgabewert.", false, booleanRueckgabe);

        argumente = new Object[]{null};
        rueckgabe = werteMethodeAus(zahl1, METHODEN_BEZEICHNER_EQUALS, parameter,
                argumente);
        booleanRueckgabe = (Boolean) rueckgabe;
        assertEquals("Methode " + METHODEN_BEZEICHNER_EQUALS
                + " liefert falschen Rückgabewert.", false, booleanRueckgabe);
    }

    /**
     * Testmethode für Unteraufgabe 5
     */
    @Test
    public void testUnteraufgabe5() {
        Class<?>[] konstruktorParameter = new Class<?>[]{double.class,
                double.class};

        KomplexeZahl zahl1 = (KomplexeZahl) erzeugeInstanz(KOMPLEXE_ZAHL_CLASS,
                konstruktorParameter, new Object[]{23, 42});
        KomplexeZahl zahl2 = (KomplexeZahl) erzeugeInstanz(KOMPLEXE_ZAHL_CLASS,
                konstruktorParameter, new Object[]{1, 2});
        KomplexeZahl zahl3 = (KomplexeZahl) erzeugeInstanz(KOMPLEXE_ZAHL_CLASS,
                konstruktorParameter, new Object[]{42, 42});
        KomplexeZahl zahl4 = (KomplexeZahl) erzeugeInstanz(KOMPLEXE_ZAHL_CLASS,
                konstruktorParameter, new Object[]{3, 4});
        KomplexeZahl zahl5 = (KomplexeZahl) erzeugeInstanz(KOMPLEXE_ZAHL_CLASS,
                konstruktorParameter, new Object[]{23, 23});

        Class<?>[] parameter = {KomplexeZahl[].class};
        Object[] argumente = new Object[]{
                new KomplexeZahl[]{zahl1, zahl2, zahl3, zahl4, zahl5}};
        KomplexeZahl groesste = (KomplexeZahl) werteStatischeMethodeAus(
                KOMPLEXE_ZAHL_CLASS, METHODEN_BEZEICHNER_FINDE_GROESSTE, parameter,
                argumente);
        assertEquals("Methode " + METHODEN_BEZEICHNER_FINDE_GROESSTE
                + " liefert falschen Wert", groesste, zahl3);

        // !null
        assertNotNull("Methode " + METHODEN_BEZEICHNER_FINDE_GROESSTE
                + " liefert falschen Wert", groesste);

        argumente = new Object[]{
                new KomplexeZahl[]{zahl1, zahl2, zahl4, zahl5}};
        groesste = (KomplexeZahl) werteStatischeMethodeAus(KOMPLEXE_ZAHL_CLASS,
                METHODEN_BEZEICHNER_FINDE_GROESSTE, parameter, argumente);
        assertEquals("Methode " + METHODEN_BEZEICHNER_FINDE_GROESSTE
                + " liefert falschen Wert", groesste, zahl1);

        argumente = new Object[]{new KomplexeZahl[]{zahl2, zahl4, zahl5}};
        groesste = (KomplexeZahl) werteStatischeMethodeAus(KOMPLEXE_ZAHL_CLASS,
                METHODEN_BEZEICHNER_FINDE_GROESSTE, parameter, argumente);
        assertEquals("Methode " + METHODEN_BEZEICHNER_FINDE_GROESSTE
                + " liefert falschen Wert", groesste, zahl5);

        argumente = new Object[]{new KomplexeZahl[]{}};
        groesste = (KomplexeZahl) werteStatischeMethodeAus(KOMPLEXE_ZAHL_CLASS,
                METHODEN_BEZEICHNER_FINDE_GROESSTE, parameter, argumente);
        assertEquals("Methode " + METHODEN_BEZEICHNER_FINDE_GROESSTE
                + " liefert falschen Wert", groesste, null);
    }

}
