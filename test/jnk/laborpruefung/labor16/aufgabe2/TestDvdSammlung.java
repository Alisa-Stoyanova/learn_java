package jnk.laborpruefung.labor16.aufgabe2;

import jnk.laborpruefung.labor16.base.TestBasisklasse;
import org.junit.Test;

import java.lang.reflect.TypeVariable;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Testklasse für DvdSammlung.
 *
 * @author Philipp Jenke
 */
public class TestDvdSammlung extends TestBasisklasse {

    private static String BEZEICHNER_ANZAHL_DVDS = "anzahlDvds";
    private static String BEZEICHNER_DVDS = "dvds";
    private static String BEZEICHNER_GET_ANZAHL_DVDS = "getAnzahlDvds";
    private static String BEZEICHNER_DVD_HINZUEFUEGEN = "dvdHinzufuegen";
    private static String BEZEICHNER_GET_DVD_BY_INDEX = "getDvd";
    private static String BEZEICHNER_GET_DVD_BY_TITLE = "getDvd";
    private static String BEZEICHNER_GET_LAUFZEIT_IN_SAMMLUNG =
            "getLaufzeitInSammlung";
    private static String BEZEICHNER_GET_DVDS_BIS_ALTER = "getDvdsBisAlter";

    /**
     * Erzeugt ein DvdSammlung-Objekt.
     */
    private Object erzeugeDvdSammlung(int arrayGroesse) {
        Class<?>[] typen = {int.class};
        Object[] werte = {arrayGroesse};
        Object dvdSammlung = erzeugeInstanz(DvdSammlung.class, typen, werte);
        return dvdSammlung;
    }

    /**
     * Liefert das DVD-Array.
     */
    private Dvd[] getDvdArray(Object dvdSammlung) {
        Object istArray = getWertObjektVariable(dvdSammlung, BEZEICHNER_DVDS);
        Dvd[] istDvds = (Dvd[]) istArray;
        return istDvds;
    }

    @Test
    public void testeVariableAnzahlDvds() {
        assertTrue(
                "Klasse DvdSammlung hat nicht geforderte Objektvariable "
                        + BEZEICHNER_ANZAHL_DVDS,
                testHatObjektVariable(DvdSammlung.class, BEZEICHNER_ANZAHL_DVDS,
                        int.class));
    }

    @Test
    public void testeVariableDvds() {
        assertTrue(
                "Klasse DvdSammlung hat nicht geforderte Objektvariable "
                        + BEZEICHNER_DVDS,
                testHatObjektVariable(DvdSammlung.class, BEZEICHNER_DVDS, Dvd[].class));
    }

    @Test
    public void testeKonstruktor() {
        Class<?>[] parameter = {int.class};
        assertTrue("Klasse DvdSammlung hat nicht geforderten Konstruktor.",
                hatKonstruktor(DvdSammlung.class, parameter));

        // Erzeuge DvdSammlung
        int arrayGroesse = 3;
        Object dvdSammlung = erzeugeDvdSammlung(arrayGroesse);

        // Anzahl DVDs in Sammlung
        Object istAnzahlDvs =
                getWertObjektVariable(dvdSammlung, BEZEICHNER_ANZAHL_DVDS);
        Integer istAnzahlDvsInt = (Integer) istAnzahlDvs;
        assertTrue(
                BEZEICHNER_ANZAHL_DVDS
                        + " wurde in Konstruktor nicht korrekt initialisiert.",
                istAnzahlDvsInt == 0);

        // DVD-Array nicht null
        Dvd[] istDvds = getDvdArray(dvdSammlung);
        assertNotNull(
                BEZEICHNER_DVDS + " darf nach dem Konstruktor nicht null sein.",
                istDvds);

        // DVD-Array mit korrekte Länge
        assertTrue(BEZEICHNER_DVDS + "-Array hat nicht die korrekte Länge.",
                istDvds.length == arrayGroesse);
    }

