package jnk.laborpruefung.midterm; /**
 * Basisklasse für die Tests in Laborprüfungen.
 * <p>
 * Hochschule für Angewandte Wissenschaften, Hamburg
 * Prof. Dr. Philipp Jenke
 */

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

/**
 * Die Klasse beinhaltet gemeinsame Funktionalität für die davon erbenden
 * Testklassen, die einzelne Klassen testen.
 *
 * @author Philipp Jenke
 */
public abstract class TestBasisklasse {

    /**
     * Prüft, ob ein Sichtbarkeitsmodifizierer public ist.
     */
    protected static final Predicate<Integer> istPublic = (
            Integer modifizierer) -> {
        return Modifier.isPublic(modifizierer);
    };

    /**
     * Prüft, ob ein Sichtbarkeitsmodifizierer private ist.
     */
    protected static final Predicate<Integer> istPrivate = (
            Integer modifizierer) -> {
        return Modifier.isPrivate(modifizierer);
    };

    /**
     * Prüft, ob ein Sichtbarkeitsmodifizierer static ist.
     */
    protected static final Predicate<Integer> istStatic = (
            Integer modifizierer) -> {
        return Modifier.isStatic(modifizierer);
    };

    /**
     * Prüft, ob ein Sichtbarkeitsmodifizierer final ist.
     */
    protected static final Predicate<Integer> istFinal = (
            Integer modifizierer) -> {
        return Modifier.isFinal(modifizierer);
    };

    /**
     * Prüft, ob die Sichtbarkeit der Methode methodenName mit der Parameterliste
     * parameterTypen dem Sichtbarkeitsprädikat entspricht.
     */
    protected boolean methodeHatModifizierer(Class<?> klasse,
                                             String methodenBezeichner, Class<?>[] parameterTypen,
                                             Predicate<Integer> sichtbarkeitsPraedikat) {
        try {
            Method methode = klasse.getDeclaredMethod(methodenBezeichner,
                    parameterTypen);
            methode.setAccessible(true);
            int modifizierer = methode.getModifiers();
            if (!sichtbarkeitsPraedikat.test(modifizierer)) {
                return false;
            }
            return true;
        } catch (NoSuchMethodException | SecurityException e) {
            return false;
        }
    }

    /**
     * Prüft, ob die Sichtbarkeit der Objektvariablen objektVariablenBezeichner
     * dem Sichtbarkeitsprädikat entspricht.
     */
    protected boolean objektvariableHatModifizierer(Class<?> klasse,
                                                    String objektVariablenBezeichner,
                                                    Predicate<Integer> sichtbarkeitsPraedikat) {
        try {
            Field objektVariablenFeld = klasse
                    .getDeclaredField(objektVariablenBezeichner);
            objektVariablenFeld.setAccessible(true);
            int modifizierer = objektVariablenFeld.getModifiers();
            if (!sichtbarkeitsPraedikat.test(modifizierer)) {
                return false;
            }
            return true;
        } catch (NoSuchFieldException | SecurityException e) {
            return false;
        }
    }

    /**
     * Prüft, ob die Sichtbarkeit der Klasse klasse
     * dem Sichtbarkeitsprädikat entspricht.
     */
    protected boolean klasseHatModifizierer(Class<?> klasse, Predicate<Integer> sichtbarkeitsPraedikat) {
        try {
            int modifizierer = klasse.getModifiers();
            if (!sichtbarkeitsPraedikat.test(modifizierer)) {
                return false;
            }
            return true;
        } catch (SecurityException e) {
            return false;
        }
    }

