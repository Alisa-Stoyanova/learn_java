package jnk.praktika.aufgabe5;

public abstract class BinaeresGatter implements Gatter {
    // alternatively make both object variables protected, so that the classes that extend BinaeresGatter have access to them
    private Gatter operand1;
    private Gatter operand2;

    protected BinaeresGatter(Gatter operand1, Gatter operand2) {
        if (operand1 == null || operand2 == null) {
            throw new IllegalArgumentException("Ein oder beide der Argumenten sind ungültig.");
        }
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public Gatter getOperand1() {
        return operand1;
    }

    public Gatter getOperand2() {
        return operand2;
    }

/*  // no need, because Und and Oder also implement Gatter via inheritance of BinaeresGatter
    @Override
    public abstract boolean getOutput();

    @Override
    public abstract String toString();*/
}
