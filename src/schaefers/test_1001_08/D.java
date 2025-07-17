package schaefers.test_1001_08;

public class D {
    public static void main(String[] args) {
        Q q = new Q();
        System.out.println(q);
        q.o();
        L l = new P();
        System.out.println(l);
        l.o();
        K k = (P) l;
        System.out.println(k);
        k.o();
        l = q;
        ((Q) l).r();
        System.out.println(l);
    }
}
