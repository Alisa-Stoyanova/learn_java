package jnk.laborpruefung.labor17.aufgabe3;

import jnk.laborpruefung.labor17.basis.TestBasisklasse;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TestAufgabe3 extends TestBasisklasse {

    private static final String ENUM_FARBE_BEZEICHNER = "Farbe";
    private static final String ENUM_SYMBOL_BEZEICHNER = "Symbol";

    private static final String VARIABLE_FARBE_BEZEICHNER = "farbe";
    private static final String VARIABLE_SYMBOL_BEZEICHNER = "symbol";

    private static final String METHODE_GET_WERT_BEZEICHNER = "getWert";
    private static final String METHODE_ERZEUGE_LISTE_ALLER_KARTEN_BEZEICHNER = "erzeugeListeAllerKarten";
    private static final String METHODE_GET_BESTES_PAAR_BEZEICHNER = "getBestesPaar";
    private static final String METHODE_GET_SCHLECHTESTES_PAAR_BESSER_ALS_BEZEICHNER = "getSchlechtestesPaarBesserAls";

    private static final String ENUM_FARBE_ROT = "ROT";
    private static final String ENUM_FARBE_SCHWARZ = "SCHWARZ";
    private static final String ENUM_FARBE_BLAU = "BLAU";
    private static final String ENUM_SYMBOL_BUBE = "BUBE";
    private static final String ENUM_SYMBOL_DAME = "DAME";
    private static final String ENUM_SYMBOL_KOENIG = "KOENIG";

    private static final Class<?> SPIELKARTE_KLASSE = Spielkarte.class;
    private static final Class<?> HAND_KLASSE = Hand.class;

    /**
     * Testmethode für Unteraufgabe 1
     */
    @Test
    public void testUnteraufgabe1() {
        assertTrue(
                "Spielkarte hat nicht geforderte Methode "
                        + METHODE_GET_WERT_BEZEICHNER,
                hatMethode(SPIELKARTE_KLASSE, METHODE_GET_WERT_BEZEICHNER,
                        new Class<?>[]{}));

        assertEquals(
                "Falscher Rückgabetyp bei der Methode " + METHODE_GET_WERT_BEZEICHNER,
                int.class, getRueckgabeTyp(SPIELKARTE_KLASSE,
                        METHODE_GET_WERT_BEZEICHNER, new Class<?>[]{}));

        Spielkarte spielkarte = erzeugeSpielkarte(ENUM_FARBE_ROT, ENUM_SYMBOL_DAME);
        assertEquals(
                "Methode " + METHODE_GET_WERT_BEZEICHNER + " liefert falschen Wert.", 2,
                (int) werteMethodeAus(spielkarte, METHODE_GET_WERT_BEZEICHNER));

        spielkarte = erzeugeSpielkarte(ENUM_FARBE_ROT, ENUM_SYMBOL_BUBE);
        assertEquals(
                "Methode " + METHODE_GET_WERT_BEZEICHNER + " liefert falschen Wert.", 1,
                (int) werteMethodeAus(spielkarte, METHODE_GET_WERT_BEZEICHNER));

        spielkarte = erzeugeSpielkarte(ENUM_FARBE_BLAU, ENUM_SYMBOL_KOENIG);
        assertEquals(
                "Methode " + METHODE_GET_WERT_BEZEICHNER + " liefert falschen Wert.", 9,
                (int) werteMethodeAus(spielkarte, METHODE_GET_WERT_BEZEICHNER));

        spielkarte = erzeugeSpielkarte(ENUM_FARBE_SCHWARZ, ENUM_SYMBOL_DAME);
        assertEquals(
                "Methode " + METHODE_GET_WERT_BEZEICHNER + " liefert falschen Wert.", 4,
                (int) werteMethodeAus(spielkarte, METHODE_GET_WERT_BEZEICHNER));
    }

    /**
     * Testmethode für Unteraufgabe 2
     */
    @Test
    public void testUnteraufgabe2() {
        assertTrue(
                "Spielkarte hat nicht die geforderte Methode "
                        + METHODE_ERZEUGE_LISTE_ALLER_KARTEN_BEZEICHNER,
                hatMethode(SPIELKARTE_KLASSE,
                        METHODE_ERZEUGE_LISTE_ALLER_KARTEN_BEZEICHNER, new Class<?>[]{}));
        assertEquals(
                "Method " + METHODE_ERZEUGE_LISTE_ALLER_KARTEN_BEZEICHNER
                        + " hat nicht den geforderten Rückgabetyp",
                List.class, getRueckgabeTyp(SPIELKARTE_KLASSE,
                        METHODE_ERZEUGE_LISTE_ALLER_KARTEN_BEZEICHNER, new Class<?>[]{}));

        assertTrue(
                "Methode " + METHODE_ERZEUGE_LISTE_ALLER_KARTEN_BEZEICHNER
                        + " ist nicht statisch",
                methodeHatModifizierer(SPIELKARTE_KLASSE,
                        METHODE_ERZEUGE_LISTE_ALLER_KARTEN_BEZEICHNER, new Class<?>[]{},
                        istStatic));

        @SuppressWarnings("unchecked")
        List<Spielkarte> liste = (List<Spielkarte>) werteStatischeMethodeAus(
                SPIELKARTE_KLASSE, METHODE_ERZEUGE_LISTE_ALLER_KARTEN_BEZEICHNER,
                new Class<?>[]{}, new Object[]{});
        assertEquals("Liste aus " + METHODE_ERZEUGE_LISTE_ALLER_KARTEN_BEZEICHNER
                + " hat falsche Länge", 9, liste.size());

        // ROT/DAME
        boolean gefunden = false;
        for (Spielkarte spielkarte : liste) {
            gefunden = getWertObjektVariable(spielkarte,
                    VARIABLE_FARBE_BEZEICHNER) == createFarbeEnum(ENUM_FARBE_ROT)
                    && getWertObjektVariable(spielkarte,
                    VARIABLE_SYMBOL_BEZEICHNER) == createSymbolEnum(ENUM_SYMBOL_DAME);
            if (gefunden) {
                break;
            }
        }
        assertTrue("Spielkarte ROT/DAME nicht gefunden", gefunden);

        // SCHWARZ/BUBE
        gefunden = false;
        for (Spielkarte spielkarte : liste) {
            gefunden = getWertObjektVariable(spielkarte,
                    VARIABLE_FARBE_BEZEICHNER) == createFarbeEnum(ENUM_FARBE_SCHWARZ)
                    && getWertObjektVariable(spielkarte,
                    VARIABLE_SYMBOL_BEZEICHNER) == createSymbolEnum(ENUM_SYMBOL_BUBE);
            if (gefunden) {
                break;
            }
        }
        assertTrue("Spielkarte SCHWARZ/BUBE nicht gefunden", gefunden);

        // BLAU/KOENIG
        gefunden = false;
        for (Spielkarte spielkarte : liste) {
            gefunden = getWertObjektVariable(spielkarte,
                    VARIABLE_FARBE_BEZEICHNER) == createFarbeEnum(ENUM_FARBE_BLAU)
                    && getWertObjektVariable(spielkarte,
                    VARIABLE_SYMBOL_BEZEICHNER) == createSymbolEnum(
                    ENUM_SYMBOL_KOENIG);
            if (gefunden) {
                break;
            }
        }
        assertTrue("Spielkarte BLAU/KOENIG nicht gefunden", gefunden);
    }

    /**
     * Testmethode für Unteraufgabe 3
     */
    @Test
    public void testUnteraufgabe3() {
        Class<?>[] parameter = new Class<?>[]{SPIELKARTE_KLASSE,
                SPIELKARTE_KLASSE};

        assertTrue(
                "Klasse Hand hat nicht die geforderte Methode "
                        + METHODE_GET_WERT_BEZEICHNER,
                hatMethode(HAND_KLASSE, METHODE_GET_WERT_BEZEICHNER, parameter));
        assertEquals(
                "Methode " + METHODE_GET_WERT_BEZEICHNER + " hat falschen Rückgabetyp",
                int.class,
                getRueckgabeTyp(HAND_KLASSE, METHODE_GET_WERT_BEZEICHNER, parameter));
        assertTrue(
                "Methode " + METHODE_GET_WERT_BEZEICHNER + " muss statisch sein.",
                methodeHatModifizierer(HAND_KLASSE, METHODE_GET_WERT_BEZEICHNER,
                        parameter, istStatic));

        Spielkarte roteDame = erzeugeSpielkarte(ENUM_FARBE_ROT, ENUM_SYMBOL_DAME);
        Spielkarte blauerBube = erzeugeSpielkarte(ENUM_FARBE_BLAU,
                ENUM_SYMBOL_BUBE);
        assertEquals(
                "Methode " + METHODE_GET_WERT_BEZEICHNER
                        + " liefert falschen Wert für ROT/DAME und BLAU/BUBE",
                5, werteStatischeMethodeAus(HAND_KLASSE, METHODE_GET_WERT_BEZEICHNER,
                        parameter, new Object[]{roteDame, blauerBube}));

        Spielkarte schwarzerKoening = erzeugeSpielkarte(ENUM_FARBE_SCHWARZ,
                ENUM_SYMBOL_KOENIG);
        Spielkarte roterKoenig = erzeugeSpielkarte(ENUM_FARBE_ROT,
                ENUM_SYMBOL_KOENIG);
        assertEquals(
                "Methode " + METHODE_GET_WERT_BEZEICHNER
                        + " liefert falschen Wert für SCHWARZ/KOENING und ROT/KOENIG",
                18, werteStatischeMethodeAus(HAND_KLASSE, METHODE_GET_WERT_BEZEICHNER,
                        parameter, new Object[]{schwarzerKoening, roterKoenig}));

        Spielkarte blaueDame = erzeugeSpielkarte(ENUM_FARBE_BLAU, ENUM_SYMBOL_DAME);
        assertEquals(
                "Methode " + METHODE_GET_WERT_BEZEICHNER
                        + " liefert falschen Wert für BLAU/DAME und BLAE/DAME",
                48, werteStatischeMethodeAus(HAND_KLASSE, METHODE_GET_WERT_BEZEICHNER,
                        parameter, new Object[]{blaueDame, blaueDame}));
    }

    /**
     * Testmethode für Unteraufgabe 4
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testUnteraufgabe4() {
        Class<?>[] parameter = new Class<?>[]{};
        assertTrue(
                "Klasse Hand hat nicht die geforderte Methode "
                        + METHODE_GET_BESTES_PAAR_BEZEICHNER,
                hatMethode(HAND_KLASSE, METHODE_GET_BESTES_PAAR_BEZEICHNER, parameter));
        assertEquals(
                "Methode " + METHODE_GET_BESTES_PAAR_BEZEICHNER
                        + " hat falschen Rückgabetyp",
                List.class, getRueckgabeTyp(HAND_KLASSE,
                        METHODE_GET_BESTES_PAAR_BEZEICHNER, parameter));

        Spielkarte roteDame = erzeugeSpielkarte(ENUM_FARBE_ROT, ENUM_SYMBOL_DAME);
        Spielkarte blauerKoenig = erzeugeSpielkarte(ENUM_FARBE_BLAU,
                ENUM_SYMBOL_KOENIG);
        Spielkarte roterBube = erzeugeSpielkarte(ENUM_FARBE_ROT, ENUM_SYMBOL_BUBE);
        Spielkarte roterKoenig = erzeugeSpielkarte(ENUM_FARBE_ROT,
                ENUM_SYMBOL_KOENIG);

        // {}
        Hand hand = new Hand(roteDame);
        List<Spielkarte> bestesPaar = (List<Spielkarte>) werteMethodeAus(hand,
                METHODE_GET_BESTES_PAAR_BEZEICHNER);
        assertTrue("Methode " + METHODE_GET_BESTES_PAAR_BEZEICHNER
                + " liefert falsches Paar", bestesPaar.size() == 0);

        // ROT/DAME
        hand = new Hand(roteDame);
        bestesPaar = (List<Spielkarte>) werteMethodeAus(hand,
                METHODE_GET_BESTES_PAAR_BEZEICHNER);
        assertTrue("Methode " + METHODE_GET_BESTES_PAAR_BEZEICHNER
                + " liefert falsches Paar", bestesPaar.size() == 0);

        // ROT/DAME, BLAU/KOENIG
        hand = new Hand(roteDame, blauerKoenig);
        bestesPaar = (List<Spielkarte>) werteMethodeAus(hand,
                METHODE_GET_BESTES_PAAR_BEZEICHNER);
        assertTrue(
                "Methode " + METHODE_GET_BESTES_PAAR_BEZEICHNER
                        + " liefert falsches Paar",
                bestesPaar.size() == 2 && bestesPaar.contains(roteDame)
                        && bestesPaar.contains(blauerKoenig));

        // ROT/DAME, BLAU/KOENIG, ROT/BUBE
        hand = new Hand(roteDame, blauerKoenig, roterBube);
        bestesPaar = (List<Spielkarte>) werteMethodeAus(hand,
                METHODE_GET_BESTES_PAAR_BEZEICHNER);
        assertTrue(
                "Methode " + METHODE_GET_BESTES_PAAR_BEZEICHNER
                        + " liefert falsches Paar",
                bestesPaar.size() == 2 && bestesPaar.contains(roteDame)
                        && bestesPaar.contains(blauerKoenig));

        // ROT/DAME, BLAU/KOENIG, ROT/BUBE, ROT/KOENIG
        hand = new Hand(roteDame, blauerKoenig, roterBube, roterKoenig);
        bestesPaar = (List<Spielkarte>) werteMethodeAus(hand,
                METHODE_GET_BESTES_PAAR_BEZEICHNER);
        assertTrue(
                "Methode " + METHODE_GET_BESTES_PAAR_BEZEICHNER
                        + " liefert falsches Paar",
                bestesPaar.size() == 2 && bestesPaar.contains(roterKoenig)
                        && bestesPaar.contains(blauerKoenig));
    }

    /**
     * Testmethode für Unteraufgabe 5
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testUnteraufgabe5() {
        Class<?>[] parameter = new Class<?>[]{SPIELKARTE_KLASSE,
                SPIELKARTE_KLASSE};
        assertTrue(
                "Klasse Hand hat nicht die geforderte Methode "
                        + METHODE_GET_SCHLECHTESTES_PAAR_BESSER_ALS_BEZEICHNER,
                hatMethode(HAND_KLASSE,
                        METHODE_GET_SCHLECHTESTES_PAAR_BESSER_ALS_BEZEICHNER, parameter));
        assertEquals(
                "Methode " + METHODE_GET_SCHLECHTESTES_PAAR_BESSER_ALS_BEZEICHNER
                        + " hat falschen Rückgabetyp",
                List.class, getRueckgabeTyp(HAND_KLASSE,
                        METHODE_GET_SCHLECHTESTES_PAAR_BESSER_ALS_BEZEICHNER, parameter));

        Spielkarte roteDame = erzeugeSpielkarte(ENUM_FARBE_ROT, ENUM_SYMBOL_DAME);
        Spielkarte blauerKoenig = erzeugeSpielkarte(ENUM_FARBE_BLAU,
                ENUM_SYMBOL_KOENIG);
        Spielkarte roterKoenig = erzeugeSpielkarte(ENUM_FARBE_ROT,
                ENUM_SYMBOL_KOENIG);
        Spielkarte schwarzerKoening = erzeugeSpielkarte(ENUM_FARBE_SCHWARZ,
                ENUM_SYMBOL_KOENIG);

        // {}
        Hand hand = new Hand(roteDame);
        List<Spielkarte> bestesPaar = (List<Spielkarte>) werteMethodeAus(hand,
                METHODE_GET_SCHLECHTESTES_PAAR_BESSER_ALS_BEZEICHNER, parameter,
                new Object[]{roteDame, roteDame});
        assertTrue("Methode " + METHODE_GET_SCHLECHTESTES_PAAR_BESSER_ALS_BEZEICHNER
                + " liefert falsches Paar", bestesPaar.size() == 0);

        // ROT/DAME
        hand = new Hand(roteDame);
        bestesPaar = (List<Spielkarte>) werteMethodeAus(hand,
                METHODE_GET_SCHLECHTESTES_PAAR_BESSER_ALS_BEZEICHNER, parameter,
                new Object[]{roteDame, roteDame});
        assertTrue("Methode " + METHODE_GET_SCHLECHTESTES_PAAR_BESSER_ALS_BEZEICHNER
                + " liefert falsches Paar", bestesPaar.size() == 0);

        // kein Paar besser: ROT/DAME + BLAU/KOENING
        hand = new Hand(roteDame, blauerKoenig);
        bestesPaar = (List<Spielkarte>) werteMethodeAus(hand,
                METHODE_GET_SCHLECHTESTES_PAAR_BESSER_ALS_BEZEICHNER, parameter,
                new Object[]{roteDame, roteDame});
        assertTrue("Methode " + METHODE_GET_SCHLECHTESTES_PAAR_BESSER_ALS_BEZEICHNER
                + " liefert falsches Paar", bestesPaar.size() == 0);

        // ein Paar besser
        hand = new Hand(roteDame, blauerKoenig, roterKoenig);
        bestesPaar = (List<Spielkarte>) werteMethodeAus(hand,
                METHODE_GET_SCHLECHTESTES_PAAR_BESSER_ALS_BEZEICHNER, parameter,
                new Object[]{roteDame, roteDame});
        assertTrue(
                "Methode " + METHODE_GET_SCHLECHTESTES_PAAR_BESSER_ALS_BEZEICHNER
                        + " liefert falsches Paar",
                bestesPaar.size() == 2 && bestesPaar.contains(blauerKoenig)
                        && bestesPaar.contains(roterKoenig));

        // mehrere Paare besser
        hand = new Hand(roteDame, blauerKoenig, roterKoenig, schwarzerKoening);
        bestesPaar = (List<Spielkarte>) werteMethodeAus(hand,
                METHODE_GET_SCHLECHTESTES_PAAR_BESSER_ALS_BEZEICHNER, parameter,
                new Object[]{roteDame, roteDame});
        assertTrue(
                "Methode " + METHODE_GET_SCHLECHTESTES_PAAR_BESSER_ALS_BEZEICHNER
                        + " liefert falsches Paar",
                bestesPaar.size() == 2 && bestesPaar.contains(schwarzerKoening)
                        && bestesPaar.contains(roterKoenig));
    }

    private Spielkarte erzeugeSpielkarte(String farbe, String symbol) {
        Class<?> enumFarbe = getEnum(SPIELKARTE_KLASSE, ENUM_FARBE_BEZEICHNER);
        Class<?> enumSymbol = getEnum(SPIELKARTE_KLASSE, ENUM_SYMBOL_BEZEICHNER);
        return (Spielkarte) erzeugeInstanz(SPIELKARTE_KLASSE,
                new Class<?>[]{enumFarbe, enumSymbol},
                new Object[]{createFarbeEnum(farbe), createSymbolEnum(symbol)});
    }

    private Object createFarbeEnum(String konstante) {
        Class<?> enumFarbe = getEnum(SPIELKARTE_KLASSE, ENUM_FARBE_BEZEICHNER);
        return getEnumKonstante(enumFarbe, konstante);
    }

    private Object createSymbolEnum(String konstante) {
        Class<?> enumSymbol = getEnum(SPIELKARTE_KLASSE, ENUM_SYMBOL_BEZEICHNER);
        return getEnumKonstante(enumSymbol, konstante);
    }
}
