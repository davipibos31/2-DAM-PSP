public class LiquorStore extends Store {
    private int tax;

    public LiquorStore(double drinkprice, int tax) {
        super(drinkprice);
        this.tax = tax;
    }
    @Override
    public void Welcome() {
        System.out.println("LiquorStore");
    }

    @Override
    public void payDrinks(int numOfDrinks) {
        super.payDrinks(numOfDrinks);
        addCash(numOfDrinks * this.getDrinkPrice() * tax / 100.0);
    }
}
