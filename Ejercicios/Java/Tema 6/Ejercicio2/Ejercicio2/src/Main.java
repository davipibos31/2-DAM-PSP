public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Thread t = new MultiplierThread(i);
            t.start();
        }
    }
}