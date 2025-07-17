package jnk.dossier.dossier12;

public class HarmonicSeries {

    public static void main(String[] args) {
        System.out.println(harmonicSeriesRec(5)); // 137/60 = 2.2833333...
        System.out.println(harmonicSeriesRec(-5));
        System.out.println(harmonicSeriesRec(1));
        System.out.println(harmonicSeriesRec(23)); // 3.73429...

        System.out.println(harmonicSeriesIter(5)); // 137/60 = 2.2833333...
        System.out.println(harmonicSeriesIter(-5));
        System.out.println(harmonicSeriesIter(1));
        System.out.println(harmonicSeriesIter(23)); // 3.73429...
    }

    public static double harmonicSeriesRec(int nenner) {
        if (nenner <= 0) {
            return 0;
        }
        return 1.0 / nenner + harmonicSeriesRec(nenner - 1);
    }

    public static double harmonicSeriesIter(int nenner) {
        if (nenner <= 0) {
            return 0;
        }
        for (int i = 0; i < nenner; i++) {
            //TODO
        }
        return 1.0 / nenner + harmonicSeriesRec(nenner - 1);
    }
}
