package codecademy;

class Bakery {
    Cake cake;
    double price;
    String info;

    public Bakery(Cake cake, double price) {
        Cake copyOfCake = new Cake(cake);
        this.cake = copyOfCake;
        this.price = price;

        // Uncomment line below
        copyOfCake.flavor = "vanilla";
        info = "The " + copyOfCake.flavor + " cupcake is €" + price;
    }

    public static void main(String[] args) {
        Cake chocolateSprinkle = new Cake("chocolate", true); // original object

        // Create an object that takes in an object as a parameter
        Bakery myBakery = new Bakery(chocolateSprinkle, 3.25);

        // Output a value of the parameter-object
        System.out.println("Our object sent as a parameter has a flavor value of " + myBakery.cake.flavor);

        // Output a value of original object
        System.out.println("Our original object has a flavor value of " + chocolateSprinkle.flavor);
    }
}