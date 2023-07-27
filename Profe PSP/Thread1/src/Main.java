import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            MyThread th = new MyThread("Name:"+i);
            //th.start();
            executor.execute(th);
        }









        MyThread th = new MyThread("Name:"+i);
        //th.start();
        executor.execute(th);




        executor.shutdown();
        System.out.println("finish...");
        Thread.sleep(1000*100);
    }

}