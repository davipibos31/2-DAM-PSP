public class RunnerThread extends Thread {
    // Thread current number
    int num;

    public RunnerThread(String name) {
        this.setName(name);
        num = 1;
    }

    public String getRunnerName() {
        return this.getName();
    }

    public int getRunnerNumber() {
        return num;
    }

    @Override
    public void run() {
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
