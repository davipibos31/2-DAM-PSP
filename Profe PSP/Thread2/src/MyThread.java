public class MyThread extends Thread {

    private Thread waitThread = null;

    public MyThread(Thread waitThread) {
        this.waitThread = waitThread;
    }

    public MyThread() {
        this.waitThread = null;
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
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