    @Test
    public void testeGetAnzahlDvds() {
        Class<?>[] parameter = {};
        assertTrue(
                "Klasse DvdSammlung hat nicht geforderte Methode "
                        + BEZEICHNER_GET_ANZAHL_DVDS + ".",
                hatMethode(DvdSammlung.class, BEZEICHNER_GET_ANZAHL_DVDS, parameter));

        assertTrue(
                "Methode " + BEZEICHNER_GET_ANZAHL_DVDS + " hat falschen Rückgabetyp.",
                getRueckgabeTyp(DvdSammlung.class, BEZEICHNER_GET_ANZAHL_DVDS,
                        parameter) == int.class);

        // Erzeuge DvdSammlung
        int arrayGroesse = 3;
        Object dvdSammlung = erzeugeDvdSammlung(arrayGroesse);

        // Erzeuge Dvd
        String titel = "Stirb langsam";
        int laufzeit = 120;
        int altersfreigabe = 16;
        Object dvd = TestDvd.erzeugeDvd(titel, laufzeit, altersfreigabe);

        // Werte Methode aus
        Object ergebnis = werteMethodeAus(dvdSammlung, BEZEICHNER_GET_ANZAHL_DVDS);
        assertNotNull(
                "Methode " + BEZEICHNER_GET_ANZAHL_DVDS + " liefert falsches Ergebnis.",
                ergebnis);
        int istAnzahlDvds = (Integer) ergebnis;
        assertTrue(
                "Methode " + BEZEICHNER_GET_ANZAHL_DVDS
                        + " liefert nicht korrekten Wert (0 erwartet).",
                istAnzahlDvds == 0);

        // Eine Dvd hinzufuegen
        Class<?>[] parameterListe = {Dvd.class};
        Object[] argumentenListe = {dvd};
        werteMethodeAus(dvdSammlung, BEZEICHNER_DVD_HINZUEFUEGEN, parameterListe,
                argumentenListe);

        // Werte Methode aus
        ergebnis = werteMethodeAus(dvdSammlung, BEZEICHNER_GET_ANZAHL_DVDS);
        assertNotNull(
                "Methode " + BEZEICHNER_GET_ANZAHL_DVDS + " liefert falsches Ergebnis.",
                ergebnis);
        istAnzahlDvds = (Integer) ergebnis;
        assertTrue(
                "Methode " + BEZEICHNER_GET_ANZAHL_DVDS
                        + " liefert nicht korrekten Wert (1 erwartet).",
                istAnzahlDvds == 1);
    }

    @Test
    public void testeDvdHinzufuegen() {
        Class<?>[] parameter = {Dvd.class};
        assertTrue(
                "Klasse DvdSammlung hat nicht geforderte Methode "
                        + BEZEICHNER_DVD_HINZUEFUEGEN + ".",
                hatMethode(DvdSammlung.class, BEZEICHNER_DVD_HINZUEFUEGEN, parameter));

        assertTrue(
                "Methode " + BEZEICHNER_DVD_HINZUEFUEGEN + " hat falschen Rückgabetyp",
                getRueckgabeTyp(DvdSammlung.class, BEZEICHNER_DVD_HINZUEFUEGEN,
                        parameter) == void.class);

        // Erzeuge DvdSammlung
        int arrayGroesse = 1;
        Object dvdSammlung = erzeugeDvdSammlung(arrayGroesse);

        // Erzeuge Dvds
        String titel = "Stirb langsam";
        int laufzeit = 120;
        int altersfreigabe = 16;
        Object dvd1 = TestDvd.erzeugeDvd(titel, laufzeit, altersfreigabe);

        titel = "Herr der Ringe";
        laufzeit = 320;
        altersfreigabe = 12;
        Object dvd2 = TestDvd.erzeugeDvd(titel, laufzeit, altersfreigabe);

        // DVD hinzufügen
        Object[] argumente = {dvd1};
        werteMethodeAus(dvdSammlung, BEZEICHNER_DVD_HINZUEFUEGEN, parameter,
                argumente);

        Dvd[] istDvds = getDvdArray(dvdSammlung);
        assertNotNull("Dvd-array ist null", istDvds);
        assertTrue("Dvd-array sollte Länge 2 haben",
                (Integer) werteMethodeAus(dvdSammlung,
                        BEZEICHNER_GET_ANZAHL_DVDS) == 1);
        assertEquals("DVD in Sammlung falsch.", dvd1, istDvds[0]);
        assertTrue("Variable " + BEZEICHNER_ANZAHL_DVDS + " falsch gesetzt",
                (Integer) getWertObjektVariable(dvdSammlung,
                        BEZEICHNER_ANZAHL_DVDS) == 1);

        // Zweite DVD einfügen - exception ewartet
        argumente[0] = dvd2;
        try {
            werteMethodeAusKeineAusnahmebehandlung(dvdSammlung,
                    BEZEICHNER_DVD_HINZUEFUEGEN, parameter, argumente);
            assertTrue("IllegalArgumentException erwartet, keine Exception geworfen.",
                    false);
        } catch (IllegalArgumentException e) {
            // Ok
        } catch (Throwable e) {
            assertTrue("Falsche Exception geworfen: (" + e.getClass().getName()
                    + "): " + e.getMessage(), false);
        }
    }

