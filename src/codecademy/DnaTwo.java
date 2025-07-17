package codecademy;

/**
 * Determines if a given strand of DNA is a protein.
 * A protein has the following qualities:
 * - begins with a “start codon”: ATG,
 * - ends with a “stop codon”: TGA,
 * - in between, each additional codon is a sequence of three nucleotides.
 */

public class DnaTwo {
    private String dnaStrand;
    private boolean isProtein;

    public DnaTwo(String dnaStrand) {
        this.dnaStrand = dnaStrand;
        this.isProtein = checkProtein();
    }

    public boolean checkProtein() {
        int length = this.dnaStrand.length();
        if (this.dnaStrand.startsWith("ATG")
                && this.dnaStrand.endsWith("TGA")
                && length % 3 == 0) {
            return true;
        } else return false;
    }

    public String toString() {
        return "DNA " + this.dnaStrand + " has protein: " + this.isProtein;
    }

    public static void main(String[] args) {

        DnaTwo dna1 = new DnaTwo("ATGCGATACGCTTGA");
        DnaTwo dna2 = new DnaTwo("ATGCGATACGTGA");
        DnaTwo dna3 = new DnaTwo("ATTAATATGTACTGA");

        System.out.println(dna1);
        System.out.println(dna2);
        System.out.println(dna3);
    }
}