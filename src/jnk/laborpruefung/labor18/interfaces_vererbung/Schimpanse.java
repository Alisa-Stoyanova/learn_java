package jnk.laborpruefung.labor18.interfaces_vererbung;

public class Schimpanse extends Affe {
    private int alter;

    public Schimpanse (String name, int alter) {
        super(name);
        this.alter = alter;
    }

    public int getAlter(){
        return alter;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        Schimpanse andererSchimpanse = (Schimpanse) o;

        return this.alter == andererSchimpanse.getAlter() && this.getName() == andererSchimpanse.getName();
    }
}
