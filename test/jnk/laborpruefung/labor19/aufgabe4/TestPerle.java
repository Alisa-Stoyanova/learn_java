package jnk.laborpruefung.labor19.aufgabe4;

import jnk.laborpruefung.labor19.base.TestBasisklasse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.*;

public class TestPerle extends TestBasisklasse {

    public static final String PACKAGE_NAME = "jnk.laborpruefung.labor19.aufgabe4";
    public static final String KLASSE_BEZEICHNER_PERLE = "Perle";
    public static final String VARIABLE_BEZEICHNER_NACHFOLGERIN = "nachfolgerin";
    public static final String METHODE_BEZEICHNER_SET_NACHFOLGERIN = "setNachfolgerin";
    public static final String METHODE_BEZEICHNER_EINFUEGEN = "einfuegen";
    public static final String METHODE_BEZEICHNER_ENTFERNEN = "entfernen";

    /**
     * Liefert das class-Objekt zu Perle.
     */
    public Class<?> getKlassePerle() {
        Class<?> klassePerle;
        try {
            klassePerle = Class.forName(PACKAGE_NAME + "." + KLASSE_BEZEICHNER_PERLE);
            return klassePerle;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /**
     * Setzt die Nachfolgerin einer Perle.
     */
    private void setNachfolgerin(Object perle, Object nachfolgerin) {
        Class<?> klassePerle = getKlassePerle();
        Class<?>[] parameterTypListe = new Class<?>[]{klassePerle};
        Object[] parameterListe = new Object[]{nachfolgerin};
        werteMethodeAus(perle, METHODE_BEZEICHNER_SET_NACHFOLGERIN,
                parameterTypListe, parameterListe);
    }

    @Test
    public void testPerle() {
        // Debugging
        System.out.println("Teste Klasse " + KLASSE_BEZEICHNER_PERLE + " ...");

        // Klasse
        Class<?> klassePerle = getKlassePerle();
        assertNotNull("Klasse " + KLASSE_BEZEICHNER_PERLE + " nicht gefunden.",
                klassePerle);

        // Objektvariable
        assertTrue(
                "Klasse " + KLASSE_BEZEICHNER_PERLE + " hat nicht die Objektvariable "
                        + VARIABLE_BEZEICHNER_NACHFOLGERIN,
                hatObjektVariable(klassePerle, VARIABLE_BEZEICHNER_NACHFOLGERIN,
                        klassePerle));

        // Setter
        Class<?>[] parameterTypListe = new Class<?>[]{klassePerle};
        assertTrue(
                "Klasse " + KLASSE_BEZEICHNER_PERLE + " hat nicht die Methode "
                        + METHODE_BEZEICHNER_SET_NACHFOLGERIN,
                hatMethode(klassePerle, METHODE_BEZEICHNER_SET_NACHFOLGERIN,
                        parameterTypListe));
        assertEquals(
                "Methode " + METHODE_BEZEICHNER_SET_NACHFOLGERIN
                        + " hat nicht den Rückgabetyp void",
                void.class, getRueckgabeTyp(klassePerle,
                        METHODE_BEZEICHNER_SET_NACHFOLGERIN, parameterTypListe));
        Object p1 = erzeugeInstanz(klassePerle);
        Object p2 = erzeugeInstanz(klassePerle);

        setNachfolgerin(p1, p2);
        Object nachfolgerin = getWertObjektVariable(p1,
                VARIABLE_BEZEICHNER_NACHFOLGERIN);
        assertEquals("Nachfolgerin nicht korrekt gesetzt", p2, nachfolgerin);
    }

    @Test
    public void testeEinfuegen() {
        // Debugging
        System.out.println("Teste Methode " + METHODE_BEZEICHNER_EINFUEGEN
                + " der Klasse " + KLASSE_BEZEICHNER_PERLE + " ...");

        Class<?> klassePerle = getKlassePerle();
        Class<?>[] parameterTypListe = new Class<?>[]{int.class, klassePerle};
        assertTrue(
                "Klasse " + KLASSE_BEZEICHNER_PERLE + " hat nicht die Methode "
                        + METHODE_BEZEICHNER_EINFUEGEN,
                hatMethode(klassePerle, METHODE_BEZEICHNER_EINFUEGEN,
                        parameterTypListe));
        assertEquals(
                "Methode " + METHODE_BEZEICHNER_EINFUEGEN
                        + " hat nicht den Rückgabetyp void",
                void.class, getRueckgabeTyp(klassePerle, METHODE_BEZEICHNER_EINFUEGEN,
                        parameterTypListe));

        Object p1 = erzeugeInstanz(klassePerle);
        Object p2 = erzeugeInstanz(klassePerle);
        Object p3 = erzeugeInstanz(klassePerle);
        Object pNeu = erzeugeInstanz(klassePerle);

        List<List<Object>> kettenVorher = new ArrayList<List<Object>>();
        List<List<Object>> kettenNachher = new ArrayList<>();
        List<Object[]> params = new ArrayList<>();

        // Testfall 1
        kettenVorher.add(Arrays.asList(p1, p2, p3));
        kettenNachher.add(Arrays.asList(p1, p2, pNeu, p3));
        params.add(new Object[]{1, pNeu});

        // Testfall 2
        kettenVorher.add(Arrays.asList(p1, p2));
        kettenNachher.add(Arrays.asList(p1, pNeu, p2));
        params.add(new Object[]{0, pNeu});

        // Testfall 3
        // 1 -> 2 , 1.insert(5, neu) -> 1 -> neu -> 2 ->
        kettenVorher.add(Arrays.asList(p1, p2));
        kettenNachher.add(Arrays.asList(p1, p2, pNeu));
        params.add(new Object[]{5, pNeu});

        for (int j = 0; j < kettenVorher.size(); j++) {
            List<Object> ketteVorher = kettenVorher.get(j);
            List<Object> ketteNachher = kettenNachher.get(j);
            Object[] param = params.get(j);

            // Kette vorher aufbauen
            for (int i = 0; i < ketteVorher.size(); i++) {
                setNachfolgerin(ketteVorher.get(i),
                        ketteVorher.get((i + 1) % ketteVorher.size()));
            }
            // Methodeaufruf: einfügen
            werteMethodeAus(p1, METHODE_BEZEICHNER_EINFUEGEN, parameterTypListe,
                    param);
            // Kette nachher evaluieren
            for (int i = 0; i < ketteNachher.size(); i++) {
                Object perle = ketteNachher.get(i);
                Object nachfolgerinErwartet = ketteNachher
                        .get((i + 1) % ketteNachher.size());
                Object nachfolgerinIst = getWertObjektVariable(perle,
                        VARIABLE_BEZEICHNER_NACHFOLGERIN);
                if (!nachfolgerinErwartet.equals(nachfolgerinIst)) {
                    System.out.println("What!!!");
                }
                assertEquals("Perle hat nicht die richtige (neue) Nachfolgerin.",
                        nachfolgerinErwartet, nachfolgerinIst);
            }
        }
        System.out.println("  " + kettenVorher.size() + " Testfälle erfolgreich.");
    }

    @Test
    public void testeEnfernen() {
        // Debugging
        System.out.println("Teste Methode " + METHODE_BEZEICHNER_ENTFERNEN
                + " der Klasse " + KLASSE_BEZEICHNER_PERLE + " ...");

        Class<?> klassePerle = getKlassePerle();
        Class<?>[] parameterTypListe = new Class<?>[]{int.class};
        assertTrue(
                "Klasse " + KLASSE_BEZEICHNER_PERLE + " hat nicht die Methode "
                        + METHODE_BEZEICHNER_ENTFERNEN,
                hatMethode(klassePerle, METHODE_BEZEICHNER_ENTFERNEN,
                        parameterTypListe));
        assertEquals(
                "Methode " + METHODE_BEZEICHNER_EINFUEGEN
                        + " hat nicht den Rückgabetyp " + KLASSE_BEZEICHNER_PERLE,
                klassePerle, getRueckgabeTyp(klassePerle, METHODE_BEZEICHNER_ENTFERNEN,
                        parameterTypListe));

        Object p1 = erzeugeInstanz(klassePerle);
        Object p2 = erzeugeInstanz(klassePerle);
        Object p3 = erzeugeInstanz(klassePerle);

        List<List<Object>> kettenVorher = new ArrayList<List<Object>>();
        List<List<Object>> kettenNachher = new ArrayList<>();
        List<Object[]> params = new ArrayList<>();
        List<Object> rueckgaben = new ArrayList<Object>();

        // Testfall 1
        kettenVorher.add(Arrays.asList(p1, p2, p3));
        kettenNachher.add(Arrays.asList(p1, p2));
        params.add(new Object[]{1});
        rueckgaben.add(p3);

        // Testfall 2
        kettenVorher.add(Arrays.asList(p1, p2, p3));
        kettenNachher.add(Arrays.asList(p1, p3));
        params.add(new Object[]{0});
        rueckgaben.add(p2);

        // Testfall 3
        // 1 -> 2 , 1.insert(5, neu) -> 1 -> neu -> 2 ->
        kettenVorher.add(Arrays.asList(p1, p2, p3));
        kettenNachher.add(Arrays.asList(p2, p3));
        params.add(new Object[]{5});
        rueckgaben.add(p1);

        for (int j = 0; j < kettenVorher.size(); j++) {
            List<Object> ketteVorher = kettenVorher.get(j);
            List<Object> ketteNachher = kettenNachher.get(j);
            Object[] param = params.get(j);

            // Kette vorher aufbauen
            for (int i = 0; i < ketteVorher.size(); i++) {
                setNachfolgerin(ketteVorher.get(i),
                        ketteVorher.get((i + 1) % ketteVorher.size()));
            }
            // Methodeaufruf: entfernen
            werteMethodeAus(p1, METHODE_BEZEICHNER_ENTFERNEN,
                    parameterTypListe, param);
            // Kette nachher evaluieren
            for (int i = 0; i < ketteNachher.size(); i++) {
                Object perle = ketteNachher.get(i);
                Object nachfolgerinErwartet = ketteNachher
                        .get((i + 1) % ketteNachher.size());
                Object nachfolgerinIst = getWertObjektVariable(perle,
                        VARIABLE_BEZEICHNER_NACHFOLGERIN);
                assertEquals("Perle hat nicht die richtige (neue) Nachfolgerin.",
                        nachfolgerinErwartet, nachfolgerinIst);

            }
        }
        System.out.println("  " + kettenVorher.size() + " Testfälle erfolgreich.");
    }

    @Test
    public void testeEnfernenRueckgabe() {
        // Debugging
        System.out.println("Teste Methode " + METHODE_BEZEICHNER_ENTFERNEN
                + " der Klasse " + KLASSE_BEZEICHNER_PERLE + " ...");

        Class<?> klassePerle = getKlassePerle();
        Class<?>[] parameterTypListe = new Class<?>[]{int.class};
        assertTrue(
                "Klasse " + KLASSE_BEZEICHNER_PERLE + " hat nicht die Methode "
                        + METHODE_BEZEICHNER_ENTFERNEN,
                hatMethode(klassePerle, METHODE_BEZEICHNER_ENTFERNEN,
                        parameterTypListe));
        assertEquals(
                "Methode " + METHODE_BEZEICHNER_EINFUEGEN
                        + " hat nicht den Rückgabetyp " + KLASSE_BEZEICHNER_PERLE,
                klassePerle, getRueckgabeTyp(klassePerle, METHODE_BEZEICHNER_ENTFERNEN,
                        parameterTypListe));

        Object p1 = erzeugeInstanz(klassePerle);
        Object p2 = erzeugeInstanz(klassePerle);
        Object p3 = erzeugeInstanz(klassePerle);

        List<List<Object>> kettenVorher = new ArrayList<List<Object>>();
        List<List<Object>> kettenNachher = new ArrayList<>();
        List<Object[]> params = new ArrayList<>();
        List<Object> rueckgaben = new ArrayList<Object>();

        // Testfall 1
        kettenVorher.add(Arrays.asList(p1, p2, p3));
        kettenNachher.add(Arrays.asList(p1, p2));
        params.add(new Object[]{1});
        rueckgaben.add(p3);

        // Testfall 2
        kettenVorher.add(Arrays.asList(p1, p2, p3));
        kettenNachher.add(Arrays.asList(p1, p3));
        params.add(new Object[]{0});
        rueckgaben.add(p2);

        // Testfall 3
        // 1 -> 2 , 1.insert(5, neu) -> 1 -> neu -> 2 ->
        kettenVorher.add(Arrays.asList(p1, p2, p3));
        kettenNachher.add(Arrays.asList(p2, p3));
        params.add(new Object[]{5});
        rueckgaben.add(p1);

        for (int j = 0; j < kettenVorher.size(); j++) {
            List<Object> ketteVorher = kettenVorher.get(j);
            Object[] param = params.get(j);

            // Kette vorher aufbauen
            for (int i = 0; i < ketteVorher.size(); i++) {
                setNachfolgerin(ketteVorher.get(i),
                        ketteVorher.get((i + 1) % ketteVorher.size()));
            }
            // Methodeaufruf: entfernen
            Object wert = werteMethodeAus(p1, METHODE_BEZEICHNER_ENTFERNEN,
                    parameterTypListe, param);
            assertEquals(
                    "Methode " + METHODE_BEZEICHNER_ENTFERNEN
                            + " liefert nicht die richtige Rückgabe",
                    rueckgaben.get(j), wert);
        }
        System.out.println("  " + kettenVorher.size() + " Testfälle erfolgreich.");
    }

}
