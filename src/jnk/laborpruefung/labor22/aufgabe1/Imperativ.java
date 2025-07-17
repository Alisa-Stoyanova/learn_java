package jnk.laborpruefung.labor22.aufgabe1;

public class Imperativ {

    /**
     * In dieser main()-Methode können Sie die Methoden von Aufgabe 1 testen. Sie können hier auch die bestehenden
     * Vorgaben anpassen und weitere Aufrufe hinzufügen.
     */
    public static void main(String[] args) {
        Imperativ imp = new Imperativ();

        // Aufgabe 1.1
        System.out.println(imp.buchstabenkette('d'));

        // Aufgabe 1.2
        char[] charArray = imp.string2char(new String[]{"abc", "d", null, "ef"});
        if (charArray != null) {
            for (char c : charArray) {
                System.out.print(c + " ");
            }
        }

        // Aufgabe 1.3
        System.out.println(imp.auswerten("23 + 42"));
    }

    /**
     * Aufgabe 1.1
     */
    public String buchstabenkette(char buchstabe) { // 16 Min
        if (buchstabe >= 'a' && buchstabe <= 'z') {
            String result = "";
            for (int i = 0; i <= buchstabe - 'a'; i++) {
                result += buchstabe;
            }
            return result;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Aufgabe 1.2
     */
    public char[] string2char(String[] stringArray) {
        if (stringArray == null) {
            return new char[0];
        } else {
            String s = "";
            for (String string : stringArray) {
                if (string != null) {
                    for (int i = 0; i < string.length(); i++) {
                        s += string.charAt(i);
                    }
                }
            }
            char[] ary = new char[s.length()];
            for (int i = 0; i < ary.length; i++) {
                ary[i] = s.charAt(i);
            }
            return ary;
        }
    }

    public char[] string2char1(String[] stringArray) { // 15 Min
        if (stringArray == null) {
            return new char[0];
        } else {
            int len = 0;
            for (String string : stringArray) {
                if (string != null) {
                    len += string.length();
                }
            }
            char[] ary = new char[len];
            int counter = 0;
            for (int i = 0; i < stringArray.length; i++) {
                if (stringArray[i] != null) {
                    for (int j = 0; j < stringArray[i].length(); j++) {
                        ary[counter] = stringArray[i].charAt(j);
                        counter++;
                    }
                }
            }
            return ary;
        }
    }

    /**
     * Aufgabe 1.3
     */
    public int auswerten(String ausdruck) { // 7 Min
        String[] expressionAry = ausdruck.split(" ");
        if (expressionAry.length < 3) {
            throw new IllegalArgumentException();
        } else {
            String operator = expressionAry[1];
            int operand1 = Integer.valueOf(expressionAry[0]);
            int operand2 = Integer.valueOf(expressionAry[2]);
            if (operator.equals("+")) {
                return operand1 + operand2;
            } else if (operator.equals("-")) {
                return operand1 - operand2;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
