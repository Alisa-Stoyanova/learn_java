package jnk.laborpruefung.probe.aufgabe3;

import jnk.laborpruefung.probe.LaborpruefungException;
import jnk.laborpruefung.probe.TestBasisklasse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse für die Klasse Auto
 */
public class TestAufgabe3 extends TestBasisklasse {

    private static final String PACKAGENAME = Fahrzeug.class.getPackageName();
    public static final String CLASS_NAME_AUTO = "Auto";
    private static final String VAR_NAME_ANZAHL_TUEREN = "anzahlTueren";
    private static final String METHOD_NAME_GET_ANZAHL_TUEREN = "getAnzahlTueren";
    private static final Class<?>[] constructorParamTypesAuto =
            new Class[]{String.class, String.class, int.class, int.class};
    public static final String CLASS_NAME_MOTORRAD = "Motorrad";
    private static final String VAR_NAME_HAT_BEIWAGEN = "hatBeiwagen";
    private static final String METHOD_NAME_GET_HAT_BEIWAGEN = "getHatBeiwagen";
    private static final Class<?>[] constructorParamTypesMotorrad =
            new Class[]{String.class, String.class, int.class, boolean.class};

    // +++++++++++++++++++++++++++++++++++ Werkstatt ++++++++++++++++++++++++++++++++++

    @Test
    public void testErstelleFahrzeug() {
        Fahrzeug auto = Werkstatt.erstelleFahrzeug(Werkstatt.Typ.AUTO);
        assertNotNull(auto, "Generiertes Auto-Objekt ungültig.");
        assertEquals(TestAufgabe3.getClassAuto(), auto.getClass(),
                "Fehler bei Generieren eines Auto-Objektes.");

        Fahrzeug motorrad = Werkstatt.erstelleFahrzeug(Werkstatt.Typ.MOTORRAD);
        assertNotNull(motorrad, "Generiertes Auto-Objekt ungültig.");
        assertEquals(getClassMotorrad(), motorrad.getClass(),
                "Fehler bei Generieren eines Auto-Objektes.");
    }

    @Test
    public void testErstelleFahrzeugUngueltig() {
        assertThrows(IllegalArgumentException.class, () -> {
            Werkstatt.erstelleFahrzeug(Werkstatt.Typ.BAGGER);
        }, "Exception bei erstelleFahrzeug erwartet.");
    }

    @Test
    public void testGetAnzahlTueren() {
        String marke = "VW";
        String modell = "Käfer";
        int baujahr = 1999;
        int anzahlTueren = 7;
        Fahrzeug auto = TestAufgabe3.makeAuto(marke, modell, baujahr, anzahlTueren);
        assertEquals(anzahlTueren, Werkstatt.getAnzahlTueren(auto), "Fehler beim Auslesen der Anzahl an Türen");
    }

    @Test
    public void testGetAnzahlTuerenInvalid() {
        String marke = "VW";
        String modell = "Käfer";
        int baujahr = 1999;
        boolean hatBeisitzer = false;
        Fahrzeug motorrad = makeMotorrad(marke, modell, baujahr, hatBeisitzer);
        assertThrows(IllegalArgumentException.class, () -> Werkstatt.getAnzahlTueren(motorrad),
                "Fehler beim Auslesen der Anzahl an Türen");
    }

    // ++++++++++++++++++++++++++++++++++ Motorad ++++++++++++++++++++++++++++

