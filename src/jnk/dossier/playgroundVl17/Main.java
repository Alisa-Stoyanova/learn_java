/*
package jnk.playgroundVl17;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(Hochschulperson.STUDENT.alter());
        System.out.println(Hochschulperson.PROFESSOR.alter());
        System.out.println(Hochschulperson.MITARBEITER.alter());
    }

    public enum Hochschulperson {
        STUDENT, PROFESSOR, MITARBEITER;

        public int alter() {
*/
/*            if (this == STUDENT) {
                return 24;
            } else if (this == PROFESSOR) {
                return 45;
            } else {
                return 41; // this == MITARBEITER
            }
        }*//*

            switch (this) {
                case STUDENT:
                    return 24;
                case PROFESSOR:
                    return 45;
                case MITARBEITER:
                    return 41;
                default:
                    return -1; // IDE zwingt, dass es einen default gibt
            }
        }
    }

    Scanner scanner = new Scanner(System.in);
    Double gleitkomma = scanner.nextDouble();
    gleitkomma++;

    double gleitkommaPrimitiv = gleitkomma;
    gleitkommaPrimitiv++;
    System.out.println((int)gleitkomma);
    System.out.println(gleitkomma.intValue());
}
*/
