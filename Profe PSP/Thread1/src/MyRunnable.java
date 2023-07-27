public class MyRunnable implements Runnable{
    private String name;
    private int num;

    public MyRunnable(String name) {
        this.name = name;
    }

    public int getValue(){
        return this.num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            num = i;
            System.out.println(this.name +" "+i);
        }
    }
}
