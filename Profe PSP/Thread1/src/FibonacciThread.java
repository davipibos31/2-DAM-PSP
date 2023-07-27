public class FibonacciThread extends Thread {
    private int num = 0;

    public FibonacciThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("El resultado de fibonacci: "+utils.fibbonacci(this.num));
    }
}
