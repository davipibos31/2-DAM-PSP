public class MyThread extends Thread{
    private Thread waitThread = null;
    public MyThread() {
        this.waitThread = null;
    }

    public MyThread(Thread waitThread) {
        this.waitThread = waitThread;
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
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
