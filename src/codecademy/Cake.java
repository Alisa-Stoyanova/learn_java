package codecademy;

class Cake {
    String flavor;
    boolean sprinkles;

    public Cake(String flavor, boolean sprinkles) {
        this.flavor = flavor;
        this.sprinkles = sprinkles;
    }

    // copy constructor
    public Cake(Cake cakeToCopy) {
        flavor = cakeToCopy.flavor;
        sprinkles = cakeToCopy.sprinkles;
    }
}