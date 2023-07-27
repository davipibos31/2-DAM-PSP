public abstract class Store {
    private double cash, drinkPrice;

    public Store(double drinkPrice) {
        this.drinkPrice = drinkPrice;
        this.cash = 0.0;
    }

    public void payDrinks(int numDrinks) {
        addCash(numDrinks * this.drinkPrice);
    }

    public abstract void welcome();

    public void addCash(double cash) {
        this.cash += cash;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }
}
