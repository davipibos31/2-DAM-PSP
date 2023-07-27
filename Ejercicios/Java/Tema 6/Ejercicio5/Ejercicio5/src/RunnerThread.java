public class RunnerThread extends Thread {
    // Thread current number
    int num;
    // Thread to wait for before start our race
    Thread waitThread;

    public RunnerThread(String name) {
        this.setName(name);
        num = 1;
        waitThread = null;
    }

    public RunnerThread(String name, Thread wt) {
        this.setName(name);
        num = 1;
        waitThread = wt;
    }

    public String getRunnerName() {
        return this.getName();
    }

    public int getRunnerNumber() {
        return num;
    }

    @Override
    public void run() {
        // Join waitThread if it exists
        if (waitThread != null)
            try {
                waitThread.join();
            } catch (InterruptedException e) {
            }

        // Start race
        while (num < 1000) {
            try {
                this.sleep((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num++;
        }
    }
}