    /**
     * Prüft, ob der Konstruktor den angefragten Modifizierer hat.
     */
    protected boolean konstruktorHatModifizierer(
            Class<?> klasse, Class<?>[] params, Predicate<Integer> sichtbarkeitsPraedikat) {
        try {
            Constructor<?> konstruktor = klasse.getDeclaredConstructor(params);
            int modifizierer = konstruktor.getModifiers();
            return sichtbarkeitsPraedikat.test(modifizierer);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Testet eine Getter-Methode.
     */
    protected Object getWertVonGetter(Object instanz,
                                      String variablenName) throws LaborpruefungException {
        String methodenBezeichner = erstelleGetterBezeichner(variablenName);
        Class<?>[] parameterTypListe = new Class<?>[0];
        Object[] parameterWertListe = {};

        if (!methodeHatModifizierer(instanz.getClass(), methodenBezeichner,
                parameterTypListe, istPublic)) {
            return false;
        }

        hatMethode(instanz.getClass(), methodenBezeichner, parameterTypListe);
        try {
            Object rueckgabeWert = methodeAufrufen(instanz, methodenBezeichner,
                    parameterTypListe, parameterWertListe);
            return rueckgabeWert;
        } catch (Exception e) {
            throw new LaborpruefungException("Fehler beim Verwenden des Getters für " + variablenName);
        }
    }

    /**
     * Ruft die angegeben Methode auf und liefert den Rückgabewert der Methode
     * zurück.
     */
    protected Object methodeAufrufen(
            Object instanz, String methodenBezeichner, Class<?>[] parameterTypListe,
            Object[] parameterWertListe) throws LaborpruefungException {
        Method methode = getMethode(instanz.getClass(), methodenBezeichner,
                parameterTypListe);
        if (methode == null) {
            throw new LaborpruefungException("Fehler beim Aufrufen der Methode " + methodenBezeichner);
        }
        // Aufrufen der Methode
        try {
            methode.setAccessible(true);
            return methode.invoke(instanz, parameterWertListe);
        } catch (IllegalAccessException | IllegalArgumentException
                 | InvocationTargetException | SecurityException e) {
            throw new LaborpruefungException("Fehler beim Aufrufen der Methode " + methodenBezeichner);
        }
    }

    /**
     * Ruft die angegeben Methode auf und liefert den Rückgabewert der Methode
     * zurück. Wirft auch die Exception zurück, die die Methode beim Aufrufen geworfen hat.
     */
    protected Object methodeAufrufenExceptionErwartet(
            Object instanz, String methodenBezeichner, Class<?>[] parameterTypListe,
            Object[] argumentListe) throws Throwable {
        // Methode suchen
        Method methode = getMethode(instanz.getClass(), methodenBezeichner,
                parameterTypListe);
        if (methode == null) {
            throw new LaborpruefungException("Fehler beim Aufrufen der Methode " + methodenBezeichner);
        }
        // Aufrufen der Methode
        methode.setAccessible(true);

        try {
            return methode.invoke(instanz, argumentListe);
        } catch (IllegalAccessException | IllegalArgumentException e) {
            // Handle exceptions related to method call.
            throw new LaborpruefungException("Fehler beim Aufrufen der Methode " + methodenBezeichner);
        } catch (InvocationTargetException e) {
            // Pass exception to caller.
            throw e.getTargetException();
        }
    }

    /**
     * Ruft die angegebe Methode auf und liefert den Rückgabewert der Methode
     * zurück. Bequemlichkeitsmethode: keine Argumente.
     */
    protected Object methodeAufrufen(Object instanz, String methodenBezeichner)
            throws LaborpruefungException {
        return methodeAufrufen(instanz, methodenBezeichner, new Class<?>[]{},
                new Object[]{});
    }

    /**
     * Ruft die angegeben statische Methode auf und liefert den Rückgabewert der
     * Methode zurück.
     */
    protected Object methodeAufrufenStatic(
            Class<?> klasse, String methodenBezeichner, Class<?>[] parameterTypListe,
            Object[] parameterWertListe) throws LaborpruefungException {
        Method methode = getMethode(klasse, methodenBezeichner, parameterTypListe);
        if (methode == null) {
            throw new LaborpruefungException("Fehler beim Aufrufen der statischen Methode " + methodenBezeichner);
        }

        // Aufrufen der Methode
        try {
            if (!(Modifier.isStatic(methode.getModifiers()))) {
                // Hier können nur statische Methoden aufgerufen werden.
                throw new LaborpruefungException("Fehler beim Aufrufen der statischen Methode " + methodenBezeichner);
            }
            methode.setAccessible(true);
            return methode.invoke(null, parameterWertListe);
        } catch (Exception e) {
            throw new LaborpruefungException("Fehler beim Aufrufen der statischen Methode " + methodenBezeichner);
        }
    }

    /**
     * Prüft, ob die Methode methodenName mit Parameter-Typen-Liste
     * parameterTypListe existiert.
     */
    protected boolean hatMethode(Class<?> klasse, String methodenName,
                                 Class<?>[] parameterTypListe) {
        try {
            Method method = klasse.getDeclaredMethod(methodenName, parameterTypListe);
            return method != null;
        } catch (NoSuchMethodException | SecurityException e) {
            return false;
        }
    }

    protected Class<?> getRueckgabeTyp(
            Class<?> klasse, String methodenBezeichner,
            Class<?>[] parameterListe) throws LaborpruefungException {
        Method methode = getMethode(klasse, methodenBezeichner, parameterListe);
        if (methode == null) {
            throw new LaborpruefungException("Fehler beim Bestimmen des Rückgabetyps von " + methodenBezeichner);
        }
        return methode.getReturnType();
    }

    /**
     * Liefert das Methoden-Objekt zu einer Methode. Liefert null, falls die
     * Methode nicht gefunden wurde.
     */
    protected Method getMethode(Class<?> klasse, String methodenBezeichner,
                                Class<?>[] parameterTypListe) throws LaborpruefungException {
        // Versuche Methode in der aktuellen Klasse zu finden.
        Method methode = null;
        try {
            methode = klasse.getDeclaredMethod(methodenBezeichner, parameterTypListe);
        } catch (NoSuchMethodException e1) {
            // Versuche Methode einer Elternklasse zu finden.
            try {
                methode = klasse.getMethod(methodenBezeichner, parameterTypListe);
            } catch (NoSuchMethodException e2) {
                throw new LaborpruefungException("Fehler beim Zugriff auf die Methode " + methodenBezeichner);
            }
        }
        return methode;
    }

    /**
     * Prüft, ob ein Konstruktor mit Parameter-Typen-Liste parameterTypListe
     * existiert.
     */
    protected boolean hatKonstruktor(Class<?> klasse, Class<?>[] parameterTypListe) {
        try {
            klasse.getDeclaredConstructor(parameterTypListe);
            return true;
        } catch (NoSuchMethodException | SecurityException e) {
            return false;
        }
    }

    /**
     * Prüft, ob ein Konstruktor mit einem String-Varargs-Param vorhanden ist.
     */
    protected boolean hatStringVarArgsKonstruktor(Class<?> klasse) {
        try {
            klasse.getDeclaredConstructor(String[].class);
            return true;
        } catch (NoSuchMethodException | SecurityException e) {
            return false;
        }
    }

    /**
     * Erzeugt den Bezeichner für den Getter einer ObjektVariable.
     */
    private String erstelleGetterBezeichner(String objektVariablenBezeichner) {
        return "get" + Character.toUpperCase(objektVariablenBezeichner.charAt(0))
                + objektVariablenBezeichner.substring(1,
                objektVariablenBezeichner.length());
    }

    /**
     * Setzt den Wert der Objektvariable bezeichner in dem Objekt instanz auf
     * wert.
     *
     * @param instanz             Objekt, dessen Variable gesetzt wird.
     * @param variablenBezeichner Bezeichner der Variablen, die gesetzt werden
     *                            soll.
     * @param wert                Wert der gesetzt werden soll.
     */
    protected void setObjektvariable(Object instanz,
                                     String variablenBezeichner, Object wert) throws LaborpruefungException {
        try {
            Field variablenFeld = instanz.getClass()
                    .getDeclaredField(variablenBezeichner);
            variablenFeld.setAccessible(true);
            variablenFeld.set(instanz, wert);
        } catch (Exception e) {
            throw new LaborpruefungException("Fehler bei Setzen der Objektvariablen " + variablenBezeichner);
        }
    }

    /**
     * Liefert den Wert einer Objektvariablen (Achtung: liefert auch null im
     * Fehlerfall!).
     */
    protected Object getWertObjektVariable(
            Object instanz, String objektVariablenBezeichner) throws LaborpruefungException {

        // Declared field
        try {
            Field objektVariablenFeld = instanz.getClass()
                    .getDeclaredField(objektVariablenBezeichner);
            objektVariablenFeld.setAccessible(true);
            return objektVariablenFeld.get(instanz);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
                 | IllegalAccessException e) {
            // This exception  is ok - no declared field found
            System.out.println(e);
        }

        // Other field
        Field objektVariablenFeld;
        try {
            objektVariablenFeld = instanz.getClass()
                    .getField(objektVariablenBezeichner);
            objektVariablenFeld.setAccessible(true);
            return objektVariablenFeld.get(instanz);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
                 | IllegalAccessException e) {
            // This exceptio  is ok - no other field found
            System.out.println(e);
        }

        throw new LaborpruefungException("Fehler beim Lesen der Objektvariablen " + objektVariablenBezeichner);
    }

    /**
     * Liefert den Wert einer geerbten Objektvariablen (nur direkte Elternklasse!)
     * (Achtung: liefert auch null im Fehlerfall!)
     */
    protected Object getWertObjektVariableElternklasse(
            Object instanz, String objektVariablenBezeichner) throws LaborpruefungException {
        try {
            Field objektVariablenFeld = instanz.getClass().getSuperclass()
                    .getDeclaredField(objektVariablenBezeichner);
            objektVariablenFeld.setAccessible(true);
            return objektVariablenFeld.get(instanz);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
                 | IllegalAccessException e) {
            throw new LaborpruefungException("Fehler beim Lesen der Objektvariablen aus Basisklasse " + objektVariablenBezeichner);
        }
    }

    /**
     * Liefert den Typ einer Objektvariablen
     */
    protected Class<?> getTypObjektvariable(Class<?> klasse,
                                            String variablenBezeichner) {
        try {
            Field field = klasse.getDeclaredField(variablenBezeichner);
            if (field != null) {
                return field.getType();
            }
        } catch (NoSuchFieldException | SecurityException e) {
            return null;
        }
        return null;
    }

    /**
     * Prüft, ob die Klasse eine Objektvariable bezeichner vom Typ typ hat.
     *
     * @param klasse              Klasse, die überprüft werden soll.
     * @param variablenBezeichner Name der Objektvariable
     * @param typ                 Erwarteter Typ der Objektvariable.
     */
    protected boolean hatObjektVariable(Class<?> klasse,
                                        String variablenBezeichner, Class<?> typ) {
        try {
            Field field = klasse.getDeclaredField(variablenBezeichner);
            if (field == null) {
                return false;
            }
            if (typ != field.getType()) {
                return false;
            }
            return true;
        } catch (NoSuchFieldException | SecurityException e) {
            return false;
        }
    }

    /**
     * Prüft ob die Klasse klasse das Interface iface implementiert.
     *
     * @param klasse Klasse, die das Interface implementieren soll.
     * @param iface  Interface auf das geprüft wird.
     */
    protected boolean implementiertInterface(Class<?> klasse,
                                             Class<?> iface) {
        Class<?>[] interfaces = klasse.getInterfaces();
        boolean interfaceGefunden = false;
        for (Class<?> interfaceCandidate : interfaces) {
            if (iface == interfaceCandidate) {
                interfaceGefunden = true;
                break;
            }
        }
        if (!interfaceGefunden) {
            return false;
        }
        return true;
    }

    protected boolean wirftMethodeException(Class<?> klasse,
                                            String methodenBezeichner, Class<?>[] parameterTypeListe,
                                            Class<?> exceptionKlasse) {
        try {
            Method methode = klasse.getDeclaredMethod(methodenBezeichner,
                    parameterTypeListe);
            Class<?>[] exceptions = methode.getExceptionTypes();

            if (!new HashSet<Class<?>>(Arrays.asList(exceptions))
                    .contains(exceptionKlasse)) {
                return false;
            }
            return true;
        } catch (NoSuchMethodException | SecurityException e) {
            return false;
        }
    }

    /**
     * Erzeugt eine Instanz der angegebenen Klasse. Bequemlichkeitsmethode für
     * erzeugeInstanz(Class<?> [] typen, Object [] parameter);
     *
     * @param klasse Klasse die instanziiert werden soll.
     * @return Erzeugtes Objekt, null, wenn etwas schief läuft.
     */
    protected Object erzeugeInstanz(Class<?> klasse) throws LaborpruefungException {
        return erzeugeInstanz(klasse, new Class<?>[]{}, new Object[]{});
    }

    /**
     * Erzeugt eine Instanz der angegebenen Klasse. Bequemlichkeitsmethode für
     * erzeugeInstanz(Class<?> [] typen, Object [] parameter);
     *
     * @param klasse Klasse die instanziiert werden soll.
     * @param typen  Liste der Parameter-Typen.
     * @param werte  Liste der Parameter-Werte.
     * @return Erzeugtes Objekt, null, wenn etwas schief läuft.
     */
    protected static Object erzeugeInstanz(Class<?> klasse, Class<?>[] typen,
                                           Object[] werte) throws LaborpruefungException {
        try {
            Constructor<?> konstruktor = klasse.getConstructor(typen);
            return konstruktor.newInstance(werte);
        } catch (NoSuchMethodException | SecurityException | InstantiationException
                 | IllegalAccessException | IllegalArgumentException
                 | InvocationTargetException e) {
            throw new LaborpruefungException("Fehler beim Erzeugen einer Instanz der Klasse " + klasse);
        }
    }

    /**
     * Erzeugt eine Instanz der angegebenen Klasse, wobei die Parameter als vargs
     * gegeben sind. Bequemlichkeitsmethode für erzeugeInstanz(Class<?> [] typen,
     * Object [] parameter);
     *
     * @param klasse Klasse die instanziiert werden soll.
     * @param werte  Liste der Parameter-Werte.
     * @return Erzeugtes Objekt, null, wenn etwas schief läuft.
     */
    protected Object erzeugeInstanzStringVarargs(Class<?> klasse,
                                                 Object[] werte) throws LaborpruefungException {
        try {
            Constructor<?> konstruktor = klasse.getConstructor(String[].class);
            return konstruktor.newInstance((Object) werte);
        } catch (NoSuchMethodException | SecurityException | InstantiationException
                 | IllegalAccessException | IllegalArgumentException
                 | InvocationTargetException e) {
            throw new LaborpruefungException("Fehler beim Erzeugen einer Instanz der Klasse " + klasse);
        }
    }

    /**
     * Liefert das Class-Objekt des enums enumBezeichner in der Klasse klasse;
     *
     * @param klasse         Klasse in der nach dem Enum gesucht wird.
     * @param enumBezeichner Bezeichner des Enums
     * @return Class-Objekt, falls der Enum existiert, ansonsten null;
     */
    public Class<?> getEnum(Class<?> klasse, String enumBezeichner) throws LaborpruefungException {
        try {
            Class<?>[] innereKlassen = klasse.getDeclaredClasses();
            for (Class<?> innereKlasse : innereKlassen) {
                if (innereKlasse.getName().endsWith(enumBezeichner)) {
                    if (innereKlasse.isEnum()) {
                        return innereKlasse;
                    }
                }
            }
            return null;
        } catch (SecurityException e) {
            throw new LaborpruefungException("Fehler beim Zugriff auf den Enum " + enumBezeichner);
        }
    }

    /**
     * Liefert die enum-Konstante zu einem Bezeichner
     *
     * @param enumKlasse           Klassen-Objekt des enums.
     * @param konstantenBezeichner Bezeichner der Konstante
     * @return Gesuchte Konstante oder null, falls sie nicht gefunden werden kann.
     */
    protected Object getEnumKonstante(Class<?> enumKlasse,
                                      String konstantenBezeichner) throws LaborpruefungException {
        if (!enumKlasse.isEnum()) {
            throw new LaborpruefungException("Fehler beim Zugriff auf Enum-Konstante " + konstantenBezeichner);
        }
        Object[] konstanten = enumKlasse.getEnumConstants();
        if (konstanten == null) {
            throw new LaborpruefungException("Fehler beim Zugriff auf Enum-Konstante " + konstantenBezeichner);
        }
        return methodeAufrufenStatic(enumKlasse, "valueOf",
                new Class<?>[]{String.class}, new Object[]{konstantenBezeichner});
    }

    /**
     * Liefert den ordinal einer enum-Konstanten. Liefert -1, falls die Konstante
     * nicht gefunden werden kann.
     */
    protected int getEnumOrdinal(Class<?> enumKlasse,
                                 String konstantenBezeichner) throws LaborpruefungException {
        Object konstante = getEnumKonstante(enumKlasse, konstantenBezeichner);
        Object[] konstanten = enumKlasse.getEnumConstants();
        for (int i = 0; i < konstanten.length; i++) {
            if (konstante.equals(konstanten[i])) {
                return i;
            }
        }
        throw new LaborpruefungException("Fehler beim Zugriff auf Enum-Konstante " + konstantenBezeichner);
    }

    /**
     * Liefert ein Array der Konstanten des Enums.
     *
     * @param enumKlasse Klassen-Objekt des enums.
     * @return Array der Konstanten, null, falls ein Fehler aufgetreten ist.
     */
    protected Object[] getEnumKonstanten(Class<?> enumKlasse) throws LaborpruefungException {
        if (!enumKlasse.isEnum()) {
            throw new LaborpruefungException("Fehler beim Zugriff auf Enum " + enumKlasse);
        }
        Object[] konstanten = enumKlasse.getEnumConstants();
        return konstanten;
    }

    /**
     * Liefert die Liste der (generischen) Typenvariablen.
     */
    protected List<TypeVariable<?>> getGenericsTypenVariablen(Class<?> klasse) {
        TypeVariable<?>[] typenVariablen = klasse.getTypeParameters();
        return Arrays.asList(typenVariablen);
    }

    /**
     * Liefert wahr, wenn die Klasse klasse von der Basisklasse basisklasse erbt.
     */
    public boolean erbtVon(Class<?> klasse, Class<?> basisklasse) {
        return klasse.getSuperclass().equals(basisklasse);
    }
}