    @Test
    public void testKlasseMotorrad() {
        Class<?> classMotorrad = getClassMotorrad();

        // Klasse vorhanden?
        assertNotNull(classMotorrad, "Klasse Motorrad nicht gefunden.");

        // Erbt von Fahrzeug
        assertTrue(erbtVon(classMotorrad, Fahrzeug.class), CLASS_NAME_MOTORRAD + " erbt nicht von Fahrzeug.");

        // Objektvariable
        assertTrue(hatObjektVariable(classMotorrad, VAR_NAME_HAT_BEIWAGEN, boolean.class),
                "Objektvariable fehlerhaft");
        assertTrue(objektvariableHatModifizierer(classMotorrad, VAR_NAME_HAT_BEIWAGEN, istPrivate),
                "Objektvariable " + VAR_NAME_HAT_BEIWAGEN + " hat falsche Sichtbarkeit.");
        assertEquals(boolean.class, getTypObjektvariable(classMotorrad, VAR_NAME_HAT_BEIWAGEN),
                "Objektvariable " + VAR_NAME_HAT_BEIWAGEN + " hat falschen Typ.");

        // Konstruktor
        assertTrue(hatKonstruktor(classMotorrad, constructorParamTypesMotorrad), "Fehlerhafter Konstruktor");
        assertTrue(konstruktorHatModifizierer(classMotorrad, constructorParamTypesMotorrad, istPublic),
                "Fehlerhafter Konstruktor");

        // Getter
        Class<?>[] getterParamTypes = new Class[]{};
        assertTrue(hatMethode(classMotorrad, METHOD_NAME_GET_HAT_BEIWAGEN, getterParamTypes),
                "Methode " + METHOD_NAME_GET_HAT_BEIWAGEN + " fehlerhaft");
        try {
            assertEquals(boolean.class, getRueckgabeTyp(classMotorrad, METHOD_NAME_GET_HAT_BEIWAGEN, getterParamTypes),
                    "Methode " + METHOD_NAME_GET_HAT_BEIWAGEN + " fehlerhaft");
        } catch (LaborpruefungException e) {
            fail("Methode " + METHOD_NAME_GET_HAT_BEIWAGEN + " fehlerhaft");
        }
        assertTrue(methodeHatModifizierer(classMotorrad, METHOD_NAME_GET_HAT_BEIWAGEN, getterParamTypes, istPublic),
                "Fehlerhafte Sichtbarkeit bei Methode " + METHOD_NAME_GET_HAT_BEIWAGEN);

        // Laufzeittest
        Object motorrad = null;
        String marke = "VW";
        String modell = "Käfer";
        int baujahr = 1999;
        boolean hatBeiwagen = true;
        motorrad = makeMotorrad(marke, modell, baujahr, hatBeiwagen);
        assertNotNull(motorrad, "Fehler beim Erzeugen eines " + CLASS_NAME_MOTORRAD + "-Objektes.");
        try {
            Fahrzeug fahrzeug = (Fahrzeug) motorrad;

            // Aus Fahrzeug
            assertEquals(marke, fahrzeug.getMarke(), "Falscher Wert bei Objektvariable");
            assertEquals(modell, fahrzeug.getModell(), "Falscher Wert bei Objektvariable");
            assertEquals(baujahr, fahrzeug.getBaujahr(), "Falscher Wert bei Objektvariable");

            // Aus Auto
            assertEquals(hatBeiwagen, getWertObjektVariable(motorrad, VAR_NAME_HAT_BEIWAGEN), "Falscher Wert bei Objektvariable");

            // Info-Methode
            String info = fahrzeug.getInfo();
            assertNotNull(info, "Ungültige Rückgabe der Methode getInfo().");
            assertTrue(info.contains(marke), "Marke fehlt in Rückgabe der Methode info()");
            assertTrue(info.contains(modell), "Modell fehlt in Rückgabe der Methode info()");
            assertTrue(info.contains("" + baujahr), "Baujahr fehlt in Rückgabe der Methode info()");
            assertTrue(info.contains("" + hatBeiwagen), "Anzahl Türen fehlt in Rückgabe der Methode info()");

        } catch (LaborpruefungException e) {
            fail("Fehler beim Zugriff auf eine Objektvariable.");
        }
    }

    public static Fahrzeug makeMotorrad(String marke, String modell, int baujahr, boolean hatBeiwagen) {
        try {
            Class<?> classMotorrad = getClassMotorrad();
            if (classMotorrad == null) {
                return null;
            }
            return (Fahrzeug) erzeugeInstanz(classMotorrad, constructorParamTypesMotorrad, new Object[]{marke, modell, baujahr, hatBeiwagen});
        } catch (LaborpruefungException e) {
            return null;
        }
    }


