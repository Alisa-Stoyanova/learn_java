package jnk.dossier.playgroundVl17;

public class RollenspielMain { // main in der abstrakten Klasse???
    public static void main(String[] args) {
        Elf dobby = new Elf("Dobby"); // nicht gut, wir wollen allgemein blaiben, sodass später ein Kaempfer zugewiesen werden kann
        dobby.kaempfen();
        dobby.zauberspruchSagen();

        Rollenspielfigur figur = new Elf("Legolas"); // besser
        figur.kaempfen();
        if (figur instanceof Elf) {
            ((Elf) figur).zauberspruchSagen();
        }
    }
}