    @Test
    public void testGetDvdByIndexRegulaer() {
        Class<?>[] parameterListe = {int.class};
        assertTrue(
                "Klasse DvdSammlung hat nicht geforderte Methode "
                        + BEZEICHNER_GET_DVD_BY_INDEX + ".",
                hatMethode(DvdSammlung.class, BEZEICHNER_GET_DVD_BY_INDEX,
                        parameterListe));

        assertTrue(
                "Methode " + BEZEICHNER_GET_DVD_BY_INDEX + " hat falschen Rückgabetyp",
                getRueckgabeTyp(DvdSammlung.class, BEZEICHNER_GET_DVD_BY_INDEX,
                        parameterListe) == Dvd.class);

        // Erzeuge DvdSammlung
        int arrayGroesse = 3;
        Object dvdSammlung = erzeugeDvdSammlung(arrayGroesse);

        // Erzeuge Dvds
        String titel = "Stirb langsam";
        int laufzeit = 120;
        int altersfreigabe = 16;
        Object dvd1 = TestDvd.erzeugeDvd(titel, laufzeit, altersfreigabe);

        titel = "Herr der Ringe";
        laufzeit = 320;
        altersfreigabe = 12;
        Object dvd2 = TestDvd.erzeugeDvd(titel, laufzeit, altersfreigabe);

        // DVDs hinzufügen
        Class<?>[] parameterListeHinzufuegen = {Dvd.class};
        Object[] argumentenListeHinzufuegen = {dvd1};
        werteMethodeAus(dvdSammlung, BEZEICHNER_DVD_HINZUEFUEGEN,
                parameterListeHinzufuegen, argumentenListeHinzufuegen);
        argumentenListeHinzufuegen[0] = dvd2;
        werteMethodeAus(dvdSammlung, BEZEICHNER_DVD_HINZUEFUEGEN,
                parameterListeHinzufuegen, argumentenListeHinzufuegen);

        // Prüfe, ob erste DVD korrekt geliefert wird
        Object[] argumentenListe = {new Integer(0)};
        Object ergebnis = werteMethodeAus(dvdSammlung, BEZEICHNER_GET_DVD_BY_INDEX,
                parameterListe, argumentenListe);
        Dvd ergebbnisDvd = (Dvd) ergebnis;
        assertTrue("DVD nicth korrekt zurückgegeben.", dvd1 == ergebbnisDvd);
    }

    @Test
    public void testGetDvdByIndexException() {
        Class<?>[] parameterListe = {int.class};

        // Erzeuge DvdSammlung
        int arrayGroesse = 3;
        Object dvdSammlung = erzeugeDvdSammlung(arrayGroesse);
        String titel = "Stirb langsam";
        int laufzeit = 120;
        int altersfreigabe = 16;
        Object dvd1 = TestDvd.erzeugeDvd(titel, laufzeit, altersfreigabe);
        titel = "Herr der Ringe";
        laufzeit = 320;
        altersfreigabe = 12;
        Object dvd2 = TestDvd.erzeugeDvd(titel, laufzeit, altersfreigabe);

        // DVDs hinzufügen
        Class<?>[] parameterListeHinzufuegen = {Dvd.class};
        Object[] argumentenListeHinzufuegen = {dvd1};
        werteMethodeAus(dvdSammlung, BEZEICHNER_DVD_HINZUEFUEGEN,
                parameterListeHinzufuegen, argumentenListeHinzufuegen);
        argumentenListeHinzufuegen[0] = dvd2;
        werteMethodeAus(dvdSammlung, BEZEICHNER_DVD_HINZUEFUEGEN,
                parameterListeHinzufuegen, argumentenListeHinzufuegen);

        // Prüfe, ob Zugriff auf 2 und 3 eine Exception wirft
        Object[] argumentenListe = {new Integer(2)};
        try {
            werteMethodeAusKeineAusnahmebehandlung(dvdSammlung,
                    BEZEICHNER_GET_DVD_BY_INDEX, parameterListe, argumentenListe);
            assertTrue("IllegalArgumentException erwartet.", false);
        } catch (IllegalArgumentException e) {
            // Ok
        } catch (Throwable e) {
            assertTrue("False exception geworfen: " + e.getMessage(), false);
        }
    }

