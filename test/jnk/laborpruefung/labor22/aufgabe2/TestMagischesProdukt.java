package jnk.laborpruefung.labor22.aufgabe2;

import jnk.laborpruefung.labor22.LaborpruefungException;
import jnk.laborpruefung.labor22.TestBasisklasse;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

public class TestMagischesProdukt extends TestBasisklasse {

    private static final String PACKAGENAME = Behaelter.class.getPackageName();
    private static final String CLASS_NAME_MAGISCHES_PRODUKT = "MagischesProdukt";
    private static final Class<?>[] CONSTRUCTOR_PARAMS_MAGISCHES_PRODUKT = {String.class};
    private static final String VARIABLE_NAME_INNERES = "inneres";
    private static final String METHOD_NAME_GET_INNERES = "getInneres";
    private static final String METHOD_NAME_SET_INNERES = "setInneres";
    private static final String METHOD_NAME_GET_VOLUMEN = "getVolumen";
    private static final Class<?>[] METHOD_PARAMS_GET_VOLUMEN = {};
    private static final String METHOD_NAME_EINSETZEN = "einsetzen";

    /**
     * Returns the class object for the class Einkaufswagen if it exists, otherwise null;
     */
    private Class<?> getClassMagischesProdukt() {
        try {
            Class<?> classMagischesProdukt = Class.forName(PACKAGENAME + "." + CLASS_NAME_MAGISCHES_PRODUKT);
            return classMagischesProdukt;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /**
     * Generate in instance of Einkaufskorb
     */
    private Object getMagischesProduktInstance(String name) {
        Class<?> classMagischesProdukt = getClassMagischesProdukt();
        if (classMagischesProdukt == null) {
            return null;
        }
        try {
            Object instance = erzeugeInstanz(classMagischesProdukt, CONSTRUCTOR_PARAMS_MAGISCHES_PRODUKT, new Object[]{name});
            return instance;
        } catch (LaborpruefungException e) {
            return null;
        }
    }

    @Test
    public void testKlasseKonstruktorName() throws NoSuchMethodException {
        // Objektvariable name, an Konstruktor übergeben, mit getName zurückgegeben.
        Class<?> classMagischesProdukt = getClassMagischesProdukt();
        assertNotNull(classMagischesProdukt, "Klasse " + CLASS_NAME_MAGISCHES_PRODUKT + " nicht gefunden.");
        assertTrue(implementiertInterface(classMagischesProdukt, Produkt.class), "Klasse " + CLASS_NAME_MAGISCHES_PRODUKT + " " +
                "implementiert nicht wie gefordert.");

        // Check for constructor with parameter
        Constructor<?> constructor = classMagischesProdukt.getConstructor(CONSTRUCTOR_PARAMS_MAGISCHES_PRODUKT);
        assertNotNull(constructor, "Geforderter Konstruktor nicht gefunden.");

    }

    @Test
    public void testKlasseKonstruktorInneres() throws LaborpruefungException {
        // Objektvariable inneres, Getter, Setter
        Class<?> classMagischesProdukt = getClassMagischesProdukt();
        assertTrue(hatObjektVariable(classMagischesProdukt, VARIABLE_NAME_INNERES, classMagischesProdukt),
                "Klasse " + CLASS_NAME_MAGISCHES_PRODUKT + " hat nicht die gefordete Objektvariable " + VARIABLE_NAME_INNERES);
        assertTrue(objektvariableHatModifizierer(classMagischesProdukt, VARIABLE_NAME_INNERES, istPrivate),
                "Variable " + VARIABLE_NAME_INNERES + " hat nicht die richtige Sichtbarkeit");
        Object magischesProduktInstance = getMagischesProduktInstance("Stein");
        Object inneresWert = getWertObjektVariable(magischesProduktInstance, VARIABLE_NAME_INNERES);
        assertEquals(null, inneresWert, "Variable " + VARIABLE_NAME_INNERES + " hat nicht geforderten Initialwert null.");

        // Getter
        Class<?>[] GETTER_PARAMS = new Class<?>[]{};
        assertTrue(hatMethode(classMagischesProdukt, METHOD_NAME_GET_INNERES, GETTER_PARAMS),
                "Klasse " + CLASS_NAME_MAGISCHES_PRODUKT +
                        " hat nicht geforderten Getter");
        assertEquals(classMagischesProdukt, getRueckgabeTyp(classMagischesProdukt, METHOD_NAME_GET_INNERES,
                GETTER_PARAMS), "Methode " + METHOD_NAME_GET_INNERES + " hat falsche Parameterliste");
        assertTrue(methodeHatModifizierer(classMagischesProdukt, METHOD_NAME_GET_INNERES, GETTER_PARAMS, istPublic),
                "Methode " + METHOD_NAME_GET_INNERES + " hat falsche Sichtbarkeit");

        // Getter
        Class<?>[] SETTER_PARAMS = new Class<?>[]{classMagischesProdukt};
        assertTrue(hatMethode(classMagischesProdukt, METHOD_NAME_SET_INNERES, SETTER_PARAMS),
                "Klasse " + CLASS_NAME_MAGISCHES_PRODUKT +
                        " hat nicht geforderten Setter");
        assertEquals(void.class, getRueckgabeTyp(classMagischesProdukt, METHOD_NAME_SET_INNERES,
                SETTER_PARAMS), "Methode " + METHOD_NAME_SET_INNERES + " hat falsche Parameterliste");
        assertTrue(methodeHatModifizierer(classMagischesProdukt, METHOD_NAME_SET_INNERES, SETTER_PARAMS, istPublic),
                "Methode " + METHOD_NAME_SET_INNERES + " hat falsche Sichtbarkeit");
    }

    @Test
    public void testVolumenKeinInneres() throws LaborpruefungException {
        // ohne Inneres
        Class<?> classMagischesProdukt = getClassMagischesProdukt();
        assertTrue(hatMethode(classMagischesProdukt, METHOD_NAME_GET_VOLUMEN, METHOD_PARAMS_GET_VOLUMEN), "Geforderte " +
                "Methode " + METHOD_NAME_GET_VOLUMEN + " fehlt");
        assertEquals(int.class, getRueckgabeTyp(classMagischesProdukt, METHOD_NAME_GET_VOLUMEN,
                METHOD_PARAMS_GET_VOLUMEN), "Methode " + METHOD_NAME_GET_VOLUMEN + " hat falschen Rückgabetyp");
        assertTrue(methodeHatModifizierer(classMagischesProdukt, METHOD_NAME_GET_VOLUMEN, METHOD_PARAMS_GET_VOLUMEN,
                istPublic), "Methode " + METHOD_NAME_GET_VOLUMEN + " hat falsche Sichtbarkeit");

        Object magischesProdukt = getMagischesProduktInstance("Stein");
        int wert = (Integer) methodeAufrufen(magischesProdukt, METHOD_NAME_GET_VOLUMEN, METHOD_PARAMS_GET_VOLUMEN,
                new Object[]{});
        assertEquals(1, wert, "Methode " + METHOD_NAME_GET_VOLUMEN + " liefert falsches Volumen bei leerem Inhalt");
    }

    @Test
    public void testVolumenMitInneres() throws LaborpruefungException {
        // mit zwei verschachtelten Inneren
        Class<?> classMagischesProdukt = getClassMagischesProdukt();
        Object magischesProdukt1 = getMagischesProduktInstance("Stein");
        Object magischesProdukt2 = getMagischesProduktInstance("Schere");
        Object magischesProdukt3 = getMagischesProduktInstance("Papier");
        setObjektvariable(magischesProdukt1, VARIABLE_NAME_INNERES, magischesProdukt2);
        setObjektvariable(magischesProdukt2, VARIABLE_NAME_INNERES, magischesProdukt3);

        int wert = (Integer) methodeAufrufen(magischesProdukt1, METHOD_NAME_GET_VOLUMEN, METHOD_PARAMS_GET_VOLUMEN,
                new Object[]{});
        assertEquals(3, wert, "Methode " + METHOD_NAME_GET_VOLUMEN + " liefert falsches Volumen bei verschachteltem " +
                "Inhalt");
    }

    @Test
    public void testEinsetzenVorherKeinInneres() throws LaborpruefungException {
        // eingesetztes Produkt ohne inneres = neues inneres
        Class<?> classMagischesProdukt = getClassMagischesProdukt();
        Class<?>[] einsetzenParamTypes = {classMagischesProdukt};
        assertTrue(hatMethode(classMagischesProdukt, METHOD_NAME_EINSETZEN, einsetzenParamTypes), "Geforderte " +
                "Methode " + METHOD_NAME_EINSETZEN + " fehlt");
        assertEquals(void.class, getRueckgabeTyp(classMagischesProdukt, METHOD_NAME_EINSETZEN,
                einsetzenParamTypes), "Methode " + METHOD_NAME_EINSETZEN + " hat falschen Rückgabetyp");
        assertTrue(methodeHatModifizierer(classMagischesProdukt, METHOD_NAME_EINSETZEN, einsetzenParamTypes,
                istPublic), "Methode " + METHOD_NAME_EINSETZEN + " hat falsche Sichtbarkeit");

        Object magischesProdukt1 = getMagischesProduktInstance("Stein");
        Object magischesProdukt2 = getMagischesProduktInstance("Schere");
        methodeAufrufen(magischesProdukt1, METHOD_NAME_EINSETZEN, einsetzenParamTypes, new Object[]{magischesProdukt2});
        assertEquals(magischesProdukt2, getWertObjektVariable(magischesProdukt1, VARIABLE_NAME_INNERES), "Falscher " +
                "Zustand nach dem Einsetzen eines weiteren Magisches Gegenstandes");
    }

    @Test
    public void testEinsetzenVorherMitInneres() throws LaborpruefungException {
        // alte vorhandene innnere sind dann Nachfolger des eingesetzten Produktes
        Class<?> classMagischesProdukt = getClassMagischesProdukt();
        Class<?>[] einsetzenParamTypes = {classMagischesProdukt};
        Object magischesProdukt1 = getMagischesProduktInstance("Stein");
        Object magischesProdukt2 = getMagischesProduktInstance("Schere");
        Object magischesProdukt3 = getMagischesProduktInstance("Schere");

        // mp1->mp2 + mp3 --> mp1->mp3->mp2


        setObjektvariable(magischesProdukt1, VARIABLE_NAME_INNERES, magischesProdukt2);
        methodeAufrufen(magischesProdukt1, METHOD_NAME_EINSETZEN, einsetzenParamTypes, new Object[]{magischesProdukt3});
        assertEquals(magischesProdukt3, getWertObjektVariable(magischesProdukt1, VARIABLE_NAME_INNERES), "Falscher " +
                "Zustand nach dem Einsetzen eines weiteren Magisches Gegenstandes");
        assertEquals(magischesProdukt2, getWertObjektVariable(magischesProdukt3, VARIABLE_NAME_INNERES), "Falscher " +
                "Zustand nach dem Einsetzen eines weiteren Magisches Gegenstandes");
        assertEquals(null, getWertObjektVariable(magischesProdukt2, VARIABLE_NAME_INNERES), "Falscher " +
                "Zustand nach dem Einsetzen eines weiteren Magisches Gegenstandes");


    }
}
