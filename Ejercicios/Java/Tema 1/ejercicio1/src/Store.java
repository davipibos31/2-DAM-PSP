public abstract class Store {
    public abstract void Welcome();

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public double getCash() {
        return cash;
    }

    public void setDrinkPrice(double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    private double drinkPrice, cash;

    Store(double drinkPrice) {
        this.drinkPrice = drinkPrice;
        this.cash = 0.0;
    }
    public void payDrinks(int numOfDrinks) {
        cash = this.cash + (numOfDrinks * drinkPrice);
    }
    public void addCash(double cash) {
        this.cash += cash;
    }
}
