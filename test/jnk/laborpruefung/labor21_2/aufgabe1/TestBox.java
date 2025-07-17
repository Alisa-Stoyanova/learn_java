package jnk.laborpruefung.labor21_2.aufgabe1;

import jnk.laborpruefung.labor21_2.LaborpruefungException;
import jnk.laborpruefung.labor21_2.TestBasisklasse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse zur Aufgabe 1.
 */
public class TestBox extends TestBasisklasse {

    private static final String NAME_KLASSE_BOX = "Box";
    private static final String BEZEICHNER_VARIABLE_INHALT = "inhalt";
    private static final String BEZEICHNER_METHODE_TOSTRING = "toString";
    private static final String BEZEICHNER_METHODE_GET_GROESSSE = "getGroesse";
    private static final String BEZEICHNER_METHODE_ZUSAMMENLEGEN = "zusammenlegen";
    private static final Class<?>[] konstruktorParamTypen = new Class<?>[]{int.class, String.class};
    private static final Class<?>[] toStringParamTypes = new Class<?>[]{};

    /**
     * Liefert das Class-Objekt für die Box-Klasse. Liefert null, wenn die Klasse nicht gefunden wurde.
     */
    private Class<?> getKlassenobjekt() {
        String packageName = TestBox.class.getPackageName();
        try {
            return Class.forName(packageName + "." + NAME_KLASSE_BOX);
        } catch (ClassNotFoundException e) {
            assertNotNull(null, "Klasse Box nicht definiert.");
            return null;
        }
    }

    @Test
    public void testKlasseUndInhalt() {
        Class<?> boxClass = getKlassenobjekt();
        assertNotNull(boxClass, "Klasse " + NAME_KLASSE_BOX + " nicht gefunden");
        assertTrue(erbtVon(boxClass, Ding.class), "Klasse " + NAME_KLASSE_BOX + " ist kein Ding");
        assertTrue(hatObjektVariable(boxClass, BEZEICHNER_VARIABLE_INHALT, String.class), "Klasse " +
                NAME_KLASSE_BOX + " " +
                "hat nicht die geforderte Objektvariable " + BEZEICHNER_VARIABLE_INHALT);
        assertTrue(objektvariableHatModifizierer(boxClass, BEZEICHNER_VARIABLE_INHALT, istPrivate),
                "Variable " + BEZEICHNER_VARIABLE_INHALT + " hat nicht die richtige Sichtbarkeit.");
    }

    @Test
    public void testKonstruktor() {
        Class<?> boxClass = getKlassenobjekt();
        assertTrue(hatKonstruktor(boxClass, konstruktorParamTypen), "Klasse " + NAME_KLASSE_BOX
                + " hat nicht den " +
                "geforderten Konstruktor.");
        try {
            String sollInhalt = "Laborprüfung";
            int sollGroesse = 3;
            Object box = makeBox(sollGroesse, sollInhalt);
            assertNotNull(boxClass, "Konstruktor von " + NAME_KLASSE_BOX + " erzeugte kein Objekt.");
            Object ist = getWertObjektVariable(box, BEZEICHNER_VARIABLE_INHALT);
            assertEquals(sollGroesse, methodeAufrufen(box, BEZEICHNER_METHODE_GET_GROESSSE, new Class<?>[]{}, new Object[]{}),
                    "Box-Objekt hat falsche Größe");
            assertEquals(sollInhalt, ist, "Variable " + BEZEICHNER_VARIABLE_INHALT
                    + " hat falschen Wert nach Konstruktoraufruf.");
        } catch (LaborpruefungException e) {
            assertTrue(false, "Fehler beim Aufrufen des Konstruktors von " + NAME_KLASSE_BOX + ": "
                    + e.getMessage());
        }
    }

    @Test
    public void testToString() {
        try {
            Class<?> boxClass = getKlassenobjekt();
            assertNotNull(boxClass, "Klasse Box nicht definiert.");
            assertTrue(hatMethode(boxClass, BEZEICHNER_METHODE_TOSTRING, toStringParamTypes),
                    "Methode " + BEZEICHNER_METHODE_TOSTRING + " nicht gefunden.");
            assertTrue(methodeHatModifizierer(boxClass, BEZEICHNER_METHODE_TOSTRING, toStringParamTypes, istPublic),
                    "Methode " + BEZEICHNER_METHODE_TOSTRING + " hat nicht den richtigen Modizizierer.");
            assertEquals(String.class, getRueckgabeTyp(boxClass, BEZEICHNER_METHODE_TOSTRING, toStringParamTypes),
                    "Methode " + BEZEICHNER_METHODE_TOSTRING + " hat falschen Rückgabetyp");
            List<String> inhalte = Arrays.asList("Bohnen", "nix", "", "Box");
            for (String inhalt : inhalte) {
                int groesse = (int) (Math.random() * 10) + 1;
                Object box = makeBox(groesse, inhalt);
                Object ist = methodeAufrufen(box, BEZEICHNER_METHODE_TOSTRING, toStringParamTypes, new Object[]{});
                assertEquals("Box mit " + inhalt, ist, "Methode " + BEZEICHNER_METHODE_TOSTRING
                        + " liefert falschen Wert.");
            }
        } catch (LaborpruefungException e) {
            assertTrue(false, "Fehler beim Aufrufen von " + BEZEICHNER_METHODE_TOSTRING);
        }
    }

