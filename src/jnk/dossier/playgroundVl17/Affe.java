package jnk.dossier.playgroundVl17;

public class Affe extends Tier {
    public Affe(String name) {
        super(name);
    }

    @Override
    public void lautMachen() {
        System.out.println("Hello");
    }

    @Override
    public String getName() {
        return "Affe " + super.getName();
    }
}
