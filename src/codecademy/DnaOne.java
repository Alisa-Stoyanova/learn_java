package codecademy;

/**
 * Determines if a given strand of DNA is a protein.
 * A protein has the following qualities:
 * - begins with a “start codon”: ATG,
 * - ends with a “stop codon”: TGA,
 * - in between, each additional codon is a sequence of three nucleotides.
 */

public class DnaOne {
    private String dnaStrand;
    private boolean isProtein = false;

    public DnaOne(String dnaStrand) {
        this.dnaStrand = dnaStrand;
    }

    public void checkProtein() {
        int length = this.dnaStrand.length();
        if (this.dnaStrand.substring(0, 3).equals("ATG")
                && this.dnaStrand.substring(length - 3, length).equals("TGA")
                && this.dnaStrand.substring(3, length - 3).length() % 3 == 0) {
            isProtein = true;
        }
    }

    public static void main(String[] args) {

        DnaOne dna1 = new DnaOne("ATGCGATACGCTTGA");
        DnaOne dna2 = new DnaOne("ATGCGATACGTGA");
        DnaOne dna3 = new DnaOne("ATTAATATGTACTGA");

        dna1.checkProtein();
        dna2.checkProtein();
        dna3.checkProtein();

        System.out.println("DNA " + dna1.dnaStrand + " has protein: " + dna1.isProtein);
        System.out.println("DNA " + dna2.dnaStrand + " has protein: " + dna2.isProtein);
        System.out.println("DNA " + dna3.dnaStrand + " has protein: " + dna3.isProtein);
    }
}