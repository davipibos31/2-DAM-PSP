public class Main {
    public static void main(String[] args) {
        LiquorStore ls= new LiquorStore(8.95, 20);
        ls.Welcome();
        ls.payDrinks(10);
        System.out.printf("total cash: %.2f\n", ls.getCash());

        Store storer= new Store(8.95){
            @Override
            public void Welcome() {
                System.out.println("store");
            }
        };

        storer.payDrinks(10);
        System.out.printf("total cash: %.2f\n", storer.getCash());
    }
}