    @Test
    public void testGetDvdByTitleRegulaer() {
        Class<?>[] parameterListe = {String.class};
        assertTrue(
                "Klasse DvdSammlung hat nicht geforderte Methode "
                        + BEZEICHNER_GET_DVD_BY_TITLE + ".",
                hatMethode(DvdSammlung.class, BEZEICHNER_GET_DVD_BY_TITLE,
                        parameterListe));

        assertTrue(
                "Methode " + BEZEICHNER_GET_DVD_BY_TITLE + " hat falschen Rückgabetyp.",
                getRueckgabeTyp(DvdSammlung.class, BEZEICHNER_GET_DVD_BY_TITLE,
                        parameterListe) == Dvd.class);

        // Erzeuge DvdSammlung
        int arrayGroesse = 3;
        Object dvdSammlung = erzeugeDvdSammlung(arrayGroesse);
        String titel1 = "Stirb langsam";
        int laufzeit = 120;
        int altersfreigabe = 16;
        Object dvd1 = TestDvd.erzeugeDvd(titel1, laufzeit, altersfreigabe);
        String titel2 = "Herr der Ringe";
        laufzeit = 320;
        altersfreigabe = 12;
        Object dvd2 = TestDvd.erzeugeDvd(titel2, laufzeit, altersfreigabe);

        // Prüfe, ob bei leerer Sammlung null geliefert wird
        Object[] argumentenListe = {titel1};
        argumentenListe[0] = "Ungüliger Titel";
        Object ergebnis = werteMethodeAus(dvdSammlung, BEZEICHNER_GET_DVD_BY_TITLE,
                parameterListe, argumentenListe);
        Dvd ergebbnisDvd = (Dvd) ergebnis;
        assertNull("Ergebnis nicht wie erwartet null.", ergebbnisDvd);

        // DVDs hinzufügen
        Class<?>[] parameterListeHinzufuegen = {Dvd.class};
        Object[] argumentenListeHinzufuegen = {dvd1};
        werteMethodeAus(dvdSammlung, BEZEICHNER_DVD_HINZUEFUEGEN,
                parameterListeHinzufuegen, argumentenListeHinzufuegen);
        argumentenListeHinzufuegen[0] = dvd2;
        werteMethodeAus(dvdSammlung, BEZEICHNER_DVD_HINZUEFUEGEN,
                parameterListeHinzufuegen, argumentenListeHinzufuegen);

        // Prüfe, ob erste DVD korrekt geliefert wird
        argumentenListe[0] = titel1;
        ergebnis = werteMethodeAus(dvdSammlung, BEZEICHNER_GET_DVD_BY_TITLE,
                parameterListe, argumentenListe);
        ergebbnisDvd = (Dvd) ergebnis;
        assertTrue("DVD nicht korrekt zurückgegeben.", dvd1 == ergebbnisDvd);

        // Prüfe, ob zweite DVD korrekt geliefert wird.
        argumentenListe[0] = titel2;
        ergebnis = werteMethodeAus(dvdSammlung, BEZEICHNER_GET_DVD_BY_TITLE,
                parameterListe, argumentenListe);
        ergebbnisDvd = (Dvd) ergebnis;
        assertTrue("DVD nicht korrekt zurückgegeben.", dvd2 == ergebbnisDvd);
    }

