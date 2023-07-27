public class Main {
    public static void main(String[] args) {
        ThreadKiller thread = new ThreadKiller();
        thread.start();

        Runnable runnabe = () -> {

        };

        Thread th = new Thread(runnabe);
        th.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello world!");
        thread.setCancelled(true);
        // thread.interrupt();


        try {
            MyThread myThread = new MyThread();
            myThread.start();
            myThread.join();
            MyThread myThread2 = new MyThread(myThread);
            myThread2.start();
            myThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Hello word!");


        Counter c = new Counter(100);
        Thread tinc = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                c.increment();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) { }
            }
            System.out.println("Finishing inc. Final value= " + c.getValue());
        });
        Thread tdec = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                c.decrement();
                try {Thread.sleep(100);
                } catch (InterruptedException ignored) { }
            }
            System.out.println("Finishing dec. Final value= " + c.getValue());
        });
        tinc.start();
        tdec.start();
    }
}