package jnk.praktika.aufgabe5;

public class Oder extends BinaeresGatter {

    public Oder(Gatter operand1, Gatter operand2) {
        super(operand1, operand2);
    }

    @Override
    public boolean getOutput() {
        return getOperand1().getOutput() || getOperand2().getOutput();
    }

    @Override
    public String toString() {
        //return "(" + getOperand1().toString().toUpperCase() + " ODER " + getOperand2().toString().toUpperCase() + ")";
        return String.format("%s%s ODER %s%s", "(", getOperand1().toString().toUpperCase(), getOperand2().toString().toUpperCase(), ")");
    }
}