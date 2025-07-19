package jnk.laborpruefung.labor18.interfaces_vererbung;

public class Affe implements Saeugetier {
    private String name;

    public Affe(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
