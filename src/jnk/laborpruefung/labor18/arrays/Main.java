package jnk.laborpruefung.labor18.arrays;

public class Main {
    public static void main(String[] args) {
        Aufgabe1 aufgabe1 = new Aufgabe1();
        double[] test = aufgabe1.einfuegen(new double[]{1.0, 2.0, 3.0}, 1, 7.0);

        for(double d:test){
            System.out.println(d);
        }

}
}
