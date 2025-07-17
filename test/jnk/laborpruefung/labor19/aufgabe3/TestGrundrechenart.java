package jnk.laborpruefung.labor19.aufgabe3;

import jnk.laborpruefung.labor19.base.TestBasisklasse;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class TestGrundrechenart extends TestBasisklasse {

    public static final String PACKAGE_NAME = "jnk.laborpruefung.labor19.aufgabe3";
    public static final String INTERFACE_BEZEICHNER_GRUNDRECHENART = "Grundrechenart";
    public static final String METHODE_BEZEICHNER_AUSWERTEN = "auswerten";
    public static final String METHODE_BEZEICHNER_GET_SYMBOL = "getSymbol";

    /**
     * Liefert das class-Objekt zu Grundrechenart.
     */
    public Class<?> getInterfaceGrundrechenart() {
        Class<?> interfaceGrundrechenart;
        try {
            interfaceGrundrechenart = Class
                    .forName(PACKAGE_NAME + "." + INTERFACE_BEZEICHNER_GRUNDRECHENART);
            return interfaceGrundrechenart;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    @Test
    public void testGrundrechenart() {
        // Debugging
        System.out.println(
                "Teste Interface " + INTERFACE_BEZEICHNER_GRUNDRECHENART + " ...");

        Class<?> interfaceGrundrechenart = getInterfaceGrundrechenart();
        assertNotNull(
                "Interface " + INTERFACE_BEZEICHNER_GRUNDRECHENART + " nicht gefunden.",
                interfaceGrundrechenart);

        // Auswerten
        Class<?>[] parameterTypenAuswerten = new Class<?>[]{int.class,
                int.class};
        hatMethode(interfaceGrundrechenart, METHODE_BEZEICHNER_AUSWERTEN,
                parameterTypenAuswerten);
        Class<?> rueckgabeTypAuswerten = getRueckgabeTyp(interfaceGrundrechenart,
                METHODE_BEZEICHNER_AUSWERTEN, parameterTypenAuswerten);
        assertEquals("Falscher Rückgabetype bei " + METHODE_BEZEICHNER_AUSWERTEN,
                int.class, rueckgabeTypAuswerten);

        // GetSymbol
        Class<?>[] parameterTypenGetSymbol = new Class<?>[]{};
        hatMethode(interfaceGrundrechenart, METHODE_BEZEICHNER_GET_SYMBOL,
                parameterTypenGetSymbol);
        Class<?> rueckgabeTypGetSymbol = getRueckgabeTyp(interfaceGrundrechenart,
                METHODE_BEZEICHNER_GET_SYMBOL, parameterTypenGetSymbol);
        assertEquals("Falscher Rückgabetype bei " + METHODE_BEZEICHNER_GET_SYMBOL,
                String.class, rueckgabeTypGetSymbol);

    }

}
