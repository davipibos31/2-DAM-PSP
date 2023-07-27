public class Main {
    public static void main(String[] args) {
        Counter c = new Counter(100);
        Thread tinc = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                c.increment();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            System.out.println("Finishing inc. Final value= " + c.getValue());
        });
        Thread tdec = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                c.decrement();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            System.out.println("Finishing dec. Final value= " + c.getValue());
        });
        tinc.start();
        tdec.start();












        /*ThreadKiller thread = new ThreadKiller();
        thread.start();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       // thread.setCancelled(true);
        thread.interrupt();

        try {
            MyThread myThread = new MyThread();
            myThread.start();

            MyThread myThread2 = new MyThread(myThread);
            myThread2.start();

            MyThread myThread3 = new MyThread(myThread);
            myThread3.start();

            myThread2.join();
            System.out.println("Hello world!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
*/

    }
}