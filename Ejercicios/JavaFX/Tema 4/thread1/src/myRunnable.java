public class myRunnable implements Runnable {

    public myRunnable(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public void run() {
        for( int i = 0; i < 10; i++) {
            System.out.println(this.name + " " + i);
        }
    }
}