    @Test
    public void testGetDvdByTitleFehler() {
        Class<?>[] parameterListe = {String.class};
        // Erzeuge DvdSammlung
        int arrayGroesse = 3;
        Object dvdSammlung = erzeugeDvdSammlung(arrayGroesse);
        String titel1 = "Stirb langsam";
        int laufzeit = 120;
        int altersfreigabe = 16;
        Object dvd1 = TestDvd.erzeugeDvd(titel1, laufzeit, altersfreigabe);
        String titel2 = "Herr der Ringe";
        laufzeit = 320;
        altersfreigabe = 12;
        Object dvd2 = TestDvd.erzeugeDvd(titel2, laufzeit, altersfreigabe);

        // Prüfe, ob bei leerer Sammlung null geliefert wird
        Object[] argumentenListe = {titel1};
        argumentenListe[0] = "Ungüliger Titel";
        Object ergebnis = werteMethodeAus(dvdSammlung, BEZEICHNER_GET_DVD_BY_TITLE,
                parameterListe, argumentenListe);
        Dvd ergebbnisDvd = (Dvd) ergebnis;
        assertNull("Ergebnis nicht wie erwartet null.", ergebbnisDvd);

        // DVDs hinzufügen
        Class<?>[] parameterListeHinzufuegen = {Dvd.class};
        Object[] argumentenListeHinzufuegen = {dvd1};
        werteMethodeAus(dvdSammlung, BEZEICHNER_DVD_HINZUEFUEGEN,
                parameterListeHinzufuegen, argumentenListeHinzufuegen);
        argumentenListeHinzufuegen[0] = dvd2;
        werteMethodeAus(dvdSammlung, BEZEICHNER_DVD_HINZUEFUEGEN,
                parameterListeHinzufuegen, argumentenListeHinzufuegen);

        // Prüfe, ob bei ungültgem Titel null geliefert wird
        argumentenListe[0] = "Ungüliger Titel";
        ergebnis = werteMethodeAus(dvdSammlung, BEZEICHNER_GET_DVD_BY_TITLE,
                parameterListe, argumentenListe);
        ergebbnisDvd = (Dvd) ergebnis;
        assertNull("Ergebnis nicht wie erwartet null.", ergebbnisDvd);
    }

