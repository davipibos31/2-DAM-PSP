public class MultiplierThreads extends Thread {
    private int num = 0;
    private Thread waitThread = null;

    public MultiplierThreads(int num) {
        this.num = num;
    }

    public MultiplierThreads(Thread th, int i) {
        this.num = i;
        this.waitThread = th;
    }

    @Override
    public void run() {
        if (this.waitThread != null) {
            try {
                this.waitThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < 10; i++) {
            int result = this.num * i;
            System.out.println(this.num + " x " + i + " = " + result);
        }
    }
}
