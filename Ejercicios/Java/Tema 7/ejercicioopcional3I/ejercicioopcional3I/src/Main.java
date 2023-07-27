public class Main {
    public static void main(String[] args) {
        Threads threaduno= new Threads();
        Threads threaddos= new Threads();
        Threads threadtres= new Threads();

        threaduno.setPriority(Thread.MAX_PRIORITY);
        threaddos.setPriority(Thread.NORM_PRIORITY);
        threadtres.setPriority(Thread.MIN_PRIORITY);
        threaduno.setName("hilo A");
        threaddos.setName("hilo B");
        threadtres.setName("hilo C");
        threaduno.start();
        threaddos.start();
        threadtres.start();

        do {
            try {
                //noinspection BusyWait
                Thread.sleep(100);
                //noinspection BusyWait
                Thread.sleep(100);
                //noinspection BusyWait
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(threaduno.getName() + ":" + threaduno.getCont() + " " + threaddos.getName() + ":" + threaddos.getCont() + " " + threadtres.getName() + ":" + threadtres.getCont());
        } while (threaduno.isAlive() && threaddos.isAlive() && threadtres.isAlive());
    }
}