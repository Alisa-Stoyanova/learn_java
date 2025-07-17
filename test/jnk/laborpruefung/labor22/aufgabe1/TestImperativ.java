package jnk.laborpruefung.labor22.aufgabe1;

import jnk.laborpruefung.labor22.TestBasisklasse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestImperativ extends TestBasisklasse {

    private static final String METHOD_NAME_AUSWERTEN = "auswerten";

    @Test
    public void testAuswertenAddition() {
        // - "23 + 42" -> 65
        Imperativ imperativ = new Imperativ();
        assertEquals(65, imperativ.auswerten("23 + 42"), METHOD_NAME_AUSWERTEN + " liefert falschen Wert");
        assertEquals(3, imperativ.auswerten("1 + 2"), METHOD_NAME_AUSWERTEN + " liefert falschen Wert");
        int a = new Random().nextInt(20);
        int b = new Random().nextInt(20);
        assertEquals(a + b, imperativ.auswerten("" + a + " + " + b), METHOD_NAME_AUSWERTEN + " liefert falschen Wert");
    }

    @Test
    public void testAuswertenSubtraktion() {
        // "23 - 42" -> -19
        Imperativ imperativ = new Imperativ();
        assertEquals(-19, imperativ.auswerten("23 - 42"), METHOD_NAME_AUSWERTEN + " liefert falschen Wert");
        assertEquals(-1, imperativ.auswerten("1 - 2"), METHOD_NAME_AUSWERTEN + " liefert falschen Wert");
        int a = new Random().nextInt(20);
        int b = new Random().nextInt(20);
        assertEquals(a - b, imperativ.auswerten("" + a + " - " + b), METHOD_NAME_AUSWERTEN + " liefert falschen Wert");
    }

    @Test
    public void testAuswertenSubtraktionFalscheFormatierung() {
        // "23+42" -> IllegalArgumentException
        Imperativ imperativ = new Imperativ();
        assertThrows(IllegalArgumentException.class, () -> imperativ.auswerten("23+42"), METHOD_NAME_AUSWERTEN + " wirft " +
                "nicht die geforderte Exception");
        assertThrows(IllegalArgumentException.class, () -> imperativ.auswerten("23 +42"), METHOD_NAME_AUSWERTEN + " wirft" +
                " nicht die geforderte Exception");
        assertThrows(IllegalArgumentException.class, () -> imperativ.auswerten("23+ 42"), METHOD_NAME_AUSWERTEN + " wirft" +
                " nicht die geforderte Exception");
    }

    @Test
    public void testAuswertenSubtraktionFalscherOperator() {
        // "23 / 42" -> IllegalArgumentException
        Imperativ imperativ = new Imperativ();
        assertThrows(IllegalArgumentException.class, () -> imperativ.auswerten("23 / 42"), METHOD_NAME_AUSWERTEN + " " +
                "wirft nicht die geforderte Exception");
        assertThrows(IllegalArgumentException.class, () -> imperativ.auswerten("23 4 42"), METHOD_NAME_AUSWERTEN + " " +
                "wirft nicht die geforderte Exception");
        assertThrows(IllegalArgumentException.class, () -> imperativ.auswerten("23 cc 42"), METHOD_NAME_AUSWERTEN + " " +
                "wirft nicht die geforderte Exception");
    }

    @Test
    public void testBuchstabenKetteRegulaer() {
        // 'a' -> "a" und 'f' -> "ffffff"
        Imperativ imperativ = new Imperativ();
        assertEquals("a", imperativ.buchstabenkette('a'), "Falsche Rückgabe-Zeichenkette");
        assertEquals("ffffff", imperativ.buchstabenkette('f'), "Falsche Rückgabe-Zeichenkette");
    }

    @Test
    public void testBuchstabenKetteUngueltigeEingabe() {
        // 'E' -> IllegalArgumentException
        Imperativ imperativ = new Imperativ();
        assertThrows(IllegalArgumentException.class, () -> imperativ.buchstabenkette('E'), "IllegalArgumentException " +
                "erwartet");
        assertThrows(IllegalArgumentException.class, () -> imperativ.buchstabenkette('*'), "IllegalArgumentException " +
                "erwartet");
    }

    @Test
    public void testString2charZeichen() {
        // regulärer Fall: Zeichen korrekt
        Imperativ imperativ = new Imperativ();
        Assertions.assertEquals(0, Arrays.compare(new char[]{'a', 'b', 'c', 'd', 'e', 'f'}, imperativ.string2char(new String[]{"abc",
                "de", "f"})), "Rückgabearray beinhaltet nicht die richtigen Zeichen");
        Assertions.assertEquals(0, Arrays.compare(new char[]{'a'}, imperativ.string2char(new String[]{"a"})),
                "Rückgabearray beinhaltet nicht die richtigen Zeichen");
        Assertions.assertEquals(0, Arrays.compare(new char[]{'a', 'b', 'c'}, imperativ.string2char(new String[]{"abc"})),
                "Rückgabearray beinhaltet nicht die richtigen Zeichen");
    }


    @Test
    public void testString2charEingabeNull() {
        // stringArray ist null
        Imperativ imperativ = new Imperativ();
        Assertions.assertEquals(0, Arrays.compare(new char[]{},
                        imperativ.string2char(null)),
                "Fehler beim Umgang mit null als Eingabe-Array");
    }

    @Test
    public void testString2charStringNull() {
        // ein String ist null
        Imperativ imperativ = new Imperativ();
        Assertions.assertEquals(0, Arrays.compare(new char[]{'a', 'b', 'c', 'd', 'e', 'f'},
                        imperativ.string2char(new String[]{"abc", "d", null, "ef"})),
                "Fehler beim Umgang mit null im Eingabe-Array");
        Assertions.assertEquals(0, Arrays.compare(new char[]{},
                        imperativ.string2char(new String[]{null, null, null})),
                "Fehler beim Umgang mit null im Eingabe-Array");
        Assertions.assertEquals(0, Arrays.compare(new char[]{'a', 'b', 'c'},
                        imperativ.string2char(new String[]{null, "abc", null})),
                "Fehler beim Umgang mit null im Eingabe-Array");
    }
}
