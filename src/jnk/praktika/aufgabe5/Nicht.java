package jnk.praktika.aufgabe5;

public class Nicht implements Gatter {
    private final Gatter eingang;

    public Nicht(Gatter operand) {
        eingang = operand;
    }

    @Override
    public boolean getOutput() {
        return !eingang.getOutput();
    }

    @Override
    public String toString() {
        //return "(" + "NICHT " + eingang.toString().toUpperCase() + ")";
        return String.format("%sNICHT %s%s", "(", eingang.toString().toUpperCase(), ")");
    }
}
