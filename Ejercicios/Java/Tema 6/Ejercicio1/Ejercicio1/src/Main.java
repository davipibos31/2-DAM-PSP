public class Main {
    public static void main(String[] args) {
        System.out.println(Threads1.fibbonacci(10));
        Threads1 t = new Threads1();
        t.start();
        }
    }
