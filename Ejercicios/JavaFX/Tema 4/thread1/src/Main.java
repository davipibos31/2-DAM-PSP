public class Main {
    public static void main(String[] args) {
        myTread t = new myTread("Primero");
       t.start();

        myTread t1 = new myTread("Segundo");
        t1.start();
        myRunnable r = new myRunnable("Runnable");

        Thread threadRunnable = new Thread(r);
        threadRunnable.start();

        System.out.println("Hello world!");
      //  System.exit(1);
    }
}