package jnk.dossier.playgroundVl17;

public abstract class Tier {
    protected String name;

    public Tier(String name) {
        this.name = name;
    }

    public abstract void lautMachen();

    public String getName() {
        return name;
    }
}
