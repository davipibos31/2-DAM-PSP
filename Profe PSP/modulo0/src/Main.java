public class Main {
    public static void main(String[] args) {

        LiquorStore liquorStore = new LiquorStore();
        liquorStore.welcome();
        Store store1 = new Store() {
            @Override
            public void welcome() {
                System.out.println("Welcome to store1");
            }
        };
        store1.welcome();
    }
}