    @Test
    public void testZusammenlegenSignatur() {
        try {
            Class<?> boxClass = getKlassenobjekt();
            Class<?>[] zusammenlegenParamTypes = new Class<?>[]{boxClass};
            assertTrue(hatMethode(boxClass, BEZEICHNER_METHODE_ZUSAMMENLEGEN, zusammenlegenParamTypes),
                    "Methode " + BEZEICHNER_METHODE_ZUSAMMENLEGEN + " nicht gefunden.");
            assertTrue(methodeHatModifizierer(boxClass, BEZEICHNER_METHODE_ZUSAMMENLEGEN, zusammenlegenParamTypes, istPublic),
                    "Methode " + BEZEICHNER_METHODE_ZUSAMMENLEGEN + " hat nicht den richtigen Modifizierer.");
            assertEquals(boxClass, getRueckgabeTyp(boxClass, BEZEICHNER_METHODE_ZUSAMMENLEGEN, zusammenlegenParamTypes),
                    "Methode " + BEZEICHNER_METHODE_ZUSAMMENLEGEN + " hat falschen Rückgabetyp");
        } catch (LaborpruefungException e) {
            assertTrue(false, "Fehler bei der Methode " + BEZEICHNER_METHODE_ZUSAMMENLEGEN);
        }
    }

    @Test
    public void testZusammenlegenImplementierung() {
        Class<?> boxClass = getKlassenobjekt();
        Class<?>[] zusammenlegenParamTypes = new Class<?>[]{boxClass};

        // Testfälle
        List<Ding> thisBoxen = new ArrayList<>();
        List<Ding> argumentBoxen = new ArrayList<>();
        {
            thisBoxen.add(makeBox(2, "A"));
            argumentBoxen.add(makeBox(2, "B"));
        }
        {
            thisBoxen.add(makeBox(2, "A"));
            argumentBoxen.add(makeBox(3, ""));
        }
        {
            thisBoxen.add(makeBox(3, ""));
            argumentBoxen.add(makeBox(2, ""));
        }

        runZusammenlegenTestfaelle(zusammenlegenParamTypes, thisBoxen, argumentBoxen);

    }

    @Test
    public void testZusammenlegenImplementierungNullArgument() {
        Class<?> boxClass = getKlassenobjekt();
        Class<?>[] zusammenlegenParamTypes = new Class<?>[]{boxClass};

        // Testfälle
        List<Ding> thisBoxen = new ArrayList<>();
        List<Ding> argumentBoxen = new ArrayList<>();
        {
            thisBoxen.add(makeBox(2, "A"));
            argumentBoxen.add(null);
        }

        runZusammenlegenTestfaelle(zusammenlegenParamTypes, thisBoxen, argumentBoxen);
    }

    /**
     * Erzeugt eine Box mit dem gegebenen Inhalt.
     */
    private Ding makeBox(int groesse, String inhalt) {
        Class<?> boxClass = getKlassenobjekt();
        try {
            return (Ding) erzeugeInstanz(boxClass, konstruktorParamTypen, new Object[]{groesse, inhalt});
        } catch (LaborpruefungException e) {
            return null;
        }
    }

    /**
     * Liefert den Inhalt eines Box-Objektes
     */
    private String getInhalt(Object box) {
        Class<?> boxClass = getKlassenobjekt();
        try {
            return (String) getWertObjektVariable(box, BEZEICHNER_VARIABLE_INHALT);
        } catch (LaborpruefungException e) {
            return null;
        }
    }

    /**
     * Führt die Testfälle für die Methode zusammenlegen aus.
     */
    private void runZusammenlegenTestfaelle(Class<?>[] zusammenlegenParamTypes, List<Ding> thisBoxen, List<Ding> argumentBoxen) {
        try {
            for (int i = 0; i < thisBoxen.size(); i++) {
                if (argumentBoxen.get(i) == null) {
                    try {
                        Ding ist = (Ding) methodeAufrufenExceptionErwartet(thisBoxen.get(i), BEZEICHNER_METHODE_ZUSAMMENLEGEN,
                                zusammenlegenParamTypes,
                                new Object[]{argumentBoxen.get(i)});
                        assertTrue(false, "IllegalArgumentException in Methode "
                                + BEZEICHNER_METHODE_ZUSAMMENLEGEN + " erwartet.");
                    } catch (Throwable e) {
                        assertTrue(e instanceof IllegalArgumentException,
                                "IllegalArgumentException in Methode " + BEZEICHNER_METHODE_ZUSAMMENLEGEN + " erwartet.");
                    }
                } else {
                    Ding ist = (Ding) methodeAufrufen(thisBoxen.get(i), BEZEICHNER_METHODE_ZUSAMMENLEGEN,
                            zusammenlegenParamTypes,
                            new Object[]{argumentBoxen.get(i)});
                    assertNotNull(ist, "Rückgabeobjekt von " + BEZEICHNER_METHODE_ZUSAMMENLEGEN + "ist null");
                    assertEquals(thisBoxen.get(i).getGroesse() + argumentBoxen.get(i).getGroesse(), ist.getGroesse(),
                            "Rückgabeobjekt von " + BEZEICHNER_METHODE_ZUSAMMENLEGEN + " hat die falsche Größe");
                    assertEquals(getInhalt(thisBoxen.get(i)) + "+" + getInhalt(argumentBoxen.get(i)), getInhalt(ist),
                            "Rückgabebox von " + BEZEICHNER_METHODE_ZUSAMMENLEGEN + " hat falschen Inhalt");
                }
            }
        } catch (LaborpruefungException e) {
            assertTrue(false, "Fehler beim Ausführen der Methode " + BEZEICHNER_METHODE_ZUSAMMENLEGEN + ": " + e);
        }
    }
}
