package jnk.praktika.aufgabe4;

public class Zug {
    private Wagen ersterWagen;

/*    public Zug() {
    }

    public Zug(Zug z) {
        ersterWagen = z.ersterWagen; // TODO
    }*/

    public Wagen getErsterWagen() {
        return ersterWagen;
    }

    public void anhaengenIter(Wagen neuerWagen) {
        if (ersterWagen == null) {
            ersterWagen = neuerWagen;
        } else {
            Wagen current = ersterWagen;
            Wagen next = current.getNext();
            while (next != null) {
                current = next;
            }
            current.setNext(neuerWagen);
        }
    }

    public void anhaengenRec(Wagen neuerWagen) {
        addAtEnd(neuerWagen, ersterWagen);
    }

    private void addAtEnd(Wagen neuerWagen, Wagen current) {
        if (ersterWagen == null) {
            ersterWagen = neuerWagen;
        } else {
            Wagen next = current.getNext();
            if (next != null) {
                addAtEnd(neuerWagen, next);
            } else {
                current.setNext(neuerWagen);
            }
        }
    }

    public boolean abhaengen(Wagen wagen) {
        if (wagen == ersterWagen) {
            ersterWagen = ersterWagen.getNext();
            return true;
        }
        Wagen prev = ersterWagen;
        Wagen current = ersterWagen.getNext();
        while (current != null) {
            if (current.getID().equals(wagen.getID())) {
                prev.setNext(current.getNext());
                return true;
            }
            prev = current;
            current = current.getNext();
        }
        return false;
    }
}
