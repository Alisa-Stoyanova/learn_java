package jnk.laborpruefung.midterm.aufgabe2;

import jnk.laborpruefung.midterm.LaborpruefungException;
import jnk.laborpruefung.midterm.TestBasisklasse;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse für die Klasse Tupel (Aufgabe 2)
 */
public class TestTupel extends TestBasisklasse {

    private static final String NAME_KLASSE_TUPEL = "Tupel";
    private static final String NAME_VARIABLE_ZAHL = "zahl";
    private static final String NAME_VARIABLE_ZEICHEN = "zeichen";
    private static final String NAME_METHODE_GET_ZAHL = "getZahl";
    private static final String NAME_METHODE_GET_ZEICHEN = "getZeichen";
    private static final String NAME_METHODE_ZUSAMMEN = "zusammen";
    private static final String NAME_METHODE_FLIP = "flip";

    /**
     * Liefert das Class-Objekt für die Tupel-Klasse. Liefert null, wenn die Klasse nicht gefunden wurde.
     */
    private Class<?> getKlassenobjekt() {
        String packageName = TestTupel.class.getPackageName();
        try {
            return Class.forName(packageName + "." + NAME_KLASSE_TUPEL);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    @Test
    public void testObjektvariablen() {
        Class<?> klasseTupel = getKlassenobjekt();
        assertNotNull(klasseTupel, "Klasse " + NAME_KLASSE_TUPEL + " nicht gefunden.");
        assertTrue(hatObjektVariable(klasseTupel, NAME_VARIABLE_ZAHL, int.class),
                "Objektvariable " + NAME_VARIABLE_ZAHL + " nicht gefunden.");
        assertTrue(objektvariableHatModifizierer(klasseTupel, NAME_VARIABLE_ZAHL, istPrivate),
                "Variable " + NAME_VARIABLE_ZAHL + " hat falsche Sichtbarkeit");
        assertTrue(hatObjektVariable(klasseTupel, NAME_VARIABLE_ZEICHEN, char.class),
                "Variable " + NAME_VARIABLE_ZEICHEN + " nicht gefunden.");
        assertTrue(objektvariableHatModifizierer(klasseTupel, NAME_VARIABLE_ZEICHEN, istPrivate),
                "Variable " + NAME_VARIABLE_ZEICHEN + " hat falsche Sichtbarkeit");
    }

    @Test
    public void testKonstruktorGetter() {
        testObjektvariablen();
        Class<?> klasseTupel = getKlassenobjekt();

        // Konstruktor
        Class<?>[] konstruktorParams = {int.class, char.class};
        assertTrue(hatKonstruktor(klasseTupel, konstruktorParams), "Konstruktor nicht gefunden");
        assertTrue(konstruktorHatModifizierer(klasseTupel, konstruktorParams, istPublic),
                "Konstruktor hat falsche Sichtbarkeit");

        // Getter: zahl
        Class<?>[] getterParams = {};
        assertTrue(hatMethode(klasseTupel, NAME_METHODE_GET_ZAHL, getterParams), "Getter " +
                NAME_METHODE_GET_ZAHL + " nicht gefunden.");
        assertTrue(methodeHatModifizierer(klasseTupel, NAME_METHODE_GET_ZAHL, getterParams, istPublic),
                "Getter " + NAME_METHODE_GET_ZAHL + " hat falsche Sichtbarkeit");

        // Getter: zeichen
        assertTrue(hatMethode(klasseTupel, NAME_METHODE_GET_ZEICHEN, getterParams), "Getter " +
                NAME_VARIABLE_ZEICHEN + " nicht gefunden.");
        assertTrue(methodeHatModifizierer(klasseTupel, NAME_METHODE_GET_ZEICHEN, getterParams, istPublic), "Getter " +
                NAME_VARIABLE_ZEICHEN + " hat falsche Sichtbarkeit");
    }

    @Test
    public void testZusammen() {
        Class<?> klasseTupel = getKlassenobjekt();
        assertNotNull(klasseTupel, "Klasse " + NAME_KLASSE_TUPEL + " nicht gefunden.");
        Class<?>[] params = {klasseTupel};
        assertTrue(hatMethode(klasseTupel, NAME_METHODE_ZUSAMMEN, params), "Klasse Tupel hat nicht die " +
                "Methode " + NAME_METHODE_ZUSAMMEN);
        assertTrue(methodeHatModifizierer(klasseTupel, NAME_METHODE_ZUSAMMEN, params, istPublic), "Methode " +
                NAME_METHODE_ZUSAMMEN + " hat nicht die geforderte Sichtbarkeit");

        List<Object> baseObjects = Arrays.asList(makeTupel(23, 'a'), makeTupel(-2, 'k'),
                makeTupel(23, 'a'), makeTupel(-1, 'z'), makeTupel(5, 'g')
        );
        List<Object> argObjects = Arrays.asList(makeTupel(42, 'c'), makeTupel(3, 'b'),
                null, makeTupel(-1, 'z'), makeTupel(5, 'f'));
        List<Object> expected = Arrays.asList(makeTupel(65, 'a'), makeTupel(1, 'b'),
                makeTupel(23, 'a'), makeTupel(-2, 'z'), makeTupel(10, 'f'));

        try {
            for (int i = 0; i < baseObjects.size(); i++) {
                Object z = methodeAufrufen(baseObjects.get(i), NAME_METHODE_ZUSAMMEN, params, new Object[]{argObjects.get(i)});
                assertNotEquals(z, baseObjects.get(i), "Rückgabe bei Argument null muss Kopie sein");
                assertTrue(inhaltlichGleich(expected.get(i), z), "Methode " + NAME_METHODE_ZUSAMMEN +
                        " liefert falsches " +
                        "Objekt.");
            }
        } catch (LaborpruefungException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Prüft, ob die beiden Tupel-Objekte inhaltlich gleich sind.
     */
    private boolean inhaltlichGleich(Object t1, Object t2) throws LaborpruefungException {
        try {
            int zahl1 = (Integer) getWertObjektVariable(t1, NAME_VARIABLE_ZAHL);
            int zahl2 = (Integer) getWertObjektVariable(t2, NAME_VARIABLE_ZAHL);
            int zeichen1 = (Character) getWertObjektVariable(t1, NAME_VARIABLE_ZEICHEN);
            int zeichen2 = (Character) getWertObjektVariable(t2, NAME_VARIABLE_ZEICHEN);
            return zahl1 == zahl2 && zeichen1 == zeichen2;
        } catch (LaborpruefungException e) {
            return false;
        }
    }

    /**
     * Erzeuge ein Tupel-Objekt aus den beiden Werten.
     */
    private Object makeTupel(int zahl, char zeichen) {
        Class<?> klasseTupel = getKlassenobjekt();
        Class<?>[] params = {int.class, char.class};
        try {
            return erzeugeInstanz(klasseTupel, params, new Object[]{zahl, zeichen});
        } catch (LaborpruefungException e) {
            return null;
        }
    }

    @Test
    public void testFlip() {
        Class<?> klasseTupel = getKlassenobjekt();
        assertNotNull(klasseTupel, "Klasse " + NAME_KLASSE_TUPEL + " nicht gefunden.");
        Class<?>[] params = {};
        assertTrue(hatMethode(klasseTupel, NAME_METHODE_FLIP, params), "Klasse Tupel hat nicht die " +
                "Methode " + NAME_METHODE_FLIP);
        assertTrue(methodeHatModifizierer(klasseTupel, NAME_METHODE_FLIP, params, istPublic), "Methode " +
                NAME_METHODE_FLIP + " hat nicht die geforderte Sichtbarkeit");

        List<Object> baseObjects = Arrays.asList(makeTupel(100, 'a'), makeTupel(-1, 'c'),
                makeTupel(300, '\u007E'));
        List<Object> expected = Arrays.asList(makeTupel(97, 'd'), makeTupel(99, '\u0000'),
                makeTupel(126, '\u007F'));


        try {
            for (int i = 0; i < baseObjects.size(); i++) {
                methodeAufrufen(baseObjects.get(i), NAME_METHODE_FLIP, params, new Object[]{});
                assertTrue(inhaltlichGleich(expected.get(i), baseObjects.get(i)), "Methode " + NAME_METHODE_FLIP +
                        " arbeitet nicht korrekt.");
            }
        } catch (LaborpruefungException laborpruefungException) {
            assertTrue(false, "Fehler beim Ausführen der Methode " + NAME_METHODE_FLIP);
        }
    }
}
