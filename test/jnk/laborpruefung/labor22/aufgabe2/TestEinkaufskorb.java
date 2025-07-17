package jnk.laborpruefung.labor22.aufgabe2;

import jnk.laborpruefung.labor22.LaborpruefungException;
import jnk.laborpruefung.labor22.TestBasisklasse;
import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

public class TestEinkaufskorb extends TestBasisklasse {

    private static final String CLASS_NAME_EINKAUFSKORB = "Einkaufskorb";
    private static final String VARIABLE_NAME_PRODUKTE = "produkte";
    private static final String PACKAGENAME = Behaelter.class.getPackageName();
    private static final Class<?>[] CONSTRUCTOR_PARAMS_EINKAUFSKORB = {String.class};
    private static final String METHOD_NAME_GET_BELEGT = "getBelegt";
    private static final String METHOD_NAME_EINLEGEN = "einlegen";
    private static final Class<?>[] EINLEGEN_PARAM_TYPES = {Produkt.class};
    private static final Class<?>[] GET_BELEGT_PARAM_TYPES = {};

    /**
     * Returns the class object for the class Einkaufswagen if it exists, otherwise null;
     */
    private Class<?> getClassEinkaufskorb() {
        try {
            Class<?> classEinkaufskorb = Class.forName(PACKAGENAME + "." + CLASS_NAME_EINKAUFSKORB);
            return classEinkaufskorb;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /**
     * Generate in instance of Einkaufskorb
     */
    private Object getEinkaufskorbInstance(String name) {
        Class<?> classEinkaufskorb = getClassEinkaufskorb();
        if (classEinkaufskorb == null) {
            return null;
        }
        try {
            Object instance = erzeugeInstanz(classEinkaufskorb, CONSTRUCTOR_PARAMS_EINKAUFSKORB, new Object[]{name});
            return instance;
        } catch (LaborpruefungException e) {
            return null;
        }
    }

    /**
     * This dummy product can be used to experiment witn an einkaufskorb.
     */
    private class DummyProdukt implements Produkt {

        private int volumen;

        public DummyProdukt(int volumen) {
            this.volumen = volumen;
        }

        @Override
        public String getName() {
            return "Dummy-Produkt";
        }

        @Override
        public int getVolumen() {
            return volumen;
        }
    }

    /**
     * Put the given products into the Einkaufskorb instance (replacing current content).
     */
    private void putIntoEinkaufskorb(Object einkaufskobInstance, Produkt... products) throws LaborpruefungException {
        setObjektvariable(einkaufskobInstance, VARIABLE_NAME_PRODUKTE, products);
    }

    @Test
    public void testKonstruktor() throws NoSuchMethodException, LaborpruefungException {
        // Konstruktor existiert mit korrekter Signatur, name wird an Basisklasse durchgereicht
        Class<?> classEinkaufskorb = getClassEinkaufskorb();
        assertNotNull(classEinkaufskorb, "Klasse " + CLASS_NAME_EINKAUFSKORB + " nicht gefunden.");
        assertTrue(erbtVon(classEinkaufskorb, Behaelter.class), "Klasse " + CLASS_NAME_EINKAUFSKORB + " erbt nicht wie " +
                "gefordert.");

        // Check for constructor with parameter
        Constructor<?> constructor = classEinkaufskorb.getConstructor(CONSTRUCTOR_PARAMS_EINKAUFSKORB);
        assertNotNull(constructor, "Geforderter Konstruktor nicht gefunden.");
    }

    @Test
    public void testProdukte() throws LaborpruefungException {
        // Objektvariable produkte mit korrekter Initialisierung
        Class<?> classEinkaufskorb = getClassEinkaufskorb();
        assertNotNull(classEinkaufskorb, "Klasse " + CLASS_NAME_EINKAUFSKORB + " nicht gefunden.");

        // Check for 'produkte' variable
        Class<?> typeProdukte = Produkt[].class;
        assertTrue(hatObjektVariable(classEinkaufskorb, VARIABLE_NAME_PRODUKTE, typeProdukte),
                "Objektvariable " + VARIABLE_NAME_PRODUKTE + " nicht gefunden.");
        assertTrue(objektvariableHatModifizierer(classEinkaufskorb, VARIABLE_NAME_PRODUKTE, istPrivate),
                "Variable " + VARIABLE_NAME_PRODUKTE + " hat nicht die richtige Sichtbarkeit.");

        // Check for produkte initialization
        Object einkaufskobInstance = getEinkaufskorbInstance("Einkaufskorb");
        assertNotNull(einkaufskobInstance, "Fehler bei Erzeugen eines " + CLASS_NAME_EINKAUFSKORB + " Objektes.");
        Produkt[] produkteWert = (Produkt[]) getWertObjektVariable(einkaufskobInstance, VARIABLE_NAME_PRODUKTE);
        assertEquals(0, produkteWert.length, "Objektvariable " + VARIABLE_NAME_PRODUKTE + " hat nicht die geforderte Länge");
    }

    @Test
    public void testBelegungLeer() throws LaborpruefungException {
        // leerer Einkaufskorb
        Class<?> classEinkaufskorb = getClassEinkaufskorb();
        assertNotNull(classEinkaufskorb, "Klasse " + CLASS_NAME_EINKAUFSKORB + " nicht gefunden.");
        assertTrue(hatMethode(classEinkaufskorb, METHOD_NAME_GET_BELEGT, GET_BELEGT_PARAM_TYPES),
                "Methode " + METHOD_NAME_GET_BELEGT + " nicht gefunden.");
        assertTrue(methodeHatModifizierer(classEinkaufskorb, METHOD_NAME_GET_BELEGT, GET_BELEGT_PARAM_TYPES, istPublic),
                "Methode " + METHOD_NAME_GET_BELEGT + " hat nicht geforderte Sichtbarkeit.");
        assertEquals(int.class, getRueckgabeTyp(classEinkaufskorb, METHOD_NAME_GET_BELEGT, GET_BELEGT_PARAM_TYPES),
                "Methode" +
                        " " + METHOD_NAME_GET_BELEGT + " hat nicht geforderten Rückgabetyp.");
        assertEquals(int.class, getRueckgabeTyp(classEinkaufskorb, METHOD_NAME_GET_BELEGT, GET_BELEGT_PARAM_TYPES),
                "Methode " + METHOD_NAME_GET_BELEGT + " hat falschen Rückgabetyp.");

        // Leerer Einkaufswagen
        Object einkaufskobInstance = getEinkaufskorbInstance("Einkaufskorb");
        assertNotNull(einkaufskobInstance, "Fehler bei Erzeugen eines " + CLASS_NAME_EINKAUFSKORB + " Objektes.");

        // getBelegt für leeren Einkaufswagen
        int result = (Integer) methodeAufrufen(einkaufskobInstance, METHOD_NAME_GET_BELEGT, GET_BELEGT_PARAM_TYPES,
                new Object[]{});
        assertEquals(0, result, "Methode " + METHOD_NAME_GET_BELEGT + " liefert falschen Wert bei leerem Einkaufskorb.");
    }

    @Test
    public void testBelegungMitInhalt() throws LaborpruefungException {
        // Einkaufskorb mit 2 Produkten unterschiedlicher Volumen.
        Class<?> classEinkaufskorb = getClassEinkaufskorb();
        assertNotNull(classEinkaufskorb, "Klasse " + CLASS_NAME_EINKAUFSKORB + " nicht gefunden.");
        assertTrue(hatMethode(classEinkaufskorb, METHOD_NAME_GET_BELEGT, GET_BELEGT_PARAM_TYPES),
                "Methode " + METHOD_NAME_GET_BELEGT + " nicht gefunden.");
        assertEquals(int.class, getRueckgabeTyp(classEinkaufskorb, METHOD_NAME_GET_BELEGT, GET_BELEGT_PARAM_TYPES),
                "Methode " + METHOD_NAME_GET_BELEGT + " hat falschen Rückgabetyp.");

        // 3 products
        Object einkaufskobInstance = getEinkaufskorbInstance("Einkaufskorb");
        putIntoEinkaufskorb(einkaufskobInstance, new DummyProdukt(1), new DummyProdukt(2), new DummyProdukt(3));
        int result = (Integer) methodeAufrufen(einkaufskobInstance, METHOD_NAME_GET_BELEGT, GET_BELEGT_PARAM_TYPES,
                new Object[]{});
        assertEquals(6, result, "Methode " + METHOD_NAME_GET_BELEGT + " liefert falschen Wert bei befülltem Einkaufskorb.");

        // 1 product
        putIntoEinkaufskorb(einkaufskobInstance, new DummyProdukt(55));
        result = (Integer) methodeAufrufen(einkaufskobInstance, METHOD_NAME_GET_BELEGT, GET_BELEGT_PARAM_TYPES,
                new Object[]{});
        assertEquals(55, result, "Methode " + METHOD_NAME_GET_BELEGT + " liefert falschen Wert bei befülltem Einkaufskorb" +
                ".");
    }

    @Test
    public void testEinlegenLeer() throws LaborpruefungException {
        // einlegen(p) vorher leeres Array
        Class<?> classEinkaufskorb = getClassEinkaufskorb();
        assertTrue(hatMethode(classEinkaufskorb, METHOD_NAME_EINLEGEN, EINLEGEN_PARAM_TYPES));
        assertTrue(methodeHatModifizierer(classEinkaufskorb, METHOD_NAME_EINLEGEN, EINLEGEN_PARAM_TYPES, istPublic),
                "Methode " + METHOD_NAME_EINLEGEN + " hat nicht geforderte Sichtbarkeit");
        assertEquals(void.class, getRueckgabeTyp(classEinkaufskorb, METHOD_NAME_EINLEGEN, EINLEGEN_PARAM_TYPES), "Methode" +
                " " + METHOD_NAME_EINLEGEN + " hat nicht geforderten Rückgabetyp.");
        Object einkaufskorbInstance = getEinkaufskorbInstance("Einkaufskorb");

        Produkt produkt = new DummyProdukt(3);
        methodeAufrufen(einkaufskorbInstance, METHOD_NAME_EINLEGEN, EINLEGEN_PARAM_TYPES, new Object[]{produkt});
        Produkt[] produktArray = (Produkt[]) getWertObjektVariable(einkaufskorbInstance, VARIABLE_NAME_PRODUKTE);
        assertNotNull(produktArray, "Produkte-Array darf nicht null sein");
        assertEquals(1, produktArray.length, "Falsche Länge des Produkt-Arrays nach einfügen.");
        assertEquals(produkt, produktArray[0], "Eingefügtes Produkt nicht an richtiger Stelle.");
    }

    @Test
    public void testEinlegenNichtLeer() throws LaborpruefungException {
        // einlegen(p) vorher bereits Produkte im Array
        Class<?> classEinkaufskorb = getClassEinkaufskorb();
        assertTrue(hatMethode(classEinkaufskorb, METHOD_NAME_EINLEGEN, EINLEGEN_PARAM_TYPES));
        assertTrue(methodeHatModifizierer(classEinkaufskorb, METHOD_NAME_EINLEGEN, EINLEGEN_PARAM_TYPES, istPublic),
                "Methode " + METHOD_NAME_EINLEGEN + " hat nicht geforderte Sichtbarkeit");
        assertEquals(void.class, getRueckgabeTyp(classEinkaufskorb, METHOD_NAME_EINLEGEN, EINLEGEN_PARAM_TYPES), "Methode" +
                " " + METHOD_NAME_EINLEGEN + " hat nicht geforderten Rückgabetyp.");
        Object einkaufskorbInstance = getEinkaufskorbInstance("Einkaufskorb");

        Produkt produkt1 = new DummyProdukt(3);
        Produkt produkt2 = new DummyProdukt(2);
        methodeAufrufen(einkaufskorbInstance, METHOD_NAME_EINLEGEN, EINLEGEN_PARAM_TYPES, new Object[]{produkt1});
        methodeAufrufen(einkaufskorbInstance, METHOD_NAME_EINLEGEN, EINLEGEN_PARAM_TYPES, new Object[]{produkt2});
        Produkt[] produktArray = (Produkt[]) getWertObjektVariable(einkaufskorbInstance, VARIABLE_NAME_PRODUKTE);
        assertNotNull(produktArray, "Produkte-Array darf nicht null sein");
        assertEquals(2, produktArray.length, "Falsche Länge des Produkt-Arrays nach einfügen.");
        assertEquals(produkt1, produktArray[0], "Eingefügtes Produkt nicht an richtiger Stelle.");
        assertEquals(produkt2, produktArray[1], "Eingefügtes Produkt nicht an richtiger Stelle.");
    }

    @Test
    public void testEinlegenNull() throws LaborpruefungException {
        // einlegen(null) - keine Änderung
        Class<?> classEinkaufskorb = getClassEinkaufskorb();
        assertTrue(hatMethode(classEinkaufskorb, METHOD_NAME_EINLEGEN, EINLEGEN_PARAM_TYPES));
        assertTrue(methodeHatModifizierer(classEinkaufskorb, METHOD_NAME_EINLEGEN, EINLEGEN_PARAM_TYPES, istPublic),
                "Methode " + METHOD_NAME_EINLEGEN + " hat nicht geforderte Sichtbarkeit");
        assertEquals(void.class, getRueckgabeTyp(classEinkaufskorb, METHOD_NAME_EINLEGEN, EINLEGEN_PARAM_TYPES), "Methode" +
                " " + METHOD_NAME_EINLEGEN + " hat nicht geforderten Rückgabetyp.");

        // null in leer einfügen
        Object einkaufskorbInstance = getEinkaufskorbInstance("Einkaufskorb");
        methodeAufrufen(einkaufskorbInstance, METHOD_NAME_EINLEGEN, EINLEGEN_PARAM_TYPES, new Object[]{null});
        Produkt[] produktArray = (Produkt[]) getWertObjektVariable(einkaufskorbInstance, VARIABLE_NAME_PRODUKTE);
        assertNotNull(produktArray, "Produkte-Array darf nicht null sein");
        assertEquals(0, produktArray.length, "Falsche Länge des Produkt-Arrays nach einfügen.");

        // null hinter Produkt einfügen
        einkaufskorbInstance = getEinkaufskorbInstance("Einkaufskorb");
        Produkt produkt1 = new DummyProdukt(3);
        methodeAufrufen(einkaufskorbInstance, METHOD_NAME_EINLEGEN, EINLEGEN_PARAM_TYPES, new Object[]{null});
        methodeAufrufen(einkaufskorbInstance, METHOD_NAME_EINLEGEN, EINLEGEN_PARAM_TYPES, new Object[]{produkt1});
        produktArray = (Produkt[]) getWertObjektVariable(einkaufskorbInstance, VARIABLE_NAME_PRODUKTE);
        assertEquals(1, produktArray.length, "Falsche Länge des Produkt-Arrays nach einfügen.");
        assertEquals(produkt1, produktArray[0], "Eingefügtes Produkt nicht an richtiger Stelle.");
    }
}