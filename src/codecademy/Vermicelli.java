package codecademy;

public class Vermicelli extends Noodle { // protected ?
    public Vermicelli() {
        super(2, 10);
        noodleType = "codecademy.Vermicelli";
        ingredient = "durum wheat";
    }

    @Override
    protected void cook(String sauce) {
        System.out.println(noodleType + " is not just some type of " + dishType + ". It's italian!\nCook it for "
                + cookingTime + " minutes and add some " + sauce + " sauce. Buon appetito!");
    }

}
