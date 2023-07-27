public class ThreadKiller extends Thread {
    private boolean cancelled = false;

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public void run() {
        try {
            int num = 0;
            while (!cancelled && !Thread.currentThread().isInterrupted()) {
                System.out.println(num);
                Thread.sleep(1000);
                num++;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
