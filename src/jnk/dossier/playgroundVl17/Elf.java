package jnk.dossier.playgroundVl17;

public class Elf extends Rollenspielfigur {

    public Elf(String name) {
        super(name);
    }

    @Override
    public void kaempfen() {
        System.out.println(name + " schießt einen Pfeil.");
    }

    public void zauberspruchSagen() {
        System.out.println("Expecto Patronum!");
    }
}
