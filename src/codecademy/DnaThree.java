package codecademy;/* Determines whether there is a protein in a strand of DNA.
A protein has the following qualities:
- begins with a “start codon”: ATG,
- ends with a “stop codon”: TGA,
- in between, each additional codon is a sequence of three nucleotides. */

public class DnaThree {
    private String dnaStrand;
    private boolean hasProtein;

    public DnaThree(String dnaStrand) {
        this.dnaStrand = dnaStrand;
        this.hasProtein = checkProtein();
    }

    public boolean checkProtein() {
        int length = this.dnaStrand.length();
        int idxATG = this.dnaStrand.indexOf("ATG");
        int idxTGA = this.dnaStrand.indexOf("TGA");
        if (idxATG >= 0 // begins with a start codon ATG
                && idxATG < idxTGA
                && idxTGA >= 6 // ends with a stop codon TGA
                && (idxTGA - idxATG) % 3 == 0) { // in between, each additional codon is a sequence of three nucleotides
            return true;
        } else return false;
    }

    public String toString() {
        return "DNA " + this.dnaStrand + " has protein: " + this.hasProtein;
    }

    public static void main(String[] args) {

        DnaThree dna1 = new DnaThree("abATGCGATACGCTTGA");
        DnaThree dna2 = new DnaThree("ATGCGATACGTGA");
        DnaThree dna3 = new DnaThree("tzuipTGAATG");

        System.out.println(dna1);
        System.out.println(dna2);
        System.out.println(dna3);
    }
}