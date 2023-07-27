public class RunnerThread extends Thread {
    // Thread current number
    int num;
    // Flag to finish the thread
    boolean finished;

    public RunnerThread(String name) {
        this.setName(name);
        num = 1;
        finished = false;
    }

    // Getters and setters needed

    public String getRunnerName() {
        return this.getName();
    }

    public int getRunnerNumber() {
        return num;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public void run() {
        while (num < 1000 && !finished) {
            try {
                this.sleep((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num++;
        }
    }
}
