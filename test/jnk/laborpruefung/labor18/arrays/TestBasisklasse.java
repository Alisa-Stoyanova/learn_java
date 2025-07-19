/**
 * Laborprüfung Mini-Übungen.
 * Hochschule für Angewandte Wissenschaften, Hamburg
 * Prof. Dr. Philipp Jenke
 */
package jnk.laborpruefung.labor18.arrays;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

/**
 * Die Klasse beinhaltet gemeinsame Funktionalität für die davon erbenden
 * Testklassen, die einzelne Klassen testen.
 * 
 * @author Philipp Jenke
 *
 */
public abstract class TestBasisklasse {

  protected boolean verbose = false;

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
   * Bezeichner der Methode valueOf.
   */
  private static final String METHODE_VALUE_OF = "valueOf";

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
  protected boolean objektvariablenHatModifizierer(Class<?> klasse,
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
   * Testet eine Getter-Methode.
   */
  protected boolean testGetter(Object instanz, Object erwarteterRueckgabeWert,
      String variablenName) {
    String methodenBezeichner = erstelleGetterBezeichner(variablenName);
    Class<?>[] parameterTypListe = new Class<?>[0];
    Object[] parameterWertListe = {};

    if (!methodeHatModifizierer(instanz.getClass(), methodenBezeichner,
        parameterTypListe, istPublic)) {
      return false;
    }
    setzeObjektvariable(instanz, variablenName, erwarteterRueckgabeWert);
    hatMethode(instanz.getClass(), methodenBezeichner, parameterTypListe);
    try {
      Object rueckgabeWert = werteMethodeAus(instanz, methodenBezeichner,
          parameterTypListe, parameterWertListe);
      if ((erwarteterRueckgabeWert == null && rueckgabeWert == null)
          || erwarteterRueckgabeWert.equals(rueckgabeWert)) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Ruft die angegeben Methode auf und liefert den Rückgabewert der Methode
   * zurück. Liefert null bei einem Fehler (Achtung: keine Unterschreidung,
   * falls null erwartet!)
   */
  protected Object werteMethodeAus(Object instanz, String methodenBezeichner,
      Class<?>[] parameterTypListe, Object[] parameterWertListe) {
    Method methode = getMethode(instanz.getClass(), methodenBezeichner,
        parameterTypListe);
    if (methode == null) {
      return null;
    }
    // Aufrufen der Methode
    try {
      methode.setAccessible(true);
      return methode.invoke(instanz, parameterWertListe);
    } catch (IllegalAccessException | IllegalArgumentException
        | InvocationTargetException | SecurityException e) {
      return null;
    }
  }

  /**
   * Ruft die angegeben Methode auf und liefert den Rückgabewert der Methode
   * zurück. Liefert null bei einem Fehler (Achtung: keine Unterschreidung,
   * falls null erwartet!). Macht keine Exception-Behandlung.
   * 
   * @throws InvocationTargetException
   * @throws IllegalArgumentException
   * @throws IllegalAccessException
   */
  protected Object werteMethodeAusKeineAusnahmebehandlung(Object instanz,
      String methodenBezeichner, Class<?>[] parameterTypListe,
      Object[] parameterWertListe) throws Throwable {
    // Methode suchen
    Method methode = getMethode(instanz.getClass(), methodenBezeichner,
        parameterTypListe);
    if (methode == null) {
      return null;
    }
    // Aufrufen der Methode
    methode.setAccessible(true);
    try {
      return methode.invoke(instanz, parameterWertListe);
    } catch (IllegalAccessException | IllegalArgumentException e) {
    } catch (InvocationTargetException e) {
      throw e.getTargetException();
    }
    return null;
  }

  /**
   * Ruft die angegebe Methode auf und liefert den Rückgabewert der Methode
   * zurück. Bequemlichkeitsmethode: keine Argumente (Achtung: keine
   * Unterscheidung, falls null erwartet!)
   */
  protected Object werteMethodeAus(Object instanz, String methodenBezeichner) {
    try {
      return werteMethodeAus(instanz, methodenBezeichner, new Class<?>[] {},
          new Object[] {});
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Ruft die angegeben statische Methode auf und liefert den Rückgabewert der
   * Methode zurück ( Achtung: keine Unterscheidung, falls null erwartet!)
   */
  protected Object werteStatischeMethodeAus(Class<?> klasse,
      String methodenBezeichner, Class<?>[] parameterTypListe,
      Object[] parameterWertListe) {
    Method methode = getMethode(klasse, methodenBezeichner, parameterTypListe);
    if (methode == null) {
      return null;
    }

    // Aufrufen der Methode
    try {
      if (!(Modifier.isStatic(methode.getModifiers()))) {
        // Hier können nur statische Methoden aufgerufen werden.
        return null;
      }
      methode.setAccessible(true);
      return methode.invoke(null, parameterWertListe);
    } catch (IllegalAccessException | IllegalArgumentException
        | InvocationTargetException | SecurityException e) {
      return null;
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

  protected Class<?> getRueckgabeTyp(Class<?> klasse, String methodenBezeichner,
      Class<?>[] parameterListe) {
    Method methode = getMethode(klasse, methodenBezeichner, parameterListe);
    if (methode == null) {
      return null;
    }
    return methode.getReturnType();
  }

  /**
   * Liefert das Methoden-Objekt zu einer Methode. Liefert null, falls die
   * Methode nicht gefunden wurde.
   */
  private Method getMethode(Class<?> klasse, String methodenBezeichner,
      Class<?>[] parameterTypListe) {
    // Versuche Methode in der aktuellen Klasse zu finden.
    Method methode = null;
    try {
      methode = klasse.getDeclaredMethod(methodenBezeichner, parameterTypListe);
    } catch (NoSuchMethodException e1) {
      // Versuche Methode einer Elternklasse zu finden.
      try {
        methode = klasse.getDeclaredMethod(methodenBezeichner,
            parameterTypListe);
      } catch (NoSuchMethodException e2) {
        // Methode kann nicht gefunden werden.
        return null;
      }
    }
    return methode;
  }

  /**
   * Prüft, ob ein Konstruktor mit Parameter-Typen-Liste parameterTypListe
   * existiert.
   */
  protected boolean hatKonstruktor(Class<?> klasse,
      Class<?>[] parameterTypListe) {
    try {
      klasse.getDeclaredConstructor(parameterTypListe);
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
  protected boolean setzeObjektvariable(Object instanz,
      String variablenBezeichner, Object wert) {
    try {
      Field variablenFeld = instanz.getClass()
          .getDeclaredField(variablenBezeichner);
      variablenFeld.setAccessible(true);
      variablenFeld.set(instanz, wert);
      return true;
    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
        | IllegalAccessException e) {
      return false;
    }
  }

  /**
   * Liefert den Wert einer Objektvariablen (Achtung: liefert auch null m
   * Fehlerfall!).
   */
  protected Object getWertObjektVariable(Object instanz,
      String objektVariablenBezeichner) {

    // Declared field
    try {
      Field objektVariablenFeld = instanz.getClass()
          .getDeclaredField(objektVariablenBezeichner);
      objektVariablenFeld.setAccessible(true);
      return objektVariablenFeld.get(instanz);
    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
        | IllegalAccessException e) {
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
    }

    return null;
  }

  /**
   * Liefert den Wert einer geerbten Objektvariablen (nur direkte Elternklasse!)
   * (Achtung: liefert auch null im Fehlerfall!)
   */
  protected Object getWertObjektVariableElternklasse(Object instanz,
      String objektVariablenBezeichner) {
    try {
      Field objektVariablenFeld = instanz.getClass().getSuperclass()
          .getDeclaredField(objektVariablenBezeichner);
      objektVariablenFeld.setAccessible(true);
      return objektVariablenFeld.get(instanz);
    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
        | IllegalAccessException e) {
      return null;
    }
  }

  /**
   * Testet, ob die Objektvariable mit dem Namen bezeichner in der Instance
   * instanz den Wert erwarteterWert hat.
   */
  protected boolean testWertVonObjektvariable(Object instanz,
      String variablenBezeichner, Object erwarteterWert) {
    try {
      Field nameFeld = instanz.getClass().getDeclaredField(variablenBezeichner);
      nameFeld.setAccessible(true);
      Object wert = nameFeld.get(instanz);
      if ((erwarteterWert == null && wert == null)
          || erwarteterWert.equals(wert)) {
        return true;
      } else {
        return false;
      }
    } catch (IllegalArgumentException | IllegalAccessException
        | NoSuchFieldException | SecurityException e) {
      return false;
    }
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
  protected boolean testImplementiertInterface(Class<?> klasse,
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
  protected Object erzeugeInstanz(Class<?> klasse) {
    return erzeugeInstanz(klasse, new Class<?>[] {}, new Object[] {});
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
      Object[] werte) {
    try {
      Constructor<?> konstruktor = klasse.getConstructor(typen);
      return konstruktor.newInstance(werte);
    } catch (NoSuchMethodException | SecurityException | InstantiationException
        | IllegalAccessException | IllegalArgumentException
        | InvocationTargetException e) {
      return null;
    }
  }

  /**
   * Erzeugt eine Instanz der angegebenen Klasse, wobei die Parameter als vargs
   * gegeben sind. Bequemlichkeitsmethode für erzeugeInstanz(Class<?> [] typen,
   * Object [] parameter);
   * 
   * @param klasse Klasse die instanziiert werden soll.
   * @param typen  Liste der Parameter-Typen.
   * @param werte  Liste der Parameter-Werte.
   * @return Erzeugtes Objekt, null, wenn etwas schief läuft.
   */
  protected Object erzeugeInstanzVarargs(Class<?> klasse, Class<?>[] typen,
      Object[] werte) {
    try {
      Constructor<?> konstruktor = klasse.getConstructor(typen);
      return konstruktor.newInstance((Object) werte);
    } catch (NoSuchMethodException | SecurityException | InstantiationException
        | IllegalAccessException | IllegalArgumentException
        | InvocationTargetException e) {
      return null;
    }
  }

  /**
   * Liefert das Class-Objekt des enums enumBezeichner in der Klasse klasse;
   * 
   * @param klasse         Klasse in der nach dem Enum gesucht wird.
   * @param enumBezeichner Bezeichner des Enums
   * @return Class-Objekt, falls der Enum existiert, ansonsten null;
   */
  public Class<?> getEnum(Class<?> klasse, String enumBezeichner) {
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
      return null;
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
      String konstantenBezeichner) {
    if (!enumKlasse.isEnum()) {
      return null;
    }
    Object[] konstanten = enumKlasse.getEnumConstants();
    if (konstanten == null) {
      return null;
    }
    return werteStatischeMethodeAus(enumKlasse, METHODE_VALUE_OF,
        new Class<?>[] { String.class }, new Object[] { konstantenBezeichner });
  }

  /**
   * Liefert den ordinal einer enum-Konstanten. Liefert -1, falls die Konstante
   * nicht gefunden werden kann.
   */
  protected int getEnumOrdinal(Class<?> enumKlasse,
      String konstantenBezeichner) {
    Object konstante = getEnumKonstante(enumKlasse, konstantenBezeichner);
    Object[] konstanten = enumKlasse.getEnumConstants();
    for (int i = 0; i < konstanten.length; i++) {
      if (konstante.equals(konstanten[i])) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Liefert ein Array der Konstanten des Enums.
   * 
   * @param enumKlasse Klassen-Objekt des enums.
   * @return Array der Konstanten, null, falls ein Fehler aufgetreten ist.
   */
  protected Object[] getEnumKonstanten(Class<?> enumKlasse) {
    if (!enumKlasse.isEnum()) {
      return null;
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

}