    /**
     * Return the class object for the Motorrad class (if it exists)
     */
    public static Class<?> getClassMotorrad() {
        try {
            return Class.forName(PACKAGENAME + "." + CLASS_NAME_MOTORRAD);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }


    // +++++++++++++++++++++++++++++++ Auto ++++++++++++++++++++++++++++++++++++++++

    @Test
    public void testKlasseAuto() {
        Class<?> classAuto = getClassAuto();

        // Klasse vorhanden?
        assertNotNull(classAuto, "Klasse Auto nicht gefunden.");

        // Erbt von Fahrzeug
        assertTrue(erbtVon(classAuto, Fahrzeug.class), CLASS_NAME_AUTO + " erbt nicht von Fahrzeug.");

        // Objektvariable
        assertTrue(hatObjektVariable(classAuto, VAR_NAME_ANZAHL_TUEREN, int.class),
                "Objektvariable fehlerhaft");
        assertTrue(objektvariableHatModifizierer(classAuto, VAR_NAME_ANZAHL_TUEREN, istPrivate),
                "Objektvariable " + VAR_NAME_ANZAHL_TUEREN + " hat falsche Sichtbarkeit.");
        assertEquals(int.class, getTypObjektvariable(classAuto, VAR_NAME_ANZAHL_TUEREN),
                "Objektvariable " + VAR_NAME_ANZAHL_TUEREN + " hat falschen Typ.");

        // Konstruktor

        assertTrue(hatKonstruktor(classAuto, constructorParamTypesAuto), "Fehlerhafter Konstruktor");
        assertTrue(konstruktorHatModifizierer(classAuto, constructorParamTypesAuto, istPublic),
                "Fehlerhafter Konstruktor");

        // Getter
        Class<?>[] getterParamTypes = new Class[]{};
        assertTrue(hatMethode(classAuto, METHOD_NAME_GET_ANZAHL_TUEREN, getterParamTypes),
                "Methode " + METHOD_NAME_GET_ANZAHL_TUEREN + " fehlerhaft");
        try {
            assertEquals(int.class, getRueckgabeTyp(classAuto, METHOD_NAME_GET_ANZAHL_TUEREN, getterParamTypes),
                    "Methode " + METHOD_NAME_GET_ANZAHL_TUEREN + " fehlerhaft");
        } catch (LaborpruefungException e) {
            fail("Methode " + METHOD_NAME_GET_ANZAHL_TUEREN + " fehlerhaft");
        }
        assertTrue(methodeHatModifizierer(classAuto, METHOD_NAME_GET_ANZAHL_TUEREN, getterParamTypes, istPublic),
                "Fehlerhafte Sichtbarkeit bei Methode " + METHOD_NAME_GET_ANZAHL_TUEREN);

        // Laufzeittest
        String marke = "VW";
        String modell = "Käfer";
        int baujahr = 1999;
        int anzahlTueren = 7;
        Object auto = makeAuto(marke, modell, baujahr, anzahlTueren);
        assertNotNull(auto, "Fehler beim Erzeugen eines " + CLASS_NAME_AUTO + "-Objektes.");
        try {
            Fahrzeug fahrzeug = (Fahrzeug) auto;

            // Aus Fahrzeug
            assertEquals(marke, fahrzeug.getMarke(), "Falscher Wert bei Objektvariable");
            assertEquals(modell, fahrzeug.getModell(), "Falscher Wert bei Objektvariable");
            assertEquals(baujahr, fahrzeug.getBaujahr(), "Falscher Wert bei Objektvariable");

            // Aus Auto
            assertEquals(anzahlTueren, getWertObjektVariable(auto, VAR_NAME_ANZAHL_TUEREN), "Falscher Wert bei Objektvariable");

            // Info-Methode
            String info = fahrzeug.getInfo();
            assertNotNull(info, "Ungültige Rückgabe der Methode getInfo().");
            assertTrue(info.contains(marke), "Marke fehlt in Rückgabe der Methode info()");
            assertTrue(info.contains(modell), "Modell fehlt in Rückgabe der Methode info()");
            assertTrue(info.contains("" + baujahr), "Baujahr fehlt in Rückgabe der Methode info()");
            assertTrue(info.contains("" + anzahlTueren), "Anzahl Türen fehlt in Rückgabe der Methode info()");

        } catch (LaborpruefungException e) {
            fail("Fehler beim Zugriff auf eine Objektvariable.");
        }
    }

    public static Fahrzeug makeAuto(String marke, String modell, int baujahr, int anzahlTueren) {
        try {
            Class<?> classAuto = getClassAuto();
            if (classAuto == null) {
                return null;
            }
            return (Fahrzeug) erzeugeInstanz(classAuto, constructorParamTypesAuto, new Object[]{marke, modell, baujahr, anzahlTueren});
        } catch (LaborpruefungException e) {
            return null;
        }
    }

    /**
     * Return the class object for the Auto class (if it exists)
     */
    public static Class<?> getClassAuto() {
        try {
            return Class.forName(PACKAGENAME + "." + CLASS_NAME_AUTO);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
