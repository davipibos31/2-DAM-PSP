public class Main {
    public static void main(String[] args) {
        LiquorStore ls = new LiquorStore(8.95, 20);
        ls.welcome();
        ls.payDrinks(10);
        System.out.printf("Total cash: %.2f\n", ls.getCash());

        Store joseStore = new Store(8.95) {
            @Override
            public void welcome() {
                System.out.println("joseStore");
            }
            @Override
            public void payDrinks(int numDrinks) {
                super.payDrinks(numDrinks);
                addCash(numDrinks * getDrinkPrice());
            }
        };
        joseStore.payDrinks(10);
        System.out.printf("Total joseStore cash: %.2f\n", joseStore.getCash());

    }
}