    @Test
    public void testGetLaufzeitInSammlung() {
        Class<?>[] parameterListe = {};
        assertTrue(
                "Klasse DvdSammlung hat nicht geforderte Methode "
                        + BEZEICHNER_GET_LAUFZEIT_IN_SAMMLUNG + ".",
                hatMethode(DvdSammlung.class, BEZEICHNER_GET_LAUFZEIT_IN_SAMMLUNG,
                        parameterListe));

        assertTrue(
                "Methode " + BEZEICHNER_GET_LAUFZEIT_IN_SAMMLUNG
                        + " hat falschen Rückgabetyp",
                getRueckgabeTyp(DvdSammlung.class, BEZEICHNER_GET_LAUFZEIT_IN_SAMMLUNG,
                        parameterListe) == int.class);

        // Erzeuge DvdSammlung
        int arrayGroesse = 3;
        Object dvdSammlung = erzeugeDvdSammlung(arrayGroesse);

        // Erzeuge Dvds
        String titel1 = "Stirb langsam";
        int laufzeit1 = 120;
        int altersfreigabe = 16;
        Object dvd1 = TestDvd.erzeugeDvd(titel1, laufzeit1, altersfreigabe);

        String titel2 = "Herr der Ringe";
        int laufzeit2 = 320;
        altersfreigabe = 12;
        Object dvd2 = TestDvd.erzeugeDvd(titel2, laufzeit2, altersfreigabe);

        // Prüfe Laufzeit in Sammlung bei leerer Liste
        Object[] argumentenListe = {};
        Object ergebnis = werteMethodeAus(dvdSammlung,
                BEZEICHNER_GET_LAUFZEIT_IN_SAMMLUNG, parameterListe, argumentenListe);
        int laufzeitInSammlung = (Integer) ergebnis;
        assertTrue("Laufzeit für leere Sammlung nicht korrekt.",
                0 == laufzeitInSammlung);

        // DVDs hinzufügen
        Class<?>[] parameterListeHinzufuegen = {Dvd.class};
        Object[] argumentenListeHinzufuegen = {dvd1};
        werteMethodeAus(dvdSammlung, BEZEICHNER_DVD_HINZUEFUEGEN,
                parameterListeHinzufuegen, argumentenListeHinzufuegen);
        argumentenListeHinzufuegen[0] = dvd2;
        werteMethodeAus(dvdSammlung, BEZEICHNER_DVD_HINZUEFUEGEN,
                parameterListeHinzufuegen, argumentenListeHinzufuegen);

        // Prüfe Laufzeit in Sammlung bei Liste mit zwei Titeln
        ergebnis = werteMethodeAus(dvdSammlung, BEZEICHNER_GET_LAUFZEIT_IN_SAMMLUNG,
                parameterListe, argumentenListe);
        laufzeitInSammlung = (Integer) ergebnis;
        assertTrue("Laufzeit für Sammlung mit zwei Titeln nicht korrekt.",
                (laufzeit1 + laufzeit2) == laufzeitInSammlung);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetDvdsAbAlter() {
        Class<?>[] parameterListe = {int.class};
        assertTrue(
                "Klasse DvdSammlung hat nicht geforderte Methode "
                        + BEZEICHNER_GET_DVDS_BIS_ALTER + ".",
                hatMethode(DvdSammlung.class, BEZEICHNER_GET_DVDS_BIS_ALTER,
                        parameterListe));

        Class<?> rueckgabeTyp = getRueckgabeTyp(DvdSammlung.class,
                BEZEICHNER_GET_DVDS_BIS_ALTER, parameterListe);
        assertTrue(
                "Methode " + BEZEICHNER_GET_DVDS_BIS_ALTER + " hat falschen Rückgabetyp",
                rueckgabeTyp == List.class);

        List<TypeVariable<?>> typenVariablen =
                getGenericsTypenVariablen(rueckgabeTyp);
        assertTrue(
                "Rückgabe von" + BEZEICHNER_GET_DVDS_BIS_ALTER
                        + " sollte eine generische Liste zurückgeben.",
                typenVariablen.size() == 1);

        // Erzeuge DvdSammlung
        int arrayGroesse = 3;
        Object dvdSammlung = erzeugeDvdSammlung(arrayGroesse);

        // Erzeuge Dvds
        String titel1 = "Stirb langsam";
        int laufzeit1 = 120;
        int altersfreigabe = 16;
        Object dvd1 = TestDvd.erzeugeDvd(titel1, laufzeit1, altersfreigabe);

        String titel2 = "Herr der Ringe";
        int laufzeit2 = 320;
        altersfreigabe = 12;
        Object dvd2 = TestDvd.erzeugeDvd(titel2, laufzeit2, altersfreigabe);

        // Prüfe getListAbAbAlter bei leerer Sammlung.
        Object[] argumentenListe = {12};
        Object ergebnis = werteMethodeAus(dvdSammlung, BEZEICHNER_GET_DVDS_BIS_ALTER,
                parameterListe, argumentenListe);
        List<Dvd> liste = (List<Dvd>) ergebnis;
        assertTrue("Dvds aber Alter 12 sollte bei leerer Sammlung leer sein.",
                0 == liste.size());

        // DVDs hinzufügen
        Class<?>[] parameterListeHinzufuegen = {Dvd.class};
        Object[] argumentenListeHinzufuegen = {dvd1};
        werteMethodeAus(dvdSammlung, BEZEICHNER_DVD_HINZUEFUEGEN,
                parameterListeHinzufuegen, argumentenListeHinzufuegen);
        argumentenListeHinzufuegen[0] = dvd2;
        werteMethodeAus(dvdSammlung, BEZEICHNER_DVD_HINZUEFUEGEN,
                parameterListeHinzufuegen, argumentenListeHinzufuegen);

        // Prüfe Liste bei nicht-leerer Sammlung
        argumentenListe[0] = 12;
        ergebnis = werteMethodeAus(dvdSammlung, BEZEICHNER_GET_DVDS_BIS_ALTER,
                parameterListe, argumentenListe);
        liste = (List<Dvd>) ergebnis;
        assertTrue("Sammlung sollte eine DVD ab 12 beinhalten.",
                1 == liste.size() && dvd2 == liste.get(0));
    }
}
