package jnk.dossier.playgroundVl17;

public abstract class Rollenspielfigur {
    protected String name;

    public Rollenspielfigur(String name) {
        this.name = name;
    }

    public abstract void kaempfen();
}
